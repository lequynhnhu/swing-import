package com.app.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XMLUtils {
	
	
	File inputXml =new File(System.getProperty("user.dir")+"\\config\\config.xml");
	
	/**
	 * 从config文件中读取属性
	 * @return  configbean
	 */
	public ConfigBean getconfigXML(){
		SAXReader saxReader = new SAXReader();
		ConfigBean config = new ConfigBean();
		try {
			Document document = saxReader.read(inputXml);
			Node n=document.selectSingleNode("app");
			config.setRuntype(n.selectSingleNode("runtype").getText());
			config.setFilepath(n.selectSingleNode("filepath").getText());
			config.setDatetime(n.selectSingleNode("datetime").getText());
			config.setDelay(Long.parseLong(n.selectSingleNode("delay").getText()));
			config.setPeriod(Long.parseLong(n.selectSingleNode("period").getText()));
			config.setIsFirstRun(n.selectSingleNode("isfirstrun").getText());
			return config;
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return config;
	}
	
	/**
	 * 通过configbean来修改xml文件
	 * @param config
	 */
	public void modifyconfigXML(ConfigBean config){
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(inputXml);
			Node n=document.selectSingleNode("app");
			n.selectSingleNode("runtype").setText(config.getRuntype());
			n.selectSingleNode("filepath").setText(config.getFilepath());
			n.selectSingleNode("datetime").setText(config.getDatetime());
			if(!"".equals(config.getIsFirstRun())&&config.getIsFirstRun()!=null)
			n.selectSingleNode("isfirstrun").setText(config.getIsFirstRun());
			XMLWriter writer = new XMLWriter(new FileOutputStream(inputXml));   
	        writer.write(document);   
	        writer.close();   

			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
