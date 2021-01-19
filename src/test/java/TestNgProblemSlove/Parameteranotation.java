package TestNgProblemSlove;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Common.BaseClass;
import Utilities.TestListeners;

public class Parameteranotation extends BaseClass {
	@BeforeMethod
	public void beforMethod() throws IOException {
		System.out.println("Before Method");
	}
	@Parameters({"browser","Url"})
	@Test
	public void Demo(String browser,String Url) {
		System.out.println(browser);
		System.out.println(Url);
	}
	@Test
	public void exclude() {
		System.out.println("Test exclude Function");
		
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method Method");
	}
}
