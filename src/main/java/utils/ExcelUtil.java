package utils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public static String getCellData(String filePath, String sheetName, int row, int col) {
		try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {

			Sheet sheet = workbook.getSheet(sheetName);
			Row excelRow = sheet.getRow(row);
			org.apache.poi.ss.usermodel.Cell cell = excelRow.getCell(col);
			return cell.toString();

		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
}
