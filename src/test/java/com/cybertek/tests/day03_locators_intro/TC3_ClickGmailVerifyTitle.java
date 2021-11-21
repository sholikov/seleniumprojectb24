package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC3_ClickGmailVerifyTitle {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();



        String url = "https://google.com";
        driver.get(url);
         // Find Gmail link and click on it
        driver.findElement(By.linkText("Gmail")).click();
           //element find method// locator and value for how to find the element on the page//click--> action to do after

        //driver.findElement(By.partialLinkText("a")).click();

        String expectedTitle = "Gmail";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)) {
            System.out.println("PASS: Title verification success");
        } else {
            System.out.println("FAIL: Title verification failed");
        }

        // go back
        driver.navigate().back();

        String googleExpectedTitle = "Google";
        String googleActTitle = driver.getTitle();

        if (googleActTitle.contains(googleExpectedTitle)) {
            System.out.println("PASS: Title verification success");
        } else {
            System.out.println("FAIL: Title verification failed");
        }

        driver.close();














    }

}
