package com.bahmni.pages;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class NewPatientPage {
  // locators and Constructor and Page actions
  private WebDriver driver;

  private By firstName = By.xpath("//input[@id='givenName']");
  private By lastName = By.xpath("//input[@id='familyName']");
  private By gender = By.xpath("//select[@id='gender']");
  private By birthDate = By.xpath("//input[@id='birthdate']");
  private By save = By.xpath("//button[@type='submit']");
  private By patientIdValue = By.xpath("//span[@id='patientIdentifierValue']");  
  
  public NewPatientPage(WebDriver driver) {
    System.out.println("LoginPage");
    this.driver = driver;
  }

  public void enterFirstName(String firstname) {
    driver.findElement(firstName).sendKeys(firstname);
  }

  public void enterLastName(String lastname) {
    driver.findElement(lastName).sendKeys(lastname);
  }

  public void selectGender(String gen) {
    Select s = new Select(driver.findElement(gender));
    s.selectByVisibleText(gen);
  }

  public void selectBirhtDate(String dob) {
    driver.findElement(birthDate).sendKeys(dob);
  }
  
  public void clickSave() {
    driver.findElement(save).click();
  }

  public boolean isPatientIdCreated() throws InterruptedException {
    Thread.sleep(5000);
    return driver.findElement(patientIdValue).isDisplayed();
  }
}
