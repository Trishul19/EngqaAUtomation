package com.engqa.TDF.pages;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.engqa.TDF.base.TestBase;

public class TDF_RestAPI_Pages extends TestBase{
	@FindBy(xpath="//h4[contains(text(),'Rest API')]")
	WebElement RestApiheader;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement Name;
	
	@FindBy(xpath="//input[@id='code']")
	WebElement Alias;
	
	@FindBy(xpath="//input[@id='code']")
	WebElement schemaurl;
	
	@FindBy(xpath="//textarea[@name='dataSchemaUrl']")
	WebElement MediaTypeJson;
	
	@FindBy(xpath="//option[contains(text(),'TEXT')]")
	WebElement MediaTypeJsonmain;
	
	@FindBy(xpath="//select[@id='mediaType']")
	WebElement MediaTypetext;
	
	
	@FindBy(xpath="//input[@type='radio']")
	WebElement Radiobuttonschema;
	
	@FindBy(xpath="//div[@class='form-group'][2]")
	WebElement Radiobuttonschema2;
	
	@FindBy(xpath="//select[@name='mediaType']")
	WebElement Httpmethod;
	
	@FindBy(xpath="//select[@id='httpMethod']")
	WebElement HttpmethodGet;
	@FindBy(xpath="//option[contains(text(),'POST')]")
	WebElement HttpmethodPost;
	@FindBy(xpath="//input[@value='url']")
	WebElement Radiobuttonschemaurl;
	@FindBy(xpath="//input[@value='json']")
	WebElement jsonupload;
	@FindBy(xpath="//input[@value='noschema']")
	WebElement noschema;
	
	@FindBy(xpath="//textarea[@name='dataSourceUrl']")
	WebElement Datasourceurl;
	
	@FindBy(xpath="//input[@id='schema']")
	WebElement Schemaname;
	
	
	@FindBy(xpath="//input[@name='dataSchemaUrl']")
	WebElement dataschemaurl;
	
	
	@FindBy(xpath="//input[@id='nestedObjectPath']")
	WebElement Nestedelement;
	
	@FindBy(xpath="//input[@id='username']")
	WebElement Username;
	@FindBy(xpath="//input[@id='password']")
	WebElement Password;
	
	@FindBy(xpath="//textarea[@id='rawText']")
	WebElement Rawtext;
	
	@FindBy(xpath="//button[contains(text(),'Add Connection')]")
	WebElement Addconncetion;
	
	
	public TDF_RestAPI_Pages()throws IOException {
		super();
		PageFactory.initElements(driver, this);
		
	}
	
	public String VerifyRestAPIpage() {

		return RestApiheader.getText();
	}

public TDF_DataSourceConfiguration_Page CreateRestAPidata(String radio,String name,String alias,String schenarurl,String Mediatype,String methods,String datsourceurl,String schemaname,String Nestedobjpath,String rawtext) throws IOException{
		

	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    Date now = new Date(0);
    String timestamp = sdf.format(now);
		
		
		driver.findElement(By.xpath("//input[@value='"+ radio +"']")).click();
		Name.sendKeys(name + timestamp );
		Alias.sendKeys(alias);
		dataschemaurl.sendKeys(schenarurl);
		Select Mediatype1 = new Select(MediaTypetext);
		Mediatype1.selectByVisibleText(Mediatype);
		Select methodseloect = new Select(HttpmethodGet);
		methodseloect.selectByVisibleText(methods);
		Datasourceurl.sendKeys(datsourceurl);
		Schemaname.sendKeys(schemaname);
		Nestedelement.sendKeys(Nestedobjpath);
		Rawtext.sendKeys(rawtext);
		Addconncetion.click();
		return new TDF_DataSourceConfiguration_Page();
		
		
	}
		
		
		
		 
        
        
		
		
		
	}


