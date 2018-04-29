package StepDefinitions;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import static org.junit.Assert.fail;
import io.appium.java_client.android.AndroidDriver;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
	@Given("^\"(.*)\" I install and launch the application$")
	public void installLaunch(String deviceNum) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			cfg.installApp(deviceNum,1);
			cfg.launchApp(deviceNum);
	 	} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}
	
	@Given("^\"(.*)\" I launch the application$")
	public void launchAppTest(String deviceNum) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			cfg.installApp(deviceNum,0);
			cfg.launchApp(deviceNum);
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}
	
	@Then("^\"(.*)\" I tap on agreement checkBox$")
	public void clickCheckBox(String deviceNum) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("terms_checkbox")).click();
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
		
	}
	
	@Then("^\"(.*)\" I tap on agree continue button$")
	public void clickAgreeButton(String deviceNum) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("terms_button")).click();
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}
	
	@Then("^\"(.*)\" I swipe the Screens$")
	public void swipScreen(String deviceNum) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			int i=0;
			TimeUnit.SECONDS.sleep(2);
			while(i<30) {
				TouchAction touchAction = new TouchAction(((AndroidDriver) m.get("driver"+deviceNum)));
				touchAction.press(800, 200).moveTo(-500, 0).release().perform();
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
	}
	
	@Then("^\"(.*)\" I tap on GetStarted button$")
	public void clickgetStartedButton(String deviceNum) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("button")).click();
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
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
	@Then("^\"(.*)\" I tap on signUp button$")
	public void clickSignUpButton(String deviceNum) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
		try {
			TimeUnit.SECONDS.sleep(2);
			((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("signup_button")).click();
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
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
		Field m = getDriverFields("driver"+deviceNum);
		try {
			WebElement el = ((AndroidDriver) m.get("driver"+deviceNum)).findElement(MobileBy.xpath("//android.widget.TextView[contains(@text, '"+opText+"')]"));
			el.click();
		} catch(Exception e) {
			System.out.println(e.getMessage());
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
		}
	}
	
	
	@Then("^\"(.*)\" I enter the \"(.*)\"$")
	public void enterText(String deviceNum, String opType) throws Throwable {
		Field m = getDriverFields("driver"+deviceNum);
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
		Field m = getDriverFields("driver"+deviceNum);
		try {
			((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.id("btn_top_up")).click();
		} catch(Exception e) {
			Reporter.addStepLog(e.getMessage().toString());
			cfg.takeScreenShot(((AndroidDriver) m.get("driver"+deviceNum)));
			fail("Failed:");
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
		Field m = getDriverFields("driver"+deviceNum);
		try {
			((AndroidDriver) m.get("driver"+deviceNum)).findElement(By.xpath("//android.widget.Button[contains(@text, 'LOGOUT')]")).click();
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