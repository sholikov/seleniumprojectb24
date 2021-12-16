package com.cybertek.practiceassignments;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ContextClickTest extends TestBase {
    @Test
    public void contextClickTest(){
        driver.get(ConfigurationReader.getProperty("practice.url"));
        WebElement box= driver.findElement(By.xpath("//div[@id='hot-spot']"));
        actions.moveToElement(box).contextClick().perform();
        Alert alert= driver.switchTo().alert();
        System.out.println("alert.getText() = " + alert.getText());
        alert.accept();
    }
}
