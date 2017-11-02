package com.epam.jf.bavtovich.homework;

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
        if (args.length != 0) {
            Arrays.sort(args, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    Integer lenFirst = o1.length();
                    Integer lenSecond = o2.length();
                    return lenFirst.equals(lenSecond) ? o1.compareTo(o2) : lenFirst.compareTo(lenSecond);
                }
            });
            for (String word : args) {
                System.out.print(word + ' ');
            }
        }
    }
}
