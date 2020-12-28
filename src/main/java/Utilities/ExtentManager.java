package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Common.BaseClass;

public class ExtentManager extends BaseClass {

	public static ExtentReports extent;

	public static ExtentReports createInstance() {
		String fileName =getReportName(); 
		String directory=System.getProperty("user.dir") + "/Report/";
		new File(directory).mkdirs();
		String reportPath=directory+fileName;
		System.out.println(reportPath);
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);
		//htmlReporter=new ExtentHtmlReporter("./Report/"+fileName+".html");
	//	htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
	//	htmlReporter.config().setChartVisibilityOnOpen(true);
		
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
	public static String getReportName() {
		Date objd=new Date();
		String expName="Test_"+ objd.toString().replace(":","_").replace(" ","_")+".html";
		return expName;
	}
}