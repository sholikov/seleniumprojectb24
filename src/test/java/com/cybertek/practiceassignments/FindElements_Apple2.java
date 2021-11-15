package com.cybertek.practiceassignments;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindElements_Apple2 {
    public static void main(String []args){
        /*
        TC #03: FINDELEMENTS_APPLE
1. Open Chrome browser
2. Go to https://www.apple.com
3. Click to all of the headers one by one
a. Mac, iPad, iPhone, Watch, TV, Music, Support
4. Print out the titles of the each page
5. Print out total number of links in each page
6. While in each page:
a. Print out how many link is missing text TOTAL
b. Print out how many link has text TOTAL
         */
        String url = "https://www.apple.com";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(url);

        String [] list = {"Mac", "iPad", "iPhone", "Watch"," TV", "Music", "Support"};
     //   List<WebElement> links  = driver.findElements(By.tagName("//a[.=" + list[i]+ ));

        for (int i = 0;i<8; i++){
             driver.findElements(By.tagName("//a[.=" + list[i]+"]" ));

        }


    }
}
