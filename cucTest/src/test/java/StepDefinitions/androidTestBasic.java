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


public class androidTestBasic {
	Config cfg = new Config();
	public Field getDriverFields(String driverName) throws NoSuchFieldException, SecurityException {
		Field m = Config.class.getDeclaredField(driverName);
		m.setAccessible(true);
		return m;
	}
	
	public void callScreenShot(WebDriver driver) throws Throwable {
		
	}
	@Given("^\"(.*)\" I install and launch the application$")
	public void installLaunch(String deviceNum) throws Throwable {
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("Android")) {
			driverValText = "driver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				cfg.installApp(deviceNum,1);
				cfg.launchApp(deviceNum);
				cfg.takeScreenShot(((AndroidDriver) m.get(driverValText)));
		 	} catch(Exception e) {
				Reporter.addStepLog(e.getMessage().toString());
				System.out.println(e.getMessage());
				cfg.takeScreenShot(((AndroidDriver) m.get(driverValText)));
				fail("Failed:"+e.toString());
			}
		} else if (cfg.getCfg(deviceNum+"deviceType").equals("IOS")) {
			driverValText = "idriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				cfg.installApp(deviceNum,1);
				cfg.launchApp(deviceNum);
				cfg.takeScreenShot(((IOSDriver) m.get(driverValText)));
		 	} catch(Exception e) {
				Reporter.addStepLog(e.getMessage().toString());
				System.out.println(e.getMessage());
				cfg.takeScreenShot(((IOSDriver) m.get(driverValText)));
				fail("Failed:"+e.toString());
			}
		}
	}
	
	@Given("^\"(.*)\" I launch the application$")
	public void launchAppTest(String deviceNum) throws Throwable {
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("Android")) {
			driverValText = "driver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
					cfg.installApp(deviceNum,0);
					cfg.launchApp(deviceNum);	
			} catch(Exception e) {
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		} else if (cfg.getCfg(deviceNum+"deviceType").equals("IOS")) {
			driverValText = "idriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				cfg.installApp(deviceNum,0);
				cfg.launchApp(deviceNum);	
			} catch(Exception e) {
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((IOSDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		} else if (cfg.getCfg(deviceNum+"deviceType").equals("WEB")) {
			driverValText = "wdriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				cfg.launchApp(deviceNum);
				System.out.println(cfg.getCfg(deviceNum+"launchURL"));
				((ChromeDriver) m.get("driver"+deviceNum)).get(cfg.getCfg(deviceNum+"launchURL"));
			} catch(Exception e) {
				System.out.println(e.getMessage().toString());
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((ChromeDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		}
	}	
	
	@Then("^\"(.*)\" I tap on agreement checkBox$")
	public void clickCheckBox(String deviceNum) throws Throwable {
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("Android")) {
			driverValText = "driver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("terms_checkbox")).click();
			} catch(Exception e) {
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		} else {
			driverValText = "idriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				((IOSDriver) m.get("driver"+deviceNum)).findElement(By.className("XCUIElementTypeSwitch")).click();
			} catch(Exception e) {
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((IOSDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		}
	}
	
	@Then("^\"(.*)\" I tap on agree continue button$")
	public void clickAgreeButton(String deviceNum) throws Throwable {
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("Android")) {
			driverValText = "driver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("terms_button")).click();
			} catch(Exception e) {
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		} else {
			driverValText = "idriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//XCUIElementTypeButton[@name=\"agree\"]")).click();
			} catch(Exception e) {
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((IOSDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		}
	}
	
	@Then("^\"(.*)\" I tap on iSettings button$")
	public void clickiButton(String deviceNum) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("btn_settings")).click();
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}
	
	@Then("^\"(.*)\" I swipe the Screens$")
	public void swipScreen(String deviceNum) throws Throwable {
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("Android")) {
			driverValText = "driver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				int i=0;
				TimeUnit.SECONDS.sleep(2);
				while(i<30) {
					TouchAction touchAction = new TouchAction(((AndroidDriver) m.get("driver"+deviceNum)));
					Point pt = ((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("headline")).getLocation();
					touchAction.press(pt.x+200, pt.y).moveTo(pt.x, pt.y).release().perform();				
					TimeUnit.SECONDS.sleep(2);
					if(((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("headline")).getText().contains("Pack your suitcases and take your phone")) {
						Reporter.addStepLog("Found Text: "+((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("headline")).getText());
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
				while(i<30) {
					//TouchAction touchAction = new TouchAction((PerformsTouchActions) ((IOSDriver) m.get("driver"+deviceNum)));
					JavascriptExecutor js = (JavascriptExecutor) ((IOSDriver) m.get("driver"+deviceNum));
					Map<String, Object> params = new HashMap<String, Object>();
					params.put("direction", "left");
					RemoteWebElement element = (RemoteWebElement) ((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//XCUIElementTypeStaticText"));
					params.put("element", ((RemoteWebElement) element).getId());
					js.executeScript("mobile: swipe", params);
					TimeUnit.SECONDS.sleep(2);
					if(((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//XCUIElementTypeStaticText")).getText().contains("Pack your suitcases and take your phone")) {
						Reporter.addStepLog("Found Text: "+((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//XCUIElementTypeStaticText")).getText());
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
	
	@Then("^\"(.*)\" I tap on GetStarted button$")
	public void clickgetStartedButton(String deviceNum) throws Throwable {
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("Android")) {
			driverValText = "driver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("button")).click();
			} catch(Exception e) {
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		} else {
			driverValText = "idriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				((IOSDriver) m.get("driver"+deviceNum)).findElement(By.name("GET STARTED")).click();
			} catch(Exception e) {
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((IOSDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		}
	}
	
	@Then("^\"(.*)\" I tap on BigTick button$")
	public void clicktickButton(String deviceNum) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("fab")).click();
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}
	
	@Then("^\"(.*)\" I tap on Next button$")
	public void clickNextButton(String deviceNum) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("btn_confirm")).click();
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}
	
	@Then("^\"(.*)\" I tap on ConFirm button$")
	public void clickconfirmButton(String deviceNum) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("btn_confirm")).click();
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}
	
	//ContinueActivation
	@Then("^\"(.*)\" I tap on ContinueActivation button$")
	public void clickcntdActivateButton(String deviceNum) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("activate_button")).click();
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}
	
	@Then("^\"(.*)\" I tap on signIn button$")
	public void clickSignInButton(String deviceNum) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("signin_button")).click();
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}
	
	@Then("^\"(.*)\" I tap on permission allow button \"(.*)\" time/s$")
	public void clickpermAllowButton(String deviceNum, int cnt) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			int i=0;
			while(i<cnt) {
				((AndroidDriver) m.get("driver"+deviceNum)).findElement(MobileBy.id("com.android.packageinstaller:id/permission_allow_button")).click();
				 //(((AndroidDriver)) m.get("driver"+deviceNum)).findElement(MobileBy.xpath("//*[@class='android.widget.TextView'][2]")).click();
				TimeUnit.SECONDS.sleep(2);
				i++;
			}
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}

	@Then("^\"(.*)\" I seect 3Dots for gift offer \"(.*)\" text$")
	public void clickGiftopts(String deviceNum, String optsName) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
				((AndroidDriver) m.get("driver"+deviceNum)).findElement(MobileBy.xpath("//android.widget.FrameLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[@text=\""+optsName+"\"]"));
				((AndroidDriver) m.get("driver"+deviceNum)).findElement(MobileBy.xpath("//android.widget.FrameLayout[3]/android.widget.ImageView")).click();
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}

	@Then("^\"(.*)\" I tap on signUp button$")
	public void clickSignUpButton(String deviceNum) throws Throwable {
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("Android")) {
			driverValText = "driver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				TimeUnit.SECONDS.sleep(2);
				((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("signup_button")).click();
			} catch(Exception e) {
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		} else {
			driverValText = "idriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				TimeUnit.SECONDS.sleep(2);
				((IOSDriver) m.get("driver"+deviceNum)).findElement(By.name("signup")).click();
			} catch(Exception e) {
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((IOSDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		}
	}
	
	@Then("^\"(.*)\" I tap on \"(.*)\" option$")
	public void selectOption(String deviceNum,String opVal) throws Throwable {
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("Android")) {
			driverValText = "driver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			//No code for android as of now
		} else {
			driverValText = "idriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				if (opVal.equals("VOUCHER")) {
					((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//XCUIElementTypeStaticText[@value=\"VOUCHER / CREDIT CARD\"]")).click();
				} else {
					System.out.println("Option not supported!");
				}
			} catch(Exception e) {
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((IOSDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		}
	}
	
	@Then("^\"(.*)\" I tap on VoucherArrow button$")
	public void clickVoucherArrowButton(String deviceNum) throws Throwable {
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("Android")) {
			driverValText = "driver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			//No code for android as of now
		} else {
			driverValText = "idriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("(//XCUIElementTypeButton[@name=\"arrowButton\"])[1]")).click();
			} catch(Exception e) {
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((IOSDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		}
	}
	
	@Then("^\"(.*)\" I wait for \"(.*)\" seconds$")
	public void universalWait(String deviceNum, int timeVal) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			TimeUnit.SECONDS.sleep(timeVal);
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}
	
	
	@Then("^\"(.*)\" I tap on \"(.*)\" text$")
	public void selectText(String deviceNum, String opText) throws Throwable {
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("Android")) {
			driverValText = "driver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				if (opText.equals("ServerURL")) {
					((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView[2]")).click();
				} else if (opText.equals("Custom")) {
					WebElement el = ((AndroidDriver) m.get("driver"+deviceNum)).findElement(MobileBy.xpath("//android.widget.CheckedTextView[contains(@text, '"+opText+"')]"));
					el.click();
				} else {
					WebElement el = ((AndroidDriver) m.get("driver"+deviceNum)).findElement(MobileBy.xpath("//android.widget.TextView[contains(@text, '"+opText+"')]"));
					el.click();
				}			
			} catch(Exception e) {
				System.out.println(e.getMessage());
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		} else {
			driverValText = "idriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				((IOSDriver) m.get("driver"+deviceNum)).findElement(By.name(opText)).click();;
			} catch(Exception e) {
				System.out.println(e.getMessage());
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((IOSDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		}
	}
	
	
	@Then("^\"(.*)\" I enter the \"(.*)\"$")
	public void enterText(String deviceNum, String opType) throws Throwable {
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("Android")) {
			driverValText = "driver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				try {
					((AndroidDriver) m.get("driver"+deviceNum)).hideKeyboard();
				} catch (Exception e) {}
				if (opType.equals("phoneLoginNumber")) {
					//(((AndroidDriver)) m.get("driver"+deviceNum)).findElement(By.id("phone_number")).clear();
					Reporter.addStepLog("Text Entered: "+cfg.getCfg("loginMobileNumber"));
					((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("phone_number")).sendKeys(cfg.getCfg("loginMobileNumber"));
					//(((AndroidDriver)) m.get("driver"+deviceNum)).getKeyboard().sendKeys(cfg.getCfg("loginMobileNumber"));
					//(((AndroidDriver)) m.get("driver"+deviceNum)).hideKeyboard();
				} else if (opType.equals("phoneSignUpNumber")) {
					Reporter.addStepLog("Text Entered: "+cfg.getCfg("phoneSignUpNumber"));
					((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("et_phone_number")).sendKeys(cfg.getCfg("phoneSignUpNumber"));
				} else if (opType.equals("validationCode")) {
					Reporter.addStepLog("Text Entered: "+cfg.getCfg("validationCode"));
					((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("pin_edit")).sendKeys(cfg.getCfg("validationCode"));
				} else if (opType.equals("userName")) {
					Reporter.addStepLog("Text Entered: "+cfg.getCfg("userName"));
					((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("et_name")).sendKeys(cfg.getCfg("userName"));
				} else if (opType.equals("userPassword")) {
					Reporter.addStepLog("Text Entered: "+cfg.getCfg("userPassword"));
					((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("et_password")).sendKeys(cfg.getCfg("userPassword"));
					((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("et_password_confirm")).sendKeys(cfg.getCfg("userPassword"));
				} else if (opType.equals("voucherNumber")) {
					Reporter.addStepLog("Text Entered: "+cfg.getCfg("voucherNumber"));
					((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("et_voucher_number")).sendKeys(cfg.getCfg("voucherNumber"));
				} else if (opType.equals("creditCardNumber")) {
					Reporter.addStepLog("Text Entered: "+cfg.getCfg("creditCardNumber"));
					((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("et_card_number")).sendKeys(cfg.getCfg("creditCardNumber"));
				} else if (opType.equals("creditCardExpMM")) {
					Reporter.addStepLog("Text Entered: "+cfg.getCfg("creditCardExpMM"));
					((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("et_month")).sendKeys(cfg.getCfg("creditCardExpMM"));
				} else if (opType.equals("creditCardExpYY")) {
					Reporter.addStepLog("Text Entered: "+cfg.getCfg("creditCardExpYY"));
					((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("et_year")).sendKeys(cfg.getCfg("creditCardExpYY"));
				} else if (opType.equals("creditCardCVV")) {
					Reporter.addStepLog("Text Entered: "+cfg.getCfg("creditCardCVV"));
					((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("et_cvv")).sendKeys(cfg.getCfg("creditCardCVV"));
				} else if (opType.equals("setServerURL")) {
					Reporter.addStepLog("Text Entered: "+cfg.getCfg("setServerURL"));
					((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("title_template")).clear();
					((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("title_template")).sendKeys(cfg.getCfg("setServerURL"));
				} else {
					assert false: "Code not added for" + opType;
				}
				try {
					((AndroidDriver) m.get("driver"+deviceNum)).hideKeyboard();
				} catch (Exception e) {}
			} catch(Exception e1) {
				Reporter.addStepLog(e1.getMessage().toString());
				cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		} else {
			driverValText = "idriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				if (opType.equals("userName")) {
					Reporter.addStepLog("Text Entered: "+cfg.getCfg("userName"));
					((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//XCUIElementTypeTextField[@name=\"name\"]")).sendKeys(cfg.getCfg("userName"));
					((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//XCUIElementTypeTextField[@name=\"name\"]")).sendKeys(Keys.RETURN);
				} else if (opType.equals("userPassword")) {
					Reporter.addStepLog("Text Entered: "+cfg.getCfg("userPassword"));
					((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//XCUIElementTypeSecureTextField[@name=\"password\"]")).sendKeys(cfg.getCfg("userPassword"));
					((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//XCUIElementTypeSecureTextField[@name=\"reenterPass\"]")).sendKeys(cfg.getCfg("userPassword"));
					((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//XCUIElementTypeSecureTextField[@name=\"reenterPass\"]")).sendKeys(Keys.RETURN);
				} else if (opType.equals("iOSphoneSignUpNumber")) {
					Reporter.addStepLog("Text Entered: "+cfg.getCfg("iOSphoneSignUpNumber"));
					((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//XCUIElementTypeTextField[@name=\"phone\"]")).sendKeys(cfg.getCfg("iOSphoneSignUpNumber"));
					((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//XCUIElementTypeTextField[@name=\"phone\"]")).sendKeys(Keys.RETURN);
				} else if (opType.equals("iOSOTP")) {
					((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//XCUIElementTypeOther[@name=\"code\"]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText")).sendKeys("0");
					((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//XCUIElementTypeOther[@name=\"code\"]/XCUIElementTypeOther[2]/XCUIElementTypeStaticText")).sendKeys("0");
					((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//XCUIElementTypeOther[@name=\"code\"]/XCUIElementTypeOther[3]/XCUIElementTypeStaticText")).sendKeys("0");
					((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//XCUIElementTypeOther[@name=\"code\"]/XCUIElementTypeOther[4]/XCUIElementTypeStaticText")).sendKeys("0");
					((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//XCUIElementTypeOther[@name=\"code\"]/XCUIElementTypeOther[5]/XCUIElementTypeStaticText")).sendKeys("0");
					((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//XCUIElementTypeOther[@name=\"code\"]/XCUIElementTypeOther[5]/XCUIElementTypeStaticText")).sendKeys(Keys.RETURN);
				} else if (opType.equals("voucherNumber")) {
					Reporter.addStepLog("Text Entered: "+cfg.getCfg("voucherNumber"));
					((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//XCUIElementTypeTextField[@name=\"number\"]")).sendKeys(cfg.getCfg("voucherNumber"));
				} else if (opType.equals("iOSloginMobileNumber")) {
					Reporter.addStepLog("Text Entered: "+cfg.getCfg("iOSloginMobileNumber"));
					((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//XCUIElementTypeTextField[@name=\"phone\"]")).sendKeys(cfg.getCfg("iOSloginMobileNumber"));
				} else if (opType.equals("creditCardNumber")) {
					Reporter.addStepLog("Text Entered: "+cfg.getCfg("creditCardNumber"));
					((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//XCUIElementTypeTextField[@name=\"number\"]")).sendKeys(cfg.getCfg("creditCardNumber"));
					//((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//XCUIElementTypeTextField[@name=\"number\"]")).sendKeys(Keys.TAB);
				} else if (opType.equals("creditCardExpMM")) {
					Reporter.addStepLog("Text Entered: "+cfg.getCfg("creditCardExpMM"));
					((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//XCUIElementTypeTextField[@value=\"MM\"]")).sendKeys(cfg.getCfg("creditCardExpMM"));
					//((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//XCUIElementTypeTextField[@value=\"MM\"]")).sendKeys(Keys.RETURN);
				} else if (opType.equals("creditCardExpYY")) {
					Reporter.addStepLog("Text Entered: "+cfg.getCfg("creditCardExpYY"));
					((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//XCUIElementTypeTextField[@value=\"YY\"]")).sendKeys(cfg.getCfg("creditCardExpYY"));
					//((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//XCUIElementTypeTextField[@value=\"YY\"]")).sendKeys(Keys.RETURN);
				} else if (opType.equals("creditCardCVV")) {
					Reporter.addStepLog("Text Entered: "+cfg.getCfg("creditCardCVV"));
					((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//XCUIElementTypeTextField[@value=\"CVV\"]")).sendKeys(cfg.getCfg("creditCardCVV"));
					//((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//XCUIElementTypeTextField[@value=\"CVV\"]")).sendKeys(Keys.RETURN);
				//XCUIElementTypeTextField[@name="phone"]
				} else if (opType.equals("addAmount")) {
					Reporter.addStepLog("Text Entered: 50");
					((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//XCUIElementTypePickerWheel")).sendKeys("50");
					//((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//XCUIElementTypeTextField[@value=\"YY\"]")).sendKeys(Keys.RETURN);
				}
			} catch(Exception e1) {
				System.out.println(e1.getMessage().toString());
				Reporter.addStepLog(e1.getMessage().toString());
				cfg.takeScreenShot(((IOSDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}	
		}
	}
	
	@Then("^\"(.*)\" I tap on login button$")
	public void clickPhoneLoginButton(String deviceNum) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("phone_button")).click();
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}
	
	@Then("^\"(.*)\" I tap on TopUp button$")
	public void clicktopupButton(String deviceNum) throws Throwable {
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("Android")) {
			driverValText = "driver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("btn_top_up")).click();
			} catch(Exception e) {
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		} else {
			driverValText = "idriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//XCUIElementTypeButton[@name=\"topup\"")).click();
			} catch(Exception e) {
				System.out.println(e.getMessage());
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((IOSDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		}
	}
	
	@Then("^\"(.*)\" I tap on SaveTopUp button$")
	public void clickTopupSavebutton(String deviceNum) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("btn_save")).click();
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}
	@Then("^\"(.*)\" I tap on CreditTopUp button$")
	public void clickCredittopupButton(String deviceNum) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("credit_top_up")).click();
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}
	
	@Then("^\"(.*)\" I tap on CreditArrow1 button$")
	public void clickCreditArrowbutton(String deviceNum) throws Throwable {
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("Android")) {
			driverValText = "driver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			//No code for android
		} else {
			driverValText = "idriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("(//XCUIElementTypeButton[@name=\"arrowButton\"])[1]")).click();
			} catch(Exception e) {
				System.out.println(e.getMessage().toString());
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((IOSDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		}
	}
	
	@Then("^\"(.*)\" I tap on CreditArrow2 button$")
	public void clickCreditArrow2button(String deviceNum) throws Throwable {
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("Android")) {
			driverValText = "driver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			//No code for android
		} else {
			driverValText = "idriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("(//XCUIElementTypeButton[@name=\"arrowButton\"])[2]")).click();
			} catch(Exception e) {
				System.out.println(e.getMessage().toString());
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((IOSDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		}
	}
	
	@Then("^\"(.*)\" I tap on VoucherTopUp button$")
	public void clickVouchertopupButton(String deviceNum) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("btn_voucher_top_up")).click();
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}
	
	@Then("^\"(.*)\" I tap on GoToMyPage button$")
	public void clickGoToMypageButton(String deviceNum) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("btn_go")).click();
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}
	
	@Then("^\"(.*)\" I tap on PayAndActivate button$")
	public void clickpayActivateButton(String deviceNum) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("btn_top_up")).click();
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}
	
	@Then("^\"(.*)\" I tap on LOGOUT button$")
	public void clickappLogoutButton(String deviceNum) throws Throwable {
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("Android")) {
			driverValText = "driver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//android.widget.Button[contains(@text, 'LOGOUT')]")).click();
			} catch(Exception e) {
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		} else {
			driverValText = "idriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//XCUIElementTypeStaticText[@value=\"LOGOUT\"]")).click();
			} catch(Exception e) {
				System.out.println(e.getMessage().toString());
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((IOSDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		}
	}
	
	@Then("^\"(.*)\" I tap on ReprovisionUser button$")
	public void clickreproUserButton(String deviceNum) throws Throwable {
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("Android")) {
			driverValText = "driver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			//No code for Android
		} else {
			driverValText = "idriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				((IOSDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//XCUIElementTypeStaticText[@value=\"REPROVISION USER\"]")).click();
			} catch(Exception e) {
				System.out.println(e.getMessage().toString());
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((IOSDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		}
	}

	@Then("^\"(.*)\" I tap on signUpYes button$")
	public void clickSignUpYesButton(String deviceNum) throws Throwable {
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("Android")) {
			driverValText = "driver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//android.widget.Button[contains(@text, 'Yes')]")).click();
		} else {
			driverValText = "idriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				//No Code for IOS
			} catch(Exception e) {
				System.out.println(e.getMessage().toString());
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((IOSDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		}
	}

	@Then("^\"(.*)\" I tap on signUpNo button$")
	public void clickSignUpNoButton(String deviceNum) throws Throwable {
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("Android")) {
			driverValText = "driver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//android.widget.Button[contains(@text, 'No')]")).click();
		} else {
			driverValText = "idriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				//No Code for IOS
			} catch(Exception e) {
				System.out.println(e.getMessage().toString());
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((IOSDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		}
	}

	@Then("^\"(.*)\" I tap on tellUsMore button$")
	public void clicktellUsMoreButton(String deviceNum) throws Throwable {
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("Android")) {
			driverValText = "driver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//android.widget.Button[contains(@text, 'TELL US MORE ABOUT YOU')]")).click();
		} else {
			driverValText = "idriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				//No Code for IOS
			} catch(Exception e) {
				System.out.println(e.getMessage().toString());
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((IOSDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		}
	}
	
	@Then("^\"(.*)\" I tap on addOffer button$")
	public void clickAddThisOfferButton(String deviceNum) throws Throwable {
		String driverValText = null;
		if (cfg.getCfg(deviceNum+"deviceType").equals("Android")) {
			driverValText = "driver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//android.widget.Button[contains(@text, 'ADD THIS OFFER')]")).click();
		} else {
			driverValText = "idriver"+deviceNum.toString();
			Field m = getDriverFields(driverValText);
			try {
				//No Code for IOS
			} catch(Exception e) {
				System.out.println(e.getMessage().toString());
				Reporter.addStepLog(e.getMessage().toString());
				cfg.takeScreenShot(((IOSDriver) m.get("driver"+deviceNum)));
				fail("Failed:");
			}
		}
	}

	@Then("^\"(.*)\" I tap on OK button$")
	public void clickappOkButton(String deviceNum) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//android.widget.Button[contains(@text, 'OK')]")).click();
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}
	
	@Then("^\"(.*)\" I tap on CANCEL button$")
	public void clickappCancelButton(String deviceNum) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//android.widget.Button[contains(@text, 'Cancel')]")).click();
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}
	
	@Then("^\"(.*)\" I tap on reProvision checkBox$")
	public void clickreprovisionCheckbox(String deviceNum) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//android.widget.CheckBox[contains(@text, 'Also apply user reprovision?')]")).click();
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}
	
	@Then("^\"(.*)\" I Navigate back$")
	public void drivernavback(String deviceNum) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			((AndroidDriver) m.get("driver")).navigate().back();
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}
}