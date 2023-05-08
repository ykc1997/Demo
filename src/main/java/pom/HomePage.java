package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import library.Base;

public class HomePage extends Base
{
	//WebElement nameOfUser = driver.findElement(By.xpath("//div[@class='nav-line-1-container']//child::span"));

	public String getUserName() 
	{
		WebElement nameOfUser = driver.findElement(By.xpath("//div[@class='nav-line-1-container']//child::span"));
		String actualName = nameOfUser.getText();
		return actualName;
	}
	
	public void clickSignOut() throws InterruptedException 
	{
		Thread.sleep(2000);
		WebElement goToSignOut = driver.findElement(By.id("nav-link-accountList"));
		Actions act = new Actions(driver);
		act.moveToElement(goToSignOut).perform();
		
		WebElement signOutButton = driver.findElement(By.xpath("//span[text()='Sign Out']"));
		signOutButton.click();
	}
}
