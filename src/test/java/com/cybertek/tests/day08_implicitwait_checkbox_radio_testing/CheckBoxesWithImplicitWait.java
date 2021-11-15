package com.cybertek.tests.day08_implicitwait_checkbox_radio_testing;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class CheckBoxesWithImplicitWait {
    public static void main(String[] args) {
        String url = "http://practice.cybertekschool.com/checkboxes";

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //implicit wait command
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

       WebElement checkbox1 = driver.findElement(By.name("checkbox1"));
       checkbox1.click();
        WebElement checkbox2 = driver.findElement(By.cssSelector("input[id='box2']"));
        checkbox2.click();

        System.out.println("checkbox1 is selected ? - "+ checkbox1.isSelected());
        System.out.println("checkbox2 is selected ? - "+ checkbox2.isSelected());

        if(!checkbox1.isSelected()){
            checkbox1.click();
        }else {
            System.out.println("Checkbox 1 is already selected");
        }


    }
}
