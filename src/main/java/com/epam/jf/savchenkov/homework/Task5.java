package com.epam.jf.savchenkov.homework;

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

    /**
     * @param args анализируемые строки.
     */
    public static void main(String[] args) {
        int counter = 0;
        for (String word : args) {
            if (isRightWord(word)) {
                ++counter;
            }
        }
        System.out.println(counter);
    }

    private static boolean isRightWord(String word) {
        String consonants = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
        String vowels = "aeiouAEIOU";

        int len = word.length();
        int diff = 0;

        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            if (consonants.indexOf(c) != -1) {
                ++diff;
            } else if (vowels.indexOf(c) != -1) {
                --diff;
            } else {
                return false;
            }
        }

        return diff == 0;
    }
}
