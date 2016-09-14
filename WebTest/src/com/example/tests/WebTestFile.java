package com.example.tests;

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


public class WebTestFile {
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
	  public void testLink() throws Exception {
	    driver.get(baseUrl);
	    driver.findElement(By.name("title")).clear();
	    driver.findElement(By.name("title")).sendKeys("Web Development");
	    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
	    assertEquals(driver.findElement(By.linkText("TeamTAE")).getText(), "TeamTAE");
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
