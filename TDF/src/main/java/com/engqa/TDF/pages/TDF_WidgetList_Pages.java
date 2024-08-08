package com.engqa.TDF.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.engqa.TDF.base.TestBase;

public class TDF_WidgetList_Pages extends TestBase {
	
	
	@FindBy(xpath="//i[@class='fas fa-cog']")
	WebElement settings;
	@FindBy(xpath="//a[contains(text(),'Export')]")
	WebElement Export;
	@FindBy(xpath="//a[contains(text(),'Import')]")
	WebElement Import;
	@FindBy(xpath="//a[contains(text(),'Account Settings')]")
	WebElement AccountSettings;
	@FindBy(xpath="//a[contains(text(),'Log Out')]")
	WebElement Logout;
	 
	
	public TDF_WidgetList_Pages()throws IOException {
		super();
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickonExport() throws InterruptedException {
		

		settings.click();
		Export.click();

		
	}
	
	
public void clickonImport() {
		
	Actions action= new Actions(driver);
	action.moveToElement(settings).build().perform();
	Import.click();
	
	}


public void clickonAccountSettings() {
	
	Actions action= new Actions(driver);
	action.moveToElement(settings).build().perform();
	AccountSettings.click();
	
}


public void clickononlogout() {
	
	Actions action= new Actions(driver);
	action.moveToElement(settings).build().perform();
	Logout.click();
	
}
	

}
