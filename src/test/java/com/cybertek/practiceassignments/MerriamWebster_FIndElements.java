package com.cybertek.practiceassignments;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MerriamWebster_FIndElements {
    public static void main(String[] args) {
        /*
        1. Open Chrome browser
2. Go to https://www.merriam-webster.com/
3. Print out the texts of all links
4. Print out how many link is missing text
5. Print out how many link has text
6. Print out how many total link
         */

        String url = "https://www.merriam-webster.com";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(url);

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        //
        //  System.out.println(allLinks.size());
        int missingText = 0;
        int hasText = 0;

        for (WebElement allLink : allLinks) {
            if (allLink.getText().isEmpty()) {
                missingText++;
            } else {
                hasText++;
            }

        }
        System.out.println(missingText + " links are missing text \n"  + hasText + " links have texts \nThere are total of " + allLinks.size() + " links");
    }
}
