package com.epam.jf.polovinkin.homework;

import java.util.Arrays;

/**
 * На вход программе подается несколько строк (через параметры командной строки args).
 * Каждая строка представляет собой одно слово.
 * В результате выполнения в выходной поток должно быть выведено количество слов,
 * состоящих только из символов латинского алфавита и содержащих равное количество гласных и согласных букв.
 *
 * Количество различных вхождений одной буквы в слове учитывается.
 *
 * Входные данные:
 * args = ["Язык", "программирования", "Java", "is", "widespread"]
 *
 * Выходные данные:
 * 2
 */
public class Task5 {

    private static int vowels(String str) {
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                counter++;
            }
        }
        return counter;
    }

    /**
     * @param args анализируемые строки.
     */
    public static void main(String[] args) {
        //feels good m8

        System.out.println(Arrays.stream(args)
                .filter(a -> a.matches("\\w+"))
                .filter(a -> vowels(a) == (a.length() - vowels(a)))
                .count());
    }
}
