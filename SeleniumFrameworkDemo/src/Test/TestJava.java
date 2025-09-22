package Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.ExcelUtil;
import utils.*;
import Base.BaseJava;
import Page.LoginPage;
import Page.PageJava;
import Page.DashBoard;
import Page.PIM;

public class TestJava extends BaseJava{
	
	PageJava page;
	LoginPage loginpge;
	DashBoard dashB;
	PIM pimPage;
	
	@BeforeMethod
	// driver is now initialized
	    public void initPage() {
	        page = new PageJava(driver);
	        loginpge = new LoginPage(driver);
	        dashB = new DashBoard(driver);
	        pimPage = new PIM(driver);
	    }
	
	@Test(priority = 1)
//Page title verification
	public void verifyHomePageTitle() {
		
		ReportManager.createTest("Verify Home Page Title");
		
		String expectedTitle = "OrangeHRM";
        String actualTitle = driver.getTitle(); 
		
        if (expectedTitle.equals(actualTitle)) {
            ReportManager.getTest().pass("Title matched successfully");
        } else {
            ReportManager.getTest().fail("Title mismatch. Expected: " + expectedTitle + ", Found: " + actualTitle);
        }

        Assert.assertEquals(actualTitle, expectedTitle);
	}
// login with multiple parameters
	
	 @DataProvider(name = "loginFromExcel")
	    public Object[][] loginData() {
	        String excelPath = "src/test/resources/LoginData.xlsx";
	        String sheetName = "Sheet1";
	        return ExcelUtil.getExcelData(excelPath, sheetName);
	    }

	    @Test(priority = 2, dataProvider = "loginFromExcel")
	    public void loginVerification(String username, String password) throws InterruptedException {
	        
	        ReportManager.createTest("Login Test for user: " + username);
	        
	        loginpge = new LoginPage(driver);

	        loginpge
	            .enterUsername(username)
	            .enterPassword(password)
	            .clickBtnLogin();


	        Thread.sleep(1000);

	        String expectedUrl = "https://indeewarag-osondemand.orangehrm.com/dashboard/index";
	        String actualUrl = driver.getCurrentUrl();

	        if (expectedUrl.equals(actualUrl)) {
	            ReportManager.getTest().pass("Login Success for user: " + username);
	        } else {
	            ReportManager.getTest().fail("Login Failed for user: " + username + ". URL mismatch.");
	        }

	        Assert.assertEquals(actualUrl, expectedUrl, "URL mismatch for user: " + username);
	    }
	
		/*
		 * @Test(priority = 2) //Page Loginbutton verification public void
		 * LoginVerification() throws InterruptedException {
		 * 
		 * ReportManager.createTest("Verify Login Function");
		 * 
		 * loginpge .enterUsername("Admin") .enterPassword("@cKJCM@4@w3b")
		 * .clickBtnLogin(); Thread.sleep(1000);
		 * 
		 * String expecterUrl =
		 * "https://indeewarag-osondemand.orangehrm.com/dashboard/index"; String
		 * actualUrl = driver.getCurrentUrl();
		 * 
		 * if (expecterUrl.equals(actualUrl)) {
		 * ReportManager.getTest().pass("Login Success"); } else {
		 * ReportManager.getTest().fail("URL mismatch. Expected: " + expecterUrl +
		 * ", Found: " + actualUrl); }
		 * 
		 * Assert.assertEquals(actualUrl,expecterUrl,"URL Fail"); }
		 */
	
@Test(priority = 3)
	public void verifyDashboard() {
	ReportManager.createTest("Verify Dashboard URL");
		String expecterUrl = "dashboard/index";
		String actualUrl = driver.getCurrentUrl();
		
		  if (actualUrl.contains(expecterUrl)) {
	            ReportManager.getTest().pass("Navigation Success");
	        } else {
	            ReportManager.getTest().fail("URL mismatch. Expected: " + expecterUrl + ", Found: " + actualUrl);
	        }
		
		Assert.assertTrue(actualUrl.contains(expecterUrl),"Navigation Fail");

	}

	//Navigation after Click on PIM
		@Test(priority = 4, dependsOnMethods = {"verifyDashboard"})
		public void PIM() throws InterruptedException {
			ReportManager.createTest("Verify PIM URL");
			dashB.GotoPIM();
			Thread.sleep(1000);
			 //Navigation checker
			 String expecterUrl = "https://indeewarag-osondemand.orangehrm.com/pim/viewEmployeeList";
				String actualUrl = driver.getCurrentUrl();
				
				  if (actualUrl.contains(expecterUrl)) {
			            ReportManager.getTest().pass("Navigation Success");
			        } else {
			            ReportManager.getTest().fail("URL mismatch. Expected: " + expecterUrl + ", Found: " + actualUrl);
			        }
		}

	//Search on PIMby Name
		@Test(priority = 5)
		public void PimSearch() throws InterruptedException {
			ReportManager.createTest("Employee Search Verification by Name only");
			dashB.GotoPIM();
			pimPage
			.SearchbyEMPName("Indeewara")
			.ClickSearch();
			
		}
	@Test(priority = 6, dependsOnMethods = {"PimSearch"})
		public void compare() throws InterruptedException {
		ReportManager.createTest("Compare results");
		PimSearch();
		pimPage.compareresult();
		}


}
