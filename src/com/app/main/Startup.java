package com.app.main;

import javax.swing.SwingUtilities;

/**
 * 系统启动
 *
 */
public class Startup {
	public  static void main(String a[]){
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				MainFrame f = MainFrame.getInstance();
				System.out.println("程序已经运行了");
			}
		});
		
	}
	
	
}
