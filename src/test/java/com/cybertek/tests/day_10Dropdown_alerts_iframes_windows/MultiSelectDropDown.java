package com.cybertek.tests.day_10Dropdown_alerts_iframes_windows;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MultiSelectDropDown {
    String url = "http://practice.cybertekschool.com/dropdown";
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void selectMultipleLanguagesTest() throws InterruptedException {
        Select languages = new Select(driver.findElement(By.name("Languages")));
        languages.selectByVisibleText("Java");
        languages.selectByVisibleText("JavaScript");
        languages.selectByVisibleText("Python");

        System.out.println("languages.isMultiple() = " + languages.isMultiple());

        Thread.sleep(1234);
        //un check all selected options
        languages.deselectAll();

        Thread.sleep(1234);

        for (WebElement each : languages.getOptions()) {
            each.click();
        }
    }
}
