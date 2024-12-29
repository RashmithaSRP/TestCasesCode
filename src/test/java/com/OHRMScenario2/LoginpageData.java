package com.OHRMScenario2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginpageData {
	 WebDriver driver;
	 @FindBy(css="[name=\"username\"]") WebElement Username;
	 @FindBy(css="[name=\"password\"]") WebElement Password;
	 @FindBy(css="[type=submit]") WebElement Submit; 
	 
	 public LoginpageData(WebDriver driver)
	  {
		  this.driver=driver;
		  PageFactory.initElements(driver, this);
	  }
	  
//testcase1
	 public void username(String un) {
		 Username.sendKeys(un);	 
	 }
	 public void password(String pwd) {
		 Password.sendKeys(pwd);
	 }
	 public void submitbutton() {
		 Submit.click();
	 }
	 
}