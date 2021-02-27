package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage {
	

	public MealPage(WebDriver driver,  WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
	}
	
	public WebElement getMealPage() {
		return this.driver.findElement(By.linkText("Meals"));
		
	}
	public void AddMeadlToCart(String quality) throws InterruptedException{
		this.driver.findElement(By.xpath("//input[@name='product_qty']")).click();
		this.driver.findElement(By.xpath("//input[@name='product_qty']")).sendKeys(Keys.CONTROL + "a");
		this.driver.findElement(By.xpath("//input[@name='product_qty']")).sendKeys(Keys.DELETE);
		this.driver.findElement(By.xpath("//input[@name='product_qty']")).sendKeys(quality);
		this.driver.findElement(By.className("js-proceedtoAddInCart")).click();
	}
	
	public void AddMealToFavourite() {
		this.driver.findElement(By.className("favourite")).click();
	}
	
	

}
