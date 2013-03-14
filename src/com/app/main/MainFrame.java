package com.app.main;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.app.config.ConfigBean;
import com.app.config.XMLUtils;
import com.app.importdata.IdataProvider;
import com.app.importdata.impl.DataProviderImpl;
import com.app.util.DateUtil;
import com.app.util.SwingTimerTask;
import com.app.util.SwingWorker;
import com.app.util.TaskEngine;
import com.app.util.VersionUtils;

import craky.component.JRound3DProgressBar;
import craky.componentc.JCButton;
import craky.componentc.JCCheckBox;
import craky.componentc.JCFrame;
import craky.componentc.JCLabel;
import craky.componentc.JCMenu;
import craky.componentc.JCMenuItem;
import craky.componentc.JCMessageBox;
import craky.componentc.JCPopupMenu;
import craky.componentc.JCScrollPane;
import craky.componentc.JCTextArea;
import craky.componentc.JCTextField;
import craky.layout.LineLayout;
import craky.util.UIUtil;

/**
 * 
 * ������
 * 
 */
public class MainFrame {
	private JCFrame f; // ϵͳ������
	private JTextField filepath; // �ļ�·��
	private JCTextArea textPane; // ��Ϣ����
	private JCScrollPane js; // �������
	private JCLabel info; // ��Ϣ��ǩ
	private JCButton startbt; // ��ʼ��ť
	private JCButton browserbt; // �����ť
	private JRound3DProgressBar slider; // ������
	private Dimension preferredSize; // ��ʼ����ť��С
	private JFileChooser chooser; // �ļ�ѡ����
	private static MainFrame instance; // ����
	private DateChooserJCTextField datefield; // ʱ���ı���
	private JCheckBox auto; // �Զ���ѡ��
	private JCheckBox manual; // �ֶ���ѡ��
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel panel;
	private ConfigBean config; // ����bean
	private XMLUtils xml; // xml������
	private JCMenuItem saveconfig; // ���水ť
	private JCMenuItem configdialog; // ���öԻ���
	private JCMenuItem aboutdialog;  //���ڶԻ���
	private SwingTimerTask task; // ��ʱִ�е�����
	private long delay = 5000; // �ӳ�ִ��5��
	private long period = 1000; // ִ������Ϊ5��
	private Map filemap;
	IdataProvider process;
	int x=0;
	int y=0;
	String appname = "��Ʊ���ݵ������";
	private MainFrame() {

	}

