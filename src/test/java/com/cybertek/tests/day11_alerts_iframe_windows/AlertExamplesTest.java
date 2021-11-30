package com.cybertek.tests.day11_alerts_iframe_windows;

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

public class AlertExamplesTest {
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
    public void infoAlertTest(){
        // click on JS alert link
        WebElement alertLink = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        alertLink.click();

        //switch to the alert and assert text is "I am a JS alert"
        Alert alert= driver.switchTo().alert();
        System.out.println("Alert text: " + alert.getText());
        Assert.assertEquals(alert.getText(),"I am a JS Alert");
        alert.accept();// clicking on Ok button on the alert

        Assert.assertEquals(driver.findElement(By.id("result")).getText(),"You successfuly clicked an alert");
    }
    @Test
    public void confirmAlertTest(){
        //click pn JS confirm alert link
        // switch to alert then assert the text is "I am JS Confirm
        //click on cancel
        //assert result message is "You clicked: Cancel"

        WebElement alertLink = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        alertLink.click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text: " + alert.getText());


        Assert.assertEquals(alert.getText(),"I am a JS Confirm");
       alert.dismiss();
       WebElement confirmMsg =driver.findElement(By.id("result"));
        System.out.println("confirmMsg = " + confirmMsg.getText());
      Assert.assertEquals(confirmMsg.getText(),"You clicked: Cancel");

    }
    @Test
    public void promptAlertTest(){
        //click JS prompt button
        // switch to alert and assert/confirm the text is "I am aJS prompt"
        //enter"hello and click ok
        //assert "You entered: hello" message is displayed

        WebElement promptButton = driver.findElement(By.xpath("//button[contains(text(),'Prompt')]"));
        promptButton.click();

        Alert promptAlert = driver.switchTo().alert();
        System.out.println("promptAlert Text: " + promptAlert.getText());
        //enter"hello and click ok
        promptAlert.sendKeys("hello");
        promptAlert.accept();

        WebElement promptResult = driver.findElement(By.id("result"));
        System.out.println("promptResult.getText() = " + promptResult.getText());
        Assert.assertEquals(promptResult.getText(),"You entered: hello");


    }
}
