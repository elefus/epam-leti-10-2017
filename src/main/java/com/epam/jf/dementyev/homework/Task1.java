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

        int[] index = new int[]{-1, -1};
        for (int i = 0; i < times.length; i++) {
            if (index[0] == -1 || times[index[0]] > times[i]) {
                index[1] = index[0];
                index[0] = i;
            } else if (index[1] == -1 || times[index[1]] > times[i]) {
                index[1] = i;
            }
        }

        if (index[0] != -1)
            System.out.println(names[index[0]] + ": " + times[index[0]]);
        if (index[1] != -1)
            System.out.println(names[index[1]] + ": " + times[index[1]]);
    }
}
