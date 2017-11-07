package com.epam.jf.khvan.homework;

import java.util.ArrayList;

/**
 * На вход программе подается несколько строк (через параметры командной строки args).
 * Каждая строка представляет собой одно слово.
 *
 * Помимо обычных слов, во входной последовательности могут встречаться целые числа.
 * Среди них необходимо найти число-палиндром (одинаково читающееся в обоих направлениях).
 * Если таких чисел больше одного, найти второе из них.
 *
 * Одна цифра является палиндромом.
 * Ограничения на размер числа нет.
 */
public class Task8 {
    /**
     * @param args анализируемые строки.
     */
    public static void main(String[] args) {
        int firstPalindrom = -1;
        int secondPalindroim = -2;
        int m = 0;
        boolean flag;
        for (String word: args) {
            flag = true;
            char [] charArray = word.toCharArray();
            for ( int i = 0; i < charArray.length; i++){
                if ( charArray[i] != charArray[charArray.length - 1 - i] || !(Character.isDigit(charArray[i])) ){
                    flag = false;
                }
            }
            if ( flag){
                m++;
                if ( firstPalindrom < 0) { firstPalindrom = Integer.parseInt(word);}
                if ( secondPalindroim < 0 & m == 2) { secondPalindroim = Integer.parseInt(word);}
            }
        }
        System.out.println(firstPalindrom);
        System.out.println(secondPalindroim);
    }
}
