package com.pagesMicroblaze;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver)
	  {
		  this.driver=driver;
		  PageFactory.initElements(driver, this);
	  } 
	@FindBy(id="signin2") WebElement signup;
	@FindBy(id="sign-username")  WebElement username;
	@FindBy(id="sign-password") WebElement password;
	@FindBy(xpath="//*[@id=\"signInModal\"]/div/div/div[3]/button[2]") WebElement signupbutton;
	@FindBy(xpath="//*[@id=\"signInModal\"]/div/div/div[1]/button/span") WebElement closesignupwindow;
	//locators to login
	@FindBy(id="login2") WebElement loginbutton;
	@FindBy(id="loginusername") WebElement loginusername;
	@FindBy(id="loginpassword") WebElement loginpassword;
	@FindBy(xpath="//*[@id=\"logInModal\"]/div/div/div[3]/button[2]") WebElement loginbutton2;
	//other locators
	@FindBy(xpath="//*[@id=\"itemc\"]") List<WebElement> allcategory;
	@FindBy(linkText="Phones") WebElement phonesproduct;
	@FindBy(xpath="/html/body/div[5]/div/div[2]/div/div/div/div/h4/a") List<WebElement> phonesavialable;
	@FindBy(linkText="Laptops") WebElement laptops;
	@FindBy(linkText="Monitors") WebElement Monitors;
	@FindBy(xpath="/html/body/div[5]/div/div[2]/div/div/div/div/h4/a") List<WebElement> laptopsavialable;
	@FindBy(xpath="//*[@id=\"tbodyid\"]/div/div/div/h4/a") List<WebElement> monitorsavialable;
	@FindBy(linkText="Cart") WebElement cart;
	@FindBy(linkText = "Add to cart") WebElement AddtoCart;
	@FindBy(xpath="//*[@id=\"page-wrapper\"]/div/div[2]/button") WebElement placeorder;
	@FindBy(id="name") WebElement pcname;
	@FindBy(id="country") WebElement pccountry;
	@FindBy(id="city") WebElement pccity;
	@FindBy(id="card") WebElement pccard;
	@FindBy(id="month")WebElement pcmonth;
	@FindBy(id="year") WebElement pcyear;
	@FindBy(xpath="//*[@id=\"orderModal\"]/div/div/div[3]/button[2]") WebElement pcpurchase;
	@FindBy(xpath="/html/body/div[10]/h2") WebElement message;
	public String getAppUrl(){
		return driver.getCurrentUrl();	
		}
	public void Signup(String un, String pwd) throws Throwable {
		signup.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		signupbutton.click();
		Thread.sleep(2000);
		Alert alt=driver.switchTo().alert();
		System.out.println("alert text is" +alt.getText());
		alt.accept();
		closesignupwindow.click();
	}
	public void login(String userlogin,String pwdlogin) throws Throwable {
		loginbutton.click();
		loginusername.sendKeys(userlogin);
		Thread.sleep(2000);
		loginpassword.sendKeys(pwdlogin);
		Thread.sleep(2000);
		loginbutton2.click();
	}
	public int numberofcategories(){
		return allcategory.size();
	}
	public void printcategories() throws Throwable {
		for(WebElement c:allcategory) {
			System.out.println("categories : "+ c.getText());
		}
		Thread.sleep(2000);
	}
	//phones number and list
	public void Phones() throws Throwable {
			phonesproduct.click();
			Thread.sleep(1000);
	}
	public int numberofphones() {
		return phonesavialable.size();
    }
	public void printphones() throws Throwable {
		for(WebElement p:phonesavialable) {
			System.out.println("phones: "+ p.getText());
		}
		Thread.sleep(2000);
	}
	//laptops number and list
	public void laptops() throws Throwable {
		laptops.click();
		Thread.sleep(1000);
	}
	public int numberoflaptops() {
		return laptopsavialable.size();
    }
	public void printlaptops() throws Throwable {
		for(WebElement l:laptopsavialable) {
			System.out.println("laptops: "+ l.getText());
		}
		Thread.sleep(1000);
	}
	//monitors and list
	public void monitors() throws Throwable {
		Monitors.click();
		Thread.sleep(1000);
	}
	public int numberofmonitors() {
		return monitorsavialable.size();	
    }
	public void printmonitors() throws Throwable {
		for(WebElement m:monitorsavialable) {
			System.out.println("monitors: " + m.getText());
		}
		Thread.sleep(1000); 
	}
	public void buyamonitor(String pname) throws Throwable
	{
		Monitors.click();
		for(WebElement m:monitorsavialable) {
			if(m.getText().contains(pname))
			{
				m.click();
			}
		}
		Thread.sleep(2000);
	}
		public void clickAddToCart() throws Throwable  {
			AddtoCart.click();
			Thread.sleep(1000);
			Alert alt=driver.switchTo().alert();
			System.out.println("text on alert is "+ alt.getText());
			alt.accept();
			Thread.sleep(1000);
		}
		public void clickoncart() {
			cart.click();
	    }
		public void clickplaceorder() {
			placeorder.click();
		}
		public void enterdatainplaceorder(String name,String country,String city,String card,String month) {
			pcname.sendKeys(name);
			pccountry.sendKeys(country);
			pccity.sendKeys(city);
			pccard.sendKeys(card);
			pcmonth.sendKeys(month);
		}
		public void clickPurchase() {
			pcpurchase.click();
		}
		public void response() {
			System.out.println(message);
		}	
}
