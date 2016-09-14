package com.example.tests;

import org.testng.annotations.Test;

//import java.util.regex.Pattern;
//import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestAddWebDev {
	 WebDriver driver;
	   String baseUrl, nodeURL;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @BeforeClass(alwaysRun = true)
	  public void setUp() throws MalformedURLException {
	   
	    baseUrl = "http://52.42.226.149/SchoolSchedule/";
	    nodeURL = "http://selenium-hub:4444/wd/hub";
	    DesiredCapabilities capability = DesiredCapabilities.firefox();
	    capability.setBrowserName("firefox");
	    //capability.setPlatform(Platform.XP);
	    driver = new RemoteWebDriver(new URL(nodeURL), capability);
	    
	    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testAddWebDev() throws Exception {
		    driver.get(baseUrl);
		    driver.findElement(By.name("title")).clear();
		    driver.findElement(By.name("title")).sendKeys("Web Development");
		    driver.findElement(By.xpath("(//input[@name='day'])[2]")).click();
		    new Select(driver.findElement(By.name("starttime"))).selectByVisibleText("10:00am");
		    new Select(driver.findElement(By.name("endtime"))).selectByVisibleText("1:00pm");
		    driver.findElement(By.name("Submit")).click();
		    try {
		      assertEquals(driver.findElement(By.linkText("TeamTAE")).getText(), "TeamTAE");
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
	  }

	  @AfterClass(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }
	  private boolean isElementPresent(By by) {
		    try {
		      driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
		  }

		  private boolean isAlertPresent() {
		    try {
		      driver.switchTo().alert();
		      return true;
		    } catch (NoAlertPresentException e) {
		      return false;
		    }
		  }

		  private String closeAlertAndGetItsText() {
		    try {
		      Alert alert = driver.switchTo().alert();
		      String alertText = alert.getText();
		      if (acceptNextAlert) {
		        alert.accept();
		      } else {
		        alert.dismiss();
		      }
		      return alertText;
		    } finally {
		      acceptNextAlert = true;
		    }
		  }
}
