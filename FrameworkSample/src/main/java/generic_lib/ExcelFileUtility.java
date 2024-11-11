package generic_lib;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	
	public String getDataFromExcelSheet(String sheetName, int rowNum, int cellNum)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/testscriptdata.xlsx");
		String data = WorkbookFactory.create(fis).getSheet(sheetName).getRow(rowNum).getCell(cellNum)
				.getStringCellValue();
		return data;
	}
}
