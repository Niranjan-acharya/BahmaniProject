package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.bahmni.pages.BahmniWelcomePage;
import com.bahmni.pages.DashboardPage;
import com.bahmni.pages.LoginPage;
import com.bahmni.pages.SearchPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchPageSD {
  private static String url;
  private WebDriver driver = DriverFactory.getDriver();
//  private BahmniWelcomePage welcomePage = new BahmniWelcomePage(driver);
//  private LoginPage loginPage = new LoginPage(driver);
  private SearchPage searchPage = new SearchPage(driver);

  private boolean flag = false;
  
//  @Given("user on BAHMNI Dashboard page")
//  public void user_on_bahmni_dashboard_page() throws InterruptedException {
//    System.out.println("Dashboard Page");
//    LoginPageSD obj = new LoginPageSD();
//    obj.page_should_navigate_to_dashboard_page("dashboard");
//  }
//  
//  @And("user finds {string} option2")
//  public void user_finds_option2(String string) {
//    flag = dashboardPage.isRegistrationLinkExist();
//    Assert.assertTrue(flag); 
//  }
//
//  @When("user clicks Registration option")
//  public void user_clicks_registration_option() {
//    dashboardPage.clickOnRegistration();
//  }
//
//  @Then("page should navigate to {string} Page2")
//  public void page_should_navigate_to_search_page2(String string) throws InterruptedException {
//    System.out.println("STRING URL :: "+string);
//    url = dashboardPage.navigateSearchPage();
//    Assert.assertTrue(url.contains(string));
//  }
  
  @And("user finds Create New option")
  public void user_finds_create_new_option() {
    flag = searchPage.isCreateNewLinkExist();
    Assert.assertTrue(flag); 
  }

  @When("user clicks Create New option")
  public void user_clicks_create_new_option() {
    searchPage.clickOnCreateNew();
  }

  @Then("page should navigate to {string} Page3")
  public void page_should_navigate_to_page3(String string) {
    searchPage.navigateNewPatientPage();
  }
  
  @When("user clicks search option")
  public void user_clicks_search_option() {
    searchPage.clickOnSearch();
  }

  @And("user enters patient id {string}")
  public void user_enters_patient_id(String string) {
    searchPage.enterID(string);
  }

  @When("user clicks searchID option")
  public void user_clicks_searchid_option() {
    searchPage.clickOnSearchID();
  }

  @Then("results should be {string} patient")
  public void results_should_be_patient(String string) throws InterruptedException {
    searchPage.resultID(string);
  }

  @And("user enters patient name {string}")
  public void user_enters_patient_name(String string) {
    searchPage.enterName(string);
  }

  @When("user clicks searchName option")
  public void user_clicks_searchname_option() {
    searchPage.clickOnSearchName();
  }

  @Then("results should be {string} and {string} table")
  public void results_should_be_and_table(String string1, String string2) throws InterruptedException {
    searchPage.resultName(string1, string2);
  }
}