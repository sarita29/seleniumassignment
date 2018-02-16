package com.sample.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetDataFromExcel {
	private static String s = "Sheet1";
	private static String s1 = "F:/Sarita/workspace/automation/src/test/resources/testdata/datasheet.xlsx";
	private static Map<String, String> map = new HashMap<String, String>();

	public String get(String testcasename, String columnname) throws IOException {
		FileInputStream fis;
		int k = 0;
		try {
			fis = new FileInputStream(s1);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet ws = wb.getSheet(s);
			int rows = ws.getPhysicalNumberOfRows();
			for (int i = 0; i < rows; i++) {
				int cols = ws.getRow(0).getPhysicalNumberOfCells();
				for (int j = 0; j < cols; j++) {
					if (ws.getRow(i).getCell(j, Row.CREATE_NULL_AS_BLANK).toString().replace(".0", "")
							.equalsIgnoreCase(columnname)) {
						k = j;
					}
					map.put(ws.getRow(i).getCell(0,Row.CREATE_NULL_AS_BLANK).toString().replace(".0", ""),
							 ws.getRow(i).getCell(k,Row.CREATE_NULL_AS_BLANK).toString().replace(".0", "")); 
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map.get(testcasename);
	}
}
