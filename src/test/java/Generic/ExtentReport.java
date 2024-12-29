package Generic;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport{
	static ExtentTest logger;
	static ExtentTest test;	
	static ExtentReports report;
	public static void beforetest() {
	ExtentSparkReporter htmlReport = new ExtentSparkReporter("MyReport.html");	//Report File
	report = new ExtentReports();		//Report
	report.attachReporter(htmlReport);				//Attaching the file with report
					//Represents test cases
	//Add environment details
	/*report.setSystemInfo("Machine Name", "Dell");
	report.setSystemInfo("OS", "Windows 11");
	report.setSystemInfo("User", "Rashmitha");
	report.setSystemInfo("Browser", "Google Chrome");
	
	//Configure Report
	htmlReport.config().setDocumentTitle("My TestNG Report");
	htmlReport.config().setReportName("My Report");
	htmlReport.config().setTheme(Theme.DARK);
	htmlReport.config().setTimeStampFormat("EEEE MMMM dd yyyy, hh:mm a '('zzz')'");*/
	
	}
	public static void aftertest() {
	report.flush();
	}
	
}

