package testng;

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.firefox.FirefoxDriver;		
import org.testng.Assert;		
import org.testng.annotations.Listeners;		
import org.testng.annotations.Test;

import com.util.test_bed;             		

@Listeners(com.util.ListenerTest.class)			

public class ListenerDemo extends test_bed{				


//Test to pass as to verify listeners.		
@Test		
public void Login()				
{		
	Assert.assertTrue(true);					
}		

//Forcefully failed this test as verify listener.		
@Test		
public void TestToFail()				
{		
    System.out.println("This method to test fail");					
    Assert.assertTrue(false);			
}		
}
