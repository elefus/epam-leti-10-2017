package com.epam.jf.bavtovich.homework;

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
        if (args.length > 0) {
            int cnt = 0;
            String polyndrome = null;

            for (String word: args) {
                anotherword:
                if (isNumber(word)) {
                    int i;
                    int j;
                    for (i = 0, j = word.length() - 1; i <= j; i++, j--) {
                        if (word.charAt(i) != word.charAt(j)) {
                            break anotherword;
                        }
                    }

                    cnt++;
                    polyndrome = word;
                    if (cnt == 2) {
                        break;
                    }
                }
            }
            System.out.println(polyndrome);
        }
    }

    /**
     *
     * @param word анализируемое слово
     * @return true, если слово состоит из цифр, иначе - false
     */
    private static boolean isNumber(String word) {
        for (int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) >= 57 || word.charAt(i) <= 48) {
                return false;
            }
        }
        return true;
    }
}