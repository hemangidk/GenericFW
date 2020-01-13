package com.testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

public class log4j2
{
    private static WebDriver driver;
    
    public static void main(final String[] args) {
        final String log4jConfPath = "D:\\02_hemangi\\java\\GenericSelenium\\config\\log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
        final Logger log = Logger.getLogger("devpinoyLogger");
        log.debug((Object)"Getting errors");
    }
}