package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookIncorrectLoginTitleVerification_TC2 {
    /*
    TC #2: Facebook incorrect login title verification
    1. Open Chrome browser
    2. Go to https://www.facebook.com
    3. Enter incorrect username
    4. Enter incorrect password
    5. Verify title changed to:
    Expected: “Log into Facebook”
     */
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = " https://www.facebook.com";
        driver.get(url);

       String email= "alpharameo@gmail.com";
       String pass = "B24Feb2022";


        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("pass")).sendKeys(pass);
        driver.findElement((By.name("login"))).click();

        driver.getCurrentUrl();
        String actTitle = driver.getTitle();
        String expTitle = "Log into Facebook";


        System.out.println(actTitle);

        if (actTitle.equals(expTitle)) {
            System.out.println("Verification passed, title has changed to " + expTitle);
        } else {
            System.out.println("Verification failed, title has not changed to " + expTitle);

        }
    }
}
