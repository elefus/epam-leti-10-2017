package com.epam;

public class Task2 {
    public static void main(String[] args) {
        String max = null;
        String min = null;
        for (String str : args) {
            if (max == null || str.length() >= max.length()) {
                max = str;
            }
            if (min == null || str.length() <= min.length()) {
                min = str;
            }
        }
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }
}