package com.epam.jf.savchenkov.homework;


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
        if (args.length > 0) {
            Arrays.sort(args, new Comparator<String>() {
                @Override
                public int compare(String str1, String str2) {
                    int lenStr1 = str1.length();
                    int lenStr2 = str2.length();
                    return (lenStr1 == lenStr2) ? str1.compareTo(str2)
                                                : Integer.compare(lenStr1,lenStr2);
                }
            });
            for (String word : args) {
                System.out.println(word);
            }
        }

    }
}