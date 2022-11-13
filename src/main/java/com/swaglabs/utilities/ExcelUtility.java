package com.swaglabs.utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtility {

    public String readSingleData(int i, int j,String sheetName) {
        String filePath=System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx";
        FileInputStream inputStream=null;
        try {
            inputStream = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb=null;
        try {
            wb = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        XSSFSheet sheet = wb.getSheet(sheetName);
        Row r = sheet.getRow(i);
        Cell c = r.getCell(j);
        DataFormatter formatter = new DataFormatter();
        String value = formatter.formatCellValue(sheet.getRow(i).getCell(j));
        return value;
    }
    /*public String[][] readDataFromExcel(String sheetName) throws IOException {
        String filePath=System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx";
        FileInputStream file=new FileInputStream(filePath);
        XSSFWorkbook workbook=new XSSFWorkbook(file);
        XSSFSheet sheet=workbook.getSheet(sheetName);
        int row_count=sheet.getLastRowNum();
        int coln_count=sheet.getRow(0).getLastCellNum();

        String [][]data=new String[row_count][coln_count];
        for(int i=1;i<row_count;i++){
            for(int j=0;j<coln_count;j++){
                DataFormatter formatter=new DataFormatter();
                data[i-1][j]=formatter.formatCellValue(sheet.getRow(i).getCell(j));
            }
            System.out.println();
        }
        workbook.close();
        file.close();
        return data;
    }*/
}
