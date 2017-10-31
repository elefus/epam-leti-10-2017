package com.epam.jf.khvan.homework;

import java.util.ArrayList;
import java.util.List;


public class Solution {
    public static void main(String[] args) {
        String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate" };
        int[] times = { 200, 199, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265 };
        int first = 0;
        int second = 1;

        for(int i = 1; i < times.length; i++) {
            if (times[i] < times[first] ) {
                int y=first;
                first = i;
                second=y;
            }
            if (times[i] < times[second] & times[i] > times[first]) {
                second = i;
            }
        }
        System.out.println("First: Name:" + names[first] + " Time:" + times[first]);
        System.out.println("Second: Name:" + names[second] + " Time:" + times[second]);
    }
}





