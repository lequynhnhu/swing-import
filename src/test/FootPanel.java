package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

class FootPanel extends JPanel {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private JTextField hour;
		private JTextField minute;
		private JTextField seconds;

		

		public FootPanel() {

			super(new BorderLayout());

			this.setPreferredSize(new Dimension(295, 40));

			this.setBackground(new Color(160, 185, 215));

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");

			final JLabel jl = new JLabel("今天: " + sdf.format(new Date()));

			jl.setToolTipText("点击回到今天日期");

			this.add(jl, BorderLayout.SOUTH);
			
			JPanel panel = new JPanel();
			panel.setOpaque(false);
			add(panel, BorderLayout.CENTER);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			
			JLabel lblNewLabel = new JLabel("\u65F6\uFF1A");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 1;
			panel.add(lblNewLabel, gbc_lblNewLabel);
			
			hour = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 5);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 1;
			gbc_textField.gridy = 1;
			panel.add(hour, gbc_textField);
			hour.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("\u5206\uFF1A");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 2;
			gbc_lblNewLabel_1.gridy = 1;
			panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
			
			minute = new JTextField();
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.insets = new Insets(0, 0, 5, 5);
			gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_1.gridx = 3;
			gbc_textField_1.gridy = 1;
			panel.add(minute, gbc_textField_1);
			minute.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("\u79D2\uFF1A");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 4;
			gbc_lblNewLabel_2.gridy = 1;
			panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
			
			seconds = new JTextField();
			GridBagConstraints gbc_textField_2 = new GridBagConstraints();
			gbc_textField_2.insets = new Insets(0, 0, 5, 0);
			gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_2.gridx = 5;
			gbc_textField_2.gridy = 1;
			panel.add(seconds, gbc_textField_2);
			seconds.setColumns(10);
			

			

			jl.addMouseListener(new MouseAdapter() {

				public void mouseEntered(MouseEvent me) {

					jl.setCursor(new Cursor(Cursor.HAND_CURSOR));

					jl.setForeground(Color.RED);

				}

				public void mouseExited(MouseEvent me) {

					jl.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

					jl.setForeground(Color.BLACK);

				}

				public void mousePressed(MouseEvent me) {

					jl.setForeground(Color.WHITE);

				//	select.setTime(new Date());

			//		refresh();

				//	commit();

				}

				public void mouseReleased(MouseEvent me) {

					jl.setForeground(Color.BLACK);

				}

			});

		}

	}
