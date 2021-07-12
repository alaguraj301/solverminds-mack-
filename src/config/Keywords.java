package config;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.interactions.Action;

//import com.sun.media.sound.InvalidFormatException;

import java.awt.Desktop;
import java.awt.Robot;
import java.awt.Scrollbar;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import net.bytebuddy.dynamic.loading.PackageDefinitionStrategy.Definition;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.commandhandler.ExceptionHandler;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.SkipException;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.xmlpull.v1.builder.XmlDocument;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.KlovReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.collect.Ordering;

import configurationsetup.respository;
import jxl.Cell;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import seleniumpackage.ACTIVESQL;
import seleniumpackage.RateOfExchange;
import seleniumpackage.SQL;
import seleniumpackage.siterequestedFor;
import utility.ColorUtil;
import utility.ExcFileUtil;
import utility.ExcelUtil;
import utility.Log;
import utility.SeleniumLibrary;
import utility.WaitUtil;

public class Keywords extends SeleniumLibrary {

	public static WebDriver driver;

	public static String Exchange = null;

	public static Wait<WebDriver> wait;
	// public static String requiredSno;
	public static String companyname;
	public static String fleetname;
	public static String vesname;
	public static String vessaltypename;
	public static String flag;
	public static String bgColor;
	public static String result;
	private static XSSFSheet excelWSheet;
	private static int k = 1;
	private static int mY = 1;
	private static int mNY = 1;
	private static int mN = 1;
	private static XSSFWorkbook excelWBook;
	private static HSSFCell cell;
	private static FileInputStream fis;
	public static String userName;
	public static String password;
	public static String url;
	public static ArrayList<String> data = new ArrayList<String>();

	ExcelUtil re = new ExcelUtil();

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports report;
	public static ExtentTest extent;
	public static String username;
	public static KlovReporter klov;
	public static String date;

	public static String code = ExcelUtil.testCase;
	public Markup m = MarkupHelper.createCodeBlock(code);
	private Scanner get;
	public static String PurchaseNo1, ShipPurchaseNo1;
	public static String Input;

	public static int TotalItemCount;

	public double vendorQuotedDiscount1 = 0;
	public double vendorBaseDiscountedAmount1 = 0;
	public double vendorQuotedCost1 = 0;
	public double vendorBaseAmount1 = 0;
	public static double PoNetAmount = 0;
	public static double poItemCurrency1;

	public static double POCommittedamount = 0;

	public static String SerialNo_Copy;

	public static Date CounterStartupdate, Counterupdate, Counterupdatold = null;
	public static double CounterStartValue, StartUpAverage, EntryToCalculate, CounterValue, Last4Entry,
			CounterValueold = 0;

	public static String Modulename, result1;
	public static String ROORIGINSITE, RODEPARTMENT, ROCREATEDDATE, ROCRETEDBY, ROPRIORITY, RODELIVERYDATE,
			RODELIVERYLOCATION, ROALERTDATE;

	public static String Query;

	public static String ActiveRecordQuery, Envronment, Envronment1;
	public static int oldvalue = 300;// Declare global
	public static int dateold = 5;// declare global

	private static List<String> Lifecylce = new ArrayList<String>();

	private static List<Double> Sum_RFQTotalAmt_withutDisc = new ArrayList<Double>();

	private static List<Double> Sum_RFQ_DiscountAmt = new ArrayList<Double>();

	private static List<Double> Sum_RFQ_TotalNetamount = new ArrayList<Double>();

	public static double OverallDiscount, RFQ_Header_TotalAmt_AfterDisc, RFQ_Header_Additional_Charge,
			RFQ_Header_NetAmount, RFQ_Header_Tax, RFQ_Header_QuotedAmount;
	public static String startTime_1;
	public static String gettextfromscreen;

	public static boolean checkIfURLExists(String targetUrl) {
		HttpURLConnection httpUrlConn;
		try {
			httpUrlConn = (HttpURLConnection) new URL(targetUrl).openConnection();

			// A HEAD request is just like a GET request, except that it asks
			// the server to return the response headers only, and not the
			// actual resource (i.e. no message body).
			// This is useful to check characteristics of a resource without
			// actually downloading it,thus saving bandwidth. Use HEAD when
			// you don't actually need a file's contents.
			httpUrlConn.setRequestMethod("HEAD");
			// Set timeouts in milliseconds
			// httpUrlConn.setConnectTimeout(30000);
			// httpUrlConn.setReadTimeout(30000);

			// Print HTTP status code/message for your information.
			Log.info("Response Code: " + httpUrlConn.getResponseCode());
			Log.info("Response Message: " + httpUrlConn.getResponseMessage());

			return (httpUrlConn.getResponseCode() == HttpURLConnection.HTTP_OK);
		} catch (Exception e) {
			Log.info("Error: " + e.getMessage());
			return false;
		}
	}

	public void Usernamesetup(String locatorType, String value) throws IOException, InterruptedException {
		try {

			By locator;
			locator = locatorValue(locatorType, value);
			respository opj1 = new respository();

			WebElement element = WaitUtil.fluentWait(locator);
			element.sendKeys(opj1.Username);
			extent.pass(code);
			result = "PASS";

			// WaitUtil.waitForEleTobevisible(By.xpath("//*[@class='ui-datatable ui-widget
			// upload_table']/div/table/tbody/tr[2]"))
			// ;

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void Userpasswordsetup(String locatorType, String value) throws IOException, InterruptedException {
		try {

			By locator;
			locator = locatorValue(locatorType, value);
			respository opj1 = new respository();

			WebElement element = WaitUtil.fluentWait(locator);
			element.sendKeys(opj1.Password);
			extent.pass(code);
			result = "PASS";

			// WaitUtil.waitForEleTobevisible(By.xpath("//*[@class='ui-datatable ui-widget
			// upload_table']/div/table/tbody/tr[2]"))
			// ;

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void ShipUsernamesetup(String locatorType, String value) throws IOException, InterruptedException {
		try {

			By locator;
			locator = locatorValue(locatorType, value);
			respository opj1 = new respository();

			WebElement element = WaitUtil.fluentWait(locator);
			element.sendKeys(opj1.ShipUsername);
			extent.pass(code);
			result = "PASS";

			// WaitUtil.waitForEleTobevisible(By.xpath("//*[@class='ui-datatable ui-widget
			// upload_table']/div/table/tbody/tr[2]"))
			// ;

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void ShipUserpasswordsetup(String locatorType, String value) throws IOException, InterruptedException {
		try {

			By locator;
			locator = locatorValue(locatorType, value);
			respository opj1 = new respository();

			WebElement element = WaitUtil.fluentWait(locator);
			element.sendKeys(opj1.ShipPassword);
			extent.pass(code);
			result = "PASS";

			// WaitUtil.waitForEleTobevisible(By.xpath("//*[@class='ui-datatable ui-widget
			// upload_table']/div/table/tbody/tr[2]"))
			// ;

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public static void testRepName(String filePath) throws BiffException, IOException {
		FileInputStream fs;

		fs = new FileInputStream(filePath);
		ExcelUtil.wbWorkbook = Workbook.getWorkbook(fs);

		ExcelUtil.shSheet = ExcelUtil.wbWorkbook.getSheet(0);

		ExcelUtil.ScreenName = ExcelUtil.shSheet.getCell(4, 1).getContents();

		userName = ExcelUtil.shSheet.getCell(0, 1).getContents();
		System.out.println(userName);
		password = ExcelUtil.shSheet.getCell(1, 1).getContents();
		System.out.println(password);
		url = ExcelUtil.shSheet.getCell(5, 1).getContents();
		System.out.println(url);

	}

	public static void startTesting() throws UnknownHostException {
		SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

		date = SDF.format(new Date());

		Date date21 = new Date();
		SimpleDateFormat ft1 = new SimpleDateFormat("HH:mm:ss");
		startTime_1 = ft1.format(date21);

		System.out.println("start time is: " + startTime_1);

		htmlReporter = new ExtentHtmlReporter(
				"F:\\mack project reports\\report\\" + ExcelUtil.ScreenName + date + ".html");

		// htmlReporter.setAppendExisting(true);
		// klov = new KlovReporter();

		report = new ExtentReports();
		// / specify mongoDb connection
		// klov.initMongoDbConnection("localhost", 27017);

		// specify project ! you must specify a project, other a "Default
		// project will
		// be used"
		// klov.setProjectName("Scenario");

		// you must specify a reportName otherwise a default timestamp will be
		// used
		// klov.setReportName("Myklov");

		// URL of the KLOV server
		// klov.setKlovUrl("http://localhost:8090");
		report.attachReporter(htmlReporter);

		InetAddress address = InetAddress.getLocalHost();
		String os = System.getProperty("os.name").toLowerCase();
		username = System.getProperty("user.name");

		report.setSystemInfo("OS", os);
		report.setSystemInfo("Project", "MACK");
		report.setSystemInfo("Resource", username);
		report.setSystemInfo("Environment", "TESTING");
		report.setSystemInfo("Host Name", address.getHostName());

		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle(" MACK Testing");
		htmlReporter.config().setReportName("MACK Testing");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);

		// extent = report.createTest(ExcelUtil.ScreenName);
		// extent.createNode("testing");

	}

	public static String ScreenShot() throws IOException {

		SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMddHHmmss");

		String date = SDF.format(new Date());

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destFile = "F:\\mack project reports\\failedcase\\" + date + ".png";
		FileUtils.copyFile(scrFile, new File(destFile));
		return destFile;

	}

	public void dataClear() throws InterruptedException, IOException {
		try {

			che();
			result = "PASS";
		} catch (Exception e) {
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void Report_Scenario() throws InterruptedException, IOException {
		try {
			extent = report.createTest(ExcelUtil.Scenario);
			result = "PASS";
		} catch (Exception e) {
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void Report_Scenario1() throws InterruptedException, IOException {

		try {
			extent = report.createTest(code);

			result = "PASS";

		} catch (Exception e) {
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void open_browser(String browserName) throws IOException {

		try {
			System.out.print("Firefox1");
			// System.setProperty("webdrive
			// extent = report.createTest(ExcelUtil.Scenario);

			if (browserName.equalsIgnoreCase("Firefox")) {
				System.out.print("Firefox1");
				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\alaguraj.periyasamy\\eclipse-workspace\\DailyAutomationEngine\\driverfolder\\geckodriver.exe");
				driver = new FirefoxDriver();
				System.out.print("Firefox2");
			} else if (browserName.equalsIgnoreCase("chrome")) {

				// System.setProperty("webdriver.chrome.driver",
				// "D:\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\alaguraj.periyasamy\\eclipse-workspace\\DailyAutomationEngine\\driverfolder\\chromedriver.exe");

				/*
				 * Bindings bindings = js.getBindings(ScriptContext.ENGINE_SCOPE);
				 * bindings.put("stdout", System.out);
				 * js.eval("stdout.println(Math.cos(Math.PI));");
				 */
				// System.setProperty("webdriver.chrome.driver",
				// "C:\\jar\\chromedriver.exe");
				// File file = new File("chromedriver.exe");
				// System.out.println(file.getAbsolutePath());
				// ChromeOptions options = new ChromeOptions();
				// options.addArguments("disable-infobars");
				// driver = new ChromeDriver(options);
				// driver.manage().timeouts().implicitlyWait(4,
				driver = new ChromeDriver();
				// TimeUnit.SECONDS);
				driver.manage().window().maximize();

			} else if (browserName.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver",
						"C:\\Users\\alaguraj.periyasamy\\eclipse-workspace\\DailyAutomationEngine\\driverfolder\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			result = "PASS";
			extent.pass(code);

		} catch (Exception e) {

			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	// Check this option open a new form and Check without giving write access to
	// the module New button should not available in landing page

	public void enterURL(String URL) throws IOException {
		try {
			driver.get(URL);
			result = "PASS";
			extent.pass(code);

		} catch (Exception e) {
			extent.fatal(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void enterURLsetup() throws IOException {
		try {
			driver.get(respository.URL);
			result = "PASS";
			extent.pass(code);

		} catch (Exception e) {
			extent.fatal(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void ShipenterURLsetup() throws IOException {
		try {
			driver.get(respository.ShipURL);
			result = "PASS";
			extent.pass(code);

		} catch (Exception e) {
			extent.fatal(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	// private File File(String string) {
	// throw new UnsupportedOperationException("Not supported yet."); //To
	// change
	// body of generated methods, choose Tools | Templates.
	// }
	private enum LocatorTpye {

		id, name, xpath, css, linkText, partialLinkText;
	}

	/*
	 * public By locatorValue1(String locatorTpye, String value) throws IOException
	 * { Properties p = new Properties(); String Filename =
	 * "C:\\Users\\saravanapravin.p\\Downloads\\DailyAutomationEngine\\DailyAutomationEngine\\object.properties";
	 * File file = new File(Filename); InputStream st = new FileInputStream(file);
	 * p.load(st); String val = locatorTpye; LocatorTpye locator =
	 * LocatorTpye.valueOf(val); By by; switch (locator) { case id: by =
	 * By.id(p.getProperty(value)); break; case name: by =
	 * By.name(p.getProperty(value)); break; case xpath:
	 * 
	 * by = By.xpath(p.getProperty(value)); break; case css: by =
	 * By.cssSelector(p.getProperty(value)); break; case linkText: by =
	 * By.linkText(p.getProperty(value)); break; case partialLinkText: by =
	 * By.partialLinkText(p.getProperty(value)); break; default: by = null; break; }
	 * return by; }
	 */

	public static By locatorValue(String locatorTpye, String value) {
		String val = locatorTpye;
		LocatorTpye locator = LocatorTpye.valueOf(val);
		By by;
		switch (locator) {
		case id:
			by = By.id(value);
			break;
		case name:
			by = By.name(value);
			break;
		case xpath:
			by = By.xpath(value);
			break;
		case css:
			by = By.cssSelector(value);
			break;
		case linkText:
			by = By.linkText(value);
			break;
		case partialLinkText:
			by = By.partialLinkText(value);
			break;
		default:
			by = null;
			break;
		}
		return by;
	}

	public void windowMaximize() throws IOException {
		try {
			driver.manage().window().maximize();
			// Thread.sleep(2000);
			result = "PASS";
			extent.pass(code);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void enterText(String locatorType, String value, String text) throws IOException, InterruptedException {
		try {
			// //String Result = null;
			By locator;
			locator = locatorValue(locatorType, value);

			WebElement element = WaitUtil.fluentWait(locator);

			if (element != null) {
				// element.sendKeys(text);

				new Actions(driver).click(element).pause(200).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
						.pause(200).sendKeys(Keys.BACK_SPACE)

						.pause(500).sendKeys(text).perform();
				// System.out.println(element.getAttribute("value"));

				if (element.getAttribute("value").equals(text)) {

					extent.pass(code);
					result = "PASS";

				}
			} else {
				System.out.println("fail");
				extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}

		} catch (TimeoutException e) {

			extent.fail(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("No Element Found to perform click" + e);
			result = "FAIL";

		} catch (StaleElementReferenceException se) {
			extent.pass(code);
			result = "PASS";
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void enterText_delay() throws IOException, InterruptedException {
		try {
			// //String Result = null;

			int i = 100000;

			for (i = 0; i <= 100000; i++) {

				// Enter text "q" and perform keyboard action "Enter"
				driver.findElement(By.xpath("//INPUT[@id='PRQ-PRQ_name']/self::INPUT")).sendKeys("q" + Keys.ENTER);
				Thread.sleep(5000);

				driver.findElement(By.xpath("//INPUT[@id='PRQ-PRQ_name']/self::INPUT")).sendKeys(Keys.CONTROL, "a");
				driver.findElement(By.xpath("//INPUT[@id='PRQ-PRQ_name']/self::INPUT")).sendKeys(Keys.DELETE);
				Thread.sleep(5000);
			}

		} catch (StaleElementReferenceException se) {
			extent.pass(code);
			result = "PASS";
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void upload_attachment(String locatorType, String value) throws IOException, InterruptedException {
		try {
			// String Result = null;
			String path = "D:\\Attachment\\Attachment.png";
			File filepath = new File(path);
			if (!filepath.exists()) {
				filepath.mkdir();
				@SuppressWarnings("resource")
				HSSFWorkbook wb = new HSSFWorkbook();
				HSSFSheet sh1 = wb.createSheet("attachment");
				FileOutputStream fileOut = new FileOutputStream(new File(path));

				wb.write(fileOut);
				fileOut.close();
				System.out.println("file Created ");
			}

			By locator;
			locator = locatorValue(locatorType, value);

			WebElement element = WaitUtil.fluentWait(locator);
			if (element != null) {
				element.sendKeys("D:\\Attachment\\Attachment.png");
			}

			WaitUtil.waitForEleTobevisible(
					By.xpath("//*[@class='ui-datatable ui-widget upload_table']/div/table/tbody/tr[2]"));
			extent.pass(code);
			result = "PASS";

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void file_upload(String locatorType, String value) throws IOException, InterruptedException {
		try {

			By locator;
			locator = locatorValue(locatorType, value);

			WebElement a = driver.findElement(locator);

			Actions act = new Actions(driver);

			act.click(a).build().perform();

			Thread.sleep(2000);

			StringSelection s = new StringSelection("D:\\Attachment\\Attachment.png");

			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);

			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_CONTROL);

			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);

			robot.keyRelease(KeyEvent.VK_V);

			robot.keyPress(KeyEvent.VK_ENTER);

			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void RFQEXCEL(String locatorType, String value) throws IOException, InterruptedException {
		try {

			By locator;
			locator = locatorValue(locatorType, value);

			WebElement element = WaitUtil.fluentWait(locator);
			if (Input != null) {

				element.sendKeys("C:\\Users\\pushpakumari.d\\Downloads\\" + Input);
				extent.pass(code);
				result = "PASS";
			} else {
				extent.fail(code);
				result = "FAIL";
			}

			// WaitUtil.waitForEleTobevisible(By.xpath("//*[@class='ui-datatable ui-widget
			// upload_table']/div/table/tbody/tr[2]"))
			// ;

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void jsClick(String locatorType, String value) throws IOException, InterruptedException {
		// //String Result = null;
		try {

			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);

			result = "PASS";
			extent.pass(code);
		} catch (Exception e) {
			extent.fail(code + " " + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void webClick(String locatorType, String value) throws IOException, InterruptedException {
		// //String Result = null;
		try {

			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			// Thread.sleep(1500);
			element.click();
			WaitUtil.waitForEleTobeInvisible(By.xpath("//div[@class='blockUI']"));
			result = "PASS";
			extent.pass(code);
		} catch (Exception e) {
			extent.fail(code + " " + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void staleClick(String locatorType, String value) throws IOException, InterruptedException {
		// //String Result = null;
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			try {
				WebElement ele = WaitUtil.waitForStaleElement(locator);
				ele.click();
			} catch (ElementNotVisibleException en) {
				WebElement ele = WaitUtil.waitForStaleElementVisible(locator);
				ele.click();
			}
			result = "PASS";
			extent.pass(code);

		} catch (Exception e) {

			extent.fail(code + " " + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());

			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}

		data.add(result);
		anotherMethod(result, data);
	}

	public void clearText(String locatorType, String value) throws IOException, InterruptedException {

		try {
			By locator;
			locator = locatorValue(locatorType, value);

			WebElement element = WaitUtil.fluentWait(locator);

			element.clear();
			extent.pass(code);
			result = "PASS";

			// Thread.sleep(3000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void outputValue(String locatorType, String value, String text)
			throws BiffException, IOException, InterruptedException {
		// //String Result = null;
		try {
			String columname, Columvalue;
			File src = new File("C:\\Excel\\SystemGenValues.xls");
			FileInputStream fis = new FileInputStream(src);
			@SuppressWarnings("resource")
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh1 = wb.getSheetAt(0);
			int columncount = sh1.getRow(0).getLastCellNum();
			// System.out.println(columncount);
			for (int i = 0; i <= columncount; i++) {
				columname = sh1.getRow(0).getCell(i).getStringCellValue();
				if (text.equalsIgnoreCase(columname)) {
					Columvalue = sh1.getRow(1).getCell(i).getStringCellValue();
					By locator;
					locator = locatorValue(locatorType, value);
					WebElement element = WaitUtil.waitForEleTobevisible(locator);
					element.sendKeys(Columvalue);

					break;
				}
			}
			extent.pass(code);
			result = "PASS";

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
			// rs.getScenarios(TSID, Description, Result);
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void excelCellCompare(String text) throws IOException {

		try {
			String[] arrSplit = text.split(",");
			String columname, Columvalue1 = null, Columvalue2 = null;
			File src = new File("C:\\Excel\\SystemGenValues.xls");
			// String filepath = "C:\\Excel\\SystemGenValues.xls";
			FileInputStream fis = new FileInputStream(src);
			@SuppressWarnings("resource")
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh1 = wb.getSheetAt(0);
			int columncount = sh1.getRow(0).getLastCellNum();
			System.out.println(columncount);
			// int lastrow = lastrow = sh1.getLastRowNum();
			for (int i = 0; i <= columncount; i++) {
				columname = sh1.getRow(0).getCell(i).getStringCellValue();
				if (arrSplit[0].equalsIgnoreCase(columname)) {
					Columvalue1 = sh1.getRow(1).getCell(i).getStringCellValue();
					break;
				}
			}
			for (int i = 0; i <= columncount; i++) {
				columname = sh1.getRow(0).getCell(i).getStringCellValue();
				if (arrSplit[1].equalsIgnoreCase(columname)) {
					Columvalue2 = sh1.getRow(1).getCell(i).getStringCellValue();
					break;
				}
			}
			if (Columvalue1.equals(Columvalue2)) {
				// System.out.println("Both values are same");
				extent.pass(code);
				result = "PASS";
			} else {
				extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				System.out.println("Both values are not same");
				result = "FAIL";
			}
			Thread.sleep(1000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void double_click(String locatorType, String value) throws IOException, InterruptedException {

		try {
			By locator;
			locator = locatorValue(locatorType, value);
			Actions actions = new Actions(driver);
			WebElement elementLocator = driver.findElement(locator);
			actions.doubleClick(elementLocator).build().perform();
			extent.pass(code);
			result = "PASS";

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void doubleClick(String locatorType, String value) throws IOException, InterruptedException {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.waitForEleTobeClickble(locator);
			Actions action = new Actions(driver);
			action.moveToElement(element).doubleClick().build().perform();
			extent.pass(code);
			result = "PASS";

		}

		// Thread.sleep(2000);
		catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
			// rs.getScenarios(TSID, Description, Result);
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void check_vesselname() throws IOException, InterruptedException {

		try {
			System.out.println("-----------system---------xxxxxxxxxxxxxxxxxxxxxxxxxxxx----------------------");

			List<WebElement> m = driver.findElements(By.xpath("//div[text()= 'Shinano queen']"));
			System.out.println(m);
			Thread.sleep(2000);
			for (int i = 1; i <= m.size(); i++) {
				// WebElement mm = driver.findElement(By.xpath("(//div[text()= 'Shinano
				// queen'])[" + i + "]"));

				String text = m.get(i).getText();
				// String text2 = mm.getText();
				// String text = m.get(i).getText();

				if (text.equalsIgnoreCase("Shinano queen")) {

					System.out.println(text + "********");

				}
			}

			extent.pass(code);
			result = "PASS";

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "FAIL";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void rightClick(String locatorType, String value, String text) throws InterruptedException, IOException {
		try {

			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.waitForEleTobeClickble(locator);
			Actions oAction = new Actions(driver);

			oAction.moveToElement(element);
			Thread.sleep(3000);
			oAction.contextClick(element).build().perform(); /*
																 * this will perform right click
																 */
//
//			WebElement elementOpen = WaitUtil
//					.waitForEleTobevisible(By.linkText(text)); /* This will select menu after right click */

			// elementOpen.click();
			extent.pass(code);
			result = "PASS";

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void rightClk(String locatorType, String value) throws InterruptedException, IOException {
		try {

			By locator;
			locator = locatorValue(locatorType, value);

			Actions act = new Actions(driver);

			WebElement e = driver.findElement(locator);

			act.contextClick(e).perform();

			extent.pass(code);
			result = "PASS";

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void rightClickDelete(String locatorType, String value) throws InterruptedException, IOException {
		try {

			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.waitForEleTobeClickble(locator);
			Actions oAction = new Actions(driver);
			oAction.moveToElement(element);
			oAction.contextClick(element).build().perform(); /*
																 * this will perform right click
																 */

			WebElement elementOpen = WaitUtil.waitForEleTobevisible(By.xpath(
					"//SPAN[@ref='eName'][text()='Delete']/self::SPAN")); /*
																			 * This will select menu after right click
																			 */

			elementOpen.click();
			extent.pass(code);
			result = "PASS";

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void scrollDown() throws InterruptedException, IOException {
		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,250)"); // Scroll vertically
														// down by 1000
														// pixels
			result = "PASS";
			extent.pass(code);

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public static void scrollDown1(String locatorType, String value) throws InterruptedException, IOException {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.waitForEleTobevisible(locator);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			result = "PASS";
			extent.pass(code);

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void scrollHorizontalLeft() throws InterruptedException, IOException {
		try {

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("javascript:window.scrollBy(-2500,0)");
			extent.pass(code);
			result = "PASS";

		} catch (NoSuchElementException e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "FAIL";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void scrollHorizontalRight() throws InterruptedException, IOException {
		try {

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("javascript:window.scrollBy(+2500,0)");
			extent.pass(code);
			result = "PASS";

		} catch (NoSuchElementException e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "FAIL";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void scrollHorizontalRight_Element(String locatorType, String value)
			throws InterruptedException, IOException {
		try {

			By locator;
			locator = locatorValue(locatorType, value);

			WebElement scroll = driver.findElement(locator);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(2500,0)", "");

			extent.pass(code);
			result = "PASS";

		} catch (NoSuchElementException e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "FAIL";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void scrollDownCertainPoint() throws InterruptedException, IOException {
		try {

			JavascriptExecutor jse = (JavascriptExecutor) driver;

			jse.executeScript("javascript:window.scrollBy(0,200)");
			extent.pass(code);
			result = "PASS";
		} catch (NoSuchElementException e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "FAIL";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void mouseHoverClick(String locatorType, String value) throws IOException, StaleElementReferenceException {
		try {
			By locator;
			locator = locatorValue(locatorType, value);

			WebElement web_Element_To_Be_Hovered = WaitUtil.waitForEleTobeClickble(locator);
			// System.out.println(web_Element_To_Be_Hovered);
			Actions builder = new Actions(driver);

			builder.moveToElement(web_Element_To_Be_Hovered).click().build().perform();
			// Runtime.getRuntime().exec("C:\\Users\\samyuktha.aj\\Desktop\\Script.exe");
			result = "PASS";
			extent.pass(code);

		} catch (TimeoutException e) {

			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void scrollUp() throws InterruptedException, IOException {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("javascript:window.scrollBy(0,-450)");
			result = "PASS";
			extent.pass(code);
		} catch (NoSuchElementException e) {

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "FAIL";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void scrollUpCertainUP() throws InterruptedException, IOException {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("javascript:window.scrollBy(0,-1300)");
			result = "PASS";
			extent.pass(code);
		} catch (NoSuchElementException e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "FAIL";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void scrollUpCertainDown() throws InterruptedException, IOException {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;

			jse.executeScript("javascript:window.scrollBy(0,800)");
			result = "PASS";
			extent.pass(code);
		} catch (NoSuchElementException e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "FAIL";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void storeWebTableDoubleClick(String locatorType, String value, String text) throws IOException {

		try {
			// System.out.println(value);
			// System.out.println(text);
			String columname, Columvalue;
			File src = new File("C:\\Excel\\SystemGenValues.xls");
			// String filepath = "C:\\ExcelSystemGenValues.xls";
			FileInputStream fis = new FileInputStream(src);
			@SuppressWarnings("resource")
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh1 = wb.getSheetAt(0);
			int columncount = sh1.getRow(0).getLastCellNum();
			// System.out.println(columncount);
			// int lastrow = lastrow = sh1.getLastRowNum();
			for (int i = 0; i <= columncount; i++) {
				columname = sh1.getRow(0).getCell(i).getStringCellValue();
				if (text.equalsIgnoreCase(columname)) {
					Columvalue = sh1.getRow(1).getCell(i).getStringCellValue();
					// Print value in excel
					System.out.println(Columvalue);

					// To locate table.
					WebElement mytable = WaitUtil.waitForEleTobevisible(By.id(value));
					System.out.println("table is selected");
					// To locate rows of table.
					List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
					// To calculate no of rows In table.
					int rows_count = rows_table.size();

					// Loop will execute till the last row of table.
					for (int row = 0; row < rows_count; row++) {
						// To locate columns(cells) of that specific row.
						List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
						// To calculate no of columns(cells) In that specific
						// row.
						int columns_count = Columns_row.size();
						System.out.println("Number of cells In Row " + row + " are " + columns_count);

						// Loop will execute till the last cell of that specific
						// row.
						for (int column = 0; column < columns_count; column++) {
							// To retrieve text from that specific cell.
							System.out.println("true or false=>>"
									+ Columns_row.get(column).getText().trim().equalsIgnoreCase(Columvalue.trim()));
							if (Columns_row.get(column).getText().trim().equalsIgnoreCase(Columvalue.trim())) {
								String celtext = Columns_row.get(column).getText();
								// int rowNo=Columns_row.get(row);
								// selenium.click("//input[@value=rowNo]");
								int rowno = row;
								int colno = column;
								System.out.println(
										"give me the sunshine=>>" + rowno + " " + "give me the rain=>>" + colno);
								// System.out.println("yes");

								List<WebElement> Columns_row1 = rows_table.get(rowno).findElements(By.tagName("td"));
								// for(int i=0;i< Columns_row1.size();i++){
								// System.out.println("the content after if condition=>"+Columns_row1.get(i));
								// }
								Actions action = new Actions(driver);
								// action.moveToElement(mytable).doubleClick().build().perform();
								action.moveToElement(Columns_row1.get(0)).doubleClick().build().perform();
								// Columns_row1.get(0).click();
								System.out.println("Cell Value Of row number" + row + " and column number " + column
										+ " Is " + celtext);
								// for(int i=0;i< Columns_row1.size();i++){
								// System.out.println("the content after if condition=>"+Columns_row1.get(i));
								// }
							}
						}
						// System.out.println("--------------------------------------------------");
					}
				}
			}
			extent.pass(code);
			result = "PASS";

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);

			result = "<a href=" + ScreenShot() + "> FAIL</a>";
			// rs.getScenarios(TSID, Description, Result);
		}
		data.add(result);
		anotherMethod(result, data);
	}

	// Method to click web table value from system generated value stored in
	// excel

	public void storeWebTableClick(String locatorType, String value, String text)
			throws IOException, InterruptedException {
		try {
			System.out.println(value);
			System.out.println(text);
			String columname, Columvalue;
			File src = new File("C:\\Excel\\SystemGenValues.xls");
			// String filepath = "C:\\Excel\\SystemGenValues.xls";
			FileInputStream fis = new FileInputStream(src);
			@SuppressWarnings("resource")
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh1 = wb.getSheetAt(0);
			int columncount = sh1.getRow(0).getLastCellNum();
			System.out.println(columncount);

			for (int i = 0; i <= columncount; i++) {
				columname = sh1.getRow(0).getCell(i).getStringCellValue();
				if (text.equalsIgnoreCase(columname)) {
					Columvalue = sh1.getRow(1).getCell(i).getStringCellValue();
					// Print value in excel
					// System.out.println(Columvalue);

					// To locate table.
					WebElement mytable = WaitUtil.waitForEleTobevisible(By.id(value));
					System.out.println("table is selected");
					// To locate rows of table.
					List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
					// To calculate no of rows In table.
					int rows_count = rows_table.size();

					// Loop will execute till the last row of table.
					for (int row = 0; row < rows_count; row++) {
						// To locate columns(cells) of that specific row.
						List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
						// To calculate no of columns(cells) In that specific
						// row.
						int columns_count = Columns_row.size();
						System.out.println("Number of cells In Row " + row + " are " + columns_count);

						// Loop will execute till the last cell of that specific
						// row.
						for (int column = 0; column < columns_count; column++) {
							// To retrieve text from that specific cell.
							System.out.println("true or false=>>"
									+ Columns_row.get(column).getText().trim().equalsIgnoreCase(Columvalue.trim()));
							if (Columns_row.get(column).getText().trim().equalsIgnoreCase(Columvalue.trim())) {
								String celtext = Columns_row.get(column).getText();
								// int rowNo=Columns_row.get(row);
								// selenium.click("//input[@value=rowNo]");
								int rowno = row;
								int colno = column;
								System.out.println(
										"give me the sunshine=>>" + rowno + " " + "give me the rain=>>" + colno);
								System.out.println("yes");

								List<WebElement> Columns_row1 = rows_table.get(rowno).findElements(By.tagName("td"));
								// for(int i=0;i< Columns_row1.size();i++){
								// System.out.println("the content after if condition=>"+Columns_row1.get(i));
								// }
								Columns_row1.get(0).click();
								System.out.println("Cell Value Of row number" + row + " and column number " + column
										+ " Is " + celtext);
							}
						}
						System.out.println("--------------------------------------------------");
					}
				}
			}
			extent.pass(code);
			result = "PASS";

		} catch (NoSuchElementException e) {

			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
			// rs.getScenarios(TSID, Description, Result);
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void eslStoreWebTableClick(String locatorType, String value, String text)
			throws IOException, InterruptedException {
		try {
			System.out.println(value);
			System.out.println(text);
			String columname, Columvalue = null;
			File src = new File("C:\\Excel\\SystemGenValues.xls");
			// String filepath = "C:\\Excel\\SystemGenValues.xls";
			FileInputStream fis = new FileInputStream(src);
			@SuppressWarnings("resource")
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh1 = wb.getSheetAt(0);

			int rowcount = sh1.getLastRowNum();
			System.out.println("total rowNo=>" + rowcount);
			for (int j = 0; j <= rowcount; j++) {
				columname = sh1.getRow(j).getCell(0).getStringCellValue();
				if (text.equalsIgnoreCase(columname)) {
					Columvalue = sh1.getRow(j).getCell(1).getStringCellValue();

					break;
				}
			}
			// To locate table.
			WebElement mytable = WaitUtil.waitForEleTobevisible(By.id(value));
			System.out.println("table is selected");
			// To locate rows of table.
			List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
			// To calculate no of rows In table.
			int rows_count = rows_table.size();

			// Loop will execute till the last row of table.
			for (int row = 0; row < rows_count; row++) {
				// To locate columns(cells) of that specific row.
				List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
				// To calculate no of columns(cells) In that specific row.
				int columns_count = Columns_row.size();
				System.out.println("Number of cells In Row " + row + " are " + columns_count);

				// Loop will execute till the last cell of that specific row.
				for (int column = 0; column < columns_count; column++) {
					// To retrieve text from that specific cell.
					System.out.println("true or false=>>"
							+ Columns_row.get(column).getText().trim().equalsIgnoreCase(Columvalue.trim()));
					if (Columns_row.get(column).getText().trim().equalsIgnoreCase(Columvalue.trim())) {
						String celtext = Columns_row.get(column).getText();
						// int rowNo=Columns_row.get(row);
						// selenium.click("//input[@value=rowNo]");
						int rowno = row;
						int colno = column;
						System.out.println("give me the sunshine=>>" + rowno + " " + "give me the rain=>>" + colno);
						System.out.println("yes");

						List<WebElement> Columns_row1 = rows_table.get(rowno).findElements(By.tagName("td"));
						// for(int i=0;i< Columns_row1.size();i++){
						// System.out.println("the content after if condition=>"+Columns_row1.get(i));
						// }
						Columns_row1.get(0).click();
						System.out.println(
								"Cell Value Of row number" + row + " and column number " + column + " Is " + celtext);
						break;
					}
				}
				System.out.println("--------------------------------------------------");
			}
			extent.pass(code);
			result = "PASS";
			Thread.sleep(1000);
		} catch (NoSuchElementException e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
			// rs.getScenarios(TSID, Description, Result);
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void eslStoreWebTableDoubleClick(String locatorType, String value, String text) throws IOException {

		try {
			System.out.println(value);
			System.out.println(text);
			String columname, Columvalue = null;
			File src = new File("C:\\Excel\\SystemGenValues.xls");
			// String filepath = "C:\\Excel\\SystemGenValues.xls";
			FileInputStream fis = new FileInputStream(src);

			@SuppressWarnings("resource")
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh1 = wb.getSheetAt(0);

			int rowcount = sh1.getLastRowNum();
			System.out.println("total rowNo=>" + rowcount);
			for (int j = 0; j <= rowcount; j++) {
				columname = sh1.getRow(j).getCell(0).getStringCellValue();
				if (text.equalsIgnoreCase(columname)) {
					Columvalue = sh1.getRow(j).getCell(1).getStringCellValue();

					break;
				}
			}
			// To locate table.
			WebElement mytable = WaitUtil.waitForEleTobevisible(By.id(value));
			// System.out.println("table is selected");
			// To locate rows of table.
			List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
			// To calculate no of rows In table.
			int rows_count = rows_table.size();

			// Loop will execute till the last row of table.
			for (int row = 0; row < rows_count; row++) {
				// To locate columns(cells) of that specific row.
				List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
				// To calculate no of columns(cells) In that specific row.
				int columns_count = Columns_row.size();
				// System.out.println("Number of cells In Row " + row + " are "
				// + columns_count);

				// Loop will execute till the last cell of that specific row.
				for (int column = 0; column < columns_count; column++) {
					// To retrieve text from that specific cell.
					System.out.println("true or false=>>"
							+ Columns_row.get(column).getText().trim().equalsIgnoreCase(Columvalue.trim()));
					if (Columns_row.get(column).getText().trim().equalsIgnoreCase(Columvalue.trim())) {
						String celtext = Columns_row.get(column).getText();
						// int rowNo=Columns_row.get(row);
						// selenium.click("//input[@value=rowNo]");
						int rowno = row;
						int colno = column;
						System.out.println("give me the sunshine=>>" + rowno + " " + "give me the rain=>>" + colno);
						System.out.println("yes");

						List<WebElement> Columns_row1 = rows_table.get(rowno).findElements(By.tagName("td"));
						// for(int i=0;i< Columns_row1.size();i++){
						// System.out.println("the content after if condition=>"+Columns_row1.get(i));
						// }
						Actions action = new Actions(driver);
						// action.moveToElement(mytable).doubleClick().build().perform();
						action.moveToElement(Columns_row1.get(0)).doubleClick().build().perform();
						// Columns_row1.get(0).click();
						System.out.println(
								"Cell Value Of row number" + row + " and column number " + column + " Is " + celtext);
						// for(int i=0;i< Columns_row1.size();i++){
						// System.out.println("the content after if condition=>"+Columns_row1.get(i));
						// }

						break;
					}
				}
				// System.out.println("--------------------------------------------------");
			}
			extent.pass(code);
			result = "PASS";
			Thread.sleep(1000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
			// rs.getScenarios(TSID, Description, Result);
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void webtableClick(String locatorType, String value, String text) throws InterruptedException, IOException {

		try {
			// System.out.println(value);
			// System.out.println(text);

			// To locate table.
			WebElement mytable = WaitUtil.waitForEleTobevisible(By.id(value));
			// System.out.println("table is selected");
			// To locate rows of table.
			List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
			// To calculate no of rows In table.
			int rows_count = rows_table.size();

			// Loop will execute till the last row of table.
			for (int row = 0; row < rows_count; row++) {
				// To locate columns(cells) of that specific row.
				List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
				// To calculate no of columns(cells) In that specific row.
				int columns_count = Columns_row.size();
				// System.out.println("Number of cells In Row " + row + " are "
				// + columns_count);

				// Loop will execute till the last cell of that specific row.
				for (int column = 0; column < columns_count; column++) {
					// To retrieve text from that specific cell.
					// System.out.println("true or false=>>"
					// +
					// Columns_row.get(column).getText().trim().equalsIgnoreCase(text.trim()));
					if (Columns_row.get(column).getText().trim().equalsIgnoreCase(text.trim())) {

						int rowno = row;

						// System.out.println("give me the sunshine=>>" + rowno
						// + " " + "give me the rain=>>" + colno);
						// System.out.println("yes");

						List<WebElement> Columns_row1 = rows_table.get(rowno).findElements(By.tagName("td"));
						// for(int i=0;i< Columns_row1.size();i++){
						// System.out.println("the content after if condition=>"+Columns_row1.get(i));
						// }
						Columns_row1.get(0).click();
						// System.out.println(
						// "Cell Value Of row number" + row +
						// " and column number " + column + " Is " + celtext);
					}
				}
				System.out.println("--------------------------------------------------");
			}
			result = "PASS";
			extent.pass(code);

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
			// rs.getScenarios(TSID, Description, Result);
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void webtableDoubleClick(String locatorType, String value, String text, String Status)
			throws InterruptedException, IOException {

		// //String Result = null;
		try {
			System.out.println(value);
			System.out.println(text);

			// To locate table.
			WebElement mytable = WaitUtil.waitForEleTobeClickble(By.id(value));
			// System.out.println("table is selected");
			// To locate rows of table.
			List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
			// To calculate no of rows In table.
			int rows_count = rows_table.size();

			// Loop will execute till the last row of table.
			for (int row = 0; row < rows_count; row++) {
				// To locate columns(cells) of that specific row.
				List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
				// To calculate no of columns(cells) In that specific row.
				int columns_count = Columns_row.size();
				// System.out.println("Number of cells In Row " + row + " are "
				// + columns_count);

				// Loop will execute till the last cell of that specific row.
				for (int column = 0; column < columns_count; column++) {
					// To retrieve text from that specific cell.
					// System.out.println("true or false=>>"
					// +
					// Columns_row.get(column).getText().trim().equalsIgnoreCase(text.trim()));
					if (Columns_row.get(column).getText().trim().equalsIgnoreCase(text.trim())) {
						// String celtext = Columns_row.get(column).getText();
						// int rowNo=Columns_row.get(row);
						// selenium.click("//input[@value=rowNo]");
						int rowno = row;
						// int colno = column;
						// System.out.println("give me the sunshine=>>" + rowno
						// + " " + "give me the rain=>>" + colno);
						// System.out.println("yes");

						List<WebElement> Columns_row1 = rows_table.get(rowno).findElements(By.tagName("td"));
						// for(int i=0;i< Columns_row1.size();i++){
						// System.out.println("the content after if condition=>"+Columns_row1.get(i));
						// }
						Actions action = new Actions(driver);
						// action.moveToElement(mytable).doubleClick().build().perform();
						action.moveToElement(Columns_row1.get(0)).doubleClick().build().perform();
						// Columns_row1.get(0).click();
						// System.out.println(
						// "Cell Value Of row number" + row +
						// " and column number " + column + " Is " + celtext);
						break;
					}
				}
				// System.out.println("--------------------------------------------------");
			}
			extent.pass(code);
			result = "PASS";
		} catch (NoSuchElementException e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
			// rs.getScenarios(TSID, Description, Result);
		}
	}

	public void mDOutputInsertImage(String locatorType, String value, String text) throws IOException {
		try {

			String columname, Columvalue = null;
			File src = new File("C:\\Excel\\SystemGenValues.xls");
			// String filepath = "C:\\Excel\\SystemGenValues.xls";
			FileInputStream fis = new FileInputStream(src);
			@SuppressWarnings("resource")
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh1 = wb.getSheetAt(0);
			int columncount = sh1.getRow(0).getLastCellNum();
			System.out.println(columncount);
			// int lastrow = lastrow = sh1.getLastRowNum();
			for (int i = 0; i <= columncount; i++) {
				columname = sh1.getRow(0).getCell(i).getStringCellValue();
				if (text.equalsIgnoreCase(columname)) {
					Columvalue = sh1.getRow(1).getCell(i).getStringCellValue();

					break;
				}
			}

			String[] arrSplit = Columvalue.split(",");
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.waitForEleTobevisible(locator);

			List<WebElement> options = element
					.findElements(By.xpath(".//span[contains(@class,'ui-treenode-label ui-corner-all')]"));

			for (int j = 1; j < options.size(); j++) {
				String parent = options.get(j).getText();
				System.out.println(parent);
				if (parent.equalsIgnoreCase(arrSplit[0])) {
					System.out.println("Index : " + j);
					System.out.println("********** Successfully selected ********");
					System.out.println("Selected parent node is : " + parent);
					options.get(j).click();
					// Thread.sleep(3000);
					driver.findElement(By.xpath(
							".//li[contains(@aria-selected,'true')]//span[contains(@class,'ui-tree-toggler ui-icon ui-icon-triangle-1-e')]"))
							.click();
					// Thread.sleep(2000);

					break;
				}
			}
			List<WebElement> options1 = element.findElements(By.xpath(
					".//ul[contains(@class,'ui-treenode-children')]//span[contains(@class,'ui-treenode-label ui-corner-all')]"));
			for (int k = 1; k < options1.size(); k++) {
				String child = options1.get(k).getText();
				System.out.println(child);
				if (child.equalsIgnoreCase(arrSplit[1])) {
					System.out.println("Index : " + k);
					System.out.println("********** Successfully selected ********");
					System.out.println("Selected child node is : " + child);
					options1.get(k).click();
					// Thread.sleep(2000);

					break;
				}
			}
			extent.pass(code);

			result = "PASS";

		} catch (Exception e) {

			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void mDInsertDocument(String locatorType, String value, String text) throws IOException {

		try {
			String[] arrSplit = text.split(",");
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);

			List<WebElement> options = element
					.findElements(By.xpath(".//span[contains(@class,'ui-treenode-label ui-corner-all')]"));

			for (int j = 1; j < options.size(); j++) {
				String parent = options.get(j).getText();
				System.out.println(parent);
				if (parent.equalsIgnoreCase(arrSplit[0])) {
					System.out.println("Index : " + j);
					System.out.println("********** Successfully selected ********");
					System.out.println("Selected parent node is : " + parent);
					options.get(j).click();
					// Thread.sleep(2000);
					driver.findElement(By.xpath(
							".//li[contains(@aria-selected,'true')]//span[contains(@class,'ui-tree-toggler ui-icon ui-icon-triangle-1-e')]"))
							.click();
					// Thread.sleep(2000);

					break;
				}
			}
			List<WebElement> options1 = element.findElements(By.xpath(
					".//ul[contains(@class,'ui-treenode-children')]//span[contains(@class,'ui-treenode-label ui-corner-all')]"));
			for (int k = 1; k < options1.size(); k++) {
				String child = options1.get(k).getText();
				System.out.println(child);
				if (child.equalsIgnoreCase(arrSplit[1])) {
					System.out.println("Index : " + k);
					System.out.println("********** Successfully selected ********");
					System.out.println("Selected child node is : " + child);
					options1.get(k).click();
					// Thread.sleep(2000);

					break;
				}
			}
			extent.pass(code);
			result = "PASS";

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void mDInsertImage(String locatorType, String value, String text) throws IOException {
		try {
			String[] arrSplit = text.split(",");
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);

			List<WebElement> options = element
					.findElements(By.xpath(".//span[contains(@class,'ui-treenode-label ui-corner-all')]"));

			for (int j = 1; j < options.size(); j++) {
				String parent = options.get(j).getText();
				System.out.println(parent);
				if (parent.equalsIgnoreCase(arrSplit[0])) {
					System.out.println("Index : " + j);
					System.out.println("********** Successfully selected ********");
					System.out.println("Selected parent node is : " + parent);
					// Thread.sleep(2000);
					options.get(j).click();
					options.get(j).click();
					// Thread.sleep(3000);
					driver.findElement(By.xpath(
							".//li[contains(@aria-selected,'true')]//span[contains(@class,'ui-tree-toggler ui-icon ui-icon-triangle-1-e')]"))
							.click();
					// Thread.sleep(2000);

					break;
				}
			}
			List<WebElement> options1 = element.findElements(By.xpath(
					".//ul[contains(@class,'ui-treenode-children')]//span[contains(@class,'ui-treenode-label ui-corner-all')]"));
			for (int k = 1; k < options1.size(); k++) {
				String child = options1.get(k).getText();
				System.out.println(child);
				if (child.equalsIgnoreCase(arrSplit[1])) {
					System.out.println("Index : " + k);
					System.out.println("********** Successfully selected ********");
					System.out.println("Selected child node is : " + child);
					options1.get(k).click();
					// Thread.sleep(2000);

					break;
				}
			}
			extent.pass(code);
			result = "PASS";

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

	// ***** used to Right click the folder(whatever visible at that time in the
	// tree) ************** //
	public void mDFolderRightClick(String text) throws IOException, InterruptedException {
		// String Result = null;

		try {
			String[] arrSplit = text.split(",");
			WebElement element = driver.findElement(By.id("DMSAD-DMSAD_tree"));
			List<WebElement> options = element
					.findElements(By.xpath(".//span[contains(@class,'ui-inplace ui-hidden-container')]"));
			for (int n = 0; n < options.size(); n++) {
				String menu = options.get(n).getText();
				System.out.println(menu);

				if (options.get(n).getText().equalsIgnoreCase(arrSplit[0])) {

					JavascriptExecutor jse = (JavascriptExecutor) driver;
					jse.executeScript("arguments[0].scrollIntoView();", options.get(n));
					System.out.println("********** Successfully selected ********");
					System.out.println("Selected value : " + options.get(n).getText());
					options.get(n).click();
					Thread.sleep(1000);

					Actions oAction = new Actions(driver);
					oAction.moveToElement(options.get(n));
					oAction.contextClick(options.get(n)).build().perform(); /*
																			 * this will perform right click
																			 */

					WebElement elementOpen = driver
							.findElement(By.linkText(arrSplit[1])); /*
																	 * This will select menu after right click
																	 */

					elementOpen.click();

					break;

				}

			}
			extent.pass(code);
			result = "PASS";
			// Thread.sleep(1000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void mDFocusRightClick(String text) throws IOException, InterruptedException {
		// //String Result = null;
		try {
			WebElement element = driver.findElement(By.id("DMSAD-DMSAD_tree"));
			WebElement element1 = element.findElement(By.xpath(".//span[contains(@aria-selected,'true')]"));
			// JavascriptExecutor jse = (JavascriptExecutor) driver;
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
					element1.findElement(By.xpath(".//span[contains(@class,'ui-inplace ui-hidden-container')]")));
			element1.findElement(By.xpath(".//span[contains(@class,'ui-inplace ui-hidden-container')]")).click();
			Thread.sleep(3000);

			Actions oAction = new Actions(driver);
			oAction.moveToElement(
					element1.findElement(By.xpath(".//span[contains(@class,'ui-inplace ui-hidden-container')]")));
			oAction.contextClick(
					element1.findElement(By.xpath(".//span[contains(@class,'ui-inplace ui-hidden-container')]")))
					.build().perform(); /* this will perform right click */
			WebElement elementOpen = driver.findElement(By.linkText(text)); /*
																			 * This will select menu after right click
																			 */

			elementOpen.click();
			extent.pass(code);
			result = "PASS";
			// Thread.sleep(1000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void contextMenuNeg() throws IOException, InterruptedException {
		// //String Result = null;
		try {
			WebElement element = driver.findElement(By.id("DMSAD-DMSAD_tree"));
			WebElement element1 = element.findElement(By.xpath(".//span[contains(@aria-selected,'true')]"));
			// JavascriptExecutor jse = (JavascriptExecutor) driver;
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
					element1.findElement(By.xpath(".//span[contains(@class,'ui-inplace ui-hidden-container')]")));
			element1.findElement(By.xpath(".//span[contains(@class,'ui-inplace ui-hidden-container')]")).click();
			Thread.sleep(3000);

			Actions oAction = new Actions(driver);
			oAction.moveToElement(
					element1.findElement(By.xpath(".//span[contains(@class,'ui-inplace ui-hidden-container')]")));
			oAction.contextClick(
					element1.findElement(By.xpath(".//span[contains(@class,'ui-inplace ui-hidden-container')]")))
					.build().perform(); /* this will perform right click */

			// WebElement elementOpen = driver.findElement(By.linkText(text));
			// /*This will
			// select menu after right click */

			// elementOpen.click();
			extent.pass(code);
			result = "PASS";
			// Thread.sleep(1000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void mDFocusClick(String text) throws IOException, InterruptedException {
		// //String Result = null;
		try {
			WebElement element = driver.findElement(By.id("DMSAD-DMSAD_tree"));
			WebElement element1 = element.findElement(By.xpath(".//span[contains(@aria-selected,'true')]"));
			// JavascriptExecutor jse = (JavascriptExecutor) driver;
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
					element1.findElement(By.xpath(".//span[contains(@class,'ui-inplace ui-hidden-container')]")));
			element1.findElement(By.xpath(".//span[contains(@class,'ui-inplace ui-hidden-container')]")).click();
			Thread.sleep(3000);
			extent.pass(code);

			result = "PASS";
			// Thread.sleep(1000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void mDOuputFolderRightClick(String text) throws IOException, InterruptedException {
		// //String Result = null;

		try {
			String[] arrSplit = text.split(",");
			String columname, Columvalue = null;
			File src = new File("C:\\Excel\\SystemGenValues.xls");
			// String filepath = "C:\\Excel\\SystemGenValues.xls";
			FileInputStream fis = new FileInputStream(src);
			@SuppressWarnings("resource")
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh1 = wb.getSheetAt(0);
			int columncount = sh1.getRow(0).getLastCellNum();
			System.out.println(columncount);
			// int lastrow = lastrow = sh1.getLastRowNum();
			for (int i = 0; i <= columncount; i++) {
				columname = sh1.getRow(0).getCell(i).getStringCellValue();
				if (arrSplit[0].equalsIgnoreCase(columname)) {
					Columvalue = sh1.getRow(1).getCell(i).getStringCellValue();
					break;
				}
			}

			WebElement element = driver.findElement(By.id("DMSAD-DMSAD_tree"));
			List<WebElement> options = element
					.findElements(By.xpath(".//span[contains(@class,'ui-inplace ui-hidden-container')]"));
			for (int n = 0; n < options.size(); n++) {
				String menu = options.get(n).getText();
				System.out.println(menu);

				if (options.get(n).getText().equalsIgnoreCase(Columvalue)) {

					JavascriptExecutor jse = (JavascriptExecutor) driver;
					jse.executeScript("arguments[0].scrollIntoView();", options.get(n));
					System.out.println("********** Successfully selected ********");
					System.out.println("Selected value : " + options.get(n).getText());
					options.get(n).click();
					// Thread.sleep(1000);

					Actions oAction = new Actions(driver);
					oAction.moveToElement(options.get(n));
					oAction.contextClick(options.get(n)).build().perform(); /*
																			 * this will perform right click
																			 */

					WebElement elementOpen = driver
							.findElement(By.linkText(arrSplit[1])); /*
																	 * This will select menu after right click
																	 */

					elementOpen.click();

					break;

				}

			}
			extent.pass(code);
			result = "PASS";
			// Thread.sleep(1000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	// ****** Used to select list values in conditional variables (If condition
	// after drop down) ******** //
	public void mDSelectList(String locatorType, String value, String text) throws IOException, InterruptedException {
		// //String Result = null;
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			List<WebElement> options = element
					.findElements(By.xpath(".//li[contains(@class,'ui-selectlistbox-item ui-corner-all')]"));
			for (int n = 0; n < options.size(); n++) {
				String menu = options.get(n).getText();
				System.out.println(menu);

				if (options.get(n).getText().equalsIgnoreCase(text)) {
					System.out.println("********** Successfully selected ********");
					System.out.println("Selected value : " + options.get(n).getText());
					options.get(n).click();
					// Thread.sleep(1000);
					break;
				}

			}
			extent.pass(code);
			result = "PASS";
			// Thread.sleep(1000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void mDOutputSelectList(String locatorType, String value, String text)
			throws IOException, InterruptedException {
		// //String Result = null;
		try {

			String columname, Columvalue = null;
			File src = new File("C:\\Excel\\SystemGenValues.xls");
			// String filepath = "C:\\Excel\\SystemGenValues.xls";
			FileInputStream fis = new FileInputStream(src);
			@SuppressWarnings("resource")
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh1 = wb.getSheetAt(0);
			int columncount = sh1.getRow(0).getLastCellNum();
			System.out.println(columncount);
			// int lastrow = lastrow = sh1.getLastRowNum();
			for (int i = 0; i <= columncount; i++) {
				columname = sh1.getRow(0).getCell(i).getStringCellValue();
				if (text.equalsIgnoreCase(columname)) {
					Columvalue = sh1.getRow(1).getCell(i).getStringCellValue();

					break;
				}
			}
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			List<WebElement> options = element
					.findElements(By.xpath(".//li[contains(@class,'ui-selectlistbox-item ui-corner-all')]"));
			for (int n = 0; n < options.size(); n++) {
				String menu = options.get(n).getText();
				System.out.println(menu);

				if (options.get(n).getText().equalsIgnoreCase(Columvalue)) {
					System.out.println("********** Successfully selected ********");
					System.out.println("Selected value : " + options.get(n).getText());
					options.get(n).click();
					// Thread.sleep(1000);
					break;
				}

			}
			extent.pass(code);
			result = "PASS";
			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void dropdown(String locatorType, String value, String text) throws IOException, InterruptedException {
		// //String Result = null;
		try {
			By locator;
			locator = locatorValue(locatorType, value);

			Select s = new Select(driver.findElement(locator));

			s.selectByVisibleText(text);

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public static void dropdownSelect(String locatorType, String value, String text)
			throws IOException, InterruptedException {
		// //String Result = null;
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);

			// WebElement element =
			// driver.findElement(By.id("DMS_SubmitOLPanelform-DMS_cmbDocType_items"));
			List<WebElement> options = element.findElements(By.xpath(value));

			for (int n = 0; n < options.size(); n++) {
				String menu = options.get(n).getText();

				if (options.get(n).getText().equalsIgnoreCase(text)) {

					Thread.sleep(1000);
					options.get(n).click();
					break;
					// Thread.sleep(2000);
				}

			}
			extent.pass(code);
			result = "PASS";

			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void outputDrpdwnSelect(String locatorType, String value, String text)
			throws IOException, InterruptedException {
		// //String Result = null;
		try {

			String columname, Columvalue = null;
			File src = new File("C:\\Excel\\SystemGenValues.xls");
			// String filepath = "C:\\Excel\\SystemGenValues.xls";
			FileInputStream fis = new FileInputStream(src);
			@SuppressWarnings("resource")
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh1 = wb.getSheetAt(0);
			int columncount = sh1.getRow(0).getLastCellNum();
			System.out.println(columncount);
			// int lastrow = lastrow = sh1.getLastRowNum();
			for (int i = 0; i <= columncount; i++) {
				columname = sh1.getRow(0).getCell(i).getStringCellValue();
				if (text.equalsIgnoreCase(columname)) {
					Columvalue = sh1.getRow(1).getCell(i).getStringCellValue();

					break;
				}
			}
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			List<WebElement> options = element.findElements(By
					.xpath(".//li[contains(@class,'ui-selectonemenu-item ui-selectonemenu-list-item ui-corner-all')]"));
			for (int n = 0; n < options.size(); n++) {
				String menu = options.get(n).getText();
				System.out.println(menu);

				if (options.get(n).getText().equalsIgnoreCase(Columvalue)) {
					System.out.println("********** Successfully selected ********");
					System.out.println("Selected value : " + options.get(n).getText());
					options.get(n).click();
					// Thread.sleep(1000);
					break;
				}

			}
			extent.pass(code);
			result = "PASS";
			// Thread.sleep(1000);
		} catch (Exception e) {

			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void eslOutputDropdownSelect(String locatorType, String value, String text)
			throws IOException, InterruptedException {
		// //String Result = null;
		try {

			String columname, Columvalue = null;
			File src = new File("C:\\Excel\\SystemGenValues.xls");
			// String filepath = "C:\\Excel\\SystemGenValues.xls";
			FileInputStream fis = new FileInputStream(src);
			@SuppressWarnings("resource")
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh1 = wb.getSheetAt(0);

			int rowcount = sh1.getLastRowNum();
			System.out.println("total rowNo=>" + rowcount);
			for (int j = 0; j <= rowcount; j++) {
				columname = sh1.getRow(j).getCell(0).getStringCellValue();
				if (text.equalsIgnoreCase(columname)) {
					Columvalue = sh1.getRow(j).getCell(1).getStringCellValue();

					break;
				}
			}
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			List<WebElement> options = element.findElements(By
					.xpath(".//li[contains(@class,'ui-selectonemenu-item ui-selectonemenu-list-item ui-corner-all')]"));
			for (int n = 0; n < options.size(); n++) {
				String menu = options.get(n).getText();
				System.out.println(menu);

				if (options.get(n).getText().equalsIgnoreCase(Columvalue)) {
					System.out.println("********** Successfully selected ********");
					System.out.println("Selected value : " + options.get(n).getText());
					options.get(n).click();
					Thread.sleep(1000);
					break;
				}

			}
			extent.pass(code);
			result = "PASS";
			// Thread.sleep(1000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void dropdownSelectNeg(String locatorType, String value, String text)
			throws IOException, InterruptedException {
		// //String Result = null;
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			// WebElement element =
			// driver.findElement(By.id("DMS_SubmitOLPanelform-DMS_cmbDocType_items"));
			List<WebElement> options = element.findElements(By
					.xpath(".//li[contains(@class,'ui-selectonemenu-item ui-selectonemenu-list-item ui-corner-all')]"));
			for (int n = 0; n < options.size(); n++) {
				String menu = options.get(n).getText();
				System.out.println(menu);

				if (options.get(n).getText().equalsIgnoreCase(text)) {
					System.out.println("********** Successfully selected ********");
					System.out.println("Selected value : " + options.get(n).getText());
					options.get(n).click();
					// Thread.sleep(2000);
					extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				} else {
					extent.pass(code);
					result = "PASS";
				}

			}

			Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);

			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void eslOutputFilter(String locatorType, String value, String text)
			throws IOException, InterruptedException {
		// //String Result = null;
		String[] arrSplit = text.split(",");
		try {

			String columname, Columvalue = null;
			File src = new File("C:\\Excel\\SystemGenValues.xls");
			// String filepath = "C:\\Excel\\SystemGenValues.xls";
			FileInputStream fis = new FileInputStream(src);
			@SuppressWarnings("resource")
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh1 = wb.getSheetAt(0);

			int rowcount = sh1.getLastRowNum();
			System.out.println("total rowNo=>" + rowcount);
			for (int j = 0; j <= rowcount; j++) {
				columname = sh1.getRow(j).getCell(0).getStringCellValue();
				if (arrSplit[1].equalsIgnoreCase(columname)) {
					Columvalue = sh1.getRow(j).getCell(1).getStringCellValue();

					break;
				}
			}

			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			element.findElement(By.xpath(".//th[contains(@aria-label,'" + arrSplit[0]
					+ ": activate to sort column ascending')]//input[contains(@role,'textbox')]")).sendKeys(Columvalue);
			// Thread.sleep(1000);
			extent.pass(code);
			result = "PASS";
			// Thread.sleep(1000);

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void mDUtilSelectAttachment(String locatorType, String value, String text)
			throws IOException, InterruptedException {
		// //String Result = null;
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			List<WebElement> options = element
					.findElements(By.xpath(".//a[contains(@class,'ui-commandlink ui-widget')]"));
			for (int n = 0; n < options.size(); n++) {
				String menu = options.get(n).getText();
				System.out.println(menu);

				if (options.get(n).getText().equalsIgnoreCase(text)) {
					System.out.println("********** Successfully selected ********");
					System.out.println("Selected value : " + options.get(n).getText());
					options.get(n).click();
					// Thread.sleep(2000);
				}

			}
			extent.pass(code);
			result = "PASS";
			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void storeSNo(String locatorType, String value)
			throws IOException, InterruptedException, RowsExceededException, WriteException {
		// String path = "C:\\SerialNumber";
		String path = "E:\\framework sheet1";
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.waitForEleTobevisible(locator);
			String test = element.getAttribute("value");
			// String Textvalue1=element.getAttribute("value");
			System.out.println("printvalue" + test);
			// String[] Textvalue = test.split(":");
			// requiredSno = Textvalue[1];
			// System.out.println(requiredSno);
			File filepath = new File(path);

			if (!filepath.exists()) {
				System.out.println("yes" + test);
				ExcFileUtil.makeFileDir(path);
				ExcFileUtil.setValueInACell(path, "\\read.xls", "Serial No", test);
				System.out.println("yes1" + test);

			} else {
				System.out.println("ye1s1" + test);
				ExcFileUtil.updateValueInACell("E:\\mack framework\\framework sheet\\read.xls", test);
				System.out.println("no" + test);
			}

			result = "PASS";
			extent.pass(m);
			// extent.info("Serial Number : "+requiredSno);
		} catch (FileNotFoundException fe) {
			// ExcFileUtil.setValueInACell(path, "/SerialNo.xls", "Serial No",
			// requiredSno);
			result = "PASS";
			extent.pass(code);
			// extent.info("Serial Number : "+requiredSno);
		} catch (Exception e) {
			Log.error("some Exception found here=>" + e);
			result = "FAIL";

		}

		data.add(result);
		anotherMethod(result, data);
	}

	public void landingPageFilter(String requiredFilterName) throws IOException, InterruptedException {

		try {

			ExcFileUtil.getCellValue("C:\\SerialNumber\\SerialNo.xls", ExcFileUtil.value);
			// filter = WaitUtil.waitForEleTobevisible(By.id("datagrid"));
			WebElement filter = WaitUtil.waitForEleTobeClickble(By.xpath(".//i[contains(@class,'fa fa-filter')]"));
			javaScriptClick(filter);

			List<WebElement> headers = driver.findElements(By.xpath("//*[@id=\"datagrid_head\"]/tr/th"));

			for (WebElement header : headers) {
				// String header = headers.get(i).getText();
				// System.out.println(header);
				if (header.getText().equals(requiredFilterName))

				{
					WebElement textbox = WaitUtil.waitForEleTobevisible(By.xpath("//span[contains(./text(),'"
							+ requiredFilterName + "')]/following::input[1][@style='display: block;']"));
					System.out.println(textbox);
					if (textbox.isDisplayed()) {
						textbox.sendKeys(ExcFileUtil.value);
						WaitUtil.waitForEleTobeInvisible(By.xpath("//*[@id='datagrid_data']/tr[2]"));
						JavascriptExecutor jse = (JavascriptExecutor) driver;
						jse.executeScript("javascript:window.scrollBy(-2500,0)");
						extent.pass(code);
						result = "PASS";
						break;
					} else {
						System.out.println("the filter is not displayed");

					}
				}

			}

		} catch (Exception e) {
			extent.fail(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("some Exception found here=>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void navigateBack() throws IOException, InterruptedException {

		try {
			driver.navigate().back();

		} catch (Exception e) {
			extent.fail(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("some Exception found here=>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
//ponumna kalambunga muthu i will see what to do enaku therenjadha podura muthu
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void shipStatus(String requiredHeader) throws IOException, InterruptedException {

		try {
			List<WebElement> headers = driver.findElements(By.xpath("//*[@id=\"datagrid_head\"]/tr/th"));
			for (int i = 0; i < headers.size(); i++) {
				String header = headers.get(i).getText();
				System.out.println(header);
				if (header.equals(requiredHeader)) {
				}
			}

			extent.pass(code);
			result = "PASS";
			// Thread.sleep(1000);

		} catch (Exception e) {

			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void filter(String locatorType, String value, String text) throws IOException, InterruptedException {
		// ////String Result = null;
		try {
			/*
			 * File src = new File("C:\\Serial\\SerialNo.xls");
			 * 
			 * FileInputStream fis = new FileInputStream(src);
			 * 
			 * @SuppressWarnings("resource") HSSFWorkbook wb = new HSSFWorkbook(fis);
			 * HSSFSheet sh1 = wb.getSheetAt(0); String requiredSerialNo =
			 * sh1.getRow(0).getCell(0).getStringCellValue();
			 * System.out.println(requiredSerialNo); fis.close();
			 */
			ExcFileUtil.getCellValue("C:\\SerialNumber\\SerialNo.xls", ExcFileUtil.value);
			By locator;
			locator = locatorValue(locatorType, value);

			WebElement element = driver.findElement(locator);
			element.findElement(By.xpath(".//th[contains(@aria-label,'" + text
					+ ": activate to sort column ascending')]//input[contains(@role,'textbox')]"))
					.sendKeys(ExcFileUtil.value);
			Thread.sleep(2000);
			Log.info("The Required Serial No. : " + ExcFileUtil.value);
			extent.pass(code);
			result = "PASS";

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void dynamicWebTable(String locatorType, String value, String text)
			throws IOException, InterruptedException {
		// String Result = null;
		try {
			File src = new File("C:\\Serial\\SerialNo.xls");
			FileInputStream fis = new FileInputStream(src);
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh1 = wb.getSheetAt(0);
			String requiredSerialNo = sh1.getRow(0).getCell(0).getStringCellValue().trim();
			System.out.println(requiredSerialNo);
			fis.close();
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);

			List<WebElement> page = element.findElements(By.xpath(".//*[@id='datagrid_paginator_bottom']/span/a"));
			// System.out.println(page);
			// This loop will iterate the page until the test data is found
			mainLoop: for (int i = 1; i < page.size(); i++) {

				String sPage = driver.findElement(By.xpath(".//*[@id='datagrid_paginator_bottom']/span/a[" + i + "]"))
						.getText();
				System.out.println(sPage);
				driver.findElement(By.xpath(".//*[@id='datagrid_paginator_bottom']/span/a[" + i + "]")).click();
				Thread.sleep(2000);

				List<WebElement> options = element.findElements(By.xpath(".//*[@id='datagrid_data']/tr/td[3]"));
				for (int j = 1; j < options.size(); j++) {
					String sValue = driver.findElement(By.xpath(".//*[@id='datagrid_data']/tr[" + j + "]/td[3]"))
							.getText();

					System.out.println(sValue);

					if (sValue.equals(requiredSerialNo)) {
						String table = driver.findElement(By.xpath(".//*[@id='datagrid_data']/tr[" + j + "]/td[3]"))
								.getText();
						System.out.println(table);
						WebElement element1 = driver
								.findElement(By.xpath(".//*[@id='datagrid_data']/tr[" + j + "]/td[3]"));
						Actions action = new Actions(driver);
						action.moveToElement(element1).doubleClick().build().perform();
						break mainLoop;
					}

				}
			}

			// System.out.println(options);
			// This loop will find the test data in the Ref id column

			extent.pass(code);
			result = "PASS";

			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("some Exception found here=>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void mDTextEditor(String locatorType, String value, String text) throws IOException, InterruptedException {

		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			driver.switchTo().frame(element);
			// Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body")).sendKeys(text);
			driver.switchTo().defaultContent();
			// Thread.sleep(1000);
			extent.pass(code);
			result = "PASS";
			// Thread.sleep(1000);

		} catch (Exception e) {

			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void fileUpload(String text) throws IOException, InterruptedException {

		try {
			StringSelection ss = new StringSelection(text);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			extent.pass(code);
			result = "PASS";
			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void mackStoreText(String locatorType, String value, String text) throws EncryptedDocumentException,
			InvalidFormatException, IOException, BiffException, InterruptedException {
		try {
			// String Verification = "Yes";
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			String Textvalue = element.getAttribute("value");
			System.out.println("text to be copied=>" + Textvalue);

			String[] arrSplit = text.split(",");
			int lastrow;
			// C:\\Excel\\SystemGenValues.xls
			File src = new File("C:\\Excel\\SystemGenValues.xls");
			String filepath = "C:\\Excel\\SystemGenValues.xls";
			FileInputStream fis = new FileInputStream(src);
			@SuppressWarnings("resource")
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh1 = wb.getSheetAt(0);
			int columncount = sh1.getRow(0).getLastCellNum();
			System.out.println("total columNo=>" + columncount);

			lastrow = sh1.getLastRowNum();
			System.out.println("last row is=>" + lastrow);

			for (int j = 0; j < columncount; j++) {
				String datastore = sh1.getRow(0).getCell(j).getStringCellValue();
				System.out.println(datastore);
				if (datastore.equalsIgnoreCase(arrSplit[0])) {
					HSSFRow row = sh1.getRow(lastrow);
					HSSFCell cell = row.createCell(j);
					cell.setCellValue(Textvalue);
					String datastore1 = cell.getStringCellValue();
					System.out.println(datastore1);
					break;

				}

			}

			FileOutputStream fileOut = new FileOutputStream(filepath);
			wb.write(fileOut);
			extent.pass(code);
			result = "PASS";
		} catch (NoSuchElementException e) {
			extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void verifyEnable(String locatorType, String value) throws IOException, InterruptedException {
		// //String Result = null;
		try {
			By locator;
			locator = locatorValue(locatorType, value);

			WebElement element = driver.findElement(locator);

			if (element.isEnabled()) {

				System.out.print("True");
				result = "PASS";
				extent.pass(code);

				// Thread.sleep(2000);
			} else {
				extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}

			// result = "<a href=" + ScreenShot() + "> FAIL</a>";
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void verifyDisable(String locatorType, String value) throws IOException, InterruptedException {
		// //String Result = null;
		try {
			By locator;
			locator = locatorValue(locatorType, value);

			WebElement element = driver.findElement(locator);
			if (element.isEnabled()) {

				System.out.print("True");
				extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			} else {
				extent.pass(code);
				System.out.print("False");
				result = "PASS";

			}
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void verifyElementNeg(String locatorType, String value) throws IOException, InterruptedException {
		// //String Result = null;
		try {
			By locator;
			locator = locatorValue(locatorType, value);

			if (driver.findElements(locator).size() != 0) {
				System.out.println("Element is Present ElementStatus");
				extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			} else {
				extent.pass(code);
				// System.out.print("False");
				// System.out.println("Element is Absent");
				result = "PASS";

			}
		} catch (Exception e) {

			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			System.out.print("Element not found" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void verifyHrefDisable(String locatorType, String value) throws IOException, InterruptedException {

		try {
			By locator;
			locator = locatorValue(locatorType, value);

			WebElement element = WaitUtil.fluentWait(locator);

			if (element.getAttribute("class").contains("disabled")) {
				extent.pass(code);
				result = "PASS";

			} else {
				extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void verifyMandatoryField(String locatorType, String value) throws IOException, InterruptedException {

		// //String Result = null;
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			// WebElement element = driver.findElement(locator);
			String element = driver.findElement(locator).getCssValue("box-shadow");
			System.out.print(element);
			String az = "rgb(230, 42, 16)";
			if (element.contains(az)) {
				System.out.println("True");
				extent.pass(code);
				result = "PASS";
			}

			else {
				extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				Log.error("EXCEPTION DESCRIPTION=====>");
				System.out.println("False");
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void verifyMandatoryNot(String locatorType, String value) throws IOException, InterruptedException {

		// //String Result = null;
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			// WebElement element = driver.findElement(locator);
			String element = driver.findElement(locator).getCssValue("box-shadow");
			System.out.print(element);
			String az = "rgb(230, 42, 16)";

			if (element.contains(az)) {
				extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				Log.error("EXCEPTION DESCRIPTION=====>");
				System.out.println("red");
				result = "<a href=" + ScreenShot() + "> FAIL</a>";

				extent.pass(code);
				result = "PASS";
			}

			else {
				System.out.println("not red");
				extent.pass(code);
				result = "PASS";
			}
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void verifyHrefEnable(String locatorType, String value) throws IOException, InterruptedException {

		// //String Result = null;
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);
			if (element.getAttribute("class").contentEquals("ui-commandlink ui-widget")) {
				System.out.print("a tag enabled");
				extent.pass(code);
				result = "PASS";

			}

			else {
				extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				// System.out.print("False");
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void verifyLabelnBG(String locatorType, String value, String text) throws IOException, InterruptedException {
		// //String Result = null;
		String[] arrSplit = text.split(":");
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.waitForEleTobevisible(locator);
			String label = element.getText();
			bgColor = driver.findElement(locator).getCssValue("background-color");
			if (label.equals(arrSplit[0]) && bgColor.equals(arrSplit[1])) {
				Log.info(label);
				Log.info(bgColor);
				result = "PASS";
				extent.pass(code);
			} else {
				extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			// System.out.println("Element not present");
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void verifyBGColor(String locatorType, String value, String text) throws IOException, InterruptedException {

		try {
			By locator;
			locator = locatorValue(locatorType, value);
			String element = driver.findElement(locator).getCssValue("background-color");

			Log.info("The Expected Back-ground Color :" + element);
			Log.info("The Actual Back-ground Color :" + text);
			if (element.equals(text)) {
				// System.out.println("True");
				extent.pass(code);
				result = "PASS";

			}

			else {
				extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}

			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void sendMessage(String message) throws IOException, InterruptedException {

		try {
			WebElement chat = WaitUtil.waitForEleTobeClickble(By.xpath("//i[@class=\"fa fa-commenting-o\"]"));
			javaScriptClick(chat);
			WebElement msg = WaitUtil.waitForEleTobeClickble(By.xpath("//span[text()='Send']//preceding::input[1]"));
			msg.sendKeys(message);

			driver.findElement(By.xpath("//span[text()='Send']")).click();

			WaitUtil.waitForEleTobevisible(By.xpath("//span[text()='Send']"));
			List<WebElement> options = WaitUtil
					.waitForElementsTobevisible(By.xpath("//*[@id='slideout']/following::div[1]/div/div[1]/div[2]"));

			for (int i = 0; i < options.size(); i++) {
				if (options.get(i).getText().contains(message)) {
					result = "PASS";
					extent.pass(code);

					break;

				} else {
					extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
					Log.error("Messaege is not sent");
					result = "<a href=" + ScreenShot() + "> FAIL</a>";
				}
			}
			driver.findElement(By.xpath("//*[@id='CWC_sendDiv']/following::a[1]")).click();
		}

		catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void verifyMessage(String message) throws IOException, InterruptedException {

		try {
			WebElement chat = WaitUtil.waitForEleTobeClickble(By.xpath("//i[@class=\"fa fa-commenting-o\"]"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", chat);

			List<WebElement> options = WaitUtil
					.waitForElementsTobevisible(By.xpath("//*[@id='slideout']/following::div[1]/div/div[1]/div[2]"));
			if (options.get(0).getText().contains(message)) {
				result = "PASS";
				extent.pass(code);
			} else {
				extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				Log.error("Messaege is not received");
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}

			driver.findElement(By.xpath("//*[@id='CWC_sendDiv']/following::a[1]")).click();

		} catch (Exception e) {

			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
		}

		data.add(result);
		anotherMethod(result, data);
	}

	public void verifyWorkFlow(String status) throws IOException, InterruptedException {

		try {

			WebElement waitForWorkFlow = WaitUtil.waitForEleTobeClickble(By.xpath("//i[@class=\"fa fa-history\"]"));
			javaScriptClick(waitForWorkFlow);
			WebElement statusChange = WaitUtil.waitForEleTobevisible(
					By.xpath("//li[1]/div/div/div/div[3]/span[contains(./text(),'" + status.trim() + "')]"));

			List<WebElement> loginDetail = driver
					.findElements((By.xpath("//*[@id=\"nfr_layoutwrapper\"]/div[1]/div[2]/ul/li[1]/a[2]/ul/li")));
			String loginUsername = loginDetail.get(0).getText();
			String loginDesig = loginDetail.get(1).getText();

			List<WebElement> workFlow = WaitUtil.waitForElementsTobevisible(By.xpath("//div/li[1]/div/div/div/div"));

			String login = workFlow.get(0).getText();
			String designation = workFlow.get(1).getText();
			String workFlowStatus = workFlow.get(2).getText();
			if (loginUsername.equals(login) && loginDesig.equals(designation) && workFlowStatus.equals(status.trim())) {
				bgColor = statusChange.getCssValue("background-color");
				Boolean verify = ColorUtil.verifyStatus(status.trim());

				if (verify) {
					result = "PASS";
					extent.pass(code);
					extent.info(" WorkFlow Username: " + login + "," + "Designation: " + designation + ", " + "Status: "
							+ workFlowStatus);
				} else {
					extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
					extent.info(" WorkFlow Username: " + login + "," + "Designation: " + designation + ", " + "Status: "
							+ workFlowStatus + ", " + "Back-ground Color" + bgColor);
					Log.error("ERROR DESCRIPTION=====>Status color is not matched ");
					result = "<a href=" + ScreenShot() + "> FAIL</a>";
				}

			} else {
				extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				extent.info(" WorkFlow Username: " + login + "," + "Designation: " + designation + ", " + "Status: "
						+ workFlowStatus + "|| Login Username: " + loginUsername + "," + "Designation: " + loginDesig);
				Log.error("ERROR DESCRIPTION=====>Login Details and the Work Flow Details are not matched ");
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}
			driver.findElement(By.xpath(".//div[contains(@class,'ui-g-7')]//following::a[1]	")).click();
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void verifyUDntHvAccessMsg() throws IOException, InterruptedException {
		try {

			WebElement toolBar = WaitUtil.waitForEleTobeClickble(By.xpath("//i[contains(@class ,'fa fa-ellipsis-h')]"));
			javaScriptClick(toolBar);
			WaitUtil.waitForEleTobevisible(By.xpath("//*[@class='collapse in']"));
			WebElement editButton = driver.findElement(By.xpath("//span[text()='Edit']"));

			boolean attribute = isAttributePresent(editButton, "aria-disabled");
			if (!attribute) {
				javaScriptClick(editButton);
				WaitUtil.waitForEleTobevisible(By.xpath("//div[contains(@id,'lrp_cust_dailog')][@aria-live='polite']"));
				WebElement message = driver.findElement(By.xpath("//*[@id=\"sm_dialogutil_grid_msglabel\"]"));

				String expectedMessage = getText(message);
				if (expectedMessage.equals("You do not have access to edit this form")) {

					WebElement ok = driver.findElement(By.xpath(".//*[@id='sm_dialogutil_grid_btn1']"));
					javaScriptClick(ok);
					extent.pass(code);
					result = "PASS";

				} else {
					Log.error("ERROR FOUND HERE=====> Validation is not matched");
					extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
					result = "<a href=" + ScreenShot() + "> FAIL</a>";
				}

			} else {
				Log.error("ERROR FOUND HERE=====> EditButton is not enabled");
				extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("ERROR FOUND HERE=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void verifyNewRecConfMsg() throws IOException, InterruptedException {
		try {
			WebElement toolBar = WaitUtil.waitForEleTobeClickble(By.xpath("//i[contains(@class ,'fa fa-ellipsis-h')]"));
			javaScriptClick(toolBar);
			WaitUtil.waitForEleTobevisible(By.xpath("//*[@class='collapse in']"));
			WebElement newBtn = driver.findElement(By.xpath("//span[text()='New']"));

			boolean attribute = isAttributePresent(newBtn, "aria-disabled");
			if (!attribute) {
				javaScriptClick(newBtn);
				WaitUtil.waitForEleTobevisible(By.xpath("//div[contains(@id,'lrp_cust_dailog')][@aria-live='polite']"));

				WebElement yes = driver.findElement(By.xpath(".//*[@id='sm_dialogutil_grid_btn1']"));
				WebElement no = driver.findElement(By.xpath(".//*[@id='sm_dialogutil_grid_btn2']"));
				if (yes.isEnabled() && no.isEnabled()) {

					javaScriptClick(yes);
					extent.pass(code);
					result = "PASS";
				}

			}

			else {
				Log.error("ERROR FOUND HERE=====> EditButton is not enabled");
				extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("ERROR FOUND HERE=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void eslOutputCustomerType(String locatorType, String value, String text)
			throws IOException, InterruptedException {
		// //String Result = null;
		try {

			String columname, Columvalue = null;
			File src = new File("C:\\Excel\\SystemGenValues.xls");
			// String filepath = "C:\\Excel\\SystemGenValues.xls";
			FileInputStream fis = new FileInputStream(src);
			@SuppressWarnings("resource")
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh1 = wb.getSheetAt(0);

			int rowcount = sh1.getLastRowNum();
			System.out.println("total rowNo=>" + rowcount);
			for (int j = 0; j <= rowcount; j++) {
				columname = sh1.getRow(j).getCell(0).getStringCellValue();
				if (text.equalsIgnoreCase(columname)) {
					Columvalue = sh1.getRow(j).getCell(1).getStringCellValue();

					break;
				}
			}
			By locator;
			locator = locatorValue(locatorType, value);

			WebElement element = driver.findElement(locator);
			List<WebElement> options = element
					.findElements(By.xpath(".//li[contains(@class,'ui-selectlistbox-item ui-corner-all')]"));
			System.out.println("Testing11--->" + options.size());
			for (int i = 0; i < options.size(); i++) {
				String rowSize = options.get(i).getText();
				System.out.println("Testing--->" + rowSize);
				if (options.get(i).getText().equals(Columvalue)) {
					options.get(i).click();
					System.out.println("True");
					extent.pass(code);
					result = "PASS";
					// Thread.sleep(1000);

				}

				else {

					extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
					result = "<a href=" + ScreenShot() + "> FAIL</a>";
				}

			}
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void eslSelectCustomerType(String locatorType, String value, String text)
			throws IOException, InterruptedException {
		// //String Result = null;
		try {

			By locator;
			locator = locatorValue(locatorType, value);

			WebElement element = driver.findElement(locator);
			List<WebElement> options = element
					.findElements(By.xpath(".//li[contains(@class,'ui-selectlistbox-item ui-corner-all')]"));
			System.out.println("Testing11--->" + options.size());
			for (int i = 0; i < options.size(); i++) {
				String rowSize = options.get(i).getText();
				System.out.println("Testing--->" + rowSize);
				if (options.get(i).getText().equals(text)) {
					options.get(i).click();

					System.out.println("True");
					extent.pass(code);
					result = "PASS";
					break;
					// Thread.sleep(1000);

				}

				else {

					extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
					result = "<a href=" + ScreenShot() + "> FAIL</a>";
				}

			}
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void verifyText(String locatorType, String value, String text) throws IOException, InterruptedException {
		// //String Result = null;
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			String textvalue = element.getText();
			System.out.println(textvalue);
			if (textvalue.trim().equals(text.trim())) {

				result = "PASS";
				extent.pass(code);
				Log.info("The Expected Text:" + textvalue.trim());
			} else {
				extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			// System.out.println("Element not present");
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void outputVerifyText(String locatorType, String value, String text)
			throws IOException, InterruptedException {
		// //String Result = null;
		try {

			String columname, Columvalue = null;
			File src = new File("C:\\Excel\\SystemGenValues.xls");
			// String filepath = "C:\\Excel\\SystemGenValues.xls";
			FileInputStream fis = new FileInputStream(src);
			@SuppressWarnings("resource")
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh1 = wb.getSheetAt(0);
			int columncount = sh1.getRow(0).getLastCellNum();
			System.out.println(columncount);
			// int lastrow = lastrow = sh1.getLastRowNum();
			for (int i = 0; i <= columncount; i++) {
				columname = sh1.getRow(0).getCell(i).getStringCellValue();
				if (text.equals(columname)) {
					Columvalue = sh1.getRow(1).getCell(i).getStringCellValue();
					break;
				}
			}
			By locator;
			locator = locatorValue(locatorType, value);
			String textvalue = driver.findElement(locator).getText();
			if (textvalue.equals(Columvalue)) {
				System.out.println(textvalue);
				System.out.println("Element present");
				result = "PASS";
			}

			else {
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}
			Thread.sleep(1000);
		} catch (Exception e) {

			System.err.format("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void verifyTextNeg(String locatorType, String value, String text) throws IOException, InterruptedException {
		// //String Result = null;
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			String textvalue = driver.findElement(locator).getText();
			if (textvalue.equals(text)) {
				System.out.println(textvalue);
				// System.out.println("Element present");
				extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";

				// Thread.sleep(2000);
			} else {
				extent.pass(code);
				result = "PASS";
			}
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			// System.out.println("Element not present");
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void mDVerifyButton(String locatorType, String value) throws IOException {
		// //String Result = null;
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			if (element.getText().equals("")) {
				System.out.print("True");
				extent.pass(code);
				result = "PASS";
			} else {

				extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				Log.error("Verification Failed");

				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void verifyElement(String locatorType, String value) throws IOException {
		// //String Result = null;

		try {

			By locator;
			locator = locatorValue(locatorType, value);
			// Thread.sleep(2000);
			Boolean element = driver.findElement(locator).isDisplayed();

			if (element == true) {
				System.out.println("Dialog is appearing");
			}

			// Thread.sleep(2000);

			result = "PASS";
			extent.pass(code);
			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void verifyFileDownload(String locatorType, String value, String text)
			throws IOException, InterruptedException {
		// //String Result = null;
		try {

			String[] arrSplit = text.split(",");
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			List<WebElement> options = element
					.findElements(By.xpath(".//a[contains(@class,'ui-commandlink ui-widget nfr_dm_link')]"));
			for (int n = 0; n < options.size(); n++) {
				String menu = options.get(n).getText();
				System.out.println(menu);

				if (options.get(n).getText().equalsIgnoreCase(arrSplit[0])) {
					System.out.println("********** Successfully selected ********");
					System.out.println("Selected value : " + options.get(n).getText());
					options.get(n).click();
					// Thread.sleep(2000);
					break;
				}
			}
			Thread.sleep(5000);
			File f = new File(arrSplit[1]);
			if (f.exists()) {
				Log.info("File existed");
			}
			extent.pass(code);
			result = "PASS";
			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.info("File not found!");
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void verifyDownload(String locatorType, String value, String text) throws IOException, InterruptedException {
		// //String Result = null;
		try {

			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);

			List<WebElement> options = element
					.findElements(By.xpath(".//a[contains(@class,'ui-commandlink ui-widget nfr_dm_link')]"));
			Thread.sleep(1000);
			System.out.println(options.size());
			String menu1 = options.get(0).getText();
			System.out.println(menu1);

			for (int n = options.size() - 1; n >= 0; n--) {
				String menu = options.get(n).getText();
				System.out.println(menu);

				if (options.get(n).getText().equalsIgnoreCase(text)) {
					System.out.println("********** Successfully selected ********");
					System.out.println("Selected value : " + options.get(n).getText());
					options.get(n).click();
					Thread.sleep(1000);
					break;
				}
			}
			extent.pass(code);
			result = "PASS";
			// Thread.sleep(1000);
		} catch (Exception e) {
			Log.info("File not found!");
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void verifyDownloadLocalPath(String text) throws IOException, InterruptedException {
		// //String Result = null;
		try {

			File f = new File(text);
			if (f.exists()) {
				Log.info("File existed");
			}
			extent.pass(code);
			result = "PASS";
			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			Log.info("File not found!");

			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void verifyNotification(String locatorType, String value, String text)
			throws IOException, InterruptedException {
		// //String Result = null;
		try {
			String Columvalue = null, columname;
			String[] arrSplit = text.split(",");
			int lastrow;
			File src = new File(arrSplit[0]);
			System.out.println("File" + src);
			String filepath = arrSplit[0];
			System.out.println("Filelocation" + filepath);
			System.out.println("Second Array" + arrSplit[1]);
			String columname1 = arrSplit[1];
			FileInputStream fis = new FileInputStream(src);
			@SuppressWarnings("resource")
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh1 = wb.getSheetAt(0);
			int columncount = sh1.getRow(0).getLastCellNum();
			System.out.println(columncount);
			lastrow = sh1.getLastRowNum();
			for (int i = 0; i <= columncount; i++) {
				columname = sh1.getRow(0).getCell(i).getStringCellValue();
				System.out.println(columname);

				if (columname1.equalsIgnoreCase(columname)) {
					Columvalue = sh1.getRow(1).getCell(i).getStringCellValue();
					System.out.println(Columvalue);

					break;
				}
			}

			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			List<WebElement> options = element
					.findElements(By.xpath(".//a[contains(@class,'ui-commandlink ui-widget')]"));

			for (int j = 1; j < options.size(); j++) {

				String notification;
				notification = driver
						.findElement(
								By.xpath("html/body/div[1]/div[1]/div[2]/ul/li[5]/ul/form/div/a[" + j + "]/ul/li[3]"))
						.getText();
				System.out.println(notification);

				if (notification.contains("" + Columvalue + " is pending")) {
					System.out.println("Index : " + j);
					System.out.println("********** Successfully selected ********");
					System.out.println("Selected value : " + notification);
					JavascriptExecutor jse = (JavascriptExecutor) driver;
					jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(
							By.xpath("html/body/div[1]/div[1]/div[2]/ul/li[5]/ul/form/div/a[" + j + "]/ul/li[3]")));
					driver.findElement(
							By.xpath("html/body/div[1]/div[1]/div[2]/ul/li[5]/ul/form/div/a[" + j + "]/ul/li[3]"))
							.click();
					Thread.sleep(5000);

					break;

				}
			}
			extent.pass(code);
			result = "PASS";
			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);

			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void storeWebTable(String locatorType, String value, String text) throws IOException, InterruptedException {
		// //String Result = null;
		try {

			String[] arrSplit = text.split(",");
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			List<WebElement> allRows = element.findElements(By.tagName("tr"));
			int rowSize = allRows.size();
			System.out.println(rowSize);
			File file = new File(arrSplit[0]);
			FileInputStream fis = new FileInputStream(file);
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sheet1 = wb.getSheet(arrSplit[1]);
			HSSFRow row;
			for (int i = 0; i < rowSize; i++) {
				WebElement webRow = allRows.get(i);
				List<WebElement> allCells = webRow.findElements(By.tagName("td"));
				HSSFRow excelRow = sheet1.createRow(i);

				for (int j = 0; j < allCells.size(); j++) {
					WebElement webCell = allCells.get(j);
					String data = webCell.getText();
					HSSFCell excelCell = excelRow.createCell(j);
					excelCell.setCellValue(webCell.getText());
				}
			}
			FileOutputStream fileOut = new FileOutputStream(file);
			wb.write(fileOut);
			// Thread.sleep(2000);
			extent.pass(code);
			result = "PASS";
			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void verifyNull(String locatorType, String value) throws IOException {
		// //String Result = null;
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			String element_value = element.getAttribute("value");
			if (element_value.equals("")) {
				{
					Log.info("Field is empty");
					extent.pass(code);
					result = "PASS";
				}
			} else {
				// System.out.println("Field is not empty");
				extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				Log.info("Value in the filed : " + element_value);

				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}

			// Thread.sleep(1000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void verifyNullNeg(String locatorType, String value) throws IOException {
		// //String Result = null;
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			String element_value = element.getAttribute("value");
			if (element_value.equals("")) {
				{
					// System.out.println("Field is empty");

					extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
					Log.info("Value in the filed : " + element_value);
					result = "<a href=" + ScreenShot() + "> FAIL</a>";

				}
			} else {
				Log.info("Field is not empty");
				extent.pass(code);
				result = "PASS";

			}

			// Thread.sleep(1000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void verifyCurrentDate(String locatorType, String value) throws IOException {
		// //String Result = null;
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			LocalDate localDate = LocalDate.now();
			System.out.println("Current date is : " + DateTimeFormatter.ofPattern("dd/MM/yyyy").format(localDate));
			String current_date = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(localDate);
			String date = driver.findElement(locator).getAttribute("value");
			Log.info("Date in that field : " + date);
			if (date.equals(current_date)) {
				Log.info("Current date is displayed");
				extent.pass(code);
				result = "PASS";
			} else {
				Log.info("Date displayed Wrongly");
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}

			// Thread.sleep(2000);
		} catch (Exception e) {

			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void close_browser() throws IOException {
		try {
			driver.close();
			// Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");

			result = "PASS";
			extent.pass(code);

			System.out.println("test");
			// Keywords.report.close();

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void close_ALLbrowser() throws IOException {
		try {
			driver.quit();
			// Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");

			result = "PASS";
			extent.pass(code);

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void Delete_Cookies() throws IOException {
		try {
			driver.manage().deleteAllCookies();

			result = "PASS";
			extent.pass(code);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	// ******************Used to split the BL number in combined bl and store it
	// in excel(Example--EPIRAEESAD000001-MASTER BL-CONFIRMED-NOT CLOSED then
	// split the bl no EPIRAEESAD000001)
	public void eslCombinedBL(String locatorType, String value, String text)
			throws IOException, InterruptedException, RowsExceededException, WriteException {
		try {

			String Verification = "Yes";
			By locator;

			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			String test = element.getText();
			// String Textvalue1=element.getAttribute("value");
			System.out.println("printvalue" + test);
			String[] Textvalue = test.split("-");
			String splittedvalue = Textvalue[0];
			System.out.println(splittedvalue);

			String[] arrSplit = text.split(",");
			int lastrow;
			File src = new File(arrSplit[0]);
			System.out.println("File" + src);
			String filepath = arrSplit[0];
			System.out.println("Filelocation" + filepath);
			FileInputStream fis = new FileInputStream(src);
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh1 = wb.getSheetAt(0);
			int columncount = sh1.getRow(0).getLastCellNum();
			System.out.println(columncount);

			if (Verification.equalsIgnoreCase(arrSplit[2])) {
				lastrow = sh1.getLastRowNum();
				System.out.println(arrSplit[2]);
				lastrow = lastrow + 1;
				System.out.println(lastrow);
				for (int i = 0; i < columncount; i++) {
					String datastore = sh1.getRow(0).getCell(i).getStringCellValue();
					System.out.println(datastore);
					if (datastore.equalsIgnoreCase(arrSplit[1])) {
						HSSFRow row = sh1.createRow(lastrow);
						HSSFCell cell = row.createCell(i);
						cell.setCellValue(splittedvalue);
						String datastore1 = cell.getStringCellValue();
						System.out.println(datastore1);
						break;

					}

				}
			} else {
				lastrow = sh1.getLastRowNum();
				System.out.println(lastrow);

				for (int j = 0; j < columncount; j++) {
					String datastore = sh1.getRow(0).getCell(j).getStringCellValue();
					System.out.println(datastore);
					if (datastore.equalsIgnoreCase(arrSplit[1])) {
						HSSFRow row = sh1.getRow(lastrow);
						HSSFCell cell = row.createCell(j);
						cell.setCellValue(splittedvalue);
						String datastore1 = cell.getStringCellValue();
						System.out.println(datastore1);
						break;

					}

				}
			}

			// file.close();
			FileOutputStream fileOut = new FileOutputStream(filepath);
			wb.write(fileOut);
			extent.pass(code);
			result = "PASS";

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void waitTime() throws InterruptedException, IOException {
		try {
			Thread.sleep(3500);
			// extent.pass(code);
			result = "PASS";

			// extent.pass(code);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
			result = "FAIL";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void waitTime1(String text) throws InterruptedException, IOException {
		try {

			int i = Integer.parseInt(text);

			Thread.sleep(i);
			extent.pass(code);
			result = "PASS";

			// extent.pass(code);
		} catch (Exception e) {
			// extent.fail(code + e.getMessage(),
			// MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			extent.fail(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("some Exception found here=>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void Counter_Click(String text) throws InterruptedException, IOException {
		try {

			Thread.sleep(5000);

			String counterrefresh = driver.findElement(By.xpath("//label[text()='" + text + "']")).getAttribute("id");
			System.out.println(counterrefresh);

			String counterrefresh1 = counterrefresh.replaceFirst("PJC-PJC_cntname", "PJC-PJC_Cumcolor");
			Thread.sleep(2000);

			System.out.println(counterrefresh1);
			driver.findElement(By.xpath(counterrefresh1)).click();

			Thread.sleep(5000);

			extent.pass(code);
			result = "PASS";

			// extent.pass(code);
		} catch (Exception e) {
			// extent.fail(code + e.getMessage(),
			// MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
			result = "FAIL";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void implicitwait() throws InterruptedException, IOException {
		try {
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			result = "PASS";
			// extent.pass(code);

		} catch (Exception e) {
			// extent.fail(code + e.getMessage(),
			// MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void pageload() throws InterruptedException, IOException {
		try {
			// driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);

			new WebDriverWait(driver, 80).until(webDriver -> ((JavascriptExecutor) webDriver)
					.executeScript("return document.readyState").equals("complete"));

			result = "PASS";
			// extent.pass(code);
		} catch (Exception e) {
			// extent.fail(code + e.getMessage(),
			// MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}

		data.add(result);
		anotherMethod(result, data);
	}

	public void routing1() {
		try {
			// By locator;
			// locator = locatorValue(locatorType, value);
			WebDriverWait wait1 = new WebDriverWait(driver, 20);
			WebElement element = wait1
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(./text(),'Ok')]")));
			// element.findElement(By.xpath("//button[contains(./text(),'Ok')]"));

			element.click();

		} catch (Exception e) {
			WebDriverWait wait1 = new WebDriverWait(driver, 20);
			WebElement element = wait1
					.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[contains(@id,'btnTblEdit')]")));
			element.click();
		}
	}

	public void routing() throws IOException {
		try {

			WebElement element = WaitUtil.waitForEleTobeClickble(By.xpath("//button[contains(./text(),'Ok')]"));
			// System.out.println("Test Routing1");
			element.click();
			extent.pass(code);
			result = "PASS";

		} catch (Exception e) {
			try {
				// System.out.println("Test Routing2");
				Log.info("EXCEPTION FOUND HERE=====>" + e);
				WebElement element = WaitUtil.waitForEleTobeClickble(By.xpath(".//*[contains(@id,'btnTblEdit')]"));
				element.click();

				extent.pass(code);
				result = "PASS";

			} catch (Exception ex) {
				// System.out.println("Test Routing3");
				Log.error("EXCEPTION FOUND HERE=====>" + ex);
				extent.fail(code + e.getMessage(),
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void SSCcommunicationWait() throws InterruptedException, IOException {
		try {
			Thread.sleep(600000);
			extent.pass(code);
			result = "PASS";

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void clearTextBS(String locatorType, String value) throws IOException, InterruptedException {

		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);

			element.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);

			result = "PASS";
			extent.pass(code);
			// Thread.sleep(3000);
		} catch (NoSuchElementException e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("No Element Found to perform click" + e);
			result = "FAIL";
			// rs.getScenarios(TSID, Description, Result);
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void verifyProgressBar(String locatorType, String value, String text) throws IOException {

		try {
			By locator;
			locator = locatorValue(locatorType, value);
			// WebElement element = driver.findElement(locator);

			WebElement element = WaitUtil.fluentWait(locator);

			String textvalue = element.getText();
			System.out.println("The status is : " + textvalue);
			if (textvalue.equals(text)) {

				System.out.println("Status Pass");
				result = "PASS";
				extent.pass(code);
			} else {
				System.out.println("Status Fail");
				extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}
			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			System.out.println("Exception=>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void excelSheetComparision(String text) throws IOException, InterruptedException {
		// //String Result = null;
		try {
			String[] arrSplit = text.split(",");
			File src = new File(arrSplit[0]);
			System.out.println("Filelocation" + src);
			// ArrayList a = new ArrayList();
			// ArrayList b = new ArrayList();
			FileInputStream excellFile1 = new FileInputStream(src);
			@SuppressWarnings("resource")
			HSSFWorkbook workbook1 = new HSSFWorkbook(excellFile1);
			HSSFSheet sheet1 = workbook1.getSheet(arrSplit[1]);
			HSSFSheet sheet2 = workbook1.getSheet(arrSplit[2]);
			HSSFCell cell = null;
			HSSFCell sheet1cell = null;
			int value1 = 0;
			HSSFCellStyle style = workbook1.createCellStyle();
			style.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);
			HSSFFont font = workbook1.createFont();
			font.setColor(HSSFColor.RED.index);
			style.setFont(font);
			HSSFRow row1;
			for (int j = 1; j < sheet1.getLastRowNum() + 1; j++) {
				row1 = sheet1.getRow(j);
				for (int i = 0; i < row1.getLastCellNum(); i++) {
					cell = row1.getCell(i);
					System.out.println("content of excel1" + row1.getCell(i).getStringCellValue());
				}
			}
			HSSFRow row2;
			for (int j = 1; j < sheet2.getLastRowNum() + 1; j++) {
				row2 = sheet2.getRow(j);
				for (int i = 0; i < row2.getLastCellNum(); i++) {
					cell = row2.getCell(i);
					System.out.println("content of excel2" + row2.getCell(i).getStringCellValue());
				}
			}
			HSSFRow row3;
			HSSFRow row4;
			HSSFCell cell1 = null;
			HSSFCell cell2 = null;
			for (int j = 1; j < sheet1.getLastRowNum() + 1; j++) {
				row3 = sheet1.getRow(j);
				row4 = sheet2.getRow(j);
				for (int i = 0; i < row3.getLastCellNum(); i++) {
					cell1 = row3.getCell(i);
					cell2 = row4.getCell(i);
					if (row3.getCell(i).getStringCellValue().equals(row4.getCell(i).getStringCellValue())) {
						System.out.println("matched");
						System.out.println(i);
						sheet1cell = sheet1.getRow(j).getCell(value1);
					} else {
						System.out.println("not matched");
						value1 = i;
						System.out.println(value1);
						sheet1cell = sheet1.getRow(j).getCell(value1);
						sheet1cell.setCellStyle(style);
					}
				}
			}
			FileOutputStream output_file = new FileOutputStream(src); // Open
																		// FileOutputStream
																		// to
																		// write
																		// updates
			workbook1.write(output_file); // write changes
			output_file.close();
			CellStyle colour = sheet1cell.getCellStyle();
			System.out.println(colour);
			System.out.println(style);
			System.out.println(style.equals(colour));
			if (style.equals(colour)) {
				extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "FAIL";
			} else {
				extent.pass(code);
				result = "PASS";
			}
			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);

			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void datePicker(String locatorType, String value, String text) throws IOException {
		// String Result = null;
		try {
			System.out.println(text);
			String ar[] = text.split("-");// 02/04/2019
			System.out.println(ar[0]);
			System.out.println(ar[1]);
			System.out.println(ar[2]);

			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.waitForEleTobeClickble(locator);
			javaScriptClick(element);
			WaitUtil.waitForEleTobeClickble(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[2]")).click();

			// Thread.sleep(2000);
			WebElement yearWidget = WaitUtil
					.waitForEleTobeClickble(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]"));
			// System.out.println("yearWidget"+yearWidget);
			List<WebElement> yearcolumns = yearWidget.findElements(By.tagName("option"));

			// stem.out.println("yearcolumns1"+((WebElement)
			// yearcolumns).getText());
			// comparing the text of cell with year and clicking it.
			for (WebElement cell : yearcolumns) {
				System.out.println("cell" + cell.getText());
				Thread.sleep(1000);
				if (cell.getText().equals(ar[2])) {
					System.out.println("cell1" + cell.getText());
					cell.click();
					break;
				}
			}
			// Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]")).click();
			// Thread.sleep(1000);
			WebElement monthWidget = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]"));
			List<WebElement> monthcolumns = monthWidget.findElements(By.tagName("option"));
			// comparing the text of cell with month and clicking it.
			for (WebElement cell : monthcolumns) {
				System.out.println("moth" + cell.getText());
				if (cell.getText().equals(ar[1])) {
					System.out.println("moth1" + cell.getText());
					Thread.sleep(1000);
					cell.click();
					break;
				}
			}
			// find the calendar
			// Thread.sleep(1000);
			WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));
			List<WebElement> columns = dateWidget.findElements(By.tagName("td"));
			// comparing the text of cell with today's date and clicking it.
			for (WebElement cell : columns) {
				if (cell.getText().equals(ar[0])) {
					System.out.println("date" + cell.getText());
					Thread.sleep(1000);
					cell.click();
					extent.pass(code);
					result = "PASS";
					break;
				}
			}

		} catch (Exception e) {
			extent.fail(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			System.out.println("Exception=>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void javaClick(String locatorType, String value) throws IOException {
		// String Result = null;
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);

		} catch (Exception e) {
			extent.fail(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			System.out.println("Exception=>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

//	  WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));
//
//      // enter the file path onto the file-selection input field
//      uploadElement.sendKeys("C:\\newhtml.html");
//
//      // check the "I accept the terms of service" check box
//      driver.findElement(By.id("terms")).click();
//
//      // click the "UploadFile" button
//      driver.findElement(By.name("send")).click();
//      }
//}

	public void uploadfile(String locatorType, String value) throws IOException {
		try {

			By locator;

			locator = locatorValue(locatorType, value);

			WebElement uploadElement = driver.findElement(locator);

			uploadElement.sendKeys("C:\\Users\\kamali.pondurai\\Downloads\\download.jfif");

		} catch (Exception e) {
			extent.error(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("some Exception found here=>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
			result = "fail";
		}
		data.add(result);

		anotherMethod(result, data);

	}

	public void uploadAttach(String locatorType, String value) throws IOException {
		try {

			By locator;

			locator = locatorValue(locatorType, value);

			WebElement fileUpload = driver.findElement(locator);

			fileUpload.sendKeys("C:\\Users\\kamali.pondurai\\Downloads\\download.jfif");
			Thread.sleep(3000);

		} catch (Exception e) {
			extent.error(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("some Exception found here=>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
			result = "fail";
		}
		data.add(result);

		anotherMethod(result, data);

	}

	public void outputDatePicker(String locatorType, String value, String text) throws IOException {
		// //String Result = null;
		try {

			String columname, Columvalue = null;
			File src = new File("C:\\Excel\\SystemGenValues.xls");
			String filepath = "C:\\Excel\\SystemGenValues.xls";
			FileInputStream fis = new FileInputStream(src);
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh1 = wb.getSheetAt(0);
			int columncount = sh1.getRow(0).getLastCellNum();
			System.out.println(columncount);
			int lastrow = lastrow = sh1.getLastRowNum();
			for (int i = 0; i <= columncount; i++) {
				columname = sh1.getRow(0).getCell(i).getStringCellValue();
				if (text.equalsIgnoreCase(columname)) {
					Columvalue = sh1.getRow(1).getCell(i).getStringCellValue();

					break;
				}
			}
			String ar[] = Columvalue.split("/");
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]")).click();
			Thread.sleep(3000);
			WebElement yearWidget = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]"));
			List<WebElement> yearcolumns = yearWidget.findElements(By.tagName("option"));
			// comparing the text of cell with year and clicking it.
			for (WebElement cell : yearcolumns) {
				if (cell.getText().equals(ar[2])) {
					cell.click();
					break;
				}
			}
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]")).click();
			Thread.sleep(1000);
			WebElement monthWidget = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]"));
			List<WebElement> monthcolumns = monthWidget.findElements(By.tagName("option"));
			// comparing the text of cell with month and clicking it.
			for (WebElement cell : monthcolumns) {
				if (cell.getText().equals(ar[1])) {
					cell.click();
					break;
				}
			}
			// find the calendar
			WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));
			List<WebElement> columns = dateWidget.findElements(By.tagName("td"));
			// comparing the text of cell with today's date and clicking it.
			for (WebElement cell : columns) {
				if (cell.getText().equals(ar[0])) {
					cell.click();
					extent.pass(code);
					result = "PASS";
					break;

				} else {
					extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
					result = "<a href=" + ScreenShot() + "> FAIL</a>";
				}
			}

			Thread.sleep(1000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void eslOutputDatePicker(String locatorType, String value, String text) throws IOException {
		// //String Result = null;
		try {

			String columname, Columvalue = null;
			File src = new File("C:\\Excel\\SystemGenValues.xls");
			// String filepath = "C:\\Excel\\SystemGenValues.xls";
			FileInputStream fis = new FileInputStream(src);
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh1 = wb.getSheetAt(0);

			int rowcount = sh1.getLastRowNum();
			System.out.println("total rowNo=>" + rowcount);
			for (int j = 0; j <= rowcount; j++) {
				columname = sh1.getRow(j).getCell(0).getStringCellValue();
				if (text.equalsIgnoreCase(columname)) {
					Columvalue = sh1.getRow(j).getCell(1).getStringCellValue();

					break;
				}
			}
			String ar[] = Columvalue.split("/");
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]")).click();
			Thread.sleep(3000);
			WebElement yearWidget = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]"));
			List<WebElement> yearcolumns = yearWidget.findElements(By.tagName("option"));
			// comparing the text of cell with year and clicking it.
			for (WebElement cell : yearcolumns) {
				if (cell.getText().equals(ar[2])) {
					cell.click();
					break;
				}
			}
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]")).click();
			Thread.sleep(1000);
			WebElement monthWidget = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]"));
			List<WebElement> monthcolumns = monthWidget.findElements(By.tagName("option"));
			// comparing the text of cell with month and clicking it.
			for (WebElement cell : monthcolumns) {
				if (cell.getText().equals(ar[1])) {
					cell.click();
					break;
				}
			}
			// find the calendar
			WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));
			List<WebElement> columns = dateWidget.findElements(By.tagName("td"));
			// comparing the text of cell with today's date and clicking it.
			for (WebElement cell : columns) {
				if (cell.getText().equals(ar[0])) {
					cell.click();
					extent.pass(code);
					result = "PASS";
					break;

				} else {
					extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
					result = "<a href=" + ScreenShot() + "> FAIL</a>";
				}
			}

			// Thread.sleep(1000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void mDSelectMenuList(String locatorType, String value, String text)
			throws IOException, InterruptedException {
		// //String Result = null;
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			List<WebElement> options = element
					.findElements(By.xpath(".//a[contains(@class,'ui-commandlink ui-widget')]"));
			for (int n = 0; n < options.size(); n++) {
				String menu = options.get(n).getText();
				System.out.println(menu);

				if (options.get(n).getText().equalsIgnoreCase(text)) {
					System.out.println("********** Successfully selected ********");
					System.out.println("Selected value : " + options.get(n).getText());
					options.get(n).click();
					// Thread.sleep(2000);
					break;
				}

			}
			extent.pass(code);
			result = "PASS";
			// Thread.sleep(2000);
		} catch (Exception e) {

			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "FAIL";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void mDOutputSelectMenuList(String locatorType, String value, String text)
			throws IOException, InterruptedException {
		// //String Result = null;
		try {

			String columname, Columvalue = null;
			File src = new File("C:\\Excel\\SystemGenValues.xls");
			String filepath = "C:\\Excel\\SystemGenValues.xls";
			FileInputStream fis = new FileInputStream(src);
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh1 = wb.getSheetAt(0);
			int columncount = sh1.getRow(0).getLastCellNum();
			System.out.println(columncount);
			int lastrow = lastrow = sh1.getLastRowNum();
			for (int i = 0; i <= columncount; i++) {
				columname = sh1.getRow(0).getCell(i).getStringCellValue();
				if (text.equalsIgnoreCase(columname)) {
					Columvalue = sh1.getRow(1).getCell(i).getStringCellValue();

					break;
				}
			}

			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			List<WebElement> options = element
					.findElements(By.xpath(".//a[contains(@class,'ui-commandlink ui-widget')]"));
			for (int n = 0; n < options.size(); n++) {
				String menu = options.get(n).getText();
				System.out.println(menu);

				if (options.get(n).getText().equalsIgnoreCase(Columvalue)) {
					System.out.println("********** Successfully selected ********");
					System.out.println("Selected value : " + options.get(n).getText());
					options.get(n).click();
					// Thread.sleep(1000);
					break;
				}
			}

			extent.pass(code);
			result = "PASS";
			// Thread.sleep(1000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	// ****** Used to select tree node in insert link page,insert
	// document,insert
	// image (parent node) ******** //
	public void mDSelectTreeNode(String locatorType, String value, String text)
			throws IOException, InterruptedException {
		// String Result = null;
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			List<WebElement> options = element
					.findElements(By.xpath(".//span[contains(@class,'ui-treenode-label ui-corner-all')]"));
			for (int n = 0; n < options.size(); n++) {
				String menu = options.get(n).getText();
				System.out.println(menu);

				if (options.get(n).getText().equalsIgnoreCase(text)) {
					System.out.println("********** Successfully selected ********");
					System.out.println("Selected value : " + options.get(n).getText());
					options.get(n).click();
					// Thread.sleep(1000);
					break;
				}
			}
			extent.pass(code);
			result = "PASS";
			// Thread.sleep(1000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	// ****** Used to select tree node in insert document,insert image (parent
	// node)
	// based on sys gen values ******** //
	public void mDOutputSelectTreeNode(String locatorType, String value, String text)
			throws IOException, InterruptedException {
		// String Result = null;
		try {

			String columname, Columvalue = null;
			File src = new File("C:\\Excel\\SystemGenValues.xls");
			String filepath = "C:\\Excel\\SystemGenValues.xls";
			FileInputStream fis = new FileInputStream(src);
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh1 = wb.getSheetAt(0);
			int columncount = sh1.getRow(0).getLastCellNum();
			System.out.println(columncount);
			int lastrow = lastrow = sh1.getLastRowNum();
			for (int i = 0; i <= columncount; i++) {
				columname = sh1.getRow(0).getCell(i).getStringCellValue();
				if (text.equalsIgnoreCase(columname)) {
					Columvalue = sh1.getRow(1).getCell(i).getStringCellValue();

					break;

				}

			}
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			List<WebElement> options = element
					.findElements(By.xpath(".//span[contains(@class,'ui-treenode-label ui-corner-all')]"));
			for (int n = 0; n < options.size(); n++) {
				String menu = options.get(n).getText();
				System.out.println(menu);

				if (options.get(n).getText().equalsIgnoreCase(Columvalue)) {
					System.out.println("********** Successfully selected ********");
					System.out.println("Selected value : " + options.get(n).getText());
					options.get(n).click();
					// Thread.sleep(1000);
					break;

				}

			}
			extent.pass(code);
			result = "PASS";
			// Thread.sleep(1000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	// ***** used to click folder(whatever visible at that time in the tree)
	// ************** //
	public void mDFolderClick(String text) throws IOException, InterruptedException {
		// String Result = null;
		try {

			WebElement element = driver.findElement(By.id("DMSAD-DMSAD_tree"));
			List<WebElement> options = element
					.findElements(By.xpath(".//span[contains(@class,'ui-inplace ui-hidden-container')]"));

			for (int n = 0; n < options.size(); n++) {
				String menu = options.get(n).getText();
				System.out.println(menu);

				if (options.get(n).getText().equalsIgnoreCase(text)) {

					JavascriptExecutor jse = (JavascriptExecutor) driver;
					jse.executeScript("arguments[0].scrollIntoView();", options.get(n));
					System.out.println("********** Successfully selected ********");
					System.out.println("Selected value : " + options.get(n).getText());
					options.get(n).click();
					Thread.sleep(1000);

					break;

				}

			}
			extent.pass(code);
			result = "PASS";
			// Thread.sleep(1000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void mDOutputFolderClick(String text) throws IOException, InterruptedException {
		// String Result = null;
		try {
			String columname, Columvalue = null;
			File src = new File("C:\\Excel\\SystemGenValues.xls");
			// String filepath = "C:\\Excel\\SystemGenValues.xls";
			FileInputStream fis = new FileInputStream(src);
			@SuppressWarnings("resource")
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh1 = wb.getSheetAt(0);
			int columncount = sh1.getRow(0).getLastCellNum();
			System.out.println(columncount);
			// int lastrow = lastrow = sh1.getLastRowNum();
			for (int i = 0; i <= columncount; i++) {
				columname = sh1.getRow(0).getCell(i).getStringCellValue();
				if (text.equalsIgnoreCase(columname)) {
					Columvalue = sh1.getRow(1).getCell(i).getStringCellValue();
					break;
				}
			}
			WebElement element = driver.findElement(By.id("DMSAD-DMSAD_tree"));
			List<WebElement> options = element
					.findElements(By.xpath(".//span[contains(@class,'ui-inplace ui-hidden-container')]"));

			for (int n = 0; n < options.size(); n++) {
				String menu = options.get(n).getText();
				System.out.println(menu);

				if (options.get(n).getText().equalsIgnoreCase(Columvalue)) {

					JavascriptExecutor jse = (JavascriptExecutor) driver;
					jse.executeScript("arguments[0].scrollIntoView();", options.get(n));
					System.out.println("********** Successfully selected ********");
					System.out.println("Selected value : " + options.get(n).getText());
					options.get(n).click();
					// Thread.sleep(1000);

					break;

				}

			}
			extent.pass(code);
			result = "PASS";
			// Thread.sleep(1000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void currentDate(String locatorType, String value) throws IOException {
		// //String Result = null;

		try {

			By locator;
			locator = locatorValue(locatorType, value);
			Calendar cal = Calendar.getInstance();
			int yr = cal.get(Calendar.YEAR);
			String year = String.valueOf(yr);
			String month = new SimpleDateFormat("MMM").format(cal.getTime());
			WebElement element = WaitUtil.fluentWait(locator);
			element.click();
			Select month_drpdwn = new Select(
					WaitUtil.waitForEleTobevisible(By.xpath(".//*[@class='ui-datepicker-month']")));

			for (WebElement var : month_drpdwn.getOptions()) {
				// System.out.println(var.getText());
				if (var.getText().equals(month)) {
					month_drpdwn.selectByVisibleText(month);
					break;
				}
			}

			Select year_drpdwn = new Select(
					WaitUtil.waitForEleTobevisible(By.xpath(".//*[@class='ui-datepicker-year']")));

			for (WebElement var : year_drpdwn.getOptions())

			{
				// System.out.println(var.getText());
				if (var.getText().equals(year)) {
					year_drpdwn.selectByVisibleText(year);
					driver.findElement(By.xpath(".//a[contains(@class,'ui-state-default ui-state-highlight')]"))
							.click();

					break;

				}

			}
			Boolean filled = isAttributePresent(element, "value");
			if (filled) {

				result = "PASS";
				extent.pass(code);

			} else {
				extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			}

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			System.out.println("Element not present");
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void clickCalender() throws IOException {

		try {
			Date now = new Date();
			String day = new SimpleDateFormat("E").format(now).toLowerCase();
			System.out.println(day);
			WebElement element = driver
					.findElement(By.xpath("//td[@class='fc-day-number fc-" + day + " fc-today ui-state-highlight']"));
			element.click();
			extent.pass(code);
			result = "PASS";
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void search(String locatorType, String value, String search) throws IOException, InterruptedException {
		// String Result = null;
		String arrSplit[] = search.split(":");
		try {

			By locator;
			locator = locatorValue(locatorType, value);

			WebElement element = WaitUtil.waitForEleTobeClickble(locator);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);

			WaitUtil.waitForEleTobevisible(By.xpath("//*[@id=\"nfr_sch_t_dt_data\"]/tr[1]/td[1]"));

			List<WebElement> columns = driver.findElements(By.xpath(".//*[@id='nfr_sch_t_dt_head']/tr/th"));
			// System.out.println("test3");
			for (int i = 0; i < columns.size(); i++) {
				// System.out.println("test4");
				String requiredColumn = columns.get(i).getText().trim();
				if (requiredColumn.equalsIgnoreCase(arrSplit[0])) {
					WebElement ele = WaitUtil.waitForEleTobeClickble(
							By.xpath(".//*[@id='nfr_sch_t_dt-nfr_sch_tc_dyn_cols-" + i + "-filter']"));
					// System.out.println(element);

					ele.sendKeys(arrSplit[1]);
					WaitUtil.waitForEleTobeInvisible(By.xpath("//*[@id='nfr_sch_t_dt_data']/tr[2]"));
					WebElement row = driver.findElement(By.xpath("//*[@id='nfr_sch_t_dt_data']/tr"));
					Actions action = new Actions(driver);
					action.moveToElement(row).doubleClick().build().perform();
					WaitUtil.waitForEleTobeInvisible(By.xpath("//*[@id=\"nfr_sch_t_dt-globalFilter\"]"));
					extent.pass(code);
					result = "PASS";

					break;
				}

			}
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void twoColumnSearch1(String locatorType, String value, String text)
			throws IOException, InterruptedException {
		// String Result = null;
		try {

			By locator;
			locator = locatorValue(locatorType, value);

			WebElement element = WaitUtil.waitForEleTobeClickble(locator);
			WaitUtil.waitForEleTobeInvisible(By.xpath("//div[@class='blockUI']"));
			element.sendKeys(text);

			WaitUtil.waitForEleTobeInvisible(By.xpath(".//tr[@data-ri='1']"));

			WebElement ele = element.findElement(By.xpath(".//tr[@data-ri='0']"));

			Actions action = new Actions(driver);
			action.moveToElement(ele).doubleClick().build().perform();
			WaitUtil.waitForEleTobeInvisible(By.xpath("//div[@class='blockUI']"));
			System.out.println("Pass");
			result = "PASS";
			extent.pass(code);
			/*
			 * Thread.sleep(500); } else { extent.fail(code,
			 * MediaEntityBuilder.createScreenCaptureFromPath (ScreenShot()).build());
			 * System.out.println("Fail"); result = "<a href=" + ScreenShot() +
			 * "> FAIL</a>"; Thread.sleep(500);
			 * 
			 * }
			 */
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void select_Drpdwn(String locatorType, String value, String text) throws IOException {
		// String Result = null;
		try {

			By locator;
			locator = locatorValue(locatorType, value);

			Select drpdwn = new Select(driver.findElement(locator));

			for (WebElement var : drpdwn.getOptions()) {
				System.out.println(var.getText());
				if (var.getText().equals(text)) {
					drpdwn.selectByVisibleText(text);
					result = "PASS";
					// extent.pass(code);
					break;
				}
			}

		} catch (Exception e) {
			// extent.fail(code + e.getMessage(),
			// MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			// System.out.println("Element not present");
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void mDExcelWrite() throws EncryptedDocumentException, InvalidFormatException, IOException, BiffException,
			InterruptedException {
		try {

			SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd-HHmmss");

			String date = SDF.format(new Date());
			File src = new File("C:\\Excel\\Name.xls");
			String filepath = "C:\\Excel\\Name.xls";
			FileInputStream fis = new FileInputStream(src);
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh1 = wb.getSheetAt(0);

			HSSFRow row = sh1.createRow(1);
			HSSFCell cell = row.createCell(0);
			cell.setCellValue("Doc_" + date);
			String datastore = cell.getStringCellValue();
			System.out.println(datastore);

			FileOutputStream fileOut = new FileOutputStream(filepath);
			wb.write(fileOut);
			extent.pass(code);
			result = "PASS";

		} catch (NoSuchElementException e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void mDExcelOutput(String locatorType, String value)
			throws BiffException, IOException, InterruptedException {
		// String Result = null;
		try {
			String columname, Columvalue;
			File src = new File("C:\\Excel\\Name.xls");
			String filepath = "C:\\Excel\\Name.xls";
			FileInputStream fis = new FileInputStream(src);
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh1 = wb.getSheetAt(0);

			Columvalue = sh1.getRow(1).getCell(0).getStringCellValue();
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			element.sendKeys(Columvalue);
			extent.pass(code);
			result = "PASS";

			// Thread.sleep(1000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void eslStoreText(String locatorType, String value, String text) throws EncryptedDocumentException,
			InvalidFormatException, IOException, BiffException, InterruptedException {
		try {

			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			String Textvalue = element.getAttribute("value");
			System.out.println("text to be copied=>" + Textvalue);

			String[] arrSplit = text.split(",");
			int lastrow;

			File src = new File("C:\\Excel\\SystemGenValues.xls");
			String filepath = "C:\\Excel\\SystemGenValues.xls";
			FileInputStream fis = new FileInputStream(src);
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh1 = wb.getSheetAt(0);
			int rowcount = sh1.getLastRowNum();
			System.out.println("total rowNo=>" + rowcount);

			for (int j = 0; j <= rowcount; j++) {
				String datastore = sh1.getRow(j).getCell(0).getStringCellValue();
				System.out.println(datastore);
				if (datastore.equalsIgnoreCase(arrSplit[0])) {
					HSSFRow row = sh1.getRow(j);
					HSSFCell cell = row.createCell(1);
					cell.setCellValue(Textvalue);
					String datastore1 = cell.getStringCellValue();
					System.out.println(datastore1);
					break;
				}
			}
			FileOutputStream fileOut = new FileOutputStream(filepath);
			wb.write(fileOut);
			extent.pass(code);
			result = "PASS";

		} catch (NoSuchElementException e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void outputURL(String text) throws IOException {
		try {

			String columname, Columvalue = null;
			File src = new File("C:\\Excel\\SystemGenValues.xls");
			String filepath = "C:\\Excel\\SystemGenValues.xls";
			FileInputStream fis = new FileInputStream(src);
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh1 = wb.getSheetAt(0);
			int columncount = sh1.getRow(0).getLastCellNum();
			System.out.println(columncount);
			int lastrow = lastrow = sh1.getLastRowNum();
			for (int i = 0; i <= columncount; i++) {
				columname = sh1.getRow(0).getCell(i).getStringCellValue();
				if (text.equalsIgnoreCase(columname)) {
					Columvalue = sh1.getRow(1).getCell(i).getStringCellValue();
					break;
				}
			}
			driver.navigate().to(Columvalue);
			extent.pass(code);

			result = "PASS";

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void mDWorkFlowOutputValue(String locatorType, String value, String text)
			throws BiffException, IOException, InterruptedException {
		// String Result = null;
		try {
			String columname, Columvalue;
			File src = new File("C:\\Excel\\SystemGenValues.xls");
			String filepath = "C:\\Excel\\SystemGenValues.xls";
			FileInputStream fis = new FileInputStream(src);
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh1 = wb.getSheetAt(1);
			int columncount = sh1.getRow(0).getLastCellNum();
			System.out.println(columncount);
			int lastrow = lastrow = sh1.getLastRowNum();
			for (int i = 0; i <= columncount; i++) {
				columname = sh1.getRow(0).getCell(i).getStringCellValue();
				if (text.equalsIgnoreCase(columname)) {
					Columvalue = sh1.getRow(1).getCell(i).getStringCellValue();
					String[] arrSplit = Columvalue.split(",");
					By locator;
					locator = locatorValue(locatorType, value);
					WebElement element = driver.findElement(locator);
					element.sendKeys(arrSplit[0]);

					break;
				}
			}
			extent.pass(code);
			result = "PASS";

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void ouputFileUpload(String text) throws IOException, InterruptedException {
		// String Result = null;
		try {

			String columname, Columvalue = null;
			File src = new File("C:\\Excel\\SystemGenValues.xls");
			// String filepath = "C:\\Excel\\SystemGenValues.xls";
			FileInputStream fis = new FileInputStream(src);
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh1 = wb.getSheetAt(0);
			int columncount = sh1.getRow(0).getLastCellNum();
			System.out.println(columncount);
			// int lastrow = lastrow = sh1.getLastRowNum();
			for (int i = 0; i <= columncount; i++) {
				columname = sh1.getRow(0).getCell(i).getStringCellValue();
				if (text.equalsIgnoreCase(columname)) {
					Columvalue = sh1.getRow(1).getCell(i).getStringCellValue();
					break;
				}
			}
			StringSelection ss = new StringSelection(Columvalue);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			extent.pass(code);
			result = "PASS";

			// Thread.sleep(1000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void eslOutputValue(String locatorType, String value, String text)
			throws BiffException, IOException, InterruptedException {
		// String Result = null;
		try {
			String columname, Columvalue;
			File src = new File("C:\\Excel\\SystemGenValues.xls");
			String filepath = "C:\\Excel\\SystemGenValues.xls";
			FileInputStream fis = new FileInputStream(src);
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh1 = wb.getSheetAt(0);

			int rowcount = sh1.getLastRowNum();
			System.out.println("total rowNo=>" + rowcount);
			for (int j = 0; j <= rowcount; j++) {
				columname = sh1.getRow(j).getCell(0).getStringCellValue();
				if (text.equalsIgnoreCase(columname)) {
					Columvalue = sh1.getRow(j).getCell(1).getStringCellValue();
					By locator;
					locator = locatorValue(locatorType, value);

					WebElement element = WaitUtil.fluentWait(locator);
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);

					element.sendKeys(Columvalue);

					break;
				}
			}
			extent.pass(code);
			result = "PASS";

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void mDTextNullNeg(String locatorType, String value) throws IOException {
		// String Result = null;
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			String element_value = element.getText();
			if (element_value.equals("")) {
				{
					System.out.println("Field is empty");
					extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
					result = "<a href=" + ScreenShot() + "> FAIL</a>";

				}
			} else {
				System.out.println("Field is not empty");
				extent.pass(code);
				Log.info("Value in the filed : " + element_value);
				result = "PASS";

			}

			Thread.sleep(1000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void mDTextNull(String locatorType, String value) throws IOException {
		// String Result = null;
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			String element_value = element.getText();
			if (element_value.equals("")) {
				{
					System.out.println("Field is empty");
					extent.pass(code);
					result = "PASS";

				}
			} else {

				System.out.println("Field is not empty");
				extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				Log.info("Value in the filed : " + element_value);
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}

			Thread.sleep(1000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);

			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void mDverifyRefNo(String locatorType, String value, String text) throws IOException {
		// String Result = null;
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			String element_value = element.getAttribute("value");
			if (element_value.equals("")) {
				{
					System.out.println("Field is empty");
					driver.findElement(locator).sendKeys(text);
				}
			} else {
				System.out.println("Field is not empty");
				Log.info("Value in the filed : " + element_value);
			}
			extent.pass(code);
			result = "PASS";

			// Thread.sleep(1000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);

			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void mDVerifyBtnEnable(String locatorType, String value) throws IOException {
		try {
			// String Result = null;
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			element.getAttribute("title");
			if (element.getAttribute("title").equals("")) {
				extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			} else {
				extent.pass(code);
				result = "PASS";
			}

			// Thread.sleep(1000);
		} catch (Exception e) {

			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void mDVerifyBtnDisable(String locatorType, String value) throws IOException {
		try {
			// String Result = null;
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			element.getAttribute("title");
			if (element.getAttribute("title").equals("")) {
				extent.pass(code);
				result = "PASS";
			} else {

				extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}

			// Thread.sleep(1000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void mDVerifyIcon(String text) throws IOException {
		try {
			// String Result = null;
			// By locator;
			// locator = locatorValue(locatorType, value);
			// WebElement element = driver.findElement(locator);
			WebElement element = driver.findElement(By.id("DMSAD-DMSAD_tree-0"));
			// WebElement element1 =
			// element.findElement(By.xpath(".//li[contains(@aria-selected,'true')]"));
			WebElement element1 = element.findElement(By.xpath(".//span[contains(@aria-selected,'true')]"));
			// WebElement element1 =
			// element.findElement(By.xpath(".//span[contains(@class,'ui-treenode-content
			// ui-tree-selectable ui-treenode-droppable ui-draggable
			// ui-draggable-handle
			// ui-droppable')]"));
			WebElement element2 = element1
					.findElement(By.xpath(".//span[contains(@class,'ui-treenode-icon ui-icon')]"));
			element2.getAttribute("class");
			System.out.println(element2.getAttribute("class"));
			if (element2.getAttribute("class").equals(text)) {
				extent.pass(code);
				result = "PASS";
			} else {
				extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}
			// Thread.sleep(1000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);

			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void mDVerifyNotification(String locatorType, String value, String text)
			throws IOException, InterruptedException {
		// String Result = null;
		try {
			String[] arrSplit = text.split(",");
			String columname, Columvalue = null;
			File src = new File("C:\\Excel\\SystemGenValues.xls");
			String filepath = "C:\\Excel\\SystemGenValues.xls";
			FileInputStream fis = new FileInputStream(src);
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh1 = wb.getSheetAt(0);
			int columncount = sh1.getRow(0).getLastCellNum();
			System.out.println(columncount);
			int lastrow = lastrow = sh1.getLastRowNum();
			for (int i = 0; i <= columncount; i++) {
				columname = sh1.getRow(0).getCell(i).getStringCellValue();
				if (arrSplit[0].equalsIgnoreCase(columname)) {
					Columvalue = sh1.getRow(1).getCell(i).getStringCellValue();
					break;
				}
			}

			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);

			List<WebElement> options = element
					.findElements(By.xpath(".//a[contains(@class,'ui-commandlink ui-widget')]"));
			System.out.println(options.size());
			for (int j = 1; j < options.size() + 1; j++) {
				String Doctitle;

				Doctitle = driver
						.findElement(By.xpath("html/body/div[3]/div[1]/div[2]/ul/li[2]/ul/form/div[2]/a[" + j + "]/li"))
						.getText();
				System.out.println(Doctitle);
				if (Doctitle.contains(Columvalue)) {
					System.out.println("Index : " + j);
					System.out.println("********** Successfully selected ********");
					System.out.println("Selected Document : " + Doctitle);
					JavascriptExecutor jse = (JavascriptExecutor) driver;
					jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(
							By.xpath("html/body/div[3]/div[1]/div[2]/ul/li[2]/ul/form/div[2]/a[" + j + "]/li")));
					// Thread.sleep(4000);
					driver.findElement(
							By.xpath("html/body/div[3]/div[1]/div[2]/ul/li[2]/ul/form/div[2]/a[" + j + "]/li")).click();
					extent.pass(code);

					result = "PASS";
					// Thread.sleep(4000);
					break;
				} else {

					extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
					result = "<a href=" + ScreenShot() + "> FAIL</a>";
				}
			}

			Thread.sleep(4000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);

			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void mDStoreGetText(String locatorType, String value, String text) throws EncryptedDocumentException,
			InvalidFormatException, IOException, BiffException, InterruptedException {
		try {
			String Verification = "Yes";
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			String Textvalue = element.getText();
			System.out.println("text to be copied=>" + Textvalue);

			String[] arrSplit = text.split(",");
			int lastrow;
			// C:\\Excel\\SystemGenValues.xls
			File src = new File("C:\\Excel\\SystemGenValues.xls");
			String filepath = "C:\\Excel\\SystemGenValues.xls";
			FileInputStream fis = new FileInputStream(src);
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh1 = wb.getSheetAt(0);
			int columncount = sh1.getRow(0).getLastCellNum();
			System.out.println("total columNo=>" + columncount);

			if (Verification.equalsIgnoreCase(arrSplit[1])) {
				lastrow = sh1.getLastRowNum();
				System.out.println(arrSplit[1]);
				lastrow = lastrow + 1;
				System.out.println(lastrow);

				for (int i = 0; i < columncount; i++) {
					String datastore = sh1.getRow(0).getCell(i).getStringCellValue();
					System.out.println(datastore);
					if (datastore.equalsIgnoreCase(arrSplit[0])) {
						HSSFRow row = sh1.createRow(lastrow);
						HSSFCell cell = row.createCell(i);
						cell.setCellValue(Textvalue);
						String datastore1 = cell.getStringCellValue();
						System.out.println(datastore1);
						break;
					}

				}
			} else {
				lastrow = sh1.getLastRowNum();
				System.out.println("last row is=>" + lastrow);

				for (int j = 0; j < columncount; j++) {
					String datastore = sh1.getRow(0).getCell(j).getStringCellValue();
					System.out.println(datastore);
					if (datastore.equalsIgnoreCase(arrSplit[0])) {
						HSSFRow row = sh1.getRow(lastrow);
						HSSFCell cell = row.createCell(j);
						cell.setCellValue(Textvalue);
						String datastore1 = cell.getStringCellValue();
						System.out.println(datastore1);
						break;

					}

				}
			}

			FileOutputStream fileOut = new FileOutputStream(filepath);
			wb.write(fileOut);
			extent.pass(code);
			result = "PASS";

		} catch (NoSuchElementException e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);

			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void eslLabelStoreText(String locatorType, String value, String text) throws EncryptedDocumentException,
			InvalidFormatException, IOException, BiffException, InterruptedException {
		try {

			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			String Textvalue = element.getText();
			System.out.println("text to be copied=>" + Textvalue);

			String[] arrSplit = text.split(",");
			int lastrow;
			// C:\\Excel\\SystemGenValues.xls
			File src = new File("C:\\Excel\\SystemGenValues.xls");
			String filepath = "C:\\Excel\\SystemGenValues.xls";
			FileInputStream fis = new FileInputStream(src);
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh1 = wb.getSheetAt(0);
			int rowcount = sh1.getLastRowNum();
			System.out.println("total rowNo=>" + rowcount);

			for (int j = 0; j <= rowcount; j++) {
				String datastore = sh1.getRow(j).getCell(0).getStringCellValue();
				System.out.println(datastore);
				if (datastore.equalsIgnoreCase(arrSplit[0])) {
					HSSFRow row = sh1.getRow(j);
					HSSFCell cell = row.createCell(1);
					cell.setCellValue(Textvalue);
					String datastore1 = cell.getStringCellValue();
					System.out.println(datastore1);
					break;
				}
			}

			FileOutputStream fileOut = new FileOutputStream(filepath);
			wb.write(fileOut);
			extent.pass(code);
			result = "PASS";

		} catch (NoSuchElementException e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void eslOutputURL(String text) throws IOException {
		try {

			String columname, Columvalue = null;
			File src = new File("C:\\Excel\\SystemGenValues.xls");
			String filepath = "C:\\Excel\\SystemGenValues.xls";
			FileInputStream fis = new FileInputStream(src);
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh1 = wb.getSheetAt(0);

			int rowcount = sh1.getLastRowNum();
			System.out.println("total rowNo=>" + rowcount);
			for (int j = 0; j <= rowcount; j++) {
				columname = sh1.getRow(j).getCell(0).getStringCellValue();
				if (text.equalsIgnoreCase(columname)) {
					Columvalue = sh1.getRow(j).getCell(1).getStringCellValue();

					break;
				}
			}
			driver.navigate().to(Columvalue);
			extent.pass(code);
			result = "PASS";

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void waitForElement(String locatorType, String value) throws IOException {
		try {
			By locator;
			locator = locatorValue(locatorType, value);

			WaitUtil.fluentWait(locator);
			extent.pass(code);
			result = "PASS";

		} catch (ElementNotVisibleException e) {
			extent.fail(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("some Exception found here=>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void waitForElementToBeClickable(String locatorType, String value) throws IOException, InterruptedException {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			element.click();
			extent.pass(code);
			result = "PASS";

		} catch (TimeoutException e) {

			extent.fail(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("No Element Found to perform click" + e);
			result = "FAIL";

		} catch (Exception e) {

			extent.fail(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("No Element Found to perform click" + e);
			result = "FAIL";
			// rs.getScenarios(TSID, Description, Result);
		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void Waitclick(String locatorType, String value) throws IOException, InterruptedException {
		try {
			By locator;
			locator = locatorValue(locatorType, value);

			int timeOut = 60;
			WebDriverWait wait1 = new WebDriverWait(driver, timeOut);

			wait1.until(new ExpectedCondition<Boolean>() {

				public Boolean apply(WebDriver driver) {

					{
						System.out.println("loop-----------------------try 1" + locator);

						driver.findElement(locator).click();
						return Boolean.TRUE;
					}
				}
			}

			);

			result = "PASS";
			extent.pass(code);

		} catch (Exception e) {

			extent.fail(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("some Exception found here=>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void Waitsendkey(String locatorType, String value, String text) throws IOException, InterruptedException {
		try {
			By locator;
			locator = locatorValue(locatorType, value);

			int timeOut = 60;
			WebDriverWait wait1 = new WebDriverWait(driver, timeOut);

			wait1.until(new ExpectedCondition<Boolean>() {

				public Boolean apply(WebDriver driver) {

					{
						System.out.println("loop-----------------------try 1" + locator);
						driver.findElement(locator).sendKeys(text);

						return Boolean.TRUE;
					}

				}

			});
			result = "PASS";
			extent.pass(code);

		} catch (Exception e) {

			extent.fail(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("some Exception found here=>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void reSize() throws InterruptedException, IOException {
		try {

			Dimension k = new Dimension(700, 450);

			driver.manage().window().setSize(k);

			result = "PASS";
			extent.pass(code);

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void reSize1() throws InterruptedException, IOException {
		try {

			driver.manage().window().maximize();

			result = "PASS";
			extent.pass(code);

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void tab(String locatorType, String value) throws IOException, InterruptedException {
		// String Result = null;
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			element.click();
			element.sendKeys(Keys.TAB);

			result = "PASS";
			extent.pass(code);
			// Thread.sleep(3000);
		} catch (NoSuchElementException e) {
			extent.fail(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("some Exception found here=>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void waitForElementInVisible(String locatorType, String value) throws IOException {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

			extent.info(code);
			result = "PASS";

		} catch (ElementNotVisibleException e) {
			extent.fail(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("some Exception found here=>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}

		data.add(result);
		anotherMethod(result, data);
	}

	public void click(String locatorType, String value) throws IOException {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebDriverWait wait = new WebDriverWait(driver, 30);

			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			driver.findElement(locator).click();

			// WaitUtil.waitForEleTobevisible(locator);

			extent.info(code);
			result = "PASS";

		} catch (ElementNotVisibleException e) {
			extent.fail(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("some Exception found here=>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void sendkey(String locatorType, String value, String text) throws IOException, InterruptedException {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			// ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
			// element);

			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(text);
			if (element != null) {

				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

				// driver.findElement(locator).sendKeys(text);
				// element.sendKeys(text);

				if (element.getAttribute("value").equals(text)) {
					// System.out.println("test"+element.getAttribute("value"));
					extent.pass(code);
					result = "PASS";

				}

			} else {
				extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}

		} catch (TimeoutException e) {

			extent.fail(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("No Element Found to perform click" + e);
			result = "FAIL";

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void checkbox(String text) throws InterruptedException, IOException {
		try {

			int Size = Integer.parseInt(text);

			List<WebElement> li = driver.findElements(By.xpath(
					"//SPAN[@class='ag-selection-checkbox']//SPAN[@class='ag-icon ag-icon-checkbox-unchecked']"));
			System.out.println("checkbox" + li.size());
			for (int i = 0; i >= Size; i++) {

				// System.out.println( li.get(i));

				li.get(i).click();

			}

			extent.info(code);
			result = "PASS";

		} catch (ElementNotVisibleException e) {
			extent.fail(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("some Exception found here=>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void waitForElementVisible(String locatorType, String value) throws IOException {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WaitUtil.waitForEleTobevisible(locator);

			extent.info(code);
			result = "PASS";

		} catch (ElementNotVisibleException e) {
			extent.fail(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("some Exception found here=>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void ElementVisible(String locatorType, String value) throws IOException {
		try {
			By locator;
			locator = locatorValue(locatorType, value);

			if (driver.findElements(locator).size() != 0) {
				System.out.println("Element is Present");

				extent.pass(code);
				result = "PASS";

			} else {
				System.out.println("Element is Absent");

				extent.fail(code + code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "FAIL";

			}

		} catch (ElementNotVisibleException e) {
			extent.fail(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("some Exception found here=>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void Element_Not_Visible(String locatorType, String value) throws IOException {
		try {
			By locator;
			locator = locatorValue(locatorType, value);

			if (driver.findElements(locator).size() != 0) {
				System.out.println("Element is Present");

				extent.fail(code + code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "FAIL";

			} else {
				System.out.println("Element is Absent");

				extent.pass(code);
				result = "PASS";

			}

		} catch (ElementNotVisibleException e) {
			extent.fail(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("some Exception found here=>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void unique(String locatorType, String value, String text) throws IOException, InterruptedException {
		try {

			Random rand = new Random();
			int rand_int1 = rand.nextInt(1000);

			System.out.println("Random Integers: " + rand_int1);

			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(text + rand_int1);
			if (element != null) {

				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

				// driver.findElement(locator).sendKeys(text);
				// element.sendKeys(text);

				if (element.getAttribute("value").equals(text)) {
					// System.out.println("test"+element.getAttribute("value"));
					extent.pass(code);
					result = "PASS";

				}

			} else {
				extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}

		} catch (StaleElementReferenceException se) {
			extent.pass(code);
			result = "PASS";
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void waitForElementVisible_click(String locatorType, String value) throws IOException {
		try {

			By locator;
			locator = locatorValue(locatorType, value);

			WebElement ele = WaitUtil.waitForEleTobevisible(locator);

			ele.click();

			extent.info(code);
			result = "PASS";

		} catch (ElementNotVisibleException e) {
			extent.fail(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("some Exception found here=>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		} catch (TimeoutException e) {
			extent.fail(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("some Exception found here=>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		} catch (Exception e) {
			extent.fail(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("some Exception found here=>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

	/*
	 * public void ShipReqexcel() throws IOException, InterruptedException { //
	 * //String Result = null; try { System.out.println("non inventory ");
	 * 
	 * ShipRequisition req1 = new ShipRequisition();
	 * 
	 * System.out.println("Row Count1 : ");
	 * 
	 * extent.pass(code); result = "PASS";
	 * 
	 * } catch (Exception e) { extent.fail(code + e.getMessage(),
	 * MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
	 * 
	 * Log.error("EXCEPTION DESCRIPTION=====>" + e); result = "<a href=" +
	 * ScreenShot() + "> FAIL</a>"; // rs.getScenarios(TSID, Description, Result); }
	 * data.add(result); anotherMethod(result, data); }
	 * 
	 * 
	 */

	public void Passvalue(String locatorType, String value) throws IOException {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			// WebElement element = WaitUtil.fluentWait(locator);

			WebElement element1 = driver.findElement(By.xpath(" "));
			String value1 = element1.getAttribute("value");

			driver.findElement(locator).sendKeys(value1);

			extent.info(code);
			result = "PASS";

		} catch (ElementNotVisibleException e) {
			extent.fail(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("some Exception found here=>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void getText(String locatorType, String value, String text) throws IOException {

		try {

			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);

			int timeOut = 60;
			WebDriverWait wait1 = new WebDriverWait(driver, timeOut);

			wait1.until(new ExpectedCondition<Boolean>() {

				public Boolean apply(WebDriver driver) {

					{
						System.out.println("loop-----------------------try 1" + locator);
						gettextfromscreen = element.getText();

						return Boolean.TRUE;
					}
				}
			}

			);

			if (gettextfromscreen.contentEquals(text)) {

				System.out.println(text + "equal" + gettextfromscreen);
				extent.pass("Expected Result : " + text + "" + " Actual Result :" + gettextfromscreen);
				result = "PASS";

			} else {

				System.out.println(text + " notequal " + gettextfromscreen);
				extent.fail("Expected Result : " + text + "" + " Actual Result :" + gettextfromscreen,
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				// result = "<a href=" + ScreenShot() + "> FAIL</a>";
				result = "<a href=" + ScreenShot() + "> FAIL</a>" + "-Expected Result : " + text + ""
						+ " Actual Result :" + gettextfromscreen;

			}

		} catch (Exception e) {
			extent.error(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("some Exception found here=>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void getText_TotalRecord(String locatorType, String value, String text) throws IOException {

		try {

			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);

			String Textscreen = element.getText();

			String[] arrSplit = Textscreen.split(" ");
			String gettextfromscreen1 = arrSplit[0];

			if (gettextfromscreen1.contentEquals(text)) {

				System.out.println(text + "equal" + gettextfromscreen1);
				extent.pass("Expected Result : " + text + "" + " Actual Result :" + gettextfromscreen1);
				result = "PASS";

			} else {

				System.out.println(text + " notequal " + gettextfromscreen1);
				extent.fail("Expected Result : " + text + "" + " Actual Result :" + gettextfromscreen1,
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				// result = "<a href=" + ScreenShot() + "> FAIL</a>";
				result = "<a href=" + ScreenShot() + "> FAIL</a>" + "-Expected Result : " + text + ""
						+ " Actual Result :" + gettextfromscreen1;

			}

		} catch (Exception e) {
			extent.error(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("some Exception found here=>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void getText_Contain(String locatorType, String value, String text) throws IOException {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);

			String message = element.getText();

			if (message.contains(text)) {

				System.out.println(text + "equal" + message);
				extent.pass(text + "==equl==  " + message);
				result = "PASS";

			} else {

				System.out.println(text + " notequal " + message);
				extent.fatal(text + "==not Equl== " + message,
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				// result = "<a href=" + ScreenShot() + "> FAIL</a>";
				result = "FAIL";

			}

		} catch (Exception e) {
			extent.error(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("some Exception found here=>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void VerifyAttributevalue(String locatorType, String value, String text) throws IOException {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);

			String message = element.getAttribute("value");

			if (message.equalsIgnoreCase(text)) {

				System.out.println(text + "equal" + message);
				extent.pass(text + "==equl==  " + message);
				result = "PASS";

			} else {

				System.out.println(text + " notequal " + message);
				extent.fatal(text + "==not Equl== " + message,
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				// result = "<a href=" + ScreenShot() + "> FAIL</a>";
				result = "FAIL";

			}

		} catch (Exception e) {
			extent.error(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("some Exception found here=>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void mandatory(String locatorType, String value) throws IOException {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);
			String Symbol = element.getText();
			System.out.println(Symbol);
			if (Symbol.equals("*")) {

				System.out.println("mandatory field");

				extent.pass(code + "    " + "Expected Result:Field should have astriesk Mark" + ""
						+ "Actual Result : Astriesk Mark Found");
				result = "PASS";

			}

			else {

				extent.fail(
						"Expected Result:Field should have astriesk Mark" + ""
								+ "Actual Result : Astriesk Mark Not Found" + code,
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>" + code + "    "
						+ "Expected Result:Field should have astriesk Mark" + ""
						+ "Actual Result : Astriesk Mark Not Found";
			}

		} catch (Exception e) {

			extent.fail(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("some Exception found here=>" + e);

			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void VerifyCurrentDate(String locatorType, String value) throws IOException {
		try {
			By locator;
			String Date1;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			Date1 = element.getAttribute("value");

			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			String Date2 = formatter.format(date);

			if (Date1.equals(Date2)) {

				System.out.println(Date1 + "date" + Date2);

				extent.pass(code + "    " + "Expected Result:Date should be current Date" + ""
						+ "Actual Result : Current Date Found");
				result = "PASS";

			}

			else {

				extent.fail("Expected Result:Date should be current Date" + ""
						+ "Actual Result : Current Date Not Found" + code,
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>" + code + "    "
						+ "Expected Result:Date should be current Date" + "" + "Actual Result : Current Date Not Found";
			}

		} catch (Exception e) {

			extent.fail(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("some Exception found here=>" + e);

			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void attachmentcolor_Blue(String locatorType, String value) throws IOException {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			String color = element.getAttribute("style");

			System.out.println("attribute" + color);

			if (color.contains("background-color: rgb(17, 30, 163) !important;")) {

				System.out.println("blue");
				extent.pass(code);
				result = "PASS";

			}

			else {

				System.out.println("not blue");
				extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}
		} catch (Exception e) {
			extent.fail(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("some Exception found here=>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void attachmentcolor_notBlue(String locatorType, String value) throws IOException {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			String color = element.getAttribute("style");

			System.out.println("blue" + color);

			if (color.contains("background-color: rgb(17, 30, 163) !important;")) {

				System.out.println("  blue");
				extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}

			else {
				System.out.println("Not blue");
				extent.pass(code);
				result = "PASS";

			}
		} catch (ElementNotVisibleException e) {
			extent.fail(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("some Exception found here=>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void ButtonEnable(String locatorType, String value) throws IOException {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			// System.out.println("attribute"+element.getAttribute("class"));

			if (element.getAttribute("class").contains("disabled")) {

				System.out.println("buttondissable");
				extent.fail(code + "--------------------button Disable--------------------",
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
				;

			} else {
				System.out.println("buttonenable");
				extent.pass(code + "-------------------------buttonenable-------------------------------");
				result = "PASS";
			}
			// result = "PASS";
			// extent.pass(code);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void RadioButton_selected(String locatorType, String value) throws IOException {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			// System.out.println("attribute"+element.getAttribute("class"));

			if (element.getAttribute("class").contains("ui-icon-blank")) {

				System.out.println("Radio Button not selected");
				extent.fail(code + "--------------------button Disable--------------------",
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
				;

			} else {
				System.out.println("Ration Button selected");
				extent.pass(code + "-------------------------buttonenable-------------------------------");
				result = "PASS";
			}
			// result = "PASS";
			// extent.pass(code);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void Buttondisable(String locatorType, String value) throws IOException {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			// WebElement element1 =
			// driver.findElement(By.xpath("//button [contains(@id,'-dft_button')]"));

			if (element.getAttribute("class").contains("disabled")) {

				extent.pass(code + "---------------buttondissable----------------------");
				result = "PASS";

			} else {

				extent.fail(code + "------------------buttonenable---------------------",
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}
			// result = "PASS";
			// extent.pass(code);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void datacompare(String locatorType, String value, String text) throws IOException, InterruptedException {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			String value1 = element.getAttribute("value");
			// System.out.println("text"+value1);

			// System.out.println("text"+value2);

			if (value1.equalsIgnoreCase(text)) {

				System.out.println(value1 + "pass" + text);

				extent.pass(code);
				result = "PASS";

			} else if (value1.equalsIgnoreCase("")) {

				System.out.println(value1 + "null ");

				extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}

			else {

				System.out.println(value1 + "fail" + text);

				extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}

		} catch (StaleElementReferenceException se) {
			extent.pass(code);
			result = "PASS";
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void datacompare_Dropdown(String locatorType, String value, String text)
			throws IOException, InterruptedException {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			String value2 = element.getText();

			// System.out.println("text"+value2);

			if (value2.equalsIgnoreCase(text)) {

				System.out.println(value2 + "pass" + text);

				extent.pass(code);
				result = "PASS";

			} else if (value2.equalsIgnoreCase("")) {

				System.out.println(value2 + "null ");

				extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}

			else {
				System.out.println("fail");

				System.out.println(value2 + "fail" + text);

				extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}

		} catch (StaleElementReferenceException se) {
			extent.pass(code);
			result = "PASS";
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void ReviewCancel(String locatorType, String value) throws IOException {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			System.out.println("status" + element.getText());

			if (element.getText().contains("RE-ASSIGN")) {
				Thread.sleep(1000);

				driver.findElement(By.xpath("//button [contains(@id,'-btnsave')] ")).click();
				Thread.sleep(4500);

				WebElement element1 = WaitUtil.fluentWait(locator);

				if (element1.getText().contains("DRAFT")) {

					extent.info("draft ");
					// extent.info("cancel working correctly"+element1.getText());
					extent.pass(code + "cancel working correctly" + element1.getText());
					result = "PASS";

				} else {
					extent.info("not in draft ");
					// System.out.println("not"+element1.getText());
					extent.fail(code + "not cancel working correctly" + element1.getText(),
							MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
					result = "<a href=" + ScreenShot() + "> FAIL</a>";
					;
				}

			} else {
				extent.info("not in cancel " + element.getText());
				// extent.info("not in review cancel"+element.getText());
				extent.fail(code + "not in review cancel" + element.getText(),
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
				;

			}
			// result = "PASS";
			// extent.pass(code);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void Reject(String locatorType, String value) throws IOException {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			System.out.println("status" + element.getText());

			if (element.getText().contains("REJECT")) {
				Thread.sleep(1000);

				driver.findElement(By.xpath("//button [contains(@id,'-btnsave')] ")).click();
				Thread.sleep(3000);

				WebElement element1 = WaitUtil.fluentWait(locator);

				if (element1.getText().contains("REJECT")) {

					extent.info("draft ");
					// extent.info("Reject working correctly"+element1.getText());
					extent.pass("Reject working correctly" + element1.getText());
					result = "PASS";

				} else {
					extent.info("not in REJECT ");
					// extent.info("Reject working correctly"+element1.getText());
					extent.fail(code + "Reject working correctly" + element1.getText(),
							MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
					result = "<a href=" + ScreenShot() + "> FAIL</a>";
					;
				}

			} else {
				extent.info("not in Reject " + element.getText());
				// extent.info("not in review cancel"+element.getText());
				extent.fail(code + "not in review cancel" + element.getText(),
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
				;

			}
			// result = "PASS";
			// extent.pass(code);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void PurschaeNo(String locatorType, String value) throws IOException {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			PurchaseNo1 = element.getAttribute("value");
			System.out.println(PurchaseNo1);

			result = "PASS";
			extent.pass(code);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void SerialNo_Copy(String locatorType, String value) throws IOException {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			SerialNo_Copy = (element.getText().substring(7));

			System.out.println(PurchaseNo1);

			result = "PASS";
			extent.pass(code);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void insideScroll(String text, String value) throws IOException, StaleElementReferenceException {
		try {

			EventFiringWebDriver scroll = new EventFiringWebDriver(driver);

			scroll.executeScript("document.querySelector('" + text + "').scrollTop=" + value + "");

			result = "PASS";
			extent.pass(code);

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void doubleClick1(String locatorType, String value) throws IOException, InterruptedException {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			By locator;
			locator = locatorValue(locatorType, value);

			WebElement findElement = driver.findElement(locator);
			Actions action = new Actions(driver);
			WebElement click = driver.findElement(locator);
			action.moveToElement(click).doubleClick().build().perform();
			extent.pass(code);
			result = "PASS";

		}

		// Thread.sleep(2000);
		catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
			// rs.getScenarios(TSID, Description, Result);
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void mouseMove(String locatorType, String value) throws IOException, InterruptedException {

		try {

			By locator;
			locator = locatorValue(locatorType, value);

			WebElement findElement = driver.findElement(locator);
			Actions action = new Actions(driver);
			WebElement click = driver.findElement(locator);
			action.moveToElement(click).click().build().perform();
			extent.pass(code);
			result = "PASS";

		}

		// Thread.sleep(2000);
		catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
			// rs.getScenarios(TSID, Description, Result);
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void scrollEnd(String locatorType, String value) throws IOException, InterruptedException {

		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			extent.pass(code);
			result = "PASS";

		}

		// Thread.sleep(2000);
		catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
			// rs.getScenarios(TSID, Description, Result);
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void Copy_Serail(String locatorType, String value) throws IOException {
		try {
			System.out.println(SerialNo_Copy);
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			element.sendKeys(SerialNo_Copy);

			result = "PASS";
			extent.pass(code);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void ShipPurschaeNo(String locatorType, String value) throws IOException {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			ShipPurchaseNo1 = element.getAttribute("value");
			System.out.println(ShipPurchaseNo1);

			result = "PASS";
			extent.pass(code);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void GetPurschaeNo(String locatorType, String value) throws IOException {
		try {
			System.out.println(PurchaseNo1);
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			element.sendKeys(PurchaseNo1);

			result = "PASS";
			extent.pass(code);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void GetPurschaeNo_Ship(String locatorType, String value) throws IOException {
		try {
			System.out.println(ShipPurchaseNo1);
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			element.sendKeys(ShipPurchaseNo1);

			result = "PASS";
			extent.pass(code);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void File_Exist_delete(String text) throws IOException {
		try {
			String path = text;
			File file = new File(path);
			File[] files = file.listFiles();
			for (File f : files) {
				if (f.isFile() && f.exists()) {
					f.delete();
					extent.pass("successfully deleted");
				} else {
					extent.info("cant delete a file due to open or error");
				}
			}

			result = "PASS";
			extent.pass(code);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void GetPurschaeNoRO_Ship(String locatorType, String value) throws IOException {
		try {
			System.out.println(ShipPurchaseNo1);
			Thread.sleep(1000);
			String ar[] = ShipPurchaseNo1.split("/");

			// System.out.println(ar[0]);

			// System.out.println(ar[1]);

			// System.out.println(ar[2]);

			// System.out.println(ar[3]);

			// System.out.println(ar[4]);

			ar[2] = "RO";

			// System.out.println(ar[0]+"/"+ar[1]+"/"+ar[2]+"/"+ar[3]+"/"+ar[4]);

			String Ship_PurschaeNoRFQ = ar[0] + "/" + ar[1] + "/" + ar[2] + "/" + ar[3] + "/" + ar[4];
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			element.sendKeys(Ship_PurschaeNoRFQ);

			result = "PASS";
			extent.pass(code);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void GetPurschaeNoRO(String locatorType, String value) throws IOException {
		try {

			System.out.println(PurchaseNo1);
			Thread.sleep(1000);
			String ar[] = PurchaseNo1.split("/");

			// System.out.println(ar[0]);

			// System.out.println(ar[1]);

			// System.out.println(ar[2]);

			// System.out.println(ar[3]);

			// System.out.println(ar[4]);

			ar[2] = "RO";

			// System.out.println(ar[0]+"/"+ar[1]+"/"+ar[2]+"/"+ar[3]+"/"+ar[4]);

			String PurschaeNoRFQ = ar[0] + "/" + ar[1] + "/" + ar[2] + "/" + ar[3] + "/" + ar[4];
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			element.sendKeys(PurschaeNoRFQ);

			result = "PASS";
			extent.pass(code);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void GetPurschaeNoRFQ_Ship(String locatorType, String value, String text) throws IOException {
		try {
			System.out.println(ShipPurchaseNo1);
			Thread.sleep(1000);
			String ar[] = ShipPurchaseNo1.split("/");

			// System.out.println(ar[0]);

			// System.out.println(ar[1]);

			// System.out.println(ar[2]);

			// System.out.println(ar[3]);

			// System.out.println(ar[4]);

			ar[2] = "rfq";

			// System.out.println(ar[0]+"/"+ar[1]+"/"+ar[2]+"/"+ar[3]+"/"+ar[4]);

			String Ship_PurschaeNoRFQ = ar[0] + "/" + ar[1] + "/" + ar[2] + "/" + ar[3] + "/" + ar[4] + "-" + text;
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			element.sendKeys(Ship_PurschaeNoRFQ);

			result = "PASS";
			extent.pass(code);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void GetPurschaeNoRFQ(String locatorType, String value, String text) throws IOException {
		try {

			System.out.println(PurchaseNo1);

			Thread.sleep(1000);
			String ar[] = PurchaseNo1.split("/");

			// System.out.println(ar[0]);

			// System.out.println(ar[1]);

			// System.out.println(ar[2]);

			// System.out.println(ar[3]);

			// System.out.println(ar[4]);

			ar[2] = "rfq";

			// System.out.println(ar[0]+"/"+ar[1]+"/"+ar[2]+"/"+ar[3]+"/"+ar[4]);

			String PurschaeNoRFQ = ar[0] + "/" + ar[1] + "/" + ar[2] + "/" + ar[3] + "/" + ar[4] + "-" + text;
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			element.sendKeys(PurschaeNoRFQ);

			result = "PASS";
			extent.pass(code);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void GetPurschaeNoRFQCompar(String locatorType, String value) throws IOException {
		try {
			System.out.println(PurchaseNo1);

			String ar[] = PurchaseNo1.split("/");

			// System.out.println(ar[0]);

			// System.out.println(ar[1]);

			// System.out.println(ar[2]);

			// System.out.println(ar[3]);

			// System.out.println(ar[4]);

			ar[2] = "rfq";

			// System.out.println(ar[0]+"/"+ar[1]+"/"+ar[2]+"/"+ar[3]+"/"+ar[4]);

			String PurschaeNoRFQ = ar[0] + "/" + ar[1] + "/" + ar[2] + "/" + ar[3] + "/" + ar[4];
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			element.sendKeys(PurschaeNoRFQ);

			result = "PASS";
			extent.pass(code);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void GetPurschaeNoRFQCompar_Ship(String locatorType, String value) throws IOException {
		try {
			System.out.println(ShipPurchaseNo1);

			String ar[] = ShipPurchaseNo1.split("/");

			// System.out.println(ar[0]);

			// System.out.println(ar[1]);

			// System.out.println(ar[2]);

			// System.out.println(ar[3]);

			// System.out.println(ar[4]);

			ar[2] = "rfq";

			// System.out.println(ar[0]+"/"+ar[1]+"/"+ar[2]+"/"+ar[3]+"/"+ar[4]);

			String Ship_PurschaeNoRFQ = ar[0] + "/" + ar[1] + "/" + ar[2] + "/" + ar[3] + "/" + ar[4];
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			element.sendKeys(Ship_PurschaeNoRFQ);

			result = "PASS";
			extent.pass(code);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void GetPurschaeNoPO(String locatorType, String value, String text) throws IOException {
		try {
			// System.out.println(PurchaseNo1);

			// PurchaseNo1 = "SSE/O1/PO/0005/2020";

			// System.out.println(ar[0]);

			// System.out.println(ar[1]);

			// System.out.println(ar[2]);

			// System.out.println(ar[3]);

			// System.out.println(ar[4]);

			String ar[] = PurchaseNo1.split("/");

			ar[2] = "PO";

			System.out.println(ar[0] + "/" + ar[1] + "/" + ar[2] + "/" + ar[3] + "/" + ar[4]);

			String GetPurschaeNoPO = ar[0] + "/" + ar[1] + "/" + ar[2] + "/" + ar[3] + "/" + ar[4] + "-" + text;
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			element.sendKeys(GetPurschaeNoPO);

			System.out.println("PO trns no------------------------------------>" + GetPurschaeNoPO);

			result = "PASS";
			extent.pass(code);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void GetPurschaeNoPO_Ship(String locatorType, String value, String text) throws IOException {
		try {
			// System.out.println(PurchaseNo1);

			// System.out.println(ar[0]);

			// System.out.println(ar[1]);

			// System.out.println(ar[2]);

			// System.out.println(ar[3]);

			// System.out.println(ar[4]);

			String ar[] = ShipPurchaseNo1.split("/");

			ar[2] = "PO";

			System.out.println(ar[0] + "/" + ar[1] + "/" + ar[2] + "/" + ar[3] + "/" + ar[4]);

			String Ship_GetPurschaeNoPO = ar[0] + "/" + ar[1] + "/" + ar[2] + "/" + ar[3] + "/" + ar[4] + "-" + text;
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			element.sendKeys(Ship_GetPurschaeNoPO);

			System.out.println("PO trns no------------------------------------>" + Ship_GetPurschaeNoPO);

			result = "PASS";
			extent.pass(code);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void GetPurschaeNoMR_Ship(String locatorType, String value, String text) throws IOException {
		try {
			// System.out.println(PurchaseNo1);

			// System.out.println(ar[0]);

			// System.out.println(ar[1]);

			// System.out.println(ar[2]);

			// System.out.println(ar[3]);

			// System.out.println(ar[4]);

			String ar[] = ShipPurchaseNo1.split("/");

			ar[2] = "MR";

			System.out.println(ar[0] + "/" + ar[1] + "/" + ar[2] + "/" + ar[3] + "/" + ar[4]);

			String Ship_GetPurschaeNoMR = ar[0] + "/" + ar[1] + "/" + ar[2] + "/" + ar[3] + "/" + ar[4] + "-" + text;
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			element.sendKeys(Ship_GetPurschaeNoMR);

			System.out.println("MR trns no------------------------------------>" + Ship_GetPurschaeNoMR);

			result = "PASS";
			extent.pass(code);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void GetPurschaeNoMR(String locatorType, String value, String text) throws IOException {
		try {
			// System.out.println(PurchaseNo1);

			// System.out.println(ar[0]);

			// System.out.println(ar[1]);

			// System.out.println(ar[2]);

			// System.out.println(ar[3]);

			// System.out.println(ar[4]);

			String ar[] = PurchaseNo1.split("/");

			ar[2] = "MR";

			System.out.println(ar[0] + "/" + ar[1] + "/" + ar[2] + "/" + ar[3] + "/" + ar[4]);

			String GetPurschaeNoMR = ar[0] + "/" + ar[1] + "/" + ar[2] + "/" + ar[3] + "/" + ar[4] + "-" + text;
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			element.sendKeys(GetPurschaeNoMR);

			System.out.println("MR trns no------------------------------------>" + GetPurschaeNoMR);

			result = "PASS";
			extent.pass(code);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void GetPurschaeNoINV_Ship(String locatorType, String value, String text) throws IOException {
		try {
			// System.out.println(PurchaseNo1);

			// System.out.println(ar[0]);

			// System.out.println(ar[1]);

			// System.out.println(ar[2]);

			// System.out.println(ar[3]);

			// System.out.println(ar[4]);

			String ar[] = ShipPurchaseNo1.split("/");

			ar[2] = "INV";

			System.out.println(ar[0] + "/" + ar[1] + "/" + ar[2] + "/" + ar[3] + "/" + ar[4]);

			String Ship_GetPurschaeNoinv = ar[0] + "/" + ar[1] + "/" + ar[2] + "/" + ar[3] + "/" + ar[4] + "-" + text;
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			element.sendKeys(Ship_GetPurschaeNoinv);

			System.out.println("MR trns no------------------------------------>" + Ship_GetPurschaeNoinv);

			result = "PASS";
			extent.pass(code);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void GetPurschaeNoINV(String locatorType, String value, String text) throws IOException {
		try {
			// System.out.println(PurchaseNo1);

			// System.out.println(ar[0]);

			// System.out.println(ar[1]);

			// System.out.println(ar[2]);

			// System.out.println(ar[3]);

			// System.out.println(ar[4]);

			String ar[] = PurchaseNo1.split("/");

			ar[2] = "inv";

			System.out.println(ar[0] + "/" + ar[1] + "/" + ar[2] + "/" + ar[3] + "/" + ar[4]);

			String GetPurschaeNoinv = ar[0] + "/" + ar[1] + "/" + ar[2] + "/" + ar[3] + "/" + ar[4] + "-" + text;
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			element.sendKeys(GetPurschaeNoinv);

			System.out.println("inv trns no------------------------------------>" + GetPurschaeNoinv);

			result = "PASS";
			extent.pass(code);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void ReqRefNo(String locatorType, String value) throws IOException {
		try {

			// System.out.println(PurchaseNo1);

			// System.out.println(ar[0]);

			// System.out.println(ar[1]);

			// System.out.println(ar[2]);

			// System.out.println(ar[3]);

			// System.out.println(ar[4]);

			String ar[] = PurchaseNo1.split("/");

			System.out.println(ar[0] + "/" + ar[1] + "/" + ar[3] + "/" + ar[4] + "/R");

			String UniqueRef_No = ar[0] + "/" + ar[1] + "/" + ar[3] + "/" + ar[4] + "/R";
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			element.sendKeys(UniqueRef_No);

			System.out.println("UNIQUE ref------------------------------------>" + UniqueRef_No);

			result = "PASS";
			extent.pass(code);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void Ship_ReqRefNo(String locatorType, String value) throws IOException {
		try {
			// System.out.println(PurchaseNo1);

			// System.out.println(ar[0]);

			// System.out.println(ar[1]);

			// System.out.println(ar[2]);

			// System.out.println(ar[3]);

			// System.out.println(ar[4]);

			String ar[] = ShipPurchaseNo1.split("/");

			System.out.println(ar[0] + "/" + ar[1] + "/" + ar[3] + "/" + ar[4] + "/R");

			String UniqueRef_No = ar[0] + "/" + ar[1] + "/" + ar[3] + "/" + ar[4] + "/R";
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			element.sendKeys(UniqueRef_No);

			System.out.println("UNIQUE ref------------------------------------>" + UniqueRef_No);

			result = "PASS";
			extent.pass(code);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void Converting_FileXLS(String text) throws IOException {
		try {

			String oldfileExtension = text;
			System.out.println(oldfileExtension);

			File oldfile = new File(oldfileExtension);
			if (!oldfile.exists()) {
				System.out.println("File does not exist.");
				System.exit(0);
			}
			int dotPos = oldfileExtension.lastIndexOf(".");
			String strExtension = oldfileExtension.substring(dotPos + 1);
			String strFilename = oldfileExtension.substring(0, dotPos);
			String newfileExtension = "xls";
			String strNewFileName = strFilename + "." + newfileExtension;
			System.out.println(strNewFileName);

			File newfile = new File(strNewFileName);
			boolean Rename = oldfile.renameTo(newfile);

			if (!Rename) {
				System.out.println("FileExtension hasn't been changed successfully.");

			} else {
				System.out.println("FileExtension has been changed successfully.");
			}

			extent.pass(code);

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void Converting_FileXLSX(String text) throws IOException {
		try {

			String oldfileExtension = text;
			File oldfile = new File(oldfileExtension);
			if (!oldfile.exists()) {
				System.out.println("File does not exist.");
				System.exit(0);
			}
			int dotPos = oldfileExtension.lastIndexOf(".");
			String strExtension = oldfileExtension.substring(dotPos + 1);
			String strFilename = oldfileExtension.substring(0, dotPos);
			String newfileExtension = "xlsx";
			String strNewFileName = strFilename + "." + newfileExtension;
			File newfile = new File(strNewFileName);
			boolean Rename = oldfile.renameTo(newfile);

			System.out.println(newfile);
			if (!Rename) {
				System.out.println("FileExtension hasn't been changed successfully.");
				System.out.println(strNewFileName);

			} else {
				System.out.println("FileExtension has been changed successfully.");
			}

			extent.pass(code);

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void openfile(String text) throws IOException {
		try {

			File file = new File(text);

			// first check if Desktop is supported by Platform or not
			if (!Desktop.isDesktopSupported()) {
				System.out.println("Desktop is not supported");
				return;
			}

			Desktop desktop = Desktop.getDesktop();
			if (file.exists())
				desktop.open(file);
			if (file.exists())
				desktop.edit(file);

			extent.pass(code);

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void setcellvalueexcel(String locatorType, String value) throws IOException {
		try {
			if (Input != null) {
				By locator;
				locator = locatorValue(locatorType, value);
				WebElement element = WaitUtil.fluentWait(locator);

				String TotalItem = element.getText();
				int TotalItem1 = Integer.parseInt(TotalItem);

				System.out.println(TotalItem);

				String path = "C:\\Users\\pushpakumari.d\\Downloads\\" + Input;
				System.out.println(path);

				File myFile = new File(path);

				FileInputStream fis = new FileInputStream(myFile);

				HSSFWorkbook myWorkBook = new HSSFWorkbook(fis);

				String sheetName = "Sheet1";
				HSSFSheet mySheet = myWorkBook.getSheet(sheetName);
				HSSFRow row = null;

				// Making the object of excel row

				row = mySheet.getRow(0);

				int colCount = row.getLastCellNum();

				System.out.println("Column Count : " + colCount);

				int rowCount = mySheet.getLastRowNum();
				System.out.println("Row Count : " + rowCount);

				for (int i = 15; i <= TotalItem1 + 14; i++) {

					k = 0;

					System.out.println("taking input");

					System.out.println("RFQ quantity" + mySheet.getRow(i).getCell(k + 6));

					System.out.println("RFQ quantity" + mySheet.getRow(i).getCell(k + 7));
					System.out.println("RFQ quantity" + mySheet.getRow(i).getCell(k + 12));
					System.out.println("RFQ quantity" + mySheet.getRow(i).getCell(k + 13));

					extent.info("Quotation for " + "---------------------------->ITEM " + i);

					// Rfq quantity

					cell = mySheet.getRow(i).getCell(k + 8);

					System.out.println("RFQ quantity" + mySheet.getRow(i).getCell(k + 8));

					cell.setCellValue(100 + i);
					extent.info("Quotation for " + "---------------------------->ITEM " + i);
					// Discount

					cell = mySheet.getRow(i).getCell(k + 10);

					cell.setCellValue(10);

					// leadtime
					System.out.println("Discount" + mySheet.getRow(i).getCell(k + 10));

					cell = mySheet.getRow(i).getCell(k + 11);

					cell.setCellValue(3);
					System.out.println("leadtime" + mySheet.getRow(i).getCell(k + 11));

					// stocklocation

					cell = mySheet.getRow(i).getCell(k + 12);

					cell.setCellValue("office");

					System.out.println("stocklocation" + mySheet.getRow(i).getCell(k + 12));
					// remark received from

					cell = mySheet.getRow(i).getCell(k + 14);

					cell.setCellValue("Remark Received From");
					System.out.println("remark" + mySheet.getRow(i).getCell(k + 14));

					// dangerous good
					cell = mySheet.getRow(i).getCell(k + 15);

					cell.setCellValue("Y");

					// Leadtime Stock Location Remark Received From Dangerous
					// Goods(Y/N)

					fis.close();

					FileOutputStream outFile = new FileOutputStream(
							new File("C:\\Users\\pushpakumari.d\\Downloads\\" + Input));
					myWorkBook.write(outFile);
					outFile.close();

					extent.pass(code);
				}

			} else {
				System.out.println(Input);

				extent.fail(code + MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}
		} catch (TimeoutException e) {

			extent.fail(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("No Element Found to perform click" + e);
			result = "FAIL";

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void quotationcompare() throws BiffException, IOException, InterruptedException {
		// //String Result = null;
		try {

			String path = "F:\\vendor.xls";

			File myFile = new File(path);

			FileInputStream fis = new FileInputStream(myFile);

			HSSFWorkbook myWorkBook = new HSSFWorkbook(fis);

			String sheetName = "sheet1";
			HSSFSheet mySheet = myWorkBook.getSheet(sheetName);
			HSSFRow row = null;

			// Making the object of excel row

			row = mySheet.getRow(0);

			int colCount = row.getLastCellNum();

			System.out.println("Column Count : " + colCount);

			int rowCount = mySheet.getLastRowNum();
			// System.out.println("Row Count : " + rowCount);

			for (int i = 1; i <= rowCount; i++) {

				k = 0;

				extent.info(code + "---------------------------->ITEM " + i);

				double RFQQuantity = mySheet.getRow(i).getCell(k + 4).getNumericCellValue();

				System.out.println(RFQQuantity);
				double QuotedUnitCost = mySheet.getRow(i).getCell(k + 6).getNumericCellValue();
				System.out.println(QuotedUnitCost);
				double QuotedDisUnitCost = mySheet.getRow(i).getCell(k + 7).getNumericCellValue();
				System.out.println(QuotedDisUnitCost);
				double TotalQuotedCost = mySheet.getRow(i).getCell(k + 8).getNumericCellValue();

				double Discount = mySheet.getRow(i).getCell(k + 14).getNumericCellValue();

				double BaseUnitCost = mySheet.getRow(i).getCell(k + 10).getNumericCellValue();

				double BaseDisUnitCost = mySheet.getRow(i).getCell(k + 11).getNumericCellValue();

				double BaseTotalCost = mySheet.getRow(i).getCell(k + 12).getNumericCellValue();

				double BasDisTotalCost = mySheet.getRow(i).getCell(k + 13).getNumericCellValue();

				Exchange = mySheet.getRow(i).getCell(k + 9).getStringCellValue();

				RateOfExchange test1 = new RateOfExchange();

				double RATE1 = Double.parseDouble(test1.ROE);

				double QuotedDisUnitCost1 = (QuotedUnitCost - ((QuotedUnitCost * Discount) / 100));

				double TotalQuotedCost1 = QuotedUnitCost * RFQQuantity;

				double BaseUnitCost1 = QuotedUnitCost * RATE1;

				double BaseDisUnitCost1 = QuotedDisUnitCost1 * RATE1;

				double BaseTotalCost1 = TotalQuotedCost1 * RATE1;

				double BasDisTotalCost1 = BaseDisUnitCost1 * RFQQuantity;

				vendorBaseAmount1 = vendorBaseAmount1 + BaseTotalCost1;

				vendorBaseDiscountedAmount1 = vendorBaseDiscountedAmount1 + BasDisTotalCost1;

				vendorQuotedCost1 = vendorQuotedCost1 + TotalQuotedCost1;

				vendorQuotedDiscount1 = vendorQuotedDiscount1 + (QuotedDisUnitCost1 * RFQQuantity);

				// calculation for QuotedDisUnitCost

				try {

					if (QuotedDisUnitCost1 == QuotedDisUnitCost) {

						extent.pass("QuotedDisUnitCost==" + QuotedDisUnitCost1 + "pass" + QuotedDisUnitCost);

						result = "PASS";
					} else {
						extent.fatal("QuotedDisUnitCost==" + QuotedDisUnitCost1 + "FAIL" + QuotedDisUnitCost);
					}

				} catch (Exception e) {

					extent.error(code + e.getMessage());

					Log.error("EXCEPTION DESCRIPTION=====>" + e);

					// rs.getScenarios(TSID, Description, Result);
				}

				// calculation for TotalQuotedCost
				try {
					if (TotalQuotedCost1 == TotalQuotedCost) {
						extent.pass("TotalQuotedCost==" + TotalQuotedCost1 + "pass" + TotalQuotedCost);

						result = "PASS";
					} else {
						extent.fatal("TotalQuotedCost==" + TotalQuotedCost1 + "FAIL" + TotalQuotedCost);

					}

				} catch (Exception e) {
					extent.error(code + e.getMessage());

					Log.error("EXCEPTION DESCRIPTION=====>" + e);

					// rs.getScenarios(TSID, Description, Result);
				}

				// calculation for BaseUnitCost
				try {
					if (BaseUnitCost1 == BaseUnitCost) {
						extent.pass("BaseUnitCost==" + BaseUnitCost1 + "pass" + BaseUnitCost);

						result = "PASS";
					} else {
						extent.fatal("BaseUnitCost==" + BaseUnitCost1 + "FAIL" + BaseUnitCost);

					}
				} catch (Exception e) {
					extent.error(code + e.getMessage());

					Log.error("EXCEPTION DESCRIPTION=====>" + e);

				}

				// calculation for BaseDisUnitCost

				try {
					if (BaseDisUnitCost1 == BaseDisUnitCost) {
						extent.pass("BaseDisUnitCost==" + BaseDisUnitCost1 + "pass" + BaseDisUnitCost);

						result = "PASS";
					} else {
						extent.fatal("BaseDisUnitCost==" + BaseDisUnitCost1 + "FAIL" + BaseDisUnitCost);

					}
				} catch (Exception e) {
					extent.error(code + e.getMessage());

					Log.error("EXCEPTION DESCRIPTION=====>" + e);

					// rs.getScenarios(TSID, Description, Result);
				}

				// calculation for BaseQuotedCost

				try {
					if (BaseTotalCost1 == BaseTotalCost) {
						extent.pass("BaseQuotedCost==" + BaseTotalCost1 + "pass" + BaseTotalCost);

						result = "PASS";
					} else {
						extent.fatal("BaseQuotedCost==" + BaseTotalCost1 + "FAIL" + BaseTotalCost);

					}
				} catch (Exception e) {
					extent.error(code + e.getMessage());

					Log.error("EXCEPTION DESCRIPTION=====>" + e);

					// rs.getScenarios(TSID, Description, Result);
				}

				// calculation for BasDisTotalCost

				try {

					if (BasDisTotalCost1 == BasDisTotalCost) {
						extent.pass("BasDisTotalCost==" + BasDisTotalCost1 + "pass" + BasDisTotalCost);

						result = "PASS";
					} else {
						// System.out.println(BasDisTotalCost1+"FAIL"+BasDisTotalCost);

						extent.fatal("BasDisTotalCost==" + BasDisTotalCost1 + "FAIL" + BasDisTotalCost);

					}
				} catch (Exception e) {
					extent.error(code + e.getMessage());
					Log.error("EXCEPTION DESCRIPTION=====>" + e);

					// rs.getScenarios(TSID, Description, Result);
				}

			}
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
			// rs.getScenarios(TSID, Description, Result);
		}

		try {

			String path1 = "F:\\item.xls";
			File myFile1 = new File(path1);

			FileInputStream fis1 = new FileInputStream(myFile1);

			HSSFWorkbook myWorkBook1 = new HSSFWorkbook(fis1);

			String sheetName1 = "sheet1";
			HSSFSheet mySheet1 = myWorkBook1.getSheet(sheetName1);
			HSSFRow row1 = null;
			System.out.println("Column Count : " + sheetName1);

			// Making the object of excel row

			row1 = mySheet1.getRow(0);

			int colCoun1t = row1.getLastCellNum();

			System.out.println("Column Count : ");

			int rowCount1 = mySheet1.getLastRowNum();
			// System.out.println("Row Count : " + rowCount);

			for (int p = 1; p <= rowCount1; p++) {

				int j = 0;

				extent.info(code + "---------------------------->VENDOR " + p);

				double vendorBaseAmount = mySheet1.getRow(p).getCell(j + 5).getNumericCellValue();

				System.out.println("Column Count : " + vendorBaseAmount);
				// System.out.println(vendorBaseAmount);

				double vendorBaseDiscountedAmount = mySheet1.getRow(p).getCell(j + 6).getNumericCellValue();
				// System.out.println(vendorBaseDiscountedAmount);

				double vendorQuotedCost = mySheet1.getRow(p).getCell(j + 7).getNumericCellValue();
				// System.out.println(vendorQuotedCost);

				double vendorQuotedDiscount = mySheet1.getRow(p).getCell(j + 8).getNumericCellValue();

				// System.out.println(vendorQuotedDiscount);

				// calculation of vendor vendorBaseAmount
				try {

					if (vendorBaseAmount1 == vendorBaseAmount) {

						extent.pass("vendorBaseAmount==" + vendorBaseAmount1 + "pass" + vendorBaseAmount);

						result = "PASS";
					} else {
						// System.out.println(BasDisTotalCost1+"FAIL"+BasDisTotalCost);

						extent.fatal("BasDisTotalCost==" + vendorBaseAmount1 + "FAIL" + vendorBaseAmount);

					}
				} catch (Exception e) {
					extent.error(code + e.getMessage());
					Log.error("EXCEPTION DESCRIPTION=====>" + e);
				}

				// calculation of vendor BaseDiscountedAmount

				try {

					if (vendorQuotedCost1 == vendorQuotedCost) {

						extent.pass("vendorQuotedCost==" + vendorQuotedCost1 + "pass" + vendorQuotedCost);

						result = "PASS";
					} else {
						// System.out.println(BasDisTotalCost1+"FAIL"+BasDisTotalCost);

						extent.fatal("vendorQuotedCost==" + vendorQuotedCost1 + "FAIL" + vendorQuotedCost);

					}
				} catch (Exception e) {
					extent.error(code + e.getMessage());
					Log.error("EXCEPTION DESCRIPTION=====>" + e);

				}

				// calculation of vendor BaseDiscountedAmount

				try {

					if (vendorBaseDiscountedAmount1 == vendorBaseDiscountedAmount) {

						extent.pass("vendorBaseDiscountedAmount==" + vendorBaseDiscountedAmount1 + "pass"
								+ vendorBaseDiscountedAmount);

						result = "PASS";
					} else {
						// System.out.println(BasDisTotalCost1+"FAIL"+BasDisTotalCost);

						extent.fatal("vendorBaseDiscountedAmount==" + vendorBaseDiscountedAmount1 + "FAIL"
								+ vendorBaseDiscountedAmount);

					}
				} catch (Exception e) {
					extent.error(code + e.getMessage());
					Log.error("EXCEPTION DESCRIPTION=====>" + e);

				}

				// calculation of vendor BaseDiscountedAmount

				try {

					if (vendorQuotedDiscount1 == vendorQuotedDiscount) {

						extent.pass("vendorQuotedDiscount==" + vendorQuotedDiscount1 + "pass" + vendorQuotedDiscount);

						result = "PASS";
					} else {
						// System.out.println(BasDisTotalCost1+"FAIL"+BasDisTotalCost);

						extent.fatal("vendorQuotedDiscount==" + vendorQuotedDiscount1 + "FAIL" + vendorQuotedDiscount);

					}
				} catch (Exception e) {
					extent.error(code + e.getMessage());
					Log.error("EXCEPTION DESCRIPTION=====>" + e);

				}

			}
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
			// rs.getScenarios(TSID, Description, Result);
		}

		data.add(result);
		anotherMethod(result, data);
	}

	public void CompareQuotation_AgGrid() throws BiffException, IOException, InterruptedException {
		// //String Result = null;
		try {

			int rowCount = Integer.parseInt(driver
					.findElement(
							By.xpath("//LABEL[@id='PCR-pcr_comparetab-PCR_smgridro_dwn_records_lbl_cnt']/self::LABEL"))
					.getText());

			System.out.println("Row Count : " + rowCount);

			for (int i = 0; i < rowCount; i++) {

				k = 0;

				extent.info(code + "---------------------------->ITEM " + i);

				double RFQQuantity = Double
						.valueOf(driver.findElement(By.xpath("//div[@row-id='" + i + "']//div[@col-id='rfq_qnty']"))
								.getText().replace(",", ""));

				System.out.println(RFQQuantity);

				double QuotedUnitCost = Double.valueOf(
						driver.findElement(By.xpath("//div[@row-id='" + i + "']//div[@col-id='rfq_unit_cost']"))
								.getText().replace(",", ""));

				System.out.println(QuotedUnitCost);

				double QuotedDisUnitCost = Double.valueOf(
						driver.findElement(By.xpath("//div[@row-id='" + i + "']//div[@col-id='qt_rfq_disc_unit_cost']"))
								.getText().replace(",", ""));
				System.out.println(QuotedDisUnitCost);

				double TotalQuotedCost = Double.valueOf(driver
						.findElement(By.xpath("//div[@id='PCR-pcr_comparetab-PCR_smgridro_dwn_tbl']//div[@row-id='" + i
								+ "']//div[@col-id='rfq_cost']"))
						.getText().replace(",", ""));

				double Discount = Double.valueOf(driver
						.findElement(By.xpath("//div[@id='PCR-pcr_comparetab-PCR_smgridro_dwn_tbl']//div[@row-id='" + i
								+ "']//div[@col-id='rfq_disc'] "))
						.getText().replace(",", ""));

				double BaseUnitCost = Double
						.valueOf(driver
								.findElement(
										By.xpath("//div[@id='PCR-pcr_comparetab-PCR_smgridro_dwn_tbl']//div[@row-id='"
												+ i + "']//div[@col-id='rfq_base_unit_cost'] "))
								.getText().replace(",", ""));

				double BaseDisUnitCost = Double
						.valueOf(driver
								.findElement(
										By.xpath("//div[@id='PCR-pcr_comparetab-PCR_smgridro_dwn_tbl']//div[@row-id='"
												+ i + "']//div[@col-id='rfq_base_disc_unit_cost'] "))
								.getText().replace(",", ""));

				double BaseTotalCost = Double
						.valueOf(driver
								.findElement(
										By.xpath("//div[@id='PCR-pcr_comparetab-PCR_smgridro_dwn_tbl']//div[@row-id='"
												+ i + "']//div[@col-id='rfq_base_total_cost'] "))
								.getText().replace(",", ""));
				;

				double BasDisTotalCost = Double
						.valueOf(driver
								.findElement(
										By.xpath("//div[@id='PCR-pcr_comparetab-PCR_smgridro_dwn_tbl']//div[@row-id='"
												+ i + "']//div[@col-id='rfq_base_disc_total_cost'] "))
								.getText().replace(",", ""));

				Exchange = driver
						.findElement(By.xpath("//div[@id='PCR-pcr_comparetab-PCR_smgridro_dwn_tbl']//div[@row-id='" + i
								+ "']//div[@col-id='rfq_curr'] "))
						.getText();

				RateOfExchange test1 = new RateOfExchange();

				double RATE1 = Double.parseDouble(test1.ROE);

				double QuotedDisUnitCost1 = (QuotedUnitCost - ((QuotedUnitCost * Discount) / 100));

				double TotalQuotedCost1 = QuotedUnitCost * RFQQuantity;

				double BaseUnitCost1 = QuotedUnitCost * RATE1;

				double BaseDisUnitCost1 = QuotedDisUnitCost1 * RATE1;

				double BaseTotalCost1 = TotalQuotedCost1 * RATE1;

				double BasDisTotalCost1 = BaseDisUnitCost1 * RFQQuantity;

				vendorBaseAmount1 = vendorBaseAmount1 + BaseTotalCost1;

				vendorBaseDiscountedAmount1 = vendorBaseDiscountedAmount1 + BasDisTotalCost1;

				vendorQuotedCost1 = vendorQuotedCost1 + TotalQuotedCost1;

				vendorQuotedDiscount1 = vendorQuotedDiscount1 + (QuotedDisUnitCost1 * RFQQuantity);

				// calculation for QuotedDisUnitCost

				try {

					if (QuotedDisUnitCost1 == QuotedDisUnitCost) {

						extent.pass("QuotedDisUnitCost==" + QuotedDisUnitCost1 + "pass" + QuotedDisUnitCost);

						result = "PASS";

					} else {
						extent.fatal("QuotedDisUnitCost==" + QuotedDisUnitCost1 + "FAIL" + QuotedDisUnitCost);
						result = "FAIL";
					}

				} catch (Exception e) {

					extent.error(code + e.getMessage());

					Log.error("EXCEPTION DESCRIPTION=====>" + e);

					// rs.getScenarios(TSID, Description, Result);
				}

				// calculation for TotalQuotedCost
				try {
					if (TotalQuotedCost1 == TotalQuotedCost) {

						extent.pass("TotalQuotedCost==" + TotalQuotedCost1 + "pass" + TotalQuotedCost);

						result = "PASS";
					} else {
						extent.fatal("TotalQuotedCost==" + TotalQuotedCost1 + "FAIL" + TotalQuotedCost);
						result = "FAIL";
					}

				} catch (Exception e) {
					extent.error(code + e.getMessage());

					Log.error("EXCEPTION DESCRIPTION=====>" + e);

					// rs.getScenarios(TSID, Description, Result);
				}

				// calculation for BaseUnitCost
				try {
					if (BaseUnitCost1 == BaseUnitCost) {

						extent.pass("BaseUnitCost==" + BaseUnitCost1 + "pass" + BaseUnitCost);

						result = "PASS";
					} else {
						extent.fatal("BaseUnitCost==" + BaseUnitCost1 + "FAIL" + BaseUnitCost);
						result = "FAIL";
					}
				} catch (Exception e) {
					extent.error(code + e.getMessage());

					Log.error("EXCEPTION DESCRIPTION=====>" + e);

				}

				// calculation for BaseDisUnitCost

				try {
					if (BaseDisUnitCost1 == BaseDisUnitCost) {

						extent.pass("BaseDisUnitCost==" + BaseDisUnitCost1 + "pass" + BaseDisUnitCost);

						result = "PASS";
					} else {
						extent.fatal("BaseDisUnitCost==" + BaseDisUnitCost1 + "FAIL" + BaseDisUnitCost);
						result = "FAIL";
					}
				} catch (Exception e) {
					extent.error(code + e.getMessage());

					Log.error("EXCEPTION DESCRIPTION=====>" + e);

					// rs.getScenarios(TSID, Description, Result);
				}

				// calculation for BaseQuotedCost

				try {

					if (BaseTotalCost1 == BaseTotalCost) {

						extent.pass("BaseQuotedCost==" + BaseTotalCost1 + "pass" + BaseTotalCost);

						result = "PASS";
					} else {
						extent.fatal("BaseQuotedCost==" + BaseTotalCost1 + "FAIL" + BaseTotalCost);
						result = "FAIL";
					}
				} catch (Exception e) {
					extent.error(code + e.getMessage());

					Log.error("EXCEPTION DESCRIPTION=====>" + e);

					// rs.getScenarios(TSID, Description, Result);
				}

				// calculation for BasDisTotalCost

				try {

					if (BasDisTotalCost1 == BasDisTotalCost) {

						extent.pass("BasDisTotalCost==" + BasDisTotalCost1 + "pass" + BasDisTotalCost);

						result = "PASS";
					} else {
						// System.out.println(BasDisTotalCost1+"FAIL"+BasDisTotalCost);

						extent.fatal("BasDisTotalCost==" + BasDisTotalCost1 + "FAIL" + BasDisTotalCost);
						result = "FAIL";
					}
				} catch (Exception e) {
					extent.error(code + e.getMessage());
					Log.error("EXCEPTION DESCRIPTION=====>" + e);

					// rs.getScenarios(TSID, Description, Result);
				}

			}
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
			// rs.getScenarios(TSID, Description, Result);
		}

		try {

			for (int p = 0; p < 1; p++) {

				extent.info(code + "---------------------------->VENDOR " + p);

				double vendorBaseAmount = Double.valueOf(
						driver.findElement(By.xpath("//div[@id='PCR-pcr_comparetab-PCR_smgridro_tbl']//div[@row-id='"
								+ p + "']//div[@col-id='base_rfq_cost'] ")).getText().replace(",", ""));

				// double vendorBaseAmount6 = Double.valueOf("43,500.00");

				System.out.println("Column Count : " + vendorBaseAmount);
				// System.out.println(vendorBaseAmount);

				double vendorBaseDiscountedAmount = Double.valueOf(
						driver.findElement(By.xpath("//div[@id='PCR-pcr_comparetab-PCR_smgridro_tbl']//div[@row-id='"
								+ p + "']//div[@col-id='full_base_disc_cost'] ")).getText().replace(",", ""));
				// System.out.println(vendorBaseDiscountedAmount);

				double vendorQuotedCost = Double.valueOf(
						driver.findElement(By.xpath("//div[@id='PCR-pcr_comparetab-PCR_smgridro_tbl']//div[@row-id='"
								+ p + "']//div[@col-id='rfq_cost'] ")).getText().replace(",", ""));
				// System.out.println(vendorQuotedCost);

				double vendorQuotedDiscount = Double.valueOf(
						driver.findElement(By.xpath("//div[@id='PCR-pcr_comparetab-PCR_smgridro_tbl']//div[@row-id='"
								+ p + "']//div[@col-id='full_qut_disc_cost']")).getText().replace(",", ""));

				// System.out.println(vendorQuotedDiscount);

				// calculation of vendor vendorBaseAmount
				try {

					if (vendorBaseAmount1 == vendorBaseAmount) {
						extent = report.createTest("Check Vendor base amount calculation for Vendor " + p);

						extent.pass("vendorBaseAmount==" + vendorBaseAmount1 + "pass" + vendorBaseAmount);

						result = "PASS";
					} else {
						// System.out.println(BasDisTotalCost1+"FAIL"+BasDisTotalCost);

						extent.fatal("BasDisTotalCost==" + vendorBaseAmount1 + "FAIL" + vendorBaseAmount);
						result = "FAIL";
					}
				} catch (Exception e) {
					extent.error(code + e.getMessage());
					Log.error("EXCEPTION DESCRIPTION=====>" + e);
				}

				// calculation of vendor BaseDiscountedAmount

				try {

					if (vendorQuotedCost1 == vendorQuotedCost) {
						extent = report.createTest("Check Vendor base Quoted Cost calculation for Vendor " + p);

						extent.pass("vendorQuotedCost==" + vendorQuotedCost1 + "pass" + vendorQuotedCost);

						result = "PASS";
					} else {
						// System.out.println(BasDisTotalCost1+"FAIL"+BasDisTotalCost);

						extent.fatal("vendorQuotedCost==" + vendorQuotedCost1 + "FAIL" + vendorQuotedCost);
						result = "FAIL";
					}
				} catch (Exception e) {
					extent.error(code + e.getMessage());
					Log.error("EXCEPTION DESCRIPTION=====>" + e);

				}

				// calculation of vendor BaseDiscountedAmount

				try {

					if (vendorBaseDiscountedAmount1 == vendorBaseDiscountedAmount) {
						extent = report.createTest("Check Vendor Discounted amount calculation for Vendor " + p);

						extent.pass("vendorBaseDiscountedAmount==" + vendorBaseDiscountedAmount1 + "pass"
								+ vendorBaseDiscountedAmount);

						result = "PASS";
					} else {
						// System.out.println(BasDisTotalCost1+"FAIL"+BasDisTotalCost);

						extent.fatal("vendorBaseDiscountedAmount==" + vendorBaseDiscountedAmount1 + "FAIL"
								+ vendorBaseDiscountedAmount);
						result = "FAIL";

					}
				} catch (Exception e) {
					extent.error(code + e.getMessage());
					Log.error("EXCEPTION DESCRIPTION=====>" + e);

				}

				// calculation of vendor BaseDiscountedAmount

				try {

					if (vendorQuotedDiscount1 == vendorQuotedDiscount) {
						extent = report.createTest("Check Vendor quoted amount Discounted Cost for Vendor " + p);

						extent.pass("vendorQuotedDiscount==" + vendorQuotedDiscount1 + "pass" + vendorQuotedDiscount);

						result = "PASS";
					} else {
						// System.out.println(BasDisTotalCost1+"FAIL"+BasDisTotalCost);

						extent.fatal("vendorQuotedDiscount==" + vendorQuotedDiscount1 + "FAIL" + vendorQuotedDiscount);
						result = "FAIL";

					}
				} catch (Exception e) {
					extent.error(code + e.getMessage());
					Log.error("EXCEPTION DESCRIPTION=====>" + e);

				}

			}
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
			// rs.getScenarios(TSID, Description, Result);
		}

		data.add(result);
		anotherMethod(result, data);
	}

	public void getoveralldiscount() throws IOException, InterruptedException {
		try {
			// //String Result = null;

			OverallDiscount = Double
					.valueOf(driver.findElement(By.xpath("//INPUT[@id='PFQ-PFQ_ovr_Discount_input']/self::INPUT"))
							.getAttribute("value").replace(",", ""));

			System.out.println("OverallDiscount------------------------>" + OverallDiscount);

			result = "PASS";
			extent.pass(code);

		} catch (StaleElementReferenceException se) {
			extent.pass(code);
			result = "PASS";
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void RFQNETAMOUNT_LINE() throws IOException, InterruptedException {
		try {
			// //String Result = null;

			System.out.println("OverallDiscount" + OverallDiscount);

			driver.findElement(By.xpath("//INPUT[@id='PFQ-PFQ_unitPrice_input']/self::INPUT")).click();

			double RFQUnitprice = Double
					.valueOf(driver.findElement(By.xpath("//INPUT[@id='PFQ-PFQ_unitPrice_input']/self::INPUT"))
							.getAttribute("value").replace(",", ""));

			System.out.println("RFQUnitprice" + RFQUnitprice);

			double RFQQunatity = Double
					.valueOf(driver.findElement(By.xpath("//INPUT[@id='PFQ-PFQ_qty_input']/self::INPUT"))
							.getAttribute("value").replace(",", ""));
			System.out.println("RFQQunatity" + RFQQunatity);

			double RFQDiscount = Double
					.valueOf(driver.findElement(By.xpath("//INPUT[@id='PFQ-PFQ_Discount_input']/self::INPUT"))
							.getAttribute("value").replace(",", ""));
			System.out.println("RFQDiscount" + RFQDiscount);

			double RFQTotalPrice = Double
					.valueOf(driver.findElement(By.xpath("//INPUT[@id='PFQ-PFQ_Price_input']/self::INPUT"))
							.getAttribute("value").replace(",", ""));

			System.out.println("RFQTotalPrice" + RFQTotalPrice);

			double RFQTotalAmt_withutDisc = RFQUnitprice * RFQQunatity;
			System.out.println("RFQTotalAmt_withutDisc" + RFQTotalAmt_withutDisc);

			double RFQ_DiscountAmt = (RFQTotalAmt_withutDisc * RFQDiscount) / 100;

			System.out.println("RFQ_DiscountAmt" + RFQ_DiscountAmt);

			double RFQ_TotalNetamount = RFQTotalAmt_withutDisc - RFQ_DiscountAmt;

			System.out.println("RFQ_TotalNetamount" + RFQ_TotalNetamount);

			double RFQ_OverallDiscount = (RFQ_TotalNetamount * OverallDiscount) / 100;
			System.out.println("RFQ_OverallDiscount" + RFQ_OverallDiscount);

			double RFQ_overallTotalNetamount = RFQ_TotalNetamount - RFQ_OverallDiscount;
			System.out.println("RFQ_overallTotalNetamount" + RFQ_overallTotalNetamount);

			Sum_RFQTotalAmt_withutDisc.add(RFQTotalAmt_withutDisc);

			Sum_RFQ_DiscountAmt.add(RFQ_DiscountAmt + RFQ_OverallDiscount);

			Sum_RFQ_TotalNetamount.add(RFQ_overallTotalNetamount);

			if (RFQTotalPrice == RFQTotalAmt_withutDisc) {

				System.out.println(RFQTotalPrice + "RFQTotalPrice" + RFQTotalAmt_withutDisc);
				result = "PASS";

				extent.pass(code + "_" + "Calculation of Line Item Total Price is correct =" + RFQTotalAmt_withutDisc);

			} else {

				result = "FAIL";
				System.out.println(RFQTotalPrice + "RFQTotalPrice" + RFQTotalAmt_withutDisc);
				extent.fatal(code + "_" + "Correct Value is =" + RFQTotalAmt_withutDisc + "But Found =" + RFQTotalPrice
						+ MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void RFQ_Total_Discount() throws IOException {
		try {

			driver.findElement(By.xpath("//INPUT[@id='PFQ-RFQ_DiscountAmount_input']/self::INPUT")).click();

			double RFQ_Header_DiscAmtScreen = Double
					.valueOf(driver.findElement(By.xpath("//INPUT[@id='PFQ-RFQ_DiscountAmount_input']/self::INPUT"))
							.getAttribute("value").replace(",", ""));

			double RFQ_Header_DiscAmt = 0;
			for (int i = 0; i < Sum_RFQ_DiscountAmt.size(); i++) {

				RFQ_Header_DiscAmt = RFQ_Header_DiscAmt + Sum_RFQ_DiscountAmt.get(i);

				System.out.println("sum of RFQ_Header_DiscAmt" + RFQ_Header_DiscAmt);

			}

			if (RFQ_Header_DiscAmtScreen == RFQ_Header_DiscAmt) {
				System.out.println(RFQ_Header_DiscAmtScreen + "RFQTotalPrice" + RFQ_Header_DiscAmt);
				result = "PASS";

				extent.pass(code + "_" + "Calculation of Line Item Total Price is correct =" + RFQ_Header_DiscAmt);

			} else {
				System.out.println(RFQ_Header_DiscAmtScreen + "RFQTotalPrice" + RFQ_Header_DiscAmt);
				result = "FAIL";

				extent.fatal(code + "_" + "Correct Value is =" + RFQ_Header_DiscAmt + "But Found ="
						+ RFQ_Header_DiscAmtScreen
						+ MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void RFQTotal_Line_Item_Amount() throws IOException {
		try {

			double RFQ_Header_TotalAmtScreen = Double
					.valueOf(driver.findElement(By.xpath("//INPUT[@id='PFQ-RFQ_LineAmount_input']/self::INPUT"))
							.getAttribute("value").replace(",", ""));

			double RFQ_Header_TotalAmt = 0;
			for (int i = 0; i < Sum_RFQTotalAmt_withutDisc.size(); i++) {

				RFQ_Header_TotalAmt = RFQ_Header_TotalAmt + Sum_RFQTotalAmt_withutDisc.get(i);
				System.out.println("sum of RFQ_Header_TotalAmt" + RFQ_Header_TotalAmt);

			}

			if (RFQ_Header_TotalAmtScreen == RFQ_Header_TotalAmt) {
				System.out.println(RFQ_Header_TotalAmtScreen + "RFQTotalPrice" + RFQ_Header_TotalAmt);
				result = "PASS";

				extent.pass(code + "_" + "Calculation of Line Item Total Price is correct =" + RFQ_Header_TotalAmt);

			} else {
				System.out.println(RFQ_Header_TotalAmtScreen + "RFQTotalPrice" + RFQ_Header_TotalAmt);
				result = "FAIL";

				extent.fatal(code + "_" + "Correct Value is =" + RFQ_Header_TotalAmt + "But Found ="
						+ RFQ_Header_TotalAmtScreen
						+ MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void RFQTotal_Amount_After_Discountt() throws IOException {
		try {

			double RFQ_Header_TotalAmtScreen_AfterDisc = Double
					.valueOf(driver.findElement(By.xpath("//INPUT[@id='PFQ-RFQ_GrossAmount_input']/self::INPUT"))
							.getAttribute("value").replace(",", ""));
			System.out.println("RFQ_Header_TotalAmtScreen_AfterDisc" + RFQ_Header_TotalAmtScreen_AfterDisc);

			RFQ_Header_TotalAmt_AfterDisc = 0;
			for (int i = 0; i < Sum_RFQ_TotalNetamount.size(); i++) {

				RFQ_Header_TotalAmt_AfterDisc = RFQ_Header_TotalAmt_AfterDisc + Sum_RFQ_TotalNetamount.get(i);

				System.out.println("sum of RFQ_Header_TotalAmt_AfterDisc" + RFQ_Header_TotalAmt_AfterDisc);

			}

			if (RFQ_Header_TotalAmtScreen_AfterDisc == RFQ_Header_TotalAmt_AfterDisc) {
				System.out
						.println(RFQ_Header_TotalAmtScreen_AfterDisc + "RFQTotalPrice" + RFQ_Header_TotalAmt_AfterDisc);
				result = "PASS";

				extent.pass(code + "_" + "Calculation of Line Item Total Price is correct ="
						+ RFQ_Header_TotalAmt_AfterDisc);

			} else {
				System.out
						.println(RFQ_Header_TotalAmtScreen_AfterDisc + "RFQTotalPrice" + RFQ_Header_TotalAmt_AfterDisc);
				result = "FAIL";

				extent.fatal(code + "_" + "Correct Value is =" + RFQ_Header_TotalAmt_AfterDisc + "But Found ="
						+ RFQ_Header_TotalAmtScreen_AfterDisc
						+ MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void RFQ_AdditionalCharge() throws IOException {
		try {

			for (int i = 0; i < 2; i++) {

				String Category = driver
						.findElement(By.xpath("//div[@id='PFQ-chargeDetailId']//tr[@data-ri='" + i + "']//td[5]"))
						.getText();

				System.out.println(Category + "Category-----------------------------------Category");

				if (Category.equalsIgnoreCase("Amount")) {

					String Invalue = driver
							.findElement(
									By.xpath("//div[@id='PFQ-chargeDetailId']//tr[@data-ri='" + i + "']//td[6]/span"))
							.getText();
					String Amount1 = driver
							.findElement(
									By.xpath("//div[@id='PFQ-chargeDetailId']//tr[@data-ri='" + i + "']//td[7]/span"))
							.getText();

					System.out.println(Invalue + "Invalue" + Amount1);

					RFQ_Header_Additional_Charge = Double.valueOf((Amount1).replace(",", ""));

					System.out.println("RFQ_Header_Additional_Charge" + RFQ_Header_Additional_Charge);

					if (Invalue.equalsIgnoreCase(Amount1)) {

						System.out.println(Invalue + "Invalue   equal to Am" + Amount1);

						result = "PASS";

						extent.pass(code + "_" + "Additioanal charge =" + Amount1);

					} else {
						System.out.println(Invalue + "Invalue  Not qual to Am" + Amount1);
						result = "FAIL";

						extent.fatal(code + "_" + "Correct Value is =" + Invalue + "But Found =" + Amount1
								+ MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

						result = "<a href=" + ScreenShot() + "> FAIL</a>";

					}

				} else {

					String Invaluescreen = driver
							.findElement(
									By.xpath("//div[@id='PFQ-chargeDetailId']//tr[@data-ri='" + i + "']//td[6]/span"))
							.getText();

					double Invaluescreen1 = Double.valueOf((Invaluescreen).replace(",", ""));

					System.out.println(Invaluescreen1 + "Invaluescreen1");

					double Amountscreen = Double.valueOf((driver
							.findElement(
									By.xpath("//div[@id='PFQ-chargeDetailId']//tr[@data-ri='" + i + "']//td[7]/span"))
							.getText()).replace(",", ""));

					System.out.println(RFQ_Header_TotalAmt_AfterDisc + "RFQ_Header_TotalAmt_AfterDisc");
					System.out.println(Invaluescreen1 + "Invaluescreen1");

					RFQ_Header_NetAmount = RFQ_Header_TotalAmt_AfterDisc + RFQ_Header_Additional_Charge;
					System.out.println(RFQ_Header_Additional_Charge + "RFQ_Header_Additional_Charge");

					RFQ_Header_Tax = (RFQ_Header_NetAmount * Invaluescreen1) / 100;

					System.out.println(RFQ_Header_Tax + "RFQ_Header_Tax");

					if (RFQ_Header_Tax == Amountscreen) {

						System.out.println(RFQ_Header_Tax + "RFQ_Header_Tax equal to Amountscreen" + Amountscreen);

						result = "PASS";

						extent.pass(code + "_" + "Additioanal charge =" + RFQ_Header_Tax);

					} else {

						System.out.println(RFQ_Header_Tax + "RFQ_Header_Tax Not equal to Amountscreen" + Amountscreen);

						result = "FAIL";

						extent.fatal(code + "_" + "Correct Value is =" + RFQ_Header_Tax + "But Found =" + Amountscreen
								+ MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

						result = "<a href=" + ScreenShot() + "> FAIL</a>";

					}

				}

			}

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void RFQ_Header_AdditionalCharge() throws IOException {
		try {

			double RFQ_Header_AdditionalChrge_Screen = Double
					.valueOf(driver.findElement(By.xpath("//INPUT[@id='PFQ-RFQ_FrieghtAmount_input']/self::INPUT"))
							.getAttribute("value").replace(",", ""));

			System.out.println("RFQ_Header_AdditionalCharge:" + RFQ_Header_AdditionalChrge_Screen);

			if (RFQ_Header_AdditionalChrge_Screen == RFQ_Header_Additional_Charge) {
				System.out.println(RFQ_Header_AdditionalChrge_Screen + "RFQ_Header_Additional_Charge"
						+ RFQ_Header_Additional_Charge);
				result = "PASS";

				extent.pass(code + "_" + "Calculation of RFQ_Header_Additional_Charge correct ="
						+ RFQ_Header_Additional_Charge);

			} else {
				System.out.println(RFQ_Header_AdditionalChrge_Screen + "RFQ_Header_Additional_Charge"
						+ RFQ_Header_Additional_Charge);
				result = "FAIL";

				extent.fatal(code + "_" + "Correct Value is =" + RFQ_Header_Additional_Charge + "But Found ="
						+ RFQ_Header_AdditionalChrge_Screen
						+ MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void RFQ_Header_NetAmount() throws IOException {
		try {

			double RFQ_Header_NetAmount_Screen = Double
					.valueOf(driver.findElement(By.xpath("//INPUT[@id='PFQ-RFQ_netAmountbfr_input']/self::INPUT"))
							.getAttribute("value").replace(",", ""));

			System.out.println("RFQ_Header_NetAmount_Screen:" + RFQ_Header_NetAmount_Screen);

			if (RFQ_Header_NetAmount_Screen == RFQ_Header_NetAmount) {
				System.out.println(RFQ_Header_NetAmount_Screen + "RFQ_Header_NetAmount" + RFQ_Header_NetAmount);
				result = "PASS";

				extent.pass(
						code + "_" + "Calculation of RFQ_Header_Additional_Charge correct =" + RFQ_Header_NetAmount);

			} else {
				System.out.println(RFQ_Header_NetAmount_Screen + "RFQ_Header_NetAmount" + RFQ_Header_NetAmount);
				result = "FAIL";

				extent.fatal(code + "_" + "Correct Value is =" + RFQ_Header_NetAmount + "But Found ="
						+ RFQ_Header_NetAmount_Screen
						+ MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void RFQ_Header_TaxAmount() throws IOException {
		try {

			double RFQ_Header_TaxAmount_Screen = Double
					.valueOf(driver.findElement(By.xpath("//INPUT[@id='PFQ-RFQ_taxAmount_input']/self::INPUT"))
							.getAttribute("value").replace(",", ""));

			System.out.println("RFQ_Header_TaxAmount_Screen:" + RFQ_Header_TaxAmount_Screen);

			if (RFQ_Header_TaxAmount_Screen == RFQ_Header_Tax) {
				System.out.println(RFQ_Header_TaxAmount_Screen + "RFQ_Header_Tax" + RFQ_Header_Tax);
				result = "PASS";

				extent.pass(code + "_" + "Calculation of RFQ_Header_Tax correct =" + RFQ_Header_Tax);

			} else {
				System.out.println(RFQ_Header_TaxAmount_Screen + "RFQ_Header_Tax" + RFQ_Header_Tax);
				result = "FAIL";

				extent.fatal(
						code + "_" + "Correct Value is =" + RFQ_Header_Tax + "But Found =" + RFQ_Header_TaxAmount_Screen
								+ MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void RFQ_Header_QuotedAmount() throws IOException {
		try {

			double RFQ_Header_QuotedAmount_Screen = Double
					.valueOf(driver.findElement(By.xpath("//INPUT[@id='PFQ-RFQ_NetAmount_input']/self::INPUT"))
							.getAttribute("value").replace(",", ""));

			System.out.println("RFQ_Header_TaxAmount_Screen:" + RFQ_Header_QuotedAmount_Screen);

			RFQ_Header_QuotedAmount = RFQ_Header_NetAmount + RFQ_Header_Tax;

			if (RFQ_Header_QuotedAmount_Screen == RFQ_Header_QuotedAmount) {
				System.out
						.println(RFQ_Header_QuotedAmount_Screen + "RFQ_Header_QuotedAmount" + RFQ_Header_QuotedAmount);
				result = "PASS";

				extent.pass(code + "_" + "Calculation of RFQ_Header_QuotedAmount correct =" + RFQ_Header_QuotedAmount);

			} else {
				System.out
						.println(RFQ_Header_QuotedAmount_Screen + "RFQ_Header_QuotedAmount" + RFQ_Header_QuotedAmount);
				result = "FAIL";

				extent.fatal(code + "_" + "Correct Value is =" + RFQ_Header_QuotedAmount + "But Found ="
						+ RFQ_Header_QuotedAmount_Screen
						+ MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void CreateFileRenameExisting(String text) throws IOException, InterruptedException {
		try {

			File file = new File("C:\\Users\\pushpakumari.d\\Downloads\\" + text + " (1).xlsx");
			File newFile = new File("C:\\Users\\pushpakumari.d\\Downloads\\" + text + "(1).xls");

			if (file.renameTo(newFile)) {
				extent.pass(code + "second file rename success");
				;
				result = "PASS";

			} else {
				result = "FAIL";
				extent.error("second File rename failed");
			}

		} catch (Exception e) {
			extent.fail("rename" + e.getMessage());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);

		}

		data.add(result);
		anotherMethod(result, data);
	}

	public void Thread() throws IOException {
		try {
			Thread.sleep(100000);
			extent.pass(code);
			result = "PASS";

			// extent.pass(code);
		} catch (Exception e) {
			// extent.fail(code + e.getMessage(),
			// MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void newtab(String text) throws IOException {
		try {
			int window = Integer.parseInt(text);

			// Store all currently open tabs in tabs
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

			// Switch newly open Tab
			driver.switchTo().window(tabs.get(window));

			// Close newly open tab after performing some operations.

			extent.pass(code);
			result = "PASS";

			// extent.pass(code);
		} catch (Exception e) {
			// extent.fail(code + e.getMessage(),
			// MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void vendorDragDrop(String locatorType, String value) throws IOException, InterruptedException {
		try {
			// //String Result = null;
			By locator;
			locator = locatorValue(locatorType, value);

			// WebElement element = WaitUtil.fluentWait(locator);

			// Element which needs to drag.
			WebElement From = WaitUtil.fluentWait(locator);

			// Element on which need to drop.
			WebElement To = driver.findElement(By.xpath("//DIV[@id='PRO-destArea']/self::DIV"));

			// Using Action class for drag and drop.
			Actions act = new Actions(driver);

			// Dragged and dropped.
			act.dragAndDrop(From, To).build().perform();
			result = "PASS";
			extent.pass(code);

		} catch (StaleElementReferenceException se) {
			extent.pass(code);
			result = "PASS";
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void compareSiteReq(String locatorType, String value, String text) throws IOException, InterruptedException {
		// //String Result = null;
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			// WebElement element =
			// driver.findElement(By.id("DMS_SubmitOLPanelform-DMS_cmbDocType_items"));
			Envronment1 = text;

			System.out.println(Envronment1);

			// staging//Testing

			siterequestedFor obj = new siterequestedFor();

			List<String> exp = new ArrayList<String>();

			exp.addAll(obj.getList());
			System.out.println(obj.getList());

			// to catch all web elements into list
			List<WebElement> options = element.findElements(By.xpath(value));

			// myList contains all the web elements
			// if you want to get all elements text into array list
			/*
			 * List<String> all_elements_text = new ArrayList<>();
			 * 
			 * for (int i = 0; i < options.size(); i++) {
			 * 
			 * // loading text of each element in to array all_elements_text
			 * all_elements_text.add(options.get(i).getText());
			 * 
			 * // to print directly // System.out.println(options.get(i).getText());
			 * 
			 * }
			 */

			int screen = options.size();
			int database = exp.size();

			// System.out.println(all_elements_text);

			if (screen == database) {

				extent.pass("Site requested for in screen ==" + screen

						+ " ship active in vessel master / location master in db" + database);

				result = "PASS";

			} else {
				extent.fail("Site requested for in screen Not ==" + screen

						+ " ship active in vessel master / location master in db" + database);
				result = "fail";

			}

			for (int i = 0; i < options.size(); i++) {

				if (options.get(i).getText().equalsIgnoreCase(exp.get(i))) {

					extent.pass("Site requested for in screen ==+" + options.get(i).getText()

							+ " ship active in vessel master / location master in db" + exp.get(i));

					result = "PASS";

				} else {
					extent.pass("Site requested for in screen ==+" + options.get(i).getText()

							+ " ship active in vessel master / location master in db" + exp.get(i));
					result = "fail";

				}

			}

			Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);

			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void activeRecord_SQL(String locatorType, String value, String text)
			throws IOException, InterruptedException {
		// //String Result = null;
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			String ar[] = text.split("/");

			Envronment = ar[1];

			ActiveRecordQuery = ar[0];
			ACTIVESQL obj = new ACTIVESQL();
			List<String> exp = new ArrayList<String>();
			exp.addAll(obj.getList());
			// System.out.println(obj.getList());

			// to catch all web elements into list
			List<WebElement> options = element.findElements(By.xpath(value));

			// myList contains all the web elements
			// if you want to get all elements text into array list
			List<String> all_elements_text = new ArrayList<>();

			for (int i = 0; i < options.size(); i++) {

				// loading text of each element in to array all_elements_text
				all_elements_text.add(options.get(i).getText());

				// to print directly
				// System.out.println("dropdown value"+options.get(i).getText());

			}

			// System.out.println(all_elements_text);

			int k = 0;

			for (int i = 0; i < exp.size(); i++) {

				k++;

				if (((exp.get(i)).replaceAll("\\s", "")).contains(all_elements_text.get(k).replaceAll("\\s", ""))) {

					extent.pass(all_elements_text.get(k).replaceAll("\\s", "") + " is active  "
							+ exp.get(i).replaceAll("\\s", ""));
					result = "PASS";

				} else {
					extent.fail(all_elements_text.get(k).replaceAll("\\s", "") + "is inactive "
							+ exp.get(i).replaceAll("\\s", ""));
					result = "fail";
					i--;
				}
			}

			Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);

			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void YellowcOLOR(String locatorType, String value) throws IOException {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			// System.out.println("attribute"+element.getAttribute("class"));

			if (element.getAttribute("class").contains(
					"ag-cell ag-cell-not-inline-editing ag-cell-with-height ag-cell-no-focus sm-bg-yellow ag-cell-value")) {

				System.out.println("yellow color");
				extent.pass(code + "Item marked as Yellow Color");
				result = "PASS";

			} else {

				System.out.println("not yellow");
				extent.fail(code + "not in yellow color",
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}
		} catch (Exception e) {
			extent.error(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("some Exception found here=>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void GetValue(String locatorType, String value) throws IOException {
		try {

			// storing value in input field and using for file export

			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			// System.out.println("attribute"+element.getAttribute("class"));

			Input = element.getText();
			if (Input != null) {

				String info = element.getText();

				System.out.println(info);

				extent.info(info);
				result = "PASS";
				extent.pass(code);

			} else {

				String info = element.getText();

				System.out.println(info);

				extent.info(info);

				extent.fail(code, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}

		} catch (TimeoutException e) {
			extent.fail(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("some Exception found here=>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		} catch (Exception e) {
			extent.error(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("some Exception found here=>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void RequisitionField() throws BiffException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		try {
			// Requisition Field = new Requisition();

			result = "PASS";
			extent.pass(code);

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
			// rs.getScenarios(TSID, Description, Result);
		}

		data.add(result);
		anotherMethod(result, data);
	}

	public void scenario(String text) throws IOException, InterruptedException {
		try {
			// //String Result = null;

			extent.info(text);

			extent.pass(code);

			result = "PASS";

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void Date(String text) throws IOException {
		try {

			driver.findElement(
					By.xpath("//td[not(contains(@class,'ui-state-default ui-state-hover'))]/a[text()=" + text + "]"))
					.click();
			;

			result = "PASS";
			extent.pass(code);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void Timeline1(String locatorType, String value, String text) throws IOException {
		try {

			String seq[] = text.split("-");

			By locator;
			locator = locatorValue(locatorType, value);
			// WebElement element = WaitUtil.fluentWait(locator);

			SimpleDateFormat gmtDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			gmtDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

			// Current Date Time in GMT

			String date1 = gmtDateFormat.format(new Date());

			System.out.println("Current Date and Time in GMT time zone: " + date1);

			List<WebElement> loginDetail = driver
					.findElements((By.xpath("//*[@id=\"nfr_layoutwrapper\"]/div[3]/div[2]/ul/li[1]/a[2]/ul/li")));

			String loginUsername = loginDetail.get(0).getText();

			// String loginDesig =loginDetail.get(1).getText();

			// System.out.println(formattedDate+","+loginUsername);

			Thread.sleep(3000);
			WebElement Status = driver.findElement(locator);

			String WorkflowStatus = Status.getText();

			// System.out.println("1111111111"+WorkflowStatus);

			String Timeline1 = ("Approved" + " " + "," + " " + date1 + " " + "by" + " " + loginUsername);

			Lifecylce.add(Timeline1);

			System.out.println("Approved selenium-----" + Timeline1);

			String Timeline2 = (WorkflowStatus + " " + "," + " " + date1 + " " + "by" + " " + loginUsername);

			Lifecylce.add(Timeline2);

			System.out.println("Stageclosed selenium-----" + Timeline2);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			Thread.sleep(2000);

			driver.findElement(By.xpath("//A[contains(@id,'-aa')]")).click();

			String Timeline_Screen3 = driver.findElement(By.xpath("(//LI[@class='ui-datalist-item'])[" + seq[0] + "]"))
					.getText();

			System.out.println("Approved screen-----" + Timeline_Screen3);

			String ar11[] = Timeline_Screen3.split("by");
			String timestatus1 = ar11[0];
			String user1 = ar11[1];

			String ar21[] = user1.split(" ");
			String firstname1 = ar21[1];

			String Timeline_Screen = timestatus1 + " " + "by" + " " + firstname1;

			System.out.println("Approved screen-----" + Timeline_Screen);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			String Timeline_Screen2 = driver.findElement(By.xpath("(//LI[@class='ui-datalist-item'])[" + seq[1] + "]"))
					.getText();

			String ar1[] = Timeline_Screen2.split("by");
			String timestatus = ar1[0];

			System.out.println("Approved timestatus-----" + timestatus);
			String user = ar1[1];

			System.out.println("Approved user-----" + user);

			String ar2[] = user.split(" ");
			String firstname = ar2[1];
			System.out.println("Approved screenfirstname-----" + firstname);

			String Timeline_Screen1 = timestatus + " " + "by" + " " + firstname;

			System.out.println("Approved screen-----" + Timeline_Screen1);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			result = "PASS";
			extent.pass(code);

			if (Timeline1.contentEquals(Timeline_Screen)) {

				extent.pass(Timeline1 + "pass------>" + Timeline_Screen);

				result = "PASS";
			} else {
				// System.out.println(BasDisTotalCost1+"FAIL"+BasDisTotalCost);

				extent.fail(Timeline1 + "Fail------>" + Timeline_Screen,
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			if (Timeline2.contentEquals(Timeline_Screen1)) {

				extent.pass(Timeline2 + "pass------>" + Timeline_Screen1);

				result = "PASS";
			} else {
				// System.out.println(BasDisTotalCost1+"FAIL"+BasDisTotalCost);

				extent.fail(Timeline2 + "Fail------>" + Timeline_Screen1,
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
		} catch (TimeoutException e) {

			extent.fail(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("No Element Found to perform click" + e);
			result = "FAIL";

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void Timeline(String locatorType, String value, String text) throws IOException {
		try {

			String seq[] = text.split("-");

			By locator;
			locator = locatorValue(locatorType, value);
			// WebElement element = WaitUtil.fluentWait(locator);

			SimpleDateFormat gmtDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			gmtDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

			// Current Date Time in GMT

			String date1 = gmtDateFormat.format(new Date());

			System.out.println("Current Date and Time in GMT time zone: " + date1);

			List<WebElement> loginDetail = driver
					.findElements((By.xpath("//*[@id=\"nfr_layoutwrapper\"]/div[3]/div[2]/ul/li[1]/a[2]/ul/li")));

			String loginUsername = loginDetail.get(0).getText();

			// String loginDesig =loginDetail.get(1).getText();

			// System.out.println(formattedDate+","+loginUsername);

			Thread.sleep(3000);
			WebElement Status = driver.findElement(locator);

			String WorkflowStatus = Status.getText();

			if (WorkflowStatus.equalsIgnoreCase("DRAFT")) {

				String Timeline2 = (WorkflowStatus);

				Lifecylce.add(Timeline2);

				System.out.println("Stageclosed selenium-----" + Timeline2);
				////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				Thread.sleep(2000);

				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("javascript:window.scrollBy(0,-450)");

				driver.findElement(By.xpath("//A[contains(@id,'-aa')]")).click();

				String Timeline_Screen3 = driver
						.findElement(By.xpath("(//LI[@class='ui-datalist-item'])[" + seq[0] + "]")).getText();

				System.out.println("Approved screen-----" + Timeline_Screen3);

				String ar11[] = Timeline_Screen3.split(",");
				String timestatus1 = ar11[0];

				// String Timeline_Screen = timestatus1 + " " + "by" + " " + firstname1;

				String Timeline_Screen = timestatus1;

				System.out.println("Approved screen-----" + Timeline_Screen);
				////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				String Timeline_Screen2 = driver
						.findElement(By.xpath("(//LI[@class='ui-datalist-item'])[" + seq[1] + "]")).getText();

				String ar1[] = Timeline_Screen2.split(",");
				String timestatus = ar1[0];

				System.out.println("Approved timestatus-----" + timestatus);

				String Timeline_Screen1 = timestatus;

				System.out.println("Approved screen-----" + Timeline_Screen1);
				////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

				////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// if (Timeline2.startsWith(Timeline_Screen1)) {

				if (Timeline2.replaceAll("\\s+", "").contains(Timeline_Screen1.replaceAll("\\s+", ""))) {

					extent.pass(Timeline2 + "pass------>" + Timeline_Screen1);

					result = "PASS";
				} else {
					// System.out.println(BasDisTotalCost1+"FAIL"+BasDisTotalCost);

					extent.fail(Timeline2 + "Fail------>" + Timeline_Screen1,
							MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
					result = "<a href=" + ScreenShot() + "> FAIL</a>";

				}

			}

			if (WorkflowStatus.equalsIgnoreCase("REVIWED")) {

				String Timeline2 = (WorkflowStatus);

				Lifecylce.add(Timeline2);

				System.out.println("Stageclosed selenium-----" + Timeline2);
				////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				Thread.sleep(2000);

				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("javascript:window.scrollBy(0,-450)");

				driver.findElement(By.xpath("//A[contains(@id,'-aa')]")).click();

				String Timeline_Screen3 = driver
						.findElement(By.xpath("(//LI[@class='ui-datalist-item'])[" + seq[0] + "]")).getText();

				System.out.println("Approved screen-----" + Timeline_Screen3);

				String ar11[] = Timeline_Screen3.split(",");
				String timestatus1 = ar11[0];

				// String Timeline_Screen = timestatus1 + " " + "by" + " " + firstname1;

				String Timeline_Screen = timestatus1;

				System.out.println("Approved screen-----" + Timeline_Screen);
				////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				String Timeline_Screen2 = driver
						.findElement(By.xpath("(//LI[@class='ui-datalist-item'])[" + seq[1] + "]")).getText();

				String ar1[] = Timeline_Screen2.split(",");
				String timestatus = ar1[0];

				System.out.println("Approved timestatus-----" + timestatus);

				String Timeline_Screen1 = timestatus;

				System.out.println("Approved screen-----" + Timeline_Screen1);
				////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

				////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// if (Timeline2.startsWith(Timeline_Screen1)) {

				if (Timeline2.replaceAll("\\s+", "").contains(Timeline_Screen1.replaceAll("\\s+", ""))) {

					extent.pass(Timeline2 + "pass------>" + Timeline_Screen1);

					result = "PASS";
				} else {
					// System.out.println(BasDisTotalCost1+"FAIL"+BasDisTotalCost);

					extent.fail(Timeline2 + "Fail------>" + Timeline_Screen1,
							MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
					result = "<a href=" + ScreenShot() + "> FAIL</a>";

				}

			}

			else {

				// System.out.println("1111111111"+WorkflowStatus);

				String Timeline1 = ("Approved");

				Lifecylce.add(Timeline1);

				System.out.println("Approved selenium-----" + Timeline1);

				String Timeline2 = (WorkflowStatus);

				Lifecylce.add(Timeline2);

				System.out.println("Stageclosed selenium-----" + Timeline2);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				Thread.sleep(2000);

				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("javascript:window.scrollBy(0,-450)");

				driver.findElement(By.xpath("//A[contains(@id,'-aa')]")).click();

				String Timeline_Screen3 = driver
						.findElement(By.xpath("(//LI[@class='ui-datalist-item'])[" + seq[0] + "]")).getText();

				System.out.println("Approved screen-----" + Timeline_Screen3);

				String ar11[] = Timeline_Screen3.split(",");
				String timestatus1 = ar11[0];

				// String Timeline_Screen = timestatus1 + " " + "by" + " " + firstname1;

				String Timeline_Screen = timestatus1;

				System.out.println("Approved screen-----" + Timeline_Screen);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				String Timeline_Screen2 = driver
						.findElement(By.xpath("(//LI[@class='ui-datalist-item'])[" + seq[1] + "]")).getText();

				String ar1[] = Timeline_Screen2.split(",");
				String timestatus = ar1[0];

				System.out.println("Approved timestatus-----" + timestatus);

				String Timeline_Screen1 = timestatus;

				System.out.println("Approved screen-----" + Timeline_Screen1);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

				result = "PASS";
				extent.pass(code);

				// if (Timeline1.equalsIgnoreCase(Timeline_Screen)) {

				if (Timeline1.replaceAll("\\s+", "").contains(Timeline_Screen.replaceAll("\\s+", ""))) {

					extent.pass(Timeline1 + "pass------>" + Timeline_Screen);

					result = "PASS";
				} else {
					// System.out.println(BasDisTotalCost1+"FAIL"+BasDisTotalCost);

					extent.fail(Timeline1 + "Fail------>" + Timeline_Screen,
							MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
					result = "<a href=" + ScreenShot() + "> FAIL</a>";

				}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// if (Timeline2.startsWith(Timeline_Screen1)) {

				if (Timeline2.replaceAll("\\s+", "").contains(Timeline_Screen1.replaceAll("\\s+", ""))) {

					extent.pass(Timeline2 + "pass------>" + Timeline_Screen1);

					result = "PASS";
				} else {
					// System.out.println(BasDisTotalCost1+"FAIL"+BasDisTotalCost);

					extent.fail(Timeline2 + "Fail------>" + Timeline_Screen1,
							MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
					result = "<a href=" + ScreenShot() + "> FAIL</a>";

				}

			}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
		} catch (TimeoutException e) {

			extent.fail(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("No Element Found to perform click" + e);
			result = "FAIL";

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void Timeline_Draft(String locatorType, String value, String text) throws IOException {
		try {

			By locator;
			locator = locatorValue(locatorType, value);
			// WebElement element = WaitUtil.fluentWait(locator);
			Thread.sleep(3000);
			WebElement Status = driver.findElement(locator);

			String WorkflowStatus = Status.getText();
			if (WorkflowStatus.equalsIgnoreCase("DRAFT")) {

				System.out.println("WorkflowStatus WorkflowStatus-----" + WorkflowStatus);

				SimpleDateFormat gmtDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				gmtDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

				// Current Date Time in GMT

				String date1 = gmtDateFormat.format(new Date());

				System.out.println("Current Date and Time in GMT time zone: " + date1);

				List<WebElement> loginDetail = driver
						.findElements((By.xpath("//*[@id=\"nfr_layoutwrapper\"]/div[3]/div[2]/ul/li[1]/a[2]/ul/li")));

				String loginUsername = loginDetail.get(0).getText();

				// String loginDesig =loginDetail.get(1).getText();

				// System.out.println(formattedDate+","+loginUsername);

				// System.out.println("1111111111"+WorkflowStatus);

				String Timeline2 = (WorkflowStatus + " " + "," + " " + date1 + " " + "by" + " " + loginUsername);

				Lifecylce.add(Timeline2);

				System.out.println("Stageclosed selenium-----" + Timeline2);

				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("javascript:window.scrollBy(0,-450)");

				driver.findElement(By.xpath("//A[contains(@id,'-aa')]")).click();

				Thread.sleep(2000);

				String Timeline_Screen11 = driver
						.findElement(By.xpath("(//LI[@class='ui-datalist-item'])[" + text + "]")).getText();

				String ar1[] = Timeline_Screen11.split("by");
				String timestatus = ar1[0];

				System.out.println("Approved timestatus-----" + timestatus);
				String user = ar1[1];

				System.out.println("Approved user-----" + user);

				String ar2[] = user.split(" ");
				String firstname = ar2[1];
				System.out.println("Approved screenfirstname-----" + firstname);

				String Timeline_Screen1 = timestatus + " " + "by" + " " + firstname;

				System.out.println("Approved screen-----" + Timeline_Screen1);

				System.out.println("Approved screen-----" + Timeline_Screen1);

				result = "PASS";
				extent.pass(code);

				if (Timeline2.contentEquals(Timeline_Screen1)) {

					extent.pass(Timeline2 + "pass------>" + Timeline_Screen1);

					result = "PASS";
				} else {
					// System.out.println(BasDisTotalCost1+"FAIL"+BasDisTotalCost);

					extent.fail(Timeline2 + "Fail------>" + Timeline_Screen1,
							MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
					result = "<a href=" + ScreenShot() + "> FAIL</a>";

				}
			}

			else {

				System.out.println("WorkflowStatus WorkflowStatus-----" + WorkflowStatus);
				extent.fail(code + "Work Flow Status not in Draft"
						+ MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				Log.error("EXCEPTION DESCRIPTION=====>" + code);
				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}
		} catch (TimeoutException e) {

			extent.fail(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("No Element Found to perform click" + e);
			result = "FAIL";

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void Timeline_Export(String locatorType, String value, String text) throws IOException {
		try {

			By locator;
			locator = locatorValue(locatorType, value);
			// WebElement element = WaitUtil.fluentWait(locator);
			Thread.sleep(3000);
			WebElement Status = driver.findElement(locator);

			String WorkflowStatus = Status.getText();
			if (WorkflowStatus.equalsIgnoreCase("RFQ Exported")) {

				System.out.println("WorkflowStatus WorkflowStatus-----" + WorkflowStatus);

				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:MM");
				dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));

				Date date = new Date();

				String date1 = dateFormat.format(date);

				List<WebElement> loginDetail = driver
						.findElements((By.xpath("//*[@id=\"nfr_layoutwrapper\"]/div[3]/div[2]/ul/li[1]/a[2]/ul/li")));

				String loginUsername = loginDetail.get(0).getText();

				// String loginDesig =loginDetail.get(1).getText();

				// System.out.println(formattedDate+","+loginUsername);

				// System.out.println("1111111111"+WorkflowStatus);

				String Timeline2 = (WorkflowStatus + "," + " " + date1 + " " + "by" + " " + loginUsername);

				Lifecylce.add(Timeline2);

				System.out.println("Stageclosed selenium-----" + Timeline2);

				driver.findElement(By.xpath("//A[contains(@id,'-aa')]")).click();

				Thread.sleep(2000);

				String Timeline_Screen1 = driver
						.findElement(By.xpath("(//LI[@class='ui-datalist-item'])[" + text + "]")).getText();

				System.out.println("Approved screen-----" + Timeline_Screen1);

				result = "PASS";
				extent.pass(code);

				if (Timeline2.equalsIgnoreCase(Timeline_Screen1)) {

					extent.pass(Timeline2 + "pass------>" + Timeline_Screen1);

					result = "PASS";
				} else {
					// System.out.println(BasDisTotalCost1+"FAIL"+BasDisTotalCost);

					extent.fail(Timeline2 + "Fail------>" + Timeline_Screen1,
							MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
					result = "<a href=" + ScreenShot() + "> FAIL</a>";

				}
			}

			else {

				System.out.println("WorkflowStatus WorkflowStatus-----" + WorkflowStatus);
				extent.fail(code + "Work Flow Status not in Draft"
						+ MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				Log.error("EXCEPTION DESCRIPTION=====>" + code);
				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}
		} catch (TimeoutException e) {

			extent.fail(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("No Element Found to perform click" + e);
			result = "FAIL";

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void Timeline_Received(String text) throws IOException {
		try {

			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:MM");
			dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));

			Date date = new Date();

			String date1 = dateFormat.format(date);

			List<WebElement> loginDetail = driver
					.findElements((By.xpath("//*[@id=\"nfr_layoutwrapper\"]/div[3]/div[2]/ul/li[1]/a[2]/ul/li")));

			String loginUsername = loginDetail.get(0).getText();

			// String loginDesig =loginDetail.get(1).getText();

			// System.out.println(formattedDate+","+loginUsername);

			// System.out.println("1111111111"+WorkflowStatus);

			String Timeline2 = ("Quote Received From the Supplier" + "," + " " + date1 + " " + "by" + " "
					+ loginUsername);

			Lifecylce.add(Timeline2);

			System.out.println("Stageclosed selenium-----" + Timeline2);

			driver.findElement(By.xpath("//A[contains(@id,'-aa')]")).click();

			Thread.sleep(2000);

			String Timeline_Screen1 = driver.findElement(By.xpath("(//LI[@class='ui-datalist-item'])[" + text + "]"))
					.getText();

			System.out.println("Approved screen-----" + Timeline_Screen1);

			result = "PASS";
			extent.pass(code);

			if (Timeline2.contains(Timeline_Screen1)) {

				extent.pass(Timeline2 + "pass------>" + Timeline_Screen1);

				result = "PASS";
			} else {
				// System.out.println(BasDisTotalCost1+"FAIL"+BasDisTotalCost);

				extent.fail(Timeline2 + "Fail------>" + Timeline_Screen1,
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void Overall_Lifecycle() throws IOException {
		try {

			int i = 0;

			for (int j = 1; j < Lifecylce.size() - 1; j++) {

				String Lifecycle1 = Lifecylce.get(i);
				System.out.println(Lifecycle1);

				String Timeline_Screen = driver.findElement(By.xpath("(//LI[@class='ui-datalist-item'])[" + j + "]"))
						.getText();

				System.out.println(Timeline_Screen);

				if (Lifecycle1.equalsIgnoreCase(Timeline_Screen)) {

					System.out.println(Lifecycle1 + "PASS_Timeline_Screen_" + Timeline_Screen);

					extent.pass(Lifecycle1 + "pass------Timeline_Screen:>" + Timeline_Screen);

					result = "PASS";

				} else {

					System.out.println(Lifecycle1 + "FAIL_Timeline_Screen_" + Timeline_Screen);

					extent.fail(Lifecycle1 + "Fail------>Timeline_Screen" + Timeline_Screen,
							MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
					result = "<a href=" + ScreenShot() + "> FAIL</a>";
				}

				i++;

			}

		} catch (Exception e) {
			extent.error(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("some Exception found here=>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void Current_Status(String locatorType, String value, String text) throws IOException {
		try {

			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			// ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
			// element);

			// System.out.println("attribute"+element.getAttribute("class"));

			String GatCurrentStatus = element.getText();

			System.out.println("GatCurrentStatus" + GatCurrentStatus);

			String getStatus = text;

			System.out.println("getStatus" + getStatus);

			if (getStatus.equalsIgnoreCase(GatCurrentStatus.replace(",", ""))) {

				extent.pass(code + "  " + getStatus + "pass------>" + GatCurrentStatus);

				result = "PASS" + "" + "Actual Result" + getStatus + " " + "Equal To Expected Result" + " "
						+ GatCurrentStatus;
			} else {
				// System.out.println(BasDisTotalCost1+"FAIL"+BasDisTotalCost);

				extent.fail(code + "  " + getStatus + "Fail------>" + GatCurrentStatus,
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>" + "" + "Actual Result" + getStatus + " "
						+ " Not Equal To Expected Result" + " " + GatCurrentStatus;

			}

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void getCurrent_User(String locatorType, String value) throws IOException {
		try {

			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			String UserName = driver.findElement(By.xpath("(//UL[@class='user_name']//li)[1]")).getText();

			String UserName1 = element.getAttribute("value");
			if (UserName.equals(UserName1)) {

				System.out.println("mandatory field");

				extent.pass(code + "    " + "Expected Result:Field should be Current user Name:" + UserName + " "
						+ "Actual Result : Current user Name is" + UserName1);
				result = "PASS";

			}

			else {

				extent.fail(
						"Expected Result:Field should be Current user Name:" + UserName + ""
								+ "Actual Result : Current user Name is" + UserName1 + code,
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>" + code + "    "
						+ "Expected Result:Field should be Current user Name:" + "  " + UserName + " "
						+ "Actual Result : Current user Name is" + UserName1;
			}

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void get_Attribute_Value(String locatorType, String value, String text) throws IOException {
		try {

			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			// System.out.println("attribute"+element.getAttribute("class"));

			String GatCurrentStatus = element.getAttribute("value");

			System.out.println("GatCurrentStatus" + GatCurrentStatus);

			String getStatus = text;

			System.out.println("getStatus" + getStatus);

			if (getStatus.equalsIgnoreCase(GatCurrentStatus.replace(",", ""))) {

				extent.pass(code + "  " + getStatus + "pass------>" + GatCurrentStatus);

				result = "PASS" + " " + "Actual Result" + getStatus + "" + "Equal To Expected Result" + " "
						+ GatCurrentStatus;
			} else {
				// System.out.println(BasDisTotalCost1+"FAIL"+BasDisTotalCost);

				extent.fail(code + "  " + getStatus + "Fail------>" + GatCurrentStatus,
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>" + " " + "Actual Result" + getStatus + ""
						+ "Not Equal To Expected Result" + " " + GatCurrentStatus;

			}

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void Get_PO_NetAmount(String locatorType, String value, String text) throws IOException {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			// System.out.println("attribute"+element.getAttribute("class"));

			String PoNetAmount1 = element.getAttribute("value");
			System.out.println(PoNetAmount1); // 79,900.0000

			// double valuetest =(double)(PoNetAmount1);

			if (PoNetAmount1.equalsIgnoreCase(text)) {
				result = "PASS";
				extent.pass(PoNetAmount1 + "equal ------->" + text);

			} else {
				result = "fail";
				extent.fail(PoNetAmount1 + "equal ------->" + text);
			}

		} catch (Exception e) {
			extent.error(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("some Exception found here=>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void tracker(String locatorType, String value, String text) throws IOException {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			String TrackeRcount = element.getText();

			String ar[] = text.split("/");
			String sqlQuery = ar[0];
			String env = ar[1];

			// Getting employee name by Id
			String Sqlvalue = SQL.executeSQLQuery(env, sqlQuery);

			if (TrackeRcount.equalsIgnoreCase(Sqlvalue)) {
				result = "PASS";
				extent.pass(code + "*********VALUE IN SCREEN:" + TrackeRcount + "Equal :" + "VALUE IN DATABASE:"
						+ Sqlvalue);

			} else {
				result = "fail";
				extent.fatal(code + "*********VALUE IN SCREEN:" + TrackeRcount + " Not Equal :" + "VALUE IN DATABASE:"
						+ Sqlvalue);

			}

		} catch (Exception e) {
			extent.error(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("some Exception found here=>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
			result = "fail";

		}
		data.add(result);

		anotherMethod(result, data);

	}

	public void DBtesting(String locatorType, String value, String text) throws IOException {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);

			// System.out.println("attribute"+element.getAttribute("class"));

			String Fieldlength1 = element.getAttribute("maxlength");
			System.out.println(Fieldlength1);

			String ar[] = text.split("/");
			String columnname = ar[0];
			String env = ar[1];

			String selectquery = Query + "'" + columnname + "';";

			System.out.println(selectquery);

			// While loop to iterate through all data and print results

			String Sqlvalue = SQL.executeSQLQuery(env, selectquery);

			System.out.println(Sqlvalue);
			int databasefield = Integer.parseInt(Sqlvalue);
			int screenfield = Integer.parseInt(Fieldlength1);
			if (databasefield >= screenfield) {
				// System.out.println("pass");
				result = "PASS" + "____database FieldLength: " + databasefield + "equal/lessthan ------->"
						+ "Screen Field limit:" + screenfield;
				extent.pass(code + "____database FieldLength: " + databasefield + "equal/lessthan ------->"
						+ "Screen Field limit:" + screenfield);
			} else {
				result = "fail" + "____database FieldLength: " + databasefield + "NOT equal/greater than ------->"
						+ "Screen Field limit:" + screenfield;
				extent.fail(code + "____database FieldLength: " + databasefield + "Not equal/greaterthan ------->"
						+ "Screen Field limit:" + screenfield);

			}

		} catch (Exception e) {
			extent.error(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("some Exception found here=>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
			result = "fail";

		}
		data.add(result);

		anotherMethod(result, data);

	}

	public void SqltableName(String text) throws IOException {
		try {

			Query = "select CHARACTER_MAXIMUM_LENGTH from information_schema.COLUMNS where TABLE_FAILME ='" + text
					+ "' and COLUMN_FAILME =";
			// System.out.println(Query);
			result = "PASS";
			extent.pass(code);

		} catch (Exception e) {
			extent.error(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("some Exception found here=>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
			result = "fail";
		}
		data.add(result);

		anotherMethod(result, data);

	}

	public void SqltableNameDecimal(String text) throws IOException {
		try {

			Query = "select NUMERIC_PRECISION from information_schema.COLUMNS where TABLE_FAILME ='" + text
					+ "' and COLUMN_FAILME =";
			// System.out.println(Query);
			result = "PASS";
			extent.pass(code);

		} catch (Exception e) {
			extent.error(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("some Exception found here=>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);

		anotherMethod(result, data);

	}

	public void CounterDetail() throws IOException {
		// //String Result = null;
		try {

			String CounterStartupdate1 = driver
					.findElement(By.xpath("//INPUT[@id='PJC-PJC_data1-1-PJC_button_input']/self::INPUT"))
					.getAttribute("value");
			System.out.println(CounterStartupdate1);
			CounterStartupdate = new SimpleDateFormat("dd/MM/yyyy").parse(CounterStartupdate1);

			System.out.println(CounterStartupdate);

			extent.pass("CounterStartupupdate :" + CounterStartupdate1);

			String CounterStartValue1 = driver
					.findElement(By.xpath("//INPUT[@id='PJC-PJC_data1-1-PJC_countervalue']/self::INPUT"))
					.getAttribute("value");
			System.out.println(CounterStartValue);

			CounterStartValue = Integer.parseInt(CounterStartValue1);
			System.out.println(CounterStartValue);

			extent.pass("CounterStartValue :" + CounterStartValue);

			String StartUpAverage1 = driver
					.findElement(By.xpath("//INPUT[@id='PJC-PJC_data1-1-PJC_initalavg_input']/self::INPUT"))
					.getAttribute("value");

			StartUpAverage = Double.parseDouble(StartUpAverage1);

			System.out.println(StartUpAverage);

			extent.pass("StartUpAverage :" + StartUpAverage1);

			String EntryToCalculate1 = driver
					.findElement(By.xpath("//INPUT[@id='PJC-PJC_data1-1-PJC_readingavg_input']/self::INPUT"))
					.getAttribute("value");
			EntryToCalculate = Integer.parseInt(EntryToCalculate1);
			System.out.println(EntryToCalculate);

			extent.pass("EntryToCalculateRunningAverage :" + EntryToCalculate);
			extent.pass(code);

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void performcounterupdate(int text, int Date) throws IOException {
		// //String Result = null;
		try {

			int countervalue1 = oldvalue + text;

			String countervalue = Integer.toString(countervalue1);

			int day = dateold + Date;

			String updateddate = Integer.toString(day);

			updateddate = updateddate + "/1/2020";

			Keywords obj = new Keywords();

			obj.enterText("xpath", "//INPUT[@id='PJC-PJC_counterreading']/self::INPUT", countervalue);

			Thread.sleep(1000);

			obj.datePicker("xpath", "(//SPAN[@class='ui-button-icon-left ui-icon ui-icon-calendar'])[1]", updateddate);
			Thread.sleep(1000);
			driver.findElement(
					By.xpath("(//SPAN[@class='ui-button-text ui-c'][text()='Save'][text()='Save']/self::SPAN)[2]"))
					.click();
			Thread.sleep(2000);

			oldvalue = countervalue1;
			dateold = day;

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void CounterHistoryCheck() throws IOException {

		Date intialCounterupdate;
		double intialCounterValu;
		double RunningAverage, CummalativeAverage;
		List<Double> RunningAveragelist = new ArrayList<>();
		List<Double> CummalativeAveragelist = new ArrayList<>();

		try {

			driver.findElement(By.xpath("//div[@col-id='dateupdatedate']")).click();
			Thread.sleep(1000);

			String intialCounterupdate1 = driver
					.findElement(By.xpath("//div[@row-index='0']//div[@col-id='dateupdatedate']")).getText();
			// System.out.println(Counterupdate1);
			intialCounterupdate = new SimpleDateFormat("dd/MM/yyyy").parse(intialCounterupdate1);

			String intialCounterValue1 = driver
					.findElement(By.xpath("//div[@row-index='0']//div[@col-id='countervalue']")).getText();
			intialCounterValu = Double.parseDouble(intialCounterValue1);
			// System.out.println("----------------------->Counter
			// value------------"+intialCounterValu);

			for (int i = 0; i <= 8; i++) {

				extent.info(
						"********************************************************************************************");

				String Counterupdate1 = driver
						.findElement(By.xpath("//div[@row-index='" + i + "']//div[@col-id='dateupdatedate']"))
						.getText();
				// System.out.println(Counterupdate1);
				Counterupdate = new SimpleDateFormat("dd/MM/yyyy").parse(Counterupdate1);

				String CounterValue1 = driver
						.findElement(By.xpath("//div[@row-index='" + i + "']//div[@col-id='countervalue']")).getText();
				CounterValue = Double.parseDouble(CounterValue1);
				// System.out.println("----------------------->Counter
				// value------------"+CounterValue);

				// Difference between Current and Previous Value date

				if (i == 0) {

					double RunningAverage3 = StartUpAverage;

					RunningAverage = Math.round(RunningAverage3 * 100.0) / 100.0;

					RunningAveragelist.add(RunningAverage);

					System.out.println("RunningAverage" + RunningAverage);

					extent.pass("Entry--------->" + i + "Running average" + RunningAverage);
					double CummalativeAverage3 = 0;

					CummalativeAverage = Math.round(CummalativeAverage3 * 100.0) / 100.0;
					System.out.println("------------------CummalativeAverage" + CummalativeAverage);
					extent.pass("Entry--------->" + i + "CummalativeAverage :" + CummalativeAverage);
					CummalativeAveragelist.add(CummalativeAverage);

					Thread.sleep(1000);

				} else {
					long DiffDate = Counterupdate.getTime() - Counterupdatold.getTime();

					int diffDays = (int) (DiffDate / (24 * 60 * 60 * 1000));
					// System.out.println("difference between days: " +
					// diffDays);

					double DiffValue = CounterValue - CounterValueold;

					// System.out.println("DiffValue"+DiffValue);

					double RunningAverage3 = DiffValue / diffDays;

					RunningAverage = Math.round(RunningAverage3 * 100.0) / 100.0;

					System.out.println("-------------RunningAverage" + RunningAverage);
					extent.pass("Entry--------->" + i + "RunningAverage :" + RunningAverage);
					RunningAveragelist.add(RunningAverage);

					long Differencedate_Cum = Counterupdate.getTime() - intialCounterupdate.getTime();
					int diffDays_cum = (int) (Differencedate_Cum / (24 * 60 * 60 * 1000));
					// System.out.println("difference between days Cummalative : "
					// + diffDays_cum);

					double DiffValue_Cumm = CounterValue - intialCounterValu;

					// System.out.println("------------------DiffValue_Cumm"+DiffValue_Cumm);

					double CummalativeAverage3 = DiffValue_Cumm / diffDays_cum;

					CummalativeAverage = Math.round(CummalativeAverage3 * 100.0) / 100.0;

					System.out.println("------------------CummalativeAverage" + CummalativeAverage);
					CummalativeAveragelist.add(CummalativeAverage);
					extent.pass("Entry--------->" + i + "CummalativeAverage :" + CummalativeAverage);
					// ///////////////////}

					Thread.sleep(1000);

				}
				Counterupdatold = Counterupdate;
				CounterValueold = CounterValue;
				Thread.sleep(1000);
				driver.findElement(
						By.xpath("//A[@href='#PJC-PJC_data1-1-PCM_tab2-1'][text()='Counter History']/self::A")).click();
				Thread.sleep(1000);

				// fgggggggggggggggggggggggggggggggggggggggggggggggg
				extent.info(
						"********************************************************************************************");
			}

			// System.out.println(Counterupdate1);

			extent.pass(code);

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void CounterHistory() throws IOException {

		Date intialCounterupdate;
		double intialCounterValu;
		double RunningAverage, CummalativeAverage;
		List<Double> RunningAveragelist = new ArrayList<>();
		List<Double> CummalativeAveragelist = new ArrayList<>();

		try {

			driver.findElement(By.xpath("//div[@col-id='dateupdatedate']")).click();
			Thread.sleep(1000);

			String intialCounterupdate1 = driver
					.findElement(By.xpath("//div[@row-index='0']//div[@col-id='dateupdatedate']")).getText();
			// System.out.println(Counterupdate1);
			intialCounterupdate = new SimpleDateFormat("dd/MM/yyyy").parse(intialCounterupdate1);

			String intialCounterValue1 = driver
					.findElement(By.xpath("//div[@row-index='0']//div[@col-id='countervalue']")).getText();
			intialCounterValu = Double.parseDouble(intialCounterValue1);
			// System.out.println("----------------------->Counter
			// value------------"+intialCounterValu);

			for (int i = 0; i <= 8; i++) {

				extent.info(
						"********************************************************************************************");
				Keywords obj = new Keywords();
				int text = 20;
				int Date = 1;
				obj.performcounterupdate(text, Date);
				Thread.sleep(2000);

				String Counterupdate1 = driver
						.findElement(By.xpath("//div[@row-index='" + i + "']//div[@col-id='dateupdatedate']"))
						.getText();
				// System.out.println(Counterupdate1);
				Counterupdate = new SimpleDateFormat("dd/MM/yyyy").parse(Counterupdate1);

				String CounterValue1 = driver
						.findElement(By.xpath("//div[@row-index='" + i + "']//div[@col-id='countervalue']")).getText();
				CounterValue = Double.parseDouble(CounterValue1);
				// System.out.println("----------------------->Counter
				// value------------"+CounterValue);

				// Difference between Current and Previous Value date

				if (i == 0) {

					double RunningAverage3 = StartUpAverage;

					RunningAverage = Math.round(RunningAverage3 * 100.0) / 100.0;

					RunningAveragelist.add(RunningAverage);

					System.out.println("RunningAverage" + RunningAverage);

					extent.pass("Entry--------->" + i + "Running average" + RunningAverage);
					double CummalativeAverage3 = 0;

					CummalativeAverage = Math.round(CummalativeAverage3 * 100.0) / 100.0;
					System.out.println("------------------CummalativeAverage" + CummalativeAverage);
					extent.pass("Entry--------->" + i + "CummalativeAverage :" + CummalativeAverage);
					CummalativeAveragelist.add(CummalativeAverage);

					Thread.sleep(1000);

					driver.findElement(
							By.xpath("//A[@href='#PJC-PJC_data1-1-PCM_tab4-1'][text()='Maintenance']/self::A")).click();

					Thread.sleep(1000);

					String JobFreq1 = driver.findElement(By.xpath("//div[@row-index='0']//div[@col-id='jobfrequency']"))
							.getText();
					String ar[] = JobFreq1.split(" ");

					String JobFreq2 = ar[0];

					double JobFreq = Double.parseDouble(JobFreq2);
					System.out.println("JobFreq----------" + JobFreq);
					extent.pass("Entry--------->" + i + "JobFreq :" + JobFreq);

					double JobRunningHour = 0;

					System.out.println("JobRunningHour----------" + JobRunningHour);
					extent.pass("Entry--------->" + i + "JobRunningHour :" + JobRunningHour);
					double RemainingHour = JobFreq - JobRunningHour;

					System.out.println("RemainingHour----------" + RemainingHour);
					extent.pass("Entry--------->" + i + "RemainingHour :" + RemainingHour);

				} else {
					long DiffDate = Counterupdate.getTime() - Counterupdatold.getTime();

					int diffDays = (int) (DiffDate / (24 * 60 * 60 * 1000));
					// System.out.println("difference between days: " +
					// diffDays);

					double DiffValue = CounterValue - CounterValueold;

					// System.out.println("DiffValue"+DiffValue);

					double RunningAverage3 = DiffValue / diffDays;

					RunningAverage = Math.round(RunningAverage3 * 100.0) / 100.0;

					System.out.println("-------------RunningAverage" + RunningAverage);
					extent.pass("Entry--------->" + i + "RunningAverage :" + RunningAverage);
					RunningAveragelist.add(RunningAverage);

					long Differencedate_Cum = Counterupdate.getTime() - intialCounterupdate.getTime();
					int diffDays_cum = (int) (Differencedate_Cum / (24 * 60 * 60 * 1000));
					// System.out.println("difference between days Cummalative : "
					// + diffDays_cum);

					double DiffValue_Cumm = CounterValue - intialCounterValu;

					// System.out.println("------------------DiffValue_Cumm"+DiffValue_Cumm);

					double CummalativeAverage3 = DiffValue_Cumm / diffDays_cum;

					CummalativeAverage = Math.round(CummalativeAverage3 * 100.0) / 100.0;

					System.out.println("------------------CummalativeAverage" + CummalativeAverage);
					CummalativeAveragelist.add(CummalativeAverage);
					extent.pass("Entry--------->" + i + "CummalativeAverage :" + CummalativeAverage);
					// ///////////////////}

					Thread.sleep(1000);

					driver.findElement(
							By.xpath("//A[@href='#PJC-PJC_data1-1-PCM_tab4-1'][text()='Maintenance']/self::A")).click();

					Thread.sleep(1000);
					String JobFreq1 = driver.findElement(By.xpath("//div[@row-index='0']//div[@col-id='jobfrequency']"))
							.getText();
					String ar[] = JobFreq1.split(" ");

					String JobFreq2 = ar[0];

					double JobFreq = Double.parseDouble(JobFreq2);
					System.out.println("JobFreq----------" + JobFreq);
					extent.pass("Entry--------->" + i + "JobFreq :" + JobFreq);

					double JobRunningHour = CounterValue - CounterStartValue;

					System.out.println("JobRunningHour----------" + JobRunningHour);
					extent.pass("Entry--------->" + i + "JobRunningHour :" + JobRunningHour);
					double RemainingHour = JobFreq - JobRunningHour;

					System.out.println("RemainingHour----------" + RemainingHour);
					extent.pass("Entry--------->" + i + "RemainingHour :" + RemainingHour);
					if (i < 3) {

						Last4Entry = RunningAverage;
						// System.out.println("Last4Entry----------" +
						// Last4Entry);

						if (CummalativeAverage > Last4Entry) {
							double DuedayCalc = CummalativeAverage;
							System.out.println("DuedayCalc----------" + DuedayCalc);

							double dayFreq = RemainingHour / DuedayCalc;

							dayFreq = Math.round(dayFreq);

							System.out.println("dayFreq----------" + dayFreq);

							SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

							// increment current date by 7 days
							// Date date = new Date();
							// System.out.println("Current Date: "+
							// formatter.format(Counterupdate));

							// use `Calendar` to add days
							Calendar c = Calendar.getInstance();
							c.setTime(Counterupdate);
							c.add(Calendar.DATE, (int) dayFreq);

							String Edd = formatter.format(c.getTime());
							// print date after increment
							System.out.println("Date after Increment: " + Edd);
							extent.pass("Entry--------->" + i + "Edd :" + Edd);

							// date = date

						} else {
							double DuedayCalc = RunningAverage;
							System.out.println("DuedayCalc----------" + DuedayCalc);

							double dayFreq = RemainingHour / DuedayCalc;
							dayFreq = Math.round(dayFreq);

							System.out.println("dayFreq----------" + dayFreq);

							SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

							// increment current date by 7 days
							// Date date = new Date();
							// System.out.println("Current Date: "+
							// formatter.format(Counterupdate));

							// use `Calendar` to add days
							Calendar c = Calendar.getInstance();
							c.setTime(Counterupdate);
							c.add(Calendar.DATE, (int) dayFreq);

							String Edd = formatter.format(c.getTime());
							// print date after increment
							System.out.println("Date after Increment: " + Edd);
							extent.pass("Entry--------->" + i + "Edd :" + Edd);

						}

					} else {

						// System.out.println("----------------------------------------4
						// entry-----------------------------");
						int p = RunningAveragelist.size();
						double Last4Entry2 = 0;
						for (int j = 0; j <= 3; j++) {

							// System.out.println("print p-------------" + p);

							// System.out.println("RunningAveragelist.size();"+
							// RunningAveragelist.get(p - 1));

							Last4Entry = RunningAveragelist.get(p - 1) + Last4Entry2;

							System.out.println("Last4Entry:" + Last4Entry);

							Last4Entry2 = Last4Entry;
							p--;

						}
						double Last4EntryAvg = Last4Entry2 / 4;

						System.out.println("Last4EntryAvg:" + Last4EntryAvg);

						if (CummalativeAverage > Last4EntryAvg) {

							System.out.println(Last4EntryAvg + "less last entry" + CummalativeAverage);
							double DuedayCalc = CummalativeAverage;
							System.out.println("DuedayCalc----------" + DuedayCalc);

							double dayFreq = RemainingHour / DuedayCalc;

							dayFreq = Math.round(dayFreq);

							System.out.println("dayFreq----------" + dayFreq);

							SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

							// increment current date by 7 days
							// Date date = new Date();
							// System.out.println("Current Date: "+
							// formatter.format(Counterupdate));

							// use `Calendar` to add days
							Calendar c = Calendar.getInstance();
							c.setTime(Counterupdate);
							c.add(Calendar.DATE, (int) dayFreq);

							String Edd = formatter.format(c.getTime());
							// print date after increment
							System.out.println("Date after Increment: " + Edd);
							extent.pass("Entry--------->" + i + "Edd :" + Edd);

							// date = date

						} else {
							System.out.println(Last4EntryAvg + "greater last entry" + CummalativeAverage);
							System.out.println("less last entry");
							double DuedayCalc = Last4EntryAvg;
							System.out.println("DuedayCalc----------" + DuedayCalc);

							double dayFreq = RemainingHour / DuedayCalc;
							dayFreq = Math.round(dayFreq);
							System.out.println("dayFreq----------" + dayFreq);

							SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

							// increment current date by 7 days
							// Date date = new Date();
							// System.out.println("Current Date: "+
							// formatter.format(Counterupdate));

							// use `Calendar` to add days
							Calendar c = Calendar.getInstance();
							c.setTime(Counterupdate);
							c.add(Calendar.DATE, (int) dayFreq);

							String Edd = formatter.format(c.getTime());
							// print date after increment
							System.out.println("Date after Increment: " + Edd);
							extent.pass("Entry--------->" + i + "Edd :" + Edd);

						}

					}
				}

				Counterupdatold = Counterupdate;
				CounterValueold = CounterValue;
				Thread.sleep(1000);
				driver.findElement(
						By.xpath("//A[@href='#PJC-PJC_data1-1-PCM_tab2-1'][text()='Counter History']/self::A")).click();
				Thread.sleep(1000);

				// fgggggggggggggggggggggggggggggggggggggggggggggggg
				extent.info(
						"********************************************************************************************");
			}

			// System.out.println(Counterupdate1);

			extent.pass(code);
			driver.close();

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void HeaderOrder() throws IOException, InterruptedException {
		// //String Result = null;
		try {

			List<WebElement> elements = driver.findElements(By.xpath("//SPAN[@ref='eText']"));
			System.out.println("Number of elements:" + elements.size());

			ArrayList<String> columnname = new ArrayList<String>();
			columnname.add("Action");
			columnname.add("Purchase Transaction No.");
			columnname.add("Company Name");
			columnname.add("Fleet Name");
			columnname.add("Vessel Name");
			columnname.add("Vessel Type");
			columnname.add("Flag");

			for (int i = 0; i < columnname.size(); i++) {

				System.out.println("form column:" + elements.get(i).getText());
				String Formvalue = elements.get(i).getText();

				if (columnname.contains(elements.get(i).getText())) {
					extent.pass("Column prsent in landing page :" + Formvalue);
				} else {
					extent.fail("Column not prsent in landing page :" + Formvalue);
				}

			}
			driver.close();

		} catch (Exception e) {

			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			System.out.print("Element not found" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void CompareHeaderfieldwithForm() throws IOException, InterruptedException {
		// //String Result = null;
		try {

			driver.findElement(By.xpath("//SPAN[@class='ag-icon ag-icon-columns']")).click();
			Thread.sleep(3000);
			List<WebElement> elementsLandingpage = driver
					.findElements(By.xpath("//SPAN[@class='ag-column-tool-panel-column-label']"));
			System.out.println("Number of elements:" + elementsLandingpage.size());

			ArrayList<String> columnnamelandingpage = new ArrayList<String>();
			ArrayList<String> fieldnameform = new ArrayList<String>();

			for (int i = 0; i < elementsLandingpage.size(); i++) {

				System.out.println("landing column:" + elementsLandingpage.get(i).getText());

				String landing = elementsLandingpage.get(i).getText();
				columnnamelandingpage.add(landing);

			}
			driver.findElement(By.xpath("//SPAN[text()='New']/self::SPAN")).click();
			Thread.sleep(8000);

			List<WebElement> elementsForm = driver.findElements(By.xpath("//label[@class='ui-outputlabel ui-widget']"));

			for (int j = 0; j < elementsForm.size(); j++) {

				System.out.println("form column:" + elementsForm.get(j).getText());

				String Form = elementsForm.get(j).getText();

				fieldnameform.add(Form);

			}

			for (int e = 0; e < columnnamelandingpage.size(); e++) {

				if (fieldnameform.contains(columnnamelandingpage.get(e))) {

					int index = fieldnameform.indexOf(columnnamelandingpage.get(e));

					extent.pass(fieldnameform.get(index) + "Matching value :" + columnnamelandingpage.get(e));
				} else {

					int index = fieldnameform.indexOf(columnnamelandingpage.get(e));
					try {
						extent.info(fieldnameform.get(index) + "NOT Matching value :" + columnnamelandingpage.get(e));
					} catch (Exception h) {

						extent.info("Landing Page Column----->" + columnnamelandingpage.get(e));
					}
				}

			}
			driver.close();

		} catch (Exception e) {

			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			System.out.print("Element not found" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);

	}
	// Check Asteric should be used for all Mandatory fields

	public void mandatoryField(String locatorType, String value) throws IOException {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);
			String Symbol = element.getText();
			System.out.println(Symbol);
			if (Symbol.equals("*")) {

				System.out.println("mandatory field");

				extent.pass(code + "    " + "Expected Result:Field should have astriesk Mark" + ""
						+ "Actual Result : Astriesk Mark Found");
				result = "PASS";

			}

			else {

				extent.fail(
						"Expected Result:Field should have astriesk Mark" + ""
								+ "Actual Result : Astriesk Mark Not Found" + code,
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>" + code + "    "
						+ "Expected Result:Field should have astriesk Mark" + ""
						+ "Actual Result : Astriesk Mark Not Found";
			}
			driver.close();

		} catch (Exception e) {

			extent.fail(code + e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("some Exception found here=>" + e);

			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

	// Check this option allows the user to open the form in an Edit Mode

	public void EditIcon(String locatorType, String value) throws IOException, InterruptedException {
		// //String Result = null;
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);
			element.isEnabled();
			extent.pass("Edit button Enable");
			result = "PASS";
			driver.close();
			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(" button not Enable" + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	// Check this option allows the user to open the form in a View Mode

	public void ViewIcon(String locatorType, String value) throws IOException, InterruptedException {
		// //String Result = null;
		try {

			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);
			element.click();
			Thread.sleep(8000);
			driver.findElement(By.xpath("//button[contains(@id,'-btnTblNew')]")).isEnabled();
			driver.findElement(By.xpath("//button[contains(@id,'-btnTblDelete')]")).isEnabled();
			driver.findElement(By.xpath("//button[contains(@id,'-btnTblEdit')]")).isEnabled();
			driver.findElement(By.xpath("//button[contains(@id,'-btnTblDefaultSearch')]")).isEnabled();
			extent.pass("View button Enable");
			result = "PASS";
			driver.close();

			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(" button not Enable" + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	// when EDIT icon clicked;- In form save,edit,search ,cancel button should be
	// enable

	public void Edit(String locatorType, String value) throws IOException, InterruptedException {
		// //String Result = null;
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);
			element.click();
			Thread.sleep(8000);
			driver.findElement(By.xpath("//button[contains(@id,'-btnsave')]")).isEnabled();
			driver.findElement(By.xpath("//button[contains(@id,'-btnTblCancel')]")).isEnabled();
			driver.findElement(By.xpath("//button[contains(@id,'-btnTblDelete')]")).isEnabled();
			extent.pass(" button Enable");
			result = "PASS";
			driver.close();

			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(" button not Enable" + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}
	// Check this option list the user to open the editable forms based on his write
	// access.For forms My Actions should be configured under widget.

	public void MyAction_LandingPage() throws IOException, InterruptedException {
		// //String Result = null;
		// driver.findElement(By.xpath("//i[@class='fa fa-chevron-down
		// arrw_Pnt']")).click();
		// Thread.sleep(1000);
		boolean present;
		try {
			driver.findElement(By.xpath("//i[@c" + "lass='fa fa-chevron-down arrw_Pnt']")).click();
			driver.findElement(By.xpath("//a[@id='myactionfilterSymbl']"));
			present = true;

			extent.pass("My Action button Present");
			result = "PASS";
			driver.close();

			// Thread.sleep(2000);
		} catch (Exception e) {
			present = false;
			extent.fail(" My Action button not Present" + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	// Check while mouse hovering, user can view the full text

	public void Landingpage_Mousehover(String locatorType, String value) throws IOException, InterruptedException {
		// //String Result = null;
		try {

			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);
			Actions actions = new Actions(driver);
			Robot robot = new Robot();
			Thread.sleep(5000);
			actions.moveToElement(element);
			actions.moveToElement(element, dateold, TotalItemCount);
			WebElement toolTipElement = driver.findElement(By.xpath("" + element).cssSelector(".ui-tooltip"));

			String toolTipText = toolTipElement.getText();
			if (toolTipText != "null") {
				extent.pass(" Mousehover working");
				result = "PASS";
			} else {
				extent.fail(" Mousehover not working",
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}
			// Thread.sleep(2000);
			driver.close();

		} catch (Exception e) {
			extent.fail(" code" + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	// Ref.Id, Company Name, Fleet Name, Vessel Name, Vessel Type, Flag and form
	// related columns.

	public void LandingpageHeader_order() throws IOException, InterruptedException {
		// //String Result = null;

		try {
			driver.findElement(By.xpath(
					"//div[@class='ag-header-row']//span[text()='Action']/parent::div/parent::div//span[@class='ag-icon ag-icon-menu']"))
					.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span[@class='ag-tab'])[2]")).click();
			String Column1 = driver
					.findElement(By.xpath(
							"(//div[@class='ag-menu ag-ltr']//span[@class='ag-column-tool-panel-column-label'])[2]"))
					.getText();
			System.out.println(Column1);
			Thread.sleep(2000);
			if (Column1.equals("Ref.Id")) {
				extent.pass("Ref.Id Column Found in Position 1");
				result = "PASS";
			} else {

				extent.fail("ReF Id Column Not found in Position 1",
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}

			String Column2 = driver
					.findElement(By.xpath(
							"(//div[@class='ag-menu ag-ltr']//span[@class='ag-column-tool-panel-column-label'])[3]"))
					.getText();
			System.out.println(Column2);
			Thread.sleep(2000);
			if (Column2.equals("Company Name")) {
				extent.pass("Company Name Column Found in Position 2");
				result = "PASS";
			} else {

				extent.fail("Company Name Column Not found in Position 2",
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}
			String Column3 = driver
					.findElement(By.xpath(
							"(//div[@class='ag-menu ag-ltr']//span[@class='ag-column-tool-panel-column-label'])[4]"))
					.getText();
			System.out.println(Column3);
			Thread.sleep(2000);
			if (Column3.equals("Fleet Name")) {
				extent.pass("Fleet Name Column Found in Position 3");
				result = "PASS";
			} else {

				extent.fail("Fleet Name Column Not found in Position 3",
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}
			String Column4 = driver
					.findElement(By.xpath(
							"(//div[@class='ag-menu ag-ltr']//span[@class='ag-column-tool-panel-column-label'])[5]"))
					.getText();
			System.out.println(Column4);
			Thread.sleep(2000);
			if (Column4.equals("Vessel Name")) {
				extent.pass("Vessel Name Column Found in Position 4");
				result = "PASS";
			} else {

				extent.fail("Vessel Name Column Not found in Position 4",
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}
			String Column5 = driver
					.findElement(By.xpath(
							"(//div[@class='ag-menu ag-ltr']//span[@class='ag-column-tool-panel-column-label'])[6]"))
					.getText();
			System.out.println(Column5);
			Thread.sleep(2000);
			if (Column5.equals("Vessel Type")) {
				extent.pass("Vessel Type Column Found in Position 5");
				result = "PASS";
			} else {

				extent.fail("Vessel Type Column Not found in Position 5",
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}
			/*
			 * Actions actions = new Actions(driver); WebElement
			 * element=driver.findElement(By.xpath(
			 * "//div[@class='ag-body-horizontal-scroll-viewport']"));
			 * mouseHoverClick("xpath",
			 * "//div[@class='ag-body-horizontal-scroll-viewport']");
			 * actions.moveToElement(element, 0, 1000).perform(); Thread.sleep(4000);
			 */
			String Column6 = driver
					.findElement(By.xpath(
							"(//div[@class='ag-menu ag-ltr']//span[@class='ag-column-tool-panel-column-label'])[7]"))
					.getText();
			System.out.println(Column6);
			Thread.sleep(2000);
			if (Column6.equals("Flag")) {
				extent.pass("Flag Column Found in Position 6");
				result = "PASS";
			} else {

				extent.fail("Flag Column Not found in Position 6",
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}
			driver.close();

			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(e + "Header not in order",
					MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}
	// Horizontal and Vertical scroll bar in landing page based on the availability
	// of records

	public void Landingpage_Scroll() throws IOException, InterruptedException {
		// //String Result = null;
		boolean present;
		try {
			driver.findElement(By.xpath("//div[@class='ag-body-horizontal-scroll-viewport']"));
			present = true;
			extent.pass("Scroll Horizontal");
			result = "PASS";
			driver.close();

			// Thread.sleep(2000);
		} catch (Exception e) {
			present = false;
			extent.fail(e + "Cant scroll", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	// Check this option allows the user to open the form in a New Tab

	public void landingpage_NewTab(String locatorType, String value) throws IOException, InterruptedException {
		// //String Result = null;
		boolean present;
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);
			element.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@id='nfr_launch_mdl_in_separatewindow_cnf_dlg']//a[text()='Yes']"))
					.click();
			present = true;
			List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
			// switch to new tab
			driver.switchTo().window(browserTabs.get(1));
			extent.pass("Open in new tab");

			result = "PASS";
			driver.close();

			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail("Not open in new tab", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	// User Names should displayed combination of (First Name and Surname) or (First
	// Name and Surname) separately

	public void UserName() throws IOException, InterruptedException {
		// //String Result = null;
		try {

			WebElement Userdetail = driver.findElement(By.xpath("//ul[@class='user_name']"));
			Userdetail.click();
			Thread.sleep(1000);
			WebElement My_profile = driver.findElement(By.xpath("//a[text()='My Profile']"));
			My_profile.click();
			Thread.sleep(9000);
			String Firstname = driver.findElement(By.xpath("//input[contains(@id,'-USD_txtGivenName')]"))
					.getAttribute("value");
			String Lastname = driver.findElement(By.xpath("//input[contains(@id,'-USD_txtSurName')]"))
					.getAttribute("value");
			String displayed = driver.findElement(By.xpath("//ul[@class='user_name']//li[3]")).getText();
			String concat = Firstname + Lastname;

			if (concat.equals(displayed)) {
				extent.pass("User name valid");
				result = "PASS";
			} else {
				extent.fail("User name invalid", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}
			driver.close();

			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail("User name invalid", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}
	// Landing page widget should be configured for all forms[My Actions, My Chats,
	// My Notification, Submitted, Reviewed, Approved, Close Out]. Based on form
	// workflow status, status can be configured.

	public void widget() throws IOException, InterruptedException {
		// //String Result = null;
		boolean present;

		// boolean present;

		try {
			driver.findElement(By.xpath("//i[@class='fa fa-chevron-down arrw_Pnt']")).click();
			present = true;
			driver.findElement(By.xpath("//a[@id='myactionfilterSymbl']"));
			present = true;
			driver.findElement(By.xpath("//h5[text()='My Chats']"));
			present = true;
			driver.findElement(By.xpath("//h5[text()='My Notification']"));
			present = true;
			driver.findElement(By.xpath("//h5[text()='Reviewed']"));
			present = true;
			driver.findElement(By.xpath("//h5[text()='Submitted']"));
			present = true;
			driver.findElement(By.xpath("//h5[text()='Approved']"));
			present = true;
			driver.findElement(By.xpath("//h5[text()='Close Out']"));
			present = true;
			extent.pass("Widget present");
			result = "PASS";
			driver.close();

			// Thread.sleep(2000);
		} catch (Exception e) {
			present = false;
			extent.fail(e + "Widget not present", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	// Include Open Items-Records which are not yet closed all will be listed
	// irrespective of dates when click on Include of open items

	public void Open_item() throws IOException, InterruptedException {
		// //String Result = null;
		try {
			Thread.sleep(5000);

			String value_1 = driver.findElement(By.xpath("//label[contains(@id,'_LND_datagrid_records_lbl_cnt')]"))
					.getText();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='includeopenitems']/ancestor::label")).click();
			Thread.sleep(4000);
			String value_2 = driver.findElement(By.xpath("//label[contains(@id,'_LND_datagrid_records_lbl_cnt')]"))
					.getText();
			int v_1 = Integer.parseInt(value_1);
			int v_2 = Integer.parseInt(value_2);
			if (v_1 < v_2) {
				extent.pass("Open all Forms include open itmes");
				result = "PASS";
			} else {
				extent.fail("No Open Forms", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}
			driver.close();

			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail("No Open Forms", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	// Check this option allows the user to knowing the detail of a form

	public void LandingPage_Information() throws IOException, InterruptedException {

		try {
			List<WebElement> options = driver.findElements(By.xpath("//button[@type='rewokeEditBtn']"));
			if (options.size() >= 1) {

				extent.pass("Info button found");
				result = "PASS";
			} else {
				extent.fail("Info button not found",
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}

			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}
	// Units to be displayed correctly , If applicable

	public void Units(String text) throws IOException, InterruptedException {
		try {
			int c = 0;
			Thread.sleep(4000);
			driver.findElement(By.xpath("//SPAN[@class='ag-icon ag-icon-columns']/self::SPAN")).click();

			Thread.sleep(1000);

			driver.findElement(By.xpath("//div[@ref='primaryColsHeaderPanel']//div[@ref='eSelect']")).click();

			driver.findElement(By.xpath("//div[@ref='primaryColsHeaderPanel']//div[@ref='eSelect']")).click();

			Thread.sleep(2000);
			driver.findElement(By.xpath("//INPUT[@class='ag-primary-cols-filter']/self::INPUT")).sendKeys("" + text);

			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[text()='" + text + "']")).click();

			List<WebElement> h_1 = driver.findElements(By.xpath("//div[@role='gridcell']"));
			for (int i = 0; i < h_1.size(); i++) {
				String a = (h_1.get(i).getText());
				float interger = Float.parseFloat(a);
				if (interger == 0) {
					c += 1;
				}
			}
			if (c == 0) {
				extent.pass("Unit displayed");
				result = "PASS";
			} else {
				extent.fail("Unit is 0", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}
			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail("Unit not displayed", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void Landingpage_Date() throws IOException, InterruptedException {
		try {
			driver.findElement(By.xpath("//div[@id='reportrange']")).click();
			driver.findElement(By.xpath("//li[text()='Custom Range']"));
			driver.findElement(By.xpath("//li[text()='Last 6 years']"));
			driver.findElement(By.xpath("//li[text()='Last 3 years']"));
			driver.findElement(By.xpath("//li[text()='Last year']"));
			driver.findElement(By.xpath("//li[text()='Last 365 days']"));
			driver.findElement(By.xpath("//li[text()='Last 6 Months']"));
			driver.findElement(By.xpath("//li[text()='Last 3 Months']"));
			driver.findElement(By.xpath("//li[text()='Last 2 Months']"));
			driver.findElement(By.xpath("//li[text()='Last Month']"));
			driver.findElement(By.xpath("//li[text()='This Month']"));
			driver.findElement(By.xpath("//li[text()='Last 30 Days']"));
			driver.findElement(By.xpath("//li[text()='Last 7 Days']"));
			driver.findElement(By.xpath("//li[text()='Yesterday']"));
			driver.findElement(By.xpath("//li[text()='Today']"));
			extent.pass("Date parameters present");
			result = "PASS";

			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail("Date parameters not present",
					MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}
//Check Column Headers should match with Form field labels

	public void Column_Header() throws IOException, InterruptedException {
		// String Result = null;
		try {
			Thread.sleep(4000);
			ArrayList<String> hearder_1 = new ArrayList<String>();
			ArrayList<String> hearder_2 = new ArrayList<String>();
			ArrayList<String> hearder_3 = new ArrayList<String>();
			Actions action = new Actions(driver);
			WebElement element = driver.findElement(By.xpath("//div[@class='ag-body-horizontal-scroll-viewport']"));
			List<WebElement> h_1 = driver
					.findElements(By.xpath("//div[@class='ag-header-cell-label']//span[@ref='eText']"));
			mouseHoverClick("xpath", "//div[@class='ag-body-horizontal-scroll-viewport']");

			for (int i = 0; i < h_1.size(); i++) {
				hearder_1.add(h_1.get(i).getText());
				System.out.println(hearder_1);
			}
			Thread.sleep(10000);
			action.moveToElement(element, 0, 2000).build().perform();
			Thread.sleep(10000);
			List<WebElement> h_2 = driver
					.findElements(By.xpath("//div[@class='ag-header-cell-label']//span[@role='columnheader']"));

			for (int i = 0; i < h_2.size(); i++) {
				hearder_2.add(h_2.get(i).getText());
				System.out.println(hearder_2);
			}
			mouseHoverClick("xpath", "//div[@class='ag-body-horizontal-scroll-viewport']");
			action.moveToElement(element, 0, 1000).perform();
			List<WebElement> h_3 = driver
					.findElements(By.xpath("//div[@class='ag-header-cell-label']//span[@role='columnheader']"));

			for (int i = 0; i < h_3.size(); i++) {
				hearder_3.add(h_3.get(i).getText());
				System.out.println(hearder_3);
			}
			mouseHoverClick("xpath", "//div[@class='ag-body-horizontal-scroll-viewport']");

			Thread.sleep(2000);
			driver.findElement(
					By.xpath("//span[text()='New']/parent::a[@class='ui-commandlink ui-widget btn_wrapper']")).click();
			Thread.sleep(5000);
			driver.findElements(
					By.xpath("//div[@class='col-xs-12 col-sm-3']//label[@class='ui-outputlabel ui-widget']"));
			List<WebElement> h_4 = driver.findElements(By.xpath(""));
			ArrayList<String> hearder_4 = new ArrayList<String>();
			for (int i = 0; i < h_2.size(); i++) {
				hearder_2.add(h_2.get(i).getText());
			}
			if (hearder_1.contains(hearder_2) == true) {
				System.out.println(" Array List are equal");
			} else {
				System.out.println(" Array List are not equal");
			}

			extent.pass("Column header and form field label are same");
			result = "PASS";

			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail("Column header and form field label are not same",
					MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	// Check Right Alignment for Numeric & Datetime Fields and Left Alignment for
	// Text & Numeric Including Text fields

	public void Landingpage_Alignments(String text) throws IOException, InterruptedException {
		// String Result = null;
		try {

			Thread.sleep(4000);
			driver.findElement(By.xpath("//SPAN[@class='ag-icon ag-icon-columns']/self::SPAN")).click();

			Thread.sleep(1000);

			driver.findElement(By.xpath("//div[@ref='primaryColsHeaderPanel']//div[@ref='eSelect']")).click();

			driver.findElement(By.xpath("//div[@ref='primaryColsHeaderPanel']//div[@ref='eSelect']")).click();

			Thread.sleep(2000);
			driver.findElement(By.xpath("//INPUT[@class='ag-primary-cols-filter']/self::INPUT")).sendKeys("" + text);

			Thread.sleep(2000);

			driver.findElement(
					By.xpath("//span[@class='ag-column-tool-panel-column-label' and contains(text(),'" + text + "')]"))
					.click();

			String Alignment = driver.findElement(By.xpath("(//div[@role='gridcell'])[1]")).getCssValue("text-align");
			if (Alignment.contains("right")) {
				extent.pass("Value given in right alignment" + Alignment);
				result = "PASS";
			} else {
				extent.pass("Value given in Left alignment" + Alignment);
				result = "PASS";

				/*
				 * extent.fail("Value given in Left alignment" + Alignment,
				 * MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				 * 
				 * result = "<a href=" + ScreenShot() + "> FAIL</a>";
				 */
			}

			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void ShipShoreform() throws IOException, InterruptedException {
		// //String Result = null;
		try {
			String comname = driver
					.findElement(By.xpath(
							"//div[@class='ag-header-container']//div[@col-id='tmpreqdetailforlandingpageshorename']"))
					.getText();
			String fleetname = driver
					.findElement(By.xpath(
							"//div[@class='ag-header-container']//div[@col-id='tmpreqdetailforlandingpagefleetname']"))
					.getText();
			String vesname = driver
					.findElement(By.xpath(
							"//div[@class='ag-header-container']//div[@col-id='tmpreqdetailforlandingpagevsl_name']"))
					.getText();
			String vessaltypename = driver.findElement(By.xpath(
					"//div[@class='ag-header-container']//div[@col-id='tmpreqdetailforlandingpagevessel_type_name']"))
					.getText();
			String flag = driver
					.findElement(By.xpath(
							"//div[@class='ag-header-container']//div[@col-id='tmpreqdetailforlandingpageflagname']"))
					.getText();
			String formheader = comname + "|" + fleetname + "|" + vesname + "|" + vessaltypename + "|" + flag;
			String form = driver.findElement(By.xpath(
					"//span[text()=' SVM DEMO2 | TANKER | Tanker | FAROE ISLANDS | Brian Dale Cunanan CAINGAT']"))
					.getText();
			if (formheader == form) {
				extent.pass(formheader + "match" + form);
				result = "PASS";
			} else {
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}
			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void ShoreForm() throws IOException, InterruptedException {
		// //String Result = null;
		try {
			String CompanyName = driver
					.findElement(By.xpath(
							"//div[@class='ag-header-container']//div[@col-id='tmpreqdetailforlandingpageshorename']"))
					.getText();
			String referenceid = driver.findElement(By
					.xpath("//div[@class='ag-header-container']//div[@col-id='tmpreqdetailforlandingpageuni_tran_no']"))
					.getText();
			String formheader = CompanyName + "|" + referenceid;
			String form = driver.findElement(By.xpath(
					"//span[text()=' SVM DEMO2 | TANKER | Tanker | FAROE ISLANDS | Brian Dale Cunanan CAINGAT']"))
					.getText();

			if (formheader == form) {
				extent.pass(formheader + "match" + form);
				result = "PASS";
			} else {
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}

			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void UserFirst_second_sameColumn(String locatorType, String value, String text) throws IOException {
		try {
			Thread.sleep(4000);
			driver.findElement(By.xpath("//SPAN[@class='ag-icon ag-icon-columns']/self::SPAN")).click();

			Thread.sleep(1000);

			driver.findElement(By.xpath("//div[@ref='primaryColsHeaderPanel']//div[@ref='eSelect']")).click();

			driver.findElement(By.xpath("//div[@ref='primaryColsHeaderPanel']//div[@ref='eSelect']")).click();

			Thread.sleep(2000);
			driver.findElement(By.xpath("//INPUT[@class='ag-primary-cols-filter']/self::INPUT")).sendKeys("" + text);

			Thread.sleep(2000);

			driver.findElement(
					By.xpath("//span[@class='ag-column-tool-panel-column-label' and contains(text(),'" + text + "')]"))
					.click();
			Thread.sleep(6000);
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);
			String Username = element.getText();

			String[] First_secondName = Username.split(" ");
			String FirstName = First_secondName[0];
			String SecondName = First_secondName[1];
			System.out.println(FirstName);
			System.out.println(SecondName);
			if (SecondName != null) {
				extent.pass(" valid ");
				result = "PASS";
			} else {
				extent.fail("not Valid");

				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}

		} catch (Exception e) {
			extent.fail("User name in one word" + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void Field_RightAlignment(String locatorType, String value) throws IOException {
		try {

			// storing value in input field and using for file export

			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = WaitUtil.fluentWait(locator);
			String Alignment = element.getAttribute("style");

			if (Alignment.contains("right")) {
				extent.pass("Field given in Right alignment" + Alignment);
				result = "PASS";
			} else if (Alignment == null) {
				extent.fail("Style not prsent" + Alignment,

						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			} else {

				extent.fail("Field given in Left alignment" + Alignment,
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}

			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void Font() throws IOException {
		int a = 0, b = 0;
		try {
			List<WebElement> text = driver.findElements(
					By.xpath("//div[@ref='headerRoot']//div[@class='ag-header-cell ag-header-cell-sortable']"));
			for (int i = 0; i < text.size(); i++) {
				String value1 = text.get(i).getCssValue("font-family");
				if (value1 == "'Lato', sans-serif !important") {
					a += 1;
				} else {
					b += 1;
				}
			}
			if (b != 0) {
				extent.fail("Fonts are different",
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			} else {
				extent.pass("Same font");
				result = "PASS";
			}
		}

		// Thread.sleep(2000);
		catch (Exception e) {
			extent.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void Spelling() throws IOException {
		try {
			List<WebElement> text = driver.findElements(
					By.xpath("//div[@ref='headerRoot']//div[@class='ag-header-cell ag-header-cell-sortable']"));
			for (int i = 0; i < text.size(); i++) {
				String value2 = text.get(i).getText();
				char ch = value2.charAt(0);
				if (Character.isUpperCase(ch)) {
					extent.pass("First letter in uppercase" + value2);
					result = "PASS";
				} else {

					extent.fail("First letter not in uppercase" + value2,
							MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
					result = "<a href=" + ScreenShot() + "> FAIL</a>";
				}
			}
		}

		// Thread.sleep(2000);
		catch (Exception e) {
			extent.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void Filter_1() throws IOException, InterruptedException {
		// //String Result = null;
		try {
			String Cloumnname = driver
					.findElement(By.xpath(
							"//div[@class='ag-header-container']//div[@col-id='tmpreqdetailforlandingpageshorename']"))
					.getText();
			driver.findElement(By.xpath(
					"//*[@id=\"PRQ_LND_datagrid_tbl\"]/div/div[2]/div[1]/div[1]/div[2]/div/div[2]/div[3]/div[2]"))
					.click();
			WebElement S1 = driver.findElement(By.xpath("(//INPUT[@class='ag-filter-filter'])[1]"));
			S1.sendKeys("SVM");

			WebElement S2 = driver.findElement(By.xpath("(//INPUT[@class='ag-filter-filter'])[1]"));
			S2.sendKeys("Sg");
			String Name = driver.findElement(By.xpath("(//input[@class='ag-floating-filter-input'])[4]")).getText();
			String s3 = S1 + "AND" + S2;
			String s4 = S1 + "OR" + S2;
			if (s3 == Name || s4 == Name) {
				extent.pass(s3 + "Filter" + Name);
				result = "PASS";
			} else {
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}

			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void Landingpage_Defaultsearch() throws IOException, InterruptedException {
		// //String Result = null;
		try {
			driver.findElement(By.xpath("//button[@id='tasksearch-tasksearch']")).click();
			Thread.sleep(4000);
			String records = driver.findElement(By.xpath("//label[contains(@id,'-twocol-totrecords')]")).getText();
			if (records == "Total Records : 0") {
				extent.pass("No avialiable records");
				result = "PASS";
			} else {
				extent.pass("It show relevant form records available");
				result = "PASS";
			}

			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void Landingpage_Breadcrumb() throws IOException, InterruptedException {
		// //String Result = null;
		try {
			String Breadcrumpname = driver.findElement(By.xpath(
					"//div[contains(@id,'Breadcrumbs-brdcrm')]//span[@class='ui-menuitem-link ui-corner-all ui-state-disabled']//span"))
					.getText();
			String Heading = driver.findElement(By.xpath("//div[@class='tab_head']//div")).getText();
			if (Breadcrumpname.contains(Heading + "->List")) {
				extent.pass("Breadcrump Present");
				result = "PASS";
			} else {
				extent.fail("Breadcrump not present");
				result = "FAIL";
			}
			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void Landingpage_BreadcrumbPath() throws IOException, InterruptedException {
		// //String Result = null;
		try {
			List<WebElement> no = driver.findElements(By.xpath("//div[contains(@id,'Breadcrumbs-brdcrm')]//li"));
			int Count = no.size();
			String ele1 = driver.findElement(By.xpath("//div[contains(@id,'Breadcrumbs-brdcrm')]//li//span//span"))
					.getText();
			System.out.println(ele1);
			String ele2 = driver.findElement(By.xpath("//div[@class='tab_head']//div")).getText(); // h_1.get(i).getText()
			System.out.println(ele2);
			if (Count >= 1 && ele1.contains(ele2)) {
				extent.pass("Breadcrump Present");
				result = "PASS";
			} else {
				extent.fail("Breadcrump not present");
				result = "FAIL";
			}
			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void Landingpage_Newbutton() throws IOException, InterruptedException {
		// //String Result = null;
		boolean present;
		try {

			driver.findElement(
					By.xpath("//span[text()='New']/parent::a[@class='ui-commandlink ui-widget btn_wrapper']"));
			present = true;
			extent.pass("New button present");
			result = "PASS";
			// Thread.sleep(2000);
		} catch (Exception e) {
			present = false;
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void Landingpage_recordcount() throws IOException, InterruptedException {
		// //String Result = null;
		try {
			Actions action = new Actions(driver);
			String a2 = driver.findElement(By.xpath(
					"//div[@class='ag_total_records_hdr']//label[contains(@id,'_LND_datagrid_records_lbl_cnt')]"))
					.getText();
			int c2 = Integer.parseInt(a2);
			// action.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
			// div[@class='ag-body-viewport ag-layout-normal ag-row-no-animation']
			/*
			 * WebElement a = driver.findElement(By.
			 * xpath("//div[@class='ag-body-viewport ag-layout-normal ag-row-no-animation']"
			 * )); action.clickAndHold(a);
			 */
			/*
			 * JavascriptExecutor js = (JavascriptExecutor) driver; WebElement elem =
			 * driver.findElement( By.xpath(
			 * "driver.findElement(By.xpath(\"//div[@ref='eLeftContainer']//div[@row-index='311']"
			 * ))" )); js.executeScript("arguments[0].scrollIntoView(true);", elem);
			 * elem.click();
			 */
			WebElement elm = driver.findElement(
					By.xpath("//*[@id='PRQ_LND_datagrid_tbl']/div/div[2]/div[1]/div[3]/div[2]/div/div/div[17]/div[4]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elm);
			// String a1 =
			// driver.findElement(By.xpath("//div[@ref='eLeftContainer']//div[@row-index='"
			// + (c2 - 1) + "']")).getText();
			extent.pass("Count of record correct");
			result = "PASS";
			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void Landingpage_Actionbutton() throws IOException, InterruptedException {
		// //String Result = null;
		try {
			List<WebElement> options = driver.findElements(By.xpath("//button[@title='View']"));
			if (options.size() >= 1) {

				extent.pass("View button found");
				result = "PASS";
			} else {
				extent.fail("View button not found",
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}
			List<WebElement> options1 = driver.findElements(By.xpath("//button[@title='Edit']"));
			if (options1.size() >= 1) {

				extent.pass("Edit button found");
				result = "PASS";
			} else {
				extent.fail("Edit button not found",
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}
			List<WebElement> options2 = driver.findElements(By.xpath("//button[@title='New Tab']"));
			if (options2.size() >= 1) {

				extent.pass("New Tab button found");
				result = "PASS";
			} else {
				extent.fail("New Tab button not found",
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}
			/*
			 * List<WebElement> options3 =
			 * driver.findElements(By.xpath("//button[@type='rewokeEditBtn']")); if
			 * (options3.size() >= 1) {
			 * 
			 * extent.pass("Info button found"); result = "PASS"; } else {
			 * extent.fail("Info button not found",
			 * MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			 * 
			 * result = "<a href=" + ScreenShot() + "> FAIL</a>"; } // Thread.sleep(2000);
			 */ } catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void Drag_and_drop(String locatorType, String value, String text) throws IOException, InterruptedException {
		// //String Result = null;
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			// Element which needs to drag.
			WebElement From = driver.findElement(locator);
			// Element on which need to drop.
			WebElement To = driver.findElement(By.xpath("(//span[text()='" + text + "'])[1]"));

			// Using Action class for drag and drop.
			Actions act = new Actions(driver);
			// Dragged and dropped.
			act.dragAndDrop(From, To).build().perform();
			extent.pass("Drag and drop");
			result = "PASS";

		} catch (Exception e) {
			extent.fail("Cant drag and drop" + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void Form_opening_Popup() throws IOException, InterruptedException {
		// //String Result = null;
		boolean present;
		try {
			driver.findElement(By.xpath("//div[contains(@id,'_ExpiringDlg')]"));
			present = true;
			driver.findElement(By.xpath("//div[contains(@id,'_ExpiringDlg')]//a[@aria-label='Close']")).click();
			extent.pass("Popup Displayed");
			result = "PASS";

		} catch (Exception e) {
			extent.fail("Popup not Displayed" + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void date() throws IOException {
		// //String Result = null;
		try {
			Date objDate = new Date();
			System.out.println(objDate);
			String strDateFormat = "dd";
			String strDateFormat1 = "hh:mm:ss a dd-MMM-yyyy";
			SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
			System.out.println(objSDF.format(objDate));
			Boolean e2 = driver.findElement(By.xpath("//*[@id='wholeForm']/div[2]/div/div[2]/div/div[1]/ul/li[2]/span"))
					.isDisplayed();
			Boolean e3 = driver.findElement(By.xpath("//*[@id='wholeForm']/div[2]/div/div[2]/div/div[1]/ul/li[3]/span"))
					.isDisplayed();
			Boolean e4 = driver.findElement(By.xpath("//*[@id='wholeForm']/div[2]/div/div[2]/div/div[1]/ul/li[1]/span"))
					.isDisplayed();
			if (e2 == true && e3 == true && e4 == true) {
				System.out.println("date day and month is displayed");
				result = "PASS";
				extent.pass(code);
			} else {
				System.out.println("Not displayed");
				extent.fail(code + "Not displayed");
			}
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void Search_User() throws IOException, InterruptedException {
		// //String Result = null;
		int k = 0;
		try {
			driver.findElement(By.xpath("//button[contains(@id,'_btnperson')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span[@ref='eMenu'])[2]")).click();
			driver.findElement(By.xpath("(//span[@class='ag-tab'])[2]")).click();
			List<WebElement> element = driver
					.findElements(By.xpath("//span[@class='ag-column-tool-panel-column-label']"));
			for (int i = 1; i <= element.size(); i++) {
				String m = driver
						.findElement(By.xpath("(//span[@class='ag-column-tool-panel-column-label'])[" + i + "]"))
						.getText();
				System.out.println(m);
				if (m.equals("Company Name") || m.equals("Employee Code") || m.equals("Employee Name")
						|| m.equals("Rank Name") || m.equals("Department Name")) {
					k = k + 1;
				}
			}
			if (k == 5) {
				extent.pass("Search user");
				result = "PASS";
			} else {
				extent.fail("Cant search user", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}

		} catch (Exception e) {
			extent.fail("Cant search user" + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void ConditionFilter() throws IOException, InterruptedException {
		boolean Conditionfilter;
		try {
			driver.findElement(By.xpath("//div[@class='nfr_toolpanel_li_icon']")).click();
			WebElement conditionfilter = driver.findElement(By.xpath("//SPAN[@class='ag-icon ag-icon-filter']"));
			if (conditionfilter.isEnabled()) {
				extent.pass("Conditionfilter Enable");
				result = "PASS";
			} else {
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}
		} catch (Exception e) {
			Conditionfilter = false;
			extent.fail("Conditionfilter Disable",
					MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void records() throws IOException, InterruptedException {
		// //String Result = null;
		try {
			WebElement e1 = driver.findElement(By.xpath("//label[@id='PRQ_LND_datagrid_records_lbl_cnt']"));
			String s = e1.getText();
			int i = Integer.parseInt(s);
			System.out.println(i);
			if (i >= 25000 || i < 25000) {
				System.out.println("Landing page can load more than 25000 records");
				result = "PASS";
				extent.pass(code);
				// Thread.sleep(2000);
			}

			else {
				System.out.println("Landing page cannot load more than 25000 records");
				extent.fail(code + "No al");
			}
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

//To Validate pinLeft Button
	public void leftToRight() throws IOException, InterruptedException {
		// //String Result = null;
		try {

			// driver.findElement(By.xpath("//input[@id='nfr_topbar_autocomp1_input']")).sendKeys(TestData");
			// Thread.sleep(8000);
			driver.findElement(By.xpath(
					"//LI[@class='ui-autocomplete-item ui-autocomplete-list-item ui-corner-all ui-state-highlight']/self::LI"))
					.click();
			Thread.sleep(8000);
			driver.findElement(By.xpath("//div[@class='nfr_toolpanel_li_icon']")).click();
			WebElement Distinct = driver.findElement(By.xpath("//*[@id='PRQ_LND_datagrid_toolpanel']/ul/li[5]/a/img"));

			if (Distinct.isEnabled()) {

				Distinct.click();

				Thread.sleep(2000);
			}

			List<WebElement> beforeOrder = driver.findElements(By.xpath("//div[@class='ag-header-cell-label']"));
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[contains(@class,'ag-cell-label-container ag')])[2]/span/span")).click();
			Thread.sleep(2000);
			mouseHoverClick("xpath", "//span[text()='Pin Column']");
			Thread.sleep(4000);
			Waitclick("xpath", "//span[text()='Pin Left']");
			Thread.sleep(2000);
			List<WebElement> afterOrder = driver
					.findElements(By.xpath("//*[@id='PRQ_LND_datagrid_tbl']/div/div[2]/div[1]/div[1]/div[2]"));
			int beforeCount = 0;
			int afterCount = 0;
			for (WebElement webElement : beforeOrder) {
				if (webElement.getText().equals("Action")) {
					break;
				}
				beforeCount++;

			}
			for (WebElement webElement : afterOrder) {
				if (webElement.getText().equals("Action")) {
					break;
				}
				afterCount++;

			}

			if (beforeCount < afterCount) {
				extent.pass(" Cloumn is Moved");
				result = "PASS";
			} else {

				extent.fail("column did not move",
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

//To Validate Allignment
	public void getallelement() throws IOException, InterruptedException {
		// //String Result = null;
		try {

			driver.findElement(By.xpath("//SPAN[text()='New']/self::SPAN")).click();
			Thread.sleep(8000);

			List<WebElement> elementsForm = driver.findElements(By.xpath(
					"//DIV[@class='row']//div[@class='col-xs-12 col-sm-12 pms-margin-top10']//DIV[@class='col-xs-12 col-sm-3']/label"));

			for (int j = 0; j < elementsForm.size(); j++) {

				System.out.println("form column:" + elementsForm.get(j).getText());

			}
			extent.pass(code + "AllignMent is Success ");

		} catch (Exception e) {

			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			System.out.print("Element not found" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

//To Validate 
	public void pinleft() throws IOException, InterruptedException {

		try {

			// column which is going to drag
			WebElement From = driver.findElement(By.xpath("(//span[@role='columnheader'])[4]"));
			String dragcolumn = From.getText();

			// click on distinct filter on column header
			driver.findElement(By.xpath("(//span[@ref='eMenu'])[4]")).click();
			Thread.sleep(3000);

			// click pin column
			driver.findElement(By.xpath("//span[text()='Pin Column']")).click();

			// click pin left
			WebElement element = driver.findElement(By.xpath("//span[text()='Pin Left']"));
			element.click();

			// On column in which it is dropped
			WebElement To = driver.findElement(By.xpath("(//span[@role='columnheader'])[2]"));
			String dropcolumn = To.getText();

			if (dragcolumn.contains(dropcolumn)) {

				extent.pass("  system Pins the selected column to left");
				result = "PASS";
			}

			else {

				extent.fail("column did not move",
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}

		} catch (Exception e) {

			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			System.out.print("column did not move" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void pinright() throws IOException, InterruptedException {

		try {

			// column which is going to drag
			WebElement From = driver.findElement(By.xpath("(//span[@role='columnheader'])[4]"));
			String dragcolumn = From.getText();

			// click on distinct filter on column header
			driver.findElement(By.xpath("(//span[@ref='eMenu'])[4]")).click();
			Thread.sleep(3000);

			// click pin column
			driver.findElement(By.xpath("//span[text()='Pin Column']")).click();

			// click pin right
			WebElement element = driver.findElement(By.xpath("//span[text()='Pin Right']"));
			element.click();

			// On column in which it is dropped
			WebElement To = driver.findElement(By.xpath("//div[@class='ag-pinned-right-header']"));
			String dropcolumn = To.getText();

			if (dragcolumn.contains(dropcolumn)) {

				extent.pass("  system Pins the selected column to right");
				result = "PASS";
			}

			else {

				extent.fail("column did not move",
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}

		} catch (Exception e) {

			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			System.out.print("column did not move" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void NoPin() throws IOException, InterruptedException {

		try {
			// column which is going to drag
			WebElement From = driver.findElement(By.xpath("(//div[@class='ag-pinned-right-header']"));
			String dragcolumn = From.getText();

			// click on distinct filter on column header
			driver.findElement(By.xpath("//div[@class='ag-pinned-right-header']//span[@ref='eMenu']")).click();
			Thread.sleep(3000);

			// click pin column
			driver.findElement(By.xpath("//span[text()='Pin Column']")).click();

			// click No pin
			WebElement element = driver.findElement(By.xpath("//span[text()='No Pin']"));
			element.click();

			// On column in which it is dropped
			WebElement To = driver.findElement(By.xpath("(//span[@role='columnheader'])[8]"));
			String dropcolumn = To.getText();

			if (dragcolumn.contains(dropcolumn)) {

				extent.pass("  system has reset the default column order");
				result = "PASS";
			}

			else {

				extent.fail("column did not move",
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}

		} catch (Exception e) {

			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			System.out.print("column did not move" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void Pinvisibility() throws IOException, InterruptedException, ArrayIndexOutOfBoundsException {

		// column which is going to drag

		try {
			WebElement From = driver.findElement(By.xpath(
					"//div[@class='ag-header ag-pivot-off']//div[@class='ag-header-cell ag-header-cell-sortable'][2]//span[@class='ag-icon ag-icon-menu']"));
			From.click();
			Thread.sleep(2000);

			Actions action = new Actions(driver);

			WebElement element = driver.findElement(By.xpath("//span[text()='Pin Column']/self::span"));
			action.moveToElement(element).build().perform();

			Thread.sleep(3000);
			boolean elem = driver.findElement(By.xpath("//span[text()='Pin Left']")).isDisplayed();
			Thread.sleep(2000);
			boolean elem1 = driver.findElement(By.xpath("//span[text()='Pin Right']")).isDisplayed();
			Thread.sleep(2000);
			boolean elem2 = driver.findElement(By.xpath("//span[text()='No Pin']")).isDisplayed();
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			extent.fail("Form name not found" + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}

	}

//To Validate FormHeader
	public void Formheader_formname() throws IOException, InterruptedException {

		boolean present;

		try {

			driver.findElement(By.xpath("//div[@class='pull-left']"));

			present = true;

			extent.pass("Form name found");
			result = "PASS";

		}

		catch (Exception e) {

			present = false;

			extent.fail("Form name not found" + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void savetemplate() throws IOException, InterruptedException {
		// //String Result = null;

		try {

			WebElement e1 = driver.findElement(By.xpath("//div[contains(@class,'nfr_toolpanel_li_icon')]"));
			e1.click();
			Thread.sleep(2000);
			WebElement saveTemplate = driver.findElement(By.xpath("//span[text()='Save Template']/self::span"));
			saveTemplate.click();

			if (saveTemplate.isSelected()) {
				System.out.println("Saved successfully");

				result = "PASS";
				extent.pass(code + "Save Template ");
				// Thread.sleep(2000);
			}

			else {
				System.out.println("Not saved");
				extent.fail(code + "Not saved");
			}
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

//new
	public void savetemplateas1() throws IOException, InterruptedException {
		// //String Result = null;

		try {

			WebElement e1 = driver.findElement(By.xpath("//div[contains(@class,'nfr_toolpanel_li_icon')]"));
			e1.click();
			Thread.sleep(2000);
			WebElement saveTemplate = driver.findElement(By.xpath("//span[text()='Save as Template']/self::span"));
			saveTemplate.click();

			WebElement e3 = driver.findElement(By.xpath("//input[@name='Template Name']"));
			e3.sendKeys("abcd");

			WebElement e4 = driver.findElement(
					By.xpath("//input[contains(@class,'sm-aggrid-template-save sm-aggrid-template-btn')]"));
			e4.click();

			WebElement element = driver.findElement(By.xpath("//span[text()=" + e3 + "]"));

			System.out.println("Template is saved");

			result = "PASS";
			extent.pass(code + "Template is saved");
			// Thread.sleep(2000);

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void right_alignment() throws IOException, InterruptedException {
		// //String Result = null;
		try {

			WebElement findElement = driver.findElement(By.xpath("(//div[text()='SVM DEMO'])[1]"));
			findElement.getAttribute("style");
			// String cssValue = findElement.getAttribute("style");

			System.out.println(findElement + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			Thread.sleep(2000);
			/*
			 * if (findElement.("right")) {
			 * 
			 * System.out.println("Text is right aligned"); result = "PASS";
			 * extent.pass(code + "Template is saved"); Thread.sleep(2000);
			 * 
			 * }
			 */
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void workflow_newuser() throws IOException, InterruptedException {
		// //String Result = null;
		try {

			WebElement element = driver.findElement(By.cssSelector(""));
			String text = element.getText();

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void savetemplate1() throws IOException, InterruptedException {
		// //String Result = null;

		try {

			WebElement e1 = driver.findElement(By.xpath("//div[contains(@class,'nfr_toolpanel_li_icon')]"));
			e1.click();
			Thread.sleep(2000);
			WebElement saveTemplate = driver.findElement(By.xpath("//span[text()='Save Template']/self::span"));
			saveTemplate.click();

			Boolean element = driver.findElement(By.xpath("//p[text()='Template Updated Successfully']")).isDisplayed();

			if (element == true) {
				System.out.println("Saved successfully");

				result = "PASS";
				extent.pass(code + "Template Updated");
				// Thread.sleep(2000);
			}

			else {
				System.out.println("Not saved");
				extent.fail(code + "Not saved");
			}
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

//new
	public void savetemplateas() throws IOException, InterruptedException {
		// //String Result = null;

		try {

			WebElement e1 = driver.findElement(By.xpath("//div[contains(@class,'nfr_toolpanel_li_icon')]"));
			e1.click();
			Thread.sleep(2000);
			WebElement saveTemplate = driver.findElement(By.xpath("//span[text()='Save as Template']/self::span"));
			saveTemplate.click();

			WebElement e3 = driver.findElement(By.xpath("//input[@name='Template Name']"));
			e3.sendKeys("abcd");

			WebElement e4 = driver.findElement(
					By.xpath("//input[contains(@class,'sm-aggrid-template-save sm-aggrid-template-btn')]"));
			e4.click();

			Boolean element = driver.findElement(By.xpath("//p[text()='Template Updated Successfully']")).isDisplayed();

			if (element == true) {
				System.out.println("Template is saved");

				result = "PASS";
				extent.pass(code + "Tempalte is Saved");
				// Thread.sleep(2000);
			}

			else {
				System.out.println("Template is not saved");
				result = "n/a";
				extent.fail(code + "Tempate is not saved");
			}
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	// Check this option helps the User can view the field level description.(Note:
	// User have to map field values in Module Tool Tip Screen)
	public void Tooltip1() throws IOException, InterruptedException {
		// //String Result = null;
		boolean present;
		try {
			WebElement tooltip = driver.findElement(By.xpath("//div[@class='checkboxhelp']"));
			Thread.sleep(2000);
			if (tooltip.isEnabled()) {
				click(tooltip);
				Thread.sleep(2000);
				click(tooltip);
				Thread.sleep(2000);
				WebElement c = driver.findElement(By.xpath("//i[@class='fa fa-info-circle info_child']"));
				if (c.isDisplayed()) {
					extent.pass("formname");
					result = "PASS";
				}

			} else {
				result = "<a href=" + ScreenShot() + ">FAIL</a>";
			}
			// Thread.sleep(2000);
		} catch (Exception e) {
			present = false;
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	// Check the Bread crumb displays the navigation path of the respective Form
	public void Breadcrumb() throws IOException, InterruptedException {
		// //String Result = null;
		try {
			// WebElement breadcrumb = driver.findElement(By.xpath(
			// "//span[@class=\"ui-menuitem-link ui-corner-all
			// ui-state-disabled\"]//span[@class=\"ui-menuitem-text\"]"));
			// paste the xpath by using web element
			WebElement breadcrumb = driver.findElement(By.xpath(
					"//span[@class='ui-menuitem-text']/parent::span[@class='ui-menuitem-link ui-corner-all ui-state-disabled']"));
			WebElement header = driver.findElement(By.xpath("//div[@class='tab_head']/child::div[@class='pull-left']"));
			String a = breadcrumb.getText();
			String b = header.getText();
			if (a.equals(b)) {
				extent.pass("formname");
				result = "PASS";
			} else {
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}
			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + ">FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	// Check this option helps the User can view the complete text description
	// available on the field
	public void WarpText1() throws IOException, InterruptedException {
		// //String Result = null;

		try {
			WebElement warptext = driver.findElement(By.xpath("//img[@id='PRQ-addWrap']"));
			// Thread.sleep(2000);
			if (warptext.isEnabled()) {
				click(warptext);
				extent.pass("formname");
				result = "PASS";
			} else {
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}

			// Thread.sleep(2000);
		} catch (Exception e) {

			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	// Vessel Details Bar should display Vessel Name,Vessel
	// Type,Fleet,Flag,Master,C/E and C/O (Names should be combination of First Name
	// and Surname).

	public void VesselDetailsbar1() throws IOException, InterruptedException {
		// //String Result = null;
		try {
			boolean vessel = driver.findElement(By.xpath("//div[@class='tab_content_area']//span[@class='pull-left']"))
					.isDisplayed();
			if (vessel == true) {
				extent.pass("formheader");
				result = "PASS";

			} else {
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}
			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> N/A</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	// draft
	public void Draft() throws IOException, InterruptedException {
		// //String Result = null;

		try {
			WebElement draft = driver.findElement(By.xpath("//span[text()='DRAFT']"));
			click(draft);
			Thread.sleep(5000);
			WebElement draftcolor = driver
					.findElement(By.xpath("//a[@class='bs-wizard-dot']/preceding::span[text()='Draft']"));
			String c = draftcolor.getCssValue("background-color");
			// changing color to hexa decimal value
			String fromString = Color.fromString(c).asHex();
			String d = "#ff7c25";
			if (!(fromString.equals(d))) {
				extent.pass("formname");
				result = "PASS";
			} else {
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			} // Thread.sleep(2000);
		} catch (Exception e) {

			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	// reviewed
	public void reviewed() throws IOException, InterruptedException {
		// //String Result = null;
		try {
			WebElement reviewdropdown = driver.findElement(By.xpath("//button[@id='PRQ-review_menuButton']"));
			click(reviewdropdown);
			// Thread.sleep(2000);
			WebElement reviewed = driver.findElement(By
					.xpath("//span[@class='ui-menuitem-icon ui-icon pi pi-times']/preceding::span[text()='REVIEWED']"));
			click(reviewed);
			Thread.sleep(2000);
			WebElement reviewedcolor = driver
					.findElement(By.xpath("//a[@class='bs-wizard-dot']/preceding::span[text()='Reviewed']"));
			String c = reviewedcolor.getCssValue("background-color");
			String d = Color.fromString(c).asHex();
			String e = "#ff7c25";
			if (!(d.equals(e))) {

				extent.pass("formname");
				result = "PASS";
			} else {
				result = "<a href=" + ScreenShot() + ">FAIL</a>";
			}
			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	// approved
	public void Approved() throws IOException, InterruptedException {
		// //String Result = null;

		try {
			WebElement Approveddropdown = driver.findElement(By.xpath("//button[@id='PRQ-approve_menuButton']"));
			click(Approveddropdown);
			WebElement Approved = driver.findElement(By.xpath(
					"//span[@class='ui-menuitem-icon ui-icon pi pi-refresh']/following::span[text()='APPROVED']"));

			click(Approved);
			Thread.sleep(2000);
			WebElement ok = driver.findElement(By.xpath("//button[@class='ok']"));
			click(ok);
			pageload();
			Thread.sleep(2000);
			WebElement no = driver.findElement(By.xpath("//button[@class='cancel']"));
			click(no);
			// Thread.sleep(2000);
			WebElement Approvedcolor = driver
					.findElement(By.xpath("//a[@class='bs-wizard-dot']/preceding::span[text()='Approved']"));
			String c = Approvedcolor.getCssValue("background-color");
			String d = Color.fromString(c).asHex();
			String e = "#00a65a";
			// Thread.sleep(2000);
			if (!(d.endsWith(e))) {
				extent.pass("formname");
				result = "PASS";
			} else {
				result = "<a href=" + ScreenShot() + ">FAIL</a>";
			}
			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + ">FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	// stage closed
	public void stageclosed() throws IOException, InterruptedException {
		// //String Result = null;

		try {
			WebElement Approveddropdown = driver.findElement(By.xpath("//button[@id='PRQ-approve_menuButton']"));
			click(Approveddropdown);
			WebElement Approved = driver.findElement(By.xpath(
					"//span[@class='ui-menuitem-icon ui-icon pi pi-refresh']/following::span[text()='APPROVED']"));

			click(Approved);
			Thread.sleep(2000);
			WebElement ok = driver.findElement(By.xpath("//button[@class='ok']"));
			click(ok);
			pageload();
			Thread.sleep(2000);
			WebElement no = driver.findElement(By.xpath("//button[@class='cancel']"));
			click(no);
			// Thread.sleep(2000);
			// Thread.sleep(2000);
			WebElement stageclosedcolor = driver
					.findElement(By.xpath("//a[@class='bs-wizard-dot']/preceding::span[text()='Stage Closed']"));
			String f = stageclosedcolor.getCssValue("background-color");
			String g = Color.fromString(f).asHex();
			String h = "#ff7c25";
			if (!(g.endsWith(h))) {
				extent.pass("formname");
				result = "PASS";
			} else {
				result = "<a href=" + ScreenShot() + ">FAIL</a>";
			}
			// Thread.sleep(2000);
		} catch (Exception e) {

			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + ">FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	/// private ThreadLocal<String> testName = new ThreadLocal<>();

	public void delettemplate1() throws IOException, InterruptedException {

		try {

			WebElement e1 = driver.findElement(By.xpath("//span[text()='Delete Template']"));
			e1.click();

			if (e1.isSelected()) {
				System.out.println("Delete");

				result = "PASS";
				extent.pass(code + "Delete button is Clicked");
			}

			else {
				System.out.println("Template is deleted");
				extent.fail(code + " deleted is not Clicked");
			}
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void standardtoolbar1() throws IOException, InterruptedException {
		// //String Result = null;
		try {
			driver.findElement(By.xpath("//span[text()='New']/self::span")).click();
			waitTime();

			WebElement newButton = driver.findElement(By.xpath("//span[text()='New']/self::span"));

			newButton.isEnabled();

			System.out.println(newButton + "visible");
			WebElement saveButton = driver.findElement(By.xpath("//span[text()='Save']/self::span"));
			saveButton.isEnabled();
			Thread.sleep(2000);
			System.out.println(saveButton + "visible");
			WebElement editButton = driver.findElement(By.xpath("//span[text()='Save']/self::span"));
			editButton.isEnabled();
			Thread.sleep(2000);
			System.out.println(editButton + "visible");
			WebElement deleteButton = driver.findElement(By.xpath("//span[text()='Save']/self::span"));
			editButton.isEnabled();
			System.out.println(deleteButton + "visible");
			Thread.sleep(2000);

			WebElement searchButton = driver.findElement(By.xpath("//span[text()='Search']/self::span"));
			searchButton.isEnabled();
			System.out.println(searchButton + "visible");

		} catch (Exception e) {
			extent.fail(code + " " + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void standardtoolbarPms() throws IOException, InterruptedException {
		// //String Result = null;
		try {

			WebElement newButton = driver.findElement(By.xpath("//span[text()='New']/self::span"));

			newButton.isEnabled();

			System.out.println(newButton + "visible");
			WebElement saveButton = driver.findElement(By.xpath("//span[text()='Save']/self::span"));
			saveButton.isEnabled();
			Thread.sleep(2000);
			System.out.println(saveButton + "visible");
			WebElement editButton = driver.findElement(By.xpath("//span[text()='Save']/self::span"));
			editButton.isEnabled();
			Thread.sleep(2000);
			System.out.println(editButton + "visible");
			WebElement deleteButton = driver.findElement(By.xpath("//span[text()='Save']/self::span"));
			editButton.isEnabled();
			System.out.println(deleteButton + "visible");
			Thread.sleep(2000);

			WebElement searchButton = driver.findElement(By.xpath("//span[text()='Search']/self::span"));
			searchButton.isEnabled();
			System.out.println(searchButton + "visible");
			result = "PASS";
			extent.pass(code + "Standard Tool Bar are Visible");

		} catch (Exception e) {
			extent.fail(code + " " + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

//To Validate ToolBarButton
	public void toolbar_btn() throws IOException, InterruptedException {

		boolean present;

		try {

			WebElement newbutton = driver.findElement(By.xpath("//button[contains(@id,'btnTblNew')]"));

			WebElement cancelbutton = driver
					.findElement(By.xpath("(//SPAN[@class='ui-button-text ui-c'][text()='Cancel'])[1]"));

			WebElement editbutton = driver.findElement(By.xpath("//button [contains(@id,'-btnTblEdit')]"));

			WebElement savebutton = driver.findElement(By.xpath("//button [contains(@id,'-btnsave')]"));

			WebElement deletebutton = driver.findElement(By.xpath("//button[contains(@id,'btnTblDelete')]"));

			WebElement searchbutton = driver.findElement(By.xpath("//button[contains(@id,'btnTblDefaultSearch')]"));

			WebElement exportbutton = driver.findElement(By.xpath("//button[contains(@id,'btnTblExport')]"));

			present = true;

			extent.pass("new button found" + newbutton + "|" + "cancel button found" + cancelbutton + "|"
					+ "Edit button found" + editbutton + "|" + "search button found" + searchbutton + "|"
					+ "save button found" + savebutton + "|" + "delete button found" + deletebutton + "|"
					+ "export button found" + exportbutton);
			result = "PASS";

		}

		catch (Exception e) {

			present = false;

			extent.fail("buttons not found" + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

//To Validate FormHeader Refid
	public void Formheader_refid() throws IOException, InterruptedException {

		boolean present;

		try {

			driver.findElement(By.xpath("//span[@class='refId']"));

			present = true;

			extent.pass("Reference number found");
			result = "PASS";

		}

		catch (Exception e) {

			present = false;

			extent.fail("Reference number not found" + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

//To Validate oneClick 
	public void Onclickcancel_clear_refid() throws IOException, InterruptedException {

		try {

			// click cancel button
			driver.findElement(By.xpath("(//button[contains(@id,'-btnTblCancel')])")).click();

			// ref id displayed or not
			WebElement element = driver.findElement(By.xpath("//span[@class='refId']"));

			String Refid = element.getText();

			if (Refid == null) {

				extent.pass("Reference number cleared");
				result = "Pass";

			}

			else {

				extent.fail("Reference number did not clear : " + Refid,
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}
		}

		catch (Exception e) {

			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

//To Validate OneClicke-Clear 
	public void Onclicknew_clear_refid() throws IOException, InterruptedException {

		try {

			// click new button
			driver.findElement(By.xpath("(//button[contains(@id,'-btnTblNew')])")).click();

			// ref id displayed or not
			WebElement element = driver.findElement(By.xpath("//span[@class='refId']"));

			String Refid = element.getText();

			if (Refid == null) {

				extent.pass("Reference number cleared");
				result = "Pass";

			}

			else {

				extent.fail("Reference number did not clear : " + Refid,
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}
		}

		catch (Exception e) {

			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

//To Validate mouseHover
	public void mouseHoverClick1(String locatorType, String value) throws IOException, StaleElementReferenceException {
		try {
			By locator;
			locator = locatorValue(locatorType, value);

			WebElement web_Element_To_Be_Hovered = WaitUtil.waitForEleTobeClickble(locator);
			// System.out.println(web_Element_To_Be_Hovered);
			Actions builder = new Actions(driver);

			builder.moveToElement(web_Element_To_Be_Hovered).build().perform();
			// Runtime.getRuntime().exec("C:\\Users\\samyuktha.aj\\Desktop\\Script.exe");
			result = "PASS";
			extent.pass(code);

		} catch (TimeoutException e) {

			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	// Check this option helps the User can view the complete text description
	// available on the field
	public void WarpText() throws IOException, InterruptedException {
		// //String Result = null;
		boolean present;
		try {
			WebElement warptext = driver.findElement(By.xpath("//img[@id='PRQ-addWrap']"));
			// Thread.sleep(2000);
			if (warptext.isEnabled()) {
				click(warptext);
				extent.pass("formname");
				result = "PASS";
			} else {
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}

			// Thread.sleep(2000);
		} catch (Exception e) {
			present = false;
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	// Check the Bread crumb displays the navigation path of the respective Form
	public void Breadcrumb(String moduleSearch) throws IOException, InterruptedException {
		// //String Result = null;
		try {
			// WebElement breadcrumb = driver.findElement(By.xpath(
			// "//span[@class=\"ui-menuitem-link ui-corner-all
			// ui-state-disabled\"]//span[@class=\"ui-menuitem-text\"]"));

			Waitsendkey("id", "nfr_topbar_autocomp1_input", moduleSearch);
			Thread.sleep(2000);
			Waitclick("id", "nfr_topbar_autocomp1_input");
			pageload();
			Waitclick("Xpath", "//SPAN[text()='New']/self::SPAN");
			pageload();
			// paste the xpath by using web element
			WebElement breadcrumb = driver.findElement(By.xpath(
					"//span[@class=\"ui-menuitem-text\"]/parent::span[@class=\"ui-menuitem-link ui-corner-all ui-state-disabled\"]"));
			WebElement header = driver
					.findElement(By.xpath("//div[@class=\"tab_head\"]/child::div[@class=\"pull-left\"]"));
			String a = breadcrumb.getText();
			String b = header.getText();
			if (a.equals(b)) {
				extent.pass("formname");
				result = "PASS";
			} else {
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}
			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	// Check this option helps the User can view the field level description.(Note:
	// User have to map field values in Module Tool Tip Screen)
	public void Tooltip() throws IOException, InterruptedException {
		// //String Result = null;
		boolean present;
		try {
			WebElement tooltip = driver.findElement(By.xpath("//div[@class='checkboxhelp']"));

			if (tooltip.isEnabled()) {
				click(tooltip);
				Thread.sleep(2000);
				click(tooltip);
				Thread.sleep(2000);
				// WebElement c = driver.findElement(By.xpath("//i[@class='fa fa-info-circle
				// info_child']"));
				List<WebElement> l = driver.findElements((By.xpath("//i[@class='fa fa-info-circle info_child']")));
				if (l.size() > 0) {
					extent.pass("formname");
					result = "PASS";
				}

			} else {
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}
			// Thread.sleep(2000);
		} catch (Exception e) {
			present = false;
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	// Vessel Details Bar should display Vessel Name,Vessel
	// Type,Fleet,Flag,Master,C/E and C/O (Names should be combination of First Name
	// and Surname).
	// To Validate VesselDetail
	public void VesselDetailsbar() throws IOException, InterruptedException {
		// //String Result = null;
		try {

			WebElement vessel = driver
					.findElement(By.xpath("//div[@class='tab_content_area']//span[@class='pull-left']"));
			String header = vessel.getText();
			if (header != null) {
				extent.pass("formheader");
				result = "PASS";
			} else {
				extent.fail("Empty", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}
			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

//To Validate Logo
	public void logo() throws IOException {
		// //String Result = null;

		try {

			boolean element = driver.findElement(By.xpath("//*[@id='NFR_macklogo']")).isDisplayed();

			if (element == true) {
				System.out.println("Logo Exists");
				extent.pass("logo :" + element);

			} else {
				extent.fail("Logo does not exist :" + element);
			}

			result = "PASS";
			extent.pass(code);

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

//To validate Module
	public void module(String text) throws IOException {
		try {

			WebElement search = driver.findElement(By.xpath("//input[@id='nfr_topbar_autocomp1_input']"));
			search.sendKeys(text);
			Thread.sleep(2000);
			WebElement web = driver.findElement(By.xpath(
					"//LI[@class='ui-autocomplete-item ui-autocomplete-list-item ui-corner-all ui-state-highlight']/self::LI"));
			if (web.isDisplayed()) {
				System.out.println("Module searched is exist");
				extent.pass("Column prsent in landing page :" + search);
				extent.pass(code);

				result = "PASS";

			}

			else {
				extent.fail("Module searched is not  exist :" + search);
				result = "FAIL";

			}
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			System.out.print("input is not found" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
	}

////To validate Module Notification Bar
	public void notificationbar() throws IOException {
		try {
			{
				boolean download = driver.findElement(By.xpath("//a[@id='nfr_downloadmgr']")).isDisplayed();

				if (download == true) {

					System.out.println("Download button exists");
					extent.pass("download is exist" + download);

				} else {
					System.out.println("Download does not exist");
					extent.fail("Download is not  exist :");
					result = "FAIL";
				}
				boolean chat = driver.findElement(By.xpath("//*[@id=\"Chat_form\"]/i")).isDisplayed();

				if (chat == true) {
					System.out.println("chat exists");
					extent.pass("Chat exists" + chat);

				} else {
					System.out.println("Chat is not exist");
					extent.fail(" Chat is snot  exist :");
					result = "FAIL";
				}
				boolean alerts = driver.findElement(By.xpath("//*[@id='ALE']/i")).isDisplayed();

				if (alerts == true) {
					System.out.println("alert is present");
					extent.pass("alert is present" + alerts);

				} else {
					System.out.println("alert is not present");
					extent.fail("alert is not  exist :");
					result = "FAIL";
				}
				boolean notification = driver.findElement(By.xpath("//*[@id='NFU']/i")).isDisplayed();

				if (notification == true) {

					System.out.println("notification Exist");
					extent.pass("Notification is Exist");

				} else {
					System.out.println("notification is not present");
					extent.fail("Notification is not  exist ");
					result = "FAIL";
				}
				boolean task = driver.findElement(By.xpath("//*[@id='Fk']/i")).isDisplayed();

				if (task == true) {
					System.out.println("task is present");
					extent.pass("task is present");

				} else {
					System.out.println("task is not Exist");
					extent.fail("Task is not  exist ");
					result = "FAIL";
				}
				boolean language = driver.findElement(By.xpath("//*[@id='langnavicon']/a/i")).isDisplayed();

				if (language == true) {
					System.out.println("language Button is present");
					extent.pass("Language is displayed :" + language);

				} else {
					System.out.println("language Button is not present");
				}
			}
		} catch (Exception e) {
			System.out.print("not present" + e);
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}

	}

////To validate Module Download file
	public void downloadfile() throws IOException, InterruptedException {

		try {

			WebElement btnDownload = driver.findElement(By.xpath("//*[@id='nfr_downloadmgr']/i"));

			btnDownload.click();

			if (btnDownload.isSelected()) {
				System.out.println("download is clicked");
				extent.pass(code + "download is clicked");
				result = "PASS";
			} else {

				extent.fail(code + "download is not be clicked");
				result = "PASS";

			}

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
	}

	// To validate chatnotification
	public void chatnotification() throws IOException, InterruptedException {

		try {
			Thread.sleep(5000);
			WebElement chatnotify = driver.findElement(By.xpath("//*[@id='Chat_form']/i"));

			chatnotify.click();
			System.out.println("chatnotify is clicked");
			Thread.sleep(5000);
			WebElement chatviewall = driver.findElement(By.xpath("(//div[@class='notifications-footer'])[2]"));
			chatviewall.click();

			if (chatviewall.isSelected()) {
				System.out.println("chatnotificaion is clicked");
				extent.pass(code + "chatnotification is clicked");
				result = "PASS";
			} else {
				extent.fail(code + "chatnotification is not be clicked");
				result = "PASS";
			}

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
	}

//To Validate Notification
	public void notification() throws IOException, InterruptedException {

		try {
			WebElement notification = driver.findElement(
					By.xpath("//body/div[@id='nfr_layoutwrapper']/div[3]/div[2]/ul[1]/li[5]/a[1]/form[1]/i[1]"));

			notification.click();
			System.out.println("notification is clicked");
			if (notification.isSelected()) {
				System.out.println("notification is clicked");
				extent.pass(code + "notification is clicked");
				result = "PASS";
			} else {
				extent.fail(code + "notification is not be clicked");
			}

			WebElement allnotifications = driver.findElement(
					By.xpath("//body/div[@id='nfr_layoutwrapper']/div[3]/div[2]/ul[1]/li[5]/ul[1]/a[1]/div[1]"));

			allnotifications.click();
			if (allnotifications.isSelected()) {
				System.out.println("notification is clicked");
				extent.pass(code + "notification is clicked");
				result = "PASS";
			} else {
				extent.fail(code + "Allnotification is not be clicked");
			}

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
	}

//To Validate TaskList
	public void tasklist() throws IOException, InterruptedException {

		try {
			WebElement tasklist = driver.findElement(
					By.xpath("//body/div[@id='nfr_layoutwrapper']/div[3]/div[2]/ul[1]/li[4]/a[1]/form[1]/i[1]"));

			tasklist.click();
			if (tasklist.isSelected()) {
				System.out.println("tasklist is clicked");
				extent.pass(code + "tasklist is clicked");
				result = "PASS";

			} else {
				extent.fail(code + "tasklist is not be clicked");
				result = "PASS";

			}

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
	}

	// To Validate languagelist

	public void languagelist() throws IOException {
		try {
			WebElement element = driver.findElement(By.xpath("//li[@id='langnavicon']"));
			element.click();

			Select dropdownlanguage = new Select(element);
			dropdownlanguage.selectByIndex(0);
			Thread.sleep(5000);

			System.out.println("language is clicked and selected english");
			extent.pass(code + "language is clicked and selected english");
			result = "PASS";

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
	}

//To Validate MenuBar
	public void Menubar() throws IOException, InterruptedException {
		// //String Result = null;
		try {

			WebElement element = driver.findElement(By.xpath("//*[@id='nfr_main_menu_model_0']/a"));
			element.click();
			System.out.println("Menubar is navigated");
			result = "PASS";
			extent.pass(code);
		} catch (Exception e) {
			extent.fail(code + " " + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

//To Validate sideBar
	public void sidebar() throws IOException, InterruptedException {
		// //String Result = null;
		try {

			WebElement element = driver.findElement(By.xpath("//div[@class='topbar-right']//a[@id='menu-button']"));
			element.click();

			Thread.sleep(2000);
			element.click();
			System.out.println("sidebar is toggled");
			result = "PASS";
			extent.pass(code);
		} catch (Exception e) {
			extent.fail(code + " " + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

//To Validate Myprofile
	public void myprofile() throws IOException, InterruptedException {
		// //String Result = null;
		try {

			WebElement element = driver.findElement(By.xpath("//ul[@class='user_name']//li[1]"));
			element.click();
			Thread.sleep(2000);
			WebElement element1 = driver.findElement(By
					.xpath("//div[@class='pull-left']//a[@class='ui-commandlink ui-widget btn btn-default btn-flat']"));
			element1.click();
			System.out.println("profile is opened");
			result = "PASS";
			extent.pass(code);
		} catch (Exception e) {
			extent.fail(code + " " + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}
	// To Validate LogOut

	public void logout() throws IOException, InterruptedException {
		// //String Result = null;
		try {

			WebElement element = driver.findElement(By.xpath("//li[@class='nav_profile']"));
			element.click();
			Thread.sleep(4000);
			WebElement element1 = driver.findElement(By.xpath(
					"//div[@class='pull-right']//a[@class='ui-commandlink ui-widget btn btn-default btn-flat']"));
			element1.click();
			System.out.println("profile is opened");
			result = "PASS";
			extent.pass(code);
		} catch (Exception e) {
			extent.fail(code + " " + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}
	// To Validate ALeart

	public void Aleart() throws IOException {
		// //String Result = null;

		try {

			WebElement e1 = driver.findElement(
					By.xpath("//a[@class='ui-commandlink ui-widget']//form[@id='ALE']//span[@id='ALE-alert_counts']"));

			String s = e1.getText();
			int i = Integer.parseInt(s);

			if (i > 0) {
				System.out.println("Alerts exists");

				result = "PASS";
				extent.pass(code + "Aleart Exists");
				// Thread.sleep(2000);
			}

			else {
				System.out.println("Aleart does not exists ");
				extent.fail(code + "Aleart not Exist");
			}
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	/// To Validate delete Template

	public void delettemplate() throws IOException {

		try {

			WebElement e1 = driver.findElement(By.xpath("//*[@id='PRQ_LND_datagrid_cmbTemplate']/li[2]/i[2]"));
			e1.click();

			Boolean element = driver.findElement(By.xpath("//*[@id=\"PRQ_LND_datagrid_cmbTemplate\"]/li[2]"))
					.isDisplayed();

			if (element == true) {
				System.out.println("Template is not deleted");

				result = "PASS";
				extent.pass(code + "Template is not be deleted");
			}

			else {
				System.out.println("Template is deleted");
				extent.fail(code + "Template is deleted");
			}
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

//To VALIDATE Multiplefilter_NotPresent
	public void Multiplefilter_NotPresent() throws IOException, InterruptedException {
		// //String Result = null;

		boolean Multiplefilter;
		try {
			driver.findElement(By.xpath("//div[@class='nfr_toolpanel_li_icon']")).click();
			Thread.sleep(2000);
			WebElement multiplefilter = driver
					.findElement(By.xpath("//a[@class='sm-dt-toolpanel-link sm-dt-toolpanel-multiple']"));

			if (multiplefilter.isEnabled()) {
				extent.pass("Multiplefilter Enable");
				result = "PASS";
			} else {
				extent.fail(code + "MultiFilter is not Enable ");
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}
		} catch (Exception e) {
			Multiplefilter = false;
			extent.fail("Multiplefilter Disable", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

//To Validate Reset_Button(
	public void Reset_Button() throws IOException, InterruptedException {
		// //String Result = null;

		boolean Reset;
		try {
			driver.findElement(By.xpath("//div[@class='nfr_toolpanel_li_icon']")).click();
			Thread.sleep(2000);

			WebElement reset = driver.findElement(By.xpath("//button[contains(@class,'sm-dt-toolpanel-reset')]"));

			if (reset.isEnabled()) {
				extent.pass("Reset Enable");
				result = "PASS";
			} else {
				extent.pass("Reset is not Enable");
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}

		} catch (Exception e) {
			Reset = false;
			extent.fail("Reset Disable", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

// To Validate Excel Button
	public void Excel_Button() throws IOException, InterruptedException {
		// //String Result = null;

		boolean Excel;
		try {
			driver.findElement(By.xpath("//div[@class='nfr_toolpanel_li_icon']")).click();
			pageload();
			// WebElement excel = driver.findElement(By.xpath("//span[text()='Excel']"));
			// click(excel);
			mouseHoverClick("xpath", "//img[@alt='Excel']");

			Thread.sleep(2000);
			WebElement excel = driver.findElement(By.xpath("//img[@alt='Excel']"));
			if (excel.isDisplayed()) {
				extent.pass("Excel Dispalyed");
				result = "PASS";
			} else {
				extent.fail("Excel is not Dispalyed");
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}
		} catch (Exception e) {
			extent.fail("Excel Disable", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

//To Validate CSV_Button
	public void CSV_Button() throws IOException, InterruptedException {
		// //String Result = null;

		boolean csv;
		try {
			driver.findElement(By.xpath("//div[@class='nfr_toolpanel_li_icon']")).click();
			pageload();
			WebElement csv1 = driver.findElement(By.xpath("//img[@alt='CSV']"));
			click(csv1);
			Thread.sleep(2000);
			if (csv1.isSelected()) {
				extent.pass("CSV is Selected");
				result = "PASS";
			} else {
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}
		} catch (Exception e) {

			extent.fail("CSV Disable", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

//To Validate  Fullscreen_Button
	public void Fullscreen_Button() throws IOException, InterruptedException {
		// //String Result = null;

		boolean Fullscreen;
		try {
			driver.findElement(By.xpath("//div[@class='nfr_toolpanel_li_icon']")).click();
			pageload();

			mouseHoverClick("xpath", "//img[@alt='Fullscreen']");
			WebElement fullscreen = driver.findElement(By.xpath("//img[@alt='Fullscreen']"));
			Thread.sleep(3000);
			if (fullscreen.isSelected()) {
				extent.pass("Fullscreen is Viewed");
				result = "PASS";
			} else {
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}
		} catch (Exception e) {

			extent.fail("Fullscreen Disable", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

//To Validate officeUse 
	public void Officeuse() throws IOException, InterruptedException {
		// //String Result = null;

		try {
			WebElement attach = driver.findElement(By.xpath("//a[text()='General Attachments']"));
			click(attach);
			Thread.sleep(2000);
			scrollDown();
			Thread.sleep(2000);
			WebElement office = driver.findElement(By.xpath("//div[@class='for_office']"));
			// String c = office.getText();
			if (office.isDisplayed()) {
				extent.pass("Office  Present");
				result = "PASS";
			} else {
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}
		} catch (Exception e) {
			extent.fail("Office Use Not Present", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

//To Validate Short Form
	public void Shortform() throws IOException, InterruptedException {
		// //String Result = null;
		try {

			// WebElement click =
			// driver.findElement(By.xpath("//div[@class='nfr_toolpanel_li_icon']/img"));

			// click(click);

			Thread.sleep(2000);

			List<WebElement> Header = driver.findElements(By.xpath("//div[@class='ag-header-viewport']"));

			for (int i = 1; i < Header.size(); i++) {

				String pull = Header.get(i).getText();
				if (pull.contains(".")) {
					System.out.println(Header.get(i));
					extent.pass(code + " be Selected");

				} else {
					extent.fail(code + "not be Selected");
				}

			}

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

//To Validate AutoSizeColoumn
	public void AutoSizecolo() throws IOException, InterruptedException {
		// //String Result = null;
		try {

			/*
			 * WebElement click =
			 * driver.findElement(By.xpath("//div[@class='nfr_toolpanel_li_icon']/img"));
			 * 
			 * click(click);
			 * 
			 * Thread.sleep(2000);
			 * 
			 * WebElement Distinct =
			 * driver.findElement(By.xpath("//span[text()='Distinct Filter']"));
			 * 
			 * if (Distinct.isEnabled()) {
			 * 
			 * click(Distinct);
			 * 
			 * Thread.sleep(2000); }
			 */

			Thread.sleep(2000);

			driver.findElement(By.xpath("(//span[contains(@class,'ag-icon ag-icon-menu')])[2]")).click();
			Thread.sleep(2000);

			driver.findElement(By.xpath("//span[text()='Autosize This Column']")).click();
			Thread.sleep(2000);

			extent.pass("Selected");
			result = "PASS";

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}
	// To Validate AutoSize coloumn

	public void AutoSizeFullCloumns() throws IOException, InterruptedException {
		// //String Result = null;
		try {

			/*
			 * WebElement click =
			 * driver.findElement(By.xpath("//div[@class='nfr_toolpanel_li_icon']/img"));
			 * 
			 * click(click);
			 * 
			 * Thread.sleep(2000);
			 * 
			 * WebElement Distinct =
			 * driver.findElement(By.xpath("//span[text()='Distinct Filter']"));
			 * 
			 * if (Distinct.isEnabled()) {
			 * 
			 * click(Distinct);
			 * 
			 * Thread.sleep(2000); }
			 */

			Thread.sleep(2000);

			driver.findElement(By.xpath("(//span[contains(@class,'ag-icon ag-icon-menu')])[2]")).click();

			Thread.sleep(2000);
			WebElement autoAllSize = driver.findElement(By.xpath("//span[text()='Autosize All Columns']"));
			autoAllSize.click();

			extent.pass(code + "Selected");
			result = "PASS";

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

//Used for validating whether the no pin is present or not
	public void noPin(String TestData) throws IOException, InterruptedException {
		// //String Result = null;
		try {
			Thread.sleep(5000);

			Waitsendkey("xpath", "//span[contains(@id,'nfr_topbar_autocomp')]", TestData);

			Thread.sleep(2000);

			Waitclick("xpath", "//span[contains(@id,'nfr_topbar_autocomp')]");

			pageload();

			WebElement click = driver.findElement(By
					.xpath("(//span[contains(@id,'_LND_datagrid_records_pnl')])/div[@class='nfr_toolpanel_li_icon']"));

			click(click);

			Thread.sleep(2000);

			WebElement Distinct = driver.findElement(By.xpath("//span[text()='Distinct Filter']"));

			if (Distinct.isEnabled()) {

				click(Distinct);
				System.out.println(Distinct);

				Thread.sleep(2000);
			}

			driver.findElement(By.xpath("(//span[contains(@class,'ag-icon ag-icon-menu')])[2]")).click();

			Thread.sleep(2000);

			mouseHoverClick("xpath", "//span[text()='Pin Column']");

			Thread.sleep(2000);

			Waitclick("xpath", "//span[text()='No Pin']");
			Thread.sleep(2000);

			WebElement noPin = driver.findElement(By.xpath("//span[text()='No Pin']"));

			click(noPin);

			if (noPin.isSelected()) {
				System.out.println("No pin exists");

				result = "PASS";
				extent.pass(code + "No pin Exists");
				// Thread.sleep(2000);
			}

			else {
				System.out.println("Nopin does not exists ");
				extent.fail(code + "Does not exists");
			}
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	/*
	 * if (noPin.isSelected()) {
	 * extent.pass("  system Pins the selected column to left"); result = "PASS";
	 * 
	 * } else {
	 * 
	 * extent.fail("column did not move",
	 * MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
	 * 
	 * result = "<a href=" + ScreenShot() + "> FAIL</a>";
	 * 
	 * }
	 * 
	 * } catch (Exception e) { extent.fail(code + " " + e.getMessage(),
	 * MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
	 * Log.error("EXCEPTION DESCRIPTION=====>" + e.getMessage()); result =
	 * "<a href=" + ScreenShot() + "> FAIL</a>"; } data.add(result);
	 * anotherMethod(result, data); }
	 */

	// To validate reset row
	public void reSetRow() throws IOException, InterruptedException {
		// //String Result = null;
		try {

			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span[contains(@class,'ag-icon ag-icon-menu')])[2]")).click();

			Thread.sleep(2000);

			mouseHoverClick("xpath", "//span[text()='Reset Columns']");

			Thread.sleep(2000);

			// display

			WebElement reset = driver.findElement(By.xpath("//span[text()='Drag here to set row groups']"));
			reset.click();

			if (reset.isSelected()) {

				extent.pass("Reset exist");
				result = "PASS";

			} else {

				extent.fail("Reset does not exist",
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}

			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	// To validate pinright(Mack Standards and procedures methods)

	public void RightToLeft() throws IOException, InterruptedException {
		// //String Result = null;
		try {

			WebElement click = driver.findElement(By.xpath("//div[@class='nfr_toolpanel_li_icon']/img"));

			click(click);

			Thread.sleep(2000);

			WebElement Distinct = driver.findElement(By.xpath("//span[text()='Distinct Filter']"));

			if (Distinct.isEnabled()) {

				click(Distinct);
				System.out.println(Distinct + "Distinct filter exist");
				Thread.sleep(2000);
			}

			List<WebElement> afterOrder = driver
					.findElements(By.xpath("//*[@id='PRQ_LND_datagrid_tbl']/div/div[2]/div[1]/div[1]/div[2]"));

			driver.findElement(By.xpath("(//span[contains(@class,'ag-icon ag-icon-menu')])[2]")).click();
			Thread.sleep(2000);

			mouseHoverClick("xpath", "//span[text()='Pin Column']");
			Thread.sleep(2000);

			Waitclick("xpath", "//span[text()='Pin Right']");

			Thread.sleep(2000);

			List<WebElement> beforeOrder = driver
					.findElements(By.xpath("//*[@id=\"PRQ_LND_datagrid_tbl\"]/div/div[2]/div[1]/div[1]"));
			int beforeCount = 0;
			int afterCount = 0;
			for (WebElement webElement : beforeOrder) {
				if (webElement.getText().equals("Action")) {
					break;
				}
				beforeCount++;

			}
			for (WebElement webElement : afterOrder) {
				if (webElement.getText().equals("Action")) {
					break;
				}
				afterCount++;

			}
			if (beforeCount < afterCount) {

				extent.pass("  system Pins the selected column to left");
				result = "PASS";

			} else {

				extent.fail("column did not move",
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

//To Validate taskLog
	public void taskLog() throws IOException, InterruptedException {
		// //String Result = null;
		try {

			click("xpath", "(//span[@class='ui-button-icon-left ui-icon ui-c fa-landPg-eye'])[1]");
			pageload();

			click("xpath", "(//span[contains(@id,'-sideBarGroup')]/div/div)[2]/i");
			Thread.sleep(2000);

			// task Menu
			WebElement taskMenu = driver.findElement(By.xpath("//*[contains(@id,'-tblutil-tlg_commonComp')]"));
			click(taskMenu);

			Thread.sleep(2000);
			List<WebElement> header = driver.findElements(By.xpath(
					"//div[@id='PMA-tblutil-TLG_PMATaskLogWindow-PMA_tasklog']/div/div[1]/table/thead/tr/th/span"));
			List<WebElement> footer = driver.findElements(
					By.xpath("//*[@id=\"PMA-tblutil-TLG_PMATaskLogWindow-PMA_tasklog\"]/div[2]/table/tbody/tr/td"));

			for (int i = 1; i < header.size(); i++) {
				String columnHeader = header.get(i).getText();
				if (columnHeader == "Task name") {
					String tn = footer.get(i).getText();
					if (tn.contains("practice")) {

						extent.pass("Task name is matching");
						result = "PASS";
					} else {

						extent.fail("Task name is notatching");
						result = "PASS";

					}
					if (columnHeader == " Task Description") {
						if (tn.contains("practice work")) {
							extent.pass("Task description is matching");
							result = "PASS";

						} else {

							extent.fail("Task description is not matching");
							result = "PASS";
						}
					}
					if (columnHeader == " Priority") {
						if (tn.contains("very high")) {

							extent.pass("Task description is matching");
							result = "PASS";
						} else {
							extent.fail("Task description is not matching");

						}
					}
					if (columnHeader == "Target Date") {
						if (tn.contains("25-05-2021 00:00")) {
							extent.pass("Target date is matching");
							result = "PASS";
						} else {
							extent.fail("Target date is not matching");

						}
					}
					if (columnHeader == "Assigned To") {
						if (tn.contains("PROCTESTER PROCTESTER")) {
							extent.pass("Assignee is matching");
							result = "PASS";
						} else {
							extent.pass("Assignee is not matching");

							// result = "<a href=" + ScreenShot() + "> FAIL</a>";
						}
					}

				}

			}
			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

//To Validate Task
	public void Task() throws IOException, InterruptedException {

		try {

			click("xpath", "(//span[@class='ui-button-icon-left ui-icon ui-c fa-landPg-eye'])[1]");
			pageload();
			click("xpath", "(//span[@id='PMA-sideBarGroup']/div/div)[2]/i");
			Thread.sleep(2000);
			WebElement taskLogo = driver.findElement(By.xpath("//a[contains(@id,'PMA-tblutil-ctn_common')]"));
			javaScriptClick(taskLogo);
			WaitUtil.waitForElementsTobevisible(By.xpath("//span[text()='Create Task and Notification']"));
			Thread.sleep(2000);
			click("xpath", "(//div[@id='PMA-tblutil-CTN_PMAWindow-CTN_tasktype']/div)[2]/following::label");
			Thread.sleep(2000);
			click("xpath", "(//ul[contains(@id,'PMA-tblutil-CTN_PMAWindow-CTN')]/li)[2]");
			Thread.sleep(2000);
			sendkey("xpath", "//input[contains(@id,'PMA-tblutil-CTN_PMAWindow-CTN_taskName')]", "practice");
			Thread.sleep(2000);
			sendkey("xpath", "//textarea[contains(@id,'PMA-tblutil-CTN_PMAWindow-CTN_taskdescription')]",
					"practice work");
			Thread.sleep(3000);
			click("xpath", "(//div[contains(@id,'PMA-tblutil-CTN_PMAWind')])[11]");
			Thread.sleep(3000);
			click("xpath", "(//ul[@id='PMA-tblutil-CTN_PMAWindow-CTN_priority_items']/li)[3]");
			Thread.sleep(2000); // calender
			WebElement calender = driver.findElement(By.xpath("(//button[@aria-label='Show Calendar'])[2]"));
			javaScriptClick(calender);
			Thread.sleep(2000);

			click("xpath", "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[4]/a");
			scrollDown();

			// select assigneee
			WebElement selectAssignee = driver.findElement(By.xpath("//span[contains(text(),'Select Assignee')]"));
			javaScriptClick(selectAssignee);

			WaitUtil.waitForElementsTobevisible(By.xpath("//div[contains(text(),'PROCTESTER')]"));
			click("xpath", "//div[contains(text(),'PROCTESTER')]");
			Thread.sleep(2000);
			click("xpath", "//*[@id='multicol_okbtn']");

			WebElement submit = driver.findElement(By.xpath("//*[@id='PMA-tblutil-CTN_PMAWindow-j_idt8218']"));
			javaScriptClick(submit);

			extent.pass(" Task is Filled");
			result = "PASS";

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

// To Validate  DistinctfiltersIcon
	public void distinctFilterSelectIcon() throws IOException, InterruptedException {

		// //String Result = null;
		try {
			// Requistion tools

			driver.findElement(By.xpath("//div[contains(@class,'nfr_toolpanel_li_icon')]")).click();

			Thread.sleep(2000);
			WebElement click = driver.findElement(By.xpath("//div[@class='nfr_toolpanel_li_icon']/img"));

			click(click);

			Thread.sleep(2000);

			WebElement Distinct = driver.findElement(By.xpath("//span[text()='Distinct Filter']"));

			if (Distinct.isEnabled()) {

				click(Distinct);

				Thread.sleep(2000);
			}

			Thread.sleep(2000);

			driver.findElement(By.xpath("//span[@class='ag-iconag-icon-columns']")).click();
			Thread.sleep(2000);

			// WebElement coloumn =
			// driver.findElement(By.xpath("//div[@class='ag-column-panel']"));

			extent.pass(" Displayed ");
			result = "PASS";

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

//To validate DistinctGroupBy
	public void DistinctGroupBy() throws IOException, InterruptedException {
		// //String Result = null;

		boolean GroupBy;
		try {
//requistion 

			WebElement click = driver
					.findElement(By.xpath("(//span[@id='PRQ_LND_datagrid_records_pnl'])/div/following-sibling::img"));

			click(click);

			Thread.sleep(2000);

			WebElement Distinct = driver.findElement(By.xpath("//span[text()='Distinct Filter']"));

			if (Distinct.isEnabled()) {

				click(Distinct);
				System.out.println(Distinct + "is Enabled Distinct");
				Thread.sleep(2000);
			}

			Thread.sleep(2000);

			driver.findElement(By.xpath("(//span[contains(@class,'ag-icon ag-icon-menu')])[2]")).click();

			Thread.sleep(2000);
			Waitclick("xpath", "//span[text()='Group by Requisition Unique Ref']");

			Thread.sleep(2000);
			WebElement GroupBy1 = driver.findElement(By.xpath("//span[text()='Group by Requisition Unique Ref']"));

			if (GroupBy1.isDisplayed()) {

				extent.pass(" Displayed");
				result = "PASS";

			} else {
				extent.fail("not Displayed", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void Spelling1() throws IOException {
		try {
			List<WebElement> text = driver.findElements(By.xpath("//html"));
			for (int i = 0; i < text.size(); i++) {
				String value2 = text.get(i).getText();

				if (value2.equalsIgnoreCase(text.get(i).getText())) {
					extent.pass("First letter in uppercase" + value2);
					System.out.println(value2 + "spell");
					result = "PASS";
				} else {

					extent.fail("First letter not in uppercase" + value2,
							MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
					result = "<a href=" + ScreenShot() + "> FAIL</a>";
				}
			}
		}

		// Thread.sleep(2000);
		catch (Exception e) {
			extent.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void exportPdf1() throws IOException, InterruptedException {
		// //String Result = null;
		try {

			// external inspection

			driver.findElement(By.xpath("//SPAN[text()='New']/self::SPAN")).click();

			pageload();

			click("xpath", "(//span[@id='PMA-sideBarGroup']/div/div)[2]/i");
			Thread.sleep(2000);

			WebElement pdfButton = driver.findElement(By.xpath("//i[contains(@class,'fa fa-file-pdf-o')]"));
			click(pdfButton);

			pageload();

			if (pdfButton.isSelected()) {

				extent.pass(" system Pins the selected column to left");
				result = "PASS";

			}

			else {
				extent.fail("column did not move",
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void refresh() throws IOException, InterruptedException {
		try {

			driver.get("https://socstageship1.solverminds.net/main");

			driver.navigate().refresh();

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void implicit() throws IOException, InterruptedException {
		// //String Result = null;
		try {

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

//To ValidateExport Excel
	public void exportExcel() throws IOException, InterruptedException {
		// //String Result = null;
		try {
//requistion

			click("xpath", "(//span[contains(@id,'-sideBarGroup')]/div/div)[2]/i");
			Thread.sleep(2000);

			driver.findElement(By.xpath("//i[@class='fa fa-file-excel-o']")).click();

			Thread.sleep(2000);

			driver.findElement(By.xpath("//a[contains(@id,'nfr_downloadmgr')]")).click();

			Thread.sleep(2000);

			boolean download = driver.findElement(By.xpath("(//*[@id=\"nfr_form_dm\"]/table)[2]")).isDisplayed();

			if (download == true) {

				extent.pass("excel is Downloaded");
				result = "PASS";

			} else {

				extent.fail("Not be Downloaded", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void colorChecker(String locatorType, String value, String text) throws IOException, InterruptedException {
		// //String Result = null;
		try {
			By locator;
			locator = locatorValue(locatorType, value);

			WebElement color1 = driver.findElement(locator);

			String cssValue = color1.getCssValue("background-color");

			String asHex = Color.fromString(cssValue).asHex();

			assertEquals(cssValue, asHex);

			System.out.println("Color is Validated " + asHex);

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

	public void userName() throws InterruptedException, IOException {
		try {

			sendkey("xpath", "(//input[contains(@class,'ag-floating-filter-input')])[3]", "office");

			Thread.sleep(7000);

			driver.findElement(By.xpath("(//span[contains(@class,'ui-button-icon-left ui-icon ui-c fa fa-exter')])[1]"))
					.click();

			Thread.sleep(8000);
			// Thread.sleep(8000);
			newtab("1");
			Thread.sleep(8000);

			String firstName = driver.findElement(By.xpath("//label[text()='First Name']/following-sibling::input"))
					.getAttribute("value");
			System.out.println(firstName);

			Thread.sleep(8000);
			String lastName = driver.findElement(By.xpath("//label[text()='Last Name ']/following-sibling::input"))
					.getAttribute("value");
			System.out.println(lastName);

			String userId = firstName + " " + lastName;

			System.out.println(userId);

			WebElement LL = driver.findElement(By.xpath("//h5[text()='Vessel Mapping']"));
			javaScriptClick(LL);
			Thread.sleep(4000);

			newtab("2");
			Thread.sleep(4000);

			String login = driver.findElement(By.cssSelector("input#VLM-VLM_empcode")).getAttribute("value");
			System.out.println(login);

			if (userId.equals(login)) {
				System.out.println("Matching ");
			}

			result = "PASS";
			extent.pass(code);

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

//To Valiadate Chat Button
	public void Chat() throws IOException, InterruptedException {
		// //String Result = null;
		try {

			click("xpath", "(//span[@class='ui-button-icon-left ui-icon ui-c fa-landPg-eye'])[1]");
			pageload();
			click("xpath", "(//span[contains(@id,'-sideBarGroup')]/div/div)[2]/i");
			Thread.sleep(2000);
			click("xpath", "//a[contains(@id,'-tblutil-cwc_commonComp')]");
			Thread.sleep(2000);
			Waitsendkey("xpath", "//input[contains(@id,'Window-CWC_message')]", "hello");
			Thread.sleep(2000);
			click("xpath", "//button[contains(@id,'Window-CWC')]");
			Thread.sleep(2000);
			List<WebElement> msg = driver.findElements(By.xpath("//div[@id='cwc_scrollmsg']"));

			for (int i = 1; i <= msg.size(); i++) {
				// WebElement msgList =
				// driver.findElement(By.xpath("(//div[@id='cwc_scrollmsg'])[" + i + "]"));
				String text = msg.get(i).getText();
				if (text.contains("hello")) {
					extent.pass("chat is working");
					result = "PASS";

				} else {

					extent.fail(code + "Chat is not Working",
							MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
					result = "<a href=" + ScreenShot() + "> FAIL</a>";

				}
			}

			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

//refer
	public void screenShot() throws IOException, InterruptedException {
		// //String Result = null;
		try {

			WebElement e = driver.findElement(By.xpath("(//img[@class='carousel-images'])[2]"));

			// TakesScreenshot tk = ((TakesScreenshot) driver);

			File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			File Save = new File("D:\\screenshot\\img1.png");

			FileHandler.copy(f, Save);

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void scrolll() throws IOException, InterruptedException {
		// //String Result = null;
		try {

			EventFiringWebDriver event = new EventFiringWebDriver(driver);

			event.executeScript(
					"document.querySelector('#OEI-OEI_InputDlg>.ui-dialog-content.ui-widget-content').scrollTop=500");

		}

		catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}// To Vlaidate Landing Page-DefaultDate//

	public void scrolllright() throws IOException, InterruptedException {
		// //String Result = null;
		try {

			EventFiringWebDriver event = new EventFiringWebDriver(driver);

			event.executeScript("document.querySelector('div.ag-body-horizontal-scroll-viewport').scrollLeft=750");

		}

		catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}// To Vlaidate Landing Page-DefaultDate//

	public void LandingPae_DefaultDate() throws IOException, InterruptedException {
		// //String Result = null;
		try {

			String ar = driver.findElement(By.xpath("//div[@id='reportrange']")).getText();
			String[] Date = ar.split(" - ");
			System.out.println("ASk" + ar);
			Thread.sleep(2000);
			String FromDate1 = Date[0];
			Date FromDate = new SimpleDateFormat("dd/MM/yyyy").parse(FromDate1);
			Thread.sleep(2000);
			String ToDate1 = Date[1];
			Date ToDate = new SimpleDateFormat("dd/MM/yyyy").parse(ToDate1);

			long DiffDate = ToDate.getTime() - FromDate.getTime();
			Thread.sleep(2000);
			int diffDays = (int) (DiffDate / (24 * 60 * 60 * 1000));
			System.out.println(diffDays);

			if (diffDays == 90) {
				System.out.println(diffDays);
				extent.pass("Unit displayed");
				result = "PASS";

			} else if (diffDays < 90 || diffDays > 90) {

				extent.fail(code + "ask", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}

			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

//To Validate Pivot
	public void Pivot() throws IOException, InterruptedException {
		// //String Result = null;
		boolean present;
		try {

			WebElement pivotButton = driver.findElement(By.xpath("//div[@class='ag-side-buttons']"));
			click(pivotButton);
			if (pivotButton.isDisplayed()) {
				extent.pass("Filter found in landing page");
				result = "PASS";
			}
			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

//To Validate Filter Landing Page
	public void Filter_LandingPage() throws IOException, InterruptedException {
		// //String Result = null;
		boolean present;
		try {
			driver.findElement(By.xpath("(//div[@class='ag-header-row'])[4]"));
			present = true;
			extent.pass("Filter found in landing page");
			result = "PASS";
			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

//To Validate Standard Filter
	public void Standarad_Filter() throws IOException, InterruptedException {
		// //String Result = null;
		try {
			Thread.sleep(9000);
			String GroupName = driver.findElement(By.xpath("//div[@id='nfr-report-title0']//label")).getText();
			System.out.println(GroupName);
			String Company = driver.findElement(By.xpath("//div[@id='nfr-report-title1']//label")).getText();
			System.out.println(Company);
			String Fleet = driver.findElement(By.xpath("//div[@id='nfr-report-title2']//label")).getText();
			System.out.println(Fleet);
			String Vessal = driver.findElement(By.xpath("//div[@id='nfr-report-title3']//label")).getText();
			System.out.println(Vessal);
			String VessalType = driver.findElement(By.xpath("//div[@id='nfr-report-title4']//label")).getText();
			System.out.println(VessalType);
			String VesselClass = driver.findElement(By.xpath("//div[@id='nfr-report-title6']//label")).getText();
			System.out.println(VesselClass);
			String VesselFlag = driver.findElement(By.xpath("//div[@id='nfr-report-title7']//label")).getText();
			System.out.println(VesselFlag);

			if (GroupName.equals("Group") && Company.equals("Company") && Fleet.equals("Fleet")
					&& Vessal.equals("Vessel") && VessalType.equals("Vessel Type") && VesselClass.equals("Vessel Class")
					&& VesselFlag.equals("Vessel Flag")) {
				extent.pass("Filter present");
			} else {

				extent.fail("Filter Not Present", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}
			driver.close();

			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

//To Validate Sorting
	public void sorting1() throws IOException {

		try {

			Boolean element = driver.findElement(By.xpath(
					"//div[@id='CRP-schedule_container']//button[@class='fc-month-button ui-button ui-state-default ui-corner-left ui-state-active']"))
					.isEnabled();

			if (element == true) {
				System.out.println("Sorted by monthly basis");

				result = "PASS";
				extent.pass(code);
			}

			else {
				System.out.println("Not sorted by monthly basis");
				extent.fail(code + "Not saved");

			}
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

//To Validate Alphabetic order
	public void Alphabetic_Order(String locatorType, String value) throws IOException {
		try {

			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);

			// WebElement element =
			// driver.findElement(By.id("DMS_SubmitOLPanelform-DMS_cmbDocType_items"));
			List<WebElement> options = element.findElements(By.xpath(value));

			ArrayList<String> list = new ArrayList<String>();

			for (int n = 0; n < options.size(); n++) {
				String menu = options.get(n).getText();
				list.add(menu);
			}

			boolean isSorted = Ordering.from(String.CASE_INSENSITIVE_ORDER).isOrdered(list);

			if (isSorted) {
				extent.pass("Text are arrange in AlphabetOrder");
				result = "PASS";

			} else {
				extent.fail("Not in alphabet Order",
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}
			driver.close();

			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);

	}

//To Validate ShipShore Coloumn Name
	public void Shipshorecolumnname() throws IOException, InterruptedException {
		// //String Result = null;
		try {
			String companyname1 = driver.findElement(By
					.xpath("(//div[@class='ag-cell ag-cell-not-inline-editing ag-cell-with-height ag-cell-value'])[3]"))
					.getText();
			String fleetname1 = driver.findElement(By
					.xpath("(//div[@class='ag-cell ag-cell-not-inline-editing ag-cell-with-height ag-cell-value'])[4]"))
					.getText();
			String vesname1 = driver.findElement(By
					.xpath("(//div[@class='ag-cell ag-cell-not-inline-editing ag-cell-with-height ag-cell-value'])[5]"))
					.getText();
			String vessaltypename1 = driver.findElement(By
					.xpath("(//div[@class='ag-cell ag-cell-not-inline-editing ag-cell-with-height ag-cell-value'])[6]"))
					.getText();
			String flag1 = driver
					.findElement(By.xpath(
							"//*[@id=\"CSY_chart1_grid\"]/div/div[2]/div[1]/div[3]/div[2]/div/div/div[21]/div[5]"))
					.getText();
			Thread.sleep(2000);
			if (companyname1 == companyname && fleetname1 == fleetname && fleetname1 == fleetname && vesname1 == vesname
					&& flag1 == flag) {
				extent.pass(companyname1 + fleetname1 + vesname1 + vessaltypename1 + flag1 + "match" + companyname
						+ fleetname + vesname + vessaltypename + flag);
				result = "PASS";
			} else {
				result = "<a href=" + ScreenShot() + "> FAIL</a>";
				extent.fail(companyname1 + fleetname1 + vesname1 + vessaltypename1 + flag1 + "Notmatch" + companyname
						+ fleetname + vesname + vessaltypename + flag);
			}
			driver.close();

			Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

//To Validate Vessel master
	public void VesselMaster() throws IOException, InterruptedException {
		// //String Result = null;
		try {

			companyname = driver.findElement(By.xpath("//label[@id='SPS-SPS_mgmtcompany_label']")).getText();
			fleetname = driver.findElement(By.xpath("//input[@id='SPS-SPS_fleet']")).getText();
			vesname = driver.findElement(By.xpath("//input[@id='SPS-SPS_vesselname']")).getAttribute("value");
			vessaltypename = driver.findElement(By.xpath("//label[@id='SPS-SPS_vesseltype_label']")).getText();
			flag = driver.findElement(By.xpath("//label[@id='SPS-SPS_flag_label']")).getText();

			extent.pass(code + " VesselMaster.pass");

			driver.close();

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

	/*
	 * public void RefNo_Copy(String locatorType, String value) throws IOException {
	 * try { By locator; locator = locatorValue(locatorType, value); WebElement
	 * element = WaitUtil.fluentWait(locator);
	 * 
	 * RefNo_Copy = element.getAttribute("value"); if (RefNo_Copy == null) {
	 * RefNo_Copy = element.getText(); int len = RefNo_Copy.length(); RefNo_Copy =
	 * RefNo_Copy.substring(11, len - 3);
	 * 
	 * System.out.println(RefNo_Copy);
	 * 
	 * result = "PASS"; extent.pass(code); } else { int len = RefNo_Copy.length();
	 * RefNo_Copy = RefNo_Copy.substring(11, len - 3);
	 * 
	 * System.out.println(RefNo_Copy);
	 * 
	 * result = "PASS"; extent.pass(code); } } catch (Exception e) {
	 * extent.fail(code + e.getMessage(),
	 * MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
	 * Log.error("EXCEPTION DESCRIPTION=====>" + e); result = "<a href=" +
	 * ScreenShot() + "> FAIL</a>"; } data.add(result); anotherMethod(result, data);
	 * }
	 * 
	 */// To Validate Form Number

	public void attach(String locatorType, String value, String text) throws InterruptedException, IOException {
		try {

			By locator;

			locator = locatorValue(locatorType, value);
			Robot k = new Robot();

			WebElement e = driver.findElement(locator);

			e.click();

			// time load
			k.setAutoDelay(2000);

			// to Select File from desktop

			StringSelection file = new StringSelection(text);

			// To copy the file and paste simliar like ctr c + ctr v by using toolkit
			// function
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);

			k.setAutoDelay(4000);

			// control c+ control v
			k.keyPress(KeyEvent.VK_CONTROL);

			k.keyPress(KeyEvent.VK_V);

			// release control c + control v
			k.keyRelease(KeyEvent.VK_CONTROL);
			k.keyRelease(KeyEvent.VK_V);

			// timeload
			k.setAutoDelay(4000);

			// enter open button after selecting file
			k.keyPress(KeyEvent.VK_ENTER);
			// release
			k.keyRelease(KeyEvent.VK_ENTER);

			k.setAutoDelay(4000);

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";
		}
		data.add(result);
		anotherMethod(result, data);
	}

	public void formNumber() throws IOException, InterruptedException {
		// //String Result = null;

		try {

			// external inspection

			driver.findElement(By.xpath("//span[text()='New']/self::span")).click();

			Thread.sleep(2000);

			scrollDown();

			Thread.sleep(2000);

			Boolean noVisible = driver.findElement(By.xpath("(//span[@class='pull-right'])[2]")).isDisplayed();

			if (noVisible == true) {

				extent.pass(" Visible");
				result = "PASS";
			} else {

				extent.fail("not visible", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}
			driver.close();

			// Thread.sleep(2000);
		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);
	}

//To Validate Management
	public void management() throws IOException, InterruptedException {
		// //String Result = null;
		try {

			click("xpath", "(//span[contains(@id,'-sideBarGroup')]/div/div)[2]/i");
			Thread.sleep(2000);

			driver.findElement(By.xpath("//i[@class='fa fa-thumbs-o-up']")).click();
			Thread.sleep(2000);

			scrollDownCertainPoint();
			// title
			Waitsendkey("xpath", "//textarea[contains(@id,'SystemImprovementWindow-SIS_title')]]", "hi");

			Thread.sleep(2000);

			// detail
			Waitsendkey("xpath", "//textarea[contains(@name,'ystemImprovementWindow-SIS_detail')]", "hi");
			Thread.sleep(2000);

			// proposal
			Waitsendkey("xpath", "(//textarea[contains(@id,'SystemImprovementWindow')])[3]", "hi");

			Thread.sleep(2000);

			driver.findElement(By.xpath(
					"//label[contains(@id,'SystemImprovementWindow-SIS_Category_label')]/following-sibling::div"))
					.click();
			Thread.sleep(2000);

			driver.findElement(By.xpath("//li[text()='IDLE']")).click();
			Thread.sleep(2000);
			// submit

			WebElement submit = driver.findElement(By.xpath("(//span[text()='Submit'])[2]/following-sibling::img"));

			submit.click();
			Thread.sleep(2000);

			if (submit.isSelected()) {
				extent.pass("  submitted");
				result = "PASS";
			} else {

				extent.fail("not submitted", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";
			}
			driver.close();

		}

		catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

//To Validate ExpandandCollapse
	public void expandAndCollapse() throws IOException, InterruptedException {
		// //String Result = null;
		try {
//pms tools

			driver.findElement(By.xpath("//SPAN[text()='New']/self::SPAN")).click();

			pageload();

			WebElement expandClick = driver.findElement(By.xpath("//button[contains(@id,'PPT-PPT_expand')]"));

			click(expandClick);
			Thread.sleep(2000);

			WebElement treeStructure = driver.findElement(By.xpath("//ul[@class='jstree-children']"));

			if (treeStructure.isDisplayed()) {

				extent.pass(" Expand displayed");
				result = "PASS";

			} else {
				extent.fail("Expand not Displayed",
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}
			// collapse button Clicked
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[contains(@id,'PPT-PPT_collapse')]")).click();
			Thread.sleep(2000);

			if (treeStructure.isDisplayed() == false) {

				extent.pass(" collapse is Enabled");
				result = "PASS";

			} else {
				extent.fail("Collapse is not Clicked",
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}
			driver.close();

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

//To Validate Close Button
	public void GeneralClose() throws IOException, InterruptedException {

		// //String Result = null;
		try {

			// pms tools

			driver.findElement(By.xpath("//SPAN[text()='New']/self::SPAN")).click();

			pageload();

			driver.findElement(By.xpath("//div[@class='nfr_toolpanel_li_icon']/img[1]")).click();

			Thread.sleep(2000);
			Boolean closeButton = driver.findElement(By.xpath("(//a[@class='nfr_toolbar_close_btn'])[1]"))
					.isDisplayed();

			Thread.sleep(2000);

			if (closeButton == true) {

				extent.pass(" closeButton is Visible ");
				result = "PASS";

			}

			else {

				extent.fail("closeButton is not visibe",
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());

				result = "<a href=" + ScreenShot() + "> FAIL</a>";

			}
			driver.close();

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

//To Validate WORKfLOW bUTTON
	public void workFlow() throws IOException, InterruptedException {

		// //String Result = null;
		try {
			// Requistion tools

			driver.findElement(By.xpath("//span[text()='New']/self::span")).click();

			pageload();

			click("xpath", "//div[@id='clickme']/child::i");
			Thread.sleep(2000);

			driver.findElement(By.xpath("//i[@class='fa fa-history']/parent::a")).click();

			pageload();

			WebElement firstColour = driver.findElement(By.xpath("//label[text()='Charlotte Koch']"));
			// it will be orgp
			String c = firstColour.getCssValue("background-color");
			// String c1= .openqa.selenium.support.Color.fromString(c).asHex();
			org.openqa.selenium.support.Color.fromString(c).asHex();

			String expectFirstColour = "#365a8f";// hex no code
			if (c.equals(expectFirstColour)) {

				extent.pass("validation Ok");
				result = "PASS";
			} else {
				extent.fail("validation not Ok");

			}
			driver.close();

		} catch (Exception e) {
			extent.fail(code + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot()).build());
			Log.error("EXCEPTION DESCRIPTION=====>" + e);
			result = "<a href=" + ScreenShot() + "> FAIL</a>";

		}
		data.add(result);
		anotherMethod(result, data);

	}

	private String getCssValue(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<String> convertArrayToList(String[] exp) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void anotherMethod(String param, ArrayList data) {
		Log.info("RESULT-------------->> " + param + '\n');
		// System.out.println("status size is==>>" + data.size());
		// for(int i=0;i<data.size();i++){
		// System.out.println("results r=>"+data.get(i));
		// }
	}

	public static ArrayList kuhaName() throws IOException {

		return data;

	}

	public void clear() {
		data.clear();
	}

	public void che() {
		for (int i = 0; i < data.size(); i++) {
			if (data.size() > 0) {
				data.clear();
			}
		}

	}

	public static WebDriver getdriver() {
		if (driver == null) {
			return driver;
		} else {
			return driver;
		}
	}
}
