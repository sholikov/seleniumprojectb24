package com.cybertek.tests.day15_properties_driverutil_testbase;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileTest {
    @Test
    public void readValuesFromPropertiesFile() throws IOException {
        // Properties class  comes from java libraries
        Properties props = new Properties();

        // open file using FileInputStream
        FileInputStream fis = new FileInputStream("configuration");

        //load file content into properties object
        props.load(fis);

        System.out.println(props.getProperty("browser"));

    }
}
