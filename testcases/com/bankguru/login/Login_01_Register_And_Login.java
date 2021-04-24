package com.bankguru.login;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class Login_01_Register_And_Login {
	String projectlocation =System.getProperty("user.dir");
	WebDriver driver;
	String email ="thanhpro123@gmail.com";
	String userID ="";
	String password="";
	String loginURL;
	String homeURL ="http://demo.guru99.com/v4/manager/Managerhomepage.php";

  @BeforeClass
  public void initBrowser() {
	  System.setProperty("webdriver.gecko.driver", projectlocation+"\\browserdrivers\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.get("http://demo.guru99.com/v4/");
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  loginURL = driver.getCurrentUrl();
  }
  @Test
  public void tc_01register() {
	  driver.findElement(By.xpath("//a[text()='here']")).click();
	  driver.findElement(By.xpath("//input[@name ='emailid']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@value ='Submit']")).click();
		userID = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
		password= driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
  }
  @Test
  public void tc_02login() {
	  driver.get(loginURL);
	  driver.findElement(By.xpath("//td[text()='UserID']/following-sibling::td/input")).sendKeys(userID);
	  driver.findElement(By.xpath("//td[text()='Password']/following-sibling::td/input")).sendKeys(password);
	  driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
	  Assert.assertTrue(driver.getCurrentUrl().equals(homeURL));

  }
  @AfterMethod
  public void afterMethod() {
  }

}
