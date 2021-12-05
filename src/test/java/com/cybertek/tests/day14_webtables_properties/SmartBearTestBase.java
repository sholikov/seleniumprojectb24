package com.cybertek.tests.day14_webtables_properties;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * parent set up class
 */
public class SmartBearTestBase {

    String url = "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx";
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @AfterMethod
    public void tearDown(){
   //     driver.quit();
    }

}
