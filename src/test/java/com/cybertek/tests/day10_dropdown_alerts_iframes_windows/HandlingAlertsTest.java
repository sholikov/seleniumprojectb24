package com.cybertek.tests.day10_dropdown_alerts_iframes_windows;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HandlingAlertsTest {
    String url = "http://practice.cybertekschool.com/javascript_alerts";
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void jsAlertsTests() throws InterruptedException {
        // click on Informational/ warning
        WebElement infoAlertLink =  driver.findElement(By.xpath("//*[.='Click for JS Alert']"));
        infoAlertLink.click();

        Thread.sleep(1234);
        // Alert interface is used to accept, dismiss JS alerts, cause we cant inspect alerts and we assigned interface
        //type variable
        Alert infoAlert = driver.switchTo().alert();
        System.out.println("Text of alert= " + infoAlert.getText());
        infoAlert.accept();//click on ok

    }
    @Test
    public void confirmAlertTest(){
        WebElement confirm = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        confirm.click();
        Alert confirmAlert = driver.switchTo().alert();
        System.out.println("Text of alert = " + confirmAlert.getText());
        Assert.assertEquals(confirmAlert.getText(),"I am a JS Confirm");
        confirmAlert.dismiss();
    }
}
