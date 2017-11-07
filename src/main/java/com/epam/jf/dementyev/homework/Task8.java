package com.epam.jf.dementyev.homework;

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
        String palindrome = null;
        int count = 0;
        for (String word : args) {
            if (isPalindrome(word)) {
                palindrome = word;
                count++;
                if (count == 2) {
                    break;
                }
            }
        }

        if (palindrome != null) {
            System.out.println(palindrome);
        }
    }

    private static boolean isPalindrome(String word) {
        int len = word.length();
        int start = (word.charAt(0) == '-' || word.charAt(0) == '+') ? 1 : 0;
        int end = len - 1;
        for (; start <= end; start++, end--) {
            char c1 = word.charAt(start);
            char c2 = word.charAt(end);
            if (!Character.isDigit(c1) || !Character.isDigit(c2) || c1 != c2) {
                return false;
            }
        }
        return true;
    }
}
