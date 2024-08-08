package com.engqa.TDF.pages;

import java.io.IOException;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import com.engqa.TDF.base.TestBase;



public class TDF_DataSourceConfiguration_Page extends TestBase{
	
	
	@FindBy(xpath="//button[contains(text(),'Rest API')]")
	WebElement RestApi;
	@FindBy(xpath="//button[contains(text(),'MS SQL')]")
	WebElement MSSQL;
	@FindBy(xpath="//button[contains(text(),'PostgreSQL')]")
	WebElement PostgreSQL;
	@FindBy(xpath="//button[contains(text(),'MySQL')]")
	WebElement MySQL;
	@FindBy(xpath="//button[contains(text(),'Redis Cache')]")
	WebElement Redis;
	@FindBy(xpath="//button[contains(text(),'CSV')]")
	WebElement CSV;
	@FindBy(xpath="//button[contains(text(),'Text File')]")
	WebElement TextFile;
	@FindBy(xpath="//img[@title='Tetherfi']")
	WebElement logo;
	
	
	
	public TDF_DataSourceConfiguration_Page()throws IOException {
		super();
		PageFactory.initElements(driver, this);
		
	}
	
	
public String TDF_DataSourceConfiguration_PageTittle() {		

	return driver.getTitle();
	}
	
	
	public boolean TDFlogo() {
		return logo.isDisplayed();
		
	}
	
	public void RestApi() {
		 RestApi.isDisplayed();
		
	}
	
	public void MSSQL() {
		MSSQL.isDisplayed();
		
	}
	public boolean PostgreSQL() {
		return PostgreSQL.isDisplayed();
		
	}
	public boolean MySQL() {
		return MySQL.isDisplayed();
		
	}
	public boolean Redis() {
		return Redis.isDisplayed();
		
	}
	public boolean CSV() {
		return CSV.isDisplayed();
		
	}
	public boolean TextFile() {
		return TextFile.isDisplayed();
		
	}
	
	public void clickonrestAPI() {
		RestApi.click();
		
	}
	//Landing page
		public TDF_RestAPI_Pages clickonRestApi() throws IOException {
		RestApi.click();
		return new TDF_RestAPI_Pages();
		
	}
		
		public TDF_MSsqlPage clickonMssql() throws IOException {
			MSSQL.click();
			return new TDF_MSsqlPage();
			
		}
	
	
	

}
