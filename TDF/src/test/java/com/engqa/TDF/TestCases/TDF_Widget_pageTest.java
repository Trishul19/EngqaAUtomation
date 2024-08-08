package com.engqa.TDF.TestCases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.engqa.TDF.base.TestBase;
import com.engqa.TDF.pages.TDF_DataSourceConfiguration_Page;
import com.engqa.TDF.pages.TDF_RestAPI_Pages;
import com.engqa.TDF.pages.TDF_WidgetList_Pages;

public class TDF_Widget_pageTest extends TestBase {
	TDF_WidgetList_Pages WidgetListPage;
	
	
	
		
		public TDF_Widget_pageTest() throws IOException {
			super();// calling constructor of parent class
			
			
		}
		
		@BeforeMethod
		public void setup() throws IOException {
		initialization();
		WidgetListPage = new TDF_WidgetList_Pages();
		}
		
		
		@Test(priority = 1)
		public void clickonExport() throws InterruptedException {
			WidgetListPage.clickonExport();
		}

		
		
		

}
