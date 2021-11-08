package com.cybertek.practiceassignments;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PolymerTest {
   /* Write a basic browser automation framework to validate a Polymer website.
    The focus should be on the interaction with the browser.
    The Web Application under test http://todomvc.com/
    The first step should be to load the website,
    click within the JavaScript tab,
    and select the Polymer link.
    The second step should be: Add one Todo item
    Then Verify that the item added.
    */

    public static void main (String [] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        WebDriverFactory.windowManager(driver);
        String url = "http://todomvc.com";
        driver.get(url);

        // <div class="tab-content flex-auto center-center horizontal layout style-scope paper-tab">JavaScript</div>
        //click within the JavaScript tab,
        driver.findElement(By.xpath("//div[text()='JavaScript']")).click();


        //select the Polymer link.
        driver.findElement(By.xpath("//a[text()='Polymer']")).click();

        WebElement addToList = driver.findElement(By.xpath("//input[@id='new-todo']"));
        Thread.sleep(3000);
        addToList.sendKeys("need to review Java" + Keys.ENTER);
        addToList.sendKeys("practice more" + Keys.ENTER);



        //td-todos/section/section[@class='main style-scope td-todos']/ul/li[3]/div[@class='style-scope td-item']/input[@type='checkbox']
       // driver.findElement(By.xpath("//button[@class='destroy style-scope td-item']")).click();
       Boolean display= driver.findElement(By.xpath("//label[text()='need to review Java']")).isDisplayed();
       System.out.println("Element is Displayed " + display);

    }

}
