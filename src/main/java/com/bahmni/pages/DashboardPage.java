package com.bahmni.pages;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;

public class DashboardPage {
  private WebDriver driver;

  private By registration = By.xpath("//a[text()='Registration']");
  
  public DashboardPage(WebDriver driver) {
    System.out.println("DashboardPage");
    this.driver = driver;
  }

  public boolean isRegistrationLinkExist() {
    return driver.findElement(registration).isDisplayed();
  }

  public void clickOnRegistration() {
    driver.findElement(registration).click();
  }
  
  public String navigateSearchPage() throws InterruptedException {
    Thread.sleep(5000);
    String currentUrl = driver.getCurrentUrl();
    System.out.println("currentUrl :: "+currentUrl);
    return currentUrl; 
  }
}
