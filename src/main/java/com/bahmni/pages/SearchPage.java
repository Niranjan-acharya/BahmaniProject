package com.bahmni.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
  private WebDriver driver;

  private By createNew = By.xpath("//header/ul[1]/li[2]/a[1]/span[1]");
  private By newPatient = By.xpath("//strong[contains(text(),'NEW PATIENT')]");

  private By search = By.xpath("//header/ul[1]/li[1]/a[1]/span[1]");

  private By enterID = By.xpath("//input[@id='registrationNumber']");
  private By searchID = By.xpath("(//button[@type='submit'])[1]");

  private By enterName = By.xpath("//input[@id='name']");
  private By searchName = By.xpath("(//button[@type='submit'])[2]");

  private By result = By.xpath("//div[@class='note warning']/div/p");

//  private By patientIdValue = By.xpath("//span[@id='patientIdentifierValue']");  

  public SearchPage(WebDriver driver) {
    System.out.println("SearchPage");
    this.driver = driver;
  }

  public boolean isCreateNewLinkExist() {
    return driver.findElement(createNew).isDisplayed();
  }

  public void clickOnCreateNew() {
    driver.findElement(createNew).click();
  }

  public boolean navigateNewPatientPage() {
    return driver.findElement(newPatient).isDisplayed();
  }

  public void clickOnSearch() {
    driver.findElement(search).click();
  }

  public void enterID(String id) {
    driver.findElement(enterID).sendKeys(id);
  }

  public void clickOnSearchID() {
    driver.findElement(searchID).click();
  }

  public void resultID(String res) throws InterruptedException {
    try {
      String err = driver.findElement(result).getText();
      if (err.contains(res))
        System.out.println("ERROR FOUND");
    } catch (NoSuchElementException e) {
      System.out.println("Element not found");
      System.out.println("Patient ID :: " + res);
    }
  }

  public void enterName(String name) {
    driver.findElement(enterName).sendKeys(name);
  }

  public void clickOnSearchName() {
    driver.findElement(searchName).click();
  }

  public void resultName(String name, String res) throws InterruptedException {
    try {
      String err = driver.findElement(result).getText();
      if (err.contains(res))
        System.out.println("ERROR FOUND");
    } catch (NoSuchElementException e) {
      System.out.println("Element not found");
      List<WebElement> col = driver.findElements(By.xpath("//table/thead/tr/th"));
      System.out.println("No of cols are : " + col.size());
      List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
      System.out.println("No of rows are : " + rows.size());
      int i = 0;
      String pid = null, pname;
      for (WebElement row : rows) {
        i++;
        pname = row.findElement(By.xpath("(//table/tbody/tr/td[2])[" + i + "]")).getText();
        pid = row.findElement(By.xpath("(//table/tbody/tr/td[1])[" + i + "]")).getText();
        if (pname.contains(name) && pid.equalsIgnoreCase(res)) {
          System.out.println(pname + " Patient ID :: " + pid);
          break;
        }
      }
    }
  }
}
