package rahulshettyacademy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports getReportObject() {
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter extentreport=new ExtentSparkReporter(path);
		extentreport.config().setReportName("Web Automation Results");
		extentreport.config().setDocumentTitle("Test Results");
		
		ExtentReports extent =new ExtentReports();
		extent.attachReporter(extentreport);
		extent.setSystemInfo("Tester", "Onkar Girkar");
		return extent;
	}

}
