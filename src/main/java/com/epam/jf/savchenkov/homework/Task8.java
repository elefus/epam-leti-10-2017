package com.epam.jf.savchenkov.homework;

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
        int flag = 0;
        String answer = "No answer";
        for (String str: args) {
            if (str.matches("^[0-9]+")) {
                if (isPalindrome(str) && flag < 2) {
                    answer = str;
                    ++flag;
                }
            }
        }
        System.out.println(answer);
    }

    public static boolean isPalindrome(String str) {
        return str.equals(new StringBuilder().append(str)
                                             .reverse()
                                             .toString());
    }
}
