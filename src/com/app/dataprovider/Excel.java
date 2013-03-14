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
	// 文件路径
	private String path;
	private String tableName;
	private String[] tableCols;

	// 工作薄集合
	private Workbook workbook;
	Logger logger = Logger.getLogger(Excel.class);

	public Excel(String path, String tableName, String[] tableCols)
			throws BiffException, IOException {
		this.tableName = tableName;
		this.tableCols = tableCols;
		this.setPath(path);
		WorkbookSettings workbookSettings = new WorkbookSettings();
		workbookSettings.setEncoding("ISO-8859-1"); // 解决中文乱码
		this.setWorkbook(Workbook.getWorkbook(new java.io.File(path),workbookSettings));
	}

	/**
	 * 获取工作薄数量
	 * 
	 * @return 工作薄数量
	 */
	public int getNumberOfSheets(Workbook book) {
		return book == null ? 0 : book.getNumberOfSheets();
	}

	/**
	 * 获取工作薄总行数
	 * 
	 * @param sheet
	 *            工作薄
	 * @return 工作薄总行数
	 */
	public int getRows(Sheet sheet) {
		return sheet == null ? 0 : sheet.getRows();
	}

	/**
	 * 获取最大列数
	 * 
	 * @param sheet
	 *            工作薄
	 * @return 总行数最大列数
	 */
	public int getColumns(Sheet sheet) {
		return sheet == null ? 0 : sheet.getColumns();
	}

	/**
	 * 获取每行单元格数组
	 * 
	 * @param sheet
	 *            工作薄
	 * @param row
	 *            行数
	 * @return 每行单元格数组
	 */
	public Cell[] getRows(Sheet sheet, int row) {
		return sheet == null || sheet.getRows() < row ? null : sheet
				.getRow(row);
	}

	/**
	 * 获取每行单元格数组
	 * 
	 * @param sheet
	 *            工作薄
	 * @param endrow
	 *            结束行
	 * @param endCol
	 *            结束列
	 * @return 每行单元格数组
	 */
	public Cell[][] getCells(Sheet sheet, int endrow, int endcol) {
		return getCells(sheet, 0, endrow, 0, endcol);
	}

	/**
	 * 获取每行单元格数组
	 * 
	 * @param sheet
	 *            工作薄
	 * @param startrow
	 *            行数
	 * @param endrow
	 *            结束行
	 * @param startcol
	 *            开始列
	 * @param endCol
	 *            结束列
	 * @return 每行单元格数组
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
	 * 得到行的值
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
	 * 得到列的值
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
	 * 生成随机ID
	 * 
	 * @return
	 */
	public static String getStrRandomId() {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		return uuid;
	}

	/**
	 * 组装SQL语句(扩展导入数据库额外增加字段的情况)
	 * 
	 * @param sheet
	 *            工作薄
	 * @param startrow
	 *            开始行
	 * @param endrow
	 *            结束行
	 * @param startcol
	 *            开始列
	 * @param endcol
	 *            结束列
	 * @return SQL语句数组
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
			// 在第一列前加个随机数列
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
			// 增加时间字段
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
	 * 组装SQL语句(扩展导入数据库额外增加字段的情况)
	 * 
	 * @param sheet
	 *            工作薄
	 * @param startrow
	 *            开始行
	 * @param endrow
	 *            结束行
	 * @param startcol
	 *            开始列
	 * @param endcol
	 *            结束列
	 * @param tablename
	 *            表名称
	 * @return SQL语句数组
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
		bf.append(",导入日期,ID) VALUES (");
		for (int i = 0; tableCols != null && i < tableCols.length + 2; i++) {
			if (i != tableCols.length + 1)
				bf.append("?").append(",");
			else
				bf.append("?").append(")");
		}

		try {
			ImportStockDAO imdao = new ImportStockDAO();
			imdao.getSession().beginTransaction();
			logger.debug("导入数据库所拼装的语句是：" + bf.toString());
			Query query = imdao.getSession().createSQLQuery(bf.toString());
			// 从第二行开始
			MainFrame mf =MainFrame.getInstance();
			for (int i = 0; i < cellArray.length; i++) {
				Cell[] cell = cellArray[i];
				if (tableCols != null && cell != null
						&& tableCols.length != cell.length)
					continue;
				int j = 0;
				for (; j < cell.length; j++) {
					logger.debug("单元格"+i+"  行， " + j +"列内容：" + cell[j].getContents().toString());
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
					mf.getTextPane().insert("导入数据库出现问题，请检查文件格式是否符合要求！！！",mf.getTextPane().getRows());
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
			logger.error("导入数据库出现问题", e);
		}
		return isport;

	}

	/**
	 * 获得表头列
	 * 
	 * @param sheet
	 * @return
	 */
	public String[] getSheetHead(Sheet sheet) {
		sheet = workbook.getSheet(0); // 获得第一个工作表对象
		int a = getRows(sheet); // 最大行数
		int m = getColumns(sheet); // 最大列数
		Cell[][] c = getCells(sheet, 0, a, 0, m);
		Cell[] obj = c[0]; // head 列
		String head[] = new String[obj.length];
		for (int i = 0; i < obj.length; i++) {
			head[i] = obj[i].getContents().toString().replaceAll("%%", "率");
			head[i] = head[i].replaceAll("\\(动\\)", "dong");
		}
		return head;
	}

	/**
	 * 获取Excel文件路径
	 * 
	 * @return Excel文件路径
	 */
	public String getPath() {
		return this.path;
	}

	/**
	 * 设置Excel文件路径
	 * 
	 * @param path
	 *            Excel文件路径
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * 获取工作薄集合
	 */
	public Workbook getWorkbook() {
		return this.workbook;
	}

	/**
	 * 设置工作薄集合
	 * 
	 * @param workbook
	 *            工作薄集合
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