package Common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.codehaus.plexus.util.Base64;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import Utilities.ReadConfig;
import Utilities.TestListener;

//********************************************************************   Test Base Class    ************************************************************************  

public class BaseClass {
	public static BaseClass objBc=new BaseClass();
	public static ReadConfig readCon=new ReadConfig();
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties objprop;
	public static FileInputStream objFile;
	public static String browserName=readCon.getBrowserName();
	public static int explicit_Wait=readCon.getexpWait();
	public static int PAGE_LOAD_TIME=readCon.getPAGE_LOAD_TIME();
	public static int IMPLICIT_WAIT=readCon.getIMPLICIT_WAIT();		
	public static String chromePath=readCon.getChromePath();
	public static String ffPath=readCon.getffPath();
	public static String iePath=readCon.getiePath();
	public static String configFile;
	public static String configPath;
	public static String urlAddress;
	public static String userId;
	public static String userPassword;
	public static String Description;
	public static String Title;
	public static String driverPath;
	public static SoftAssert soft=new SoftAssert();
	public static String downloadPath=System.getProperty("user.dir")+File.separator+"downloads";
	public static JavascriptExecutor jse;
	public static String DomainName="TestA";
	public static Logger log=LogManager.getLogger(BaseClass.class.getName());	
	public static Properties appProperties;	
//	BaseClass a=new BaseClass();
	public BaseClass() {
	//	ReadConfig readCon=new ReadConfig();
		readProperties("");
	}
	/****************************************************************************************************************
	*  Author: Md Rezaul Karim 
	*  Function Name: explicitWait
	*  Function Arg: WebElement ExpwebElement,String ExPText,int timeOut
	*  FunctionOutPut: It will wait until element visible 
	* 
	**************************************************************************************************************/
	
	public static WebDriverWait explicitWait(){
		wait=new WebDriverWait(driver,explicit_Wait);
		return wait;
	}
	
