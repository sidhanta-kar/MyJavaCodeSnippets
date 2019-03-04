/**
 * 
 */
package com.sidco.snippet.excel.handling;


import java.awt.Color;

import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;

/**
 * @author Sidhanta Kumar Kar
 *
 */
public class MyExcelHandler {

	/**
	 * 
	 */
	public MyExcelHandler() {
		super();
	}
	
	public static XSSFCellStyle MyStyle;
	
	//Should support ENUM and RGB
	public static void setForegroundColor(MyColours myColour){
		MyStyle.setFillForegroundColor(IndexedColors.VIOLET.getIndex());
		MyStyle.setFillForegroundColor(new XSSFColor(Color.GREEN));
		
	}
	//Set Alignment H/V
	//public static void setAlignment(HorizontalAlignment h,VerticalAlignment v)
	//Set Border
	//public static void setBorder(BorderSides bs,BorderStyle style)
	//Set Border Color
	//public static void setBorderColor(MyColours myColour)
	//Set Background Color
	//public static void setBackgroundColor(MyColours myColour)
	//Set Foreground Color
	//public static void setForegroundColor(MyColours myColour)
	//Set Fill Pattern
	//public static void setFillPattern(FillPatternType fillPatternType)
	//Set Font
	//public static void setFont
	//Set Hidden
	//public static void setHidden(boolean hidden)
	//Set Locked
	//public static void setLocked(boolean locked)
	//Set WarpText
	//public static void setWarpText(boolean wrapped)
	
	

}
