package com.cybertek.tests.day10_dropdown_alerts_iframes_windows;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AmazonDepartmentNamesListTest {

    /*
    add setUp method with @BeforeMethod annotation:
    launch selenium, maximize, set timeout, navigate to amazon

add @Test amazonDepartmentTest

assert Amazon home page is displayed
assert that "All" option is selected by default/automatically

get All available options and print out
     */

    String url = "https://www.amazon.com";
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void amazonDepartmentTest(){
        String expTitle = "Amazon.com. Spend less. Smile more.";
        // we imported static Assert class
        assertEquals(driver.getTitle(),expTitle);

        // assert that "All" is selected default/automatically
        Select departments  = new Select(driver.findElement(By.id("searchDropdownBox")));
        String selectedOption = departments.getFirstSelectedOption().getText();
        assertEquals(selectedOption,"All Departments");

        List<WebElement> allDepartments =  departments.getOptions();// similar to findElements
        int countOfDepartments = allDepartments.size();
        System.out.println("countOfDepartments = " + countOfDepartments);
        assertTrue(countOfDepartments>10,"Department names are missing");

        // loop and print all available options
        for (WebElement department : allDepartments) {
            System.out.println(department.getText());
        }

        // with Lambda expression
        System.out.println("==========================================================");
        allDepartments.forEach(department -> System.out.println(department.getText()));

        // select eac item by order and wait 400ms in between

        for(WebElement dept : allDepartments){
            departments.selectByVisibleText(dept.getText());
        }

    }
}
