package com.epam.jf.kuchinskii.homework;

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
    public static void main(String[] args) {
        if (args.length > 0) {
            int minDifChar = Integer.MAX_VALUE; // Число различных символов
            int minArgIndex = 0; // Индекс искомого слова

            for (int i = 0; i < args.length; i++) {
                long mask = 0;
                for (int j = 0; j < args[i].length(); j++) {
                    mask |= setBit((int)args[i].charAt(j));
                }
                if (Long.bitCount(mask) < minDifChar) {
                    minDifChar = Long.bitCount(mask);
                    minArgIndex = i;
                }
            }
            System.out.println("Слово, содержащее наименьшее число различных символов: " + args[minArgIndex]);

        } else {
            System.out.println("На входе ничего нет.");
        }
    }

    /**
     * Returns {@code long} mask unique for each case sensitive English character.
     * @param code Code of a character to create a mask for.
     * @return {@code long} bit mask with single '1' shifted left 0-52 times.
     */
    private static long setBit(int code) {
        long res = 0;
        int position;
        if ((122 >= code) & (code >= 97)) {
            position = code % 26;
        } else if ((90 >= code) & (code >= 65)) {
            position = (code % 26) + 26;
        } else return -1;
        return res | 1L << position;
    }
}
