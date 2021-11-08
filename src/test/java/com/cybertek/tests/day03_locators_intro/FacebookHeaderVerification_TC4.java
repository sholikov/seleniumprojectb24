package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookHeaderVerification_TC4 {
    /*
    TC #4: Facebook header verification
    1. Open Chrome browser
    2. Go to https://www.facebook.com
    3. Verify “Create a page” link href value contains text:
    Expected: “registration_form”

     */
    public static void main(String []args){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "https://www.facebook.com";
        driver.get(url);


        String actHREF = driver.findElement(By.className("_8esh")).getAttribute("href");
        System.out.println("actHREF = " + actHREF);
        String expHREF = "registration_form";

        if(actHREF.contains(expHREF)){
            System.out.println("Verification is Passed");
        }else{
            System.out.println("Failed");
        }



    }
}
