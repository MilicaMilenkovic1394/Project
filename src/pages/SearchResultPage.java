package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage extends BasicPage {
	
	public SearchResultPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
	}
	
	public WebElement getSearchResults() {
		List<WebElement> elLista = this.driver.findElements(By.xpath("//*[@class='product-name']/a"));
		return (WebElement) elLista;
	}
	
	public String getSearchResultsText() {
		return getSearchResults().getText();
		
	}
	
	public int brojRezultata() {
		List<WebElement> el = this.driver.findElements(By.xpath("//*[@class='product-name']/a"));
		return el.size();
		
	}

}



