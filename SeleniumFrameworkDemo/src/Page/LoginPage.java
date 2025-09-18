package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import utils.WaitsUtil;


public class LoginPage {
	WebDriver driver;
	WaitsUtil util;
	
	public LoginPage(WebDriver driver) // Constuctor
	{
		this.driver = driver;
		this.util = new WaitsUtil(driver);
	}
	 //defind the locator by using Xpath
		private By Username = By.xpath("//input[@name='username']");
		private By Password = By.xpath("//input[@name='password']");
		private By loginBtn	= By.xpath("//button[@type='submit']");
	//Argument Pass and Action
		public void enterUsername(String UN)
		{
			util.sendKeysWhenVisible(Username, UN, 10);
		}

		public void enterPassword(String PW) {
			util.sendKeysWhenVisible(Password, PW, 10);
		}
		public void clickBtnLogin() {
			util.clickWhenVisible(loginBtn, 10);
		}
}
