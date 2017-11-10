package com.epam.jf.ilyinykh.homework;

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

    /**
     * @param args анализируемые строки.
     */
    public static void main(String[] args) {
        int counter = 0;
        System.out.println("Arguments: " + Arrays.toString(args));
        for (String word : args) {
            if (isFits(word)) {
                counter++;
            }
        }

        System.out.println("Answer: " + counter);
    }

    /**
     * @param word слово для анализа.
     * @return подходит ли слово к требованиям задачи.
     */
    private static boolean isFits(final String word) {
        char[] letters = word.toCharArray();
        int numberOfConsonants = 0;
        int numberOfVowels = 0;

        for (char letter : letters) {
            if (Character.isLetter(letter)) {
                // Проверяем на гласность, т.к. их меньше.
                if (isVowel(letter)) {
                    numberOfVowels++;
                } else {
                    numberOfConsonants++;
                }
            } else {
                return false;
            }
        }

        return numberOfConsonants == numberOfVowels;
    }

    /**
     * @param letter букву для анализа.
     * @return является ли буква гласной.
     */
    private static boolean isVowel(final char letter){
        switch (letter) {
            case 'a':
            case 'A':

            case 'e':
            case 'E':

            case 'i':
            case 'I':

            case 'o':
            case 'O':

            case 'u':
            case 'U':

            case 'y':
            case 'Y':
                return true;
            default:
                return false;
        }
    }
}
