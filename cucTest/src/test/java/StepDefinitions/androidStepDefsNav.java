package StepDefinitions;

import static org.junit.Assert.fail;

import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.cucumber.listener.Reporter;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
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
				String url = ((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView[2]")).getText();
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

	@Then("^\"(.*)\" I swipe the Screen for \"(.*)\" offer$")
	public void swipeScreenforOffer(String deviceNum, String offerText) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			int i=0;
			TimeUnit.SECONDS.sleep(2);
			while(i<30) {
				TouchAction touchAction = new TouchAction(((AndroidDriver) m.get("driver"+deviceNum)));				
				Point pt = ((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.TextView[1]")).getLocation();
				touchAction.press(pt.x+500,pt.y).moveTo(-500, 0).release().perform();
				TimeUnit.SECONDS.sleep(2);
				if(((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.TextView[1]")).getText().contains(offerText)) {
					System.out.println("Found Text: "+(((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.TextView[1]")).getText()));
					Reporter.addStepLog("Found Text: "+(((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.TextView[1]")).getText()));
					((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.TextView[1]")).click();
					break;
				}
				i++;
			}
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}

	@Then("^\"(.*)\" I scroll down the screen for \"(.*)\" text$")
	public void scrollDownScreenforOffer(String deviceNum, String opText) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			int i=0;
			TimeUnit.SECONDS.sleep(2);
			while(i<30) {
				TouchAction touchAction = new TouchAction(((AndroidDriver) m.get("driver"+deviceNum)));				
				Point pt = ((AndroidDriver) m.get("driver"+deviceNum)).findElement(MobileBy.xpath("//android.widget.TextView")).getLocation();
				List<WebElement> txtList = ((AndroidDriver) m.get("driver"+deviceNum)).findElements(MobileBy.xpath("//android.widget.TextView"));
				for (WebElement el: txtList) {
					if (el.getText().equals(opText)) {
						System.out.println("Found Text: " + el.getText());
						break;
					} else {
						i++;
					}
				}
				touchAction.press(pt.x,pt.y+300).moveTo(0, -300).release().perform();
				TimeUnit.SECONDS.sleep(2);
			}
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}

	@Then("^\"(.*)\" Verify \"(.*)\" OfferStatus as \"(.*)\"$")
	public void verfyOfferText(String deviceNum, String offerName, String opText) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			List<WebElement> txtList = ((AndroidDriver) m.get("driver"+deviceNum)).findElements(MobileBy.xpath("//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView"));
			for (WebElement el: txtList) {
				if (el.getText().equals(offerName)) {
					int indx = txtList.indexOf(el);
					if (txtList.get(indx+2).getText().contains(opText)) {
						System.out.println(txtList.get(indx+2).getText());
						Reporter.addStepLog("Offer Status found as expected: " + txtList.get(indx+2).getText());
						break;
					} else {
						Reporter.addStepLog("Offer Status not as expected: " + txtList.get(indx+2).getText());
						cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
						fail("Failed:");
					}
				}
			}	
		} catch(Exception e1) {
			Reporter.addStepLog(e1.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}

	@Then("^\"(.*)\" Verify \"(.*)\" ActivityStatus as \"(.*)\"$")
	public void verfyActivityText(String deviceNum, String offerName, String opText) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			List<WebElement> txtList = ((AndroidDriver) m.get("driver"+deviceNum)).findElements(MobileBy.xpath("//android.widget.RelativeLayout[1]/android.widget.TextView"));
			for (WebElement el: txtList) {
				if (el.getText().contains(offerName)) {
					int indx = txtList.indexOf(el);
					if (txtList.get(indx-2).getText().contains("minutes ago") && txtList.get(indx).getText().contains("has been purchased")) {
						System.out.println("Activity Status found as expected: " + txtList.get(indx-2).getText() + "\n" +txtList.get(indx-1).getText()+ "\n" +txtList.get(indx).getText());
						Reporter.addStepLog("Activity Status found as expected: " + txtList.get(indx-2).getText() + "\n" +txtList.get(indx-1).getText()+ "\n" +txtList.get(indx).getText());
						break;
					} else {
						System.out.println("Activity Status not found as expected: " + txtList.get(indx-2).getText() + "\n" +txtList.get(indx-1).getText()+ "\n" +txtList.get(indx).getText());
						Reporter.addStepLog("Activity Status not found as expected: " + txtList.get(indx-2).getText() + "\n" +txtList.get(indx-1).getText()+ "\n" +txtList.get(indx).getText());
						cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
						fail("Failed:");
					}
				}
			}	
		} catch(Exception e1) {
			Reporter.addStepLog(e1.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}


	@Then("^\"(.*)\" I tap on BuyCart button$")
	public void clickbuyCartButton(String deviceNum) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("buy_button")).click();
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}

	@Then("^\"(.*)\" I tap on DONE button$")
	public void clickappDoneButton(String deviceNum) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//android.widget.Button[contains(@text, 'DONE')]")).click();
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}
}