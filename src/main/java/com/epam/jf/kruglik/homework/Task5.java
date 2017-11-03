package com.epam.jf.kruglik.homework;

import java.util.Arrays;
import java.util.HashSet;

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
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('A','E','I','O','U','Y'));
        HashSet<Character> consonants = new HashSet<>(Arrays.asList('B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M',
                                                                    'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y',
                                                                    'Z'));
        Integer result = 0;
        Integer numbOfVowels = 0;
        Integer numbOfCons = 0;
        Boolean isLatinWord = true;
        for (String word : args) {
            for (Character letter : word.toUpperCase().toCharArray()) {
                if (vowels.contains(letter)){
                    ++numbOfVowels;
                } else if (consonants.contains(letter)){
                    ++numbOfCons;
                } else{
                    isLatinWord = false;
                    break;
                }
            }
            if (isLatinWord && numbOfCons.equals(numbOfVowels)){
                ++result;
            }
            numbOfCons = 0;
            numbOfVowels = 0;
            isLatinWord = true;
        }

        System.out.println("Numb of word = " + result);

    }
}
