package com.bahmni.pages;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
  // locators and Constructor and Page actions
  private WebDriver driver;

  private By username = By.xpath("//input[@id='username']");
  private By password = By.xpath("//input[@id='password']");
  private By location = By.xpath("//select[@id='location']");
  private By login = By.xpath("//button[contains(text(),'Login')]");

  public LoginPage(WebDriver driver) {
    System.out.println("LoginPage");
    this.driver = driver;
  }

  public void enterUserName(String userName) {
    driver.findElement(username).sendKeys(userName);
  }

  public void enterPassword(String pwd) {
    driver.findElement(password).sendKeys(pwd);
  }

  public void selectLocation() {
    Select s = new Select(driver.findElement(location));
    s.selectByIndex(1);
  }

  public void clickOnLogin() {
    driver.findElement(login).click();
  }
  
  public String navigateDashboardPage() throws InterruptedException {
    Thread.sleep(5000);
    String currentUrl = driver.getCurrentUrl();
    System.out.println("currentUrl :: "+currentUrl);
    return currentUrl; 
  }
}
