package com.epam.jf.vasiliev.homework;

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

    private static final long VOWEL_MASK = 0b0000000100010000010000010001000100000001000100000100000100010001L;
    private static final long CONSONANT_MASK = 0b0000001011101111101111101110111000000010111011111011111011101110L;

    /**
     * @param args анализируемые строки.
     */
    public static void main(String[] args) {
        int result = 0;

        for (String ctr : args) {
            if(isAppropriateWord(ctr)) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static boolean isAppropriateWord(String word) {
        int vowelCtr = 0;
        int consonantCtr = 0;

        for (int i = 0; i < word.length(); i++) {
            char crtChar = word.charAt(i);
            if(crtChar < 'A' || crtChar > 'z' || crtChar > 'Z' && crtChar < 'a') {
                return false;
            }

            if((VOWEL_MASK &  (1L << crtChar - 'A')) != 0) {
                vowelCtr++;
            } else if ((CONSONANT_MASK & (1L << crtChar - 'A')) != 0) {
                consonantCtr++;
            }
        }

        return vowelCtr == consonantCtr;
    }
}

