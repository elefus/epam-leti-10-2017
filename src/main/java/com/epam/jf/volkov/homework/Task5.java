package com.epam.jf.volkov.homework;

/**
 * На вход программе подается несколько строк (через параметры командной строки args).
 * Каждая строка представляет собой одно слово.
 * В результате выполнения в выходной поток должно быть выведено количество слов,
 * состоящих только из символов латинского алфавита и содержащих равное количество гласных и согласных букв.
 * <p>
 * Количество различных вхождений одной буквы в слове учитывается.
 * <p>
 * Входные данные:
 * args = ["Язык", "программирования", "Java", "is", "widespread"]
 * <p>
 * Выходные данные:
 * 2
 *
 * @author Anton Volkov aka thewalkingwind
 * @version 1.0.0
 */
public class Task5 {
    /**
     * @param args анализируемые строки.
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            int counter = 0;
            for (String word : args) {
                if (isInLatin(word) && countConsonants(word) == countVowels(word)) {
                    counter++;
                }
            }
            System.out.println(counter);
        } else {
            System.out.println("No args detected");
        }
    }

    /**
     * Анализ строки на символы латинского алфавита
     *
     * @param word Анализируемая строка
     * @return содержит ли переданная строка исключительно символы латинского алфавита
     */
    private static boolean isInLatin(String word) {
        for (char letter : word.toCharArray()) {
            if ((letter < 65 || letter > 90) && (letter < 97 || letter > 122)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Анализ строки на гласные
     *
     * @param word Анализируемая строка
     * @return Количество гласных латинских букв в анализируемой строке
     */
    private static int countVowels(String word) {
        char[] vowels = {65, 69, 73, 79, 85, 89}; //Y считается гласной буквой
        int counter = 0;
        for (char letter : word.toCharArray()) {
            for (char checked : vowels) {
                if (letter == checked || letter == checked + 32) {
                    counter++;
                }
            }
        }
        return counter;
    }

    /**
     * Анализ строки на согласные
     *
     * @param word Анализируемая строка
     * @return Количество согласных латинских букв в анализируемой строке
     */
    private static int countConsonants(String word) {

        char[] consonants = {66, 67, 68, 70, 71, 72, 74, 75, 76,
            77, 78, 80, 81, 82, 83, 84, 86, 87,
            88, 90}; //Y считается гласной буквой
        int counter = 0;
        for (char letter : word.toCharArray()) {
            for (char checked : consonants) {
                if (letter == checked || letter == checked + 32) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
