package com.epam.jf.Guyo.homework;

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

    private static boolean isVowel(char letter){
        char[] vowelArray= {'a','e','i', 'o','u','A','E','I', 'O','U'};
        for (char i: vowelArray ) {
            if (letter == i) {
                return true;
            }
        }
        return false;
    }

    private static  boolean isConsonant(char letter){
        char[] consonantArray= {'b','c','d', 'f','g','h','j','k', 'l','m','n','p','q', 'r','s','t','x','v','w','y','z',
                                'B','C','D', 'F','G','H','J','K', 'L','M','N','P','Q', 'R','S','T','X','V','W','Y','Z'};
        for (char i: consonantArray ) {
            if (letter == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean isRightWord(String args){
        int counterOfVowelConsonantDiff = 0;
        for (int i = 0; i < args.length(); i++) {
            if (!(isVowel(args.charAt(i)) || isConsonant(args.charAt(i)))){
                return false;
            }
            else if (isVowel(args.charAt(i))){
                counterOfVowelConsonantDiff++;
            }
            else if(isConsonant(args.charAt(i))){
                counterOfVowelConsonantDiff--;
            }
        }
        return counterOfVowelConsonantDiff == 0;
    }

    /**
     * //@param args анализируемые строки.
     */
    public static void main(String[] args) {
        int counter = 0;
        for (String i : args) {
            if (isRightWord(i)){
                counter ++;
            }
        }
        System.out.println("Number of right words: " + counter);
    }
}