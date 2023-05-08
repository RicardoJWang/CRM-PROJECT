package com.powernode.crm.poi;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class CreatExcelTest {
    public static void main(String[] args) throws Exception{
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("学生列表");
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("学号");
        cell = row.createCell(1);
        cell.setCellValue("姓名");
        cell = row.createCell(2);
        cell.setCellValue("年龄");

        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);

        for (int i = 1; i <= 10; i++) {
            row=sheet.createRow(i);
            cell = row.createCell(0);
            cell.setCellValue(100+i);
            cell = row.createCell(1);
            cell.setCellValue("Name"+i);
            cell = row.createCell(2);
            cell.setCellStyle(style);
            cell.setCellValue(20+i);
        }

        OutputStream os = new FileOutputStream("D:\\sqlsever\\poiTest\\studentList.xls");
        wb.write(os);
        os.close();
        wb.close();

        System.out.println("=========creat ok==========");
    }
}
