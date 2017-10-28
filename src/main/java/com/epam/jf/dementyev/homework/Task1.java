package com.epam.jf.dementyev.homework;

/**
 * Группа людей участвует в марафоне, их имена и время за которое они пробежали марафон представленны в массиве.
 * Необходимо найти человека, который быстрее всех пробежал дистанцию и вывести его имя и счет.
 * (Опционально) Найти человека, который прибежал вторым.
 */

public class Task1 {

    public static void main(String[] args) {
        String[] names = {"Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James",
                "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate"};
        int[] times = {341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265};

        int min1 = 0, min2 = 0;
        for (int i = 1; i < times.length; i++) {
            if (times[min1] > times[i]) {
                min2 = min1;
                min1 = i;
            } else if (times[min2] > times[i]) {
                min2 = i;
            }
        }

        System.out.println(names[min1] + ": " + times[min1]);
        System.out.println(names[min2] + ": " + times[min2]);
    }
}
