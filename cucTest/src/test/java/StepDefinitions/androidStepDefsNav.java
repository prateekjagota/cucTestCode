package StepDefinitions;

import static org.junit.Assert.fail;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.remote.RemoteWebElement;

import com.cucumber.listener.Reporter;

import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
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
	
	@Then("^\"(.*)\" I tap on MoreMenu button$")
	public void clickMoreMenuButton(String deviceNum) throws Throwable {
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("Android")) {
			driverValText = "driver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			//No code for Android
		} else {
			driverValText = "idriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {			
				((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//XCUIElementTypeButton[@name=\"MORE\"]")).click();
			} catch(Exception e) {
				System.out.println(e.getMessage().toString());
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((IOSDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
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
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("Android")) {
			driverValText = "driver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
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
		} else {
			driverValText = "idriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);			
			try {
				int i=0;
				TimeUnit.SECONDS.sleep(3);		
				//System.out.println(((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("(//XCUIElementTypeStaticText)[3]")).getText());
				while(i<30) {
					//TouchAction touchAction = new TouchAction((PerformsTouchActions) ((IOSDriver) m.get("driver"+deviceNum)));
					JavascriptExecutor js = (JavascriptExecutor) ((IOSDriver) m.get("driver"+deviceNum));
					Map<String, Object> params = new HashMap<String, Object>();
					params.put("direction", "left");				
					RemoteWebElement element = (RemoteWebElement) ((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("(//XCUIElementTypeStaticText)[3]"));
					params.put("element", ((RemoteWebElement) element).getId());
					js.executeScript("mobile: swipe", params);
					TimeUnit.SECONDS.sleep(2);
					System.out.println(((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("(//XCUIElementTypeStaticText)[3]")).getText());
					if(((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("(//XCUIElementTypeStaticText)[3]")).getText().contains(offerText)) {
						Reporter.addStepLog("Found Text: "+((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("(//XCUIElementTypeStaticText)[3]")).getText());
						((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("(//XCUIElementTypeStaticText)[3]")).click();
						break;
					}
					i++;
				}
			} catch(Exception e) {
				System.out.println(e.getMessage().toString());
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((IOSDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		}
	}

	@Then("^\"(.*)\" I scroll down the screen for \"(.*)\" text$")
	public void scrollDownScreenforOffer(String deviceNum, String opText) throws Throwable {
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("Android")) {
			driverValText = "driver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				int i=0;
				TimeUnit.SECONDS.sleep(2);
				while(i<30) {
					TouchAction touchAction = new TouchAction(((AndroidDriver) m.get("driver"+deviceNum)));				
					Point pt = ((AndroidDriver) m.get("driver"+deviceNum)).findElement(MobileBy.xpath("//android.widget.TextView")).getLocation();
					List<WebElement> txtList = ((AndroidDriver) m.get("driver"+deviceNum)).findElements(MobileBy.xpath("//android.widget.TextView"));
					for (WebElement el: txtList) {
						if (el.getText().equals(opText)) {
							System.out.println("0");
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
				System.out.println("3");
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		} else {
			driverValText = "idriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);			
			try {
				int i=0;
				TimeUnit.SECONDS.sleep(3);		
				//System.out.println(((IOSDriver) m.get("driver"+deviceNum)).findElement(By.name("title")).getText());
					JavascriptExecutor js = (JavascriptExecutor) ((IOSDriver) m.get("driver"+deviceNum));
					Map<String, Object> params = new HashMap<String, Object>();
					params.put("predicateString", "value == '"+opText+"'");
					params.put("direction", "down");
					params.put("toVisible", "not an empty string");
					js.executeScript("mobile:scroll", params);
					TimeUnit.SECONDS.sleep(2);
					//System.out.println(((IOSDriver) m.get("driver"+deviceNum)).findElement(By.name("title")).getText());
			} catch(Exception e) {
				System.out.println(e.getMessage().toString());
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((IOSDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		}
	}

	@Then("^\"(.*)\" I scroll down Activity screen for \"(.*)\" text$")
	public void scrollDownActivityScreen(String deviceNum, String opText) throws Throwable {
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("Android")) {
			driverValText = "driver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			int brkFlag = 0;			
			try {
				((AndroidDriver) m.get("driver"+deviceNum)).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+opText+"\").instance(0))");
			} catch(Exception e) {
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		} else {
			driverValText = "idriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);			
			try {
				int i=0;
				TimeUnit.SECONDS.sleep(3);		
				//System.out.println(((IOSDriver) m.get("driver"+deviceNum)).findElement(By.name("title")).getText());
					JavascriptExecutor js = (JavascriptExecutor) ((IOSDriver) m.get("driver"+deviceNum));
					Map<String, Object> params = new HashMap<String, Object>();
					params.put("predicateString", "value == '"+opText+"'");
					params.put("direction", "down");
					params.put("toVisible", "not an empty string");
					js.executeScript("mobile:scroll", params);
					TimeUnit.SECONDS.sleep(2);
					//System.out.println(((IOSDriver) m.get("driver"+deviceNum)).findElement(By.name("title")).getText());
			} catch(Exception e) {
				System.out.println(e.getMessage().toString());
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((IOSDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		}
	}
	
	@Then("^\"(.*)\" I scroll down the screen for nextButton$")
	public void scrollDownScreenforText(String deviceNum) throws Throwable {
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("Android")) {
			driverValText = "driver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				//No code for android
			} catch(Exception e) {
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		} else {
			driverValText = "idriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);			
			try {
				int i=0;
				TimeUnit.SECONDS.sleep(3);		
				//List<WebElement> txtList = ((IOSDriver) m.get("driver"+deviceNum)).findElements(By.xpath("//XCUIElementTypeStaticText"));
				//for (WebElement el: txtList) {
				//	System.out.println(el.getText());							
				//}
				//System.out.println(((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//XCUIElementTypeStaticText")).getText());
				JavascriptExecutor js = (JavascriptExecutor) ((IOSDriver) m.get("driver"+deviceNum));
				//RemoteWebElement parent = (RemoteWebElement) ((IOSDriver) m.get("driver"+deviceNum)).findElement(By.className("XCUIElementTypeStaticText"));				
				//	String parentID = parent.getId();
					HashMap<String, String> scrollObject = new HashMap<String, String>();
				//	scrollObject.put("element", parentID);
					//scrollObject.put("direction", "down");
					scrollObject.put("predicateString", "value == 'Unlimited Instagram 1 Day Pass'");
					//scrollObject.put("name", "Unlimited Facebook 1 Day Pass");
					scrollObject.put("direction", "down");
					js.executeScript("mobile: scroll", scrollObject);  
			} catch(Exception e) {
				System.out.println(e.getMessage().toString());
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((IOSDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		}
	}

	@Then("^\"(.*)\" Verify \"(.*)\" OfferStatus as \"(.*)\"$")
	public void verfyOfferText(String deviceNum, String offerName, String opText) throws Throwable {
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("Android")) {
			driverValText = "driver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
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
		} else {
			driverValText = "idriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				List<WebElement> txtList = ((IOSDriver) m.get("driver"+deviceNum)).findElements(By.xpath("//XCUIElementTypeStaticText[@label="+offerName+"]"));
				for (WebElement el: txtList) {
					System.out.println(el.getText());
					if (el.getText().equals(offerName)) {
						int indx = txtList.indexOf(el);
						if (txtList.get(indx+2).getText().contains(opText)) {
							System.out.println(txtList.get(indx+2).getText());
							Reporter.addStepLog("Offer Status found as expected: " + txtList.get(indx+2).getText());
							break;
						} else {
							Reporter.addStepLog("Offer Status not as expected: " + txtList.get(indx+2).getText());
							cfg.takeScreenShot(((IOSDriver) m.get("driver"+deviceNum)));
							fail("Failed:");
						}
					}
				}	
			} catch(Exception e1) {
				Reporter.addStepLog(e1.getMessage().toString());
				cfg.takeScreenShot(((IOSDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		}
	}

	@Then("^\"(.*)\" Get Receipt Details$")
	public void getReceiptInfo(String deviceNum) throws Throwable {
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("Android")) {
			driverValText = "driver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				List<WebElement> transTabler1 = ((AndroidDriver) m.get("driver"+deviceNum)).findElements(MobileBy.xpath("//android.widget.TableLayout[1]/android.widget.TableRow[1]/android.widget.TextView"));
				List<WebElement> transTabler2 = ((AndroidDriver) m.get("driver"+deviceNum)).findElements(MobileBy.xpath("//android.widget.TableLayout[1]/android.widget.TableRow[2]/android.widget.TextView"));
				List<WebElement> transTabler3 = ((AndroidDriver) m.get("driver"+deviceNum)).findElements(MobileBy.xpath("//android.widget.TableLayout[1]/android.widget.TableRow[3]/android.widget.TextView"));
				for (WebElement el: transTabler1) {
					System.out.println(el.getText());
					Reporter.addStepLog(el.getText());
				}
				for (WebElement el: transTabler2) {
					System.out.println(el.getText());
					Reporter.addStepLog(el.getText());
				}
				for (WebElement el: transTabler3) {
					System.out.println(el.getText());
					Reporter.addStepLog(el.getText());
				}
				List<WebElement> receiptTabler2 = ((AndroidDriver) m.get("driver"+deviceNum)).findElements(MobileBy.xpath("//android.widget.TableLayout[2]/android.widget.TableRow[2]/android.widget.TextView"));
				List<WebElement> receiptTabler3 = ((AndroidDriver) m.get("driver"+deviceNum)).findElements(MobileBy.xpath("//android.widget.TableLayout[2]/android.widget.TableRow[3]/android.widget.TextView"));
				List<WebElement> receiptTabler4 = ((AndroidDriver) m.get("driver"+deviceNum)).findElements(MobileBy.xpath("//android.widget.TableLayout[2]/android.widget.TableRow[4]/android.widget.TextView"));
				List<WebElement> receiptTabler5 = ((AndroidDriver) m.get("driver"+deviceNum)).findElements(MobileBy.xpath("//android.widget.TableLayout[2]/android.widget.TableRow[5]/android.widget.TextView"));
				for (WebElement el: receiptTabler2) {
					System.out.println(el.getText());
					Reporter.addStepLog(el.getText());
				}
				for (WebElement el: receiptTabler3) {
					System.out.println(el.getText());
					Reporter.addStepLog(el.getText());
				}
				for (WebElement el: receiptTabler4) {
					System.out.println(el.getText());
					Reporter.addStepLog(el.getText());
				}
				for (WebElement el: receiptTabler5) {
					System.out.println(el.getText());
					Reporter.addStepLog(el.getText());
				}
				cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			} catch(Exception e1) {
				Reporter.addStepLog(e1.getMessage().toString());
				cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		} else {
			driverValText = "idriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			//No code for IOS
		}
	}

	@Then("^\"(.*)\" Verify total Receipt Amount as \"(.*)\"$")
	public void verfyreceiptAmtText(String deviceNum, String opText) throws Throwable {
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("Android")) {
			driverValText = "driver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				String rcptAmt = ((AndroidDriver) m.get("driver"+deviceNum)).findElement(MobileBy.xpath("//android.widget.TableLayout[2]/android.widget.TableRow[5]/android.widget.TextView[2]")).getText();
				if (rcptAmt.equals(opText)) {
					System.out.println("Total amount matched!");
					Reporter.addStepLog("Total amount matched!");
				} else {
					System.out.println("Total amount not matched!");
					Reporter.addStepLog("Total amount not matched!");
					fail("Failed:");
				}
			} catch(Exception e1) {
				Reporter.addStepLog(e1.getMessage().toString());
				cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		} else {
			driverValText = "idriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			//No code for IOS
		}
	}

	@Then("^\"(.*)\" Verify \"(.*)\" ActivityStatus as \"(.*)\"$")
	public void verfyActivityText(String deviceNum, String offerName, String opText) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			List<WebElement> txtList = ((AndroidDriver) m.get("driver"+deviceNum)).findElements(MobileBy.xpath("//android.widget.RelativeLayout[1]/android.widget.TextView"));
			for (WebElement el: txtList) {
				System.out.println(el.getText());
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

	@Then("^\"(.*)\" Verify \"(.*)\" iosActivityStatus$")
	public void verfyiosActivityText(String deviceNum, String offerName) throws Throwable {
		String driverValText = null;
		driverValText = "idriver"+deviceNum.toString();
		Field m = getDriverFields(driverValText);
		try {
			int i = 2;
			while(i<13) {
				//System.out.println(((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("(//XCUIElementTypeStaticText[@name=\"AX error -25205\"])["+i+"]")).getText());
				String verTxt=((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("(//XCUIElementTypeStaticText[@name=\"AX error -25205\"])["+i+"]")).getText();
				if (verTxt.equals(offerName)) {
					System.out.println("Found Offer :"+verTxt);
					break;
				}
				i+=5;
			}
		} catch(Exception e1) {
			Reporter.addStepLog(e1.getMessage().toString());
			cfg.takeScreenShot(((IOSDriver) m.get("driver"+deviceNum)));
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
	
	@Then("^\"(.*)\" I tap on Search button$")
	public void clickSearchButton(String deviceNum) throws Throwable {
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("Android")) {
			driverValText = "driver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//android.widget.TextView[@content-desc=\"Search\"]")).click();
			} catch(Exception e) {
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		} else {
			driverValText = "idriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("(//XCUIElementTypeButton[@name=\"AX error -25205\"])[1]")).click();
			} catch(Exception e) {
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((IOSDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		}
	}

	@Then("^\"(.*)\" I tap on Download button$")
	public void clickDownloadButton(String deviceNum) throws Throwable {
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("Android")) {
			driverValText = "driver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				try {
					((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//android.widget.TextView[@content-desc=\"Download\"]")).click();
				} catch(Exception e1) {
					System.out.println("Receipt already downloaded clicking View button");
					((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//android.widget.TextView[@content-desc=\"View\"]")).click();
				}
			} catch(Exception e) {
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		} else {
			driverValText = "idriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			//No Code for IOS
		}
	}
	
	@Then("^\"(.*)\" I search and select product as \"(.*)\"$")
	public void searchSelectOffer(String deviceNum, String opType) throws Throwable {
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("Android")) {
			driverValText = "driver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				((AndroidDriver) m.get("driver"+deviceNum)).findElement(MobileBy.id("com.matrixx.android.branding:id/searchEditText_input")).sendKeys(opType.toString()+"\n");
				TimeUnit.SECONDS.sleep(2);
				List<WebElement> txtList = ((AndroidDriver) m.get("driver"+deviceNum)).findElements(MobileBy.id("com.matrixx.android.branding:id/offer_title"));
				for (WebElement el: txtList) {
					if (el.getText().contains(opType.toString())) {
						el.click();
					}
				}	
			} catch(Exception e1) {
				Reporter.addStepLog(e1.getMessage().toString());
				cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		} else {
			driverValText = "idriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("(//XCUIElementTypeTextField[@name=\"AX error -25205\"])[1]")).sendKeys(opType);
				((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("(//XCUIElementTypeTextField[@name=\"AX error -25205\"])[1]")).sendKeys(Keys.RETURN);
			} catch(Exception e) {
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((IOSDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		}
	}
	
	@Then("^\"(.*)\" I enter-\"(.*)\" as \"(.*)\"$")
	public void enterUserVals(String deviceNum, String userField, String userVal) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			((AndroidDriver) m.get("driver"+deviceNum)).hideKeyboard();
		} catch (Exception e) {}
		try {
			if (userField.equals("Contact FullName")) {	
				WebElement el = ((AndroidDriver) m.get("driver"+deviceNum)).findElement(MobileBy.xpath("//TextInputLayout[1]/android.widget.FrameLayout/android.widget.EditText"));
				el.click();el.clear();el.sendKeys(userVal.toString());
			} else if (userField.equals("Contact Email")) {
				WebElement el = ((AndroidDriver) m.get("driver"+deviceNum)).findElement(MobileBy.xpath("//TextInputLayout[2]/android.widget.FrameLayout/android.widget.EditText"));
				el.click();el.clear();el.sendKeys(userVal.toString());
			} else if (userField.equals("Contact Number")) {
				WebElement el = ((AndroidDriver) m.get("driver"+deviceNum)).findElement(MobileBy.xpath("//TextInputLayout[3]/android.widget.FrameLayout/android.widget.EditText"));
				el.click();el.clear();el.sendKeys(userVal.toString());
			} else if (userField.equals("Shipping FullName")) {
				WebElement el = ((AndroidDriver) m.get("driver"+deviceNum)).findElement(MobileBy.xpath("//TextInputLayout[4]/android.widget.FrameLayout/android.widget.EditText"));
				el.click();el.clear();el.sendKeys(userVal.toString());
			} else if (userField.equals("Shipping Address1")) {
				WebElement el = ((AndroidDriver) m.get("driver"+deviceNum)).findElement(MobileBy.xpath("//TextInputLayout[5]/android.widget.FrameLayout/android.widget.EditText"));
				el.click();el.clear();el.sendKeys(userVal.toString());
			} else if (userField.equals("Shipping Address2")) {
				int i=0;
				TimeUnit.SECONDS.sleep(2);
				while(i<5) {
					TouchAction touchAction = new TouchAction(((AndroidDriver) m.get("driver"+deviceNum)));				
					Point pt = ((AndroidDriver) m.get("driver"+deviceNum)).findElement(MobileBy.xpath("//TextInputLayout")).getLocation();
					List<WebElement> txtList = ((AndroidDriver) m.get("driver"+deviceNum)).findElements(MobileBy.xpath("//TextInputLayout"));
					for (WebElement el: txtList) {
						if (el.getText().equals("Phone Number")) {
							System.out.println("Found Text: " + el.getText());
							break;
						} else {
							i++;
						}
					}
					touchAction.press(pt.x,pt.y+300).moveTo(0, -300).release().perform();
					TimeUnit.SECONDS.sleep(2);
				}
				WebElement el = ((AndroidDriver) m.get("driver"+deviceNum)).findElement(MobileBy.xpath("//TextInputLayout[6]/android.widget.FrameLayout/android.widget.EditText"));
				el.click();el.clear();el.sendKeys(userVal.toString());
			} else if (userField.equals("Shipping City")) {
				WebElement el = ((AndroidDriver) m.get("driver"+deviceNum)).findElement(MobileBy.xpath("//TextInputLayout[7]/android.widget.FrameLayout/android.widget.EditText"));
				el.click();el.clear();el.sendKeys(userVal.toString());
			} else if (userField.equals("Shipping Region")) {
				WebElement el = ((AndroidDriver) m.get("driver"+deviceNum)).findElement(MobileBy.xpath("//TextInputLayout[8]/android.widget.FrameLayout/android.widget.EditText"));
				el.click();el.clear();el.sendKeys(userVal.toString());
			} else if (userField.equals("Shipping ZIP")) {
				WebElement el = ((AndroidDriver) m.get("driver"+deviceNum)).findElement(MobileBy.xpath("//TextInputLayout[9]/android.widget.FrameLayout/android.widget.EditText"));
				el.click();el.clear();el.sendKeys(userVal.toString());
			} else if (userField.equals("Shipping PhoneNumber")) {
				WebElement el = ((AndroidDriver) m.get("driver"+deviceNum)).findElement(MobileBy.xpath("//TextInputLayout[10]/android.widget.FrameLayout/android.widget.EditText"));
				el.click();el.clear();el.sendKeys(userVal.toString());
			} else {
				assert false: "Code not added for" + userField;
			}
			try {
				((AndroidDriver) m.get("driver"+deviceNum)).hideKeyboard();
			} catch (Exception e) {}
		} catch(Exception e1) {
			Reporter.addStepLog(e1.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}
	
	@Then("^\"(.*)\" I tap on Arrow button$")
	public void clickArrowButton(String deviceNum) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("fab")).click();
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}
	
	@Then("^\"(.*)\" I tap on Tick button$")
	public void clickTickButton(String deviceNum) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("fab")).click();
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}
	
	@Then("^\"(.*)\" I select DeliveryType as \"(.*)\"$")
	public void selectDeliveryType(String deviceNum, String opType) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			if (opType.equals("Free Standard Shipping")) {
				String s = ((AndroidDriver) m.get("driver"+deviceNum)).findElement(MobileBy.xpath("//android.widget.RelativeLayout[1]/android.widget.CheckBox")).getAttribute("checked");
				if (s.equals("false")) {
					((AndroidDriver) m.get("driver"+deviceNum)).findElement(MobileBy.xpath("//android.widget.RelativeLayout[1]/android.widget.CheckBox")).click();
				}
			} else if (opType.equals("UberRUSH")) {
				String s = ((AndroidDriver) m.get("driver"+deviceNum)).findElement(MobileBy.xpath("//android.widget.RelativeLayout[2]/android.widget.CheckBox")).getAttribute("checked");
				if (s.equals("false")) {
					((AndroidDriver) m.get("driver"+deviceNum)).findElement(MobileBy.xpath("//android.widget.RelativeLayout[2]/android.widget.CheckBox")).click();
				}
			} else {
				assert false: "Code not added for" + opType;
			}
		} catch(Exception e1) {
			Reporter.addStepLog(e1.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}
}