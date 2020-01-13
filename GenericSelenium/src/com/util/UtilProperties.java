package com.util;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.Properties;

public class UtilProperties
{
    public Properties LoadProperties(final String fileName) throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fis);
        }
        catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        finally {
            fis.close();
        }
        fis.close();
        return prop;
    }
    
    public String getProperty(final String Key) throws IOException {
        final Properties prop = this.LoadProperties(String.valueOf(new File("./").getAbsolutePath()) + "\\config\\env.properties");
        return prop.getProperty(Key);
    }
    
    public void setProperty(final String Key, final String Value) throws IOException {
        final Properties prop = this.LoadProperties(String.valueOf(new File("./").getAbsolutePath()) + "\\config\\env.properties");
        prop.setProperty(Key, Value);
    }
}