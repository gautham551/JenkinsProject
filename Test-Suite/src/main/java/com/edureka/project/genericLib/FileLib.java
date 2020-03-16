package com.edureka.project.genericLib;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
    String commonPath = "./testData/commonData.properties";
    String testScriptPath = "./testData/testScriptData.xlsx";
    FileInputStream fis;

    /**
     * This method is used to read the common data such as URL, Browser, Username from the properties file.
     * 
     * @param sheetName
     * @param rowNum
     * @param celNum
     * @return
     * @throws Throwable
     */
    public String getCommonData(String key) throws Throwable {
        fis = new FileInputStream(commonPath);
        Properties pObj = new Properties();
        pObj.load(fis);
        String data = pObj.getProperty(key);
        return data;

    }

    /**
     * This method will return you the column string value.
     * 
     * @param sheetName
     * @param rowNum
     * @param celNum
     * @return String Value
     * @throws Throwable
     */
    public String getTestScriptData(String sheetName, int rowNum, int celNum) throws Throwable {
        fis = new FileInputStream(testScriptPath);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheet(sheetName);
        Row row = sh.getRow(rowNum);
        Cell cel = row.getCell(celNum);
        String data = cel.getStringCellValue();
        return data;
    }
    
public static void main(String[] args) throws Throwable {
    FileLib fil = new FileLib();
    System.out.println(fil.getTestScriptData("testData", 1, 2));
}
}
