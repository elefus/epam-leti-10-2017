package com.epam.jf.plokhoi.homework;

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
     * @param words анализируемые слова.
     */
    public static void main(String[] words) {
        int numberLetters = Integer.MAX_VALUE;
        String minLettersWord = null;

        for (String word : words) {
            long mask = 0;

            for (char letter : word.toCharArray()) {
                mask |= calcMaskFor(letter);
            }

            int numberBitsInMask = Long.bitCount(mask);
            if (numberBitsInMask < numberLetters) {
                minLettersWord = word;
                numberLetters = numberBitsInMask;
            }
        }
        System.out.println(minLettersWord);
    }

    private static long calcMaskFor(char letter) {
        return 1L << (letter - (letter < 'a' ? 'A' : 71));
    }
}