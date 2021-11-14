package com.cybertek.practiceassignments;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindingElements_Apple {
    public static void main(String []args){
        /*
        TC #02: FINDELEMENTS_APPLE
1. Open Chrome browser
2. Go to https://www.apple.com
3. Click to iPhone
4. Print out the texts of all links
5. Print out how many link is missing text
6. Print out how many link has text
7. Print out how many total link
         */
        String url = "https://www.apple.com";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(url);

        driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-iphone']")).click();

        List<WebElement> link = driver.findElements(By.tagName("a"));

        int hasText = 0;
        int missingText = 0;
        for (WebElement element : link) {
            System.out.println(element.getText());
            if(element.getText().isEmpty()){
                missingText++;
            }else{
                hasText++;
            }

        }

        System.out.println("There are total of " + link.size()+" links");
        System.out.println("From them " + missingText + " are missing text links  and \n" + hasText + " have them texts on their links");
    }
}
