package com.cybertek.tests.day15_properties_driverutil_testbase;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TechlisticWebtableTest extends TestBase {

    /**
     * Go to this url = https://www.techlistic.com/p/demo-selenium-practice.html
     * Assert current url contains : techlistic
     * Print all Building names
     */

    @Test
    public void tallBuildingTableTest(){

        driver.get(ConfigurationReader.getProperty("techlisticUrl"));
        Assert.assertTrue(driver.getCurrentUrl().contains("techlistic"),"There is now such word in this url");

        List<WebElement> buildings= driver.findElements(By.xpath("//table[@class='tsc_table_s13']//tbody/tr/th"));

        System.out.println(driver.getCurrentUrl());
        for (WebElement element : buildings) {
            System.out.println("Tower name  " + element.getText());
            
        }

        Assert.assertTrue(driver.getCurrentUrl().contains("techlistic"),"There is now such word in this url");
        //table[@class='tsc_table_s13']//td[contains(text(),'buildings')]
        // //table[@class='tsc_table_s13']/tfoot/tr/td

    }
}
