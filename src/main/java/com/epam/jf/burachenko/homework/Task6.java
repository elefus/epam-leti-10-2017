package com.epam.jf.burachenko.homework;

import java.util.Arrays;

/**
 * На вход программе подается несколько строк (через параметры командной строки args).
 * Требуется упорядочить и вывести строки в порядке возрастания значений их длины.
 * В случае, если длины строк совпадают - упорядочить их в лексикографическом порядке.
 */
public class Task6 {
    /**
     * Метод сравнивает одинаковые по длине строки по лексикографическому признаку
     * @param s1 первая сравниваемая строка
     * @param s2 вторая сравниваемая строка
     * @return true - s1 первее в лексикографическом порядке, чем s2
     *         false - s2 первее в лексикографическом порядке, чем s1, или s1 и s2 одинаковые строки
     */
    private static boolean isStringFirstInAlphabet(String s1, String s2) {
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                return isLetterFirstInAlphabet(s1.charAt(i), s2.charAt(i));
            }
        }
        return false;
    }

    /**
     * Метод сравнивает символы по лексикографическому признаку
     * @param ch1 первый символ
     * @param ch2 вторая символ
     * @return true - ch1 первее в лексикографическом порядке, чем ch2
     *         false - ch2 первее в лексикографическом порядке, чем ch1
     */
    private static boolean isLetterFirstInAlphabet(char ch1, char ch2) {
        if(ch1 >= 'a' && ch1 <= 'z' && ch2 >= 'A' && ch2 <= 'Z') {
            return ch1 < ch2+32;
        }
        else if(ch1 >= 'A' && ch1 <= 'Z' && ch2 >= 'a' && ch2 <= 'z') {
            return ch1 <= ch2-32;
        }
        else {
            return ch1 < ch2;
        }
    }


    /**
     * @param args анализируемые строки.
     */
    public static void main(String[] args) {
        // TODO решение задачи
        String temp;
        for(int i = 0; i < args.length-1; i++) {
            for(int j = i+1; j < args.length; j++) {
                if(args[j].length() < args[i].length() || args[j].length() == args[i].length() && isStringFirstInAlphabet(args[j], args[i])) {
                    temp = args[j];
                    args[j] = args[i];
                    args[i] = temp;
                }
            }
        }

        for(String word: args) {
            System.out.println(word);
        }
    }
}

