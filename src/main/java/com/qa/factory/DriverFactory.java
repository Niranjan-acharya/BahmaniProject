package com.qa.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
  private static WebDriver driver;
  
  public WebDriver init_Driver(String browser) {
    System.out.println("browser value is :: " + browser);
    if (browser.equals("edge")) {
      WebDriverManager.edgedriver().setup();
      driver = new EdgeDriver();
    } else {
      System.out.println("Please check the browser value :: " + browser);
    }
    
    driver.manage().deleteAllCookies();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    return getDriver();
  }

  public static synchronized WebDriver getDriver() {
    return driver;
  }
}