	/****************************************************************************************************************
	 * Author: Md Rezaul Karim 
	 * Function Name: readProperties
	 * Function Arg: String expFilePath
	 * FunctionOutPut: It will encoded String
	 * **************************************************************************************************************
	 */
	public static void readProperties(String expFilePath) {
		System.out.println("Read Properties");
		try	{
			appProperties=new Properties();
			if(expFilePath.isEmpty() || expFilePath.length()<1) {	//If User provied Any properties File Path if Not use Configuration folder
				expFilePath="./Configuration/config.properties";
			}
			File src=new File(expFilePath);
			FileInputStream objFile=new FileInputStream(src);
			objprop = new Properties();
			objprop.load(objFile);
			appProperties.putAll(objprop);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	/*********************************  Test Base Constractor **********************************************************************************/
	

	/****************************************************************************************************************
	 * Author: Md Rezaul Karim 
	 * Function Name: encodedStr
	 * Function Arg: String expStr
	 * FunctionOutPut: It will encoded String
	 * **************************************************************************************************************
	 */

	public static String encodedStr(String expStr) {
		byte[] encodedStr=Base64.encodeBase64(expStr.getBytes());
		return new String(encodedStr);
	}
	
	/****************************************************************************************************************
	 * Author: Md Rezaul Karim 
	 * Function Name: dencodedStr
	 * Function Arg: String expStr
	 * FunctionOutPut: It will dencoded String
	 * **************************************************************************************************************
	 */

	public static String dencodedStr(String expStr) {
		byte[] dencodedStr=Base64.decodeBase64(expStr.getBytes());
		return new String(dencodedStr);
	}
	
	public static void softassert() {
		
	}
	
	
	/****************************************************************************************************************
	 * Author: Md Rezaul Karim 
	 * Function Name: scrollUpdown
	 * Function Arg: expScroll,WebElement expElement
	 * FunctionOutPut: It will Scroll exptect
	 * **************************************************************************************************************
	 */

	public static void scrollUpdown(String expScroll,WebElement expElement) {
		jse=(JavascriptExecutor)driver;
		if(expScroll.toLowerCase().contains("up")) {
			jse.executeScript("window.scrollTo(0,-document.body.scrollHeight);");
		}
		else if(expScroll.toLowerCase().contains("down")) {
			jse.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		}
		else if(expScroll.toLowerCase().contains("horigintaldown")) {
			jse.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		}
		else {
			jse.executeScript("arguments[0].scrollIntoView();",expElement);
		}
	}
	
	/****************************************************************************************************************
	 * Author: Md Rezaul Karim 
	 * Function Name: fileInStream
	 * Function Arg: String FileInStreamPath
	 * FunctionOutPut: It will create a Object For File Input Stream
	 * **************************************************************************************************************
	 */
	public static FileInputStream fileInStream(String FileInStreamPath ) throws FileNotFoundException
	{
		objFile=new FileInputStream(FileInStreamPath);
		return objFile;
	}
			
	/****************************************************************************************************************
	 * Author: Md Rezaul Karim 
	 * Function Name: getData()
	 * Function Arg: 
	 * FunctionOutPut: It will Return User Defined Data From Properties File
	 * **************************************************************************************************************
	 */
	public static void getData() throws IOException {
		Reporter.log("******************************************Get Data Imported Staretd******************************************");
		System.out.println("******************************************Get Data Imported Staretd******************************************");
		File src=new File("./Configuration/config.properties");
		try
		{
			FileInputStream objFile=new FileInputStream(src);
			objprop = new Properties();
			objprop.load(objFile);
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		DomainName = objprop.getProperty("userDomainName");
		if (DomainName.contains("criglist")) 
			{
				userId = objprop.getProperty("CrigListUserId");
				userPassword = objprop.getProperty("CrigListUserPassword");
				urlAddress = objprop.getProperty("CrigListUrl");
			} 
		else if (DomainName.contains("mercary")) 
			{
				userId = objprop.getProperty("MercaryUserId");
				userPassword = objprop.getProperty("MercaryPassword");
				urlAddress = objprop.getProperty("MercaryUrl");
				Description=objprop.getProperty("MercaryDescription");
				Title=objprop.getProperty("MercaryTitle");
			}
		else if (DomainName.contains("Guru")) 
		{
			userId = objprop.getProperty("GuruUserId");
			userPassword = objprop.getProperty("GuruPassword");
			urlAddress = objprop.getProperty("GuruUrl");
		}
		else
			{
				System.out.println("could not find any domain so defult id google");
			}
		Reporter.log("******************************************Get Data Imported Ended******************************************");
		System.out.println("******************************************Get Data Imported Ended********************************************");
	}

	/****************************************************************************************************************
	*  Author: Md Rezaul Karim 
	*  Function Name: initilizeDriver
	*  Function Arg: Return WebDriver
	*  FunctionOutPut: It will initilize Driver
	* 
	* ***************************************************************************************************************/
	@BeforeClass
	public static WebDriver initilizeDriver() throws IOException {
		try {
			getData();
			Reporter.log("**************************************** initilize Driver MEthod Started ******************************************");
			String mavenBrowserName=System.getProperty("Browser");// check if maven send any browser
			String driverPath=System.getProperty("user.dir")+"//Driver";
			if(mavenBrowserName!= null)
			{
				browserName=mavenBrowserName;
			}
			else
			{
				browserName=readCon.getBrowserName();	
			}
			
			if(browserName.toLowerCase().contains("ie") || browserName.contains("internet"))
			{
				System.setProperty("webdriver.ie.driver",driverPath+"//IEDriverServer.exe");
				driver= new InternetExplorerDriver();
				browserName="Internet Explorer";
			}
			else if(browserName.toLowerCase().contains("edge"))
			{
				System.setProperty("webdriver.edge.driver",driverPath+"//msedgedriver.exe");
				driver=new EdgeDriver();
				browserName="Microsoft Edge";
			}
			else if(browserName.contains("firefox") || browserName.contains("ff"))
			{
				System.setProperty("webdriver.gecko.driver",driverPath+"//geckodriver.exe");
				System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"null");
				driver=new FirefoxDriver();
				browserName="FireFox";
			}
			//if user want headless browser then you can use it 
			else if(browserName.contains("chromeheadless") || browserName.contains("headless"))
			{
				System.setProperty("webdriver.chrome.driver",driverPath+"//chromedriver.exe");
				System.setProperty("webdriver.chrome.silentOutput","true");//it will remove unnessary log
				HashMap<String,Object> ohp=new HashMap<String,Object>();
				ohp.put("profile.defult_content_settings.popups",0);
				ohp.put("download.defult_directory",downloadPath);  //if download any file it will save to current user dir 
				ChromeOptions objoption=new ChromeOptions();
				objoption.addArguments("headless");
				objoption.setExperimentalOption("useAutomationExtension",false);
				driver=new ChromeDriver(objoption);
				browserName="chrome";
			}
			else if(browserName.contains("sslcertificatebrowser") || browserName.contains("securityalartbrowser"))
			{
				DesiredCapabilities objCap = DesiredCapabilities.chrome();
				objCap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				objCap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				ChromeOptions objOption = new ChromeOptions();
				objCap.merge(objOption);
				System.setProperty("webdriver.chrome.driver",chromePath);
				driver = new ChromeDriver(objOption);
				browserName="Google Chrome";
			}
			else
			{
				System.setProperty("webdriver.chrome.driver",driverPath+"chromedriver.exe");
				System.setProperty("webdriver.chrome.silentOutput","true");//it will remove unnessary log.
				HashMap<String,Object> ohp=new HashMap<String,Object>();
				ohp.put("profile.defult_content_settings.popups",0);
				ohp.put("download.defult_directory",downloadPath);  //if download any file it will save to current user dir 
				ChromeOptions oco=new ChromeOptions();
				oco.setExperimentalOption("useAutomationExtension",false);
				oco.setExperimentalOption("prefs",ohp);
				driver = new ChromeDriver(oco);
				browserName="Google Chrome";
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIME,TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT,TimeUnit.SECONDS);
			Reporter.log("\t Expected Browser ' "+browserName+" ' Opend Successfully");
			TestListener.test.log(Status.PASS,"\t Expected Browser ' "+browserName+" ' Opend Successfully");
		}catch(Exception e) {
			Reporter.log("\t Expected Browser ' "+browserName+" ' Opend Successfully");
			TestListener.test.log(Status.FAIL,"\t Expected Browser ' "+browserName+" ' Failed To Opend");
		}	
		return driver;
	}
	
	/****************************************************************************************************************
	*  Author: Md Rezaul Karim 
	*  Function Name: RemoteGrid
	*  Function Arg: BrowserName ==>Which Browser You want work for
	*  FunctionOutPut: 
	* 
	* ***************************************************************************************************************/
	
	/*public static void RemoteGrid(String BrowserName) throws MalformedURLException{
		
		DesiredCapabilities objRc=new DesiredCapabilities();
		if(BrowserName.isEmpty())
		{
			objRc.setBrowserName(BrowserName);
		}
		else
		{
			objRc.setBrowserName("chrome");
		}
		objRc.setPlatform(Platform.WINDOWS);
		driver=new RemoteWebDriver(new URL("http://localhost:4546/wd/hub"),objRc);
	}
	*/
	/****************************************************************************************************************
	*  Author: Md Rezaul Karim 
	*  Function Name: OpenUrl
	*  Function Arg: expectedUrl ==>Which Url Or Domain You want work for
	*  FunctionOutPut: It will open Url That you want Automated
	* 
	* ***************************************************************************************************************/
		
	public static void openUrl(String expectedUrl){
		String urlAdd = null;
		try {
			Reporter.log("******************************************Url Open Strated******************************************");
			
			if(expectedUrl.isEmpty())
				{
				urlAdd=urlAddress;
				}
			else
				{
				urlAdd=expectedUrl;
				}
			driver.get(urlAdd);
			Reporter.log("\t Expected Url ' "+urlAdd+" ' Opend Or Lunch");
			TestListener.test.log(Status.PASS,"\t Expected Url ' "+urlAdd+" ' Opend Or Lunch");
		}catch(Exception e) {
			Reporter.log("\t Expected Url ' "+urlAdd+" ' Did Not Opend Or Lunch");
			TestListener.test.log(Status.FAIL,"\t Expected Url ' "+urlAdd+" ' Did Not Opend Or Lunch");
		}	
	}
	//******************************   User Action Start   ******************************************************88
	public static void waitVisibility(WebElement expElement) {
		wait=new WebDriverWait(driver,explicit_Wait);
		wait.until(ExpectedConditions.visibilityOf(expElement));
	}
	public static void waitVisibilityElements(List<WebElement> expElement) {
		wait=new WebDriverWait(driver,explicit_Wait);
		wait.until(ExpectedConditions.invisibilityOfAllElements(expElement));
	}
	
	public static void click(WebElement expElement) {
		String expClickElement=null;
		try {
			waitVisibility(expElement);
			expClickElement=expElement.getText().trim();
			expElement.click();
			TestListener.test.log(Status.PASS,"\t Expected ' "+expClickElement+" ' Element Clicked");
			log.info("\t Expected ' "+expClickElement+" ' Element Clicked");
		}catch(Exception e) {
			TestListener.test.log(Status.FAIL,"\t Expected ' "+expClickElement+" ' Not Found or Able To Clicked");
			log.info("\t Expected ' "+expClickElement+" ' Not Found or Able To Clicked");
		}
	}
	
	public static void writeText(WebElement expElement,String expText) {
		try {
			waitVisibility(expElement);
			expElement.sendKeys(expText);
			TestListener.test.log(Status.PASS,"\t Expected ' "+expText+" ' Element Set Input/Edit Field");
			log.info("\t Expected ' "+expText+" ' Element Set Input/Edit Field");
		}catch(Exception e) {
			TestListener.test.log(Status.FAIL,"\t Expected ' "+expText+" ' Element Does Not Set Input/Edit Field");
			log.info("\t Expected ' "+expText+" ' Element Does Not Set Input/Edit Field");
		}
	}
	public static void writeTextByJs(WebElement expElement,String expText) {
		try {
			jse=(JavascriptExecutor)driver;
			jse.executeScript("arguments[0].setAttribute('value','"+expText+"');",expElement);
			Thread.sleep(1000);
			String setValue=expElement.getAttribute("value").trim();
			TestListener.test.log(Status.PASS,"\t Expected ' "+setValue+" ' Element Set Input/Edit Field");
			log.info("\t Expected ' "+setValue+" ' Element Set Input/Edit Field");
		}catch(Exception e) {
			TestListener.test.log(Status.FAIL,"\t Expected ' "+expText+" ' Element Does Not Set Input/Edit Field");
			log.info("\t Expected ' "+expText+" ' Element Does Not Set Input/Edit Field");
		}
	}
	public static void clearFiled(WebElement expElement) {
		try {
			waitVisibility(expElement);
			expElement.clear();;
			TestListener.test.log(Status.PASS,"\t Expected Input/Edit Field Cleared");
			log.info("\t Expected Input/Edit Field Cleared");
		}catch(Exception e) {
			TestListener.test.log(Status.FAIL,"\t Expected Input/Edit Field Did Not Cleared");
			log.info("\t Expected Input/Edit Field Did Not Cleared");
		}
	}
	public static String readText(WebElement expElement) {
		String expReadElement=null;
		waitVisibility(expElement);
		expReadElement=expElement.getText().trim();
		return expReadElement;
	}

	/****************************************************************************************************************
	 *  Author: Md Rezaul Karim 
	 *  Function Name:setSelect
	 *  Function Arg: ExpSelect Expected Select Element Locator 
	 *  FunctionOutPut: It will create a object for select class
	 * 
	 * ***************************************************************************************************************/
	
	public static Select setSelect(WebElement ExpSelect){
		
		Select obs=new Select(ExpSelect);
		return obs;
	}
	
	/****************************************************************************************************************
	 *  Author: Md Rezaul Karim 
	 *  Function Name:clickElementByJs
	 *  Function Arg: ExpElement element locator
	 *  FunctionOutPut: It will create a object for Action class
	 * 
	 * **************************************************************************************************************/
	
	public static void clickByJs(WebElement expElement){
		try {
			jse=(JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click();",expElement);
			TestListener.test.log(Status.PASS,"\t Expected Element Clicked");
			log.info("\t Expected Element Clicked");
		}catch(Exception e) {
			TestListener.test.log(Status.FAIL,"\t Expected Not Found or Able To Clicked");
			log.info("\t Expected Not Found or Able To Clicked");
		}
	}
	
	/****************************************************************************************************************
	 *  Author: Md Rezaul Karim 
	 *  Function Name:refreshByJs
	 *  Function Arg: ExpElement element locator
	 *  FunctionOutPut: It will create a object for Action class
	 * 
	 * **************************************************************************************************************/
	
	public static void refreshByJs(){
		jse.executeScript("history.go(0)");
	}
	

	/****************************************************************************************************************
	*  Author: Md Rezaul Karim 
	*  Function Name: selectByJs
	*  Function Arg: WebElement expElement,String ExpValue
	*  FunctionOutPut: It will Select value from drop down when drop down is not able to select by select tag
	* 
	* ***************************************************************************************************************/
	
	public static void selectByJs(WebElement expElement,String ExpValue){
		Reporter.log("****************************************** Select By Js Strated ******************************************");
		System.out.println("****************************************** select By Js Strated ******************************************************");
			
		jse.executeScript("arguments[0].setAttribute('value','"+ExpValue+"');", expElement);
		Reporter.log("****************************************** Select By Js Ended ******************************************");
		System.out.println("****************************************** Select By Js Ended ******************************************************");
	}
	
	/****************************************************************************************************************
	*  Author: Md Rezaul Karim 
	*  Function Name: AutoSuggestDropDown
	*  Function Arg: String expSearchLocator  ==>Search Field Locator, String selectValue  ==> The Value user want from drop down 
	*  FunctionOutPut: It will Select value from drop down when drop down is not able to select by select tag
	* 
	* ***************************************************************************************************************/
	public static void setObjectByText(String expText, String expSearchLocator) {
		
		Reporter.log("******************************************Auto Suggest Drop Down Started******************************************");
		System.out.println("******************************************Auto Suggest Drop Down Started*************************************");
		String getSearchValue;
		List<WebElement> objElements=driver.findElements(By.xpath(expSearchLocator));
		int totalEl=objElements.size();
		for(int i = 0;i<totalEl;i++)
		{
			getSearchValue=objElements.get(i).getText().trim();
			if(getSearchValue.equalsIgnoreCase(expText))
			{
				objElements.get(i).click();
				System.out.println(getSearchValue);
				break;
			}
		}
		
		Reporter.log("******************************************Auto Suggest Drop Down Ended******************************************");
		System.out.println("******************************************Auto Suggest Drop Down Ended****************************************");
	}
	
	public static void setObjectByText(String expText, List<WebElement> expEle) {
		
		Reporter.log("******************************************Auto Suggest Drop Down Started******************************************");
		System.out.println("******************************************Auto Suggest Drop Down Started*************************************");
		String actualValue="";
		int totalEl=expEle.size();
		for(int i = 0;i<totalEl;i++)
		{
			actualValue=expEle.get(i).getText().trim();
			if(actualValue.equalsIgnoreCase(expText))
			{
				expEle.get(i).click();
				break;
			}
		}
		
		Reporter.log("******************************************Auto Suggest Drop Down Ended******************************************");
		System.out.println("******************************************Auto Suggest Drop Down Ended****************************************");
	}
	
	
	////******************************   Validation Part   ******************************************************88
	
	/****************************************************************************************************************
	*  Author: Md Rezaul Karim 
	*  Function Name: ValidateUrl
	*  Function Arg: ExpectedUrl(Which Url You want work for)
	*  FunctionOutPut: It will open Url That you want Automated
	 * @throws IOException 
	* 
	* ***************************************************************************************************************/
		
	public static void validateUrl() throws IOException{
	
		Reporter.log("******************************************Validate Url Strated******************************************");
		System.out.println("******************************************Validate Url Strated***********************************************");
		String actualUrl = driver.getCurrentUrl();
		int uIndex=urlAddress.indexOf("www");
		int aIndex=actualUrl.indexOf("www");
		if(uIndex>0 && aIndex<0 )
			{
				urlAddress=urlAddress.replace("www.","");	
			}
		else if(uIndex<0 && aIndex>0)
			{
				actualUrl=actualUrl.replace("www.","");
			} 
		urlAddress=urlAddress.trim();
		actualUrl=actualUrl.trim();
		int eplength = urlAddress.length();
		int aclength = actualUrl.length();
		int lengthDiffrent =eplength-aclength;
		if (actualUrl.equals(urlAddress))
			{
				System.out.println("Expected Url ****** " + urlAddress + " ******* Found And Validation of Url Successfully Passed");
				Assert.assertTrue(true,"Expected Url ****** " + urlAddress + " ******* Found And Validation of Url Successfully Passed");
				log.info("Expected Url ****** ==> " + urlAddress + " <== ******* Found And Validation of Url Successfully Passed");
			}
		else if (actualUrl.equalsIgnoreCase(urlAddress))
			{
				System.out.println("Expected Url ****** " + urlAddress+ " ******* Found And Validation of Url Successfully Passed but there is lower and upper case character does not match actual Url was****"+ actualUrl+" ****");
				Assert.assertTrue(true, "Expected Url ****** " + urlAddress+ " ******* Found And Validation of Url Successfully Passed but there is lower and upper case character does not match actual Url was****"+ actualUrl+" ****");
				log.warn("Expected Url ****** " + urlAddress+ " ******* Found And Validation of Url Successfully Passed but there is lower and upper case character does not match actual Url was****"+ actualUrl+" ****");
			}
		else if (actualUrl.contains(urlAddress))
			{	
				System.out.println("Expected Url ****** " +urlAddress+ " ******* Found And Validation of Url Successfully Passed but Actual Url Contains expected Url current url is **** "+actualUrl+"****");
				Assert.assertTrue(true,"Expected Url ****** " +urlAddress+ " ******* Found And Validation of Url Successfully Passed but Actual Url Contains expected Url current url is **** "+actualUrl+"****");
				log.warn("Expected Url ****** " +urlAddress+ " ******* Found And Validation of Url Successfully Passed but Actual Url Contains expected Url current url is **** "+actualUrl+"****");
			} 
		else if (actualUrl.contains(urlAddress.toLowerCase()))
			{
				System.out.println("Expected Url ****** " +urlAddress+ " ******* Found And Validation of Url Successfully Passed but Actual Url Contains expected Url and does not match upper and lower case letter acutal url was **** "+actualUrl+" ****");
				Assert.assertTrue(true, "Expected Url ****** " +urlAddress+ " ******* Found And Validation of Url Successfully Passed but Actual Url Contains expected Url and does not match upper and lower case letter acutal url was **** "+actualUrl+" ****");
				log.warn("Expected Url ****** " +urlAddress+ " ******* Found And Validation of Url Successfully Passed but Actual Url Contains expected Url and does not match upper and lower case letter acutal url was **** "+actualUrl+" ****");
			}
		else if(lengthDiffrent>0 && lengthDiffrent<5)
			{
				if(urlAddress.toLowerCase().contains(actualUrl.toLowerCase()))
				{
					System.out.println("Expected Url ****** " +urlAddress+ " ******* Found And Validation of Url Successfully Passed but Actual Url Contains expected Url and might be does not match upper and lower case letter acutal url was **** "+actualUrl+" ****");
					Assert.assertTrue(true, "Expected Url ****** " +urlAddress+ " ******* Found And Validation of Url Successfully Passed but Actual Url Contains expected Url and might be does not match upper and lower case letter acutal url was **** "+actualUrl+" ****");
					log.warn("Expected Url ****** " +urlAddress+ " ******* Found And Validation of Url Successfully Passed but Actual Url Contains expected Url and might be does not match upper and lower case letter acutal url was **** "+actualUrl+" ****");
				}
			}
		else 
			{
				takeScreenShot("ValidateUrl");
				Assert.assertFalse(false, "Expected Url ***** " + urlAddress+ " ***** Not Found And Validation of Url Are Failed " + "Actual Url Was **** " + actualUrl+" ****");
				System.out.println("Expected Url ***** " + urlAddress+ " ***** Not Found And Validation of Url Are Failed " + "Actual Url Was **** " + actualUrl+" ****");
				log.error("Expected Url ****** ==> " + urlAddress+ " <== ****** Not Found And Validation of Url Are Failed " + "Actual Url Was **** " + actualUrl+" ****");
			}
		Reporter.log("******************************************Validate Url Ended******************************************");
		System.out.println("******************************************Validate Url Ended*************************************************");
	}
	/****************************************************************************************************************
	*  Author: Md Rezaul Karim 
    *  Function Name: validateText
	*  Function Arg: ExpectedText And Actual Text
	*  FunctionOutPut: It will Validate Expected Text And Actual Text
	 * @throws IOException 
	* 
	* ***************************************************************************************************************/
	public static void verifyDownload(String expFileName) {
		File objDir=new File(downloadPath+"//");
		File[] objFiles=objDir.listFiles();
		File lastModifiedFile=objFiles[0];
		for(int i=0;i<objFiles.length;i++)
		{
			if(lastModifiedFile.lastModified()<objFiles[i].lastModified()) {
				lastModifiedFile=objFiles[i];
			}
		}
		if(lastModifiedFile.getName().toString().startsWith(expFileName)) {
			System.out.println("Download Sucessfull");
		}
		
	}
	
	
	
	
	/****************************************************************************************************************
	*  Author: Md Rezaul Karim 
    *  Function Name: validateText
	*  Function Arg: ExpectedText And Actual Text
	*  FunctionOutPut: It will Validate Expected Text And Actual Text
	 * @throws IOException 
	* 
	* ***************************************************************************************************************/
		
	public static void validateText(String expectedText,String actualText) throws IOException {
		
		Reporter.log("******************************************Validate Text Started******************************************");
		System.out.println("******************************************Validate Text Started**********************************************");
		String exText;	
		String  acText;
		int expLength,actLength;
		String[]expText=expectedText.split(",");
		String[]actText=actualText.split(",");	
		expLength=expText.length;
		actLength=actText.length;	
		if(expLength>actLength)
			{
				expText=Arrays.copyOf(expText,(actLength));	
			}
		if(expLength<actLength)
			{
				actText=Arrays.copyOf(actText,(expLength));	
			}
		expLength=expText.length;
		actLength=actText.length;	
		int j=0;
		for(int i=0;i<expLength;i++)
			{
				while(j<actLength)
				{
					exText=expText[i].trim();
					acText=actText[j].trim();
					if (exText.equals(acText))
						{
							System.out.println("Expected Text Element  ****** " + exText + " ******* Found And Validation of Text Successfully Passed");
							Assert.assertTrue(true,"Expected Text Element  ****** " + exText + " ******* Found And Validation of Text Successfully Passed");
							log.info("Expected Text Element  ****** " + exText + " ******* Found And Validation of Text Successfully Passed");
						}
					else if (exText.equalsIgnoreCase(acText))
						{
							System.out.println("Expected Text Element ****** " +exText+ " ******* Found And Validation of Text Successfully Passed but there is lower and upper case character Does not match The Actual Text Was *** "+acText+" ***");
							Assert.assertTrue(true,"Expected Text Element ****** " +exText+ " ******* Found And Validation of Text Successfully Passed but there is lower and upper case character Does not match The Actual Text Was *** "+acText+" ***");
							log.warn("Expected Text Element ****** " +exText+ " ******* Found And Validation of Text Successfully Passed but there is lower and upper case character Does not match The Actual Text Was *** "+acText+" ***");
						}
					else if (exText.contains(acText))
						{
							System.out.println("Expected Text Element  ****** " +exText+ " ******* Found From Actual Text but Actual Text Contains expected Text And Validation of Text Successfully Passed The Actual Text Was *** "+acText+" ***");
							Assert.assertTrue(true,"Expected Text Element  ****** " +exText+ " ******* Found From Actual Text but Actual Text Contains expected Text And Validation of Text Successfully Passed The Actual Text Was *** "+acText+" ***");
							log.warn("Expected Text Element  ****** " +exText+ " ******* Found From Actual Text but Actual Text Contains expected Text And Validation of Text Successfully Passed The Actual Text Was *** "+acText+" ***");
						} 
					else if (exText.contains(acText.toLowerCase()))
						{
							System.out.println("Expected Text Element ****** " + exText+ " ******* Found From Actual Text but Actual Text Contains expected Text but there is lower and upper case character Does not match And Validation of Text SuccessfullyThe Actual Text Was *** "+acText+" ***");
							Assert.assertTrue(true,"Expected Text Element ****** " + exText+ " ******* Found From Actual Text but Actual Text Contains expected Text but there is lower and upper case character Does not match And Validation of Text Successfully The Actual Text Was *** "+acText+" ***");
							log.warn("Expected Text Element ****** " + exText+ " ******* Found From Actual Text but Actual Text Contains expected Text but there is lower and upper case character Does not match And Validation of Text SuccessfullyThe Actual Text Was *** "+acText+" ***");
						}
						else
						{
							takeScreenShot("ValidateText");
							Assert.assertFalse(false, "Expected Text Element  ***** " + exText+ " *****  Not Found And Validation of Text element  Are Failed " + "The Actual Text Was *** " + acText+" ***");
							System.out.println("Expected Text Element  ***** " + exText+ " *****  Not Found And Validation of Text element  Are Failed " + "The Actual Text Was *** " + acText+" ***");
							log.error("Expected Text Element  ***** " + exText+ " *****  Not Found And Validation of Text element  Are Failed " + "The Actual Text Was *** " + acText+" ***");
						}
					j++;
					break;
				}
			}
		Reporter.log("******************************************Validate Text Ended******************************************");
		System.out.println("******************************************Validate Text Ended************************************************");
	}
		
	/***************************************************************************************************************
	*  Author: Md Rezaul Karim 
	*  Function Name: ValidateHeader
	*  Function Arg: actualHeader(Get From Application header),expectedHeader
	*  FunctionOutPut: It will Validate Expected Header and Actual Header
	 * @throws IOException 
	* 
	* ***************************************************************************************************************/
		
	public static void validateTitle(String expectedTitle) throws IOException {
		
		Reporter.log("******************************************Validate Title Header Started******************************************");
		System.out.println("******************************************Validate Title Header Started*************************************************");
		String actualTitle = driver.getTitle();
		if (actualTitle.contains(expectedTitle))
			{
				Assert.assertTrue(true,"The Expected Title Header Is *** ==> "+actualTitle+" <==*** Found Test Case Pass Succefully");
				System.out.println("The Expected Title Header Is *** ==> "+actualTitle+" <==*** Found Test Case Pass Succefully");
			}
		else
			{
				takeScreenShot("ValidateTitle");
				Assert.assertTrue(false,"The Expected *** ==> "+expectedTitle+" <==*** Not Found Test Case Failed. The Actual Title was ***==> "+actualTitle+"<==*** ");
				System.out.println("The Expected *** ==> "+expectedTitle+" <==*** Not Found Test Case Failed. The Actual Title was ***==> "+actualTitle+"<==*** ");
			}
		Reporter.log("******************************************Validate Title Header Ended******************************************");
		System.out.println("******************************************Validate Title Header Ended*************************************************");
	}
	
	/****************************************************************************************************************
    *  Author: Md Rezaul Karim 
	*  Function Name: ValidateClick
	*  Function Arg: expectedClick ==>Its Element sent from method,TextElement==>Text Element Name That Clicked
	*  FunctionOutPut: It will Validate Expected Element Clicked Or Not
	 * @throws IOException 
	* 
	* ***************************************************************************************************************/
		
	public static void validateClick(WebElement expectedClick,String TextElement) throws IOException{
		
		Reporter.log("******************************************Validate Clicked Started******************************************");
		System.out.println("******************************************Validate Clicked Started*******************************************");
		if(! expectedClick.isDisplayed())
			{
				System.out.println("The Expected Element *** "+TextElement+" is Clicked Successfully");
				Assert.assertTrue(true,"The Expected Element *** "+TextElement+" is Clicked Successfully");
				log.info("The Expected Element *** "+TextElement+" is Clicked Successfully");
			}
		else
			{
				setBorder(expectedClick);	
				takeScreenShot("ValidateClick");	
				System.out.println("The Expected Element *** "+TextElement+" does not Performed Clicked Successfully");
				Assert.assertTrue(false,"The Expected Element *** "+TextElement+" does not Performed Clicked Successfully");
				log.error("The Expected Element *** "+TextElement+" does not Performed Clicked Successfully");
			}
		Reporter.log("******************************************Validate Clicked Ended******************************************");
		System.out.println("******************************************Validate Clicked Ended*********************************************");
	}
		
	/****************************************************************************************************************
	*  Author: Md Rezaul Karim 
	*  Function Name: validateInputValue
	*  Function Arg: expectedEditElement Its Element sent from method,actualEditValue=>The Value That Will Set on Input Field
	*  FunctionOutPut: It will Validate Expected Input Value Set On Input Filed or Not
	* 
	* ***************************************************************************************************************/
	
	public static void validateInputValue(WebElement expectedEditElement,String actualEditValue) {
		
		Reporter.log("******************************************Validate Input Value Started******************************************");
		System.out.println("******************************************Validate Input Value Started***************************************");
		String EditValue=expectedEditElement.getAttribute("value");
		if((EditValue.trim()).equals(actualEditValue))
			{
				System.out.println("The Expected Input Value *** "+actualEditValue+" *** is Successfully Set on Input Box");
				Assert.assertTrue(true,"The Expected Input Value *** "+actualEditValue+" *** is Successfully Set on Input Box");
				log.info("The Expected Input Value *** "+actualEditValue+" *** is Successfully Set on Input Box");
			}
		else
			{
				System.out.println("The Expected Input Value *** "+actualEditValue+" *** Does not Set on Input Box Actual Input Value Was  *** "+EditValue+" ***");
				Assert.assertTrue(false,"The Expected Input Value *** "+actualEditValue+" *** Does not Set on Input Box Actual Input Value Was  *** "+EditValue+" ***");
				log.error("The Expected Input Value *** "+actualEditValue+" *** Does not Set on Input Box Actual Input Value Was  *** "+EditValue+" ***");
			}
		Reporter.log("******************************************Validate Input Value Ended******************************************");
		System.out.println("******************************************Validate Input Value Ended*****************************************");
	}
	
	/****************************************************************************************************************
	*  Author: Md Rezaul Karim 
	*  Function Name: validateDropValue
	*  Function Arg: expectedDropElement ==> Its Element sent from method, ActualSelectedValue==>The Value That Will Set on Input Field
	*  FunctionOutPut: It will Validate Expected Input Value Set On Input Filed or Not
	*
	**************************************************************************************************************/
	
	public static void validateDropValue(WebElement expectedDropElement,String ActualSelectedValue) throws InterruptedException {
		
		Reporter.log("****************************************** Validate Drop Value Started ******************************************");
		System.out.println("******************************************Validate Drop Value Started ***************************************");
		
		String SelectedValue=expectedDropElement.getAttribute("value");
		if((SelectedValue.trim()).equals(ActualSelectedValue.trim()))
			{
				System.out.println("The Expected Selected Input Value *** "+SelectedValue+" *** is Successfully Set on Drop Down List");
				Assert.assertTrue(true,"The Expected Selected Input Value *** "+SelectedValue+" *** is Successfully Set on Drop Down List");
				log.info("The Expected Selected Input Value *** "+SelectedValue+" *** is Successfully Set on Drop Down List");
			}
		else
			{
				System.out.println("The Expected Selected Input Value *** "+ActualSelectedValue+" *** Does not Set on Drop Down List The Actual Selected Input Value Was  *** "+SelectedValue+" ***");
				Assert.assertTrue(false,"The Expected Selected Input Value *** "+ActualSelectedValue+" *** Does not Set on Drop Down List The Actual Selected Input Value Was  *** "+SelectedValue+" ***");
				log.error("The Expected Selected Input Value *** "+ActualSelectedValue+" *** Does not Set on Drop Down List The Actual Selected Input Value Was  *** "+SelectedValue+" ***");
			}
		Reporter.log("******************************************Validate Drop Value Ended******************************************");
		System.out.println("******************************************Validate Drop Value Ended******************************************");
	}
	
	/****************************************************************************************************************
	*  Author: Md Rezaul Karim 
	*  Function Name: ValidateStringShort
	*  Function Arg: expectedEditElement Its Element sent from method,ActualEditValue=>The Value That Will Set on Input Field
	*  FunctionOutPut: It will Validate Expected Input Value Set On Input Filed or Not
	* ***************************************************************************************************************/
	
	public static void validateStringShort(String ExpectedValue[], String Locator) {
		
		Reporter.log("******************************************Validate String Short Started******************************************");
		System.out.println("******************************************Validate String Short Started**************************************");
		List<WebElement> objCol = driver.findElements(By.xpath(Locator));
		ArrayList<String> originalList = new ArrayList<String>();
		for (int i = 0; i < objCol.size(); i++)
			{
				originalList.add(objCol.get(i).getText());
			}
		ArrayList<String> copyList = new ArrayList<String>();
		for (int i = 0; i < originalList.size(); i++)
			{
				copyList.add(originalList.get(i));
			}
		Collections.sort(copyList);
		Assert.assertTrue(originalList.equals(copyList), "Expected Value Are Shorted:");
		Reporter.log("******************************************Validate String Short Ended******************************************");
		System.out.println("******************************************Validate String Short Ended****************************************");
	}
	
	/****************************************************************************************************************
	*  Author: Md Rezaul Karim 
	*  Function Name: ValidateBrookenLink
	*  Function Arg: expectedEditElement Its Element sent from method,ActualEditValue=>The Value That Will Set on Input Field
	*  FunctionOutPut: It will Validate Expected Input Value Set On Input Filed or Not
	* 
	* ***************************************************************************************************************/

	public static void validateBrookenLink(String Locator, int TotalLink) throws InterruptedException {

		Reporter.log("******************************************Validate Brooken Link Started ******************************************");
		System.out.println("******************************************Validate Brooken Link Started *************************************");
		List<WebElement> objLink = driver.findElements(By.tagName("a"));
		int totalLink = objLink.size();
		int j=0;
		String CtrLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
		for (int i = 0; i < totalLink; i++)
		{
			objLink.get(i).sendKeys(CtrLink);
			Thread.sleep(2000);
			j++;
			if(TotalLink>0)
			{
				if(j==TotalLink)
				{
					break;
				}
			}
		}
		Set<String> objWindow = driver.getWindowHandles();
		java.util.Iterator<String> it = objWindow.iterator();
		while (it.hasNext()) 
		{
			String currentTitle = driver.switchTo().window(it.next()).getTitle();
			System.out.println(currentTitle);
		}
		Reporter.log("******************************************Validate Brooken Link Ended******************************************");
		System.out.println("******************************************Validate Brooken Link Ended****************************************");
	}

	public static void validateColor(String expColor,WebElement expColorEl) throws IOException {
		//boolean colorResult=null;
		String actualColor=expColorEl.getCssValue("color");
		validateText(expColor,actualColor);
	}
	
	////******************************   All Input And Random Data Function  ***********************************************************
	
	public static List<LinkedHashMap<String,String>> fetchTable(String expColumn){
		List<LinkedHashMap<String,String>> allData=new ArrayList<LinkedHashMap<String,String>>();
		boolean checkifMorePage;
		List<String> allHeaderName=new ArrayList<String>();
		if(expColumn.isEmpty() || expColumn.length()<1) {
			List<WebElement> allHeaderEl=log4j2.xmllog4j2.xmllog4j2.xml
					.TableHeaderValue();
			for(WebElement header : allHeaderEl ) {
				String headerName=header.getText().replaceAll("\r\n","").replaceAll("ui-btn","").trim();
				allHeaderName.add(headerName);
			}
		}
		else {
			String[] expColumnSplit=expColumn.split(",");
			allHeaderName=Arrays.asList(expColumnSplit);
		}
		int totalColumn=allHeaderName.size();
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		do {
			int totalRowList=cf.TableRowValueList().Size();
			for(int i=0;i<totalRowList;i++) {
				LinkedHashMap<String,String> eachRowData=new LinkedHashMap<>();
				int k=0;
				for(int j=0;j<totalColumn;j++) {
					String cellValue=cf.TableRowValuelist().get(i+k).getText();
					k=k+1;
					eachRowData.put(allHeaderName.get(j), cellValue)
				}
				i=i+k-1;
				allData.add(eachRowData);
			}
			checkifMorePage=cf.RightArrow().get
		}
		return allData;
	}
	/****************************************************************************************************************
	 *  Author: Md Rezaul Karim 
	 *  Function Name: getInput
	 *  Function Arg: No Arguments
	 *  FunctionOutPut: It will get input from keyboard
	 * 
	 * ***************************************************************************************************************/
	public static void  getInput() {
		
		Reporter.log("******************************************Get Input Stared******************************************");
		System.out.println("******************************************Get Input Stared***************************************************");
		Scanner objInputValue = new Scanner(System.in);
		String inputValue = "";
		while (!(inputValue.equalsIgnoreCase("Exit"))) {
			System.out.println(" Please Enter Your Value:(For Exit Please Enter Exit:)=>");
			inputValue = objInputValue.nextLine();
			if(!inputValue.equalsIgnoreCase("exit"))
				{
					System.out.println("You Enter :" + inputValue );
				}
		}
		System.out.println("Exit from input taker ");
		Reporter.log("******************************************Get Input Ended******************************************");
		System.out.println("******************************************Get Input Ended****************************************************");
	}
	
	/****************************************************************************************************************
	 *  Author: Md Rezaul Karim 
	 *  Function Name:randomNumeric
	 *  Function Arg: StringSize how many digit do you want Number
	 *  FunctionOutPut: It will get input from function and return Random numeric Number String
	 * 
	 * ***************************************************************************************************************/
	
	public static String randomNumeric(int stringSize) {
		
		Reporter.log("******************************************Create Random Numeric Strated******************************************");
		System.out.println("******************************************Create Random Numeric Strated**************************************");
		String AlphaNumericString ="0123456789"; 
		StringBuilder objString = new StringBuilder(stringSize);
		for(int i=0;i<stringSize;i++)
		{
			// generate a random number between 0 to AlphaNumericString variable length
			int index=(int) (AlphaNumericString.length()*Math.random());
			objString.append(AlphaNumericString.charAt(index));
		}
		String randomNumeric=objString.toString();
		System.out.println(objString.toString());
		Reporter.log("******************************************Create Random Numeric Ended******************************************");
		System.out.println("******************************************Create Random Numeric Ended****************************************");
		return randomNumeric;
	}
	
	/****************************************************************************************************************
	 *  Author: Md Rezaul Karim 
	 *  Function Name:RandomDecimal 
	 *  Function Arg: StringSize how many digit do you want Number
	 *  FunctionOutPut: It will get input from function and return Random numeric Number String
	 * 
	 * ***************************************************************************************************************/
	
	public static String randomDecimal  (int stringSize) {
		
		Reporter.log("******************************************Create Random Decimal Number Started******************************************");
		System.out.println("******************************************Create Random Decimal Number Started*******************************");
		String AlphaNumericString ="0123456789"; 
		StringBuilder objString = new StringBuilder(stringSize);
		for(int i=0;i<stringSize;i++)
		{
			// generate a random number between 0 to AlphaNumericString variable length
           	int index=(int) (AlphaNumericString.length()*Math.random());
			objString.append(AlphaNumericString.charAt(index));
		}
		String randomDecimal =objString.toString()+".49";
		System.out.println(objString.toString());
		Reporter.log("******************************************Create Random Decimal Number Ended******************************************");
		System.out.println("******************************************Create Random Decimal Number Ended****************************************");
		return randomDecimal ;
	}
	
	/****************************************************************************************************************
	 *  Author: Md Rezaul Karim 
	 *  Function Name:RandomAlphaNumeric
	 *  Function Arg: StringSize how many digit do you want string
	 *  FunctionOutPut: It will get input from function and return Random Alpha numeric String
	 * 
	 * ************************************************************************************************************** */
	
	public static String randomAlphaNumeric(int stringSize) {
		
		Reporter.log("******************************************Create Random Alpha Numeric Started******************************************");
		System.out.println("******************************************Create Random Alpha Numeric Started********************************");
		
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789"+ "abcdefghijklmnopqrstuvxyz"; 
		StringBuilder objString = new StringBuilder(stringSize);
		for(int i=0;i<stringSize;i++)
		{
			// generate a random number between 0 to AlphaNumericString variable length
            int index=(int) (AlphaNumericString.length()*Math.random());
			objString.append(AlphaNumericString.charAt(index));
		}
		String randomAlphaNumeric=objString.toString();
		System.out.println(objString.toString());
		
		Reporter.log("******************************************Create Random Alpha Numeric Ended******************************************");
		System.out.println("******************************************Create Random Alpha Numeric Ended**********************************");
		return randomAlphaNumeric;
	}

	/****************************************************************************************************************
	 *  Author: Md Rezaul Karim 
	 *  Function Name:RandomUpperLower
	 *  Function Arg: StringSize how many digit do you want string
	 *  FunctionOutPut: It will get input from function and return Random Alpha  character upper and lower case String
	 * 
	 * ***************************************************************************************************************/
	
	public static String randomUpperLower(int stringSize) {
		
		Reporter.log("******************************************Create Random Upper Lower Case String Started******************************************");
		System.out.println("******************************************Create Random Upper Lower Case String Started**********************");
		
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz"; 
		StringBuilder objString = new StringBuilder(stringSize);
		for(int i=0;i<stringSize;i++)
		{
			// generate a random number between 0 to AlphaNumericString variable length 
            int index=(int) (AlphaNumericString.length()*Math.random());
			objString.append(AlphaNumericString.charAt(index));
		}
		String randomUpperLower=objString.toString();
		System.out.println(objString.toString());
		
		Reporter.log("******************************************Create Random Upper Lower Case String Ended******************************************");
		System.out.println("******************************************Create Random Upper Lower Case String Ended************************");
		return randomUpperLower;
	}

	/****************************************************************************************************************
	 *  Author: Md Rezaul Karim 
	 *  Function Name:RandomAlphaNumericSpeceal
	 *  Function Arg: StringSize how many digit do you want string
	 *  FunctionOutPut: It will get input from function and return Random Alpha numeric and special character String
	 * 
	 * ***************************************************************************************************************/
	
	public static String randomAlphaNumericSpeceal(int stringSize) {
		
		Reporter.log("******************************************Create Random Numeric Speceal String Started******************************************");
		System.out.println("******************************************Create Random Numeric Speceal String Started***********************");
		
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789"+"!@#$%^&*()_+<>?"+ "abcdefghijklmnopqrstuvxyz"; 
		StringBuilder objString = new StringBuilder(stringSize);
		for(int i=0;i<stringSize;i++)
		{
			// generate a random number between 0 to AlphaNumericString variable length
            int index=(int) (AlphaNumericString.length()*Math.random());
			objString.append(AlphaNumericString.charAt(index));
		}
		String randomAlphaNumericSpeceal=objString.toString();
		System.out.println(objString.toString());
		
		Reporter.log("******************************************Create Random Numeric Speceal String Ended******************************************");
		System.out.println("******************************************Create Random Numeric Speceal String Ended****************************************");
		
		return randomAlphaNumericSpeceal;
	}
	
	public static void Prime(int ExpNum)
	{
		int Num;
		ArrayList primeNumber=new ArrayList();
		String PrimeNumber="";
		int Tag=0;
		for(int i=1;i<=ExpNum;i++)
		{
			int count=0;
			for(Num=i;Num>=1;Num--)
			{
				if(i%Num==0)
				{
					count=count+1;
				}
			}
			if(count==2)
			{
				primeNumber.add(i);
				PrimeNumber=PrimeNumber+i+" ";
				
				Tag=Tag+1;
			}
			
		}
		for(int i=0;i<primeNumber.size();i++)
		{
			System.out.print(primeNumber.get(i));
		}
	}
	/****************************************************************************************************************
	 *  Author: Md Rezaul Karim 
	 *  Function Name:isPrime
	 *  Function Arg:ExpNum 
	 *  FunctionOutPut: It will get if number is prime number or not 
	 * 
	 * ***************************************************************************************************************/
	
	public static boolean isPrime(int ExpNum){
		if(ExpNum<=1) {
			return false;
		}
		for(int i=2;i<ExpNum;i++)
		{
			if(ExpNum%i==0) {
				return false;
			}
		}
		return true;
		}
	/****************************************************************************************************************
	 *  Author: Md Rezaul Karim 
	 *  Function Name:primeNumber
	 *  Function Arg:ExpNum 
	 *  FunctionOutPut: It will print prime number 
	 * 
	 * ***************************************************************************************************************/
	
	public static void primeNumber(int ExpNum) {
		for(int i=2;i<=ExpNum;i++) {
			if(isPrime(i)) {
				System.out.print(i+" ");
			}
		}
	}
	/****************************************************************************************************************
	 *  Author: Md Rezaul Karim 
	 *  Function Name:palindrom
	 *  Function Arg:ExpNum 
	 *  FunctionOutPut: It will print prime number 
	 * 
	 * ***************************************************************************************************************/
	public static void palindrom(int expNumber) {
		int r=0,sum=0,t;
		t=expNumber;
		while(expNumber>0) {
			r=expNumber%10;
			sum=(sum*10)+r;
			expNumber=expNumber/10;
		}
		if(t==sum) {
			System.out.println("Given Number Is palindrome");
		}
		else {
			System.out.println("Given Number is not panidrome");
		}
	}
	
	/****************************************************************************************************************
	 *  Author: Md Rezaul Karim 
	 *  Function Name:palindrom
	 *  Function Arg:ExpNum 
	 *  FunctionOutPut: It will print prime number 
	 * 
	 * ***************************************************************************************************************/
	public static void armstrongNumber(int expNumber) {
		int r=0,sum=0,t;
		t=expNumber;
		while(expNumber>0) {
			r=expNumber%10;
			sum=sum+(r*r*r);
			expNumber=expNumber/10;
		}
		if(t==sum) {
			System.out.println("Given Number Is ArmstronNumber");
		}
		else {
			System.out.println("Given Number is not ArmstronNumber");
		}
	}
	/****************************************************************************************************************
	 *  Author: Md Rezaul Karim 
	 *  Function Name:countword
	 *  Function Arg:ExpNum 
	 *  FunctionOutPut: It will print prime number 
	 * 
	 * ***************************************************************************************************************/

	public static void countWord(String expString) {
		int count;
		String str[]=expString.split(" ");
		for(int i=0;i<str.length;i++) {
			count=1;
			for(int j=i+1;j<str.length;j++) {
				if(str[i].equals(str[j])) {
					count++;
					str[j]="0";	
				}
			}
			if(str[i]!="0") {
				System.out.println(str[i]+"\t"+count);
			}
		}
	}
	/****************************************************************************************************************
	 *  Author: Md Rezaul Karim 
	 *  Function Name:findDuplicateWord
	 *  Function Arg:ExpNum 
	 *  FunctionOutPut: It will print prime number 
	 * 
	 * ***************************************************************************************************************/

	public static void findDuplicateWord(String expString) {
		int count;
		String str[]=expString.split(" ");
		for(int i=0;i<str.length;i++) {
			count=1;
			for(int j=i+1;j<str.length;j++) {
				if(str[i].equals(str[j])) {
					count++;
					str[j]="0";	
				}
			}
			if(count>1 && str[i]!="0") {
				System.out.println(str[i]+"\t"+count);
			}
		}
	}
//======================================================		User Action Method		===================================================
	
	
	
	/****************************************************************************************************************
	*  Author: Md Rezaul Karim 
	*  Function Name: SetClander
	*  Function Arg: String dateLocator, String monthLocator, String yearLocator, String nextLocator,String expectedDate
	*  FunctionOutPut: It will Select value from drop down when drop down is not able to select by select tag
	* 
	* ***************************************************************************************************************/
	
	public static void SetClander(String dateLocator, String monthLocator, String yearLocator, String nextLocator,String expectedDate) throws InterruptedException {
		
		Reporter.log("******************************************Set Clander Started******************************************");
		System.out.println("******************************************Set Clander Started************************************************");
		
		String expDate[] = expectedDate.split("/");
		String Month=expDate[0];
		String day=expDate[1];
		String years=expDate[2];
		driver.findElements(By.xpath(dateLocator));
		if (years.length() < 3)
			{
			years = ("20" + years);
			}
		else 
			{
			years = years;
			}
		for (int i = 0; i < 11; i++)
		{
			WebElement objMonth = driver.findElement(By.xpath(monthLocator));
			WebElement objYear = driver.findElement(By.xpath(yearLocator));
			String month = objMonth.getText();
			String year = objYear.getText();
			if (month.toLowerCase().contains(Month.toLowerCase()))
				{
					if (year.toLowerCase().contains(years.toLowerCase()))
						{
							break;
						}
				} 
			else
				{
					driver.findElement(By.xpath(nextLocator)).click();
				}
		}
		List<WebElement> listDate = driver.findElements(By.xpath(dateLocator));
		int totalDate = listDate.size();
		for (int i = 0; i < totalDate; i++)
		{
			String actualDate = listDate.get(i).getText();
			String reActualDate = actualDate.trim();
			if (reActualDate.contains(day))
				{
					if(listDate.get(i).isEnabled())//check if date is enable 
					{
						listDate.get(i).click();
						break;
					}
					else
					{
						System.out.println("The Date you want select is Disable");
					}	
				}
		}
		Reporter.log("******************************************Set Clander Ended******************************************");
		System.out.println("******************************************Set Clander Ended******************************************************");
	}	
	
	
	//*******************************************          Utility               *****************************************************//

	
	
	/****************************************************************************************************************
	*  Author: Md Rezaul Karim 
	*  Function Name: setAlert
	*  Function Arg:  
	*  FunctionOutPut: It will handle Alert acuction
	* 
	* **************************************************************************************************************/
	
	public static  Alert setAlert(){
		Alert alert = driver.switchTo().alert();
		return alert;
	}
	
	/****************************************************************************************************************
	*  Author: Md Rezaul Karim 
	*  Function Name: setAlert
	*  Function Arg:  
	*  FunctionOutPut: It will handle Alert acuction
	 * @return 
	* 
	* **************************************************************************************************************/
	
	public static   boolean isAlertPresent(){
		try {
				driver.switchTo().alert();
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
	}
	
	/****************************************************************************************************************
	*  Author: Md Rezaul Karim 
	*  Function Name: frame
	*  Function Arg:  ExFrame it can be index or webelement or value 
	*  FunctionOutPut: It will handle frame auction
	* 
	* 
	**************************************************************************************************************/
	
	public static   WebDriver setFrame(WebElement ExFrame){
		 WebDriver frame = driver.switchTo().frame(ExFrame);
		return frame;
	}
	
	/****************************************************************************************************************
	*  Author: Md Rezaul Karim 
	*  Function Name: frame
	*  Function Arg:  ExFrame it can be index or webelement or value 
	*  FunctionOutPut: It will handle frame auction
	* 
	* 
	**************************************************************************************************************/
	
	public static    Actions setAction(){
		Actions  action = new Actions(driver);
		return action;
	}
	
	/****************************************************************************************************************
	*  Author: Md Rezaul Karim 
	*  Function Name: uniqueName
	*  Function Arg:  expFileStart it can be start With File Name  
	*  FunctionOutPut: It will Create A Unique File Name 
	**************************************************************************************************************/
	
	public static String uniqueName(String expFileStart) {
		if(expFileStart==null || expFileStart.length()<1) {
			expFileStart="Test";
		}
		Date objd=new Date();
		String expName=expFileStart+"_"+ objd.toString().replace(":","_").replace(" ","_");
		return expName;
	}

	/****************************************************************************************************************
	*  Author: Md Rezaul Karim 
	*  Function Name: createFolder
	*  Function Arg: String expFolderName
	*  FunctionOutPut: It will take Create a folder with current date
	* 
	***************************************************************************************************************/
	
	public static String createFolder(String expFolderNameAndPath) {

		Reporter.log("********************************Folder Create Strated******************************************");
		String folderNamePath;
		String UName = uniqueName("Test"); // Replace -
		if (expFolderNameAndPath.isEmpty() || expFolderNameAndPath.length()<1) // Check if user provide folder path?
		{
			folderNamePath = "c:\\Qa\\" + UName;
		} else {
			folderNamePath = expFolderNameAndPath;
		}
		File file = new File(folderNamePath);
		if (!file.exists()) {
			file.mkdirs();
		} else {
			System.out.println("******************Directory already exists***********************************");
		}
		Reporter.log("***************************Folder Create Ended******************************************");
		return folderNamePath;
	}
	
	/****************************************************************************************************************
	*  Author: Md Rezaul Karim 
	*  Function Name: createFolder
	*  Function Arg: String expFolderName
	*  FunctionOutPut: It will take Create a folder with current date
	* 
	***************************************************************************************************************/
	
	public static String createFolderFile(String expFolderNameAndPath,String expFile,String expFileExtention) throws IOException{
	 	
		Reporter.log("*****************Folder and File Create Strated******************************************");
		String folderPath = createFolder(expFolderNameAndPath);
		if (expFile.isEmpty()|| expFile.length()<1) {
			expFile=uniqueName("Test");;
		}
		if (expFileExtention.isEmpty()|| expFileExtention.length()<1) {
			expFileExtention=".docx";
		} 
		
		String filePath =folderPath+ "\\" + expFile + "_" + expFileExtention;
		
		File file = new File(filePath);
		if (file.createNewFile()) {
			Reporter.log("******************************** File Created ******************************************");
		} else {
			Reporter.log("******************************** File Exist ******************************************");
			}
		return filePath;
	}
		
	/****************************************************************************************************************
	*  Author: Md Rezaul Karim 
	*  Function Name: takeScreenShot
	*  Function Arg: methodName
	*  FunctionOutPut: It will take a screen shot from screen
	 * @return 
	* 
	***************************************************************************************************************/
		
	public static String takeScreenShot(String expScName,String expScShotType) throws IOException {
		if(expScName==null||expScName.length()<1) {
			expScName="Screen";
		}
		if(expScShotType==null||expScShotType.length()<1) {
			expScName=".png";
		}
		String UName=uniqueName("Test");
		String filePath=System.getProperty("user.dir")+"//Screenshots//"+expScName+UName+expScShotType;
		Screenshot objsc=new AShot().takeScreenshot(driver);
		ImageIO.write(objsc.getImage(),"PNG",new File(filePath));
		return filePath;
	}
	
	/****************************************************************************************************************
	*  Author: Md Rezaul Karim 
	*  Function Name: setBorder
	*  Function Arg: expElement which element want make border 
	*  FunctionOutPut: It will make border which element you want 
	* 
	***************************************************************************************************************/
		
	public static void setBorder(WebElement expElement) throws IOException {
		jse.executeScript("arguments[0].style.border='3px solid red'", expElement);
	}
	
	
	//*******************************************          Close                 *****************************************************//
	
	/****************************************************************************************************************
	*  Author: Md Rezaul Karim 
	*  Function Name: CloseBrowser
	*  Function Arg: expCloseBrowser ==> Do You Want Close All Browser that open or just current browser if user does not provied any it will close all browser
	*  FunctionOutPut: It will close all browser or current browser
	* 
	* ***************************************************************************************************************/
	
	public static void closeBrowser(String expCloseBrowser) {
		
		Reporter.log("****************************************** Expected Browser Close Started ******************************************");
		System.out.println("****************************************** Expected Browser Close Started ***********************************");
		if((expCloseBrowser.toLowerCase()).contains("current"))
		{
			driver.close();
		}
		else
		{
			driver.quit();
		}
		
		driver=null;
		Reporter.log("******************************************Expected Browser Closed ******************************************");
		System.out.println("****************************************** Expected Browser Closed ******************************************");
	}
	@AfterClass
	public static void tearDown() {
		
		Reporter.log("****************************************** Expected Browser Close Started ******************************************");
		System.out.println("****************************************** Expected Browser Close Started ***********************************");
		
			driver.quit();
		driver=null;
		Reporter.log("******************************************Expected Browser Closed ******************************************");
		System.out.println("****************************************** Expected Browser Closed ******************************************");
	}
	/****************************************************************************************************************
	*  Author: Md Rezaul Karim 
	*  Function Name: closeExpectedWindow
	*  Function Arg: expWindowTabClose  ==> it will take number of child window tab that user want close
	*  FunctionOutPut: close child window
	* 
	* **************************************************************************************************************/
	
	public static void closeExpectedWindow(String expWindowTabClose){
		
		String[] ExTab=expWindowTabClose.split(",");
		int totalTab=ExTab.length;
		String PareantWindow=driver.getWindowHandle();
		System.out.println("No. of tabs: " + PareantWindow);
		Set<String> objWhandles = driver.getWindowHandles();
		ArrayList<String> objTab=new ArrayList<String>(objWhandles);
		int TotalWindow=objWhandles.size();
		for(int i=0;i<totalTab;i++)
			{
				driver.switchTo().window(objTab.get(Integer.parseInt(ExTab[i]))).close();
				System.out.println("No. of tabs: " +TotalWindow);	
			}
		driver.switchTo().window(PareantWindow);
	}
	
	/****************************************************************************************************************
	*  Author: Md Rezaul Karim 
	*  Function Name: CloseAllChildWindow
	*  Function Arg: it will close all  child window tab that user open
	*  FunctionOutPut: close all child window
	* 
	* ***************************************************************************************************************/
		
	public static void CloseAllChildWindow(){
		
		String PareantWindow=driver.getWindowHandle();
		System.out.println("No. of tabs: " + PareantWindow);
		Set<String> objWhandles = driver.getWindowHandles();
		int TotalWindow=objWhandles.size();
		for(String child:objWhandles)
			{
				if(!PareantWindow.equalsIgnoreCase(child))
				{
					driver.switchTo().window(child).close();
					System.out.println("No. of tabs: " +TotalWindow);
				}
			}
		driver.switchTo().window(PareantWindow);
	}
	
	public static void factorial(int n)
	{
		for(int i=n;i>0;i--)
		{
			if(i==1)
			{
				System.out.print(i);
			}
			else
			{
				System.out.print(i+"*");
			}
			
		}
		
	}
	
	public static boolean findlipYear(int expYear) {
		boolean res = true;
		if(expYear%4==0) {
			if(expYear%100==0) {
				if(expYear%400==0) {
					res=true;
				}
				else {
					 res=false;
				}
			}
			else {
				res=true;
			}
		
		}
		return res;
	}
	
}
