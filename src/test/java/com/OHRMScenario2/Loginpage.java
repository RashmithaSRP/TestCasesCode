package com.OHRMScenario2;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Loginpage {
	WebDriver driver;
	LoginpageData l1;//other class
	adminPageData a1;
	@BeforeTest
	public void beforetest()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		l1=new LoginpageData(driver);// creating object of other class
		a1=new adminPageData(driver);
	}
  @Test(priority=1)
  public void login() {
	l1.username("Admin");
	l1.password("admin123");
	l1.submitbutton();
  }
	@Test(priority=2)
	public void searchByUsername() { 
	a1.printmenu();
	a1.clickadmin();
	a1.usernameInAdmin("Admin");
	a1.search();
	a1.result1();
	driver.navigate().refresh();
	}
	@Test(priority=3)
	public void searchByUserRole() {
	a1.dropdown1();
	a1.testuserRole();
	a1.search();
	a1.result1();
	driver.navigate().refresh();
	}
	@Test(priority=4)
	public void searchByStatus()
	{
		a1.dropdown2();
		a1.testselected();
		a1.search();
		a1.result1();
	}
 
  @AfterTest
  public void aftertest()
  {
	  //driver.close();
  }
}

