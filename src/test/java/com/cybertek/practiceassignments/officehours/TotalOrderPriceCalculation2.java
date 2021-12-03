package com.cybertek.practiceassignments.officehours;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TotalOrderPriceCalculation2 {
    /*
    Total Order Price Calculation 2
 - Go to https://www.demoblaze.com/index.html#
 - From Categories select Laptops, and from products select Sony Vaio i7
 - click Add to Cart then handle pop up
 - Navigate to Home
  - From Categories select Phones, and from products select Iphone 6 32gb
 - click Add to Cart then handle pop up
 - Navigate to Cart
- Then Verify that total cart price is equal to expected (total of added 2 items) price
     */


    String url = "https://www.demoblaze.com/index.html#";
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void totalPriceCalculation() throws InterruptedException {
        WebElement laptop = driver.findElement(By.xpath("//a[text()='Laptops']"));
        laptop.click();
        Thread.sleep(1234);
        WebElement sony = driver.findElement(By.xpath("//h4/a[contains(text(),'Sony vaio i7')]"));
        sony.click();
      //  System.out.println(sony.getAttribute("value"));

        Thread.sleep(1234);
        driver.findElement(By.xpath("//a[@class='btn btn-success btn-lg']")).click();
        Thread.sleep(1234);

        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(1234);
        WebElement home = driver.findElement(By.xpath("//li//a[@href='index.html']"));
        home.click();
        //  Thread.sleep(1234);
        WebElement phone = driver.findElement(By.xpath("//div[@class='list-group']//a[text()='Phones']"));
        phone.click();

        Thread.sleep(1234);
        WebElement iPhone = driver.findElement(By.linkText("Iphone 6 32gb"));
        iPhone.click();
        driver.findElement(By.xpath("//a[@class='btn btn-success btn-lg']")).click();

        Thread.sleep(1234);
        Alert alert2 = driver.switchTo().alert();
        alert.accept();

        Thread.sleep(1234);
        driver.findElement(By.xpath("//a[@id='cartur']")).click();

        WebElement total = driver.findElement(By.tagName("h3"));
        Thread.sleep(1234);
        System.out.println("ActualTotal = " + total.getText());

        WebElement itemOne = driver.findElement(By.xpath("//tbody/tr[1]/td[3]"));
       // WebElement itemOne = driver.findElement(By.xpath("//tbody/tr[1]/td[.='790']"));
        Thread.sleep(1234);
        System.out.println("The first item's price = " + itemOne.getText());
        WebElement itemTwo = driver.findElement(By.xpath("//tr[2]/td[3]"));
        //WebElement itemTwo = driver.findElement(By.xpath("//tr[2]/td[.='790']"));
        Thread.sleep(1234);
        System.out.println("The second item's price = " + itemTwo.getText());
        int expectedTotal = Integer.parseInt(itemOne.getText()) + Integer.parseInt(itemTwo.getText());

        Assert.assertEquals(Integer.parseInt(total.getText()),expectedTotal);


    }
}
