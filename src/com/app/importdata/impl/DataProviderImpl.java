package com.app.importdata.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.UUID;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.log4j.Logger;

import com.app.dataprovider.Excel;
import com.app.dataprovider.Txt;
import com.app.importdata.IdataProvider;
import com.app.main.MainFrame;
import com.app.util.DateUtil;
import com.app.util.MD5Util;
import com.app.util.SwingWorker;
import com.hib.moudle.Filemd5;
import com.hib.moudle.Filemd5DAO;
import com.hib.moudle.ImportStockDAO;

import craky.componentc.JCMessageBox;
/**
 * 数据实现类
 *
 */

public class DataProviderImpl implements IdataProvider {
	MainFrame mf =MainFrame.getInstance();
	boolean issuccess=false;
	Logger logger  =  Logger.getLogger(DataProviderImpl.class );
	/**
	 * 实现数据excel的导入
	 */
	@Override
	public  void readExcel(final File f) {
				Excel excel;
				try {
					excel = new Excel(f.getAbsolutePath(),null,null);
					Workbook workbook = excel.getWorkbook();
					Sheet sheet = workbook.getSheet(0);  	// 获得第一个工作表对象
					int a = excel.getRows(sheet);      //最大行数
					int m=excel.getColumns(sheet);  //最大列数
					Cell[][] c = excel.getCells(sheet,0,a,0,m);
					String f1 = null,f3=null;
					ImportStockDAO imdao =new ImportStockDAO();
					imdao.getSession().beginTransaction();
					mf.getSlider().setValue(0);
					mf.getSlider().setMaximum(a);
					mf.getSlider().setMinimum(0);
					mf.getInfo().setText("<html><font color=red>共有"+(a-1)+"条数据</font><br><font color=blue>  和"+m+"列</font></html>");
					issuccess=excel.intelligenceMatchingPort(sheet, 1, a, 0, m,"Import_Stock");
					workbook.close();
				} catch (BiffException e) {
					issuccess=false;
					mf.getStartbt().setEnabled(true);
					e.printStackTrace();
				} catch (IOException e) {
					issuccess=false;
					mf.getStartbt().setEnabled(true);
					e.printStackTrace();
				} 
				DataProviderImpl.this.finished(f);
	}
	
