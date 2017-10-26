package main.java.com.epam.jf.savchenkov.homework.task2;

/**
 * №1.
 * Группа людей участвует в марафоне, их имена и время за которое они пробежали марафон представленны в массиве.
 * Необходимо найти человека, который быстрее всех пробежал дистанцию и вывести его имя и счет.
 *
 * (Опционально) Найти человека, который прибежал вторым.
 */

public class Main {

    public static void main(String[] args) {
        String[] names = {"Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John",
                "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate"};
        int[] times = {341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265};

        int first = times.length - 1, second = times.length - 1;

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
