package utils;


import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	 public static Object[][] getExcelData(String filePath, String sheetName) {
	        List<Object[]> dataList = new ArrayList<>();

	        try (FileInputStream fis = new FileInputStream(new File(filePath));
	             Workbook workbook = new XSSFWorkbook(fis)) {

	            Sheet sheet = workbook.getSheet(sheetName);
	            int rowCount = sheet.getPhysicalNumberOfRows();

	            for (int i = 1; i < rowCount; i++) { // skip header row
	                Row row = sheet.getRow(i);
	                if (row == null) continue;

	                String username = row.getCell(0).getStringCellValue();
	                String password = row.getCell(1).getStringCellValue();

	                dataList.add(new Object[]{username, password});
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return dataList.toArray(new Object[0][0]);
	    }

}
