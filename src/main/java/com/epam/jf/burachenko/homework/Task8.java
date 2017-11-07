package com.epam.jf.burachenko.homework;

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

    private static boolean isPalindrome(String word) {
        int length = word.length();
        int border = (length%2 == 0) ? length/2 : length/2+1;
        for(int i = 0; i < border; i++) {
            if(!(word.charAt(i) == word.charAt(length-i-1) && word.charAt(i) >= '0' && word.charAt(i) <= '9')) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param args анализируемые строки.
     */
    public static void main(String[] args) {
        int countOfPalindromes = 0;
        String result = null;
        for (String word: args) {
            if(isPalindrome(word)) {
                countOfPalindromes++;
                result = word;
                if(countOfPalindromes == 2) {
                    break;
                }
            }
        }

        System.out.println(result);
    }
}
