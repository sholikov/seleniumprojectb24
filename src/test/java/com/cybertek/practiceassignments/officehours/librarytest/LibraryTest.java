package com.cybertek.practiceassignments.officehours.librarytest;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.LibraryUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class LibraryTest extends TestBase {

    @Test
    public void linkVerificationTest() {

        LibraryUtilities.loginToLibrary(driver);
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total of links in this page = " + links.size());
        int linkCount = 1;
        for (WebElement each : links) {
            System.out.println("Link " + linkCount + " " + each.getText());
            linkCount++;

        }
    }
}








