package com.cybertek.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SmartBearUtils {
    public static void loginToSmartBear(WebDriver driver) {
        WebElement userName = driver.findElement(By.name("ctl00$MainContent$username"));
        WebElement password = driver.findElement(By.name("ctl00$MainContent$password"));
        WebElement loginBtn = driver.findElement(By.name("ctl00$MainContent$login_button"));

        userName.sendKeys("Tester");
        password.sendKeys("test");
        loginBtn.click();

        Assert.assertEquals(driver.getTitle() , "Web Orders", "Failed to login to smartbear app");
    }

   // public static void addProduct(WebDriver driver){
        /**
         * TODO: add selenium steps adding item to an order
         */
        public static List getAllLinks(WebDriver driver){
            List<WebElement> links = driver.findElements(By.tagName("a"));
            return links;
        }



    }

