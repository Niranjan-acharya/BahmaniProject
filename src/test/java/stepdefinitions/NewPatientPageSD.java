package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.bahmni.pages.NewPatientPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewPatientPageSD {
  private static String url;
  private WebDriver driver = DriverFactory.getDriver();
  private NewPatientPage newPatientPage= new NewPatientPage(driver);
  private boolean flag = false;

  @And("user enters firstname {string}")
  public void user_enters_firstname(String string) {
    newPatientPage.enterFirstName(string);
  }

  @And("user enters lastname {string}")
  public void user_enters_lastname(String string) {
    newPatientPage.enterLastName(string);
  }

  @And("user selects gender {string}")
  public void user_selects_gender(String string) {
    newPatientPage.selectGender(string);
  }

  @And("user selects birthdate {string}")
  public void user_selects_birthdate(String string) {
    newPatientPage.selectBirhtDate(string);
  }

  @When("user clicks on Save")
  public void user_clicks_on_save() {
    newPatientPage.clickSave();
  }

  @Then("page should create patinet Id")
  public void page_should_create_patinet_id() throws InterruptedException {
    flag = newPatientPage.isPatientIdCreated();
    Assert.assertTrue(flag); 
  }
}
