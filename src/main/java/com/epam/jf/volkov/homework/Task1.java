package com.epam.jf.volkov.homework;

public class Task1 {
    public static void main(String...args) {
        String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate" };
        int[] times = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265 };
        int first = 0;
        int second = 0;
        System.out.println("Results: \n");
        for (int i = 0;i<times.length;i++) {
            if (times[i]<times[second]) {
                second = i;
                if (times[second]<times[first]) {
                    int temp = first;
                    first = second;
                    second = temp;
                }
            }
        }
        System.out.println("First:\t"+names[first]+" with result "+times[first]);
        System.out.println("Second:\t"+names[second]+" with result "+times[second]);
    }
}