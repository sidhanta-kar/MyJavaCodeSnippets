/**
 * 
 */
package com.sidco.snippet.excel.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sidco.snippet.util.system.MySystemHandler;

/**
 * @author Sidhanta Kumar Kar
 *
 */
public class MyExcelWriter {

	/**
	 * 
	 */
	public MyExcelWriter() {
		super();
	}
	
	public void writeExcelWorkbook(String file, XSSFWorkbook workbook) throws FileNotFoundException, IOException {
		// Write to ExcelWorkBook File
        new MySystemHandler().verifyFileLocation(file);
        System.out.println("Writing to File");
        FileOutputStream outputFile = null;
		try {
			outputFile = new FileOutputStream(file);
			workbook.write(outputFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				outputFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
        System.out.println("End of Writing to File");
	}
	
	public void writeExcelWorkbookFromCollection(String file, HashMap<String, String[][]> myWorkbook) throws FileNotFoundException, IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		for (Entry<String, String[][]> mySheet : myWorkbook.entrySet()) {
			//Create a new Excel sheet with mentioned name from collection
			XSSFSheet sheet = workbook.createSheet(mySheet.getKey());
						
			for (int i = 0; i < mySheet.getValue().length; i++) {
				//Create a new Row
				XSSFRow row = sheet.createRow(i);
				
				if (mySheet.getValue()[i] != null) {
					for (int j = 0; j < mySheet.getValue()[i].length; j++) {
						//Create a new Cell
						XSSFCell cell = row.createCell(j);
						cell.setCellValue(mySheet.getValue()[i][j]);
						System.out.println("Address: "+ mySheet.getKey() +" [" + i + "][" + j +"] Value: " + mySheet.getValue()[i][j]);
					}
				}
			}
		}
		
		this.writeExcelWorkbook(file, workbook);
	}

}
