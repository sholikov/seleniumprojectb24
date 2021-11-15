package com.cybertek.tests.day08_implicitwait_checkbox_radio_testing;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Etsy_WoodenSpoon {
    public static void main(String[] args) throws InterruptedException {
        /*
        Launch Browser and goto etsy homepage
search for wooden spoon
click on filters
Select free shipping, on sale
select under $25
Click on apply filters
Print count of results
         */
        String url ="https://www.etsy.com/";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //implicit wait command
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

        driver.findElement(By.name("search_query")).sendKeys("wooden spoon", Keys.ENTER);
        driver.findElement(By.id("search-filter-button")).click();

        driver.findElement(By.xpath("//label[@for='special-offers-free-shipping']")).click();
        driver.findElement(By.xpath("//label[@for='special-offers-on-sale']")).click();
        driver.findElement(By.xpath("//label[@for='price-input-1']")).click();
        driver.findElement(By.xpath("//button[@aria-label='Apply']")).click();
        Thread.sleep(1234);
        WebElement msg = driver.findElement(By.xpath("//span[contains(text(),'results')]"));
        Thread.sleep(1234);
        String result = msg.getText();


        System.out.println(result);

    }
}
