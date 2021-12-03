package com.cybertek.tests.day13_faker_practice_browserutil_properties;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class RegistrationFormTest extends RegistrationFormTestBase {
    /*
    1. Open browser
2. Go to website: http://practice.cybertekschool.com/registration_form
3. Enter first name
4. Enter last name
5. Enter username
6. Enter email address
7. Enter password
8. Enter phone number
9. Select a gender from radio buttons
10.Enter date of birth
11.Select Department/Office
12.Select Job Title
13.Select programming language from checkboxes
14.Click to sign up button
15.Verify success message “You’ve successfully completed registration.” is
displayed.

}*/
    Faker faker = new Faker();

    @Test
    public void formTest(){
       WebElement firstName =  driver.findElement(By.name("firstname"));
       firstName.sendKeys(faker.name().firstName());

        WebElement lastName =  driver.findElement(By.name("lastname"));
        lastName.sendKeys(faker.name().lastName());

        enterUserName((faker.name().username().replace(".","")));

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys(faker.internet().emailAddress());

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys(faker.internet().password());

        WebElement phoneNumber = driver.findElement(By.name("phone"));
        phoneNumber.sendKeys(faker.phoneNumber().cellPhone().replace("(","").replace(")", "-").replace(".", ""));

        WebElement maleRadio = driver.findElement(By.xpath("//*[@value='male']"));
        maleRadio.click();

        WebElement dateOfBirth = driver.findElement(By.name("birthday"));
        dateOfBirth.sendKeys("01/01/1980");

        Select department = new Select(driver.findElement(By.name("department")));
        department.selectByIndex(faker.number().numberBetween(1,9));

        Select jobTitle = new Select(driver.findElement(By.name("job_title")));
        jobTitle.selectByIndex(faker.number().numberBetween(1,9));

        List<WebElement> languages = driver.findElements(By.xpath("//input[@class='form-check-input']"));
        System.out.println(languages.size());
        for (WebElement element : languages) {
            element.click();

        }
        driver.findElement(By.id("wooden_spoon")).click();

        WebElement heading = driver.findElement(By.tagName("h4"));

        Assert.assertEquals(heading.getText(),"Well done!");
        Assert.assertTrue(heading.isDisplayed());// it will assert only as displayed, it wont compare headings

    }
    public  void enterUserName(String userName){
        WebElement userNameField =  driver.findElement(By.name("username"));
        userNameField.sendKeys(userName);
    }
}
