package com.app.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	 static SimpleDateFormat smt = new SimpleDateFormat("yyyy-MM-dd");
	 static SimpleDateFormat longsmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 
	/**
	 * 获取短日期 
	 * @param dt
	 * @return
	 */
	public static String Date2Str(Date dt){
		 return smt.format(dt);
		
	}
	
	
	/**
	 * 获取短日期 
	 * @param dt
	 * @return
	 */
	public static String LongDate2Str(Date dt){
		 return longsmt.format(dt);
		
	}
	
	public static Date Str2LongDate(String dt){
		 try {
			return longsmt.parse(dt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;
	}
	
	
	public static Date Time2LongDate(String dt){
		 try {
			 Calendar dte = Calendar.getInstance();
			 String tr=(dte.get(Calendar.YEAR))+"-"+(dte.get(Calendar.MONTH)+1)+"-"+dte.get(Calendar.DAY_OF_MONTH)+" "+dt;
			 System.out.println(tr);
			return longsmt.parse(tr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;
	}
	
	
	
	
}
