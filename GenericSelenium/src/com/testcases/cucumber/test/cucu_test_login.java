package cucumber.test;


import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import cucumber.api.CucumberOptions;

import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
 
@CucumberOptions(
		features="src//com//testcases//cucumber.features",
//				features="D:/02_hemangi/java/GenericFW/GenericSelenium/src/com/testcases/cucumber/features",
		//features="testcases/cucumber/features",
		glue={"step_def","cucumber"}
	
		)
public class cucu_test_login  
{
	
	public static WebDriver driver;
	private TestNGCucumberRunner testRunner;

	/////////////////
	@BeforeClass
	public void setUP() throws IOException
	{
		final String ChromeDriver = new java.io.File(".").getCanonicalPath() + "\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", ChromeDriver);
		driver = (WebDriver) new ChromeDriver();
		testRunner = new TestNGCucumberRunner(cucu_test_login.class);
		
	}
	@Test(description="login",dataProvider="features")
	public void login(CucumberFeatureWrapper cFeature)
	{
		testRunner.runCucumber(cFeature.getCucumberFeature());
	}
	@DataProvider(name="features")
	public Object[][] getFeatures()
	{
		return testRunner.provideFeatures();
	}
	@AfterClass
	public void tearDown()
	{
		driver.close();
		testRunner.finish();
	}
	///////////////
	
}