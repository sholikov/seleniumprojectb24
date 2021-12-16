package com.cybertek.tests.day18_actions_pom_intro;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EtsySubscribeTest extends TestBase {
    /*
    add new package day18_actions_pom_intro

add new class EtsySubscribeTest

Goto Etsy homepage
Scroll down
Generate random email and enter into subscribe box
Click on Subscribe
Verify "Great! We've sent you an email to confirm your subscription." is displayed

     */

    @Test
    public void etsySubscribeTest() {


        driver.get(ConfigurationReader.getProperty("etsy.url"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement emailInput = driver.findElement(By.id("email-list-signup-email-input"));
        js.executeScript("arguments[0].scrollIntoView(true)", emailInput);
        BrowserUtils.scrollDown(emailInput);

        // we put faker generator inside our TestBase
        emailInput.sendKeys(faker.internet().emailAddress() + Keys.ENTER);
       // emailInput.submit();

        WebElement message = driver.findElement(By.xpath("//div[@class='wt-alert wt-alert--inline wt-alert--success-01 wt-text-body-01']"));
        System.out.println(message.getText());

        Assert.assertTrue(message.isDisplayed());

        Assert.assertEquals(message.getText(),"Great! We've sent you an email to confirm your subscription.", "Output message does not match");


    }


}
