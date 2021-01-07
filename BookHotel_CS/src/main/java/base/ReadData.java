package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {
	
	public String readData(String colName) throws IOException
	{
		FileInputStream fis = new FileInputStream(new File("C:\\Users\\ej758824\\Selenium\\BookHotel_CS\\BookHotel\\src\\test\\resources\\testData\\PersonalDetails.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet AcctDetails = workbook.getSheetAt(0);
		String colValue= "";
		for(int i=1;i<AcctDetails.getLastRowNum();i++)
		{
			XSSFRow row = AcctDetails.getRow(i);
					
			if(row.getCell(0).getStringCellValue().equalsIgnoreCase(colName)) {
				colValue = row.getCell(1).getStringCellValue();
			}
		}
		workbook.close();
		
		return colValue;
		
	}

}
