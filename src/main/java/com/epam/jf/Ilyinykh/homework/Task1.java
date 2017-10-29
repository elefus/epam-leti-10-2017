package com.epam.jf.ilyinykh.homework;

public class Task1 {
    public static void main(String[] args) {
        String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate" };
        int[] times = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265 };
        int first = findWithout(times, -1);
        int second = findWithout(times, first);
        System.out.println("First: " + names[first]);
        System.out.println("Second: " + names[second]);
    }

    public static int findWithout(int[] times, int index) {
        int answer = 0;
        for (int i = 0; i < times.length; i++) {
            if (times[answer] > times[i] && i != index) {
                answer = i;
            }
        }
        return answer;
    }
}