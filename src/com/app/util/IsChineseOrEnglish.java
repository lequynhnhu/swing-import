package com.app.util;

import java.util.Random;

public class IsChineseOrEnglish {

	// GENERAL_PUNCTUATION �ж����ĵġ���

	// CJK_SYMBOLS_AND_PUNCTUATION �ж����ĵġ���

	// HALFWIDTH_AND_FULLWIDTH_FORMS �ж����ĵģ���

	public static boolean isChinese(char c) {

		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);

		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS

		|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS

		|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A

		|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION

		|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION

		|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {

			return true;

		}

		return false;

	}
	
	
	

	public static boolean isContainWord(String strName) {
		char[] ch = strName.toCharArray();
		boolean isword=false;
		for(int i=0;i<ch.length;i++){
			char c = ch[i];
			if (((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
				isword =  true;
			} 
		}
		return isword;
		
	}

	public static boolean isContainChinese(String strName) {

		char[] ch = strName.toCharArray();
		boolean isCh = false;
		for (int i = 0; i < ch.length; i++) {

			char c = ch[i];

			if (isChinese(c) == true) {

				System.out.println(isChinese(c));

				isCh = true;

			}
		}
		return isCh;

	}

	public static void main(String[] args) {

		Random r = new Random();

		for (int i = 0; i < 20; i++)

			System.out.println(r.nextInt(10) + 1);

		// isChinese("��");

		isContainChinese("�й�");

	}

}
