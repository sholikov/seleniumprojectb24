package com.cybertek.practiceassignments.officehours;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TotalOrderPriceCalculation1 {
    /*
    Total Order Price Calculation 1
- Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
- Login with username: Tester, password: test
- Click  Order button
- Verify under Product Information, selected option is “MyMoney”
-Then select FamilyAlbum, make quantity 2, and click Calculate,
- Then verify Total is equal to Quantity*PricePerUnit
     */

    String url = "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx";
    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void totalOrderPriceCalculationTest() throws InterruptedException {
        WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.name("ctl00$MainContent$password"));
        password.sendKeys("test");
        driver.findElement(By.xpath("//input[@class='button']")).click();
        driver.findElement(By.linkText("Order")).click();
        Select productSelection = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        Assert.assertEquals(productSelection.getFirstSelectedOption().getText(), "MyMoney");
        productSelection.selectByValue("FamilyAlbum");
        WebElement quantitySelect = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        quantitySelect.sendKeys("2");
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();

        int quantity = Integer.parseInt(quantitySelect.getAttribute("value"));
        System.out.println("quantity = " + quantity);

        WebElement pricePerUnit = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice"));

        int price = Integer.parseInt(pricePerUnit.getAttribute("value"));
        System.out.println("price = " + price);

        WebElement totalBox = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtTotal"));

        int total = Integer.parseInt(totalBox.getAttribute("value"));
        System.out.println("total = " + total);
        
        Assert.assertEquals(total,quantity*price);


    }
}
