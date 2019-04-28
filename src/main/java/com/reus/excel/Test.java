/**
 * Reus
 * Copyright (C), 2011 - 2018, Reus.
 */
package com.reus.excel;

import java.io.IOException;
import java.util.List;

/**
 * @version $Id: Test.java, v 0.1 2018-09-20 reus Exp $
 * @ClassName: Test
 * @Description:
 * @author: reus
 */
public class Test {
    public static void main(String[] args) throws IOException {
        String name = "wcx.xlsx";
        List<List<List<String>>> lists = ExcelExtract.extractDataFromExcel(name);
        System.out.println(lists);
    }
}