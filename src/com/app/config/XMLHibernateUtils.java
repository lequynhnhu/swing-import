package com.app.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.xml.sax.SAXException;

public class XMLHibernateUtils {
	
	
	File inputXml =new File(System.getProperty("user.dir")+"\\config\\hibernate.cfg.xml");
	
	/**
	 * 从config文件中读取属性
	 * @return  configbean
	 */
	public HidernateConfigBean getconfigXML(){
		SAXReader saxReader = new SAXReader();
		
		HidernateConfigBean config = new HidernateConfigBean();
		try {
			saxReader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
			Document document = saxReader.read(inputXml);
			List<Node> n=document.selectNodes("//hibernate-configuration//session-factory//property");
			for(Node node :n){
				Element el = (Element)node;
				if("connection.username".equals(el.attribute(0).getText())){
					config.setUsername(node.getText());
					
				}
				if("connection.password".equals(el.attribute(0).getText())){
					config.setPassword(node.getText());
					
				}
				if("connection.url".equals(el.attribute(0).getText())){
					config.setDburl(node.getText());
				}
			}
			return config;
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return config;
	}
	
	/**
	 * 通过configbean来修改xml文件
	 * @param config
	 */
	public void modifyconfigXML(HidernateConfigBean config){
		SAXReader saxReader = new SAXReader();
		try {
			saxReader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
			Document document = saxReader.read(inputXml);
			List<Node> n=document.selectNodes("//hibernate-configuration//session-factory//property");
			for(Node node :n){
				Element el = (Element)node;
				if("connection.username".equals(el.attribute(0).getText())){
					if(!"".equals(config.getUsername())&&config.getUsername()!=null)
					node.setText(config.getUsername());
					
				}
				if("connection.password".equals(el.attribute(0).getText())){
					if(!"".equals(config.getPassword())&&config.getPassword()!=null)
					node.setText(config.getPassword());
					
				}
				if("connection.url".equals(el.attribute(0).getText())){
					if(!"".equals(config.getDburl())&&config.getDburl()!=null)
					node.setText(config.getDburl());
				}
			}
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
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String a[]){
		XMLHibernateUtils   xml = new XMLHibernateUtils();
		HidernateConfigBean  config = xml.getconfigXML();
		System.out.println(config.getUsername());
		System.out.println(config.getDburl());
		config.setUsername("root");
		config.setPassword("root");
		xml.modifyconfigXML(config);
		
		
	}
	
	
}
