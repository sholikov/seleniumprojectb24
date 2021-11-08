package com.cybertek.tests.day05_xpath_css_isdisplayed;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MoreXpathPractice {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        WebDriverFactory.windowManager(driver);
        String url = "http://practice.cybertekschool.com/multiple_buttons";
        driver.get(url);
        WebElement btnOne  = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        btnOne.click();

        String  actualTxt = driver.findElement(By.id("result")).getText();
        String expTxt = "Clicked on button one!";

        System.out.println(actualTxt.equals(expTxt)? "Pass": "Fail");
   ////*[@id="content"]/div[1]/button[2]
        WebElement button2 = driver.findElement(By.xpath("//button[text()='Button 2']"));





    }
}
