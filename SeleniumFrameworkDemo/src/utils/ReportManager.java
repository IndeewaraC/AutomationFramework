package utils;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {

	private static ExtentReports xt;
	private static ExtentTest xts;
	
	public static ExtentReports getReporter()
	{
		if(xt == null)
		{
			ExtentSparkReporter spk = new ExtentSparkReporter("test-output/ExtentReport.html");
			xt = new ExtentReports();
			xt.attachReporter(spk);
		}
		
		return xt;
	}
	
	public static ExtentTest createTest(String TestName) {
		xts = getReporter().createTest(TestName);
		return xts;
	}
	
	public static ExtentTest getTest()
	{
		return xts;
	}
	
}
