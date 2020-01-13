package com.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import com.util.Util4jLogs;
import com.util.test_bed;

///https://stackoverflow.com/questions/30435688/getting-java-lang-noclassdeffounderror-com-beust-jcommander-parameterexception
//You can download this jar file on central.maven.org -> jcommander-1.48.jar


public class TestAlertPopups extends test_bed
{
    Util4jLogs Log4j;
    
    public TestAlertPopups() {
        this.Log4j = new Util4jLogs();
    }
    
    @Test
    public void HandleAlerts() throws InterruptedException {
        this.Log4j.LogInfo("Enetring value ::53920");
        this.driver.findElement(By.name("cusid")).sendKeys(new CharSequence[] { "53920" });
        this.driver.findElement(By.name("submit")).submit();
        System.out.println("Success");
        this.Log4j.LogInfo("Enetring value ::Success");
        final Alert alert = this.driver.switchTo().alert();
        final String alertMessage = this.driver.switchTo().alert().getText();
        System.out.println(alertMessage);
        Thread.sleep(5000L);
        alert.accept();
    }
}

