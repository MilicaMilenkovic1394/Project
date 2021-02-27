package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class MealItemTest extends BasicTest {
	
	@Test
	public void add_meal_to_cart() throws InterruptedException {
		
		driver.navigate().to(baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo");
		locationPopUp.closeLocationForm();
		
		try {
			mealPage.AddMeadlToCart("2");
			if(driver.getPageSource().contains("The Following Errors Occurred:"))
			{
				System.out.println("Uspesno prvi red");
			}
			if(driver.getPageSource().contains("Please Select Location"))
			{
				System.out.println("Uspesno drugi red");
			}
			profilePage.waitToDisappear("The Following Errors Occurred:");
		
		}
		catch(Exception e) {
		    throw new AssertionError("A clear description of the failure", e);
		}
		
		locationPopUp.insertLocation("City Center - Albany");

		
		mealPage.AddMeadlToCart("2");
		
		if(driver.getPageSource().contains("Meal Added To Cart")) {
			System.out.println("Poruka prikazana1");
		}
		
	}
	
	
	@Test 
	public void add_meal_to_favourite() throws InterruptedException {
		driver.navigate().to(baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo");
		locationPopUp.closeLocationForm();
		Thread.sleep(2000);
		driver.findElement(By.id("item_119")).click();
		Thread.sleep(2000);
		WebElement errormessage =  waiter.until(ExpectedConditions.visibilityOfElementLocated(By.className("system_message")));
		errormessage.getText();
		 
		if(errormessage.getText().equals("Please login first!")) {
			System.out.println("Poruka prikazana.");
		}
		
		driver.navigate().to(baseUrl + "/guest-user/login-form");
		loginPage.login(email, lozinka);
		driver.navigate().to(baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo");
		driver.findElement(By.id("item_119")).click();
		
		WebElement errormessage2 =  waiter.until(ExpectedConditions.visibilityOfElementLocated(By.className("system_message")));
		errormessage2.getText();
		 
		if(errormessage2.getText().equals("Product has been added to your favorites.")) {
			System.out.println("Poruka prikazana.");
		}
	}
	
	@Test
	public void clear_cart() throws InterruptedException, IOException {
		driver.navigate().to(baseUrl + "/meals");
		driver.findElement(By.id("locality_keyword")).sendKeys("City Center - Albany");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\'frm_fat_id_frmSetLocation\']/span/input")).click();
		
		File file = new File("data/Data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = wb.getSheet("Meals");
		
		for (int i = 1; i < 6; i++) {
			String jelo = sheet.getRow(i).getCell(0).getStringCellValue();
			int kolicina = (int) sheet.getRow(i).getCell(1).getNumericCellValue();
			System.out.println(jelo);
			System.out.println(kolicina);
			driver.navigate().to(jelo);
			
			String kolicinaString = String.valueOf(kolicina);
			mealPage.AddMeadlToCart(kolicinaString);
			
			SoftAssert soft = new SoftAssert();
			String expectedHeaderText = "Meal Added To Cart";
			
		
		}
		
		cartSummaryPage.deleteAll();
		
		if(driver.getPageSource().contains("All meals removed from Cart successfully")) {
			System.out.println("Poruka prikazana.");
		}
		
		
	}
	
	@Test
	public void search_test() throws InterruptedException, IOException {
		driver.navigate().to(baseUrl + "/meals");
		driver.findElement(By.id("locality_keyword")).sendKeys("City Center - Albany");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\'frm_fat_id_frmSetLocation\']/span/input")).click();
		
		File file = new File("data/Data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = wb.getSheet("Meals Search Results Sheet");
		
		for (int i = 1; i < 6; i++) {
			String link = sheet.getRow(i).getCell(0).getStringCellValue();
			
			driver.navigate().to(link);
			
			
		}
	}
}
