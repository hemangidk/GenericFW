package cucumber.step_def;

import cucumber.test.cucu_test_login;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.util.test_bed;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.testng.AbstractTestNGCucumberTests;
 
 
public class cucu_step_def_login 
{
	@Given("^Open Application and Enter url$")
	public void open_Application_and_Enter_url() throws Throwable {
		cucu_test_login.driver.get("https://demo.openmrs.org/openmrs/login.htm");
	  
	}
 
	@When("^enter username$")
	public void enter_username() throws Throwable {
		cucu_test_login.driver.findElement(By.id("username")).sendKeys("Admin");
	}
 
	@When("^enter password$")
	public void enter_password() throws Throwable {
		cucu_test_login.driver.findElement(By.id("password")).sendKeys("Admin123");
		cucu_test_login.driver.findElement(By.id("Inpatient Ward")).click();
		cucu_test_login.driver.findElement(By.id("loginButton")).click();
	}
 
	@Then("^verify Msg$")
	public void verify_Msg() throws Throwable {
	   boolean result =  cucu_test_login.driver.findElement(By.tagName("h4")).getText().contains("Logged");
	   Assert.assertTrue(result);
	}
}