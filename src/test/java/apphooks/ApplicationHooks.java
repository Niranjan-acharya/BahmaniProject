package apphooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.utilities.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ApplicationHooks {
  private ConfigReader configReader;
  private Properties prop;
  private DriverFactory driverFactory;
  private WebDriver driver;
  
  @Before(order = 0)
  public void get_Property() throws IOException {
    configReader = new ConfigReader();
    prop = configReader.init_Prop();
  }
  
  @Before(order = 1)
  public void launchBrowser(){
    String browserName = prop.getProperty("browser");
    driverFactory = new DriverFactory();
    driver = driverFactory.init_Driver(browserName);
  }

  @After(order = 0)
  public void quitBrowser() throws InterruptedException  {
    Thread.sleep(5000);
    driver.quit();
  }
}
