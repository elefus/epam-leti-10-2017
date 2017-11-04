package com.epam.jf.volkov.homework;

/**
 * На вход программе подается несколько строк (через параметры командной строки args).
 * Требуется упорядочить и вывести строки в порядке возрастания значений их длины.
 * В случае, если длины строк совпадают - упорядочить их в лексикографическом порядке.
 */
public class Task6 {

    /**
     * @param args анализируемые строки.
     */
    public static void main(String[] args) {
        // TODO решение задачи
    }

    private static boolean compareLexic (String compared, String another) {
        /**
         * @param compared первая сравниваемая строка
         * another вторая сравниваемая срока
         */
    }

    private static void swap (String[] array, int firstIndex, int secondIndex) {
        String temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}
