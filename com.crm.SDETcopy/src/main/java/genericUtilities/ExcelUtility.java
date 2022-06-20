package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author SanjayBabu
 *
 */
public class ExcelUtility {
	/**
	 *its used to read the data from excel file  
	 * @return
	 */
public String readDataFromExcel(String sheetName,int rowNum,int cellNum) throws Throwable{
	FileInputStream fileInputStream = new FileInputStream(IPathConstants.excelPath);
	Workbook workbook = WorkbookFactory.create(fileInputStream);
	Sheet sheet = workbook.getSheet(sheetName);
	Row row = sheet.getRow(rowNum);
	Cell cell = row.getCell(cellNum);
	String data = cell.toString();
	return data;
}
/**
 * its used to write data into excel file
 * @param sheetName
 * @return
 * @throws Throwable
 */
public void writeDataIntoExcel(String sheetName,int rowNum,int cellNum,String data) throws Throwable {
	FileInputStream fileInputStream=new FileInputStream(IPathConstants.excelPath);
	Workbook workbook = WorkbookFactory.create(fileInputStream);
	Sheet sheet = workbook.getSheet(sheetName);
	Row row = sheet.getRow(rowNum);
	Cell cell = row.createCell(cellNum);
	cell.setCellValue(data);
	FileOutputStream fileOutputStream = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
	workbook.write(fileOutputStream);
}
/**
 * 
 * @param sheetname
 * @param rowNum
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public Object[][] readDataForDataProvider(String sheetname,int rowNum) throws EncryptedDocumentException, IOException
{
	FileInputStream fs=new FileInputStream(IPathConstants.excelPath);
	Workbook workbook = WorkbookFactory.create(fs);
	Sheet sheet = workbook.getSheet(sheetname);
	Object[][] obj = new Object[sheet.getLastRowNum()][sheet.getRow(rowNum).getLastCellNum()];
	for (int i = 0; i < sheet.getLastRowNum(); i++) {
		for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
			obj[i][j]=sheet.getRow(i+1).getCell(j).toString();
		}
	}
	return obj;
}
}
