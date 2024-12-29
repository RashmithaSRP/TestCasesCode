package com.OHRMScenario2;

import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class adminPageData {
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li") List<WebElement> Menu;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span") WebElement Admin;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input") WebElement Adminusername;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]") WebElement Search;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span") WebElement Result1;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div[1]/div[2]/i") WebElement Dropdown1;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[2]/span") WebElement AdminUserRole;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[2]/i") WebElement Dropdown2;
    @FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div[2]/div[2]")WebElement Enabled;
	public adminPageData(WebDriver driver)
	  {
		  this.driver=driver;
		  PageFactory.initElements(driver, this);
	  }
	//testcase2
	public void printmenu()
	{
        for(WebElement m: Menu)
        {
        	System.out.println(m.getText());
        }
        System.out.println(Menu.size());
	}
	public void clickadmin()
	{
		Admin.click();
	}
	public void usernameInAdmin(String username)
	{
		Adminusername.sendKeys(username);
	}
	public void search()
	{
		Search.click();
	}
	public void result1() {
		System.out.println(Result1.getText());
	}
	//testcase3
	public void dropdown1() {
		Dropdown1.click();	
	}
	public void testuserRole()
	{
		AdminUserRole.click();
	}
	//testcase 4
	public void dropdown2() {
		Dropdown2.click();
	}
	public void testselected()
	{
		Enabled.click();
	}
	

}
