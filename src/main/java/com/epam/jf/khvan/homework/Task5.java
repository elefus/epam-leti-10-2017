package com.epam.jf.khvan.homework;

import java.util.Arrays;
import java.util.LinkedList;

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

    public static void main(String[] args) {

        LinkedList<Character> vowels = new LinkedList<>(Arrays.asList('a','e','i','o','u','y'));
        int vowelNumber = 0;
        int consonantNumber = 0;
        int numberOfWords = 0;
        for (String word: args) {
            char [] lettersWord = word.toLowerCase().toCharArray();
            for ( int i = 0; i < lettersWord.length ; i++) {
                if ( lettersWord[i] >= 'a' && lettersWord[i] <= 'z' ){
                    if ( vowels.contains(lettersWord[i])) {
                         vowelNumber++;}
                    else{
                        consonantNumber++;
                    }
                    if ( i == lettersWord.length - 1 && consonantNumber == vowelNumber){ numberOfWords++;}
                    if ( i == lettersWord.length - 1){
                        consonantNumber = 0;
                        vowelNumber = 0;
                    }
                } else {
                    consonantNumber = 0;
                    vowelNumber = 0;
                    break;
                }
            }
        }
        System.out.println(numberOfWords);
    }
}

