package test;

import org.testng.annotations.Test;

import library.Base;
import pom.HomePage;
import pom.PasswaordPage;
import pom.UserIdPage;
import pom.WelcomePage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import org.testng.Assert;
import org.testng.Reporter;

public class AmazonTest extends Base
{
	WelcomePage welcome;
	UserIdPage uid;
	PasswaordPage pass;
	HomePage home;
  
  @BeforeClass
  public void logInToAmazon() 
  {
	  launchBrowser("chrome");
	  Reporter.log("Browser Launched..", true);
	  
	  welcome = new WelcomePage();
	  uid = new UserIdPage();
	  pass = new PasswaordPage();
	  home = new HomePage();
	  
	  welcome.clickGoToSignIn();
	  
	  uid.insertUserId();
	  uid.clickContinueBtn();
	  
	  pass.insrtPassword();
	  pass.clickSignInBtn();
	  
	  Reporter.log("Welcome to Amazon..", true);
  }
  
  @BeforeMethod
  public void startTest() 
  {
	  Reporter.log("Be Ready your test is going to start..", true);
  }
  
  @Test(priority=0)
  public void validateLogIn() 
  {
	  Assert.assertEquals(home.getUserName(), "Hello, Yogesh");
	  Reporter.log("You are successfully Logged In..", true);
  }
  
  @Test(priority=1)
  public void validateLogOut() throws InterruptedException 
  {
	  home.clickSignOut();
	  Assert.assertEquals(uid.toValidateSignOut(), "Email or mobile phone number");
	  Reporter.log("You are successfully Logged Out..", true);
  }

  @AfterMethod
  public void finishTest() 
  {
	  Reporter.log("Congratulations your test is executed..", true);
  }

  @AfterClass
  public void closeBrowser() throws InterruptedException 
  {
	  Thread.sleep(5000);
	  //driver.quit();
  }
}
