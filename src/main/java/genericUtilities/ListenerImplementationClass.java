package genericUtilities;

import java.io.IOException;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationClass implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	FileUtility file = new FileUtility();
	
	
	@Override
	public void onTestStart(ITestResult result) {
		
		test = report.createTest(result.getMethod().getMethodName());
		Reporter.log("The testmethod has been started",true);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS, result.getMethod().getMethodName());
		Reporter.log("The "+result.getMethod().getMethodName()+" method is successfully executed", true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		test.log(Status.FAIL, result.getMethod().getMethodName());
		Reporter.log("The "+result.getMethod().getMethodName()+" method is successfully executed", true);
		
		try {
			String path = new FWebdriverUtility(FBaseClass.sDriver).screenshot();
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		test.log(Status.SKIP, result.getMethod().getMethodName());
		Reporter.log(result.getMethod().getMethodName()+" has been skipped",true);
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		ExtentSparkReporter sparkReport = new ExtentSparkReporter("./ExtentReports/report"+String.valueOf(new Date()).replace(' ', '_')
																									.replace(':', '_')+".html");
		sparkReport.config().setDocumentTitle("allMobiles");
		sparkReport.config().setReportName("FlipkartMobils");
		sparkReport.config().setTheme(Theme.STANDARD);
		
		report = new ExtentReports();
		report.attachReporter(sparkReport);
		report.setSystemInfo("Base platform", "Windows");
		
		try {
			report.setSystemInfo("Base browser", file.getValue("flipkart", "browser"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		try {
			report.setSystemInfo("base url", file.getValue("flipkart", "url"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}
