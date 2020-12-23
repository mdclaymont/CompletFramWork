package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.Reporter;

public class ReadConfig {
	public static Properties appProperties;
	public static Properties objprop;
	public static String userId;
	public static String userPassword;
	public static String Description;
	public static String Title;
	public static String urlAddress;
	public static String DomainName;
	
			
	/********************** Test Base Constractor ************************************
	 * Author: Md Rezaul Karim
	 *  Function Name: readProperties 
	 *  Function Arg: String
	 * expFilePath FunctionOutPut: It will encoded String
	 * 
	 ***********************************************************************************************************/
	public static void readProperties(String expFilePath) {
		appProperties = new Properties();
		if (expFilePath.isEmpty() || expFilePath.length() < 1) { 
				expFilePath = "./Configuration/Config.properties";// If User provied Any properties File Path if Not use Configuration folder
		}
		File objsrc = new File(expFilePath);
		try {
			
			FileInputStream objFile = new FileInputStream(objsrc);
			objprop = new Properties();
			objprop.load(objFile);
			appProperties.putAll(objprop);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
