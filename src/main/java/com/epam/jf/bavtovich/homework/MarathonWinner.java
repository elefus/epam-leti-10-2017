package com.epam.jf.bavtovich.homework;

public class MarathonWinner {

    public static void main(String...args) {

        String[] names = {"Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma",
                "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate"};
        int[] times = {341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265};
        int maxTimeIndex = 0;
        int secondTimeIndex = 0;

        for (int i = 1; i < names.length; i++) {

            if (times[i] > times[maxTimeIndex]) {
                secondTimeIndex = maxTimeIndex;
                maxTimeIndex = i;
            }
            else {
                if (times[i] > times[secondTimeIndex]) {
                    secondTimeIndex = i;
                }
            }
        }

        System.out.println("Winner of marathon: " + names[maxTimeIndex]);
        System.out.println("Second place: " + names[secondTimeIndex]);
    }
}
