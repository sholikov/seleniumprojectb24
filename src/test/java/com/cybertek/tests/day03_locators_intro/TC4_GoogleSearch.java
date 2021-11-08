package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC4_GoogleSearch {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "https://google.com ";
        driver.get(url);

        //driver.findElement(By.name("q")).sendKeys("apple");

        //locate and click search button
       // driver.findElement(By.name("btnK")).click();
        driver.findElement(By.name("q")).sendKeys("apple" + Keys.ENTER);

        String titleExpected = "apple";
        String titleActual = driver.getTitle();

        if(titleActual.startsWith(titleExpected)){
            System.out.println("PASS: Title verification success");
        } else {
            System.out.println("FAIL: Title verification failed");
        }
      //  driver.quit();
        }
    }

