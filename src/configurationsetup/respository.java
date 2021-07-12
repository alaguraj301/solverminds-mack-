package configurationsetup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class respository {
	public static String URL, ShipURL;
	public static String Username, ShipUsername;
	public static String Password, ShipPassword;
	public static String Filepath1;

	public void setup() throws IOException {
		// TODO Auto-generated method stub
		String Filepath = "C:\\Users\\alaguraj.periyasamy\\eclipse-workspace\\DailyAutomationEngine\\bin\\XLSConfigurationSheets\\configuration.xls";
		File file = new File(Filepath);
		FileInputStream fis = new FileInputStream(file);
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		String sheetname1 = "Useraction";

		HSSFSheet sheet1 = workbook.getSheet(sheetname1);
		String workbookname = sheet1.getRow(1).getCell(1).getStringCellValue();
		System.out.println(workbookname);
		String Shore_environment = sheet1.getRow(1).getCell(2).getStringCellValue();
		System.out.println(Shore_environment);
		String Ship_environment = sheet1.getRow(1).getCell(3).getStringCellValue();
		System.out.println(Ship_environment);

		String sheetname2 = "Shore Environmentdetail";
		HSSFSheet sheet2 = workbook.getSheet(sheetname2);
		int rc = sheet2.getLastRowNum();

		String sheetname3 = "Filepath";
		HSSFSheet sheet3 = workbook.getSheet(sheetname3);

		String sheetname4 = "Ship Environmentdetail";
		HSSFSheet sheet4 = workbook.getSheet(sheetname4);

		int rc4 = sheet4.getLastRowNum();

		for (int i = 0; i <= rc; i++) {
			String select = sheet2.getRow(i).getCell(0).getStringCellValue();
			// System.out.println(select);
			if (select == Shore_environment) {
				URL = sheet2.getRow(i).getCell(1).getStringCellValue();
				System.out.println("URL: " + URL);
				Username = sheet2.getRow(i).getCell(2).getStringCellValue();
				System.out.println("USER NAME: " + Username);
				Password = sheet2.getRow(i).getCell(3).getStringCellValue();
				System.out.println("PASSWORD: " + Password);
			}

		}

		for (int i = 0; i <= rc4; i++) {
			String select = sheet4.getRow(i).getCell(0).getStringCellValue();
			// System.out.println(select);
			if (select == Ship_environment) {
				ShipURL = sheet4.getRow(i).getCell(1).getStringCellValue();
				System.out.println("URL: " + ShipURL);
				ShipUsername = sheet4.getRow(i).getCell(2).getStringCellValue();
				System.out.println("USER NAME: " + ShipUsername);
				ShipPassword = sheet4.getRow(i).getCell(3).getStringCellValue();
				System.out.println("PASSWORD: " + ShipPassword);
			}

		}

		int rc1 = sheet3.getLastRowNum();

		for (int i = 0; i <= rc1; i++) {
			String select = sheet3.getRow(i).getCell(0).getStringCellValue();
			// System.out.println(select);
			if (select == workbookname) {
				Filepath1 = sheet3.getRow(i).getCell(1).getStringCellValue();
				System.out.println("Filepath: " + Filepath1);
			}

		}

	}

}
