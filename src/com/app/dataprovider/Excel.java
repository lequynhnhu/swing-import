package com.app.dataprovider;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.UUID;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

import org.apache.log4j.Logger;
import org.hibernate.Query;

import com.app.main.MainFrame;
import com.app.util.DateUtil;
import com.hib.moudle.ImportStockDAO;

public class Excel {
	// �ļ�·��
	private String path;
	private String tableName;
	private String[] tableCols;

	// ����������
	private Workbook workbook;
	Logger logger = Logger.getLogger(Excel.class);

	public Excel(String path, String tableName, String[] tableCols)
			throws BiffException, IOException {
		this.tableName = tableName;
		this.tableCols = tableCols;
		this.setPath(path);
		WorkbookSettings workbookSettings = new WorkbookSettings();
		workbookSettings.setEncoding("ISO-8859-1"); // �����������
		this.setWorkbook(Workbook.getWorkbook(new java.io.File(path),workbookSettings));
	}

	/**
	 * ��ȡ����������
	 * 
	 * @return ����������
	 */
	public int getNumberOfSheets(Workbook book) {
		return book == null ? 0 : book.getNumberOfSheets();
	}

	/**
	 * ��ȡ������������
	 * 
	 * @param sheet
	 *            ������
	 * @return ������������
	 */
	public int getRows(Sheet sheet) {
		return sheet == null ? 0 : sheet.getRows();
	}

	/**
	 * ��ȡ�������
	 * 
	 * @param sheet
	 *            ������
	 * @return �������������
	 */
	public int getColumns(Sheet sheet) {
		return sheet == null ? 0 : sheet.getColumns();
	}

	/**
	 * ��ȡÿ�е�Ԫ������
	 * 
	 * @param sheet
	 *            ������
	 * @param row
	 *            ����
	 * @return ÿ�е�Ԫ������
	 */
	public Cell[] getRows(Sheet sheet, int row) {
		return sheet == null || sheet.getRows() < row ? null : sheet
				.getRow(row);
	}

	/**
	 * ��ȡÿ�е�Ԫ������
	 * 
	 * @param sheet
	 *            ������
	 * @param endrow
	 *            ������
	 * @param endCol
	 *            ������
	 * @return ÿ�е�Ԫ������
	 */
	public Cell[][] getCells(Sheet sheet, int endrow, int endcol) {
		return getCells(sheet, 0, endrow, 0, endcol);
	}

	/**
	 * ��ȡÿ�е�Ԫ������
	 * 
	 * @param sheet
	 *            ������
	 * @param startrow
	 *            ����
	 * @param endrow
	 *            ������
	 * @param startcol
	 *            ��ʼ��
	 * @param endCol
	 *            ������
	 * @return ÿ�е�Ԫ������
	 */
	public Cell[][] getCells(Sheet sheet, int startrow, int endrow,
			int startcol, int endcol) {
		Cell[][] cellArray = new Cell[endrow - startrow][endcol - startcol];
		int maxRow = this.getRows(sheet);
		int maxCos = this.getColumns(sheet);
		for (int i = startrow; i < endrow && i < maxRow; i++) {

			for (int j = startcol; j < endcol && j < maxCos; j++) {

				cellArray[i - startrow][j - startcol] = sheet.getCell(j, i);
			}

		}
		return cellArray;
	}

	/**
	 * �õ��е�ֵ
	 * 
	 * @param sheet
	 * @param col
	 * @param startrow
	 * @param endrow
	 * @return
	 */
	public Cell[] getColCells(Sheet sheet, int col, int startrow, int endrow) {
		Cell[] cellArray = new Cell[endrow - startrow];
		int maxRow = this.getRows(sheet);
		int maxCos = this.getColumns(sheet);
		if (col <= 0 || col > maxCos || startrow > maxRow || endrow < startrow) {
			return null;
		}
		if (startrow < 0) {
			startrow = 0;
		}
		for (int i = startrow; i < endrow && i < maxRow; i++) {
			cellArray[i - startrow] = sheet.getCell(col, i);
		}
		return cellArray;
	}

	/**
	 * �õ��е�ֵ
	 * 
	 * @param sheet
	 * @param row
	 * @param startcol
	 * @param endcol
	 * @return
	 */
	public Cell[] getRowCells(Sheet sheet, int row, int startcol, int endcol) {
		Cell[] cellArray = new Cell[endcol - startcol];
		int maxRow = this.getRows(sheet);
		int maxCos = this.getColumns(sheet);
		if (row <= 0 || row > maxRow || startcol > maxCos || endcol < startcol) {
			return null;
		}
		if (startcol < 0) {
			startcol = 0;
		}
		for (int i = startcol; i < startcol && i < maxCos; i++) {
			cellArray[i - startcol] = sheet.getCell(i, row);
		}
		return cellArray;
	}

	/**
	 * �������ID
	 * 
	 * @return
	 */
	public static String getStrRandomId() {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		return uuid;
	}

