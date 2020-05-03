package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	public static Properties objprop;
	
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
	
	
	
	
	
	
}
