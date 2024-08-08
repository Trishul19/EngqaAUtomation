package com.engqa.TDF.TestCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.engqa.TDF.base.TestBase;
import com.engqa.TDF.pages.TDF_DataSourceConfiguration_Page;
import com.engqa.TDF.pages.TDF_RestAPI_Pages;

public class TDFDatasourceConfigurationPageTest extends TestBase {
	TDF_DataSourceConfiguration_Page Datasourceconfigpage;
	TDF_RestAPI_Pages RestApiPage;
	
	public TDFDatasourceConfigurationPageTest() throws IOException {
		super();// calling constructor of parent class
		
	}
	
@BeforeMethod
	public void setup() throws IOException {
	initialization();
	Datasourceconfigpage = new TDF_DataSourceConfiguration_Page();
	}

@AfterMethod
public void teardown() {
	driver.quit();
}
	
	@Test(priority = 1)
	public void VerifyTitle() throws IOException {
	String Title =Datasourceconfigpage.TDF_DataSourceConfiguration_PageTittle();
	System.out.println("This is" +Title);
	Assert.assertEquals(Title, "Dashboard Configuration");
	
	
	}
	
	@Test(priority = 2)
	
	public void VerifyTypesofdatasource() throws IOException {
Datasourceconfigpage.TDFlogo();
Datasourceconfigpage.MSSQL();
Datasourceconfigpage.MySQL();
Datasourceconfigpage.PostgreSQL();
Datasourceconfigpage.Redis();
Datasourceconfigpage.RestApi();
Datasourceconfigpage.TextFile();
			
		
	}
	
	
@Test(priority = 3)
	
	public void VerifyLogo() throws IOException {
	boolean flag=Datasourceconfigpage.TDFlogo();
	Assert.assertTrue(flag);

	}



@Test(priority = 4)

public void NavigatetoRestAPiPage() throws IOException {
	RestApiPage=Datasourceconfigpage.clickonRestApi();
}
}


