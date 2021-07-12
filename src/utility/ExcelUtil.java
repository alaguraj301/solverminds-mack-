/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import config.Keywords;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelUtil {
	public static ExtentReports report;
	public static ExtentTest extent;
	public static Workbook wbWorkbook;
	public static Sheet shSheet;
	public static Cell cell;
	Sheet Sheet1;
	String col;
	String browsepath;
	String startTime;
	String executedBy;
	ArrayList testScenarioDescription = new ArrayList();
	ArrayList testCaseDescribtion = new ArrayList();
	private static HashMap<String, List<String>> map = new HashMap<String, List<String>>();
	private static HashMap<String, String> param = new HashMap<String, String>();

	public static String ScreenName, Scenario, Testcycle, TestEnvironment, MailToAddre;
	public static String Url;
	public static String tcDes;
	public static String testCase;
	public static String methodName;

	public ExcelUtil() {
	}

	public void openSheet(String filePath) {

		FileInputStream fs;
		try {
			fs = new FileInputStream(filePath);
			wbWorkbook = Workbook.getWorkbook(fs);

			// System.out.println(wbWorkbook.getNumberOfSheets());
			// System.out.println(wbWorkbook.getSheetNames());

			shSheet = wbWorkbook.getSheet(0);
			// System.out.println("0th sheet name" + " " +
			// wbWorkbook.getSheet(0).getName());
			// Printing the Sheet name
			Log.info(
					"\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n"
							+ "                                        EXECUTION STARTS\n"
							+ "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

			Log.info(wbWorkbook.getSheet(0).getName() + "\n");
			// System.out.println( wbWorkbook.getSheet(0).getName()+"\n");
			int a0 = shSheet.getRows();
			int a1;
			// System.out.println("Total number of rows in the TS_Execution sheet: " + a0);
			// Printing the TS ID and TS

			ScreenName = shSheet.getCell(4, 1).getContents();

			Testcycle = shSheet.getCell(6, 1).getContents();

			TestEnvironment = shSheet.getCell(7, 1).getContents();

			MailToAddre = shSheet.getCell(8, 1).getContents();

			for (int j = 1; j < a0; j++) {
				// Setting the value of bResult variable to 'true' before starting every test
				// case

				if (shSheet.getCell(3, j).getContents().equals("Yes")
						&& !shSheet.getCell(3, j).getContents().equalsIgnoreCase("")) {

					Log.info("Test Scenario ID: " + shSheet.getCell(0, j).getContents());
					Log.info("Test Scenario   : " + shSheet.getCell(1, j).getContents());

					Scenario = shSheet.getCell(1, j).getContents();

					// ScreenName = shSheet.getCell(4, j).getContents();
					Url = shSheet.getCell(5, j).getContents();
					executedBy = Keywords.username;
					SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd");
					Date date2 = new Date();
					SimpleDateFormat ft1 = new SimpleDateFormat("HH:mm:ss");
					startTime = ft1.format(date2);

					System.out.println("start time is: " + startTime);

					Log.info("Run Mode        : " + shSheet.getCell(3, j).getContents());
					String col = shSheet.getCell(2, j).getContents();
					// System.out.println("Sheet Name: " + col);

					List<String> list = new ArrayList<String>();
					list.add(shSheet.getCell(2, j).getContents());

					List secondlist = new ArrayList(new HashSet(list));
					Iterator it = secondlist.iterator();
					while (it.hasNext()) {
						list.add(it.next().toString());
					}

					for (int i = 1; i < list.size(); i++) {
						// System.out.println(list.get(i));

						shSheet = wbWorkbook.getSheet(list.get(i));

						String sheetname1 = shSheet.getName();

						Log.info("Executing Sheet :" + " " + sheetname1);
						a1 = shSheet.getRows();

						Log.info("Total No of rows in the " + sheetname1 + ": " + a1 + "\n");

					}
					for (int row = 1; row < shSheet.getRows(); row++) {

						List<Object> myParamList = new ArrayList<Object>();
						tcDes = shSheet.getCell(0, row).getContents();
						if (!shSheet.getCell(0, row).getContents().isEmpty()
								& !shSheet.getCell(0, row).getContents().equals("null"))
							Log.info("TC ID--------------->> " + tcDes);
						testCase = shSheet.getCell(1, row).getContents();
						if (!shSheet.getCell(1, row).getContents().isEmpty()
								& !shSheet.getCell(1, row).getContents().equals("null"))
							Log.info("TC Steps------------>> " + testCase);
						methodName = shSheet.getCell(2, row).getContents();
						Log.info("Method-------------->> " + methodName);

						// To Get Value from Excel content for report.
						for (int col1 = 0; col1 < shSheet.getColumns(); col1++) {
							// Setting the value of bResult variable to 'true' before starting every test
							// step

							String methodName5 = shSheet.getCell(col1, row).getContents();
							// System.out.println("all values:" + methodName5);
							if (col1 == 0) {
								testScenarioDescription.add(methodName5);
							}
							if (col1 == 1) {
								testCaseDescribtion.add(methodName5);
							}
						}
						// Actual Automation part.
						for (int col1 = 3; col1 < shSheet.getColumns(); col1++) {

							if (!shSheet.getCell(col1, row).getContents().isEmpty()
									& !shSheet.getCell(col1, row).getContents().equals("null")) {

								myParamList.add(shSheet.getCell(col1, row).getContents());
								Log.info("Locator Type/Value-->> " + shSheet.getCell(col1, row).getContents());

							}
						}

						Object[] paramListObject = new String[myParamList.size()];
						paramListObject = myParamList.toArray(paramListObject);

						runReflectionMethod("config.Keywords", methodName, paramListObject);

					}
					shSheet = wbWorkbook.getSheet(0);
					param.put("StartTime", startTime);
					param.put("ScreenName", ScreenName);
					param.put("Testcycle", Testcycle);
					param.put("TestEnvironment", TestEnvironment);
					param.put("MailToAddre", MailToAddre);

					param.put("Url", Url);
					param.put("executedBy", executedBy);
					// System.out.println("checkmap:" + param);
					map.put("testScenarioDescription", testScenarioDescription);
					map.put("testCaseDescribtion", testCaseDescribtion);
					System.out.println("checkmap:" + map);
					System.out.println("checkmaptsc:" + map.get("testScenarioDescription"));
				}
			}
			System.out.println(shSheet.getName());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public HashMap passA() {
		// System.out.println("checkmappassA:" + map);
		return map;
	}

	public HashMap param() {
		// System.out.println("checkmappassparam:" + param);
		return param;
	}

	public int getRowCount() {
		return shSheet.getRows();
	}

	public int getColumnCount() {
		return shSheet.getColumns();
	}

	public void runReflectionMethod(String strClassName, String strMethodName, Object... inputArgs) {

		Class<?> params[] = new Class[inputArgs.length];

		for (int i = 0; i < inputArgs.length; i++) {
			if (inputArgs[i] instanceof String) {
				params[i] = String.class;
			}
		}
		try {
			Class<?> cls = Class.forName(strClassName);
			Object _instance = cls.newInstance();
			Method myMethod = cls.getDeclaredMethod(strMethodName, params);
			myMethod.invoke(_instance, inputArgs);

		} catch (ClassNotFoundException e) {
			System.err.format(strClassName + ":- Class not found%n");
		} catch (IllegalArgumentException e) {
			System.err.format("Method invoked with wrong number of arguments%n");
		} catch (NoSuchMethodException e) {
			Log.error("In Class " + strClassName + "::" + strMethodName + ":- method does not exists%n");
		} catch (InvocationTargetException e) {
			System.out.println(e.getCause());
			System.err.format("Exception thrown by an invoked method%n");
		} catch (IllegalAccessException e) {
			System.err.format("Can not access a member of class with modifiers private%n");
			e.printStackTrace();
		} catch (InstantiationException e) {
			System.err.format("Object cannot be instantiated for the specified class using the newInstance method%n");
		}
	}
}
