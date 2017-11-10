package com.epam.jf.polovinkin.homework;

public class Task1 {

    /**
     * Группа людей участвует в марафоне, их имена и время за которое они пробежали марафон представленны в массиве.
     * Необходимо найти человека, который быстрее всех пробежал дистанцию и вывести его имя и счет.
     * (Опционально) Найти человека, который прибежал вторым.
     */
    public static void main(String...args) {
        String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate" };
        int[] times = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265 };

        int top1;
        int top2;
        if (times[0] < times[1]){
            top1 = 0;
            top2 = 1;
        } else {
            top1 = 1;
            top2 = 0;
        }
        for(int i = 2; i < names.length; i++) {
            if  (times[i] < times[top1]) {
                top2 = top1;
                top1 = i;
            } else if (times[i] < times[top2]) {
                top2 = i;
            }
        }
        System.out.println(names[top1] + ' ' + times[top1]);
        System.out.println(names[top2] + ' ' + times[top2]);
    }
}
