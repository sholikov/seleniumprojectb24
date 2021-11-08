package com.cybertek.practiceassignments;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginTest {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        WebDriverFactory.windowManager(driver);
        String url  = "https://www.phptravels.net";
        driver.get(url);

        String email ="valeje4198@cyadp.com";
        String password = "B24Feb2022!";

        WebElement signup = driver.findElement(By.linkText("Login"));
        signup.click();
        WebElement emailField =driver.findElement(By.name("email"));
        emailField.sendKeys(email);
        WebElement passField = driver.findElement(By.name("password"));
        passField.sendKeys(password);

        driver.findElement(By.xpath("//button[@type='submit']")).click();
       // driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebElement wlmMsg = driver.findElement(By.tagName("h2"));
        wlmMsg.getText();
        String expectedName = "Mike";
        if(wlmMsg.isDisplayed()){
            System.out.println("Verification Passed");
        }else{
            System.out.println("Failed");
        }
        driver.quit();
    }
}
