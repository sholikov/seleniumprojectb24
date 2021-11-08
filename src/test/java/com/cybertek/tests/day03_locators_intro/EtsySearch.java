package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EtsySearch {
    public static void main(String []args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url ="https://www.etsy.com/";
        driver.get(url);

        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String beginTitle = "wooden spoon";

        System.out.println(actualTitle.startsWith(beginTitle)? " Passed": "Failed");

        driver.findElement(By.linkText("Holiday Shop")).click();

        String actualHeader = driver.findElement(By.tagName("h1")).getText();
        String expHeader = "Holiday Shop";

        System.out.println(actualHeader.equals(expHeader)? "Passes":"Failed");




    }
}
