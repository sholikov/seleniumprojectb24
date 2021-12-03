package com.cybertek.tests.day13_faker_practice_browserutil_properties;

import com.cybertek.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationFormNegativeTest extends RegistrationFormTestBase{

    @Test

    public void invalidFirstNameTest(){
       // do not enter any value in the firstname and click on the sign up
        //

        WebElement signUp = driver.findElement(By.id("wooden_spoon"));
        signUp.click();

        // wait for 1 second
        BrowserUtils.sleep(1);

        WebElement errorMsg = driver.findElement(By.xpath("//small[text()='first name is required']"));
        Assert.assertTrue(errorMsg.isDisplayed(),"Error message is displayed");

        // now we type 12345 and verify "first name can only consist of alphabetical letters"
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("12345");

        BrowserUtils.sleep(2);
        WebElement noNumberMsg = driver.findElement(By.xpath("//small[text()='first name can only consist of alphabetical letters']"));
        Assert.assertTrue(noNumberMsg.isDisplayed(),"Error message is displayed");

    }
}
