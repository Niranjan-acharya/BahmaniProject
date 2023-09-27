package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.bahmni.pages.BahmniWelcomePage;
import com.bahmni.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSD {
  private static String url;
  private WebDriver driver = DriverFactory.getDriver();
  private BahmniWelcomePage welcomePage = new BahmniWelcomePage(driver);
  private LoginPage loginPage = new LoginPage(driver);

  @Given("user on BAHMNI login page")
  public void user_on_bahmni_login_page() {
    System.out.println("Login Page");
    WelcomePageSD obj = new WelcomePageSD();
    obj.page_should_navigate_to_login_page();
  }

  @Given("user enters username {string}")
  public void user_enters_username(String string) {
    loginPage.enterUserName(string);
  }

  @Given("user enters password {string}")
  public void user_enters_password(String string) {
    loginPage.enterPassword(string);
  }

  @Given("user selects location {string}")
  public void user_selects_location(String loc) {
    loginPage.selectLocation();
//    Assert.assertTrue(.contains(loc));
  }

  @When("user clicks on Login")
  public void user_clicks_on_login() {
    loginPage.clickOnLogin();
  }

  @Then("page should navigate to {string} Page")
  public void page_should_navigate_to_dashboard_page(String string) throws InterruptedException {
    System.out.println("STRING URL :: "+string);
    url = loginPage.navigateDashboardPage();
    Assert.assertTrue(url.contains(string));
  }
}
