package com.epam.jf.Shabashov.homework;


import java.nio.ByteBuffer;

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

    private static Long vowelsNum = calcVowelsLetters();

    public static void main(String[] args) {
        int countLines = 0;
        int vowelCounter = 0;
        int consonantCounter = 0;
        for (String line :args) {
            vowelCounter = 0;
            consonantCounter = 0;
            for (char letter :line.toCharArray()) {
                if ((letter >= 'a' && letter <='z') || (letter >= 'A' && letter <='Z')){
                    if (checkVowelLetter(letter)){
                        vowelCounter++;
                    }else{
                        consonantCounter++;
                    }
                }else{
                    vowelCounter=-1;
                    break;
                }
            }
            if (vowelCounter == consonantCounter){
                countLines++;
            }
        }

        System.out.println(countLines);
        for (char letter:"aeiouAEIOU".toCharArray()) {
            if (!checkVowelLetter(letter)){
                throw new NullPointerException();
            }
        }

    }

    /**
     * @param letter
     * @return true если буква гласная иначе false
     */
    public static boolean checkVowelLetter(char letter){
        if ((vowelsNum & (1L << (letter - 'A')))==0){
            return false;
        }
        return true;
    }

    public static Long calcVowelsLetters(){
        String vowels = "aeiouAEIOU";
        Long returnValue=0L;
        for (char letter :vowels.toCharArray()) {
            returnValue |= 1L << letter-'A';
        }
        return returnValue;
    }


}
