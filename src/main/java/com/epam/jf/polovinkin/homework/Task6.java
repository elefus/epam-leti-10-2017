package com.epam.jf.polovinkin.homework;

import java.util.Arrays;
import java.util.Comparator;

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
        Arrays.stream(args).sorted((a, b) -> a.length() == b.length() ? a.compareTo(b) : Integer.compare(a.length(), b.length())).forEach(System.out::println);
    }
}
