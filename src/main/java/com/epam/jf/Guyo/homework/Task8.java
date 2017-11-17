package com.epam.jf.Guyo.homework;

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

    private static boolean isPalindrome(String args){
        StringBuilder reverseInputString = new StringBuilder(args);
        reverseInputString = reverseInputString.reverse();
        return  reverseInputString.toString().equals(args);
    }

    private static boolean isNumeric(String s){
        return s != null && s.matches("\\d+");
    }

    /**
     * @param args анализируемые строки.
     */
    public static void main(String[] args) {
        int indexCounter = 0;
        int index = 0;
        for (int i = 0; i < args.length ; i++) {
            if((indexCounter < 2) && isPalindrome(args[i]) && isNumeric(args[i])) {
                indexCounter++;
                index = i;
            }
        }
        if (indexCounter == 0) {
            System.out.println("There are no any palindromes.");
        }
        else {
            System.out.println("Palindrome is " + args[index]);
        }
    }
}