package com.TestcasesMicroblaze;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.pagesMicroblaze.HomePage;
import Generic.ExtentReport;
import Generic.utility;
public class HomePageTest {
    ExtentReports report;
    ExtentSparkReporter htmlReport;
    ExtentTest test;
	WebDriver driver;
	HomePage hp;
	Alert alt;
	@BeforeTest()
	public void launchbrowser()
	{
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("MyReport.html");	//Report File
		report = new ExtentReports();		//Report
		report.attachReporter(htmlReport);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.demoblaze.com/");	
		hp=new HomePage(driver);
	}
@Test(priority=1)
public void test1(){
	test = report.createTest("Verify App URL");
	String actualUrl=hp.getAppUrl();
	System.out.println(actualUrl);
	Assert.assertEquals(actualUrl, "https://www.demoblaze.com/","not matched");
	System.out.println(); 
	test.log(Status.PASS, MarkupHelper.createLabel("App URL Verified", ExtentColor.GREEN));
}

@Test(priority=2)
public void validatesignup() throws Throwable {
	 test = report.createTest("validatesignup");
	hp.Signup("Rashmitha","Rashmi123");
	System.out.println("sign up successfull");	
	utility.getScreenshot(driver);
	test.log(Status.PASS, MarkupHelper.createLabel("Signup successful", ExtentColor.GREEN));
}
@Test(priority=3)
public void validatelogin() throws Throwable {
	test = report.createTest("validatelogin");
	hp.login("Rashmitha","Rashmi123");
	System.out.println("login successfull");
	utility.getScreenshot(driver);
	 test.log(Status.PASS, MarkupHelper.createLabel("Login successful", ExtentColor.GREEN));
} 
//print size and all categories
 @Test(priority=4)
 public void validatenumberofcategories(){
	 test = report.createTest("validatenumberofcategories");
	System.out.println("number of categories are: "+ hp.numberofcategories()); 
	 test.log(Status.PASS, MarkupHelper.createLabel("Categories count verified", ExtentColor.GREEN));
 }
 @Test(priority=5)
 public void validateprintcategories() throws Throwable {
	 test = report.createTest("validateprintcategories");
	 hp.printcategories();
	 test.pass("Printed categories successfully");
 }
 //print size and all phones
 @Test(priority=6)
 public void gotophones() throws Throwable {
	 test = report.createTest("click on phones");
	 hp.Phones();
	 utility.getScreenshot(driver);
	 test.pass("Navigated to Phones successfully");
 }
 @Test(priority=7)
 public void validatenumberofphones() {
	 test = report.createTest("validate number of phones");
	System.out.println(hp.numberofphones());
	test.pass("printed number of phones successfully");
 }
 @Test(priority=8)
 public void validateprintphones() throws Throwable
 {
	 test = report.createTest("print phones");
	 hp.printphones();
	 test.pass("printed names of phones successfully");
 }
 //print size and all laptops
 @Test(priority=9)
 public void gotolaptops() throws Throwable {
	 test = report.createTest("click on  laptops");
	 hp.laptops();	
	 utility.getScreenshot(driver);
	 test.pass("navigated to laptops successfully");
 }
 @Test(priority=10)
 public void validatenumbeoflaptops() {
	 test = report.createTest("validate number of laptops");
	 System.out.println(hp.numberoflaptops());
	 test.pass("printed names of laptops successfully");
 }
 @Test(priority=11)
 public void validateprintlaptops() throws Throwable
 {
	 test = report.createTest("print laptops");
	 hp.printlaptops();
	 test.pass("printed names of laptops successfully");
 }
 //print size and monitors
 @Test(priority=12)
public void gotomonitors() throws Throwable {
	 test = report.createTest("click on monitors");
	hp.monitors();
	utility.getScreenshot(driver);
	 test.pass("Navigated to monitors successfully");
}
 @Test(priority=13)
 public void validatenumbeofmonitors()
 {
	 test = report.createTest("validate number of monitors");
	 System.out.println(hp.numberofmonitors());
	 test.pass("printed number of monitors successfully");
 }
 @Test(priority=14)
 public void validateprintmonitors() throws Throwable {
	 test = report.createTest("print names of monitors");
	 hp.printmonitors();
	 test.pass("printed names of monitors successfully");
 }
 @Test(priority=15)
 public void buyamonitor() throws Throwable {
	 test = report.createTest("click selected monitors");
	 hp.buyamonitor("ASUS Full HD");
	 test.pass("clicked on  selected monitor successfully");
 }
 @Test(priority=16)
 public void addPhoneToCart() throws Throwable {
	 test = report.createTest("click selected monitors");
	 hp.clickAddToCart();
	 System.out.println("product added successfully");
	 utility.getScreenshot(driver);
	 test.pass("clicked on  selected monitor successfully");
 }
 @Test(priority=17)
 public void opencart() {
	 test = report.createTest("open cart");
	 hp.clickoncart();
	 utility.getScreenshot(driver);
	 test.pass("cart validated");
 }
 @Test(priority=18)
 public void placeorder() {
	 test = report.createTest("click on place order");
	 hp.clickplaceorder();
	 test.pass("place order validated successfully");
 }
 @Test(priority=19)
 public void placeorderdetails() {
	 test = report.createTest("Fill place order details");
	 hp.enterdatainplaceorder("Rashmitha", "India", "Hyderabad", "SBI", "June");
	 test.pass("details entered successfully");
 }
@Test(priority=20)
public void clickonpurchase() {
	 test = report.createTest("validate purchase");
	hp.clickPurchase();
	utility.getScreenshot(driver);
	test.pass("purchase validated successfully");
}
@Test(priority=21)
public void captureResponse() {
	test = report.createTest("validate response");
	hp.response();
	utility.getScreenshot(driver);
	test.pass("response validated successfully");
}
@AfterTest()
	public void aftertest() {
	driver.close();
	report.flush();
}
}