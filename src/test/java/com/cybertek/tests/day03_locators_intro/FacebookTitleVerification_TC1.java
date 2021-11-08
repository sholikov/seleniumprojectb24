package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookTitleVerification_TC1 {
    /*
    TC #1: Facebook title verification
    1. Open Chrome browser
    2. Go to https://www.facebook.com
    3. Verify title:
    Expected: “Facebook - Log In or Sign Up”
     */
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://www.facebook.com";
        driver.get(url);

        String expTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expTitle)){
            System.out.println("Title verification is matched");
        }
        else{
            System.out.println("Title verification is mismatched");
        }
        driver.quit();

    }
}
