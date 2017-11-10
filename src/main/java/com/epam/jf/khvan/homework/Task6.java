package com.epam.jf.khvan.homework;

/**
 * На вход программе подается несколько строк (через параметры командной строки args).
 * Требуется упорядочить и вывести строки в порядке возрастания значений их длины.
 * В случае, если длины строк совпадают - упорядочить их в лексикографическом порядке.
 */
public class Task6 {
    public static void main(String[] args) {
        // TODO решение задачи
        for (int i = 0; i < args.length-1; i++) {
            for ( int j = i+1; j < args.length; j++){
                if ( args[i].length() > args[j].length()){
                    String min = args[i];
                    args[i] = args[j];
                    args[j] = min;
                }
                if ( args[i].length() == args[j].length()){
                    if ( args[i].compareTo(args[j]) > 0 ){
                        String min = args[i];
                        args[i] = args[j];
                        args[j] = min;
                    }
                }
            }
        }
        for (String word: args) {
            System.out.println(word);
        }
    }
}

