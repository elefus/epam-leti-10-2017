package com.epam.jf.zakomornyy.homework;

public class Task1 {
    public static void main(String... args) {
        String[] names = {"Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel",
                "Neda", "Aaron", "Kate"};
        int[] times = {341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265};
        findFirstAndSecond(names, times);
    }

    public static void findFirstAndSecond(String[] names, int[] times) {
        if(names.length != times.length) {
            System.out.println("Numbers of names and times must be equal");
        }
        else {
            if(names.length >= 2) {
                int winner = 0, second = 1;
                if (times[0] > times[1]) {
                    winner = 1;
                    second = 0;
                }

                for (int i = 2; i < names.length; i++) {
                    if (times[winner] >= times[i]) {
                        second = winner;
                        winner = i;
                    } else if (times[second] >= times[i]) {
                        second = i;
                    }
                }
                System.out.println("Winner : " + names[winner] + "! Time : " + times[winner]);
                System.out.println("Second : " + names[second] + "! Time : " + times[second]);
            }
            else if(names.length == 1){
                System.out.println("Winner : " + names[0] + " time : " + times[0]);
            }
            else {
                System.out.println("Arrays are empty");
            }
        }
    }
}

