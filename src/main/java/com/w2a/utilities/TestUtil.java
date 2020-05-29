package com.w2a.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
//import org.apache.commons.*;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.DataProvider;

import com.org.base.Page;
import com.relevantcodes.extentreports.LogStatus;


public class TestUtil extends Page {

	public static String screenshotPath;
	public static String screenshotName;

	public static void captureScreenshot() {
		try {
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			Date d = new Date();
			screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

			File destFile = new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName);
			System.out.println("DEST FILE CREATED.......");

			FileHandler.copy(srcFile, destFile);
		} catch (IOException e) {
			System.out.println("Not able to copy : Error in TestUtils class.");
			e.printStackTrace();
		}
	}

	@DataProvider(name = "dp")
	public Object[][] getData(Method m) { // method name on which the data provider is used. Name should be same as
//		test.log(LogStatus.INFO, "DataProvider has started.");
		log.debug("Data Provider Called.");
		String sheetName = m.getName();
		
		int rows = excel.getRowCount(sheetName); 			// 1
		int cols = excel.getColumnCount(sheetName); 		// 3
		
		log.info("SheetName: "+sheetName+" Rows: "+rows+" Col: "+cols);
		
		Object[][] data = new Object[rows][1];
		Hashtable<String,String> table = null;
		
		for (int i = 1; i <= rows; i++) {
			table = new Hashtable<String,String>();
			for (int j = 0; j < cols; j++) {
				table.put(excel.getCellData(sheetName, 0, j),excel.getCellData(sheetName, i, j));
//				log.info("Cell data: "+excel.getCellData(sheetName, 0, j));
//				log.info("Cell data: "+excel.getCellData(sheetName, i, j));
				data[i-1][0] = table;
			}
		}
//		System.out.println("	Printing array: ");
//		//Iterarte through the array of Hashtables :
//		for(int i=0;i<data.length;i++) {
//				System.out.println("Key :"+data[i][0]);
//		}
//		
		return data;
	}

	public static boolean isTestRunnable(String testname, ExcelReader excel) {
		log.debug("Is test Runnable Called.");
		String sheetName = "test_Suite";
		int rows = excel.getRowCount(sheetName);
		
		// public String getCellData(String sheetName, int rownum, int colnum)
		for (int rNum = 1; rNum <= rows; rNum++) {
			String testCaseExcel = excel.getCellData(sheetName, rNum, 0);
			
//			System.out.println("Current row reading in sheet "+sheetName+" is "+rNum);
//			System.out.println("Test Case testCaseExcel Name : "+testCaseExcel);
//			
			
			if (testCaseExcel.equalsIgnoreCase(testname)) {
				String runmode = excel.getCellData(sheetName, rNum, 1);
				log.debug("SheetName: "+sheetName+" TestMethod Name(From Excel): "+testCaseExcel+" TestMethod Name passed: "+testname);
				if (runmode.equalsIgnoreCase("Y")) {
					log.debug("Test is runnable");
					return true;
				} else {
					log.debug("Test is Not Runnable");
					return false;
				}
			}
		}
		log.debug("Test Not Runnable due to vague value in TestSuit excel sheet.");
		
		return false;
	}

}
