/**
 * Reus
 * Copyright (C), 2011 - 2018, Reus.
 */
package com.reus.excel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @version $Id: ExcelExtract.java, v 0.1 2018-09-20 reus Exp $
 * @ClassName: ExcelExtract
 * @Description:
 * @author: reus
 */
public class ExcelExtract {

    private static final Logger logger = LoggerFactory.getLogger(ExcelExtract.class);

    /**
     * 解析Excel表格
     * @param name
     * @return
     */
    public static List<List<List<String>>> extractDataFromExcel(String name) {
        File file = new File(name);
        Workbook workbook = null;
        List<List<List<String>>> works = new ArrayList<>();
        try {
            // 获得工作簿
            workbook = WorkbookFactory.create(file);
            // 获得工作表个数
            int sheetCount = workbook.getNumberOfSheets();
            //遍历工作表
            for (int i = 0; i < sheetCount; i++) {
                List<List<String>> sheets = new ArrayList<>();
                //获取工作表
                Sheet sheet = workbook.getSheetAt(i);
                //获取表格总行数
                int rows = sheet.getLastRowNum() + 1;
                //遍历所有的行
                for (int row = 0; row < rows; row++) {
                    //获取行
                    Row r = sheet.getRow(row);
                    //获取列数
                    int cols = r.getPhysicalNumberOfCells();
                    List<String> list = new ArrayList<>();
                    //遍历行中所有的列
                    for (int col = 0; col < cols; col++) {
                        //获取单元格
                        Cell cell = r.getCell(col);
                        //将所有的单元格设置为字符串
                        cell.setCellType(CellType.STRING);
                        String value = cell.getStringCellValue();
                        list.add(value);
                    }
                    sheets.add(list);
                }
                works.add(sheets);
            }

        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (workbook != null)
                try {
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return works;
        }
    }

}