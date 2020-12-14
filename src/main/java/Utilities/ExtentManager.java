package Utilities;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Common.BaseClass;

public class ExtentManager extends BaseClass {
    
   public static ExtentReports extent;
    
   public static ExtentReports createInstance() {
	   String fileName = null;
	try {
		fileName = createFolderFile(System.getProperty("user.dir")+"/Report/","",".html");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Automation Test Report");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(fileName);
        
        extent = new ExtentReports();
        extent.setSystemInfo("Browser Name",browserName);
        extent.setSystemInfo("OS Name",System.getProperty("os.name"));
        extent.setSystemInfo("machen ",System.getProperty("user.name"));
        extent.attachReporter(htmlReporter);
        
        return extent;
     }
}