package Utils;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class driver implements webDriver {

    public static  WebDriver  wd;

    @Before
    public void setup(){

      WebDriver wd =  new ChromeDriver();

    }
    @After
    public void teardown(){

    }
}
