package com.engqa.TDF.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import com.engqa.TDF.base.TestBase;
import com.engqa.TDF.excell.utility.ExcelReader;
import com.engqa.TDF.excell.utility.XLs_Reader;
import com.engqa.TDF.pages.TDF_DataSourceConfiguration_Page;
import com.engqa.TDF.pages.TDF_MSsqlPage;


public class TDF_MS_SQL_ConfugrationPage_Test extends TestBase {
	TDF_DataSourceConfiguration_Page Datasourceconfigpage;
	TDF_MSsqlPage MSSQLPage;
	XLs_Reader reader;
	ExcelReader akshireader;
	WebDriver driver2;
	
	@FindBy(xpath="//button[contains(text(),'MS SQL')]")
	WebElement MSSQL;
	
	public TDF_MS_SQL_ConfugrationPage_Test() throws IOException {
		super();// calling constructor of parent class
		
	}
	
	//@BeforeMethod
	@BeforeClass
	public void setup() throws IOException {
	initialization();
	Datasourceconfigpage = new TDF_DataSourceConfiguration_Page();
	MSSQLPage = new TDF_MSsqlPage();
	//reader= new Xls_Reader();
	reader=new XLs_Reader("C:\\Users\\Dell\\eclipse-workspace\\TDF\\src\\main\\java\\com\\engqa\\TDF\\testdata\\TDF.xlsx");
	akshireader=new ExcelReader("C:\\Users\\Dell\\eclipse-workspace\\TDF\\src\\main\\java\\com\\engqa\\TDF\\testdata\\TDF.xlsx","MSSQL");
	Datasourceconfigpage.clickonMssql();
	
	}
	
//	@AfterMethod
//	public void teardown() {
//		driver.quit();
//	}
	
	
	@Test(priority=1)
	
	public void VerifytitleMSSQL() {
		String Restapiheader=MSSQLPage.VerifyMSsqlTittle();
	Assert.assertEquals(Restapiheader, "MS SQL","Missmatch in Header" );
	}
	
	
@Test(priority=2)
	
	public void FillMssqlData() throws IOException, InterruptedException {
	MSSQLPage.TDF_MSSQL_Configurationpage(reader.getCellData("MSSQL","name",2), reader.getCellData("MSSQL", "Alias", 2), reader.getCellData("MSSQL", "Schema_Instance", 2), reader.getCellData("MSSQL", "Database", 2), reader.getCellData("MSSQL", "Table_View", 2), reader.getCellData("MSSQL", "TableValue", 2), reader.getCellData("MSSQL", "Username", 2), reader.getCellData("MSSQL", "Password", 2));
	//XLs_Reader Reader=new XLs_Reader("C:\\Users\\Dell\\eclipse-workspace\\TDF\\src\\main\\java\\com\\engqa\\TDF\\testdata\\TDF.xlsx");
	
	
	int RowCount=reader.getRowCount("MSSQL");
	for(int rownumber=3;rownumber<=RowCount;rownumber++ ) {
		
MSSQLPage.TDF_MSSQL_Configurationpage(reader.getCellData("MSSQL","name",rownumber), reader.getCellData("MSSQL", "Alias",rownumber), reader.getCellData("MSSQL", "Schema_Instance", rownumber), reader.getCellData("MSSQL", "Database", rownumber), reader.getCellData("MSSQL", "Table_View",rownumber), reader.getCellData("MSSQL", "TableValue", rownumber), reader.getCellData("MSSQL", "Username", rownumber), reader.getCellData("MSSQL", "Password", rownumber));

//MSSQL.click();



	}
	
	
}


}
