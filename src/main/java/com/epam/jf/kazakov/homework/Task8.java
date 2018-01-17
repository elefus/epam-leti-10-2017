package com.epam.jf.kazakov.homework;

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

    private static String palindrome(String[] args) {
        int flag = 0;
        int index = 0;
        for (int i = 0; i < args.length; i++) {
            if (flag < 2) {
                if (args[i].matches("^[0-9]+")) {
                    StringBuilder sb = new StringBuilder(args[i]);
                    sb.reverse();
                    if (args[i].equals(sb.toString())) {
                        ++flag;
                        index = i;
                    }
                }
            }
            else {
                break;
            }
        }
        return (flag == 0) ? "такого числа нет" : args[index];
    }

    /**
     * @param args анализируемые строки.
     */
    public static void main(String[] args) {
        System.out.println("Число палиндром: " + palindrome(args));
    }
}
