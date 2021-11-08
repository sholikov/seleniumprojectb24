package com.cybertek.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) throws Throwable{

        // 1= set up the webdriver
        WebDriverManager.chromedriver().setup();

        //2 -  create the instance/object of the chrome driver
        WebDriver driver = new ChromeDriver();

        //3 - test if driver is working
        String url = "http://google.com";
        String url2  = "http://apple.com";
        driver.get(url);

        //will put on hold current run on 3 seconds
        Thread.sleep(3000);

        // navigate to apple.com
        driver.navigate().to(url2);


        // will close web browser
        driver.close();

    }
}
