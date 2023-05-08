package com.powernode.crm.poi;

import com.bjpowernode.crm.commons.utils.HSSFUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.InputStream;

public class ParseExcelTest {
    public static void main(String[] args) throws Exception{
        InputStream is = new FileInputStream("D:\\sqlsever\\poiTest\\activityList.xls");
        HSSFWorkbook workbook = new HSSFWorkbook(is);
        HSSFSheet sheet =null;
        HSSFRow row =null;
        HSSFCell cell =null;
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            sheet = workbook.getSheetAt(i);
            for (int j = 0; j < sheet.getLastRowNum()+1; j++) {
                row = sheet.getRow(j);
                for (int k = 0; k < row.getLastCellNum(); k++) {
                    cell = row.getCell(k);
                    System.out.print(HSSFUtils.getCellValueForStr(cell)+" ");
                }
                System.out.println();
            }
        }

    }
}
