package tests;


import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import pages.AuthPage;
import pages.CartSummaryPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.MealPage;
import pages.ProfilePage;
public class BasicTest {
	

	protected WebDriver driver;
	protected WebDriverWait waiter;
	
	protected String baseUrl = "http://demo.yo-meals.com";
	protected String email = "customer@dummyid.com";
	protected String lozinka = "12345678a";
	protected String photoPath = "images\\download.png";
	protected String firstName = "Milica";
	protected String lastName = "Milenkovic";
	protected String address = "Bul. Nemanj";
	protected String phone = "07895412";
	protected String zipCode = "18000";
	
	//protected String imgPath = new File(photoPath).getCanonicalPath();
	
	protected LocationPopupPage locationPopUp;
	protected LoginPage loginPage;
	protected AuthPage authPage;
	protected ProfilePage profilePage;
	protected MealPage mealPage;
	protected CartSummaryPage cartSummaryPage;
	
	private JavascriptExecutor js;
	
	

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		
		this.driver = new ChromeDriver();
		this.waiter = new WebDriverWait(this.driver, 2);
		
		this.driver.manage().window().maximize();
		
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		locationPopUp = new LocationPopupPage(this.driver, this.waiter, this.js);
		loginPage = new LoginPage(this.driver, this.waiter, this.js);
		authPage = new AuthPage(this.driver, this.waiter, this.js);
		profilePage = new ProfilePage(this.driver, this.waiter, this.js);
		
	}
	
	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException { 
		if (testResult.getStatus() == ITestResult.FAILURE) { 
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		
		} 
		
		this.driver.manage().deleteAllCookies();
	}
	
	@AfterClass
	public void clean() {
		this.driver.quit();
	}
}
