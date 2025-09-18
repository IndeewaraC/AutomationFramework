package Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import utils.*;
import Base.BaseJava;
import Page.LoginPage;
import Page.PageJava;
import Page.ViewSystemUsers;

public class TestJava extends BaseJava{
	
	PageJava page;
	LoginPage loginpge;
	ViewSystemUsers vsu;
	
	@BeforeMethod
	// driver is now initialized
	    public void initPage() {
	        page = new PageJava(driver);
	        loginpge = new LoginPage(driver);
	        vsu = new ViewSystemUsers(driver);
	    }
	
	@Test
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
	
	@Test
//Page Loginbutton verification
	public void LoginVerification() {
		ReportManager.createTest("Verify Login Function");
		loginpge.enterUsername("Admin");
		loginpge.enterPassword("@cKJCM@4@w3b");
		loginpge.clickBtnLogin();
		
		String expecterUrl = "https://indeewarag-osondemand.orangehrm.com/dashboard/index";
		String actualUrl = driver.getCurrentUrl();
		
		  if (expecterUrl.equals(actualUrl)) {
	            ReportManager.getTest().pass("Login Success");
	        } else {
	            ReportManager.getTest().fail("URL mismatch. Expected: " + expecterUrl + ", Found: " + actualUrl);
	        }
		
		Assert.assertEquals(actualUrl,expecterUrl,"URL Fail");
	}
	
	/*
	 * @Test //ViewSystem Users Page //Pre req Should Logged in Page Loginbutton
	 * verification test perfom it //Page Navigation Verification public void
	 * toggle() { ReportManager.createTest("toggle View"); vsu.SidetoggleView();
	 * vsu.SidetoggleViewAfterSpan(); //check by using boolean the menu is visible
	 * if(vsu.isMenuDisplay()) { ReportManager.getTest().pass("Menu Viewed"); } else
	 * { ReportManager.getTest().fail("Menu not Viewed"); } }
	 */
	public void verifyVsuNav() {
		String expecterUrl = "orangehrm.com/admin/viewSystemUsers";
		String actualUrl = driver.getCurrentUrl();
		
		  if (expecterUrl.contains(actualUrl)) {
	            ReportManager.getTest().pass("Navigation Success");
	        } else {
	            ReportManager.getTest().fail("URL mismatch. Expected: " + expecterUrl + ", Found: " + actualUrl);
	        }
		
		Assert.assertEquals(actualUrl,expecterUrl,"Navigation Fail");
	}
	//Navigation after Click on admin btn
		@Test
		public void AdminView() {
			ReportManager.createTest("Verify PIM View");
			String expecterUrl = "https://indeewarag-osondemand.orangehrm.com/pim/viewEmployeeList";
			vsu.GotoPIM();
			String actualUrl = driver.getCurrentUrl();
			 if (expecterUrl.equals(actualUrl)) {
		            ReportManager.getTest().pass("PIM Page Navigated");
		        } else {
		            ReportManager.getTest().fail("URL mismatch. Expected: " + expecterUrl + ", Found: " + actualUrl);
		        }
			
			Assert.assertEquals(actualUrl,expecterUrl,"URL Fail");
		}
		
	public static void main(String[] args) {
		
		
		TestJava test = new TestJava();
		test.setup();
		
		PageJava page = new PageJava(test.driver);
		test.tearDown();
		
		
	}

}