	/**
	 * 数据处理完后的处理方法，将md5写入数据库
	 * @param f
	 */
	public void finished(File f){
		mf.getStartbt().setEnabled(true);
		try {
			
			if(issuccess){
				mf.getTextPane().insert("已经完成文件："+f.getAbsolutePath()+" 的导入\n",mf.getTextPane().getRows());
				mf.getSlider().setValue(mf.getSlider().getMaximum());
				if(mf.getManual().isSelected()){
					JCMessageBox jb =JCMessageBox.createInformationMessageBox(mf.getFrame(),"系统提示","已经完成文件的数据导入");
					jb.open();
				}
				addmd5todb(MD5Util.getFileMD5String(f),f.getName());
			}else{
				mf.getSlider().setValue(0);
				mf.getTextPane().insert("发生错误，未完成文件："+f.getAbsolutePath()+" 的全部导入，可能文件存在过多的空行\n",mf.getTextPane().getRows());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JCMessageBox jb =JCMessageBox.createInformationMessageBox(mf.getFrame(),"系统提示",e.getMessage());
			jb.open();
			logger.error("读取文件发生错误："+e.getMessage());
			e.printStackTrace();
		}
	}

	
	/**
	 * 实现txt的导入
	 */
	@Override
	public  void readTxt(final File f) {
				try{
					
			
					Txt txt = new Txt();
					txt.init(f);
					int row=txt.getRowCount();
					int col = txt.getColCount();
					mf.getSlider().setValue(0);
					mf.getSlider().setMaximum(txt.getRowCount());
					mf.getSlider().setMinimum(0);
				
					issuccess = txt.intelligenceMatchingPort( "Import_Stock");
				
					if(issuccess){
						mf.getSlider().setValue(0);
						mf.getSlider().setMaximum(row);
						mf.getSlider().setMinimum(0);
						mf.getInfo().setText("<html><font color=red>共有"+(row-1)+"条数据</font><br><font color=blue>  和"+col+"列</font></html>");
					}
					else{
						mf.getTextPane().insert("不支持的文件："+f.getName()+"\n",mf.getTextPane().getRows());
					}
			
				  DataProviderImpl.this.finished(f);
				}
				catch(Exception e){
					mf.getStartbt().setEnabled(true);
				}
	
		
	}
	
	//数据导入入口，在这里直接判断是否txt或者xls文件，通过同步的方式，以及mf.getFileMap()判断是否正在导入，从而保证只有一个对象在处理
	public  void start(File file){
		String filemd5;
		try {
			filemd5 = MD5Util.getFileMD5String(file);
			mf.getFileMap().put(filemd5, file);
			mf.getStartbt().setEnabled(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//判断文件是否导入数据库中，导入了则提示已经导入
		if(!isFileport_checkMd5(file)){
			//如果输入框的导入日期没有改动，为空
			if("".equals(mf.getDateFiled().getText())){
				mf.getDateFiled().setText(DateUtil.Date2Str(new Date()));
			}
			if (file.getAbsolutePath().toLowerCase().endsWith(".txt")) {
				readTxt(file);
			} else if (file.getAbsolutePath().toLowerCase().endsWith(".xls")) {
				readExcel(file);
			}
			else{
				 mf.getTextPane().insert("不支持的文件格式："+file.getAbsolutePath(),mf.getTextPane().getRows());
				 mf.getStartbt().setEnabled(true);
			}
		}else{
			
				if(mf.getManual().isSelected()){
					JCMessageBox jb =JCMessageBox.createInformationMessageBox(mf.getFrame(),"系统提示","该文件已经导入或者正在导入数据，不需要重复导入！！");
					jb.open();
				}
			
				mf.getInfo().setText("<html><font color=red>文件"+file.getAbsolutePath()+"已经或者正在导入数据库<br>不需要重复导入</font></html>");
				mf.getTextPane().insert("文件"+file.getAbsolutePath()+"已经导入数据库，不需要重复导入\n",mf.getTextPane().getRows());
				mf.getStartbt().setEnabled(true);
		}
		
	}
	

	
	/**
	 * 将文件的md5写入数据
	 * @param md5
	 * @param filename
	 */
	public void addmd5todb(String md5,String filename){
		//处理完毕后再从缓存中除去
		mf.getFileMap().remove(md5);
		Filemd5DAO md5dao = new Filemd5DAO(); 
		Filemd5 md5bean = new Filemd5();
		md5bean.setFilename(filename);
		md5bean.setMd5(md5);
		md5bean.setId(UUID.randomUUID().toString());
		md5dao.save(md5bean);

	}
	
	
	/**
	 * 判断文件是否已经导入
	 * @param f
	 * @return 
	 */
	public boolean  isFileport_checkMd5(File f){
		boolean isexist = false;
		try {
			String filemd5 = MD5Util.getFileMD5String(f);
			mf.getFileMap().put(filemd5, f);
			Filemd5DAO md5dao = new Filemd5DAO();
			isexist=md5dao.ismd5exist(filemd5);
			if(isexist){
				return true;
			}else{
				if(isporting(filemd5)){
					return false;
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			mf.getTextPane().insert(e.getMessage(), mf.getTextPane().getRows());
			logger.error("读取文件发生错误："+e.getMessage());
			e.printStackTrace();
		}
		return isexist;
		
	}
	
	/**
	 * 判断是否正在导入
	 * @param md5
	 * @return
	 */
	public boolean isporting(String md5){
		if( mf.getFileMap().get(md5)==null){
			return false;
		}else{
			return true;
		}
	}
	
	
	
}
