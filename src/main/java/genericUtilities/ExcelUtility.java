package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getStringValue(String sheetName, int row, int cell) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\flpikartDetails.xlsx");
		Workbook work = WorkbookFactory.create(fis);
		return work.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		
	}
	
}
