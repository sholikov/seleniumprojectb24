package com.cybertek.tests.day16_download_upload_JS_executor;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FileUploadTest extends TestBase {
    @Test
    public void fileUploadTest(){
        driver.get(ConfigurationReader.getProperty("upload.url"));
        WebElement upload = driver.findElement(By.id("file-upload"));
        upload.sendKeys(System.getProperty("user.home") + "/Downloads/some-file.txt");

        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();


    }
}
