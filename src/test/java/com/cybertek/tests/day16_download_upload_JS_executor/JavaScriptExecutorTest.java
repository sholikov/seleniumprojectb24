package com.cybertek.tests.day16_download_upload_JS_executor;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScriptExecutorTest extends TestBase {
    @Test
    public void alertExampleTest() {
        // down casting from WebDriver  to JavascriptExecutor interface
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //running javascript alert command
        js.executeScript("alert('hello hello!')");

        BrowserUtils.sleep(2);
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text = " + alert.getText());
        alert.accept();
    }

    @Test
    public void scrollTest() {
        driver.get(ConfigurationReader.getProperty("scroll.url"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        BrowserUtils.sleep(2);
        js.executeScript("window.scrollBy(0, 5000)");
        for (int i = 0; i < 2; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0, 1000)");
        }


    }

    @Test
    public void scrollToElementTest() {
        driver.get(ConfigurationReader.getProperty("tesla.url"));
        //locate
        WebElement shopNow = driver.findElement(By.xpath("//a[@title='Shop Now']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", shopNow);
        BrowserUtils.sleep(2);

    }

    @Test
    public void setValueUsingJSTest() {
        driver.get(ConfigurationReader.getProperty("facebook.url"));
        WebElement userName = driver.findElement(By.name("email"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='hello@gmail.com'" , userName);


    }
}
