package test;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import com.app.dataprovider.Excel;

public class testexcel {
	// E:\任务\测试数据\20120220.XLS
	public static void main(String a[]) throws MalformedURLException {
		String strTest = "668947   18  109451074 0                0        33       700198   2335821 " ;
	    String resSplit[] = strTest.split("\\s{1,}")  ;
	    for(int j =0 ;j< resSplit.length;j++){
	     System.out.println(resSplit[j]);
	    }
	}
	
	/**
	 * 读取excel
	 * @return
	 */
	public static List importTableTemplate(String path){
		ArrayList list=new ArrayList();
		try {
			Excel excel = new Excel(path,null,null);
			Workbook workbook = excel.getWorkbook();
			Sheet sheet = workbook.getSheet(0);
			int a = excel.getRows(sheet);      //最大行数
			int m=excel.getColumns(sheet);  //最大列数
			Cell[][] c = excel.getCells(sheet,0,a,0,m);
			String f1 = null,f3=null;
			for(int i =0 ; i < c.length;i++){
				Cell[] obj = c[i];
				for(int j =0 ;j< obj.length; j++ ){
					 f1=obj[j].getContents().toString();
					 System.out.println(f1);
					 list.add(f1);
				}
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	

}
