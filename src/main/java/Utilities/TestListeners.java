package Utilities;

import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Common.BaseClass;

public class TestListeners extends BaseClass implements ITestListener {
	public static ExtentTest test;
	public static String expMethodName, expClassName;
	public static ExtentReports extent = ExtentManager.createInstance();
	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	
	public static void onStart() {
		expMethodName = objBc.getClass().getName().toString().trim();
		test = extent.createTest(expMethodName); // This will be Create Pass Failed all Other log To Extent Report
		extentTest.set(test); // Make Thread safe
		Reporter.log("****** Test case Started And Details Are " + expMethodName + " Strated **************");
	}
	public void onStart(ITestContext context) {
		expMethodName = context.getName().toString().trim();
		test = extent.createTest(expMethodName); // This will be Create Pass Failed all Other log To Extent Report
		extentTest.set(test); // Make Thread safe
	}

	public void onTestStart(ITestResult result) {
		expMethodName = result.getMethod().getMethodName().trim();
		expClassName = result.getTestClass().getName().toString().trim();
		test = extent.createTest(expClassName + " :: " + expMethodName); // This will be Create Pass Failed all Other
		extentTest.set(test);																	// log To Extent Report
	}

	public void onTestSuccess(ITestResult result) {
		expMethodName = result.getMethod().getMethodName().trim();
		test = extent.createTest(expClassName + " :: " + expMethodName); // This will be Create Pass Failed all Other
		extentTest.set(test);																	// log To Extent Report
		String logText = "<b>Test Method " + expMethodName + "Successful</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		extentTest.get().log(Status.PASS, m);
	}

	public void onTestFailure(ITestResult result) {
		expMethodName =result.getMethod().getMethodName().trim();
		System.out.println(expMethodName);
		String logText = "<b>Test Method " + expMethodName + "Failed</b>";
		String exceptionMsg = Arrays.toString(result.getThrowable().getStackTrace());
		String extLog = "<details><summary><b><font color=red>" + "Exception Occured,Click To see Details:"
				+ "</font></b></summary>" + exceptionMsg.replaceAll(",", "<br>") + "</details> \n";
		extentTest.get().fail(extLog);
		try {
			String path = BaseClass.takeScreenShot(expMethodName, "");
			extentTest.get().fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		} catch (Exception e) {
			extentTest.get().fail("Test Failed, Can Not attached ScreenShot");
		}
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		extentTest.get().log(Status.FAIL, m);
	}

	public void onFinish(ITestContext context) {
		if (extent != null) {
			extent.flush();
		}
	}
	public static void onFinish() {
		expMethodName = objBc.getClass().getName().toString().trim();
		if (extent != null) {
			extent.flush();
		}
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestSkipped(ITestResult result) {
		expMethodName = result.getMethod().getMethodName().trim();
		String logText = "<b>Test Method " + expMethodName + " Skipped</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		extentTest.get().log(Status.SKIP, m);
	}

}
