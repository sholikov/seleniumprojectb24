package com.cybertek.practiceassignments;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasicLoginAuthentication {
    public static void main(String[] args) {
    /*
    Test Case 1:
    Basic login authentication
    - Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    - Verify title equals: String expectedTitle = "Web Orders Login"
    - Enter username: Tester
    - Enter password: test
    - Click “Sign In” button
    - Verify title equals: String expectedHomePageTitle = "Web Orders"

    Test Case 2:
After login
 - click on Check All button
 - verify that all check buttons are selected
 - click on Uncheck All button
 - verify that all buttons are unchecked
 - select one of the check box and delete that row
 - verify that row of information is deleted
     */


        String url = "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        // wait  upto 10 seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

        List<WebElement> info = driver.findElements(By.className("txt"));
        String[] credentials = {"Tester", "test"};
        for (int i = 0; i < 2; i++) {
            info.get(i).sendKeys(credentials[i]);
        }
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();
        String expectedTitle = "Web Orders";
        if (expectedTitle.equals(driver.getTitle())) {
            System.out.println("Passed");
        }

        WebElement checkAll = driver.findElement(By.linkText("Check All"));
        checkAll.click();
        List<WebElement> checkBox = driver.findElements(By.xpath("//input[@type='checkbox']"));
        System.out.println(checkBox.size());
        int count = 0;
        int count2 = 0;
        for (WebElement box : checkBox) {
            if (box.isSelected()) ;
            count++;
        }
        if (count == checkBox.size()) {
            System.out.println("All checkboxes are checked");
        }
        WebElement unCheckAll = driver.findElement(By.linkText("Uncheck All"));
        unCheckAll.click();
        List<WebElement> unCheckBox = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement box : unCheckBox) {
            if (box.isSelected()) {
                System.out.println("Check boxes are still selected");
            }
        }
        System.out.println("All checkboxes are unchecked");

        WebElement oneBox = driver.findElement(By.name("ctl00$MainContent$orderGrid$ctl02$OrderSelector"));
        oneBox.click();
        driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();
        List<WebElement> checkBox1 = driver.findElements(By.xpath("//input[@type='checkbox']"));
        System.out.println(checkBox1.size());




    }}



