package com.epam.jf.kuchinskii.homework;

import java.util.ArrayList;
import java.util.Collections;

public class Task1 {
    public static void main(String[] args) {
        String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate" };
        int[] times = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265 };

        if (names.length > 0 && times.length > 0 && times.length == names.length) {
            ArrayList<Record> list = new ArrayList<>();
            for (int i = 0; i < times.length; i++) {
                list.add(new Record(times[i], names[i]));
            }
            Collections.sort(list);
            System.out.println("First place: " + list.get(0));
            if (names.length > 1) {
                System.out.println("Second place: " + list.get(1));
            }
        } else {
            System.out.println("Ошибка входных данных");
        }
    }
}

class Record implements Comparable<Record> {
    private int time;
    private String name;

    Record(int time, String name) {
        this.time = time;
        this.name = name;
    }

    @Override
    public int compareTo(Record r) {
        return Integer.compare(this.time, r.time);
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", Time: " + this.time;
    }
}
