package com.epam.jf.ilyinykh.homework;

/**
 * На вход программе подается несколько строк (через параметры командной строки args).
 * Каждая строка представляет собой одно слово.
 *
 * Помимо обычных слов, во входной последовательности могут встречаться целые числа.
 * Среди них необходимо найти число-палиндром (одинаково читающееся в обоих направлениях).
 * Если таких чисел больше одного, найти второе из них.
 *
 * Одна цифра является палиндромом.
 * Ограничения на размер числа нет.
 */
public class Task8 {

    /**
     * @param args анализируемые строки.
     */
    public static void main(String[] args) {
        String result = getResult(args);
        System.out.println("Answer is " + result);
    }

    public static String getResult(String[] args) {
        int counter = 0;
        String result = null;
        for (String string : args) {
            if (checkIfPoly(string)) {
                result = string;
                ++counter;
                if (counter == 2) {
                    break;
                }
            }
        }
        return result;
    }


    public static boolean checkIfPoly(String string) {
        boolean answer = true;
        char[] chars = string.toCharArray();

        if (chars.length == 1) {
            return Character.isDigit(chars[0]);
        }

        for (int i = 0; i < chars.length / 2; ++i) {
            if (chars[i] != chars[chars.length - 1 - i] ||
                !Character.isDigit(chars[i])) {
                return false;
            }
        }

        return Character.isDigit(chars[chars.length / 2]);
    }
}
