package com.engqa.TDF.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil {
	public static long PAGE_LOAD_TIMEOUT= 50;
	public static long IMPLICIT_WAIT= 50;
	public static WebDriverWait  wait;
	File source;
	//static String tetstmethodname;

	public static WebDriver driver;
	static WebDriver screenshotdriver;
	
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\diya-trshetty\\eclipse-workspace\\StemWizard\\src\\main\\java\\com\\testdata\\StemWizardTestData.xlsx";

	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;

	
	public static void waitingforainviblity(String name){
	//wait= new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.and(
	ExpectedConditions.invisibilityOfElementLocated(By.xpath("name"))));
}
	
	public static  void failed(WebDriver screenshotdriver, String methodName)  {
		File source= ((TakesScreenshot) screenshotdriver).getScreenshotAs(OutputType.FILE);
		
			try {
				FileUtils.copyFile(source, new File (".\\Screenshots\\"+"Failedshot_"+"\\"+methodName+"_"+".jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}

	
	
	
	
	 
	
	



}
