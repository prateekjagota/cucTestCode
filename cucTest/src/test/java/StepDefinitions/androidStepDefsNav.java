package StepDefinitions;

import static org.junit.Assert.fail;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.cucumber.listener.Reporter;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import StepDefinitions.Config;
import cucumber.api.java.en.Then;

public class androidStepDefsNav {
	Config cfg = new Config();
	public Field getDriverFields(String driverName) throws NoSuchFieldException, SecurityException {
		Field m = Config.class.getDeclaredField(driverName);
		m.setAccessible(true);
		return m;
	}
	@Then("^\"(.*)\" I tap on LeftMenu button$")
	public void clickLeftMenuButton(String deviceNum) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {			
			((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}
	
	@Then("^\"(.*)\" I tap on BackArrow button$")
	public void clickbacArrButton(String deviceNum) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}
	
	@Then("^\"(.*)\" I tap on \"(.*)\" menuItem$")
	public void selectMenuItem(String deviceNum, String opText) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			WebElement el = ((AndroidDriver) m.get("driver"+deviceNum)).findElement(MobileBy.xpath("//android.widget.CheckedTextView[contains(@text, '"+opText+"')]"));
			el.click();
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}
	
	@Then("^\"(.*)\" I enable Group Sharing$")
	public void enableGroupSharing(String deviceNum) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			if(((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("enable_fs_switch")).getText().equals("Enable Group Sharing OFF")) {
				((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("enable_fs_switch")).click();
				((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//android.widget.Button[contains(@text, 'OK')]")).click();
			}
			if(((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("enable_fs_switch")).getText().equals("Enable Group Sharing ON")) {
				Reporter.addStepLog("Group Sharing already enabled..");
			}
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}
	
	@Then("^\"(.*)\" I disable Group Sharing$")
	public void disableGroupSharing(String deviceNum) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			if(((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("enable_fs_switch")).getText().equals("Enable Group Sharing ON")) {
				((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("enable_fs_switch")).click();
				((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//android.widget.Button[contains(@text, 'OK')]")).click();
			}
			if(((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("enable_fs_switch")).getText().equals("Enable Group Sharing OFF")) {
				Reporter.addStepLog("Group Sharing already disabled..");
			}
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}
	
	@Then("^\"(.*)\" Show \"(.*)\" text$")
	public void showText(String deviceNum, String opType) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			if (opType.equals("LoyalityPoints")) {
				String uName = ((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("header_user_name")).getText();
				String pts = ((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("header_points")).getText();
				Reporter.addStepLog(uName + " has " + pts);
				System.out.println(uName + " has " + pts);
			} else if(opType.equals("ServerURL")) {
				String url = ((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("summary")).getText();
				Reporter.addStepLog("Server URL: "+url);
				System.out.println("Server URL: "+url);
			} else {
				assert false: "Code not added for" + opType;
			}
		} catch(Exception e1) {
			Reporter.addStepLog(e1.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}
	@Then("^\"(.*)\" Capture the ScreenShot$")
	public void captureScreenShot(String deviceNum) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}
}