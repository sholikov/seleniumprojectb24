package com.cybertek.practiceassignments;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ExerciseHtml {
    public static void main(String[] args) throws InterruptedException {
        String appUrl ="http://te.dev.secureci.com/Exercise1.html";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(appUrl);
        // locate all the links and store into list of webelements
        List<WebElement> links = driver.findElements(By.tagName("area"));

            System.out.println(links.size());

            List<WebElement> brokenLinks =new ArrayList<WebElement>();


        for(int i=0;i< links.size();i++){
            if(links.get(i).getAttribute("href")!=null){
                brokenLinks.add(links.get(i));
            }
        }

        System.out.println(brokenLinks);
        System.out.println("Broken links = " + brokenLinks.size());
    }
}
