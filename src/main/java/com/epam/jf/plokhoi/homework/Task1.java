package com.epam.jf.plokhoi.homework;

import java.util.Arrays;

public class Task1 {

    /**
     * Группа людей участвует в марафоне, их имена и время за которое они пробежали марафон представленны в массиве.
     * Необходимо найти человека, который быстрее всех пробежал дистанцию и вывести его имя и счет.
     * (Опционально) Найти человека, который прибежал вторым.
     */
    public static void main(String...args) {
        String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate" };
        int[] times = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265 };

        usingFori(names, times);
        usingSort(names, times);
    }

    private static void usingFori(String[] names, int[] times) {
        int first = 0;
        int second = 0;

        for (int i = 1; i < times.length; ++i) {
            if (times[first] > times[i]) {
                second = first;
                first = i;
            } else if (times[second] > times[i]) {
                second = i;
            }
        }

        System.out.println("1 place: " + names[first] + " with time " + times[first]);
        System.out.println("2 place: " + names[second] + " with time " + times[second]);
    }

    private static void usingSort(String[] names, int[] times) {
        Record[] records = new Record[times.length];
        for (int i = 0; i < times.length; ++i) {
            records[i] = new Record(names[i], times[i]);
        }
        Arrays.sort(records);
        System.out.println("1 place: " + records[0]);
        System.out.println("2 place: " + records[1]);
    }

    static class Record implements Comparable<Record> {

        private final int time;
        private final String name;

        Record(String name, int time) {
            this.name = name;
            this.time = time;
        }

        @Override
        public int compareTo(Record other) {
            return Integer.compare(time, other.time);
        }

        @Override
        public String toString() {
            return name + " with time " + time;
        }
    }
}
