package com.epam.jf.bavtovich.homework;

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

    public static void  main(String[] args) {
        if (args.length != 0) {
            int minUniqueSymbols = 100;
            int wordIndex = 0;
            for (int i = 0; i < args.length ; i++) {
                int numUniqueSymbols = countUniqueSymbols(args[i]);

                if (numUniqueSymbols < minUniqueSymbols) {
                    minUniqueSymbols = numUniqueSymbols;
                    wordIndex = i;
                }
            }
            System.out.println(args[wordIndex]);
        } else {
            System.out.println("Not enough arguments");
        }
    }

    private static int countUniqueSymbols(String word) {
        int cnt = 0;
        char[] buff = word.toCharArray();

        label:
        for (int i = 0; i < buff.length; i++) {
            for (int j = 0; j < i; j++) {
                if (buff[j] == buff[i]) {
                    continue label;
                }
            }
            cnt++;
        }
        return cnt;
    }
}

