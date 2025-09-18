package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitsUtil;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;

public class ViewSystemUsers {
	
	private final WebDriver driver;
	private final WaitsUtil util;
	
	public ViewSystemUsers(WebDriver driver) // Constuctor
	{
		this.driver = driver;
		this.util = new WaitsUtil(driver);
	}
//Define Param
	/*
	 * private By Sidetoggle =
	 * By.xpath("//div[@id='app']/div[2]/div/aside/nav/div[2]/div/div/button/i");
	 * private By sidePanel = By.name("Sidepanel"); private By Span =
	 * By.xpath("//div[@id='app']/div[2]/div/aside/nav/div[2]/ul/li/a/span");
	 */
	 private final By PIM = By.xpath("//span[normalize-space()='PIM']");
	
	/*
	 * //Click on Side toggle Span/collapse button - Pre Req(should be collapsed)
	 * public void SidetoggleView() { util.clickWhenVisible(Sidetoggle,50);
	 * 
	 * } // Click on Side toggle for Span public void SidetoggleViewAfterSpan() {
	 * util.clickWhenVisible(Sidetoggle,50); }
	 */
//Click after menu is be visible
	public Boolean isMenuDisplay() {
		   try {
		        return util.visible(By.xpath("//span[text()='Dashboard']")).isDisplayed(); 
		    } catch (NoSuchElementException e) {
		        return false; 
		    }
		}
	
//Cick on PIM Btn
	public void GotoPIM() {
		
		util.clickable(PIM,20);
}
	}
