package com.app.main;

import java.io.File;

import com.app.config.ConfigBean;
import com.app.config.XMLUtils;
import com.app.util.SwingWorker;

public class RunAction  {
	/**
	 * ×Ô¶¯Ö´ÐÐ
	 */
	public static void autoRun() {
		SwingWorker sw = new SwingWorker(){

			@Override
			public Object construct() {
				// TODO Auto-generated method stub
				XMLUtils xml = new XMLUtils();
				ConfigBean cfg = xml.getconfigXML();
				File f = new File(cfg.getFilepath());
				File fs[];
				if (f.exists() && f.isFile()) {
					fs = f.getParentFile().listFiles();
				} else {
					fs = f.listFiles();
				}
				if (fs != null) {
					for (File of : fs) {
						if(MainFrame.getInstance().getManual().isSelected()){
							break;
						}
						if (of.isFile()) {
							MainFrame.getInstance().getProcess().start(of);
						}
					}
				}
				return null;
			}
			
			
		};
		sw.start();
		
	}


}
