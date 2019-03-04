/**
 * 
 */
package com.sidco.snippet.excel.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Sidhanta Kumar Kar
 *
 */
public class MyExcelReader {

	/**
	 * 
	 */
	public MyExcelReader() {
		super();
	}
	
	public XSSFWorkbook readExcelWorkbook(String file) throws FileNotFoundException, IOException {
		return new XSSFWorkbook(new FileInputStream(file));
	}
	
	public HashMap<String, String[][]> readExcelWorkbookAsCollection(String file) throws FileNotFoundException, IOException {
		HashMap<String, String[][]> myWorkbook = new HashMap<String, String[][]>();
		
		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));
		
		for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
			XSSFSheet sheet = workbook.getSheetAt(sheetNum);
			//Sheet name
			//String[][] mySheet = new String [sheet.getLastRowNum()+1][this.getLastColumnNum(sheet)];
			String[][] mySheet = new String [sheet.getLastRowNum()+1][];
			for (int rowNum = sheet.getFirstRowNum(); rowNum <= sheet.getLastRowNum(); rowNum++) {
				XSSFRow row = sheet.getRow(rowNum);
				if (row != null) {
					mySheet[rowNum] = new String[row.getLastCellNum()];
					for (int cellNum = row.getFirstCellNum(); cellNum < row.getLastCellNum(); cellNum++) {
						XSSFCell cell = row.getCell(cellNum);
						//System.out.println("Address: "+ sheet.getSheetName() +" [" + cellNum + "][" + rowNum +"] Value: " + cell.getStringCellValue());
						mySheet[rowNum][cellNum] = cell.getStringCellValue();
					}
				}
				
			}
			System.out.println(sheet.getSheetName());
			myWorkbook.put(sheet.getSheetName(), mySheet);
		}
		return myWorkbook;
	}

}
