package com.cybertek.tests.day14_webtables_properties;

import com.cybertek.utils.SmartBearUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

/**
 * we are inheriting Parent class
 */
public class SmartBearProductTest extends SmartBearTestBase{
/*
Print out count of all the links on landing page
 Print out each link text on this page
 */
    @Test
    public void verifyLinksAfterLogin(){
        //perform login steps
        SmartBearUtils.loginToSmartBear(driver);
        List<WebElement> allTheLinks = driver.findElements(By.tagName("a"));
        System.out.println("Total of links  = " + allTheLinks.size());
        for (WebElement eachLink : allTheLinks) {
            System.out.println(eachLink.getText()+"-" +eachLink.getAttribute("href"));
        }

    }





}
