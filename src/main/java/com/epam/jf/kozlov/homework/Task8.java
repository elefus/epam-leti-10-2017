package com.epam.jf.kozlov.homework;

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
        if (args.length == 0) {
            System.out.println("Error: No arguments found");
            return;
        }
        String result = "No polyndrom number found";
        boolean firstChecked = false;
        for (String string:args) {
            if (isPolyndrom(string)) {
                result = string;
                if (firstChecked) {
                    break;
                } else {
                    firstChecked = true;
                }
            }
        }
        System.out.println(result);
    }

    private static boolean isPolyndrom(String string) {
        for (int forward = 0, backward = string.length() - 1; forward <= backward; forward++, backward--) {
            if (Character.getNumericValue(string.charAt(forward)) < 0
                    || Character.getNumericValue(string.charAt(forward)) > 9
                    || Character.getNumericValue(string.charAt(backward)) < 0
                    || Character.getNumericValue(string.charAt(backward)) > 9
                    || string.charAt(forward) != string.charAt(backward)) {
                return false;
            }
        }
        return true;
    }
}
