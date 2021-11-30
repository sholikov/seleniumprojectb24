package com.cybertek.tests.day11_alerts_iframe_windows;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MultipleWindowsExampleTest {

    WebDriver driver;
    String url = "http://practice.cybertekschool.com/windows";
    String demoUrl = "https://demoqa.com/browser-windows";
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       // driver.get(url);
    }

    @Test
    public void windowsTest() {
        driver.get(url);
        //get window handle of current window
        String mainWindowHandle = driver.getWindowHandle();
        System.out.println("windowHandle = " + mainWindowHandle);

        //click on new window link
        WebElement newWindowLink = driver.findElement(By.linkText("Click Here"));
        newWindowLink.click();

        Set<String> windowsHandles = driver.getWindowHandles();
        System.out.println("Count of windows = " + windowsHandles.size());

        // print all window handles
        System.out.println("WindowsHandles = " + windowsHandles);

        // loop and switch to different window

        for(String windowHandle :windowsHandles){
            driver.switchTo().window(windowHandle);
            System.out.println("driver = " + driver.getTitle());
        }

        WebElement h3Elem= driver.findElement(By.xpath("//h3"));
        System.out.println("h3 header text on new page = " + h3Elem.getText());

        // go back to parent window/main window

        driver.switchTo().window(mainWindowHandle);
        System.out.println("Title after switching back to main window = " + driver.getTitle());

    }
    @Test
    public void demoQAMultipleWindowTest(){
        driver.get(demoUrl);
        WebElement newTab = driver.findElement(By.id("tabButton"));
        WebElement newWindow = driver.findElement(By.id("windowButton"));
        WebElement newWindowMessage = driver.findElement(By.id("messageWindowButton"));

        newTab.click();
        newWindow.click();
        newWindowMessage.click();

        System.out.println("Title page of parent/main page = " + driver.getTitle());

        //store parent window handle id in a variable
        String mainWindowId = driver.getWindowHandle();

        // store all window handle ids in to Set
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println("Total window count =" + allWindowHandles.size());
        for (String eachWindow: allWindowHandles) {
            driver.switchTo().window(eachWindow);
       //     System.out.println(driver.getTitle());

        }


    }

}
