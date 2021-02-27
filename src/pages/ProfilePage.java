package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage {

	public ProfilePage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
	}
	
	public WebElement getPersonalInfo() {
		return driver.findElement(By.xpath(""));
	}
	
	public WebElement getMyAccount() {
		return driver.findElement(By.linkText("My account"));
	}
	
	public WebElement getProfile() {
		return driver.findElement(By.linkText("Profile"));
	}
	
	public WebElement getFirstName() {
		return this.driver.findElement(By.name("user_first_name"));
	}
	
	public WebElement getLastName() {
		return this.driver.findElement(By.name("user_last_name"));
	}
	
	public WebElement getEmail() {
		return driver.findElement(By.name("user_address"));
	}
	
	public WebElement getAddress() {
		return driver.findElement(By.name("user_address"));
	}
	
	public WebElement getPhone() {
		return driver.findElement(By.name("user_phone"));
		
	}
	
	public WebElement getZipCode() {
		return driver.findElement(By.name("user_zip"));
		
	}
	
	public WebElement getUploadBtn() {
		return driver.findElement(By.xpath("//*[@title=\"Remove\"]"));
	}
	
	public WebElement removeProfilePhoto() {
		this.js.executeScript("arguments[0].click();");
		return driver.findElement(By.xpath("//*[@title=\"Remove\"]"));
	}
	
    public void uploadProfilePhoto() {
    	
    	this.driver.findElement(By.xpath("//*[@id=\'profileInfoFrm\']/div[1]/div[1]/fieldset/input")).sendKeys("C:\\Users\\jelen\\eclipse-workspace\\zavrsni\\images\\download.png");
		
    }
    
    public void waitToDisappear(String msg) {
    	WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = driver.findElement(By.xpath("/html/body/div[2]"));
		wait.until(ExpectedConditions.not(
		    ExpectedConditions.textToBePresentInElement(element,msg)));
    }
 
    	
   public void editProfileInformations(String firstName, String lastName, String email, String address, String phone, String zipCode) {
			   this.driver.findElement(By.className("user-trigger-js"));
			   getFirstName().clear();
	   		   getFirstName().sendKeys(firstName);
	   		   getLastName().clear();
			   getLastName().sendKeys(lastName);
			   //getEmail().sendKeys(email);
			   getAddress().clear();
			   getAddress().sendKeys(address);
			   getPhone().clear();
			   getPhone().sendKeys(phone);
			   getZipCode().clear();
			   getZipCode().sendKeys(zipCode);
			   this.driver.findElement(By.xpath("//*[@id=\"profileInfoFrm\"]/div[5]/div/fieldset/input")).click();
	   
   }
    
    
}

