package com.cybertek.practiceassignments;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalculatorAddTest2 {
    public static void main(String[] args) throws InterruptedException {
        /*
        1) Add a class CalculatorAddTest
2) Declare variables String appUrl = “https://www.calculator.net”
int num1 = 5, num2 = 3
int expectedResult = 8
3) Launch selenium, maximize and navigate to the url
         */

        String appUrl ="https://www.calculator.net";
        int num1 = 128, num2 = 90;
        int expectedResult = 218;

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(appUrl);

        String numOne = "" + num1;
        String numTwo = "" + num2;

        for(int i=0; i<numOne.length();i++){

            driver.findElement(By.xpath("span[.='" + numOne.charAt(i)+"']")).click();
           // Thread.sleep(1234);

        }

    }
}
