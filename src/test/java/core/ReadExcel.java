package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcel {

	//public static final Logger logger = LogManager.getLogger("Read Data From Excel file");
	public static String dataTest = System.getProperty("user.dir")+ File.separator + "data" + File.separator +  "data.xls";
	private Object[][] excelData = null;
	private String testName;
	private String rawData=null;
	private List<String[]> varArray = new ArrayList<String[]>();
	private String[] dataArray;
	
	public ReadExcel() {
		
	}
	
	public ReadExcel(String testName) {
		Object [][] arrayObject = getExcelData(dataTest,"Test Data");
		this.excelData = arrayObject;
		this.testName = testName;
		extractVar();
	}

	//Get configuration - for Mitel
	public static String getConfigData(String key) {
		Object[][] arrayObject = getExcelData(dataTest,"Configuration");
		String value = null;
		for (int i = 0; i < arrayObject.length; i++) {
			if (arrayObject[i][0].toString().toLowerCase().equals(key.toLowerCase())) {
				value = arrayObject[i][1].toString();
				break;
			}
		}
		if (value == null) {
			System.out.println("Unable to find test case");
		}
		return value;
	}

	//Get device information - for Mitel
	public static String getDeviceInfo(String deviceName, String key) {
		return getSheetInfo("Device Information", deviceName, key);

	}
	
	//Get data user - for Mitel
	public static String getDataUser(String ID, String key) {
		return getSheetInfo("Data User", ID, key);
	}
	
	//Get system Info - for Mitel
	public static String getSystemInfo(String SystemID, String key) {
		return getSheetInfo("System", SystemID, key);
	}
	
	//Get information of tested device (as DeviceID, UserID, URL Appium)
	public static String getDeviceTest(String deviceTestID, String key) {
		return getSheetInfo("DeviceTest", deviceTestID, key);
	}
	
	public static String getSheetInfo(String sheetName, String ID, String key) {
		Object[][] arrayObject = getExcelDataFull(dataTest, sheetName);
		String value = null;
		int colNumber = -1;
		for (int i = 0; i < arrayObject[0].length; i++) {
			if (arrayObject[0][i].toString().toLowerCase().equals(key.toLowerCase())) {
				colNumber = i;
				break;
			}
		}
		for (int i = 0; i < arrayObject.length; i++) {
			if (arrayObject[i][0].toString().toLowerCase().equals(ID.toLowerCase())) {
				value = arrayObject[i][colNumber].toString();
				break;
			}
		}
		if (value == null) {
			System.out.println("Unable to find data: " + ID);
		}
		return value;
	}
	
	public static String[][] getExcelData(String fileName, String sheetName) {
		String[][] arrayExcelData = null;
		try {
			FileInputStream fs = new FileInputStream(fileName);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet(sheetName);

			int totalNoOfCols = sh.getColumns();
			int totalNoOfRows = sh.getRows();

			arrayExcelData = new String[totalNoOfRows - 1][totalNoOfCols];

			for (int i = 1; i < totalNoOfRows; i++) {

				for (int j = 0; j < totalNoOfCols; j++) {
					arrayExcelData[i - 1][j] = sh.getCell(j, i).getContents();
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		}
		return arrayExcelData;
	}
	
	public static String[][] getExcelDataFull(String fileName, String sheetName) {
		String[][] arrayExcelData = null;
		try {
			FileInputStream fs = new FileInputStream(fileName);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet(sheetName);

			int totalNoOfCols = sh.getColumns();
			int totalNoOfRows = sh.getRows();

			arrayExcelData = new String[totalNoOfRows][totalNoOfCols];

			for (int i = 0; i < totalNoOfRows; i++) {

				for (int j = 0; j < totalNoOfCols; j++) {
					arrayExcelData[i][j] = sh.getCell(j, i).getContents();
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		}
		return arrayExcelData;
	}
	
	private void extractVar() {
		for (int i = 0; i < excelData.length; i++) {
			//System.out.println("TEST NAME: " + excelData[i][0].toString().toLowerCase());
			if (excelData[i][0].toString().toLowerCase().equals(testName.toLowerCase())) {
				rawData = excelData[i][2].toString();
				break;
			}
		}
		if (rawData == null) {
			System.out.println("Unable to find test case");
		}
		else {
			dataArray = rawData.split("\n");
			for (int i = 0; i < dataArray.length; i++) {
				varArray.add(i, dataArray[i].split("="));
			}
		}
	}
	
	public String getVar(String varName){
		String result = null;
		for (int i = 0; i < varArray.size(); i++) {
			if (varArray.get(i)[0].equals(varName)) {
				result = varArray.get(i)[1];
				break;
			}
		}
		if(result == null) System.out.println("Unable to find variable " + varName);
		return result;
	}

}
