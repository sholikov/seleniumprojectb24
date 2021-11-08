package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookHeaderVerification_TC3 {
    public static void main(String[] args){
        /*
        TC #3: Facebook header verification
        1. Open Chrome browser
        2. Go to https://www.facebook.com
        3. Verify header text is as expected:
        Expected: “Connect with friends and the world around you on Facebook.”

         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url="https://www.facebook.com";
        driver.get(url);

        String actHeader = driver.findElement(By.tagName("h2")).getText();
        String expHeader = "Connect with friends and the world around you on Facebook.";

        if(actHeader.equals(expHeader)){
            System.out.println("Header verification is Passed");
        }else{
            System.out.println("Header verification is Failed");
        }

    }
}
