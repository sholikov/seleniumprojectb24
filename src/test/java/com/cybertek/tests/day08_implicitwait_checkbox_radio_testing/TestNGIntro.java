package com.cybertek.tests.day08_implicitwait_checkbox_radio_testing;

import org.testng.annotations.Test;

public class TestNGIntro {

    @Test
    public void test1() {

        System.out.println("Hello World!");

    }

    @Test
    public void test2() {
        try {
            System.out.println(10 / 0);
        } catch (ArithmeticException e) {
            System.out.println("You cant divide by 0");
        }
    }
}
