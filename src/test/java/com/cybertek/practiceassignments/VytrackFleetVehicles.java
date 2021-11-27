package com.cybertek.practiceassignments;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VytrackFleetVehicles {

    String url = "https://qa2.vytrack.com/";
    WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
       WebElement username= driver.findElement(By.name("_username"));
       username.sendKeys("user10");
       WebElement password= driver.findElement(By.name("_password"));
       password.sendKeys("UserUser123");
       driver.findElement(By.id("_submit")).click();
        driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1']//span")).click();
        Thread.sleep(1234);
        driver.findElement(By.xpath("//span[.='Vehicles']")).click();
        Thread.sleep(1234);

        driver.findElement(By.xpath("//i[@class='fa-repeat']")).click();

}

    @Test
    public void locatingRefreshButtonTest(){
        System.out.println("Testing");
        WebElement refreshButton = driver.findElement(By.xpath("//i[.='fa-repeat']"));
        refreshButton.click();
        WebElement resetButton = driver.findElement(By.xpath("//i[.='fa-refresh"));
        resetButton.click();
    }



}
