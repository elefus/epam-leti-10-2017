package com.epam.jf.common.homework;

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
import java.util.Arrays;
import java.util.LinkedList;

public class Task5 {

    /**
     * @param args анализируемые строки.
     */
    public static void main(String[] args) {
        LinkedList<Character> vowels = new LinkedList<> (Arrays.asList('a','A','e','E','i','I','o','O','u','U','y','Y'));
        int vowelNumber = 0;
        int consonantNumber = 0;
        int numberOfWords = 0;

        for ( String word: args) {
            char [] lettersWord = word.toCharArray();
            boolean isLetterEnglish = false;
            for (int i = 0; i < lettersWord.length; i++) {
                if ( lettersWord[i] >= 'a' && lettersWord[i] <= 'z' || lettersWord[i] >= 'A' && lettersWord[i] <= 'Z'){
                    isLetterEnglish = true;
                } else {
                    isLetterEnglish = false;
                }
            }
            if( isLetterEnglish ){
                for ( int j = 0; j < lettersWord.length; j++){
                    if ( vowels.contains(lettersWord[j])) {
                        vowelNumber++; }
                    else {
                        consonantNumber++;
                    }
                    if ( j == lettersWord.length-1 && consonantNumber == vowelNumber ){ numberOfWords++;}
                    if ( j == lettersWord.length-1 ){
                        consonantNumber = 0;
                        vowelNumber = 0;
                    }
                }
            }
        }
        System.out.println(numberOfWords);
    }
}
