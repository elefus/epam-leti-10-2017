package com.epam.jf.Shabashov.homework;

import java.util.Arrays;

/**
 * На вход программе подается несколько строк (через параметры командной строки args).
 * Каждая строка представляет собой одно слово, состоящие из символов английского алфавита.
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
    public static void main(String[] args) {
        int min = Integer.MAX_VALUE;
        int nWord = 0;
        int value;
        for (int i=0;i<args.length;i++){
            value = getUniqueLetters(args[i]);
            if (value<min){
                min = value;
                nWord = i;
            }
        }
        System.out.println("String " + args[nWord]);
        System.out.println("Length " + min);
    }

    public static int getUniqueLetters(String str){
        boolean[] letters = new boolean[123];
        Arrays.fill(letters,false);
        int counter = 0;
        for(int i=0;i<str.length();i++){
            if (!letters[str.charAt(i)]){
                counter++;
                letters[str.charAt(i)] = true;
            }
        }
        return counter;
    }

}
