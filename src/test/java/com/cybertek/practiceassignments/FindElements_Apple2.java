package com.cybertek.practiceassignments;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindElements_Apple2 {
    public static void main(String []args) throws InterruptedException {
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
        String[] list = {"Mac", "iPad", "iPhone", "Watch", "TV & Home", "Only on Apple", "Accessories","Support"};

        for (int i = 0; i < list.length; i++) {
            WebElement headers = driver.findElement(By.linkText(list[i]));
            headers.click();
            System.out.println(driver.getTitle());
            List<WebElement> links = driver.findElements(By.tagName("a"));
            Thread.sleep(1234);
            int hasText = 0;
            int missingText = 0;
            for (WebElement link : links) {
                if (!link.getText().isEmpty()) {
                    hasText++;
                } else {
                    missingText++;
                }
            }
            System.out.println(list[i]+" page has total of " + links.size() + " links\nThis page has  " + hasText +
                " links with texts \n" + "And  " + missingText + " links without texts");
            System.out.println("-------------------------");

    }
    }
}
