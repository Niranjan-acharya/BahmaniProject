package com.qa.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
  private Properties prop;
  private String propLocation = "./src/test/resources/config/config.properties";

  public Properties init_Prop() throws IOException {
    prop = new Properties();
    
    FileInputStream fip = new FileInputStream(propLocation);
    prop.load(fip);
    
    return prop;
  }
}
