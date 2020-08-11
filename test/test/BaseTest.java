/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package test;

/**
 *
 * @author namnh16
 */
public class BaseTest {

    public static void main(String[] args) {
        int retry = 5;
        String eCode = "A";

        while (!change(eCode).equals("SUCCESS") && retry > 0) {
            System.out.println(eCode + " " + retry);
            retry--;
        }
    }

    private static String change(String a) {
        System.out.println("called");
        a = "B";
        return a;
    }
}
