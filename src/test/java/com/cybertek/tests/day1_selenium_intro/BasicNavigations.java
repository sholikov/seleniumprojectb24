package com.cybertek.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException {

        //1) set up the browser driver
        WebDriverManager.chromedriver().setup();

        //2)open browser
        WebDriver driver = new ChromeDriver();

        //3) navigate to Tesla.com

        driver.get("https://www.tesla.com");

        // navigate back  is similar to clicking back button
        driver.navigate().back();

        // pause the code. code will sleep/wait

        Thread.sleep(4000);

        // navigates forward
        driver.navigate().forward();

        Thread.sleep(4000);

        // navigates refresh button
        driver.navigate().refresh();

        Thread.sleep(4000);

        //navigate to bestbuy homepage
        driver.navigate().to("https://www.bestbuy.com");

        // reads the title of current page and returns it
        System.out.println("Current title:" + driver.getTitle());

        // close the browser
        driver.close();




    }
}
