package CrigList;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Common.BaseClass;
import Utilities.TestListeners;
@Listeners(TestListeners.class)
public class PostList extends BaseClass {
	@BeforeTest
	public void setUp() throws IOException, InterruptedException {
		getData("CrigList,4");
		initilizeDriver("");
		openUrl("");
		click(lp.myAccount());
		lip.LogIn();
	}
	/*
	@Test(dataProvider="getData")
	public void PostData(String Title,String Description,String Price,String PostalCode,String PhoneNumber ) {
		click(acp.Go());
		click(acp.SellBy());
		click(acp.SellCatagory());
		writeText(dp.postingTitle(),Title);
		writeText(dp.description(),Description);
		writeText(dp.price(),Price);
		writeText(dp.postalCode(),PostalCode);
		writeText(dp.phoneNumber(),PhoneNumber);
		click(dp.mobileOsClick());
		setObjectByText("apple iOS",dp.mobileOs());
		click(cf.Continue());
		click(cf.Continue());
		click(dp.doneImage());
		click(cf.Publish());
	}
	@DataProvider
	public Object[][] getData() throws IOException {
		Object[][]testData=XLUtility.getDataForDataProvider("","Crig","");
		return testData;
	}
	
	
	@Test()
	public void UpToDetails() {
		click(acp.Go());
		click(acp.SellBy());
		click(acp.SellCatagory());
		writeText(dp.postingTitle(),TcData.get(0).get("Title"));
		writeText(dp.description(),TcData.get(0).get("Description"));
		writeText(dp.price(),TcData.get(0).get("Price"));
		writeText(dp.postalCode(),TcData.get(0).get("PostalCode"));
	}
	@Test(groups= {"Des"})
	public void Published() {
		click(dp.mobileOsClick());
		setObjectByText("apple iOS",dp.mobileOs());
		click(cf.Continue());
		click(cf.Continue());
		click(dp.doneImage());
		click(cf.Publish());
	}
	*/
	@Test()
	public void Post() {
		click(acp.Go());
		click(acp.SellBy());
		click(acp.SellCatagory());
		writeText(dp.postingTitle(),TcData.get(0).get("Title"));
		writeText(dp.description(),TcData.get(0).get("Description"));
		writeText(dp.price(),TcData.get(0).get("Price"));
		writeText(dp.postalCode(),TcData.get(0).get("PostalCode"));
		click(dp.mobileOsClick());
		setObjectByText("apple iOS",dp.mobileOs());
		click(cf.Continue());
		click(cf.Continue());
		click(dp.doneImage());
		click(cf.Publish());
	}
	@AfterTest
	public void afterMethod() {
		closeBrowser("");
		softAssert().assertAll("All Result");
	}
	
}
