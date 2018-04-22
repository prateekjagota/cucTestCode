package StepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	  public String getCfg(String val) {
	    Properties prop = new Properties();
	    String fileName = "setup.cfg";
	    InputStream is = null;
		try {
			is = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	    try {
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(val);
	  }
}
	 