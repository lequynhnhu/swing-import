package com.app.dataprovider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.hibernate.Query;

import com.app.main.MainFrame;
import com.app.util.DateUtil;
import com.app.util.IsChineseOrEnglish;
import com.hib.moudle.ImportStockDAO;

public class Txt {
	private static String head[]; // 表头
	private int colCount; // 列数
	private int rowCount; // 行数
	List content;
	Map colEntityMap;
	Logger logger  =  Logger.getLogger(Txt.class );
	static String gupiaoName; //股票name
	static String gupiaoCode; //股票代码
	String dataType;   //股票数据类型，分为日线与5分钟线
	static int contentStartRow=0;
	static String contentToken; //内容分隔符、
	static String headToken; //表头的分隔符
	public int getColCount() {
		return colCount;
	}

	public int getRowCount() {
		return rowCount;
	}

	/**
	 * 组装SQL语句(扩展导入数据库额外增加字段的情况)
	 * 
	 * @param startrow
	 *            开始行
	 * @param endrow
	 *            结束行
	 * @param startcol
	 *            开始列
	 * @param endcol
	 *            结束列
	 * @param tablename
	 *            表名称
	 * @return SQL语句数组
	 * 
	 */
	public boolean intelligenceMatchingPort(String tablename) {
		boolean isport = false;
		java.util.ArrayList<String> list = new java.util.ArrayList<String>();
		StringBuffer bf = new StringBuffer("INSERT INTO " + tablename + " (");
		for (int i = 0; head != null && i < head.length; i++) {
			if (i != head.length - 1)
				bf.append(head[i]).append(",");
			else
				bf.append(head[i]).append("");
		}
		bf.append(",导入日期,ID) VALUES (");
		for (int i = 0; head != null && i < head.length + 2; i++) {
			if (i != head.length + 1)
				bf.append("?").append(",");
			else
				bf.append("?").append(")");
		}

		ImportStockDAO imdao = new ImportStockDAO();
		imdao.getSession().beginTransaction();
		Query query = imdao.getSession().createSQLQuery(bf.toString());
		MainFrame mf =MainFrame.getInstance();
		for (int i = 0; i < content.size(); i++) {
			Map cell = (Map) content.get(i);
			if (cell == null)
				continue;
			int j = 0;
			
			System.out.println("表头大小："+head.length);
			
			if(head.length!=cell.size()){
				logger.debug("行号："+i+"表头："+head.length+"------------------>"+cell.size());
			}
			
			for (; j < head.length; j++) {
				if (cell.get(head[j]) == null) {
					query.setString(j, "无");
				} else {
					query.setString(j, cell.get(head[j]).toString());
				}
			}
			query.setString(head.length, DateUtil.Date2Str(new Date()));
			query.setString(head.length + 1, UUID.randomUUID().toString());
			MainFrame.getInstance().getSlider().setValue(i);
			try{
				query.executeUpdate();
				
			}catch(Exception e){
				mf.getTextPane().insert("导入数据库出现问题，请检查文件格式是否符合要求！！！",mf.getTextPane().getRows());
				isport = false;
				imdao.getSession().getTransaction().rollback();
				return isport;
			}
			
		}
		imdao.getSession().getTransaction().commit();
		isport = true;
		return isport;

	}

