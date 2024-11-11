package generic_lib;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener, ISuiteListener{
	
	public ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;
	
	public void onStart(ISuite suite) {

		String time = new Date().toString().replace(' ', '_').replace(':', '_');
		spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("Test Suite Results");
		spark.config().setReportName("Test Report");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("Browser", "Chrome-125");
	}
	
	public void onFinish(ISuite suite) {
		report.flush();
	}
	
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" STARTED");
		test = report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, result.getMethod().getMethodName()+" STARTED");
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" ENDED");
		test.log(Status.PASS, result.getMethod().getMethodName()+" COMPLETED");
	}
	
	public void onTestFailure(ITestResult result) {
		String testName= result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot)BaseClass.sdriver;
		String filePath = ts.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(' ', '_').replace(':', '_');
		test.addScreenCaptureFromBase64String(filePath, testName+"_"+time);
		test.log(Status.FAIL, result.getMethod().getMethodName()+" FAILED");
		test.log(Status.FAIL, result.getThrowable());

	}
	
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+" SKIPPED");
	    test.log(Status.SKIP, result.getThrowable());
	}

}
