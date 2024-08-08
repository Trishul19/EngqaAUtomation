package com.engqa.TDF.excell.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
    private String filePath;
    static FileInputStream fileInputStream = null;
    private XSSFWorkbook xssfWorkbook = null;
    private XSSFSheet xssfSheet = null;
    private XSSFRow row = null;
    private XSSFCell cell = null;


   public ExcelReader(String filePath,String sheetName) throws IOException {
//    public ExcelReader(String sheetName) throws IOException {

        this.filePath = filePath;

        try {
            fileInputStream = new FileInputStream(filePath);
            xssfWorkbook = new XSSFWorkbook(fileInputStream);
            xssfSheet = xssfWorkbook.getSheet(sheetName);
            fileInputStream.close();
        }catch (FileNotFoundException ex){
            System.out.println("Enter valid file name");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String readCellData(int rowNum, int colNum) {

        String value = null;
        row = xssfSheet.getRow(rowNum);
        cell = row.getCell(colNum);

        if(cell!=null) {
            CellType type = cell.getCellType();
            if(type == CellType.FORMULA){
                value = cell.getRawValue();
            }
            else if (type == CellType.STRING) {
                value = cell.getStringCellValue();
            }
            else if (type == CellType.NUMERIC) {
            	if(DateUtil.isCellDateFormatted(cell)){
                   DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
                  Date date=(Date) cell.getDateCellValue();
                  value=dateFormat.format(date);
            	}
            	else{
            	value = String.valueOf(cell.getNumericCellValue());
				}
            } else if(type == CellType.BOOLEAN){value = String.valueOf(cell.getBooleanCellValue());}
            //else{value=null;}
		}//else{value=null;}
        return value;
        }
    public String readCellDataNew(int rowNum, int colNum) {
        String value = null;
        row = xssfSheet.getRow(rowNum);
        cell = row.getCell(colNum);
        if(cell!=null) {
            CellType type = cell.getCellType();
            if(type == CellType.STRING){
                value = cell.getStringCellValue();
            }else if(type==CellType.NUMERIC){
                if (DateUtil.isCellDateFormatted(cell)) {
                    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    Date date = (Date) cell.getDateCellValue();
                    value = dateFormat.format(date);
                }else {value = cell.getRawValue();;}
            }
            else if (type == CellType.FORMULA) {
                try {
                    if (DateUtil.isCellDateFormatted(cell)) {
                        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                        Date date = (Date) cell.getDateCellValue();
                        value = dateFormat.format(date);
                    }else {value = cell.getRawValue();;}
                } catch (IllegalStateException e) {
                    value = cell.getRawValue();
                }
            }else{
                value = cell.getRawValue();
            }
        }else{
            value="";
        }
        return value;
    }
    public List<Map<String, String>> getTestData() {
        List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();
        int rowCount = xssfSheet.getLastRowNum();
        Map<String, String> map;
        int i = 0;
        row = xssfSheet.getRow(0);
        int lastCellNum=row.getLastCellNum();
        for (int k = 1; k <= rowCount; k++) {
            map = new HashMap<String, String>();
            for (int j = 0; j < lastCellNum; j++) {
                map.put(readCellData(i, j), readCellData(k, j));
            }
            mapList.add(map);
        }

        return mapList;

    }
    public List<Map<String, String>> getTestDataNew() {
        List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();
        int rowCount = xssfSheet.getLastRowNum();
        Map<String, String> map;
        int i = 0;
        row = xssfSheet.getRow(0);
        int lastCellNum=row.getLastCellNum();
        for (int k = 1; k <= rowCount; k++) {
            map = new HashMap<String, String>();
            for (int j = 0; j < lastCellNum; j++) {
                map.put(readCellDataNew(i, j), readCellDataNew(k, j));
            }
            mapList.add(map);
        }

        return mapList;

    }
    public void removeRow(int i) throws IOException {
        XSSFRow removingRow=xssfSheet.getRow(i);
        xssfSheet.removeRow(removingRow);
        int rowCount = xssfSheet.getLastRowNum();
        xssfSheet.shiftRows(i+1,rowCount,-1);
        FileOutputStream outFile = new FileOutputStream(new File(filePath));
        xssfWorkbook.write(outFile);
    }

    public void writeTestData(int i, String [] input){
        try {
        row = xssfSheet.createRow(i);
        for(int l=0;l<input.length;l++){
            cell=row.createCell(l);
            cell.setCellValue(input[l]);
        }
        xssfWorkbook.write(new FileOutputStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void sortSheet(int column, int rowStart) {
//        boolean sorting = true;
//        int lastRow = xssfSheet.getLastRowNum();
//        while (sorting) {
//            sorting = false;
//            for (Row row : xssfSheet) {
//                if (row.getRowNum() < rowStart) continue;
//                if (lastRow == row.getRowNum()) break;
//                Row nextRow = xssfSheet.getRow(row.getRowNum() + 1);
//                if (nextRow == null) continue;
//                System.out.println("row value"+row.getCell(column).getDateCellValue());
//                Date firstValue = row.getCell(column).getDateCellValue() ;
//                Date secondValue = nextRow.getCell(column).getDateCellValue() ;
//                if (secondValue.before(firstValue)) {
//                    xssfSheet.shiftRows(nextRow.getRowNum(), nextRow.getRowNum(), -1);
//                    xssfSheet.shiftRows(row.getRowNum(), row.getRowNum(), 1);
//                    sorting = true;
//                }
//            }
//        }
//    }
}
