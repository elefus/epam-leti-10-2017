package com.epam.jf.ilyinykh.homework;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

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
        System.out.println("Args: " + Arrays.toString(args));
        Arrays.sort(args, (o1, o2) -> o1.length() == o2.length() ? o1.compareTo(o2) : Integer.compare(o1.length(), o2.length()));
        System.out.println("After: " + Arrays.toString(args));
    }
}
