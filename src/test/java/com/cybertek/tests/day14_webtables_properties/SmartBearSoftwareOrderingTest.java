package com.cybertek.tests.day14_webtables_properties;

import com.cybertek.utils.SmartBearUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmartBearSoftwareOrderingTest extends SmartBearTestBase {
    Faker faker = new Faker();

    @Test
    public void softwareOrderTest() {
        SmartBearUtils.loginToSmartBear(driver);
        driver.findElement(By.linkText("Order")).click();
        Select product = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        product.selectByVisibleText("FamilyAlbum");
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys("2");
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();

        WebElement name = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']"));
        name.sendKeys(faker.name().firstName());
        WebElement street = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2"));
        street.sendKeys(faker.address().streetAddress());
        WebElement city = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        city.sendKeys(faker.address().city());
        WebElement state = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4"));
        state.sendKeys(faker.address().state());
        WebElement zipCode = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5"));
        zipCode.sendKeys(faker.address().zipCode().substring(0,5));

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();

        WebElement cardNumber =  driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6"));
        cardNumber.sendKeys(faker.business().creditCardNumber().replace("-",""));

        WebElement expireDate = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));
        expireDate.sendKeys("11/26");

        driver.findElement(By.xpath("//a[.='Process']")).click();

        WebElement successMessage = driver.findElement(By.xpath("//div[@class='buttons_process']/strong"));
        Assert.assertEquals(successMessage.getText(),"New order has been successfully added.","Message does not match with output!");


    }

}
