package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
public class LoginPage extends BasicPage {
	
	public LoginPage(WebDriver driver,  WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
	}
	
	public WebElement getEmail() {
		return driver.findElement(By.name("username"));
		
	}
	
	public WebElement getPassword() {
		return driver.findElement(By.name("password"));
	}
	
	public WebElement getLoginSubmit() {
		return driver.findElement(By.name("btn_submit"));
	}
	
	
	public void login(String email, String password) throws InterruptedException {
		this.driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div[2]/div[2]/ul/li[2]/a")).click();
		Thread.sleep(5000);
		this.getEmail().sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		this.getPassword().sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		this.getEmail().sendKeys(email);
		this.getPassword().sendKeys(password);
		this.getLoginSubmit().click();
	}
	
	

}
