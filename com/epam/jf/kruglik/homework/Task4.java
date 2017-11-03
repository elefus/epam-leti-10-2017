package com.epam.jf.kruglik.homework;

import java.util.HashSet;

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
        String minWordByLet = null;
        Integer minNumbLetInWord = Integer.MAX_VALUE;
        HashSet<Character> lettersFromWord = new HashSet<Character>();
        for (String word: args){
            for (Character i: word.toCharArray()){
                lettersFromWord.add(i);
            }
            if (lettersFromWord.size() < minNumbLetInWord){
                minNumbLetInWord = lettersFromWord.size();
                minWordByLet = word;
            }
            lettersFromWord.clear();
        }
        System.out.println("Minimum equals let in word - " + minNumbLetInWord);
        System.out.println("And this word is - " + minWordByLet);
    }
}
