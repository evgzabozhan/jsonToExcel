package com.zeoblocks;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ExcelFile {

    public void createFile(Map<String, FileData> map, String fileName) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();

//Create a blank sheet

        XSSFSheet sheet = workbook.createSheet("Employee Data");

//Prepare data to be written as an Object[]

        Map<Integer, Object[]> data = new TreeMap<Integer, Object[]>();
        data.put(1, new Object[]{"count", "Parameter", "Required", "Data type", "Format"});
        int count = 2;
        for (String key : map.keySet()) {
            FileData dataObject = map.get(key);
            data.put(count, new Object[]{count, dataObject.getParameter(), dataObject.getRequired(), dataObject.getDataType(), dataObject.getFormat()});
            count++;
        }


//Iterate over data and write to sheet

        Set<Integer> keyset = data.keySet();
        int rownum = 0;
        for (Integer key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Integer)
                    cell.setCellValue((Integer) obj);
            }
        }

//Write the workbook in file system

        try {
            File excel = new File("src/main/resources/" + fileName + ".xlsx");
            if (excel.delete()) {
                System.out.println("File is deleted");
            }
            FileOutputStream out = new FileOutputStream(excel);
            workbook.write(out);
            out.close();
            System.out.println("written successfully on disk.");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}




