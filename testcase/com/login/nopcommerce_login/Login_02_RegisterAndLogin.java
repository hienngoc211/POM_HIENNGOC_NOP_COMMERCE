package com.login.nopcommerce_login;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Login_02_RegisterAndLogin {
	
	  WebDriver driver;
	  Select select;
	 
	  String firstName = "Virus";
	  String lastName = "Corona";
	  String email = "coronavirus" + randomNumber() + "@hotmail.com";
	  String company = "Kientoan";
	  String password = "Abc1234";
	  
	
 @BeforeTest
 	public void beforeTest() {
	System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver");
	   driver = new FirefoxDriver();
	   driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	   driver.manage().window().maximize();
	  }

	
  @Test
  
  public void TC_01_RegisterToSystem() {
	  driver.get("http://demo.nopcommerce.com");
	  driver.findElement(By.className("ico-register")).click();
	  driver.findElement(By.className("male")).click();
	  driver.findElement(By.id("FirstName")).sendKeys(firstName);
	  driver.findElement(By.id("LastName")).sendKeys(lastName);
	  select = new Select(driver.findElement(By.name("DateOfBirthDay")));
	  select.selectByIndex(9);
	  select = new Select(driver.findElement(By.name("DateOfBirthMonth")));
	  select.selectByVisibleText("March");
	  select = new Select(driver.findElement(By.name("DateOfBirthYear")));
	  select.selectByValue("2007");
	  driver.findElement(By.id("Email")).sendKeys(email);
	  driver.findElement(By.id("Company")).sendKeys(company);
	  driver.findElement(By.id("Password")).sendKeys(password);
	  driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
	  driver.findElement(By.id("register-button")).click();
	  String msgSuccess = driver.findElement(By.className("result")).getText();
	  Assert.assertEquals(msgSuccess, "Your registration completed");
	  System.out.println("message success: " + msgSuccess);
	  driver.findElement(By.className("ico-logout")).click();
	  
	  
	  
	  
	  
	  
  }
 
  
  
  @Test
  
  public void TC_02_LoginToSystem() {
	  driver.findElement(By.linkText("Log in")).click();
	  driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
	  driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
	  driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
	  Assert.assertTrue(driver.findElement(By.xpath("//a[@class='ico-account']")).isDisplayed());
  }

 


  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
  
  public int randomNumber() {
	  Random rand = new Random();
	  return rand.nextInt(1000);
  }

}
