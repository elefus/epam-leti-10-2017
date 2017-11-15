package com.epam.jf.kruglik.homework;

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
        Arrays.sort(args, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                if (s.length() == t1.length()){
                    return s.compareTo(t1);
                } else{
                    return Integer.compare(s.length(),t1.length());
                }
            }
        });

        System.out.println(Arrays.toString(args));
    }
}