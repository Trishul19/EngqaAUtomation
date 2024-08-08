package com.engqa.TDF.excell.utility;

import org.testng.annotations.Test;

public class ParameterizationTest {
	@Test(priority=1)

	public static void main(String[]args) {
	XLs_Reader Reader=new XLs_Reader("C:\\Users\\Dell\\eclipse-workspace\\TDF\\src\\main\\java\\com\\engqa\\TDF\\testdata\\TDF.xlsx");
	int RowCount=Reader.getRowCount("MSSQL");
	for(int rownumber=2;rownumber<=RowCount;rownumber++ ) {
		
		String Firstname=Reader.getCellData("MSSQL", "name", rownumber);
		System.out.print(Firstname);
	}
	}

}
