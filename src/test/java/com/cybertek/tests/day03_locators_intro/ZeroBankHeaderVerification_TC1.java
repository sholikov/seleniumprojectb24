package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeroBankHeaderVerification_TC1 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        String url = "http://zero.webappsecurity.com/login.html";
        driver.get(url);

        String actHeader = driver.findElement(By.tagName("h3")).getText();
        String expHeader = "Log in to ZeroBank";

        System.out.println(actHeader);

        if(actHeader.equals(expHeader)){
            System.out.println("Passed, header matched.");
        }
        else{
            System.out.println("Failed,");
        }

    }
}
