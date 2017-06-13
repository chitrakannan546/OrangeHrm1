package dataSrc;
import org.testng.annotations.*;

import java.io.File;

import jxl.*;

public class OrangeHrm_MyDetails_DataProvider {

	public static Sheet sheet;
	public static Workbook workbook;

	@DataProvider(name = "Chrome")
	public static Object[][] createData1() throws Exception {

		Object[][] retObjArr = getTableArray_1(
				"C:\\Users\\sl060497\\Desktop\\OrangeHrm_MyDetails_DataProvider.xls", "DataSrc",
				"Chrome");		
		return (retObjArr);

	}

	@DataProvider(name = "Mozilla")
	public static Object[][] createData_2() throws Exception {

		Object[][] retObjArr = getTableArray_2(
				"C:\\Users\\sl060497\\Desktop\\OrangeHrm_MyDetails_DataProvider.xls", "DataSrc",
				"Mozilla");
		return (retObjArr);

	}

	@DataProvider(name = "InternetExplorer")
	public static Object[][] createData_3() throws Exception {

		Object[][] retObjArr = getTableArray_3(
				"C:\\Users\\sl060497\\Desktop\\OrangeHrm_MyDetails_DataProvider.xls", "DataSrc",
				"InternetExplorer");
		return (retObjArr);

	}
	
	
	public static String[][] getTableArray_1(String xlFilePath, String sheetName,
			String tableName) throws Exception {

		String[][] tabArray = null;
		Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));

		Sheet sheet = workbook.getSheet(sheetName);
		// DataProviderExample.OpenDataSource();
		int startRow, startCol, endRow, endCol, ci, cj;
		Cell tableStart = sheet.findCell(tableName);
		startRow = tableStart.getRow();
		startCol = tableStart.getColumn();
		Cell tableEnd = sheet.findCell(tableName, startCol + 1, startRow + 1,
				100, 64000, false);
		endRow = tableEnd.getRow();
		endCol = tableEnd.getColumn();
		System.out.println("startRow=" + startRow + ", endRow=" + endRow + ", "
				+ "startCol=" + startCol + ", endCol=" + endCol);
		tabArray = new String[endRow - startRow - 1][endCol - startCol - 1];
		ci = 0;

		for (int i = startRow + 1; i < endRow; i++, ci++) {
			cj = 0;
			for (int j = startCol + 1; j < endCol; j++, cj++) {
				tabArray[ci][cj] = sheet.getCell(j, i).getContents();
			}
		}
		return (tabArray);
	}
	
	public static String[][] getTableArray_2(String xlFilePath, String sheetName,
			String tableName) throws Exception {

		String[][] tabArray = null;
		Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));

		Sheet sheet = workbook.getSheet(sheetName);
		// DataProviderExample.OpenDataSource();
		int startRow, startCol, endRow, endCol, ci, cj;
		Cell tableStart = sheet.findCell(tableName);
		startRow = tableStart.getRow();
		startCol = tableStart.getColumn();
		Cell tableEnd = sheet.findCell(tableName, startCol + 1, startRow + 1,
				100, 64000, false);
		endRow = tableEnd.getRow();
		endCol = tableEnd.getColumn();
		System.out.println("startRow=" + startRow + ", endRow=" + endRow + ", "
				+ "startCol=" + startCol + ", endCol=" + endCol);
		tabArray = new String[endRow - startRow - 1][endCol - startCol - 1];
		ci = 0;

		for (int i = startRow + 1; i < endRow; i++, ci++) {
			cj = 0;
			for (int j = startCol + 1; j < endCol; j++, cj++) {
				tabArray[ci][cj] = sheet.getCell(j, i).getContents();
			}
		}
		return (tabArray);
	}
	
	public static String[][] getTableArray_3(String xlFilePath, String sheetName,
			String tableName) throws Exception {

		String[][] tabArray = null;
		Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));

		Sheet sheet = workbook.getSheet(sheetName);
		// DataProviderExample.OpenDataSource();
		int startRow, startCol, endRow, endCol, ci, cj;
		Cell tableStart = sheet.findCell(tableName);
		startRow = tableStart.getRow();
		startCol = tableStart.getColumn();
		Cell tableEnd = sheet.findCell(tableName, startCol + 1, startRow + 1,
				100, 64000, false);
		endRow = tableEnd.getRow();
		endCol = tableEnd.getColumn();
		System.out.println("startRow=" + startRow + ", endRow=" + endRow + ", "
				+ "startCol=" + startCol + ", endCol=" + endCol);
		tabArray = new String[endRow - startRow - 1][endCol - startCol - 1];
		ci = 0;

		for (int i = startRow + 1; i < endRow; i++, ci++) {
			cj = 0;
			for (int j = startCol + 1; j < endCol; j++, cj++) {
				tabArray[ci][cj] = sheet.getCell(j, i).getContents();
			}
		}
		return (tabArray);
	}

	@AfterSuite(alwaysRun = true)
	public static void closeDataSource() {
		workbook.close();
	}

}// end of class
