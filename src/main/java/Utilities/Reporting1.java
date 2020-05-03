package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import Common.BaseClass;

public class Reporting1 extends TestListenerAdapter{
	
	BaseClass tb=new BaseClass();
	public String timeStamp;
	public String reportName;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	public String currentDirectory=System.getProperty("user.dir");
	public String methodName;
	
	public void onStart(ITestContext testContext) {
		methodName=testContext.getName().toString().trim();
		//Reporter.log("****************************************** "+methodName  +" Strated ******************************************");
		//System.out.println("******************************************"+methodName  +" Strated *************************************");
		timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		reportName="Test-Report-"+ timeStamp + ".html";
		System.out.println(reportName);
		htmlReporter=new ExtentHtmlReporter(currentDirectory+ "/test-output/"+reportName);
		System.out.println(currentDirectory+ "/test-output/"+reportName);
		htmlReporter.loadXMLConfig(currentDirectory+ "/extent-config.xml");
		htmlReporter.config().setDocumentTitle("For Automation Test Project"); //Title of the reorts
		htmlReporter.config().setReportName("Automation Test Report"); // Name of the report
		htmlReporter.config().setTheme(Theme.DARK);
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Enviroment","QA");
		extent.setSystemInfo("user","Reza");
		
	}
	
	public void onTestSuccess(ITestResult result) {
		methodName=result.getName().toString().trim();
		//Reporter.log("************************* Expected Test Case "+methodName+" Are Succesfully Passed********************* ");
		//System.out.println("************************* Expected Test Case "+methodName+" Are Succesfully Passed********************* ");
		
		logger=extent.createTest(methodName);
		logger.log(Status.PASS,MarkupHelper.createLabel(methodName, ExtentColor.GREEN));
	}
	
	public void onTestFailure(ITestResult result) {
		String methodName=result.getName().toString().trim();
		//Reporter.log("*************************  Error "+methodName+" test has failed *************************************** ");
		//System.out.println("*************************  Error "+methodName+" test has failed *************************************** ");
		logger=extent.createTest(methodName);
		logger.log(Status.FAIL,MarkupHelper.createLabel(methodName, ExtentColor.RED));
		String screenShotPath=currentDirectory+"\\ScreenShots\\"+methodName+".png";
		File objFile=new File(screenShotPath);
			if(objFile.exists())
			{
				try {
					logger.fail("Screenshot is below: " + logger.addScreenCaptureFromPath(screenShotPath));
					}
				catch (IOException e) 
					{
					e.printStackTrace();
					}
			}
		}
	
	public void onTestSkipped(ITestResult result) {
		methodName=result.getName().toString().trim();	
		logger=extent.createTest(methodName);
		logger.log(Status.SKIP,MarkupHelper.createLabel(methodName, ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext result) {
		methodName=result.getName().toString().trim();
		String StratmethodName=result.getName().toString().trim();
		Reporter.log("****************************************** "+StratmethodName  +" Ended ******************************************");
		System.out.println("******************************************"+StratmethodName  +" Ended ***************************************");
	}
	
	public void onTestStart(ITestResult result) {
		methodName=result.getName().toString().trim();
		Reporter.log("******************************************Launch BrowserUrl Strated******************************************");
		System.out.println("******************************************Launch Browser Url Strated*****************************************");
		
	}

	

	

	

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		methodName=result.getName().toString().trim();
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		methodName=result.getName().toString().trim();
	}

	

	

}
