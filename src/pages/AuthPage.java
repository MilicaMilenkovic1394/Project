package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage extends BasicPage {
	
	public AuthPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
	}
	public WebElement getUserBtn() {
		return this.driver.findElement(By.xpath("//*[@class='accounts-link']/ul//li[2]/a"));
	}
	public WebElement myAccount() {
		return driver.findElement(By.xpath("//*[@class='my-account-dropdown']/ul/li[1]"));
	}
	public WebElement getLogout() {
		return driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div[2]/div[2]/ul/li/a"));
				
	}
	public void logOut() {
		this.getLogout().click();
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div[2]/div[2]/ul/li/div/ul/li[2]/a")).click();
	}

}