	// �򵥵���ģʽ
	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
			instance.init();
			return instance;
		}
		return instance;
	}

	/**
	 * ϵͳ��ʼ��
	 * 
	 * @wbp.parser.entryPoint
	 */
	private void init() {
		initVar();
		initLayout();
		initMenu();
		initConfig();
		initListeners();
		addTrayIcon();
		startRun();
	}

	/**
	 * ��ʼ������
	 */
	public void initVar() {
		f = new JCFrame();
		filepath = new JCTextField();

		datefield = new DateChooserJCTextField();
		manual = new JCCheckBox("\u624B\u52A8");
		auto = new JCCheckBox("\u81EA\u52A8");
		slider = new JRound3DProgressBar();

		startbt = new JCButton("\u5F00\u59CB");
		browserbt = new JCButton("\u6D4F\u89C8");

		info = new JCLabel("\u6570\u636E\u4FE1\u606F");
		textPane = new JCTextArea();
		xml = new XMLUtils();
		config = xml.getconfigXML();
		saveconfig = new JCMenuItem("��������");
		configdialog = new JCMenuItem("���ݿ�����");
		aboutdialog = new JCMenuItem("����");
		preferredSize = new Dimension(80, 20); // ��ʼ����ť��С
		process = new DataProviderImpl();
		filemap = new HashMap();

		// ����Լ��̳еĻ������ܻ�����޷�ȡ��������������ʱ��ֻ��ͨ�����ְ취�����
		task = new SwingTimerTask() {
			@Override
			public void doRun() {
				// TODO Auto-generated method stub
				RunAction.autoRun();
			}

		};
	}

	/**
	 * ��ʼ������
	 */
	public void initLayout() {

		f.setSize(400, 400);
		f.setAlwaysOnTop(true);
		f.setTitle(appname);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setBackground(new Color(110, 120, 10));
		f.setIconImage(new ImageIcon(System.getProperty("user.dir")
				+ "/images/export.png").getImage());
		startbt.setPreferredSize(preferredSize);
		browserbt.setPreferredSize(preferredSize);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 1, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 54, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0,
				Double.MIN_VALUE };

		f.getContentPane().setLayout(gridBagLayout);

		JCLabel label = new JCLabel("\u8DEF\u5F84\uFF1A");
		label.setText(" \u8DEF\u5F84\uFF1A");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.insets = new Insets(1, 1, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		f.getContentPane().add(label, gbc_label);

		GridBagConstraints gbc_filepath = new GridBagConstraints();
		gbc_filepath.fill = GridBagConstraints.HORIZONTAL;
		gbc_filepath.insets = new Insets(5, 1, 5, 5);
		gbc_filepath.gridx = 1;
		gbc_filepath.gridy = 0;
		f.getContentPane().add(filepath, gbc_filepath);
		filepath.setColumns(10);

		GridBagConstraints gbc_browserbt = new GridBagConstraints();
		gbc_browserbt.weightx = 0.15; // ����������ã����򲼾ַ����仯��ʱ���޷�����bt�����еĿ�ȣ��Ӷ���������bt�Ĵ�С
		gbc_browserbt.fill = GridBagConstraints.HORIZONTAL;
		gbc_browserbt.insets = new Insets(5, 5, 5, 0);
		gbc_browserbt.gridx = 2;
		gbc_browserbt.gridy = 0;
		f.getContentPane().add(browserbt, gbc_browserbt);

		JCLabel lblNewLabel;
		lblNewLabel = new JCLabel("\u65E5\u671F\uFF1A");
		lblNewLabel.setText(" \u65E5\u671F\uFF1A");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(1, 1, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		f.getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(5, 1, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		f.getContentPane().add(datefield, gbc_textField);
		datefield.setColumns(10);

		panel = new JPanel();
		panel.setOpaque(false);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null), "\u6267\u884C\u65B9\u5F0F", TitledBorder.CENTER,
				TitledBorder.TOP, null, new Color(153, 50, 204)));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridwidth = 3;
		gbc_panel_1.insets = new Insets(5, 5, 5, 0);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		f.getContentPane().add(panel, gbc_panel_1);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5)); // ��ʽ����

		panel.add(auto);
		buttonGroup.add(auto);

		panel.add(manual);
		buttonGroup.add(manual);

		textPane.setForeground(Color.BLUE);
		textPane.setBackground(UIManager.getColor("Button.shadow"));
		textPane.setAutoscrolls(false);
		js = new JCScrollPane();
		js.getHeaderLabel().setText("\u8F93\u51FA\u4FE1\u606F");
		js.setViewportView(textPane);

		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.gridwidth = 3;
		gbc_textPane.insets = new Insets(5, 5, 5, 0);
		gbc_textPane.fill = GridBagConstraints.BOTH;
		gbc_textPane.gridx = 0;
		gbc_textPane.gridy = 3;
		f.getContentPane().add(js, gbc_textPane);

		GridBagConstraints gbc_info = new GridBagConstraints();
		gbc_info.fill = GridBagConstraints.BOTH;
		gbc_info.gridwidth = 3;
		gbc_info.insets = new Insets(5, 5, 5, 5);
		gbc_info.gridx = 0;
		gbc_info.gridy = 5;
		f.getContentPane().add(info, gbc_info);

		GridBagConstraints gbc_slider = new GridBagConstraints();
		gbc_slider.fill = GridBagConstraints.HORIZONTAL;
		gbc_slider.gridwidth = 2;
		gbc_slider.insets = new Insets(5, 5, 5, 5);
		gbc_slider.gridx = 0;
		gbc_slider.gridy = 4;
		f.getContentPane().add(slider, gbc_slider);

		GridBagConstraints gbc_startbt = new GridBagConstraints();
		gbc_startbt.fill = GridBagConstraints.HORIZONTAL;
		gbc_startbt.insets = new Insets(5, 5, 5, 0);
		gbc_startbt.gridx = 2;
		gbc_startbt.gridy = 4;
		f.getContentPane().add(startbt, gbc_startbt);

		f.setBackgroundImage(new ImageIcon(System.getProperty("user.dir")
				+ "/images/normal.png").getImage(), null);

		datefield.setText(DateUtil.LongDate2Str(new Date()));
		f.setVisible(true);
		MidScr(f);

	}

	/**
	 * �������ͼ�꣬������ӵ����˵�
	 */
	public void addTrayIcon() {
		if (SystemTray.isSupported()) {// �жϵ�ǰƽ̨�Ƿ�֧��ϵͳ����
			SystemTray st = SystemTray.getSystemTray();
			Image image = Toolkit.getDefaultToolkit().getImage(
					System.getProperty("user.dir") + "/images/export.png");// ��������ͼ���ͼƬ
			TrayIcon ti = new TrayIcon(image, appname);
			final JCPopupMenu jpop = new JCPopupMenu();
			JCMenuItem exit = new JCMenuItem("�˳�");
			final JCMenuItem showmainframe = new JCMenuItem("��������");
			jpop.add(showmainframe);
			jpop.addSeparator();
			jpop.add(exit);
			// ��ʾ��������������
			showmainframe.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					jpop.setVisible(false);
					f.setVisible(!f.isVisible());
					showmainframe.setText(f.isVisible() ? "����������" : "��������");
				}

			});
			// �˳��¼�
			exit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					jpop.setVisible(false);
					JCMessageBox jb = JCMessageBox.createQuestionMessageBox(f,
							"�˳�ϵͳ", "��ȷ��Ҫ�˳�ϵͳ��");
					int type = jb.open();
					if (JCMessageBox.YES_OPTION == type) {
						saveConfig();
						System.exit(0);
					}

				}

			});

			try {
				st.add(ti);
				// �������
				ti.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						jpop.show(null, e.getXOnScreen() - 80,
								e.getYOnScreen() - 60);
						showmainframe
								.setText(f.isVisible() ? "����������" : "��������");
					}

				});
			} catch (AWTException ex) {
				ex.printStackTrace();
			}
		}

	}

	/**
	 * ��ʼ������
	 */
	public void initConfig() {

		if ("�Զ�".equals(config.getRuntype())) {
			auto.setSelected(true);
			startbt.setEnabled(false);
		} else if ("�ֶ�".equals(config.getRuntype())) {
			manual.setSelected(true);
			startbt.setEnabled(true);
		}
		this.getFilepath().setText(config.getFilepath());
		this.getDateFiled().setText(config.getDatetime());
		delay = config.getDelay();
		period = config.getPeriod();

		if("true".equals(config.getIsFirstRun())){
			ConfigDialog confd = new ConfigDialog(f,xml,config);
		}
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\config\\log4j.properties");
		// this.getTextPane().insert("�Զ������ӳ�ʱ���ǣ�"+delay+" ms "+" �����ǣ�"+period+"ms \n",
		// this.getTextPane().getRows());
		System.out.println("�����ļ��������ͣ�" + config.getRuntype());
		System.out.println("�����ļ�·����" + config.getFilepath());
		System.out.println("�����ļ��������ͣ�" + config.getDatetime());
		System.out.println("�����ļ�ִ�������ǣ�" + period+"Сʱ");
	}

	/**
	 * ���������ļ�
	 */
	public void saveConfig() {
		if (auto.isSelected()) {
			config.setRuntype("�Զ�");
		} else {
			config.setRuntype("�ֶ�");
		}
		config.setDatetime(datefield.getText());
		config.setFilepath(filepath.getText());
		xml.modifyconfigXML(config);
	}

	/**
	 * ��ʼ����
	 */
	public void startRun() {
		if (auto.isSelected()) {
			this.getInfo().setText(
					"<html>��ǰΪ<font color=red>�Զ�</font>ִ��ģʽ</html>");
			// ��ע�����У��ڼ���ƻ����񣬷�������һ��task�Ķ������
			TaskEngine.getInstance().cancelScheduledTask(task);
			if (DateUtil.Time2LongDate(datefield.getText()).getTime() < new Date()
					.getTime()) {
				textPane.insert("�����趨�����ڲ���ȷ������������\n", textPane.getRows());
			} else {
				textPane.insert("��ǰΪ�Զ�ģʽ������  "
						+ instance.getDateFiled().getText() + " �Զ���������\n",
						instance.getTextPane().getRows());
				TaskEngine.getInstance().schedule(task,
						DateUtil.Time2LongDate(datefield.getText()), period*60*60*1000);
			}
		} else if (manual.isSelected()) {
			this.getInfo().setText(
					"<html>��ǰΪ<font color=red>�ֶ�</font>ִ��ģʽ</html>");
			TaskEngine.getInstance().cancelScheduledTask(task);
			task.cancel();
		}

	}

	/**
	 * ��ʼ������
	 */
	public void initListeners() {

		startbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String path = filepath.getText();
				final File file = new File(path);
				if (!"".equals(path) && file.exists() && file.isFile()) {
					SwingWorker sw = new SwingWorker(){
						@Override
						public Object construct() {
							process.start(file);
							return null;
						}
					};
					sw.start();
				} else {
					JCMessageBox jb = JCMessageBox.createInformationMessageBox(
							f, "ϵͳ��ʾ", "����δѡ���ļ�");
					jb.open();
				}
				saveConfig();

			}
		});
		browserbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"txt&xsl", "txt", "xls", "XLS");
				chooser.setFileFilter(filter);
				chooser.setVisible(true);
				System.out.println("actionperformed");
				int ret = chooser.showOpenDialog(f);
				if (ret != 0) {
					return;
				}
				filepath.setText(chooser.getSelectedFile().getAbsolutePath());
				saveConfig();
			}
		});

		auto.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (auto.isSelected()) {
					saveConfig();
					startRun();
					startbt.setEnabled(false);
				}
			}

		});

		manual.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (manual.isSelected()) {
					saveConfig();
					task.cancel();
					startbt.setEnabled(true);
				}
			}

		});


		configdialog.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ConfigDialog confd = new ConfigDialog(f,xml,config);
			}

		});
		
		
		
		aboutdialog.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				JCMessageBox jb = JCMessageBox.createInformationMessageBox(f,"����","����汾�ţ�"+VersionUtils.getAppVersion()+" ��������");
				jb.open();
			}
			
		});
		
		saveconfig.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveConfig();
				JCMessageBox jb = JCMessageBox.createInformationMessageBox(f,
						"���������ļ�", "���浱ǰ���óɹ�");
				jb.open();
			}
		});

	}

	/**
	 * ��ʼ���˵�
	 */
	public void initMenu() {
		JMenuBar bar = new JMenuBar();
		bar.setOpaque(false);
		bar.setBorder(new EmptyBorder(0, 0, 0, 0));
		bar.setBorderPainted(false);
		bar.setLayout(new GridLayout(1, 2));
		bar.setPreferredSize(new Dimension(40, 20));
		bar.setFocusable(false);
		final Icon ICON = new ImageIcon(System.getProperty("user.dir")
				+ "/images/menu_button_icon.png");
		final Image ROLLOVER_IMAGE = new ImageIcon(System
				.getProperty("user.dir")
				+ "/images/common_button_rollover_bg.png").getImage();
		final Image PRESSED_IMAGE = new ImageIcon(System
				.getProperty("user.dir")
				+ "/images/common_button_pressed_bg.png").getImage();

		// ������Ҫ�ػ���ť
		JCMenu menu = new JCMenu() {
			@Override
			protected void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				int iconWidth = ICON.getIconWidth();
				int iconHeight = ICON.getIconHeight();

				if (getModel().isSelected()) {
					UIUtil.paintImage(g, PRESSED_IMAGE, new Insets(2, 2, 2, 2),
							new Rectangle(0, 0, width, height), this);
				} else if (getModel().isRollover()) {
					UIUtil.paintImage(g, ROLLOVER_IMAGE,
							new Insets(2, 2, 2, 2), new Rectangle(0, 0, width,
									height), this);
				}

				ICON.paintIcon(this, g, (width - iconWidth) / 2,
						(height - iconHeight) / 2);
			}

		};

		menu.add(saveconfig);
		menu.add(configdialog);
		menu.add(aboutdialog);
	

		bar.add(menu);
		f.getTitleContentPane().setLayout(
				new LineLayout(0, 0, 0, 2, 0, 11, 10, 0));
		f.getTitleContentPane().add(bar, "End"); // ���˵����뵽�������������
	}

	public JTextField getFilepath() {
		return filepath;
	}

	public JTextField getDateFiled() {
		return datefield;

	}

	public JCButton getBrowserbt() {
		return browserbt;
	}

	public JTextArea getTextPane() {
		return textPane;
	}

	public JCLabel getInfo() {
		return info;
	}

	public JCButton getStartbt() {
		return startbt;
	}

	public JRound3DProgressBar getSlider() {
		return slider;
	}

	public JCFrame getFrame() {
		return f;
	}

	public ConfigBean getConfig() {
		return config;
	}

	public JCheckBox getAuto() {
		return auto;
	}

	public JCheckBox getManual() {
		return manual;
	}

	public Map getFileMap() {
		return filemap;
	}

	public IdataProvider getProcess() {
		return process;
	}
	
	
	public void CreateconfigWindow(){
		if("true".equals(config.getIsFirstRun())){
			
			
		}else{
			
			
		}
		
	}

	public void MidScr(JFrame jc) {
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
