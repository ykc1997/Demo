package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import library.Base;

public class WelcomePage extends Base
{		
	public void clickGoToSignIn() 
	{
		WebElement goToSignIn = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		goToSignIn.click();
	}
}
