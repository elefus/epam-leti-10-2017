package com.epam.jf.kuchinskii.homework;

import java.util.Arrays;
import java.util.Comparator;

/**
 * На вход программе подается несколько строк (через параметры командной строки args).
 * Требуется упорядочить и вывести строки в порядке возрастания значений их длины.
 * В случае, если длины строк совпадают - упорядочить их в лексикографическом порядке.
 */
public class Task6 {

    public static void main(String[] args) {
        System.out.println("Упорядоченные строки:");
        Arrays.sort(args, Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()));
        System.out.println(Arrays.toString(args));
    }

}
