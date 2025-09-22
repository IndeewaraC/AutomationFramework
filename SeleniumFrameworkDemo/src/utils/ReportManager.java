package utils;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {

	private static ExtentReports xt;
	private static ExtentTest xts;
	
	public static void createReporter(String filePath) {
        if (xt == null) {
            ExtentSparkReporter spk = new ExtentSparkReporter(filePath);
            xt = new ExtentReports();
            xt.attachReporter(spk);
        }
    }
	
	public static ExtentReports getReporter()
	{
		if(xt == null)
		{
			 throw new IllegalStateException("Reporter not initialized. Call createReporter() first.");
        }
		return xt;
	}
	
	public static ExtentTest createTest(String TestName) {
		if (xt == null) {
            throw new IllegalStateException("Test not created.");
        }
		xts = xt.createTest(TestName);
        return xts;
	}
	
	public static ExtentTest getTest() {
        if (xts == null) {
            throw new IllegalStateException("Test not created. Call createTest() first.");
        }
        return xts;
    }
	
	 public static void flushReporter() {
	        if (xt != null) {
	            xt.flush();
	        }}

}
