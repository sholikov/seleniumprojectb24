package com.cybertek.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    /**
     * WebDriverFactory class:
     * is used to create WebDriver(Selenium) object and return it.
     * It will open the browser
     * method:
     * getDriver(String browserType)
     * It will check browser type and return object:
     * if browserType is  "chore":
     * it will set up chrome driver, and return new ChromeDriver
     */

    public static WebDriver getDriver(String browserType) {

        if (browserType.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();

            return new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }else {
            System.out.println("Invalid Browser Type = " + browserType);
            return null;

        }

    }
    public static void windowManager(WebDriver driver){
        driver.manage().window().maximize();
    }
}
