package com.OHRMScenario1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import Generic.ExtentReport;
import Generic.utility;
import org.testng.annotations.Test;

public class OHRM {
	 WebDriver driver;
	    ExtentSparkReporter htmlReport;
	    ExtentReports report;
	    ExtentTest test;

	    @BeforeTest
	    public void launchBrowser() {
	        htmlReport = new ExtentSparkReporter("extentReport.html");
	        report = new ExtentReports(); 
	        report.attachReporter(htmlReport);

	        // Launch the browser and navigate to the login page
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	        
	       test = report.createTest("Launch Browser and Navigate to Login Page");
	       test.log(Status.INFO, "Browser launched and navigated to login page.");
	    }

	    @Test(dataProvider = "getData")
	    public void test(String Username, String Password) throws InterruptedException, IOException {
	       test.log(Status.INFO, "Entering credentials for login.");
	        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys(Username);
	        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys(Password);
	        
	       test.log(Status.INFO, "Credentials entered. Pressing Enter to log in.");
	        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).sendKeys(Keys.ENTER);
	        Thread.sleep(1000);

	        utility.getScreenshot(driver);
	        
	        boolean isLoginSuccessful = driver.getCurrentUrl().contains("dashboard");
	        Assert.assertTrue(isLoginSuccessful);
	        Thread.sleep(1000);
	    }

	    @DataProvider
	    public Object[][] getData() throws IOException {
	        // Read data from an Excel file
	    	File file=new File("D://Rashmitha_SeleniumDemos//project//TestData//Data.xlsx");
	        FileInputStream fis = new FileInputStream(file);
	        XSSFWorkbook wb = new XSSFWorkbook(fis);
	        int rows = wb.getSheet("Sheet1").getPhysicalNumberOfRows();
	        int cells = wb.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells();
	        Object data[][] = new Object[rows - 1][cells];

	        for (int i = 1; i < rows; i++) {
	            for (int j = 0; j < cells; j++) {
	                data[i - 1][j] = wb.getSheet("Sheet1").getRow(i).getCell(j).getStringCellValue();
	                System.out.print(data[i - 1][j] + " ");
	            }
	            System.out.println();
	        }
	        return data;
	    }

	    @AfterMethod
	    public void logout() {
	        if (driver.getCurrentUrl().contains("dashboard")) {
	            //test.log(Status.INFO, "User is logged in. Proceeding to logout.");
	            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/i")).click();
	            driver.findElement(By.partialLinkText("Log")).click();
	            test.log(Status.PASS, MarkupHelper.createLabel("Logout successful", ExtentColor.GREEN));
	        } else {
	            test.log(Status.FAIL, MarkupHelper.createLabel("Logout failed: Not logged in", ExtentColor.RED));
	        }
	    }

	    @AfterTest
	    public void closebrowser() {
	        driver.close();
	        report.flush();
	    }
	
}	