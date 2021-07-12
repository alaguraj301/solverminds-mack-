package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import config.Keywords;

public class SeleniumLibrary {

	public static void javaScriptClick(WebElement element)
	{
		JavascriptExecutor executor = (JavascriptExecutor) Keywords.driver;
		executor.executeScript("arguments[0].click();", element);
	}
	

	public static void goToURL(String url) {

		Keywords.driver.get(url);
	}

	public static void click(WebElement element) {

		element.click();

	}

	public static void setText(WebElement element, String value) {
		element.sendKeys(value);
	}
	
	public static String getText(WebElement element) {
		String text = element.getText();
		return text;
		
		
		 
	}
	

	public static  boolean isAttributePresent(WebElement element, String attribute) {
	    Boolean result = false;
	    try {
	    	//element=WaitUtil.waitForEleTobevisible(By.xpath("//*[@class='ui-inputfield ui-widget ui-state-default ui-corner-all hasDatepicker ui-state-filled']"));
	        String value = element.getAttribute(attribute);
	        System.out.println(value);
	        if (value != null){
	            result = true;
	        }
	    } catch (Exception e) {
	    	 Log.error("ERROR FOUND HERE=====>"+e.getMessage());
	    }
    
	    return result;
	}
	}

