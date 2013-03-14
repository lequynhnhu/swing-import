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
		super(owner, "修改配置文件", Dialog.ModalityType.DOCUMENT_MODAL);
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
		JCLabel lbAddAdmin = new JCLabel("首次使用，请先修改数据库配置，并点击创建数据库");
		JCLabel lbNew = new JCLabel();
		lbNew.setText("\u6570\u636E\u5E93\u7528\u6237\uFF1A");
		JCLabel lbCheck = new JCLabel("密码确认");
		lbCheck.setText("\u6570\u636E\u5E93\u5BC6\u7801\uFF1A");
		JCLabel lburl = new JCLabel("数据库连接：");
		this.txtNew = new JCTextField();
		this.txtCheck = new JCTextField();
		this.btnOk = new JCButton("确定");
		this.btnCancel = new JCButton("取消");
		btnTest = new JCButton("测试");
		txtUrl = new JCTextField();
		createDataBase  = new JCButton("创建数据库");

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
	 * 初始化数据
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
						"数据库无法连接，请查看配置是否正确").open();
			} else {
				JCMessageBox.createInformationMessageBox(this, getTitle(),
						"数据库连接正常").open();
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			logger.error("数据连接错误:",e);
			JCMessageBox.createInformationMessageBox(this, getTitle(),
					"数据库无法连接，请查看配置是否正确!!!").open();
		}

	}

	/**
	 * 提交数据
	 */
	private void submit() {
		saveConfig();
		JCMessageBox
				.createInformationMessageBox(this, getTitle(), "数据配置文件修改完毕")
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
	
	
	
	//自动创建数据库
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
						"数据库无法连接，请查看配置是否正确，如果想初始化数据库，请去掉jdbc:mysql://localhost:3306/xxxx  后面的字符串xxxx").open();
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
				 		"`导入日期` varchar(19) NOT NULL," +
				 		"`名称` varchar(30) default NULL," +
				 		"`AB股总市值` varchar(15) default NULL," +
				 		"`B股或A` varchar(10) default NULL," +
				 		"`H股` varchar(15) default NULL," +
				 		"`上市日期` varchar(10) default NULL," +
				 		"`主营利润` varchar(15) default NULL," +
				 		"`主营收入` varchar(15) default NULL," +
				 		"`买价一` varchar(8) default NULL," +
				 		"`买价三` varchar(8) default NULL," +
				 		"`买价二` varchar(8) default NULL,`买入价` varchar(8) default NULL,`买量一` varchar(10) default NULL," +
				 		"`买量三` varchar(10) default NULL,`买量二` varchar(10) default NULL,`今开` varchar(8) default NULL," +
				 		" `代码` varchar(10) default NULL,`公积金` varchar(15) default NULL," +
				 		"`内外比` varchar(8) default NULL,`内盘` varchar(15) default NULL," +
				 		"`净利润` varchar(15) default NULL," +
				 		"`净益率` varchar(10) default NULL,`净资产` varchar(15) default NULL," +
				 		"`利润同比` varchar(15) default NULL,`利润总额` varchar(15) default NULL," +
				 		"`卖价一` varchar(8) default NULL,`卖价三` varchar(8) default NULL,`卖价二` varchar(8) default NULL,`卖出价` varchar(8) default NULL," +
				 		"`卖量一` varchar(10) default NULL,`卖量三` varchar(10) default NULL, `卖量二` varchar(10) default NULL," +
				 		" `固定资产` varchar(15) default NULL,  `国家股` varchar(15) default NULL," +
				 		"  `均价` varchar(8) default NULL,  `外盘` varchar(15) default NULL,  `多头止损` varchar(8) default NULL," +
				 		"  `多头获利` varchar(8) default NULL,  `多空平衡` varchar(8) default NULL,  `委比率` varchar(8) default NULL," +
				 		"  `委量差` varchar(10) default NULL,  `存货` varchar(15) default NULL,  `市净率` varchar(8) default NULL," +
				 		"  `市盈dong` varchar(15) default NULL,  `强弱度率` varchar(8) default NULL,  `总现金流` varchar(15) default NULL," +
				 		"  `总股本wan` varchar(15) default NULL,  `总资产wan` varchar(15) default NULL," +
				 		"  `总量` varchar(15) default NULL,  `总金额` varchar(15) default NULL,  `所属行业` varchar(10) default NULL," +
				 		"  `投资收益` varchar(15) default NULL,  `振幅率` varchar(8) default NULL,  `换手率` varchar(8) default NULL," +
				 		"  `收入同比` varchar(15) default NULL,  `无形资产` varchar(15) default NULL," +
				 		"  `昨收` varchar(8) default NULL,  `更新日期` varchar(10) default NULL,  `最低` varchar(8) default NULL," +
				 		"  `最高` varchar(8) default NULL,  `未分利润` varchar(15) default NULL,  `权益比率` varchar(8) default NULL," +
				 		"  `每笔均量` varchar(8) default NULL,  `每笔换手` varchar(8) default NULL,  `每股公积` varchar(8) default NULL," +
				 		"  `每股净资` varchar(8) default NULL,  `每股收益` varchar(10) default NULL," +
				 		"  `每股未分配` varchar(8) default NULL,  `活跃度` varchar(8) default NULL,  `流动负债` varchar(15) default NULL," +
				 		"  `流动资产` varchar(15) default NULL,  `流通市值` varchar(15) default NULL,  `流通股本` varchar(18) default NULL," +
				 		"  `涨幅率` varchar(8) default NULL,  `涨跌` varchar(8) default NULL,  `涨速率` varchar(8) default NULL," +
				 		"  `现价` varchar(8) default NULL,  `现量` varchar(15) default NULL,  `税后利润` varchar(15) default NULL," +
				 		"  `空头回补` varchar(8) default NULL,  `空头止损` varchar(8) default NULL,  `经营现金流` varchar(15) default NULL," +
				 		"  `职工股` varchar(8) default NULL,  `营业利润` varchar(15) default NULL,  `调整后净资` varchar(8) default NULL," +
				 		"  `量比` varchar(8) default NULL,  `长期投资` varchar(15) default NULL,  `长期负债` varchar(15) default NULL," +
				 		"  `开盘` varchar(15) default NULL,  `收盘` varchar(15) default NULL,  `成交额` varchar(15) default NULL," +
				 		"  `成交量` varchar(15) default NULL,  PRIMARY KEY  (`ID`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;";

				 Query query2 = session.createSQLQuery(droptable2);
				 query2.executeUpdate();
				
//				 SchemaExport schemaExport = new SchemaExport(HibernateSessionFactory.getConfiguration());  
//		         schemaExport.create(true, true);   
		         this.txtUrl.setText(url+dbName);
		         saveConfig();
				JCMessageBox.createInformationMessageBox(this, getTitle(),
						"创建数据成功").open();
			}
					
			session.getTransaction().commit();
			HibernateSessionFactory.reConnect();
		} catch (Exception e) {
			logger.error("数据连接错误:",e);
			JCMessageBox.createInformationMessageBox(this, getTitle(),
					"数据库无法连接，请查看配置是否正确!!!").open();
		}
		
	}

	public void MidScr(JCDialog jc) {
		// 通过屏幕和控件的大小计算控件左上角的位置
		Dimension d_c = jc.getSize();
		Dimension d_scr = Toolkit.getDefaultToolkit().getScreenSize();
		double x1 = (d_scr.getWidth() - d_c.getWidth()) / 2;
		double y1 = (d_scr.getHeight() - d_c.getHeight()) / 2;
		x = new Double(x1).intValue();
		y = new Double(y1).intValue();
		jc.setLocation(x, y);
	}

}