package StepDefinitions;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import static org.junit.Assert.fail;
import static org.junit.Assume.assumeFalse;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import StepDefinitions.Config;


public class androidTest {
	Config cfg = new Config();
	public static AndroidDriver driver;
	public static final DesiredCapabilities capabilities = new DesiredCapabilities();
	public void installApp(String deviceNum, int deletePrevApp) throws Throwable {
			capabilities.setCapability("platformName", cfg.getCfg(deviceNum+"platformName"));
			capabilities.setCapability("deviceName", cfg.getCfg(deviceNum+"deviceUDID"));
			capabilities.setCapability("app", cfg.getCfg("appPath"));
			capabilities.setCapability(CapabilityType.VERSION, cfg.getCfg(deviceNum+"version"));
			capabilities.setCapability("appPackage", cfg.getCfg("appPackageName"));
			capabilities.setCapability("newCommandTimeout", cfg.getCfg(deviceNum+"newCommandTimeout"));
			capabilities.setCapability("autoGrantPermissions", "true");
			capabilities.setCapability("unicodeKeyboard", true);
			capabilities.setCapability("resetKeyboard", true);
			if (deletePrevApp == 0) {
				capabilities.setCapability("noReset", true);
				capabilities.setCapability("fullReset", false);
			}			
	}
	public void launchApp(String deviceNum) throws Throwable {
		driver = new AndroidDriver(new URL("http://"+cfg.getCfg(deviceNum+"appiumServerAddress")+"/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Given("^\"(.*)\" I install and launch the application$")
	public void installLaunch(String deviceNum) throws Throwable {
		installApp(deviceNum,1);
		launchApp(deviceNum);
	}
	
	@Then("^\"(.*)\" I tap on agreement checkBox$")
	public void clickCheckBox(String deviceNum) throws Throwable {
		driver.findElement(By.id("terms_checkbox")).click();
	}
	
	@Then("^\"(.*)\" I tap on agree continue button$")
	public void clickAgreeButton(String deviceNum) throws Throwable {
		driver.findElement(By.id("terms_button")).click();
	}
	
	@Then("^\"(.*)\" I swipe the Screens$")
	public void swipScreen(String deviceNum) throws Throwable {
		int i=0;
		TimeUnit.SECONDS.sleep(2);
		while(i<30) {
			TouchAction touchAction = new TouchAction(driver);
			touchAction.press(800, 200).moveTo(-500, 0).release().perform();
			TimeUnit.SECONDS.sleep(2);
			if(driver.findElement(By.id("headline")).getText().contains("Pack your suitcases and take your phone")) {
				System.out.println(driver.findElement(By.id("headline")).getText());
				break;
			}
			i++;
		}
	}
	
	@Then("^\"(.*)\" I tap on GetStarted button$")
	public void clickgetStartedButton(String deviceNum) throws Throwable {
		driver.findElement(By.id("button")).click();
	}
	
	@Then("^\"(.*)\" I tap on BigTick button$")
	public void clicktickButton(String deviceNum) throws Throwable {
		driver.findElement(By.id("fab")).click();
	}
	
	@Then("^\"(.*)\" I tap on Next button$")
	public void clickNextButton(String deviceNum) throws Throwable {
		driver.findElement(By.id("btn_confirm")).click();
	}
	
	@Then("^\"(.*)\" I tap on ConFirm button$")
	public void clickconfirmButton(String deviceNum) throws Throwable {
		driver.findElement(By.id("btn_confirm")).click();
	}
	
	//ContinueActivation
	@Then("^\"(.*)\" I tap on ContinueActivation button$")
	public void clickcntdActivateButton(String deviceNum) throws Throwable {
		driver.findElement(By.id("activate_button")).click();
	}
	
	@Then("^\"(.*)\" I tap on signIn button$")
	public void clickSignInButton(String deviceNum) throws Throwable {
		driver.findElement(By.id("signin_button")).click();
	}
	
	@Then("^\"(.*)\" I tap on permission allow button \"(.*)\" time/s$")
	public void clickpermAllowButton(String deviceNum, int cnt) throws Throwable {
		int i=0;
		while(i<cnt) {
			driver.findElement(MobileBy.id("com.android.packageinstaller:id/permission_allow_button")).click();
			 //driver.findElement(MobileBy.xpath("//*[@class='android.widget.TextView'][2]")).click();
			TimeUnit.SECONDS.sleep(2);
			i++;
		}
	}
	@Then("^\"(.*)\" I tap on signUp button$")
	public void clickSignUpButton(String deviceNum) throws Throwable {
		TimeUnit.SECONDS.sleep(2);
		driver.findElement(By.id("signup_button")).click();
	}
	
	@Then("^\"(.*)\" I wait for \"(.*)\" seconds$")
	public void universalWait(String deviceNum, int timeVal) throws Throwable {
		TimeUnit.SECONDS.sleep(timeVal);
	}
	
	
	@Then("^\"(.*)\" I select \"(.*)\" text$")
	public void selectText(String deviceNum, String opText) throws Throwable {
		if (opText.equals("VOUCHER")) {
			WebElement el = driver.findElement(MobileBy.xpath("//android.widget.TextView[contains(@text, '"+opText+"')]"));
			el.click();
		} else {
			assert false: "Code not added for" + opText;
		}
	}
	
	
	@Then("^\"(.*)\" I enter the \"(.*)\"$")
	public void enterText(String deviceNum, String opType) throws Throwable {
		try {
			driver.hideKeyboard();
		} catch (Exception e) {}
		if (opType.equals("phoneLoginNumber")) {
			//driver.findElement(By.id("phone_number")).clear();
			System.out.println(cfg.getCfg("loginMobileNumber"));
			driver.findElement(By.id("phone_number")).sendKeys(cfg.getCfg("loginMobileNumber"));
			//driver.getKeyboard().sendKeys(cfg.getCfg("loginMobileNumber"));
			//driver.hideKeyboard();
		} else if (opType.equals("phoneSignUpNumber")) {
			System.out.println(cfg.getCfg("phoneSignUpNumber"));
			driver.findElement(By.id("et_phone_number")).sendKeys(cfg.getCfg("phoneSignUpNumber"));
		} else if (opType.equals("validationCode")) {
			System.out.println(cfg.getCfg("validationCode"));
			driver.findElement(By.id("pin_edit")).sendKeys(cfg.getCfg("validationCode"));
		} else if (opType.equals("userName")) {
			System.out.println(cfg.getCfg("userName"));
			driver.findElement(By.id("et_name")).sendKeys(cfg.getCfg("userName"));
		} else if (opType.equals("userPassword")) {
			System.out.println(cfg.getCfg("userPassword"));
			driver.findElement(By.id("et_password")).sendKeys(cfg.getCfg("userPassword"));
			driver.findElement(By.id("et_password_confirm")).sendKeys(cfg.getCfg("userPassword"));
		} else if (opType.equals("voucherNumber")) {
			System.out.println(cfg.getCfg("voucherNumber"));
			driver.findElement(By.id("et_voucher_number")).sendKeys(cfg.getCfg("voucherNumber"));
		} else {
			assert false: "Code not added for" + opType;
		}
		try {
			driver.hideKeyboard();
		} catch (Exception e) {}
	}
	
	@Then("^\"(.*)\" I tap on login button$")
	public void clickPhoneLoginButton(String deviceNum) throws Throwable {
		driver.findElement(By.id("phone_button")).click();
	}
	
	@Then("^\"(.*)\" I tap on TopUp button$")
	public void clicktopupButton(String deviceNum) throws Throwable {
		driver.findElement(By.id("btn_top_up")).click();
	}
	
	@Then("^\"(.*)\" I tap on VoucherTopUp button$")
	public void clickVouchertopupButton(String deviceNum) throws Throwable {
		driver.findElement(By.id("btn_voucher_top_up")).click();
	}
	
	@Then("^\"(.*)\" I tap on GoToMyPage button$")
	public void clickGoToMypageButton(String deviceNum) throws Throwable {
		driver.findElement(By.id("btn_go")).click();
	}
	
	@Then("^\"(.*)\" I tap on PayAndActivate button$")
	public void clickpayActivateButton(String deviceNum) throws Throwable {
		driver.findElement(By.id("btn_top_up")).click();
	}
	
	@Then("^\"(.*)\" I tap on LeftMenu button$")
	public void clickLeftMenuButton(String deviceNum) throws Throwable {
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();
	}
	
	@Then("^\"(.*)\" I tap on \"(.*)\" menuItem$")
	public void selectMenuItem(String deviceNum, String opText) throws Throwable {
			WebElement el = driver.findElement(MobileBy.xpath("//android.widget.CheckedTextView[contains(@text, '"+opText+"')]"));
			el.click();
	}
	
	@Then("^\"(.*)\" I tap on LOGOUT button$")
	public void clickappLogoutButton(String deviceNum) throws Throwable {
		driver.findElement(By.xpath("//android.widget.Button[contains(@text, 'LOGOUT')]")).click();
	}
	
	@Then("^\"(.*)\" I tap on reProvision checkBox$")
	public void clickreprovisionCheckbox(String deviceNum) throws Throwable {
		driver.findElement(By.xpath("//android.widget.CheckBox[contains(@text, 'Also apply user reprovision?')]")).click();
	}
}