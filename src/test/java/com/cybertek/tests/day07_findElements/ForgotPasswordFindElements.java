package com.cybertek.tests.day07_findElements;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ForgotPasswordFindElements {
    public static void main(String[] args) {
        String appUrl ="http://practice.cybertekschool.com/forgot_password";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(appUrl);
        // locate all the links and store into list of webelements
        List<WebElement> links = driver.findElements(By.tagName("a"));

        // print count of link

        System.out.println("count of links" + links.size());

        // print text of first one

        System.out.println("first link= " + links.get(0).getText());

        // print second text

        System.out.println("second=" + links.get(1).getText());

        // Loop and print href of each one

        for (WebElement each : links) {

            System.out.println(each.getAttribute("href"));
            
        }
        // click on home page link

        links.get(1).click();


    }
}
