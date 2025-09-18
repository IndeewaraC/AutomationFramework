package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ReportManager;
import org.testng.annotations.*;


public class BaseJava {
	protected WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");//set the chrome driver path
		driver = new ChromeDriver(); //assign chrome driver
		driver.manage().window().maximize();
		ReportManager.getReporter();
	}
	
	@BeforeMethod
    public void openPage() {
        driver.get("https://indeewarag-osondemand.orangehrm.com/auth/login");
    }
	
	@AfterSuite
	public void tearDownReporter() {
		ReportManager.getReporter().flush();
	}
	
	@AfterClass
	public void tearDown()
	{
		if(driver !=null)
		{
			driver.quit();
		}
	}
	
}
