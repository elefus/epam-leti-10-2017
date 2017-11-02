package com.epam.jf.guba.homework;

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
        if(args.length < 1){
            System.err.println("Недостаточно аргументов");
            return;
        }

        Arrays.sort(args);
        Arrays.sort(args, Comparator.comparingInt(String::length));

        for (String string : args){
            System.out.println(string);
        }
    }
}
