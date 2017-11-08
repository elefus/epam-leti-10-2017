package com.epam.jf.ilyinykh.homework;

import java.util.Arrays;
import java.util.Comparator;

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
        Arrays.sort(args, Comparator.comparingInt(Task4::countUnique));
        System.out.println(Arrays.toString(args));
        System.out.println(args[0]);
    }

    private static int countUnique(String word) {
        int counter = 0;
        outer: for (int i = 0; i < word.length(); ++i) {
            char letter = word.charAt(i);
            for (int j = 0; j < i; ++j) {
                if ((letter ^ word.charAt(j)) == 0) {
                    continue outer;
                }
            }
            counter++;
        }
        return counter;
    }
}
