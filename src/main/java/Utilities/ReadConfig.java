package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.Reporter;

public class ReadConfig {
	public static Properties objprop;
	public static String userId;
	public static String userPassword;
	public static String Description;
	public static String Title;
	public static String urlAddress;
	public static String DomainName;
	
/*********************************  Test Base Constractor **********************************************************************************/
	public ReadConfig()
	{
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
	}
	
	public String getBrowserName(){
		String browserName = objprop.getProperty("browserName");
		return browserName;
	}
	
	public String getChromePath(){
		String chromePath=objprop.getProperty("chromePath");
		return chromePath;
	}
	public String getffPath(){
		String ffPath=objprop.getProperty("ffPath");
		return ffPath;
	}
	public String getiePath(){
		String iePath=objprop.getProperty("iePath");
		return iePath;
	}
	
	public int getPAGE_LOAD_TIME(){
		int PAGE_LOAD_TIME=Integer.parseInt(objprop.getProperty("pageLoadTime"));
		return PAGE_LOAD_TIME;
	}
	public int getIMPLICIT_WAIT(){
		int IMPLICIT_WAIT=Integer.parseInt(objprop.getProperty("implicitWait"));
		return IMPLICIT_WAIT;
	}
	public int getexpWait(){
		int expWait=Integer.parseInt(objprop.getProperty("expWait"));
		return expWait;
	}
	public String getUrl(){
		String url = objprop.getProperty("Url");
		return url;
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
	
	
	
	
}
