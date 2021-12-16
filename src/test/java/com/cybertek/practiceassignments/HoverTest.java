package com.cybertek.practiceassignments;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HoverTest extends TestBase {
    /*
    TC #15: Hover Test
1. Go to http://practice.cybertekschool.com/hovers
2. Hover over to first image
3. Assert:
a. “name: user1” is displayed
4. Hover over to second image
5. Assert:
a. “name: user2” is displayed
6. Hover over to third image
7. Confirm:
a. “name: user3” is displayed
     */
    @Test
    public void practiceHoverTest(){
        driver.get(ConfigurationReader.getProperty("hover.url"));

        WebElement image1= driver.findElement(By.xpath("(//img)[1]"));
        actions.moveToElement(image1).perform();
        System.out.println(image1.getAttribute("alt"));
        Assert.assertTrue(image1.isDisplayed());

        List<WebElement> images= driver.findElements(By.xpath("//img"));
        for (WebElement image : images) {
            actions.moveToElement(image).perform();
            System.out.println("Each image " + image.getAttribute("src"));
            Assert.assertTrue(image.isDisplayed());
        }


    }

}
