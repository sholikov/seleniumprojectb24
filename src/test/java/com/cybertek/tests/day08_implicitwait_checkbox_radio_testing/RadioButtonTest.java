package com.cybertek.tests.day08_implicitwait_checkbox_radio_testing;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RadioButtonTest {
    public static void main(String[] args) throws InterruptedException {
        String url = "http://practice.cybertekschool.com/radio_buttons";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        // wait  upto 10 seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

        WebElement red =driver.findElement(By.id("red"));
        if(!red.isSelected()){
            red.click();
        }
        WebElement football = driver.findElement(By.id("football"));
        if(!football.isSelected()){
            football.click();
        }

        if(football.isSelected()){
            System.out.println("PASS  - football is selected");
        }else{
            System.out.println("Fail - football is not selected");
        }

        //find all radio buttons
        //print the count
        //click one by one , waiting 1 second in between
        //we can use isEnabled method to check if element is active/disabled

        List<WebElement>radioButtons = driver.findElements(By.xpath("//input[@type='radio']"));
        System.out.println(radioButtons.size());
        for (WebElement radioButton : radioButtons) {
            Thread.sleep(1234);
            radioButton.click();

        }
    }
}
