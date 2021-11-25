package com.cybertek.practiceassignments;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SimpleDropDownTests {
    String url = "http://practice.cybertekschool.com/dropdown";
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }
    @Test(priority = 1)
    public void simpleDropDownAndStateSelectionTest(){
        Select dropDown =  new Select ( driver.findElement(By.id("dropdown")));
        String allDropDown = dropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(allDropDown,"Please select an option");
        Select stateSelect = new Select(driver.findElement(By.id("state")));
        String stateDropDown = stateSelect.getFirstSelectedOption().getText();
        Assert.assertEquals(stateDropDown,"Select a State");
    }
    @Test(priority = 2)
    public void stateSelectingTest() throws InterruptedException {

        Select states = new Select(driver.findElement(By.id("state")));
        states.selectByVisibleText("Illinois");
        states.selectByValue("VA");
        states.selectByIndex(5);
        String expectedState = "California";
        Thread.sleep(1234);
        Assert.assertEquals(states.getFirstSelectedOption().getText(),expectedState);
       //List<WebElement> options = states.getOptions();
        //System.out.println(options.size()-1);
    }
    @Test(priority = 3)
    public void dateDropDownTest(){
        Select year= new Select(driver.findElement(By.id("year")));
        year.selectByVisibleText("1922");
        Assert.assertEquals(year.getFirstSelectedOption().getText(),"1922");
        Select month = new Select((driver.findElement(By.id("month"))));
        month.selectByValue("11");
        Assert.assertEquals(month.getFirstSelectedOption().getText(),"December");
        Select day = new Select((driver.findElement(By.id("day"))));
        day.selectByIndex(0);
        Assert.assertEquals(day.getFirstSelectedOption().getText(),"1");

    }

}
