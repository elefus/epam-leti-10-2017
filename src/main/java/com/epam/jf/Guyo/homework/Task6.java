package com.epam.jf.Guyo.homework;

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
        Arrays.sort(args, new StringLengthCompare());
        System.out.println(Arrays.toString(args));
    }
}

class StringLengthCompare implements Comparator<String> {

    public int compare(String str1, String str2){
        if (str1.length() == str2.length()){
            return str1.compareTo(str2);
        }
        else {
            return (str1.length() - str2.length());
        }
    }
}
