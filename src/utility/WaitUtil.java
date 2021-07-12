package utility;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import config.Keywords;

public class WaitUtil {
	public static Wait<WebDriver> wait;
	public static WaitUtil w;

	public WaitUtil() {
		w = new WaitUtil();
		wait = new WebDriverWait(Keywords.driver, 20);
	}

	/***************
	 * WebDriver Explicit wait time has been initialized as a method
	 *******************/
	/*
	 * public static void explicitWait() { wait = new WebDriverWait(Keywords.driver,
	 * 20); }
	 */

	/***************
	 * WebDriver Fluent wait method to call in the KeywordExample class
	 *******************/

	public static WebElement fluentWait(By locator) {
		wait = new FluentWait<WebDriver>(Keywords.driver).withTimeout(20, TimeUnit.SECONDS)
				.pollingEvery(250, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(locator);
				return element;
			}
		});
		return element;
	}

	/***************
	 * Explicit wait methods to call in the KeywordExample class
	 *******************/

	/*************** elementToBeClickable *******************/

	public static WebElement waitForEleTobeClickble(By locator) {

		// explicitWait();
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		return element;

	}

	/*************** invisibilityOfElementLocated *******************/

	public static Boolean waitForEleTobeInvisible(By locator) {

		// explicitWait();
		Boolean element = wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		return element;
	}

	/*************** visibilityOfElementLocated *******************/

	public static WebElement waitForEleTobevisible(By locator) {

		// explicitWait();
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;
	}

	/***************
	 * visibilityOfElementsLocated to store in the List
	 *******************/

	public static List<WebElement> waitForElementsTobevisible(By locator) {

		// explicitWait();
		List<WebElement> element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		return element;
	}

	/*************** presenceOfElementLocated *******************/
	public static WebElement waitForPresenceOfEle(By locator) {

		// explicitWait();
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return element;
	}

	/*************** used for stale element reference exception *******************/
	public static WebElement waitForStaleElement(By locator) throws InterruptedException {
		try {
			return Keywords.driver.findElement(locator); // Returns when the object identified
		} catch (StaleElementReferenceException se) {
			Thread.sleep(500);
			Log.error("Exception " + se);
			return waitForStaleElement(locator); // recalls the function till the element on the page identified
		}

	}

	/*************** used for stale element reference exception *******************/
	public static WebElement waitForStaleElementVisible(By locator) throws InterruptedException {
		try {

			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return Keywords.driver.findElement(locator);

// Returns when the object identified			 s
		} catch (ElementNotVisibleException e) {
			Log.error("Exception " + e.getMessage());
			return waitForStaleElementVisible(locator); // recalls the function till the element on the page identified
		}
	}

	public static Boolean waitForEleTobeInvisible() {

		// explicitWait();
		Boolean element = wait
				.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='blockUI']")));
		return element;
	}

}
