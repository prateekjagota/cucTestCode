package StepDefinitions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class appTest {
	WebDriver driver;
	@Given("^I open the Firefox web browser$")
	public void open_browser() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "/Users/Prateek/Desktop/chromedriver");
		driver= new ChromeDriver();					
	       driver.manage().window().maximize();			
	       driver.get("http://demo.guru99.com/v4");	
	}
	@When("^Enter the \"(.*)\" and \"(.*)\"$")
	public void enterPass(String username, String password) throws Throwable {
		driver.findElement(By.name("uid")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);	
		driver.findElement(By.name("btnLogin")).click();
	}
	@Then("^I close the browser$")
	public void close_browser() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "/Users/Prateek/Desktop/chromedriver");
		driver.close();
	}
}