package com.epam.jf.bavtovich.homework;

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
        if (args.length != 0) {
            int validWordsCounter = 0;
            int numVowels;
            int numConsonants;
            for (String word: args) {
                word = word.toLowerCase();
                if (isWordLatin(word)) {
                    numConsonants = 0;
                    numVowels = 0;
                    for (int i = 0; i < word.length(); i++) {
                        if (isLetterVowel(word.charAt(i))) {
                            numVowels++;
                        } else {
                            numConsonants++;
                        }
                    }
                    if (Integer.compare(numVowels, numConsonants) == 0) {
                        validWordsCounter++;
                    }
                }
            }
            System.out.println(validWordsCounter);
        }
    }

    /**
    * @param word
    * @return true, если слово состоит из латинских букв, иначе - false
    */
    private static boolean isWordLatin(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) < 97 || word.charAt(i) > 122) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param letter
     * @return true, если буква гласная, иначе - false
     */
    private static boolean isLetterVowel(char letter) {

        switch (letter) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'y':
                return true;
            default:
                return false;
        }
    }
}
