package com.epam.jf.Guyo.homework;

import java.util.ArrayList;

/**
 * На вход программе подается несколько строк (через параметры командной строки args).
 * Каждая строка представляет собой одно слово, состоящее из символов английского алфавита.
 * Необходимо найти слово, в котором число различных символов минимально.
 *
 * Символы верхнего и нижнего регистра считать различными.
 * Если таких слов несколько, найти первое из них.
 *
 * В результате выполнения в выходной поток должно быть выведено слово, содержащее наименьшее число различных символов.
 * Наиболее эффективное с точки зрения скорости и потребляемой памяти решение - реализация с использованием битовых операций.
 * Желающие могут попробовать придумать, как их можно применить в этой задаче.
 */
public class Task4 {

    /**
     * @param args анализируемые строки.
     */

    public static int diffAmountOfCharacters(String args){

        ArrayList <Character> uniqueCharacters = new ArrayList<>();

        for (int i = 0; i < args.length(); i++) {
            char tempChar = args.charAt(i);
            if (uniqueCharacters.contains(tempChar)){
                continue;
            } else {
                uniqueCharacters.add(tempChar);
            }
        }
        int diffAmount = uniqueCharacters.size();
        return diffAmount;
    }

    public static void main(String[] args) {
        String minDiffString = args[0];
        for (String i: args) {
            if (diffAmountOfCharacters(i) < diffAmountOfCharacters(minDiffString)){
                minDiffString = i;
            }
        }
        System.out.println("String " + minDiffString + " has the least number of different characters");
    }
}