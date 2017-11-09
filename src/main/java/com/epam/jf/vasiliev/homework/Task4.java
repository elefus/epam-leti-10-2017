package com.epam.jf.vasiliev.homework;


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
        int minStrIndex = 0;
        //max amount of different ASKII characters in string is 128
        int minUniqueChars = 128;

        for (int i = 0; i < args.length; i++) {
            int buf = countUniqueChars(args[i]);
            if(buf < minUniqueChars) {
                minStrIndex = i;
                minUniqueChars = buf;
            }
        }

        System.out.println(args[minStrIndex]);
    }

    private static int countUniqueChars(String str) {
        long bitMap = 0;
        for (int i = 0; i < str.length(); i++) {
            bitMap |= (1L << str.charAt(i) - 'A');
        }

        return Long.bitCount(bitMap);
    }
}