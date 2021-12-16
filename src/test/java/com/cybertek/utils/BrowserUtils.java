package com.cybertek.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class BrowserUtils {

    public static void  sleep(int seconds)  {

        /**
         * this method is used to pause the code for given seconds
         * It is static method so we can call:
         * BrowserUtils.sleep(5)
         */
        try{
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){
            e.printStackTrace();
            System.out.println("Exception happened in sleep method");
        }


    }
    /**
     * @param pixel
     * scroll down by pixel
     */
    public static void scrollDown (int pixel) {
        //Casting the webDiver to JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        //Scroll down until the given pixel reached
        js.executeScript("window.scrollBy(0," + pixel + ")");
    }

    /**
     * @param elem
     * scroll down by gieen element
     */
    public static void scrollDown (WebElement elem) {
        //Casting the webDiver to JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        //Scroll down until the given element found
        js.executeScript("arguments[0].scrollIntoView(true)", elem);

    }
}
