package com.app.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.app.config.ConfigBean;
import com.app.config.HidernateConfigBean;
import com.app.config.XMLHibernateUtils;
import com.app.config.XMLUtils;
import com.app.dataprovider.Excel;
import com.hib.impl.HibernateSessionFactory;

import craky.component.JImagePane;
import craky.componentc.JCButton;
import craky.componentc.JCDialog;
import craky.componentc.JCLabel;
import craky.componentc.JCMessageBox;
import craky.componentc.JCTextField;
import craky.layout.LineLayout;
import craky.util.UIUtil;

public class ConfigDialog extends JCDialog implements ActionListener {
	private static final long serialVersionUID = 4787072148793183017L;
	private JComponent content;
	private JCButton btnOk;
	private JCButton btnCancel;
	private JCTextField txtNew;
	private JCTextField txtCheck;
	private JCTextField txtUrl;
	private String userName;
	private JCButton btnTest;
	private JCButton createDataBase;
	XMLHibernateUtils xml = new XMLHibernateUtils();
	XMLUtils xmlutils;
	ConfigBean cbean;
	int x, y = 0;
	Logger logger  =  Logger.getLogger(ConfigDialog.class );
	public ConfigDialog(Window owner, XMLUtils xmlutils, ConfigBean config) {
		super(owner, "�޸������ļ�", Dialog.ModalityType.DOCUMENT_MODAL);
		this.xmlutils = xmlutils;
		cbean = config;
		initUI();
		setVisible(true);
	}

	private void initUI() {
		this.content = ((JComponent) getContentPane());
		JImagePane mainPane = new JImagePane();
		EmptyComponent ecOldPsd = new EmptyComponent();
		EmptyComponent ecNewPsd = new EmptyComponent();
		EmptyComponent ecCheckPsd = new EmptyComponent();
		EmptyComponent ecPurview = new EmptyComponent();
		JImagePane buttonPane = new JImagePane();
		JCLabel lbAddAdmin = new JCLabel("�״�ʹ�ã������޸����ݿ����ã�������������ݿ�");
		JCLabel lbNew = new JCLabel();
		lbNew.setText("\u6570\u636E\u5E93\u7528\u6237\uFF1A");
		JCLabel lbCheck = new JCLabel("����ȷ��");
		lbCheck.setText("\u6570\u636E\u5E93\u5BC6\u7801\uFF1A");
		JCLabel lburl = new JCLabel("���ݿ����ӣ�");
		this.txtNew = new JCTextField();
		this.txtCheck = new JCTextField();
		this.btnOk = new JCButton("ȷ��");
		this.btnCancel = new JCButton("ȡ��");
		btnTest = new JCButton("����");
		txtUrl = new JCTextField();
		createDataBase  = new JCButton("�������ݿ�");

		this.content.setBorder(new EmptyBorder(0, 2, 2, 2));
		this.content.setPreferredSize(new Dimension(310, 205));
		this.content.setLayout(new BorderLayout());
		mainPane.setLayout(new LineLayout(8, 15, 15, 15, 0, 10, 10, 1));
		mainPane.setBackground(new Color(255, 255, 255, 210));
		ecOldPsd.setLayout(new BorderLayout());
		ecNewPsd.setLayout(new BorderLayout());
		ecCheckPsd.setLayout(new BorderLayout());
		ecPurview.setLayout(new BorderLayout());

		lbAddAdmin.setForeground(new Color(255, 40, 110));

		buttonPane.setLayout(new LineLayout(5, 7, 7, 7, 0, 10, 10, 0));

		buttonPane.setBackground(new Color(255, 255, 255, 150));
		buttonPane.setPreferredSize(new Dimension(-1, 32));
		this.btnOk.setPreferredSize(new Dimension(69, 21));
		this.btnOk.addActionListener(this);
		this.btnCancel.setPreferredSize(this.btnOk.getPreferredSize());
		this.btnCancel.addActionListener(this);
		btnTest.setPreferredSize(this.btnOk.getPreferredSize());
		btnTest.addActionListener(this);
		createDataBase.setPreferredSize(this.btnOk.getPreferredSize());
		createDataBase.addActionListener(this);
		

		ecNewPsd.add(lbNew, "West");
		ecNewPsd.add(this.txtNew, "Center");
		ecCheckPsd.add(lbCheck, "West");
		ecCheckPsd.add(this.txtCheck, "Center");
		ecPurview.add(lburl, "West");
		ecPurview.add(txtUrl, "Center");

		buttonPane.add(this.btnOk, "End");
		buttonPane.add(this.btnCancel, "End");
		buttonPane.add(this.btnTest, "End");
		buttonPane.add(this.createDataBase,"End");
		
		
		
		
		mainPane.add(lbAddAdmin, "StartFill");
		mainPane.add(ecOldPsd, "StartFill");
		mainPane.add(ecNewPsd, "StartFill");
		mainPane.add(ecCheckPsd, "StartFill");
		mainPane.add(ecPurview, "StartFill");
		this.content.add(buttonPane, "South");
		this.content.add(mainPane, "Center");
		setDefaultCloseOperation(0);
		setResizable(false);
		setLocationRelativeTo(getOwner());
		UIUtil.escAndEnterAction(this, this.btnOk, new AbstractAction() {
			private static final long serialVersionUID = 7092223290373790975L;

			public void actionPerformed(ActionEvent e) {
				ConfigDialog.this.cancel();
			}
		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				ConfigDialog.this.cancel();
			}
		});

