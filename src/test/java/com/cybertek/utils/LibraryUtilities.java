package com.cybertek.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class LibraryUtilities {

    public static void loginToLibrary(WebDriver driver) {
        driver.get(ConfigurationReader.getProperty("library.url"));

        WebElement emailInput = driver.findElement(By.id("inputEmail"));
        WebElement passInput = driver.findElement(By.id("inputPassword"));


        emailInput.sendKeys(ConfigurationReader.getProperty("library.username"));
        passInput.sendKeys(ConfigurationReader.getProperty("library.pwd"));
        driver.findElement(By.xpath("//button[.='Sign in']")).click();

        Assert.assertEquals(driver.getTitle(), "Login - Library", "Failed to login to Library app");


    }
    public static List<WebElement> getAllLinks(WebDriver driver){
        List<WebElement> links = driver.findElements(By.tagName("a"));
        return links;
    }

}
