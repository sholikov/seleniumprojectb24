package com.cybertek.practiceassignments;

import com.cybertek.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverDragAndDropTest extends TestBase {
    @Test
    public void dragAndDropTest(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement small = driver.findElement(By.xpath("//div[@class='demo-section k-content']/div[@id='draggable']"));
        WebElement large = driver.findElement(By.xpath("//div[@class='k-header']"));
        actions.dragAndDrop(small,large).perform();
        System.out.println("Message " + large.getText());
        Assert.assertEquals(large.getText(),"You did great!","Message does not match!");


    }
}
