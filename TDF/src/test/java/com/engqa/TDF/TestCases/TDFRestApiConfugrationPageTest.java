package com.engqa.TDF.TestCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.engqa.TDF.base.TestBase;
import com.engqa.TDF.pages.TDF_DataSourceConfiguration_Page;
import com.engqa.TDF.pages.TDF_RestAPI_Pages;

public class TDFRestApiConfugrationPageTest extends TestBase {
	TDF_DataSourceConfiguration_Page Datasourceconfigpage;
	TDF_RestAPI_Pages RestApiPage;
	public TDFRestApiConfugrationPageTest() throws IOException {
		super();// calling constructor of parent class
		
	}
	
	//@BeforeMethod
	@BeforeClass
	public void setup() throws IOException {
	initialization();
	Datasourceconfigpage = new TDF_DataSourceConfiguration_Page();
	RestApiPage = new TDF_RestAPI_Pages();
	Datasourceconfigpage.clickonrestAPI();
	}
	
	
	@Test(priority=1)
	
	public void VerifytitleResetapi() {
		String Restapiheader=RestApiPage.VerifyRestAPIpage();
	Assert.assertEquals(Restapiheader, "Rest API","Missmatch in Header" );
	}
	
	@Test(priority=2)
	public void EnterRestAPidata()throws IOException {
		Datasourceconfigpage=RestApiPage.CreateRestAPidata(prop.getProperty("radio"),prop.getProperty("Name"), prop.getProperty("Alias"), prop.getProperty("schemraurl"),prop.getProperty("Media"), prop.getProperty("HttpMetod"), prop.getProperty("Datatsourceurl"), prop.getProperty("schemaname"),prop.getProperty("Nestedobjpath"),prop.getProperty("Rawtext"));
		
	
}}
