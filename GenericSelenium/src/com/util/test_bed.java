package com.util;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import org.openqa.selenium.WebDriver;

@Listeners({com.util.ListenerTest.class, com.util.ReportListener.class})		


public class test_bed {
	public static UtilProperties property = new UtilProperties();
	public static Util4jLogs Log4j = new Util4jLogs();
	public static WebDriver driver;
	
		


	@BeforeTest
	public void Setup() throws IOException {
		final String bt = property.getProperty("BrowserType");
		String current = new java.io.File(".").getCanonicalPath();
		System.out.println("Current dir:" + current);

		if (bt.toLowerCase().trim().equalsIgnoreCase("chrome")) {

			final String ChromeDriver = current + "\\drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", ChromeDriver);
			final DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setCapability("chrome.binary", current + "\\drivers\\chromedriver.exe");
			
			final ChromeOptions options = new ChromeOptions();
			options.addArguments(new String[] { "--test-type" });
			options.addArguments(new String[] { "--start-maximized" });
			options.addArguments(new String[] { "--disable-web-security" });
			options.merge((Capabilities) capabilities);
			
			
			
		
			driver = (WebDriver) new ChromeDriver(options);
		}
		if (bt.toLowerCase().trim().equalsIgnoreCase("firefox")) {
			final String FFDriver = current + "\\drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", FFDriver);
			driver = (WebDriver) new FirefoxDriver();
		}
		if (bt.toLowerCase().trim().equalsIgnoreCase("ie")) {
			final String iedriver = current + "\\drivers\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", iedriver);
			final InternetExplorerOptions ieopt = new InternetExplorerOptions();
			final DesiredCapabilities iecap = DesiredCapabilities.internetExplorer();
			ieopt.merge((Capabilities) iecap);
			final WebDriver driver = (WebDriver) new InternetExplorerDriver(ieopt);
			driver.manage().window().maximize();
		}
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);

	}

	@AfterTest
	public void afterMethod() {
		driver.quit();
		Log4j.LogInfo("Closing all browsers opened by selenium");
	}
}