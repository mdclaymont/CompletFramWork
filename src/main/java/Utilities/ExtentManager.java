package Utilities;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Common.BaseClass;

public class ExtentManager extends BaseClass {

	public static ExtentReports extent;

	public static ExtentReports createInstance1() {
		String fileName =getReportName(); 
		String directory=System.getProperty("user.dir") + "/Report/";
		new File(directory).mkdirs();
		String reportPath=directory+fileName;
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportPath);
		htmlReporter.config().setDocumentTitle("Automation Test Report");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Automation Test Result");
		htmlReporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.setSystemInfo("Browser Name", browserName);
		extent.setSystemInfo("OS Name", System.getProperty("os.name"));
		extent.setSystemInfo("machen ", System.getProperty("user.name"));
		extent.attachReporter(htmlReporter);

		return extent;
	}
	
public static ExtentReports createInstance() {
		
		String fileName =getReportName(); 
		String directory=System.getProperty("user.dir") + "/Report/";
		new File(directory).mkdirs();
		String reportPath=directory+fileName;
		ExtentSparkReporter spark=new ExtentSparkReporter(reportPath);
		spark.config().setEncoding("UTF-8");
		spark.config().setDocumentTitle("Test Automation Report");
		spark.config().setReportName("Automation test Results");
		spark.config().setTheme(Theme.STANDARD);
		extent=new ExtentReports();
		extent.setSystemInfo("Organization","Windows OS");
		extent.setSystemInfo("Browser","Chrome");
		extent.attachReporter(spark);
		return extent;
	}
	
	public static void extentFlush() {
		extent.flush();
	}
	public static String getReportName() {
		Date objd=new Date();
		String expName="Test_"+ objd.toString().replace(":","_").replace(" ","_")+".html";
		return expName;
	}
}