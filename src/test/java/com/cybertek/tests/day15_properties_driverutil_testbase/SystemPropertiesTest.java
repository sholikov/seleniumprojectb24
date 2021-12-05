package com.cybertek.tests.day15_properties_driverutil_testbase;

import org.testng.annotations.Test;

public class SystemPropertiesTest {

    @Test
    public void readingSystemProperties(){
        //os.name=Windows 10
        System.out.println("OS Name = " + System.getProperty("os.name"));
        System.out.println("User name = " + System.getProperty("user.name"));
        System.out.println("User dir = " + System.getProperty("user.dir"));

        System.out.println("Pon.xml path = " + System.getProperty("user.dir") + " /pom.xml");

        System.out.println("java version = " + System.getProperty("java.version"));

    }
}
