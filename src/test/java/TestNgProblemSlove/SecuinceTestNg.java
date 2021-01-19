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
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Common.BaseClass;
import Utilities.TestListeners;

public class SecuinceTestNg extends BaseClass {
	@BeforeSuite
	public void beforSuite() throws IOException {
		System.out.println("Before Suite");
	}
	@BeforeTest
	public void beforTest() throws IOException {
		System.out.println("Before Test");
	}
	@BeforeClass
	public void beforClass() throws IOException {
		System.out.println("Before Class");
	}
	@BeforeMethod
	public void beforMethod() throws IOException {
		System.out.println("Before Method");
	}
	@Test
	public void Testc() {
		System.out.println("Test Case ");

	}
	@Test
	public void Test() {
		System.out.println("Test Case 2 ");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method Method");
	}
	
	@AfterClass
	public void AfterClass() throws IOException {
		System.out.println("After Class");
	}
	@AfterTest
	public void AfterTest() throws IOException {
		System.out.println("After Test");
	}
	@AfterSuite
	public void AfterSuite() throws IOException {
		System.out.println("After Suite");
	}
}
