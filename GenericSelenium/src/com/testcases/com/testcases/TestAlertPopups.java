package com.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import com.util.Util4jLogs;
import com.util.test_bed;

///https://stackoverflow.com/questions/30435688/getting-java-lang-noclassdeffounderror-com-beust-jcommander-parameterexception
//You can download this jar file on central.maven.org -> jcommander-1.48.jar

public class TestAlertPopups extends test_bed {



	@Test
	public void HandleAlerts() throws InterruptedException {
		final String url = "http://demo.guru99.com/test/delete_customer.php";
		Log4j.LogInfo("Opening ::" + url);

		Log4j.LogInfo("Enetring value ::53920");
		driver.get(url);
		driver.findElement(By.name("cusid")).sendKeys(new CharSequence[] { "53920" });
		driver.findElement(By.name("submit")).submit();
		System.out.println("Success");
		Log4j.LogInfo("Enetring value ::Success");
		final Alert alert = driver.switchTo().alert();
		final String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		Thread.sleep(5000L);
		alert.accept();
	}
}
