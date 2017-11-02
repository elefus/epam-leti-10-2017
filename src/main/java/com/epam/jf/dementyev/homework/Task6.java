package com.epam.jf.dementyev.homework;

import java.util.Arrays;

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
        if (args.length > 0) {
            Arrays.sort(args, (s1, s2) -> {
                    if (s1 == null && s2 == null) {
                        return 0;
                    } else if (s1 == null) {
                        return 1;
                    } else if (s2 == null) {
                        return -1;
                    } else if (s1.length() != s2.length()) {
                        return s1.length() - s2.length();
                    } else {
                        return s1.compareTo(s2);
                    }
                }
            );
            System.out.println(Arrays.toString(args));
        }
    }
}