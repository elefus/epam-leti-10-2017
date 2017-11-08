package com.epam.jf.Guyo.homework;

public class Task2 {

    public static void main(String[] args) {

        String minString = args[0];
        String maxString = args[0];

        for (String i: args) {
            if (i.length() <= minString.length()) {
                minString = i;
            }
            if (i.length() >= maxString.length()) {
                maxString = i;
            }
        }
        System.out.println("Min string is " + minString);
        System.out.println("Max string is " + maxString);
    }
}
