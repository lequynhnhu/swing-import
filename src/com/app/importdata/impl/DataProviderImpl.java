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
 * ����ʵ����
 *
 */

public class DataProviderImpl implements IdataProvider {
	MainFrame mf =MainFrame.getInstance();
	boolean issuccess=false;
	Logger logger  =  Logger.getLogger(DataProviderImpl.class );
	/**
	 * ʵ������excel�ĵ���
	 */
	@Override
	public  void readExcel(final File f) {
				Excel excel;
				try {
					excel = new Excel(f.getAbsolutePath(),null,null);
					Workbook workbook = excel.getWorkbook();
					Sheet sheet = workbook.getSheet(0);  	// ��õ�һ�����������
					int a = excel.getRows(sheet);      //�������
					int m=excel.getColumns(sheet);  //�������
					Cell[][] c = excel.getCells(sheet,0,a,0,m);
					String f1 = null,f3=null;
					ImportStockDAO imdao =new ImportStockDAO();
					imdao.getSession().beginTransaction();
					mf.getSlider().setValue(0);
					mf.getSlider().setMaximum(a);
					mf.getSlider().setMinimum(0);
					mf.getInfo().setText("<html><font color=red>����"+(a-1)+"������</font><br><font color=blue>  ��"+m+"��</font></html>");
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
	 * ���ݴ������Ĵ���������md5д�����ݿ�
	 * @param f
	 */
	public void finished(File f){
		mf.getStartbt().setEnabled(true);
		try {
			
			if(issuccess){
				mf.getTextPane().insert("�Ѿ�����ļ���"+f.getAbsolutePath()+" �ĵ���\n",mf.getTextPane().getRows());
				mf.getSlider().setValue(mf.getSlider().getMaximum());
				if(mf.getManual().isSelected()){
					JCMessageBox jb =JCMessageBox.createInformationMessageBox(mf.getFrame(),"ϵͳ��ʾ","�Ѿ�����ļ������ݵ���");
					jb.open();
				}
				addmd5todb(MD5Util.getFileMD5String(f),f.getName());
			}else{
				mf.getSlider().setValue(0);
				mf.getTextPane().insert("��������δ����ļ���"+f.getAbsolutePath()+" ��ȫ�����룬�����ļ����ڹ���Ŀ���\n",mf.getTextPane().getRows());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JCMessageBox jb =JCMessageBox.createInformationMessageBox(mf.getFrame(),"ϵͳ��ʾ",e.getMessage());
			jb.open();
			logger.error("��ȡ�ļ���������"+e.getMessage());
			e.printStackTrace();
		}
	}

	
	/**
	 * ʵ��txt�ĵ���
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
						mf.getInfo().setText("<html><font color=red>����"+(row-1)+"������</font><br><font color=blue>  ��"+col+"��</font></html>");
					}
					else{
						mf.getTextPane().insert("��֧�ֵ��ļ���"+f.getName()+"\n",mf.getTextPane().getRows());
					}
			
				  DataProviderImpl.this.finished(f);
				}
				catch(Exception e){
					mf.getStartbt().setEnabled(true);
				}
	
		
	}
	
	//���ݵ�����ڣ�������ֱ���ж��Ƿ�txt����xls�ļ���ͨ��ͬ���ķ�ʽ���Լ�mf.getFileMap()�ж��Ƿ����ڵ��룬�Ӷ���ֻ֤��һ�������ڴ���
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
		
		//�ж��ļ��Ƿ������ݿ��У�����������ʾ�Ѿ�����
		if(!isFileport_checkMd5(file)){
			//��������ĵ�������û�иĶ���Ϊ��
			if("".equals(mf.getDateFiled().getText())){
				mf.getDateFiled().setText(DateUtil.Date2Str(new Date()));
			}
			if (file.getAbsolutePath().toLowerCase().endsWith(".txt")) {
				readTxt(file);
			} else if (file.getAbsolutePath().toLowerCase().endsWith(".xls")) {
				readExcel(file);
			}
			else{
				 mf.getTextPane().insert("��֧�ֵ��ļ���ʽ��"+file.getAbsolutePath(),mf.getTextPane().getRows());
				 mf.getStartbt().setEnabled(true);
			}
		}else{
			
				if(mf.getManual().isSelected()){
					JCMessageBox jb =JCMessageBox.createInformationMessageBox(mf.getFrame(),"ϵͳ��ʾ","���ļ��Ѿ�����������ڵ������ݣ�����Ҫ�ظ����룡��");
					jb.open();
				}
			
				mf.getInfo().setText("<html><font color=red>�ļ�"+file.getAbsolutePath()+"�Ѿ��������ڵ������ݿ�<br>����Ҫ�ظ�����</font></html>");
				mf.getTextPane().insert("�ļ�"+file.getAbsolutePath()+"�Ѿ��������ݿ⣬����Ҫ�ظ�����\n",mf.getTextPane().getRows());
				mf.getStartbt().setEnabled(true);
		}
		
	}
	

	
	/**
	 * ���ļ���md5д������
	 * @param md5
	 * @param filename
	 */
	public void addmd5todb(String md5,String filename){
		//������Ϻ��ٴӻ����г�ȥ
		mf.getFileMap().remove(md5);
		Filemd5DAO md5dao = new Filemd5DAO(); 
		Filemd5 md5bean = new Filemd5();
		md5bean.setFilename(filename);
		md5bean.setMd5(md5);
		md5bean.setId(UUID.randomUUID().toString());
		md5dao.save(md5bean);

	}
	
	
	/**
	 * �ж��ļ��Ƿ��Ѿ�����
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
			logger.error("��ȡ�ļ���������"+e.getMessage());
			e.printStackTrace();
		}
		return isexist;
		
	}
	
	/**
	 * �ж��Ƿ����ڵ���
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
