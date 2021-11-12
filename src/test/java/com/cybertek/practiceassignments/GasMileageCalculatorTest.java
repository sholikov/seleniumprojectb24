package com.cybertek.practiceassignments;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GasMileageCalculatorTest {
     public static void main(String []args) throws InterruptedException {
         String url  = "https://www.calculator.net";
         WebDriver driver = WebDriverFactory.getDriver("chrome");
         driver.manage().window().maximize();
         driver.get(url);
         WebElement searchBox = driver.findElement(By.cssSelector("input[type='text']"));
         searchBox.sendKeys("gas mileage");
         driver.findElement(By.xpath("//a[.='Gas Mileage Calculator']")).click();
         //On Next page verify:
         //o Title equals: “Gas Mileage Calculator”
         //o “Gas Mileage Calculator” label is displayed
         String currentTitle  = driver.getTitle();
         System.out.println(currentTitle.equals("Gas Mileage Calculator")? "Title Matched": "Title didn't match");
         
         //String header = driver.findElement(By.tagName("h1")).getText();
         //System.out.println("header = " + header);
         WebElement header = driver.findElement(By.tagName("h1"));
         System.out.println(header.isDisplayed());

        // Locate, clear and type “7925” into “Current odometer” field


         List<WebElement> inputFields = driver.findElements(By.cssSelector("input[type='text'"));
  /*       String [] numbers ={ "7925","7550","16","3.55"};
         for (int i=; i<4; i++) {
             inputField.get(i).clear();
             inputField.get(i).sendKeys(numbers[i]);

         }
   */
         Thread.sleep(1234);
         WebElement curOdField = driver.findElement(By.id("uscodreading"));
         curOdField.clear();
         curOdField.sendKeys("7925");

         WebElement prevOdField = driver.findElement(By.id("uspodreading"));
         prevOdField.clear();
         prevOdField.sendKeys("7550");

         WebElement gasPutField = driver.findElement(By.id("usgasputin"));
         gasPutField.clear();
         gasPutField.sendKeys("16");

         WebElement gasPriceField = driver.findElement(By.id("usgasprice"));
         gasPriceField.clear();
         gasPriceField.sendKeys("3.55");



         driver.findElement(By.xpath("//input[@value='Calculate']")).click();
         WebElement result = driver.findElement(By.tagName("h2"));
         String calResult = result.getText();
         System.out.println(calResult);
         String digits = driver.findElement(By.xpath("//b[.='23.44 mpg']")).getText();
         System.out.println(digits);


     }
}
