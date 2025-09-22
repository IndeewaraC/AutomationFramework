package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.ReportManager;
import utils.WaitsUtil;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;

public class DashBoard {
	
	private final WebDriver driver;
	private final WaitsUtil util;
	
	public DashBoard(WebDriver driver) // Constuctor
	{
		this.driver = driver;
		this.util = new WaitsUtil(driver);
	}
	
	//Variuable Decleration point
	private final By dashboardHeader = By.xpath("//aside//span[text()='Dashboard']");
	private final By pimMenu = By.xpath("//aside//span[text()='PIM']");
	
	
	

//Click after menu is be visible
	public Boolean isMenuDisplay() {
	    try {
	        return util.visible(dashboardHeader, 5).isDisplayed(); 
	    } catch (Exception e) {
	        System.out.println("Dashboard element not found: " + e.getMessage());
	        return false;
	    }
	}
	
//Cick on PIM Btn
	 public void GotoPIM() { try { 
		 
	 util.clickwhenclicable(pimMenu, 15);
	 
	 } catch (Exception e) { throw new
	 IllegalStateException("PIM menu not accessible: " + e.getMessage()); } }
	 
//verify is at PIM

	 
	 
	}


