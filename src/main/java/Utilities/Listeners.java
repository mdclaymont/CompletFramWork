package Utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;

import Common.BaseClass;

public class Listeners implements ITestListener {
	
	BaseClass bc=new BaseClass();
	public static ThreadLocal<ExtentTest> test=new ThreadLocal<>();
	
	public void onTestStart(ITestResult result) {
		
		Reporter.log("******************************************Launch BrowserUrl Strated******************************************");
		System.out.println("******************************************Launch Browser Url Strated*****************************************");
		
	}

	public void onTestSuccess(ITestResult result) {
		Reporter.log("************************* Expected Test Case "+result.getName()+" Are Succesfully Passed********************* ");
		System.out.println("************************* Expected Test Case "+result.getName()+" Are Succesfully Passed********************* ");
		
	}

	public void onTestFailure(ITestResult result) {
		String FailedmethodName=result.getName().toString().trim();
		Reporter.log("*************************  Error "+FailedmethodName+" test has failed *************************************** ");
		System.out.println("*************************  Error "+FailedmethodName+" test has failed *************************************** ");
		try {
				bc.takeScreenShot(FailedmethodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		String StratmethodName=context.getName().toString().trim();
		Reporter.log("****************************************** "+StratmethodName  +" Strated ******************************************");
		System.out.println("******************************************"+StratmethodName  +" Strated *************************************");
		
	}

	public void onFinish(ITestContext context) {
		
		String StratmethodName=context.getName().toString().trim();
		Reporter.log("****************************************** "+StratmethodName  +" Ended ******************************************");
		System.out.println("******************************************"+StratmethodName  +" Ended ***************************************");
	}
	

}
