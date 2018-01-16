package com.epam.jf.vasiliev.homework;

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
    public static void main(String...args) {
        System.out.println(findPalindromes(args));
    }

    public static String findPalindromes(String...args) {
        String res = "";
        for (String crt : args) {
            if(isPalindromeNumb(crt)) {
                res = crt;
            }
        }
        return res;
    }

    public static boolean isPalindromeNumb(String toCheck) {
        if(toCheck.isEmpty()) {
            return false;
        }

        if(toCheck.length() == 1) {
            if(toCheck.charAt(0) >= '0' && toCheck.charAt(0) <= '9') {
                return true;
            } else {
                return false;
            }
        }

        for (int i = 0; i < toCheck.length() / 2 + 1; i++) {
            char crtFromStart = toCheck.charAt(i);
            char crtFromEnd = toCheck.charAt(toCheck.length() - 1 - i);

            if(!(crtFromStart >= '0' && crtFromStart <= '9') || !(crtFromEnd >= '0' && crtFromEnd <= '9')) {
                return false;
            }

            if(crtFromStart != crtFromEnd) {
                return false;
            }
        }
        return true;
    }
}
