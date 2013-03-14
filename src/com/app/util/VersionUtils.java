package com.app.util;

public class VersionUtils {
	static String majorNumber="1";
	static String smallVersion="0";
	static String endVersion="14";
	
	
	public static String getAppVersion(){
		
		return majorNumber+"."+smallVersion+"."+endVersion;
	}
	
}
