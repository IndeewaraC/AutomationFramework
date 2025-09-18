package utils;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitsUtil {
	private WebDriver driver;
	private WebDriverWait wait;
	public WaitsUtil(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
	
	// Wait until visible and then click
	public void clickWhenVisible(By locator, int timeout) {
	    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    driver.findElement(locator).click();
	}
	
	// Wait until visible and return WebElement
	 public WebElement waitForElement(By locator, int timeout) {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    }
	// Type into input fields safely
	 public void sendKeysWhenVisible(By locator, String text, int timeout) {
	        WebElement element = waitForElement(locator, timeout);
	        element.clear();
	        element.sendKeys(text);
	    }
	// check visibility
	 public WebElement visible(By locator) {
	
		 return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	 }
	 //Clickable method 
	  public void clickable(By locator,int time) {
		  wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	    }

}
