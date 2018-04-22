package TestRunner;
import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"Features/testNavigation.feature"},tags= {"@TC1,@TC2,@TC3,@TC4,@TC5"},plugin = {"com.cucumber.listener.ExtentCucumberFormatter:output/report.html"},glue= {"StepDefinitions"}, monochrome = true)

public class Runner {
	@AfterClass
    public static void teardown() {
        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Mac OSX");
        Reporter.setTestRunnerOutput("Sample test runner output message");
    }
}