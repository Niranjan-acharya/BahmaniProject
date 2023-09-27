package stepdefinitions;

import org.junit.Assert; 
import org.openqa.selenium.WebDriver;

import com.bahmni.pages.BahmniWelcomePage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WelcomePageSD {
  private static String title;
  private WebDriver driver = DriverFactory.getDriver();
  private BahmniWelcomePage welcomePage = new BahmniWelcomePage(driver);
  
  private boolean flag = false;
  
  @Given("user on BAHMNI welcome page")
  public void user_on_bahmni_welcome_page() {
    driver.get("https://demo-lite.mybahmni.in");
  }

  @When("user gets the title of the page")
  public void user_gets_the_title_of_the_page() {
    title = welcomePage.welcomePageTitle();
    System.out.println("Page title is: " + title);
  }

  @Then("page title should be {string}")
  public void page_title_should_be(String expectedTitleName) {
    Assert.assertTrue(title.contains(expectedTitleName));
  }
  
  @And("user finds {string} option")
  public void user_finds_option(String string) {
    flag = welcomePage.isClinicalServiceLinkExist();
    Assert.assertTrue(flag);
  }

  @When("user clicks Clinical Service option")
  public void user_clicks_clinical_service_option() {
    welcomePage.clickClinicalService();
  }

  @Then("page should navigate to Login Page")
  public void page_should_navigate_to_login_page() {
    flag = welcomePage.navigateLoginPage();
    Assert.assertTrue(flag);    
  }
}