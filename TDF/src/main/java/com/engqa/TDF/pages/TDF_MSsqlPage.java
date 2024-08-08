package com.engqa.TDF.pages;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.engqa.TDF.base.TestBase;

public class TDF_MSsqlPage extends TestBase{
	@FindBy(xpath="//h4[contains(text(),'MS SQL')]")
	@CacheLookup
	WebElement Mssqlheader;
	
	@FindBy(xpath="//input[@id='name']")
	
	WebElement Name;
	
	@FindBy(xpath="//input[@id='code']")
	
	WebElement Alias;
	
	@FindBy(xpath="//input[@id='server']")
	
	WebElement serverinstance;

	@FindBy(xpath="//input[@id='database']")
	
	WebElement Database;

	@FindBy(xpath="//input[@id='table']")
	
	WebElement Tablename;
	
	@FindBy(xpath="//input[@value='view']")
	
	WebElement Radioview;
	
	@FindBy(xpath="//input[@value='table']")
	
	WebElement Radiotable;

	@FindBy(xpath="//input[@id='username']")
	
	WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	
	WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'Add Connection')]")
	
	WebElement Addconncetion;
	
	
	@FindBy(xpath="//button[contains(text(),'MS SQL')]")
	WebElement MSSQL;
	
	
	public TDF_MSsqlPage()throws IOException {
		super();
		PageFactory.initElements(driver, this);
		
	}
	
	public String VerifyMSsqlTittle() {

		return Mssqlheader.getText();
	}

public TDF_DataSourceConfiguration_Page  TDF_MSSQL_Configurationpage(String name,String alias,String ServerAddress,String Databaseocm,String TableorView,String DbTable,String Username,String Password) throws IOException, InterruptedException{
		
	Name.sendKeys(name);
	Alias.sendKeys(alias);
	serverinstance.sendKeys(ServerAddress);
	Database.sendKeys(Databaseocm);
	driver.findElement(By.xpath("//input[@value='"+ TableorView +"']")).click();
	username.sendKeys(Username);
	Tablename.sendKeys(DbTable);
	password.sendKeys(Password);
   Addconncetion.click();
   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'MS SQL')]"))).click();
  
   //MSSQL.click();
   
//	driver.findElement(By.xpath("//button[@data-dismiss='modal']")).click();
	
		
		
		
		return new TDF_DataSourceConfiguration_Page();
		
		
	}


}
