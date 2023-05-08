package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import library.Base;

public class UserIdPage extends Base
{	
	public void insertUserId() 
	{
		WebElement mobileNo = driver.findElement(By.xpath("//input[@id='ap_email']"));
		mobileNo.sendKeys();
	}
	
	public void clickContinueBtn() 
	{
		WebElement continueBtn = driver.findElement(By.xpath("//input[@id='continue']"));
		continueBtn.click();
	}
	
	public String toValidateSignOut() 
	{
		WebElement userIdPageEle = driver.findElement(By.xpath("//label[contains(text(),'Email or mobile phone number')]"));
		String userIdPageText = userIdPageEle.getText();
		return userIdPageText;
	}
}
