/**
 * 
 */
package com.sidco.snippet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.sidco.snippet.excel.io.MyExcelReader;
import com.sidco.snippet.excel.io.MyExcelWriter;
import com.sidco.snippet.impl.regex.MyRegexImpl;
import com.sidco.snippet.io.MyFileReader;
import com.sidco.snippet.io.MyFileWriter;
import com.sidco.snippet.util.system.MySystemHandler;


/**
 * @author Sidhanta Kumar Kar
 *
 */
public class Main {

	/**
	 * 
	 */
	public Main() {
		super();
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//File IO
		if (false) {
			try {
				//Reading File
				HashMap<Integer,String> readFile = new MyFileReader("C:\\MyData\\Test uni.txt").readWithBufferedReader(true);
				//Writing File
				new MyFileWriter("C:\\MyData\\TestWrite.txt").writeWithBufferedWriter(readFile,true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//Excel IO - POI
		if (false) {
			try {
				//Reading Excel File
				HashMap<String, String[][]> myWorkbook= new MyExcelReader().readExcelWorkbookAsCollection("C:\\MyData\\Test.xlsx");
				//Writing Excel File
				new MyExcelWriter().writeExcelWorkbookFromCollection("C:\\MyData\\TestW.xlsx", myWorkbook);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//Excel Handling
		//XML IO - JAXB
		//Accessing CMD
		if (false) {
			try {
				ArrayList<String> executedCommand = new MySystemHandler().runProcess("cmd /c dir");
				for (String data : executedCommand) {
					System.out.println(data);
				}
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}
		//Finding files on the system
		if (true) {
			try {
				ArrayList<File> executedCommand = new MySystemHandler().findAllFiles("C:\\MyData\\Migration");
				for (File data : executedCommand) {
					System.out.println(data);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//Regex Sample
		if (false) {
			MyRegexImpl myRegexImpl = new MyRegexImpl("(\\w)(\\w)*[@](\\w)*[\\.](\\w)(\\w)*");
			boolean hasMatch = myRegexImpl.hasMatch("sidhanta.kar@gmail.com");
			System.out.println(hasMatch);
		}
		//Email
		//JDBC Connectivity
		//Hibernate Connectivity
		//UI Designing - Swing
		//UI Designing - JFX
		//Lambda Function Usage

	}

}