	/**
	 * ��װSQL���(��չ�������ݿ���������ֶε����)
	 * 
	 * @param sheet
	 *            ������
	 * @param startrow
	 *            ��ʼ��
	 * @param endrow
	 *            ������
	 * @param startcol
	 *            ��ʼ��
	 * @param endcol
	 *            ������
	 * @return SQL�������
	 */
	public Object[] constrctCellsSql(Sheet sheet, int startrow, int endrow,
			int startcol, int endcol, String payTime) {
		Cell[][] cellArray = getCells(sheet, startrow, endrow, startcol, endcol);
		java.util.ArrayList<String> list = new java.util.ArrayList<String>();
		StringBuffer bf = new StringBuffer("INSERT INTO " + tableName + "(ID,");
		tableCols = getSheetHead(sheet);
		for (int i = 0; tableCols != null && i < tableCols.length; i++) {
			if (i != tableCols.length - 1)
				bf.append(tableCols[i]).append(",");
			else
				bf.append(tableCols[i]).append("");

		}
		bf.append(",PAY_TIME) VALUES ");
		for (int i = startrow; i < cellArray.length; i++) {
			// �ڵ�һ��ǰ�Ӹ��������
			StringBuffer sqlBuffer = new StringBuffer();
			sqlBuffer.append(bf.toString() + "('" + getStrRandomId() + "',");
			Cell[] cell = cellArray[i];
			if (tableCols != null && cell != null
					&& tableCols.length != cell.length)
				continue;
			for (int j = startcol; j < cell.length; j++) {
				String tmp = "";
				if (cell[j] != null && cell[j].getContents() != null) {
					tmp = (String) cell[j].getContents();
				}
				if (j != cell.length - 1)
					sqlBuffer.append("'").append(tmp).append("',");
				else
					sqlBuffer.append("'").append(tmp).append("'");
			}
			// ����ʱ���ֶ�
			sqlBuffer.append(",").append(
					"to_date('" + payTime + "','YYYY-MM-DD HH24:MI:SS')");
			sqlBuffer.append(")");
			list.add(sqlBuffer.toString());
			System.out.println(sqlBuffer.toString());
		}
		System.out.println(list);
		return list.toArray();
	}

	/**
	 * ��װSQL���(��չ�������ݿ���������ֶε����)
	 * 
	 * @param sheet
	 *            ������
	 * @param startrow
	 *            ��ʼ��
	 * @param endrow
	 *            ������
	 * @param startcol
	 *            ��ʼ��
	 * @param endcol
	 *            ������
	 * @param tablename
	 *            ������
	 * @return SQL�������
	 * 
	 */
	public boolean intelligenceMatchingPort(Sheet sheet, int startrow,
			int endrow, int startcol, int endcol, String tablename) {
		boolean isport = false;
		Cell[][] cellArray = getCells(sheet, startrow, endrow, startcol, endcol);
		java.util.ArrayList<String> list = new java.util.ArrayList<String>();
		StringBuffer bf = new StringBuffer("INSERT INTO " + tablename + " (");
		tableCols = getSheetHead(sheet);
		for (int i = 0; tableCols != null && i < tableCols.length; i++) {
			if (i != tableCols.length - 1)
				bf.append(tableCols[i]).append(",");
			else
				bf.append(tableCols[i]).append("");
		}
		bf.append(",��������,ID) VALUES (");
		for (int i = 0; tableCols != null && i < tableCols.length + 2; i++) {
			if (i != tableCols.length + 1)
				bf.append("?").append(",");
			else
				bf.append("?").append(")");
		}

		try {
			ImportStockDAO imdao = new ImportStockDAO();
			imdao.getSession().beginTransaction();
			logger.debug("�������ݿ���ƴװ������ǣ�" + bf.toString());
			Query query = imdao.getSession().createSQLQuery(bf.toString());
			// �ӵڶ��п�ʼ
			MainFrame mf =MainFrame.getInstance();
			for (int i = 0; i < cellArray.length; i++) {
				Cell[] cell = cellArray[i];
				if (tableCols != null && cell != null
						&& tableCols.length != cell.length)
					continue;
				int j = 0;
				for (; j < cell.length; j++) {
					logger.debug("��Ԫ��"+i+"  �У� " + j +"�����ݣ�" + cell[j].getContents().toString());
					query.setString(j, cell[j].getContents().toString());
				}

				query
						.setString(tableCols.length, DateUtil
								.Date2Str(new Date()));
				query.setString(tableCols.length + 1, UUID.randomUUID()
						.toString());
				MainFrame.getInstance().getSlider().setValue(i);
				try{
					query.executeUpdate();
					
				}catch(Exception e){
					mf.getTextPane().insert("�������ݿ�������⣬�����ļ���ʽ�Ƿ����Ҫ�󣡣���",mf.getTextPane().getRows());
					isport = false;
					imdao.getSession().getTransaction().rollback();
					return isport;
				}
			//	query.executeUpdate();

			}
			imdao.getSession().getTransaction().commit();
			isport = true;
		} catch (Exception e) {
			isport = false;
			logger.error("�������ݿ��������", e);
		}
		return isport;

	}

	/**
	 * ��ñ�ͷ��
	 * 
	 * @param sheet
	 * @return
	 */
	public String[] getSheetHead(Sheet sheet) {
		sheet = workbook.getSheet(0); // ��õ�һ�����������
		int a = getRows(sheet); // �������
		int m = getColumns(sheet); // �������
		Cell[][] c = getCells(sheet, 0, a, 0, m);
		Cell[] obj = c[0]; // head ��
		String head[] = new String[obj.length];
		for (int i = 0; i < obj.length; i++) {
			head[i] = obj[i].getContents().toString().replaceAll("%%", "��");
			head[i] = head[i].replaceAll("\\(��\\)", "dong");
		}
		return head;
	}

	/**
	 * ��ȡExcel�ļ�·��
	 * 
	 * @return Excel�ļ�·��
	 */
	public String getPath() {
		return this.path;
	}

	/**
	 * ����Excel�ļ�·��
	 * 
	 * @param path
	 *            Excel�ļ�·��
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * ��ȡ����������
	 */
	public Workbook getWorkbook() {
		return this.workbook;
	}

	/**
	 * ���ù���������
	 * 
	 * @param workbook
	 *            ����������
	 */
	public void setWorkbook(Workbook workbook) {
		this.workbook = workbook;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			File fileWrite = new File("c:/testWrite.xls");
			fileWrite.createNewFile();
			OutputStream os = new FileOutputStream(fileWrite);
			// Excel.writeExcel(os);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}