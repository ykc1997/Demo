package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import library.Base;

public class PasswaordPage extends Base
{
	public void insrtPassword() 
	{
		WebElement password = driver.findElement(By.xpath("//input[@id='ap_password']"));
		password.sendKeys();
	}
	
	public void clickSignInBtn() 
	{
		WebElement signInBtn = driver.findElement(By.xpath("//input[@id='signInSubmit']"));
		signInBtn.click();
	}
	
}
