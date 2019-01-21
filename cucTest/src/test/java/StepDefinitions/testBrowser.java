package StepDefinitions;

import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import static org.junit.Assert.fail;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import com.cucumber.listener.Reporter;
import StepDefinitions.Config;


public class testBrowser {
	Config cfg = new Config();
	public Field getDriverFields(String driverName) throws NoSuchFieldException, SecurityException {
		Field m = Config.class.getDeclaredField(driverName);
		m.setAccessible(true);
		return m;
	}
	
	@Then("^\"(.*)\" I click on web-\"(.*)\" element$")
	public void clickRegister(String deviceNum,String idVal) throws Throwable {
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("WEB")) {
			driverValText = "wdriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				((ChromeDriver) m.get("driver"+deviceNum)).findElement(By.id(idVal)).click();
			} catch(Exception e) {
				System.out.println(e.getMessage().toString());
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((ChromeDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		} 
	}


	@Then("^\"(.*)\" I click on web-\"(.*)\" text$")
	public void clickText(String deviceNum,String textVal) throws Throwable {
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("WEB")) {
			driverValText = "wdriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				((ChromeDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//*[contains(text(), '"+textVal+"')]")).click();
			} catch(Exception e) {
				System.out.println(e.getMessage().toString());
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((ChromeDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		} 
	}


	@Then("^\"(.*)\" I scroll to web-\"(.*)\" text$")
	public void scrollElement(String deviceNum,String textVal) throws Throwable {
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("WEB")) {
			driverValText = "wdriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				JavascriptExecutor js = (JavascriptExecutor) ((ChromeDriver) m.get("driver"+deviceNum));
				WebElement Element = ((ChromeDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//*[contains(text(), '"+textVal+"')]"));
				js.executeScript("arguments[0].scrollIntoView();", Element);
			} catch(Exception e) {
				System.out.println(e.getMessage().toString());
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((ChromeDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		} 
	}
	
	@Then("^\"(.*)\" I enter text \"(.*)\" on web-\"(.*)\" element$")
	public void enterVals(String deviceNum,String txtVal,String idVal) throws Throwable {
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("WEB")) {
			driverValText = "wdriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				((ChromeDriver) m.get("driver"+deviceNum)).findElement(By.id(idVal)).sendKeys(txtVal.toString());
			} catch(Exception e) {
				System.out.println(e.getMessage().toString());
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((ChromeDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		} 
	}

	@Then("^\"(.*)\" I add web-amount as \"(.*)\"$")
	public void enterAmount(String deviceNum,String txtVal) throws Throwable {
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("WEB")) {
			driverValText = "wdriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				((ChromeDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//input[@id='amount']")).sendKeys(txtVal);
			} catch(Exception e) {
				System.out.println(e.getMessage().toString());
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((ChromeDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		} 
	}
	
	@Then("^\"(.*)\" I select the web-\"(.*)\"$")
	public void selectBilling(String deviceNum,String txtVal) throws Throwable {
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("WEB")) {
			driverValText = "wdriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				if (txtVal.toString().equals("billingCycle")) {
					((ChromeDriver) m.get("driver"+deviceNum)).findElement(By.id(txtVal)).click();
					TimeUnit.SECONDS.sleep(2);
					((ChromeDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//mat-option[@id='mat-option-1']")).click();
				}				
			} catch(Exception e) {
				System.out.println(e.getMessage().toString());
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((ChromeDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		} 
	}

	@Then("^\"(.*)\" I web-wait for \"(.*)\" seconds$")
	public void universalWait(String deviceNum, int timeVal) throws Throwable {
		Field m = getDriverFields("wdriver"+deviceNum);
		try {
			TimeUnit.SECONDS.sleep(timeVal);
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((ChromeDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}

	@Then("^\"(.*)\" I close the browser$")
	public void closeBrowser(String deviceNum) throws Throwable {
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("WEB")) {
			driverValText = "wdriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				((ChromeDriver) m.get("driver"+deviceNum)).quit();
			} catch(Exception e) {
				System.out.println(e.getMessage().toString());				
			}
		} 
	}
}