	public void init(File f) {
		String data = "";
		String[] s = null;
		int row = 0;
		boolean issuccess = false;
		MainFrame mf = MainFrame.getInstance();
		processTxtContent(f);
        byte[] filehead = new byte[3];  
        try {
        	InputStream inputStream = new FileInputStream(f);  
			inputStream.read(filehead);
	        String code = "";  
            code = "gb2312";  
        if (filehead[0] == -1 && filehead[1] == -2 )  
            code = "UTF-16";  
        if (filehead[0] == -2 && filehead[1] == -1 )  
            code = "Unicode";  
        if(filehead[0]==-17 && filehead[1]==-69 && filehead[2] ==-65)  
            code = "UTF-8";  
        logger.debug(f.getName()+"文件编码是:"+code);
        inputStream.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}   

		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(f)));
			content = new ArrayList();
			while ((data = br.readLine()) != null) {
				data = new String(data.getBytes("gb2312"),"GBK");
				data = data.trim();
				//logger.debug("第 "+row+" 行文件内容是:"+data);
				//s = data.split("\\s{1,}"); // 使用正则表达式以任意个空格作为分隔符分割字符串
//				String term = ",";
//				s = data.split(term);
//				System.out.println("按照"+term+"分隔符分割的数据" + s.length);
				if ("".equals(data)) {
					issuccess = true;
					System.out.println("该行是空行");
					continue;
				} 
				if(row>=contentStartRow)
				{
					colCount = head.length;
					colEntityMap = new HashMap();
					// 第一二列需要特殊处理
					boolean istitlesep = false;
					s=data.split(contentToken);
					for (int i = 0; i < s.length; i++) {
						// 如果第一列中间有分割符号的，则只能这样的判断，否则会造成导入错误
						if(i>=head.length){
							continue;
						}
						if (i == 0 && (head.length <= s.length)) {
							if (IsChineseOrEnglish.isContainChinese(s[1])
									|| IsChineseOrEnglish.isContainWord(s[1])) {
								colEntityMap.put(head[0], s[0] + s[1]);
								istitlesep = true;
							} else {
								colEntityMap.put(head[i], s[i]);
							}
						} else {
							if (istitlesep) {
								colEntityMap.put(head[i], s[i + 1]);
							} else {
								colEntityMap.put(head[i], s[i]);
							}
						}
						
					}
					if(!"".equals(gupiaoName)&&gupiaoName!=null){
						colEntityMap.put("名称", gupiaoName);
					}
					if(!"".equals(gupiaoCode)&&gupiaoName!=null){
						colEntityMap.put("代码", gupiaoCode);
					}
					content.add(colEntityMap);
				}
				row++;
			}
			rowCount = row;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error("读取文件发生错误："+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("读取文件发生错误："+e.getMessage());
			e.printStackTrace();
		}

	}
	
	
	/**
	 * 前三行测试
	 * @param f
	 */
	public static void processTxtContent(File f){
		try {
			String data="";
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(f)));
			int row = 0;
			int rowLength = 0;
			int row2Length = 0;
			int row3Length = 0 ;
			String row1 = "";
			String row2 = "";
			String row3 = "";
			while ((data = br.readLine()) != null&&row<3) {
				//第一行测试，可以测试出是否是含有表头的文件
				data = data.trim();
				String token = getStringToken(data);
				String	temphead[]=data.split(token);
				if(row==0){
					
					rowLength=temphead.length;
					if(rowLength==3||rowLength==4){
						contentStartRow  = 2;        //第一行就是内容起始行
					}
					row1 = data;
					
				}
				//第二行测试，可以得出是否是内容还是表头
				if(row==1){
					row2Length=temphead.length;
					row2=data.trim();
					System.out.println(row2);
					if(row2.startsWith("日期")){            //第三行就是内容了，那么第一行为头部
						contentStartRow  = 2;
						headToken = getStringToken(row2);
						row2 = row2.replaceAll("%%", "率");
						row2 = row2.replaceAll("\\(动\\)", "dong");
						row2 = row2.replaceAll("日期", "更新日期");
						if(headToken=="\\s{1,}"){
							row2 += "  名称";
							row2 += "  代码";
						}else{
							row2 += headToken+"名称";
							row2 += headToken+"代码";
						}
						
						System.out.println(row2);
						head= row2.split(headToken);
						String  headtemp[] = row1.split(getStringToken(row1));
						if(headtemp.length==4){
							gupiaoCode = headtemp[0];
							gupiaoName = headtemp[1]+headtemp[2];
						}else{
							gupiaoCode = headtemp[0];
							gupiaoName = headtemp[1];
						}
						
						
					}else{
						contentStartRow  = 1;
						headToken = getStringToken(row1);
						row1 = row1.replaceAll("%%", "率");
						row1 = row1.replaceAll("\\(动\\)", "dong");
						if(row1.startsWith("日期")){    
							row1 = row1.replaceAll("日期", "更新日期");
						}
						head= row1.split(headToken);
						contentToken = getStringToken(row2);
					}
				}
				//第三行测试，可以得到文件的分割样式
				if(row==2){
					data=data.trim();
					if(row3.startsWith("日期")){    
						data = data.replaceAll("日期", "更新日期");
					}
					row3=data;
					row3Length=temphead.length;
					contentToken = getStringToken(row3);
				}
				row++;
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 获取字符串的分隔符
	 * @param str
	 * @return
	 */
	public static String getStringToken(String str){
		if(testToken(str,",")){
			return ",";
		}
		if(testToken(str,";")){
			return ";";
		}
		if(testToken(str,"\t")){
			return "\t";
		}
		else if(testToken(str,"\\s{1,}")){
			return "\\s{1,}";
		}
		
		return null;
	}
	
	
	public static boolean testToken(String str , String term){
		String temp[] = str.split(term);
		if(temp.length>1){
			 return true;
		}
		return false;
	}
	

	public static void main(String a[]) {
		Txt txt = new Txt();
		txt.processTxtContent(new File("E:\\任务\\测试数据\\20120323.txt"));
		System.out.println(txt.contentStartRow);
		//SZ200168.TXT
		txt.processTxtContent(new File("c:\\export\\SZ200168.TXT"));
		System.out.println(txt.contentStartRow);
		//txt.intelligenceMatchingPort("Import_Stock");
	}

}
