package com.cybertek.practiceassignments;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PolymerWebsiteTest {
    public static void main(String[]args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        WebDriverFactory.windowManager(driver);
        String url = " http://todomvc.com";
        driver.get(url);
        driver.findElement(By.xpath("//div[.='JavaScript']")).click();
        driver.findElement(By.linkText("Polymer")).click();

        Thread.sleep(4000);
        WebElement todoList = driver.findElement(By.id("new-todo"));
        todoList.sendKeys("need to practice" + Keys.ENTER);

        WebElement msg = driver.findElement(By.xpath("//label[.='need to practice']"));
        String added = msg.getText();
        
       if(msg.isDisplayed()) {
           System.out.println(added + " is added to TODO list");

       }else{
           System.out.println("Nothing added");
       }

    }
}