		this.pack();
		MidScr(this);
		initData();
	}

	/**
	 * ��ʼ������
	 */
	private void initData() {
		HidernateConfigBean config = xml.getconfigXML();
		this.txtNew.setText(config.getUsername());
		this.txtCheck.setText(config.getPassword());
		this.txtUrl.setText(config.getDburl());
		if("true".equals(cbean.getIsFirstRun())){
			createDataBase.setVisible(true);
		}else{
			createDataBase.setVisible(false);
		}
		
	}

	private void testConnect() {
	
		
		try {
			String username = this.txtNew.getText();
			String password = this.txtCheck.getText();
			String url = this.txtUrl.getText();
			HidernateConfigBean config = new HidernateConfigBean();
			config.setUsername(username);
			config.setPassword(password);
			config.setDburl(url);
			xml.modifyconfigXML(config);
			cbean.setIsFirstRun("false");
			xmlutils.modifyconfigXML(cbean);
			HibernateSessionFactory.reConnect();
			Session session = HibernateSessionFactory.getSession();
			session.beginTransaction();
			if (!session.isOpen()||session==null) {
				JCMessageBox.createInformationMessageBox(this, getTitle(),
						"���ݿ��޷����ӣ���鿴�����Ƿ���ȷ").open();
			} else {
				JCMessageBox.createInformationMessageBox(this, getTitle(),
						"���ݿ���������").open();
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			logger.error("�������Ӵ���:",e);
			JCMessageBox.createInformationMessageBox(this, getTitle(),
					"���ݿ��޷����ӣ���鿴�����Ƿ���ȷ!!!").open();
		}

	}

	/**
	 * �ύ����
	 */
	private void submit() {
		saveConfig();
		JCMessageBox
				.createInformationMessageBox(this, getTitle(), "���������ļ��޸����")
				.open();
		dispose();

	}
	
	
	private void saveConfig(){
		String username = this.txtNew.getText();
		String password = this.txtCheck.getText();
		String url = this.txtUrl.getText();
		HidernateConfigBean config = new HidernateConfigBean();
		config.setUsername(username);
		config.setPassword(password);
		config.setDburl(url);
		xml.modifyconfigXML(config);
		cbean.setIsFirstRun("false");
		xmlutils.modifyconfigXML(cbean);
	}
	

	private void cancel() {
		dispose();
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source == this.btnOk) {
			submit();
		} else if (source == this.btnCancel) {
			cancel();
		} else if (source == this.btnTest) {
			testConnect();
		}else if(source == this.createDataBase){
			createDataBase();
		}
	}
	
	
	
	//�Զ��������ݿ�
	private void createDataBase(){
		
		try {
			String dbName ="gopiao";
			this.txtUrl.setText(this.txtUrl.getText().replace(dbName, ""));			
			String username = this.txtNew.getText();
			String password = this.txtCheck.getText();
			String url = this.txtUrl.getText();
			HidernateConfigBean config = new HidernateConfigBean();
			config.setUsername(username);
			config.setPassword(password);
			config.setDburl(url);
			xml.modifyconfigXML(config);
			cbean.setIsFirstRun("false");
			xmlutils.modifyconfigXML(cbean);
			HibernateSessionFactory.reConnect();
			Session session = HibernateSessionFactory.getSession();
			session.beginTransaction();
			if (!session.isOpen()||session==null) {
				JCMessageBox.createInformationMessageBox(this, getTitle(),
						"���ݿ��޷����ӣ���鿴�����Ƿ���ȷ��������ʼ�����ݿ⣬��ȥ��jdbc:mysql://localhost:3306/xxxx  ������ַ���xxxx").open();
			} else {
				 
				 Query query = session.createSQLQuery("CREATE DATABASE IF NOT EXISTS gopiao");
				 query.executeUpdate();
				 
				 Query querydrop1 = session.createSQLQuery("DROP TABLE IF EXISTS gopiao.filemd5");
				 querydrop1.executeUpdate();
				 
				 Query querydrop2 = session.createSQLQuery("DROP TABLE IF EXISTS gopiao.import_stock");
				 querydrop2.executeUpdate();
				 
				 
				 
				 String droptable1="CREATE TABLE gopiao.filemd5 (`ID` varchar(36) NOT NULL, `filename` varchar(100) default NULL,`md5` varchar(100) default NULL,PRIMARY KEY  (`ID`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;";
				 
				 Query query1 = session.createSQLQuery(droptable1);
				 query1.executeUpdate();
				 
				 String droptable2="CREATE TABLE gopiao.import_stock (" +
				 		"`ID` varchar(36) NOT NULL," +
				 		"`��������` varchar(19) NOT NULL," +
				 		"`����` varchar(30) default NULL," +
				 		"`AB������ֵ` varchar(15) default NULL," +
				 		"`B�ɻ�A` varchar(10) default NULL," +
				 		"`H��` varchar(15) default NULL," +
				 		"`��������` varchar(10) default NULL," +
				 		"`��Ӫ����` varchar(15) default NULL," +
				 		"`��Ӫ����` varchar(15) default NULL," +
				 		"`���һ` varchar(8) default NULL," +
				 		"`�����` varchar(8) default NULL," +
				 		"`��۶�` varchar(8) default NULL,`�����` varchar(8) default NULL,`����һ` varchar(10) default NULL," +
				 		"`������` varchar(10) default NULL,`������` varchar(10) default NULL,`��` varchar(8) default NULL," +
				 		" `����` varchar(10) default NULL,`������` varchar(15) default NULL," +
				 		"`�����` varchar(8) default NULL,`����` varchar(15) default NULL," +
				 		"`������` varchar(15) default NULL," +
				 		"`������` varchar(10) default NULL,`���ʲ�` varchar(15) default NULL," +
				 		"`����ͬ��` varchar(15) default NULL,`�����ܶ�` varchar(15) default NULL," +
				 		"`����һ` varchar(8) default NULL,`������` varchar(8) default NULL,`���۶�` varchar(8) default NULL,`������` varchar(8) default NULL," +
				 		"`����һ` varchar(10) default NULL,`������` varchar(10) default NULL, `������` varchar(10) default NULL," +
				 		" `�̶��ʲ�` varchar(15) default NULL,  `���ҹ�` varchar(15) default NULL," +
				 		"  `����` varchar(8) default NULL,  `����` varchar(15) default NULL,  `��ͷֹ��` varchar(8) default NULL," +
				 		"  `��ͷ����` varchar(8) default NULL,  `���ƽ��` varchar(8) default NULL,  `ί����` varchar(8) default NULL," +
				 		"  `ί����` varchar(10) default NULL,  `���` varchar(15) default NULL,  `�о���` varchar(8) default NULL," +
				 		"  `��ӯdong` varchar(15) default NULL,  `ǿ������` varchar(8) default NULL,  `���ֽ���` varchar(15) default NULL," +
				 		"  `�ܹɱ�wan` varchar(15) default NULL,  `���ʲ�wan` varchar(15) default NULL," +
				 		"  `����` varchar(15) default NULL,  `�ܽ��` varchar(15) default NULL,  `������ҵ` varchar(10) default NULL," +
				 		"  `Ͷ������` varchar(15) default NULL,  `�����` varchar(8) default NULL,  `������` varchar(8) default NULL," +
				 		"  `����ͬ��` varchar(15) default NULL,  `�����ʲ�` varchar(15) default NULL," +
				 		"  `����` varchar(8) default NULL,  `��������` varchar(10) default NULL,  `���` varchar(8) default NULL," +
				 		"  `���` varchar(8) default NULL,  `δ������` varchar(15) default NULL,  `Ȩ�����` varchar(8) default NULL," +
				 		"  `ÿ�ʾ���` varchar(8) default NULL,  `ÿ�ʻ���` varchar(8) default NULL,  `ÿ�ɹ���` varchar(8) default NULL," +
				 		"  `ÿ�ɾ���` varchar(8) default NULL,  `ÿ������` varchar(10) default NULL," +
				 		"  `ÿ��δ����` varchar(8) default NULL,  `��Ծ��` varchar(8) default NULL,  `������ծ` varchar(15) default NULL," +
				 		"  `�����ʲ�` varchar(15) default NULL,  `��ͨ��ֵ` varchar(15) default NULL,  `��ͨ�ɱ�` varchar(18) default NULL," +
				 		"  `�Ƿ���` varchar(8) default NULL,  `�ǵ�` varchar(8) default NULL,  `������` varchar(8) default NULL," +
				 		"  `�ּ�` varchar(8) default NULL,  `����` varchar(15) default NULL,  `˰������` varchar(15) default NULL," +
				 		"  `��ͷ�ز�` varchar(8) default NULL,  `��ͷֹ��` varchar(8) default NULL,  `��Ӫ�ֽ���` varchar(15) default NULL," +
				 		"  `ְ����` varchar(8) default NULL,  `Ӫҵ����` varchar(15) default NULL,  `��������` varchar(8) default NULL," +
				 		"  `����` varchar(8) default NULL,  `����Ͷ��` varchar(15) default NULL,  `���ڸ�ծ` varchar(15) default NULL," +
				 		"  `����` varchar(15) default NULL,  `����` varchar(15) default NULL,  `�ɽ���` varchar(15) default NULL," +
				 		"  `�ɽ���` varchar(15) default NULL,  PRIMARY KEY  (`ID`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;";

				 Query query2 = session.createSQLQuery(droptable2);
				 query2.executeUpdate();
				
//				 SchemaExport schemaExport = new SchemaExport(HibernateSessionFactory.getConfiguration());  
//		         schemaExport.create(true, true);   
		         this.txtUrl.setText(url+dbName);
		         saveConfig();
				JCMessageBox.createInformationMessageBox(this, getTitle(),
						"�������ݳɹ�").open();
			}
					
			session.getTransaction().commit();
			HibernateSessionFactory.reConnect();
		} catch (Exception e) {
			logger.error("�������Ӵ���:",e);
			JCMessageBox.createInformationMessageBox(this, getTitle(),
					"���ݿ��޷����ӣ���鿴�����Ƿ���ȷ!!!").open();
		}
		
	}

	public void MidScr(JCDialog jc) {
		// ͨ����Ļ�Ϳؼ��Ĵ�С����ؼ����Ͻǵ�λ��
		Dimension d_c = jc.getSize();
		Dimension d_scr = Toolkit.getDefaultToolkit().getScreenSize();
		double x1 = (d_scr.getWidth() - d_c.getWidth()) / 2;
		double y1 = (d_scr.getHeight() - d_c.getHeight()) / 2;
		x = new Double(x1).intValue();
		y = new Double(y1).intValue();
		jc.setLocation(x, y);
	}

}