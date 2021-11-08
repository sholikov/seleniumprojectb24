package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC5_SmartBearLoginTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx ";

        driver.get(url);

        String username = "Tester";
        String password = "test";

        String expectedTitle = "Web Orders Login";
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Test passed");
        }
        else{
            System.out.println("Test Failed");
        }
        // typing username
        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys(username);
        // typing password
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys(password);
        // clicking login button after entering username and password
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();

        // verify title is "Web Orders"
        String expTitle = "Web Orders";
        String actTitle = driver.getTitle();

        if(actTitle.equals(expTitle)){
            System.out.println("Test passed");
        }
        else{
            System.out.println("Test Failed");
        }
        //
        driver.findElement(By.linkText("Logout")).click();


        driver.quit();

    }
}
