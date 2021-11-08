package com.cybertek.tests.day04_locators_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributeDemo {

    /*
    navigate to google home page

   Locate the search field and assign to WebElement variable
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "https://www.google.com/";
        driver.get(url);

        // Locate the search field and assign to WebElement variable
       WebElement searchField = driver.findElement(By.name("q"));
        System.out.println("class value = " + searchField.getAttribute("class"));
        System.out.println("max length = " + searchField.getAttribute("maxlength"));
        searchField.sendKeys("wooden spoon");

        // read the value that is int the search field
        System.out.println("current value = " + searchField.getAttribute("value"));

        // print name value of the WebElement
        System.out.println("name = "+ searchField.getAttribute("name"));



    }
}
