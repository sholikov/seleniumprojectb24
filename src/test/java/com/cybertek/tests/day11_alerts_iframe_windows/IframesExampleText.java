package com.cybertek.tests.day11_alerts_iframe_windows;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class IframesExampleText {

    String url = "http://practice.cybertekschool.com/iframe";
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void iframeTest(){
      // swith to frame by id "mce_0_ifr"
        driver.switchTo().frame("mce_0_ifr");
        // now you can focus on the frame
        WebElement commentField = driver.findElement(By.id("tinymce"));
        System.out.println("commentField.getText() = " + commentField.getText());
        commentField.clear();
        commentField.sendKeys("Hello Hello");

        // go out from iframe back to main content
        driver.switchTo().defaultContent();

    }
    @Test
    public void multipleFramesTest(){
        driver.get("http://practice.cybertekschool.com/nested_frames");
        // count of frames on this page

        List<WebElement>frames = driver.findElements(By.tagName("frame"));
        System.out.println("Count of frames = " + frames.size());

        //Switch to bottom frame by name/id
        driver.switchTo().frame("frame-bottom");
        WebElement bodyElement = driver.findElement(By.tagName("body"));
        System.out.println("BodyElement text is  " + bodyElement.getText());

        // go out bottom frame to main level
        driver.switchTo().defaultContent();

        // switch to first frame (by index 0)
        driver.switchTo().frame(0);
        driver.switchTo().frame(0);
        bodyElement = driver.findElement(By.tagName("body"));
        System.out.println("BodyElement text is  " + bodyElement.getText());

        // go back parent frame
        driver.switchTo().parentFrame().switchTo().defaultContent();

        driver.switchTo().frame(0);
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='/frame_right']")));
        bodyElement = driver.findElement(By.tagName("body"));
        System.out.println("Right bodyElement text is  " + bodyElement.getText());

    }


}
