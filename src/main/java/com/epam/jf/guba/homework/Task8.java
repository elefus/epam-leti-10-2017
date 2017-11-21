package com.epam.jf.guba.homework;

/**
 * На вход программе подается несколько строк (через параметры командной строки args). Каждая строка представляет собой одно слово.
 *
 * Помимо обычных слов, во входной последовательности могут встречаться целые числа. Среди них необходимо найти число-палиндром (одинаково читающееся
 * в обоих направлениях). Если таких чисел больше одного, найти второе из них.
 *
 * Одна цифра является палиндромом. Ограничения на размер числа нет.
 */
public class Task8 {

    private static final StringBuilder sb;

    static {
        sb = new StringBuilder();
    }

    /**
     * @param args анализируемые строки.
     */
    public static void main(String[] args) {
        if (args == null || args.length < 1) {
            System.err.println("Мало аргументов");
            return;
        }

        int amountOfPalindroms = 0;
        int numOfString = -1;
        int currentString = 0;
        for (String string : args) {
            if (isDigit(string)) {
                if (isPalindrom(string)) {
                    numOfString = currentString;
                    amountOfPalindroms++;
                    if (amountOfPalindroms == 2) {
                        break;
                    }
                }
            }
            currentString++;
        }

        if (numOfString == -1) {
            System.out.println("Численных строк-палиндромов нет!");
        } else {
            System.out.println(args[numOfString]);
        }
    }

    private static boolean isPalindrom(String string) {
        sb.delete(0, sb.toString().length());
        return string.equals(sb.append(string).reverse().toString());
    }

    private static boolean isDigit(String string) {
        return string.matches("[0-9]+");
    }
}
