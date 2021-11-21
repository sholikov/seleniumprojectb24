package com.cybertek.tests.day09_testing_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGIntro {

    String url = "https://www.etsy.com";


    @BeforeClass// runs one time only
    public void setUp(){
        System.out.println("@BeforeClass set up method....");
        System.out.println("Opened browser and Navigating to " + url);
        System.out.println("====================================");
    }

    @BeforeMethod// runs after each method
    public void setUpApp(){
        System.out.println("@BeforeMethod setUpApp method is running .......");
        System.out.println("Navigating back to  " + url);
        System.out.println("=====================================");
    }

    @Test(priority = 1) //run first
    public void test1(){
        System.out.println("Running test......");
        int num = 10;
        Assert.assertEquals(10,num);// most common used
    }

    @Test(priority = 2) // runs second , converts regular to method to Test method
    public void myTest2(){
        System.out.println("Running Test");
        String name = "Bob";
        Assert.assertTrue(name.contains("o"));// most common used

    }
   @AfterMethod
    public void tearDown(){
        System.out.println("@AfterMethod tearDown is running...");
        System.out.println("=====================================");
    }

    @AfterClass
    public void cleanUp(){
        System.out.println("@AfterClass cleanUp is running .....");
        System.out.println("========================");
    }

}
