package com.cybertek.tests.day16_download_upload_JS_executor;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class FileDownloadTest extends TestBase {

    @Test
    public void fileDownloadTest() throws IOException {
//
        //  Driver.getDriver()  --> this one way
        //we inheriting from TestBase  parent class
        // navigate to download page,.Reading url from properties file
        driver.get(ConfigurationReader.getProperty("download.url"));
        WebElement someFileDownload = driver.findElement(By.linkText("some-file.txt"));
        someFileDownload.click();

        BrowserUtils.sleep(2);

        //verify that file is downloaded
        String filePath = System.getProperty("user.home") + "/Downloads/some-file.txt";
        // File file =  new File(System.getProperty("user.home") + "Downloads/some-file.txt");
        System.out.println("filePath = " + filePath);

        File file = new File(filePath);
        System.out.println("File exist = " + file.exists());

        Assert.assertTrue(file.exists(), "File download failed");
    }
}
    // delete downloaded file
 //   file.delete();


    // when it takes too long to download then we put sleep inside loop
 //   while(!file.exists()){

//BrowserUtils.sleep(1);

//}


