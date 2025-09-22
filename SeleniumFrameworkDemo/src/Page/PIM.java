package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;

import utils.ReportManager;
import utils.WaitsUtil;

public class PIM {
	
	private WebDriver driver = null;
	private final WaitsUtil util;

	public PIM(WebDriver driver) // Constuctor
	{
		this.driver = driver;
		this.util = new WaitsUtil(driver);
	}
	
//Variable Diclaration
	String expecterUrlPIM = "pim/viewEmployeeList";
	
	private final By Empname = By.xpath("//input[@placeholder='Type for hints...']");
	private final By pimEmp_name_lbl = By.xpath("//label[text()='Employee Name']");
	private final By clicksearch_PIM = By.xpath("//button[@type='submit']");
	private final By clickReset_PIM	= By.xpath("//button[@type='Reset']");
	private final By ID = By.xpath("//div[@class='oxd-table-body']//div[contains(text(),'0001')]");
	private final By menuPIM = By.xpath("//span[text()='PIM']");
	private final By dashboardHeader = By.cssSelector("header .oxd-topbar-header-breadcrumb h6");
	
	

//enter employee name
	public PIM SearchbyEMPName(String empnme) {
		util.sendKeysWhenVisible(Empname, empnme, 10);
		return this;
		
	}
//click on search button $ result
	 public void ClickSearch() { try { 
		 util.clickwhenclicable(clicksearch_PIM, 20);
	
	 } catch (Exception e) { throw new
		 IllegalStateException("Error" + e.getMessage()); } 
	 }
//compare result
	 public void compareresult() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 List<WebElement> rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
		            By.cssSelector("div.oxd-table-body div.oxd-table-row")
		    ));

		 if(rows.isEmpty()) {
		     System.out.println("No search results found!");
		     return;
		 }

		 WebElement firstRow = rows.get(0);

		 String empId = firstRow.findElement(By.xpath("./div[2]/div")).getText().trim();
		 String firstName = firstRow.findElement(By.xpath("./div[3]/div")).getText().trim();
		 String lastName = firstRow.findElement(By.xpath("./div[4]/div")).getText().trim();
		 
		 String expectedEmpId = "0001";
		 String expectedFirstName = "Indeewara";
		 String expectedLastName = "Gunathilaka";

		 if(empId.equals(expectedEmpId) && firstName.equals(expectedFirstName) && lastName.equals(expectedLastName)) {
		     System.out.println("Test Passed! Data matches expected values.");
		 } else {
			 System.out.println("Firstname is" +firstName);
		     System.out.println("Test Failed! Expected vs Actual mismatch.");
		 }
	 }

	 

}
