package com.cybertek.tests.day10_dropdown_alerts_iframes_windows;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CarGurusUserCarSearchTest {

    String url = "https://www.cargurus.com";
    WebDriver driver;// we can use in everywhere once we declare in global scope

    @BeforeClass
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @AfterClass
    public void tearDown(){
       driver.quit();
}

    @Test
    public void searchForMinivanTest(){
        //verify if we are on the correct page by checking page title
        String expTitle = "Buy & Sell Cars: Reviews, Prices, and Financing - CarGurus";
        Assert.assertEquals(driver.getTitle(),expTitle);
        // Select Toyota
       // WebElement dropDown = driver.findElement(By.id("carPickerUsed_makerSelect")); this is another way
       // Select make = new Select(dropDown);
        Select make = new Select(driver.findElement(By.id("carPickerUsed_makerSelect")));// shorter way
        make.selectByVisibleText("Toyota");

        // selecting car model
        Select model = new Select(driver.findElement(By.id("carPickerUsed_modelSelect")));
        model.selectByValue("d308");

        // type zip code

        WebElement zipCode = driver.findElement(By.name("zip"));
        zipCode.sendKeys("72713");

        // print currently selected options of make and model
        System.out.println("Selected make " + make.getFirstSelectedOption().getText());
        System.out.println("Selected model " + model.getFirstSelectedOption().getText());


        //click on search

        driver.findElement(By.id("dealFinderForm_0")).click();

        WebElement resultCount = driver.findElement(By.xpath("//span[@class='oKvYB4']/strong[2]"));
        System.out.println("Result count " + resultCount.getText());

        // assert that count is more than 0
        int count = Integer.parseInt(resultCount.getText());
        Assert.assertTrue(count>0);

    }


}
