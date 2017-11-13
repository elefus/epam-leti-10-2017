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

    private static final long VOWEL_MASK = 76_632_734_953_390_353L;
    private static final long CONSONANT_MASK = 211_597_636_970_462_958L;

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
            if(crtChar < 'A' || crtChar > 'z') {
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

