package com.cybertek.tests.day05_xpath_css_isdisplayed;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RelativeXpathPractice {
    /*
    Goto https://www.worldometers.info/world-population/
wait 4 seconds
Locate current world population number using relative xpath
loop from 1 to 10
    print the text of the element
    wait 1 second

     */
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        WebDriverFactory.windowManager(driver);
        String url = "https://www.worldometers.info/world-population/";
        driver.get(url);

        WebElement info  = driver.findElement(By.xpath("//div[@class='maincounter-number']"));

        System.out.println(info.getText());

        for(int i = 0; i<10; i++){
            System.out.println(info.getText());
        }
      //  driver.quit();

    }
}
