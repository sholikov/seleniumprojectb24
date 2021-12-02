package com.cybertek.tests.day12_windows_practice_faker;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerDemo {
    @Test
    public void demo(){
        //create Faker object

        Faker faker = new Faker();
        String fullName = faker.name().fullName();
        System.out.println("fullName = " + fullName);

        String city = faker.address().cityName();
        System.out.println("city = " + city);



    }
}
