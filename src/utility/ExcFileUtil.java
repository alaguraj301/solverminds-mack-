package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcFileUtil {
	static HSSFWorkbook wb;
	static	HSSFSheet sh;
	static HSSFCell cell;
	static FileOutputStream fileOut;
	public static String value;
	static FileInputStream fis;
	public static void makeFileDir(String path)
			throws IOException, InterruptedException, RowsExceededException, WriteException {

			File filepath = new File(path);

			filepath.mkdir();

		

	}

	public static void setValueInACell(String path, String fileName, String sheetName, String value)
			throws IOException, InterruptedException, RowsExceededException, WriteException {

		
			wb = new HSSFWorkbook();
			sh = wb.createSheet(sheetName);
			cell = sh.createRow(0).createCell(0);
			int lastrow = sh.getLastRowNum();
			cell = sh.getRow(lastrow).getCell(0);
			cell.setCellValue(value);
			fileOut = new FileOutputStream(new File(path + fileName));
			wb.write(fileOut);
		//	wb.close();
			fileOut.close();

	}

	public static void updateValueInACell(String path, String value)
			throws IOException, InterruptedException, RowsExceededException, WriteException {

	
			 fis = new FileInputStream(new File(path));
			wb = new HSSFWorkbook(fis);
			sh = wb.getSheetAt(0);
			int lastrow = sh.getLastRowNum();
			cell = sh.getRow(lastrow).getCell(0);
			cell.setCellValue(value);
			fileOut = new FileOutputStream(new File(path));
			wb.write(fileOut);
			//wb.close();
			fis.close();
		

	}
	public static void getCellValue(String path, String sNo)
			throws IOException, InterruptedException, RowsExceededException, WriteException {

		
			 fis = new FileInputStream(new File(path));
			wb = new HSSFWorkbook(fis);
			sh = wb.getSheetAt(0);
			value = sh.getRow(0).getCell(0).getStringCellValue().trim();
		//	wb.close();
			fis.close();
		

	}
}
