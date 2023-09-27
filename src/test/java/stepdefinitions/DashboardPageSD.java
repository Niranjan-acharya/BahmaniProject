package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.bahmni.pages.BahmniWelcomePage;
import com.bahmni.pages.DashboardPage;
import com.bahmni.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashboardPageSD {
  private static String url;
  private WebDriver driver = DriverFactory.getDriver();
  private BahmniWelcomePage welcomePage = new BahmniWelcomePage(driver);
  private LoginPage loginPage = new LoginPage(driver);
  private DashboardPage dashboardPage = new DashboardPage(driver);

  private boolean flag = false;
  
  @Given("user on BAHMNI Dashboard page")
  public void user_on_bahmni_dashboard_page() throws InterruptedException {
    System.out.println("Dashboard Page");
    LoginPageSD obj = new LoginPageSD();
    obj.page_should_navigate_to_dashboard_page("dashboard");
  }
  
  @And("user finds {string} option2")
  public void user_finds_option2(String string) {
    flag = dashboardPage.isRegistrationLinkExist();
    Assert.assertTrue(flag); 
  }

  @When("user clicks Registration option")
  public void user_clicks_registration_option() {
    dashboardPage.clickOnRegistration();
  }

  @Then("page should navigate to {string} Page2")
  public void page_should_navigate_to_search_page2(String string) throws InterruptedException {
    System.out.println("STRING URL :: "+string);
    url = dashboardPage.navigateSearchPage();
    Assert.assertTrue(url.contains(string));
  }
}