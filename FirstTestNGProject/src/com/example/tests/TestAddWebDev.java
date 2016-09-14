package com.example.tests;

import org.testng.annotations.Test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestAddWebDev {
	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://localhost:8080/SchoolSchedule/Schedule.jsp";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testAddWebDev() throws Exception {
	    driver.get(baseUrl);
	    driver.findElement(By.name("title")).clear();
	    driver.findElement(By.name("title")).sendKeys("Web Development");
	    driver.findElement(By.xpath("(//input[@name='day'])[2]")).click();
	    new Select(driver.findElement(By.name("starttime"))).selectByVisibleText("9:00am");
	    new Select(driver.findElement(By.name("endtime"))).selectByVisibleText("12:00pm");
	    driver.findElement(By.name("Submit")).click();
	    assertEquals(driver.findElement(By.xpath("//tr[3]/td[3]")).getText(), "Web Development");
	    assertEquals(driver.findElement(By.xpath("//tr[4]/td[3]")).getText(), "Web Development");
	    assertEquals(driver.findElement(By.xpath("//tr[5]/td[3]")).getText(), "Web Development");
	  }

	  @AfterClass(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }
}
