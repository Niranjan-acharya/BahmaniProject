package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {
        "./src/test/resources/features/bahmniWelcomePage.feature", 
        "./src/test/resources/features/loginPage.feature",
        "./src/test/resources/features/dashboardPage.feature",
        "./src/test/resources/features/NewPatientPage.feature"
        },
    glue = {"stepdefinitions", "apphooks"},
    plugin = { "pretty", "junit:target/JUnitReports/report.xml",
        "json:target/JSONReports/report.json",
        "html:target/HtmlReports",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "timeline:test-output-thread/" }
    )

public class TestRunner {
}