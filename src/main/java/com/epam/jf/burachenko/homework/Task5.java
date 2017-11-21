package com.epam.jf.burachenko.homework;

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
    private static final String vowels = "aeiouyAEIOUY";

    private static boolean isVowel(char ch) {
        for(int i = 0; i < vowels.length(); i++) {
            if(ch == vowels.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param args анализируемые строки.
     */
    public static void main(String[] args) {
        int countOfWords = 0;
        int countOfVowels;
        int countOfConsonants;
        for(String word: args) {
            if(word.length()%2 == 0) {
                countOfVowels = 0;
                countOfConsonants = 0;
                for(int i = 0; i < word.length(); i++) {
                    if(word.charAt(i) >= 'a' && word.charAt(i) <= 'z' || word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                        if(isVowel(word.charAt(i))) {
                            countOfVowels++;
                        }
                        else {
                            countOfConsonants++;
                        }
                    }
                    else {
                        break;
                    }
                }

                if(countOfVowels == countOfConsonants && countOfVowels+countOfConsonants == word.length()) {
                    countOfWords++;
                }
            }
        }

        System.out.println("Количество слов: " + countOfWords);
    }
}
