package com.cybertek.tests.day19_page_object_model;

import com.cybertek.pages.BookManagementPage;
import com.cybertek.pages.LibraryLoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LibraryLoginPOMTest extends TestBase {
    @Test(priority = 2)
    public void invalidCredentialsTest(){
        driver.get(ConfigurationReader.getProperty("library.url"));
        // create object of LibraryLoginPage page object class
        LibraryLoginPage loginPage = new LibraryLoginPage();
        //access email WebElement and type the email
        loginPage.userEmail.sendKeys("invalid_email@gmail.com");
        loginPage.password.sendKeys("randompwd123");
        loginPage.signInBtn.click();

        Assert.assertTrue(loginPage.errorMsg.isDisplayed());

    }
    @Test(priority = 1)
    public void positiveLoginTest() {
        driver.get(ConfigurationReader.getProperty("library.url"));
        LibraryLoginPage loginPage = new LibraryLoginPage();
        loginPage.userEmail.sendKeys(ConfigurationReader.getProperty("library3.student.email"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("library3.student.password"));
        loginPage.signInBtn.click();

        // Book management page steps:
        BookManagementPage bookManagementPage = new BookManagementPage();


        Assert.assertTrue(bookManagementPage.bookMgmtHeader.isDisplayed());
        bookManagementPage.isCurrentPage();

    }
}
