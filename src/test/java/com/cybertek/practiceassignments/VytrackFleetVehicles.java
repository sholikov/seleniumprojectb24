package com.cybertek.practiceassignments;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VytrackFleetVehicles {

    String url = "https://qa2.vytrack.com/";
    WebDriver driver;


    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);

    }

    @Test
    public void locatingRefreshButtonTest() throws InterruptedException {

        WebElement username = driver.findElement(By.name("_username"));
        username.sendKeys("user10");
        WebElement password = driver.findElement(By.name("_password"));
        password.sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1']//span")).click();
        Thread.sleep(1234);
        driver.findElement(By.xpath("//span[.='Vehicles']")).click();
        Thread.sleep(1234);


        WebElement refreshButton = driver.findElement((By.xpath("//a[@title='Reset']/preceding-sibling::a[1]")));
        Assert.assertTrue(refreshButton.isDisplayed(),"Refresh button is displayed on the left side od reset button");

    }


}
