package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class ProfileTests extends BasicTest{
	

	@Test
	public void edit_profile() throws InterruptedException {
		driver.navigate().to(baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo");
		locationPopUp.closeLocationForm();
		//Thread.sleep(5000);
		loginPage.login(email, lozinka);
		
		if(driver.getPageSource().contains("Login Successfull"))
		{
		    System.out.println("Uspesno logovanje");
		}

		else
		{
			System.out.println("Logovanje nije uspelo");
		}
		
		driver.navigate().to(baseUrl + "/member/profile");
		profilePage.editProfileInformations(firstName, lastName, email, address, phone, zipCode);
		Thread.sleep(1000);
		if(driver.getPageSource().contains("Setup Successful"))
		{
		    System.out.println("Uspesna promena");
		}

		else
		{
			System.out.println("Promena nije uspela");
		}
		authPage.logOut();
		
		if(driver.getPageSource().contains("Logout Successfull!"))
		{
		    System.out.println("Uspesan Logout");
		}

		else
		{
			System.out.println("Logout nije uspesan");
		}
	}
	
	@Test
	public void change_profile() throws InterruptedException {
		driver.navigate().to("http://demo.yo-meals.com/guest-user/login-form");
		locationPopUp.LocationForm2();
		loginPage.login(email, lozinka);
		
		if(driver.getPageSource().contains("Login Successfull"))
		{
		    System.out.println("Uspesno logovanje");
		}

		else
		{
			System.out.println("Logovanje nije uspelo");
		}
		
		driver.navigate().to("http://demo.yo-meals.com/member/profile");
		
		profilePage.uploadProfilePhoto();
		
		profilePage.waitToDisappear("Profile Image Uploaded Successfully");
			    
		Actions actions = new Actions(driver);
		WebElement subMenuOption = driver.findElement(By.xpath("//*[@id=\'profileInfo\']/div/div[1]/img")); 
		actions.moveToElement(subMenuOption).perform();
		driver.findElement(By.xpath("//*[@id=\'profileInfo\']/div/div[1]/div/a[2]")).click();
		
		profilePage.waitToDisappear("Profile Image Deleted Successfully");
		
		
		if(driver.getPageSource().contains("Profile Image Deleted Successfully"))
		{
		    System.out.println("Uspesno obrisana slika");
		}

		else
		{
			System.out.println("Brisanje slike nije uspelo");
		}
		
		
		authPage.logOut();
		
		if(driver.getPageSource().contains("Logout Successfull!"))
		{
		    System.out.println("Uspesan Logout");
		}

		else
		{
			System.out.println("Logout nije uspesan");
		}
		
		
		
		
	}

	
	
	
}
