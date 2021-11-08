package com.cybertek.tests.day04_locators_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PercentageCalculatorTest {
    public static void main(String[] args) {

        /*
        Main method:
    - launch browser, maximize
    - navigate to https://www.calculator.net/
    - Click on Percentage Calculator
    - Verify current title is "Percentage Calculator"
    - Enter 20% of 120000 and click enter (using Keys.ENTER)
    - Print the result "Result: 24000"
    - close browser
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "https://www.calculator.net";
         driver.get(url);

         driver.findElement(By.linkText("Percentage Calculator")).click();

          String actualTitle = driver.getTitle();
          String expTitle ="Percentage Calculator";
        System.out.println(actualTitle.equals(expTitle)? "Passed": "Failed");

        String percentage ="20";
        String value = "120000";

        driver.findElement(By.name("cpar1")).sendKeys(percentage);
        driver.findElement(By.name("cpar2")).sendKeys(value,Keys.ENTER);

        String result = driver.findElement(By.className("h2result")).getText();
       System.out.println(result);



    }

}
