package StepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.cucumber.listener.Reporter;

import io.appium.java_client.android.AndroidDriver;

public class Config {
	public static AndroidDriver driverD1;public static AndroidDriver driverD2;
	public static String driverName = "driver";
	public static final DesiredCapabilities capabilities = new DesiredCapabilities();
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
	  
	  public void takeScreenShot(WebDriver driver) {
		  String destDir = "output/screenshots";
		  File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		  new File(destDir).mkdirs();
		  String destFile = timeStamp + ".png";

		  try {
		   FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
		   Reporter.addStepLog(destDir.split("/")[1]+"/"+destFile);
		   Reporter.addScreenCaptureFromPath(destDir.split("/")[1]+"/"+destFile);
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
	  }
	  public void installApp(String deviceNum, int deletePrevApp) throws Throwable {
		  System.out.println(getCfg(deviceNum+"deviceType"));
		  if (getCfg(deviceNum+"deviceType").equals("Android")) {
			  	capabilities.setCapability("platformName", getCfg(deviceNum+"platformName"));
				capabilities.setCapability("deviceName", getCfg(deviceNum+"deviceUDID"));
				capabilities.setCapability("app", getCfg(deviceNum+"appPath"));
				capabilities.setCapability(CapabilityType.VERSION, getCfg(deviceNum+"version"));
				capabilities.setCapability("appPackage", getCfg(deviceNum+"appPackageName"));
				capabilities.setCapability("newCommandTimeout", getCfg(deviceNum+"newCommandTimeout"));
				capabilities.setCapability("autoGrantPermissions", "true");
				capabilities.setCapability("unicodeKeyboard", true);
				capabilities.setCapability("resetKeyboard", true);
				if (deletePrevApp == 0) {
					capabilities.setCapability("noReset", true);
					capabilities.setCapability("fullReset", false);
				}  
		  } else {
			  System.out.println("Code for IOS");
			  	capabilities.setCapability("platformName", getCfg(deviceNum+"platformName"));
			  	capabilities.setCapability("app", getCfg(deviceNum+"appPath"));
			  	capabilities.setCapability("deviceName", getCfg(deviceNum+"deviceName"));
			  	capabilities.setCapability("udid", getCfg(deviceNum+"deviceUDID"));
			  	capabilities.setCapability("automationName", "XCUITest");
			  	capabilities.setCapability("newCommandTimeout", getCfg(deviceNum+"newCommandTimeout"));
			  	capabilities.setCapability("platformVersion", getCfg(deviceNum+"version"));
			  	capabilities.setCapability("showXcodeLog", true);
			  	if (deletePrevApp == 0) {
					capabilities.setCapability("noReset", true);
					capabilities.setCapability("fullReset", false);
				}
		  }
	}
	public void launchApp(String deviceNum) throws Throwable {
		if (getCfg(deviceNum+"deviceType").equals("Android")) {
			if(deviceNum.equals("D1")) {
				driverD1 = new AndroidDriver(new URL("http://"+getCfg(deviceNum+"appiumServerAddress")+"/wd/hub"), capabilities);
				driverD1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			} else if(deviceNum.equals("D2")) {
				driverD2 = new AndroidDriver(new URL("http://"+getCfg(deviceNum+"appiumServerAddress")+"/wd/hub"), capabilities);
				driverD2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			} else {
				System.out.println("Need to add support for more than 2 devices..");
			}
		} else {
			if(deviceNum.equals("D1")) {
				driverD1 = (AndroidDriver) new RemoteWebDriver(new URL("http://"+getCfg(deviceNum+"appiumServerAddress")+"/wd/hub"), capabilities);
				driverD1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			} else if(deviceNum.equals("D2")) {
				driverD2 = (AndroidDriver) new RemoteWebDriver(new URL("http://"+getCfg(deviceNum+"appiumServerAddress")+"/wd/hub"), capabilities);
				driverD2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			} else {
				System.out.println("Need to add support for more than 2 devices..");
			}
		}
	}
}
	 