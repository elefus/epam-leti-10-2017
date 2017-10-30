package com.epam.jf.Kuchinskii.homework;

public class Task1 {
    public static void main(String[] args) {
        String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate" };
        int[] times = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265 };

        int first = times[0];
        int second = 0;
        int firstIndex = 0;
        int secondIndex = 0;

        for (int i = 0; i < times.length; i++) {
            if (times[i] < first)
            {
                second = first;
                secondIndex = firstIndex;
                first  = times[i];
                firstIndex = i;
            }
        }
        System.out.println("First place: " + names[firstIndex] + ", time: " + first);
        System.out.println("Second place: " + names[secondIndex] + ", time: " + second);
    }
}
