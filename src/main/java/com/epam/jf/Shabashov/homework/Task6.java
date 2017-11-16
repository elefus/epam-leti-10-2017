package com.epam.jf.Shabashov.homework;

import org.jetbrains.annotations.NotNull;

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
        Arrays.sort(args,new StringComparator());
        for (String line :args) {
            System.out.println(line);
        }
    }
}
class StringComparator implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        if (left.length()==right.length()){
            return left.compareTo(right);
        }
        return Integer.compare(left.length(),right.length());
    }
}