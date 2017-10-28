package com.epam.jf.dementyev.homework;

/**
 * На вход программе подается несколько строк (через параметры командной строки args).
 * Среди них необходимо найти и вывести на экран наибольшую и наименьшую по длине строки.
 * Если строк с одинаковой длиной несколько - вывести последнюю из них.
 * Длину строки можно получить вызвав метод .length() на объекте типа String.
 * <p>
 * Входные данные:
 * a abc edf q
 * <p>
 * Вывод:
 * Минимальная строка среди представленных: q
 * Максимальная строка среди представленных: edf
 */

public class Task2 {

    public static void main(String[] args) {
        if (args.length > 0) {
            int min = args[0].length();
            int max = min;
            int iMin = 0;
            int iMax = 0;
            for (int i = 1; i < args.length; i++) {
                int len = args[i].length();
                if (min >= len) {
                    min = len;
                    iMin = i;
                }
                if (max <= len) {
                    max = len;
                    iMax = i;
                }
            }
            System.out.println("Минимальная строка среди представленных: " + args[iMin]);
            System.out.println("Максимальная строка среди представленных: " + args[iMax]);
        }
    }
}
