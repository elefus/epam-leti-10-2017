package com.epam.jf.vasiliev.homework;

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
    public static void main(String... args) {
        Arrays.sort(args, (o1, o2) -> o1.length() == o2.length()
                ? o1.compareTo(o2)
                : Integer.compare(o1.length(), o2.length()));

        for (String crt : args) {
            System.out.println(crt);
        }
    }
}
