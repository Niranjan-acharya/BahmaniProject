package com.bahmni.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BahmniWelcomePage {
  private WebDriver driver;

  private By clinicalService = By.xpath("//span[contains(text(),'Clinical Service')]");
  private By loginPage = By.xpath("//b[contains(text(),'BAHMNI EMR LOGIN')]");
  
  public BahmniWelcomePage(WebDriver driver) {
    System.out.println("BahmniWelcomePage");
    this.driver = driver;
  }

  public String welcomePageTitle() {
    String title = driver.getTitle();
    System.out.println("title");
    return title;
  }
  
  public boolean isClinicalServiceLinkExist() {
    return driver.findElement(clinicalService).isDisplayed();
  }

  public void clickClinicalService() {
    driver.findElement(clinicalService).click();
  }
  
  public boolean navigateLoginPage() {
    return driver.findElement(loginPage).isDisplayed();
  }  
}
