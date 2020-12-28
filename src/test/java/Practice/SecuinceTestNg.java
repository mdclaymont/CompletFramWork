package Practice;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Common.BaseClass;
import Utilities.TestListeners;

public class SecuinceTestNg extends BaseClass {
	@BeforeMethod
	public void beforMethod() throws IOException {
		initilizeDriver();
		openUrl("");
	}
	@Test
	public void Testc() {
	System.out.println("Test");
	//TestListener.test.log(Status.FAIL,"Exptest Test Pass Failed");	
	}
	/*
	@Test(groups= {"Smoke","Sanity"})
	public void postIphone() {
	System.out.println("postIphone(");
	//TestListener.test.log(Status.FAIL,"Exptest Test Pass Failed");	
	}
	@Test(groups={"Smoke","Sanity"})
	public void postIphone2() {
	System.out.println("postIphone 2 ");
	//TestListener.test.log(Status.FAIL,"Exptest Test Pass Failed");	
	}
	@Test(groups={"Smoke"})
	public void postIphone3() {
	System.out.println("postIphone 3 ");
	//TestListener.test.log(Status.FAIL,"Exptest Test Pass Failed");	
	}
	*/
	@AfterMethod
	public void afterMethod() {
		System.out.println("Test After Method");
	}
	
}
