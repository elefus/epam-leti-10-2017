package main.java.com.epam.jf.savchenkov.homework;

/**
 *
 * №2.
 * На вход программе подается несколько строк (через параметры командной строки args).
 * Среди них необходимо найти и вывести на экран наибольшую и наименьшую по длине строки.
 * Если строк с одинаковой длиной несколько - вывести последнюю из них.
 * Длину строки можно получить вызвав метод .length() на объекте типа String.
 *
 * Входные данные:
 * a abc edf q
 *
 * Вывод:
 * Минимальная строка среди представленных: q
 * Максимальная строка среди представленных: edf
 */

public class Task2 {

    public static void main(String[] args) {
        String max = args[0], min = args[0];

        for (int i = 0; i < args.length; i++) {
            if(args[i].length() >= max.length())
                max = args[i];
            if(args[i].length() <= min.length())
                min = args[i];
        }

        System.out.println("Минимальная строка среди представленных: " + min);
        System.out.println("Максимальная строка среди представленных: " + max);
    }
}
