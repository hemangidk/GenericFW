package com.util;

import java.io.IOException;

import org.apache.log4j.Logger;
 import org.apache.log4j.PropertyConfigurator;
//Reference DOC: http://blogs.quovantis.com/how-to-use-log4j-with-selenium-web-driver/

public class Util4jLogs
{
    static String log4jConfPath;
  
   
    static {
    	 String current = null;
		try {
			current = new java.io.File( "." ).getCanonicalPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Util4jLogs.log4jConfPath = current+"\\config\\log4j.properties";
    }
    
    public void LogRootInfo(final String msg) {
        PropertyConfigurator.configure(Util4jLogs.log4jConfPath);
        final Logger log = Logger.getLogger("rootLogger");
        log.info((Object)msg);
    }
    
    public void LogInfo(final String msg) {
        PropertyConfigurator.configure(Util4jLogs.log4jConfPath);
        final Logger log = Logger.getLogger("devpinoyLogger");
        log.info((Object)msg);
    }
    
    public void LogDebug(final String msg) {
        PropertyConfigurator.configure(Util4jLogs.log4jConfPath);
        final Logger log = Logger.getLogger("devpinoyLogger");
        log.debug((Object)msg);
    }
}

