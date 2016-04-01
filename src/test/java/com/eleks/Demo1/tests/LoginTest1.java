package com.eleks.Demo1.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginTest1 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = false)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.yahoo.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test(alwaysRun = false)
  public void testUntitled() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("yui_3_18_0_4_1459429758278_1367")).click();
    driver.findElement(By.id("login-username")).click();
    driver.findElement(By.id("login-username")).clear();
    driver.findElement(By.id("login-username")).sendKeys("bzheza.test1");
    driver.findElement(By.id("login-signin")).click();
    driver.findElement(By.id("login-passwd")).clear();
    driver.findElement(By.id("login-passwd")).sendKeys("testtestTEST");
    driver.findElement(By.id("login-signin")).click();
    driver.findElement(By.id("yui_3_18_0_4_1459429871230_1478")).click();
  }

  @AfterClass(alwaysRun = false)
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
