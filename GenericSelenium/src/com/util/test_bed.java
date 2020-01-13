package com.util;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import org.openqa.selenium.WebDriver;

public class test_bed
{
    UtilProperties property;
    Util4jLogs Log4j;
    public WebDriver driver;
    
    public test_bed() {
        this.property = new UtilProperties();
        this.Log4j = new Util4jLogs();
    }
    
    @BeforeTest
    public void Setup() throws IOException {
        final String bt = this.property.getProperty("BrowserType");
        String current = new java.io.File( "." ).getCanonicalPath();
        System.out.println("Current dir:"+current);
        final String url = "http://demo.guru99.com/test/delete_customer.php";
        if (bt.toLowerCase().trim().equalsIgnoreCase("chrome")) {
        	
            final String ChromeDriver = current + "\\drivers\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", ChromeDriver);
            final DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            final ChromeOptions options = new ChromeOptions();
            options.addArguments(new String[] { "--test-type" });
            options.addArguments(new String[] { "--start-maximized" });
            options.addArguments(new String[] { "--disable-web-security" });
            options.merge((Capabilities)capabilities);
            capabilities.setCapability("chrome.binary", current+ "\\drivers\\chromedriver.exe");
            this.driver = (WebDriver)new ChromeDriver(options);
        }
        if (bt.toLowerCase().trim().equalsIgnoreCase("firefox")) {
            final String FFDriver = current + "\\drivers\\geckodriver.exe";
            System.setProperty("webdriver.gecko.driver", FFDriver);
            this.driver = (WebDriver)new FirefoxDriver();
        }
        if (bt.toLowerCase().trim().equalsIgnoreCase("ie")) {
            final String iedriver = current + "\\drivers\\IEDriverServer.exe";
            System.setProperty("webdriver.ie.driver", iedriver);
            final InternetExplorerOptions ieopt = new InternetExplorerOptions();
            final DesiredCapabilities iecap = DesiredCapabilities.internetExplorer();
            ieopt.merge((Capabilities)iecap);
            final WebDriver driver = (WebDriver)new InternetExplorerDriver(ieopt);
            driver.manage().window().maximize();
        }
        this.driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        this.Log4j.LogInfo("Opening ::" + url);
        this.driver.get(url);
    }
    
    @AfterTest
    public void afterMethod() {
        this.driver.quit();
        this.Log4j.LogInfo("Closing all browsers opened by selenium");
    }
}