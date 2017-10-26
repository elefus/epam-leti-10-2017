package com.gubadev.task1p1;

public class Runners {

    public static void main(String... args) {
        String[] names = {"Elena", "Thomas", "Hamilton", "Suzie", "Phil",
                "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily",
                "Daniel", "Neda", "Aaron", "Kate"};

        int[] times = {341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265};

        if (names.length != times.length) {
            System.err.println("Разные длины масивом(возможно не для всех участников" +
                    " есть время или не у каждого времени есть участник)");
            return;
        }

        int numOfSportsmens = names.length;
        int firstPlaceTime = Integer.MAX_VALUE;
        int secondPlaceTime = Integer.MAX_VALUE;
        int firstPlacePosition = 0;
        int secondPlacePosition = 0;
        for (int i = 0; i < numOfSportsmens; i++) {
            if (times[i] < secondPlaceTime) {
                if (times[i] < firstPlaceTime) {
                    firstPlaceTime = times[i];
                    if(firstPlacePosition != secondPlacePosition){
                        secondPlaceTime = firstPlaceTime;
                        secondPlacePosition = firstPlacePosition;
                    }
                    firstPlacePosition = i;
                } else {
                    secondPlaceTime = times[i];
                    secondPlacePosition = i;
                }
            }
        }
        System.out.println("Первое мето: " + names[firstPlacePosition] + " - " + times[firstPlacePosition]);
        System.out.println("Второе место:" + names[secondPlacePosition] + " - " + times[secondPlacePosition]);
    }
}
