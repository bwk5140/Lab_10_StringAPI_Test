package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class API_TestFile
{
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\brian\\Documents\\Fall 2023\\SWENG 431\\Lab 10\\chromedriver-win64\\chromedriver.exe");
    ChromeOptions options=new ChromeOptions();
    options.addArguments("--start-maximized");
    options.addArguments("--remote-allow-origins=*");
    driver = new ChromeDriver(options);
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    //driver.get(baseUrl);
    //driver.findElement(By.id("cookie_action_close_header")).click();
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testStringAPI() throws Exception {
    driver.get("https://docs.oracle.com/javase/9/docs/api/overview-summary.html");
    driver.findElement(By.linkText("java.se")).click();
    driver.get("https://docs.oracle.com/javase/9/docs/api/java.se-summary.html");
    driver.findElement(By.id("search")).click();
    driver.findElement(By.id("ui-id-4671")).click();
    driver.get("https://docs.oracle.com/javase/9/docs/api/java/lang/String.html");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='String'])[12]/following::a[1]")).click();
    driver.findElement(By.id("search")).click();
    driver.findElement(By.xpath("//li[@id='ui-id-9766']/a/span")).click();
    driver.get("https://docs.oracle.com/javase/9/docs/api/javax/swing/JFrame.html");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='GraphicsConfiguration'])[2]/following::a[1]")).click();
  }

  @After
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
