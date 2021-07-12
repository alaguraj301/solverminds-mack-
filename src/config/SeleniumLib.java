package config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.MediaEntityBuilder;

import utility.Log;

public class SeleniumLib {

	public static WebDriver driver;

	public static void launchBrowser() throws IOException {
		try {
			// System.setProperty("webdriver.chrome.driver",
			// "C:\\Users\\samyuktha.aj\\Downloads\\Driver\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\alaguraj.periyasamy\\eclipse-workspace\\DailyAutomationEngine\\driverfolder\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Log.info("Driver is invoked successfully");
			// driver.get("http://192.168.10.53:8080/main");
		} catch (Exception e) {
			Keywords.extent.fail("Driver is not invoked" + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(Keywords.ScreenShot()).build());
			Log.fatal("Driver is not invoked" + e.getMessage());
			Keywords.report.flush();
			System.exit(0);
		}
	}

	public static void goToURL(String url) {

		driver.get(url);
		Log.info("URL is passed successfully");
	}

	public static void click(WebElement element) {

		element.click();

	}

	public static void setText(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void selectByVisibleText(WebElement element, String value) {

		Select obj = new Select(element);
		obj.selectByVisibleText(value);
	}

	public static void WaitForClickable(WebElement Element, long time) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.elementToBeClickable(Element));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void WaitForElementVisibilty(WebElement Element, long time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(Element));
	}

	public static void waitForVisibilityOfElements(List<WebElement> list, long time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfAllElements(list));
	}

	public static void WaitForInVisibilty(WebElement Element, long time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.invisibilityOf(Element));
	}

	public void datePicker(WebElement dateLocator, String date) throws IOException {

		String ar[] = date.split("/");
		click(dateLocator);

		Select yearObj = new Select(driver.findElement(By.className("ui-datepicker-year")));
		yearObj.selectByVisibleText(ar[2]);

		Select monthObj = new Select(driver.findElement(By.className("ui-datepicker-month")));
		monthObj.selectByVisibleText(ar[1]);

		String locator = "//table[@class='ui-datepicker-calendar']//tr//td//a[text()='$']";
		locator = locator.replace("$", ar[0]);
		driver.findElement(By.xpath(locator)).click();
		WaitForInVisibilty(driver.findElement(By.id("ui-datepicker-div")), 8);

	}

	public void dropdownSelect(WebElement locator, String text) {
		List<WebElement> options = locator.findElements(By.tagName("li"));
		for (int i = 0; i < options.size(); i++) {
			if (options.get(i).getText().equalsIgnoreCase(text)) {
				options.get(i).click();
				break;
			}

		}
	}

	public static void waitForOverLayInvisibilty() throws InterruptedException {
		try {
			WaitForInVisibilty(driver.findElement(By.xpath("//div[@class='blockUI blockOverlay ui-widget-overlay']")),
					20);
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void userLogin(String user, String password)
			throws FileNotFoundException, IOException, InterruptedException {
		try {
			driver.findElement(By.xpath("//*[@id='NFR_LoginForm-nfr_login_authname']")).sendKeys(user);
			driver.findElement(By.xpath("//*[@id='NFR_LoginForm-nfr_login_authid']")).sendKeys(password);
			driver.findElement(By.xpath("//*[@id='NFR_LoginForm-nfr_login_btnlogin']")).click();
			try {
				WebElement invalidLogin = driver.findElement(By.xpath("//*[@id='NFR_LoginForm-nfr_login_msg']/li"));
				if (invalidLogin.isEnabled()) {
					System.out.println("am invalid");
					Keywords.extent.fail("invalid credentials",
							MediaEntityBuilder.createScreenCaptureFromPath(Keywords.ScreenShot()).build());
					// Log.fatal("Invalid Credentials");
					System.out.println("am invalid");

					Keywords.report.flush();
					System.exit(0);
				}
			} catch (Exception e) {

			}
		} catch (Exception e) {
			Keywords.extent.fail("cannot able to login" + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(Keywords.ScreenShot()).build());
			Log.fatal("cannot able to login" + e.getMessage());
			Keywords.report.flush();
			System.exit(0);
		}
		// waitForOverLayInvisibilty();
	}

}
