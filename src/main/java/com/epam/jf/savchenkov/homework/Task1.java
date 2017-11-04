package com.epam.jf.savchenkov.homework;

/**
 * №1.
 * Группа людей участвует в марафоне, их имена и время за которое они пробежали марафон представленны в массиве.
 * Необходимо найти человека, который быстрее всех пробежал дистанцию и вывести его имя и счет.
 *
 * (Опционально) Найти человека, который прибежал вторым.
 */

public class Task1 {

    public static void main(String[] args) {

        String[] names = {"Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John",
                "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate"};
        int[] times = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};

        int first = times.length - 1;
        int second = times.length - 2;

        if (second < first) {
            int temp = first;
            first = second;
            second = first;
        }

        for (int i = 0; i < times.length; i++) {
            if(times[i] < times[first]) {
                second = first;
                first = i;
            }
            else if(times[i] < times[second])
                second = i;
        }

        System.out.println("First is " + names[first] + " with " + times[first]);
        System.out.println("Second is " + names[second] + " with " + times[second]);
    }
}
