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
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int iMin = -1, iMax = -1;
        for (int i = 0; i < args.length; i++) {
            int len = args[i].length();
            if (iMin == -1 || min >= len) {
                min = len;
                iMin = i;
            }
            if (iMax == -1 || max <= len) {
                max = len;
                iMax = i;
            }
        }

        if (iMin != -1 && iMax != -1) {
            System.out.println("Минимальная строка среди представленных: " + args[iMin]);
            System.out.println("Максимальная строка среди представленных: " + args[iMax]);
        }

    }
}
