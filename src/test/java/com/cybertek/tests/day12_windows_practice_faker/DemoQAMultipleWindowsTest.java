package com.cybertek.tests.day12_windows_practice_faker;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class DemoQAMultipleWindowsTest {
    WebDriver driver;
    String demoUrl = "https://demoqa.com/browser-windows";

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(demoUrl);
    }

    /**
     * Click on the new Window button
     * Switch to new Window
     * Locate and print the message
     * Close the window
     * Go back to main window
     */

    @Test
    public void newWindowTest() {
        driver.findElement(By.id("windowButton")).click();


        //driver.close(); // close currently active window
        //driver.quit(); // close all the  windows in same session

        Set<String> windowHandlesSet = driver.getWindowHandles();
        String parentWindowHandle = driver.getWindowHandle();

        for (String windowHandle : windowHandlesSet) {
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle);
            }


        }

    }
}
