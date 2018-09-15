package TestRunner;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"Features"},
							tags= {"@TC1001,@TC1002,@TC1003,@TC1004,@TC1005"},
							plugin = {"com.cucumber.listener.ExtentCucumberFormatter:"},
							glue= {"StepDefinitions"}, monochrome = true, strict = true)

public class RunnerIOS {
	@BeforeClass
	public static void setup() {
	    ExtentProperties extentProperties = ExtentProperties.INSTANCE;
	    String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
	    extentProperties.setReportPath("output/Matrixx_TestExecutionReport_"+timeStamp+".html");	    
	}
	@AfterClass
    public static void teardown() {
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Mac OSX");
        Reporter.setTestRunnerOutput("Report Compiled at: "+timeStamp);
    }
	
}



