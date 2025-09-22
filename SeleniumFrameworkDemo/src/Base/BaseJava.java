package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ReportManager;
import org.testng.annotations.*;


public class BaseJava {
	protected WebDriver driver;
	
	@BeforeSuite
	@Parameters("Sample Suite 01")
	public void setupReporter() {
	    ReportManager.createReporter("test-output/ExtentReport.html");
	}
	
	@AfterSuite
	public void tearDownReporter() throws InterruptedException {
		if (driver != null) {
			Thread.sleep(1000);
            driver.quit();
            System.out.println("Browser closed and WebDriver session ended.");
            ReportManager.flushReporter();
        }
	}
	
	
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
	
	
	/*
	 * @AfterClass public void tearDown() { if(driver !=null) { driver.quit(); } }
	 */
	
}
