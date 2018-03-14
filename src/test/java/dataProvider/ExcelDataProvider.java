package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider 
{

	XSSFWorkbook wb;
	
	public ExcelDataProvider() {
		
		File src=new File("./ApplicationTestData/AppData.xlsx");
		try 
		{
			
			FileInputStream fis=new FileInputStream(src);
			wb= new XSSFWorkbook(fis);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception in the code"+e.getMessage());
		}
		
		
	}
	
	public String getData(int sheetNo, int row, int column)
	{
		String data=wb.getSheetAt(sheetNo).getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	//above code will work as per sheet index, but what if we want to pass the sheet name as well for that use below code
	
	public String getData(String sheetName,int row, int column)
	{
		String data=wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		return data;
	}
}
