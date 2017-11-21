package com.epam.jf.Kazakov.homework;

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

    private static boolean isLatin(String args) {
        return args.matches("^[a-zA-Z]+$");
    }

    private static boolean isEqualVowelsAndConsonants (String args) {
        int vowels = 0;
        int consonants = 0;
        char[] stringToCharArray = args.toCharArray();
        for (char ch :
                stringToCharArray) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'y') {
                ++vowels;
            }
            else {
                ++consonants;
            }
        }
        return (vowels == consonants);
    }

    public static void main(String[] args) {
        int count = 0;
        for (String str :
                args) {
            if (isLatin(str) && isEqualVowelsAndConsonants(str)) {
                ++count;
            }
        }
        System.out.println("Количество слов, состоящих только из символов латинского алфавита и содержащих равное количество гласных и согласных букв: " + count);
    }
}