package utils;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

public class WaitsUtil {
	private final WebDriver driver;
	private final WebDriverWait wait;
	
	public WaitsUtil(WebDriver driver) {
        this.driver = driver;
        //Default Wait time 10s
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
	
	// Wait until visible and then click
	public WebElement getkWhenVisible(By locator, int timeout) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	// Wait until visible and return WebElement
	 public WebElement waitForElement(By locator, int timeout) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    }
	// Type into input fields safely
	 public WebElement sendKeysWhenVisible(By locator, String text, int timeout) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		WebElement elemnt1 = waitForElement(locator, timeout);
		elemnt1.clear();
		elemnt1.sendKeys(text);
		return elemnt1;
	    }
	// check visibility
	 public WebElement visible(By locator, int timeout) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		 return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	 }
	 //Waits untill visible and then click
	 public void clickwhenvisible(By locator,int timeout) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		 getkWhenVisible(locator, timeout).click();
	 }

	    // Wait until cliclable and then click
	    public void clickwhenclicable(By locator, int timeout) {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	    	wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	    }
	    
	   
	   
}
