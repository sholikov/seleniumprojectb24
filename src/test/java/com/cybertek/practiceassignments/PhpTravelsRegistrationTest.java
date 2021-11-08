package com.cybertek.practiceassignments;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PhpTravelsRegistrationTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        WebDriverFactory.windowManager(driver);
         String url  = "https://www.phptravels.net";
         driver.get(url);

         String first = "Mike";
         String last = "Jones";
         String email ="valeje4198@cyadp.com";
         String password = "B24Feb2022!";

        WebElement signup = driver.findElement(By.linkText("Signup"));
        signup.click();
        WebElement firstname = driver.findElement(By.name("first_name"));
        firstname.sendKeys(first);
        WebElement lastname = driver.findElement(By.name("last_name"));
        lastname.sendKeys(last);
        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("7012054693");
        WebElement emailField =driver.findElement(By.name("email"));
        emailField.sendKeys(email);
        WebElement passField = driver.findElement(By.name("password"));
        passField.sendKeys(password);

       // Thread.sleep(4000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String currentTitle = driver.getTitle();
        System.out.println(currentTitle);
        String expectedTitle = "Login - PHPTRAVELS";

        if(currentTitle.equals(expectedTitle)){
            System.out.println("Verification is Passed");
        }else{
            System.out.println("Verification is Failed");
        }
        emailField.sendKeys(email);
        passField.sendKeys(password);

        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }
}
