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
        int[] index = new int[]{-1, -1};
        for (int i = 0; i < args.length; i++) {
            int len = args[i].length();
            if (index[0] == -1 || min >= len) {
                min = len;
                index[0] = i;
            }
            if (index[1] == -1 || max <= len) {
                max = len;
                index[1] = i;
            }
        }

        if (index[0] != -1 && index[1] != -1) {
            System.out.println("Минимальная строка среди представленных: " + args[index[0]]);
            System.out.println("Максимальная строка среди представленных: " + args[index[1]]);
        }

    }
}
