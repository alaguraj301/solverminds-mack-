package config;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UnitTesting {

	public static void main(String[] args) throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Chromenew\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://macktestingship1.solverminds.net/main");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id=\"NFR_LoginForm-nfr_login_authname\"]\r\n" + "")).sendKeys("HKKV12O");

		driver.findElement(By.xpath("//*[@id=\"NFR_LoginForm-nfr_login_authid\"]\r\n" + "")).sendKeys("password");

		driver.findElement(By.xpath("//*[@id=\"NFR_LoginForm-nfr_login_btnlogin\"]/span[1]\r\n" + "")).click();

		driver.findElement(By.xpath("//input[@id='nfr_topbar_autocomp1_input']\r\n" + ""))
				.sendKeys("External Inspection");

		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"//LI[@class='ui-autocomplete-item ui-autocomplete-list-item ui-corner-all ui-state-highlight']/self::LI"))
				.click();

		driver.findElement(By.xpath("//a[@class='ui-commandlink ui-widget btn_wrapper']//span[text()='New']\r\n" + ""))
				.click();

		driver.findElement(By.xpath("//label[@id='EXT-EXT_inspectioncode_label']\r\n" + "")).click();

		driver.findElement(By.xpath("//li[@id='EXT-EXT_inspectioncode_4']")).click();

		WebElement element1 = driver.findElement(By.xpath("//span[text()='Add Finding']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element1);

		// int totalframe=driver.findElements(By.tagName("iframe")).size();
		// System.out.println(totalframe);
		Thread.sleep(8000);

		driver.findElement(By.xpath("(//label[@id='EXT-lbl_reference']|//textarea[@id='EXT-EXT_refno'])[2]"))
				.sendKeys("Reference");
		Thread.sleep(8000);
		driver.findElement(By.xpath("//label[@id='EXT-EXT_viqNumber_label']")).click();
		driver.findElement(By.xpath("//li[@id='EXT-EXT_viqNumber_2']")).click();
		driver.findElement(By.xpath("//textarea[@id='EXT-EXT_deficiencydetail']")).sendKeys("Findings");
		Thread.sleep(8000);
		driver.findElement(By.xpath("//label[@id='EXT-EXT_categorycode_label']")).click();
		driver.findElement(By.xpath("//li[@id='EXT-EXT_categorycode_2']")).click();
		// driver.findElement(By.xpath("//label[@id='EXT-EXT_subcate1code_label']")).click();
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[5]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[22]/div[2]/div[4]/div[1]/div[1]/div[2]/div[1]/label[1]"))
				.click();
		Thread.sleep(8000);
		// driver.findElement(By.xpath("(//ul[@id='EXT-EXT_subcate1code_items']/li)[4]")).click();
		// driver.findElement(By.cssSelector("#EXT-EXT_subcate1code_0")).click();
		// Thread.sleep(8000);
		driver.findElement(By.cssSelector("#EXT-EXT_subcate2code_label")).click();
		Thread.sleep(8000);
		// driver.findElement(By.xpath("/html[1]/body[1]/div[83]/div[2]/ul[1]/li[5]")).click();
		driver.findElement(By.xpath(
				"(//button[@class='ui-datepicker-trigger ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only'])[3]"))
				.click();
		driver.findElement(By.xpath("//a[text()=15]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[22]/div[2]/div[5]/div[1]/div[1]/div[1]/label[2]/span[1]")).click();

		// driver.findElement(By.xpath("//button[@id='EXT-cse-CSE_RootCauseSelect']")).click();

		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// driver.findElement(By.xpath("(//td[@class='CSE_Cause_TreeTable_Sub'])[1]")).click();

		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/*
		 * driver.findElement( By.xpath(
		 * "//button[@id='EXT-cse-CSE_CAUSEIMPORTERDLGFORM-CSE_CAUSEIMPORTERDLG_Consolidate']\r\n"
		 * + "")) .click();
		 */

		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(8000);
		// driver.findElement(By.xpath("//div[@class='col-xs-12 col-lg-12
		// ']/a")).click();
		try {
			driver.findElement(By.xpath(
					"//body[1]/div[1]/div[5]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[22]/div[2]/div[12]/div[1]/div[1]/div[1]/a[1]/span[1]"))
					.click();
		} catch (Exception e) {
			JavascriptExecutor executor1 = (JavascriptExecutor) driver;
			executor1.executeScript("arguments[0].click();", driver.findElement(By.xpath(
					"//body[1]/div[1]/div[5]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[22]/div[2]/div[12]/div[1]/div[1]/div[1]/a[1]/span[1]")));
		}

	}

}
