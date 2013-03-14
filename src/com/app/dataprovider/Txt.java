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
	private static String head[]; // ��ͷ
	private int colCount; // ����
	private int rowCount; // ����
	List content;
	Map colEntityMap;
	Logger logger  =  Logger.getLogger(Txt.class );
	static String gupiaoName; //��Ʊname
	static String gupiaoCode; //��Ʊ����
	String dataType;   //��Ʊ�������ͣ���Ϊ������5������
	static int contentStartRow=0;
	static String contentToken; //���ݷָ�����
	static String headToken; //��ͷ�ķָ���
	public int getColCount() {
		return colCount;
	}

	public int getRowCount() {
		return rowCount;
	}

	/**
	 * ��װSQL���(��չ�������ݿ���������ֶε����)
	 * 
	 * @param startrow
	 *            ��ʼ��
	 * @param endrow
	 *            ������
	 * @param startcol
	 *            ��ʼ��
	 * @param endcol
	 *            ������
	 * @param tablename
	 *            ������
	 * @return SQL�������
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
		bf.append(",��������,ID) VALUES (");
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
			
			System.out.println("��ͷ��С��"+head.length);
			
			if(head.length!=cell.size()){
				logger.debug("�кţ�"+i+"��ͷ��"+head.length+"------------------>"+cell.size());
			}
			
			for (; j < head.length; j++) {
				if (cell.get(head[j]) == null) {
					query.setString(j, "��");
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
				mf.getTextPane().insert("�������ݿ�������⣬�����ļ���ʽ�Ƿ����Ҫ�󣡣���",mf.getTextPane().getRows());
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
        logger.debug(f.getName()+"�ļ�������:"+code);
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
				//logger.debug("�� "+row+" ���ļ�������:"+data);
				//s = data.split("\\s{1,}"); // ʹ��������ʽ��������ո���Ϊ�ָ����ָ��ַ���
//				String term = ",";
//				s = data.split(term);
//				System.out.println("����"+term+"�ָ����ָ������" + s.length);
				if ("".equals(data)) {
					issuccess = true;
					System.out.println("�����ǿ���");
					continue;
				} 
				if(row>=contentStartRow)
				{
					colCount = head.length;
					colEntityMap = new HashMap();
					// ��һ������Ҫ���⴦��
					boolean istitlesep = false;
					s=data.split(contentToken);
					for (int i = 0; i < s.length; i++) {
						// �����һ���м��зָ���ŵģ���ֻ���������жϣ��������ɵ������
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
						colEntityMap.put("����", gupiaoName);
					}
					if(!"".equals(gupiaoCode)&&gupiaoName!=null){
						colEntityMap.put("����", gupiaoCode);
					}
					content.add(colEntityMap);
				}
				row++;
			}
			rowCount = row;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error("��ȡ�ļ���������"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("��ȡ�ļ���������"+e.getMessage());
			e.printStackTrace();
		}

	}
	
	
	/**
	 * ǰ���в���
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
				//��һ�в��ԣ����Բ��Գ��Ƿ��Ǻ��б�ͷ���ļ�
				data = data.trim();
				String token = getStringToken(data);
				String	temphead[]=data.split(token);
				if(row==0){
					
					rowLength=temphead.length;
					if(rowLength==3||rowLength==4){
						contentStartRow  = 2;        //��һ�о���������ʼ��
					}
					row1 = data;
					
				}
				//�ڶ��в��ԣ����Եó��Ƿ������ݻ��Ǳ�ͷ
				if(row==1){
					row2Length=temphead.length;
					row2=data.trim();
					System.out.println(row2);
					if(row2.startsWith("����")){            //�����о��������ˣ���ô��һ��Ϊͷ��
						contentStartRow  = 2;
						headToken = getStringToken(row2);
						row2 = row2.replaceAll("%%", "��");
						row2 = row2.replaceAll("\\(��\\)", "dong");
						row2 = row2.replaceAll("����", "��������");
						if(headToken=="\\s{1,}"){
							row2 += "  ����";
							row2 += "  ����";
						}else{
							row2 += headToken+"����";
							row2 += headToken+"����";
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
						row1 = row1.replaceAll("%%", "��");
						row1 = row1.replaceAll("\\(��\\)", "dong");
						if(row1.startsWith("����")){    
							row1 = row1.replaceAll("����", "��������");
						}
						head= row1.split(headToken);
						contentToken = getStringToken(row2);
					}
				}
				//�����в��ԣ����Եõ��ļ��ķָ���ʽ
				if(row==2){
					data=data.trim();
					if(row3.startsWith("����")){    
						data = data.replaceAll("����", "��������");
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
	 * ��ȡ�ַ����ķָ���
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
		txt.processTxtContent(new File("E:\\����\\��������\\20120323.txt"));
		System.out.println(txt.contentStartRow);
		//SZ200168.TXT
		txt.processTxtContent(new File("c:\\export\\SZ200168.TXT"));
		System.out.println(txt.contentStartRow);
		//txt.intelligenceMatchingPort("Import_Stock");
	}

}
