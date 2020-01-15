package app_tc;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.util.test_bed;

public class TestNG_Priority_Annotations extends test_bed{

    @Test(priority=6)
    public void c_method(){
    System.out.println("I'm in method C");
    Reporter.log("********** c_method  **");
    }
    @Test(priority=9)
    public void b_method(){
    System.out.println("I'm in method B");
    Reporter.log("********** b_method  **");
    }
    @Test(priority=1)
    public void a_method(){
    System.out.println("I'm in method A");
    }
    @Test(priority=0)
    public void e_method(){
    System.out.println("I'm in method E");
    }
    @Test(priority=3)
    public void d_method(){
    System.out.println("I'm in method D");
    }

}