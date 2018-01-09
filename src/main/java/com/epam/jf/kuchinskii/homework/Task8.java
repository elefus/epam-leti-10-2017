package com.epam.jf.kuchinskii.homework;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static void main(String[] args) {
        ArrayList<String> palindromes = new ArrayList<>();
        for (String arg : args) {
            if (isPalindrome(arg)) {
                palindromes.add(arg);
                if (palindromes.size() == 2) {
                    break;
                }
            }
        }
        if (palindromes.isEmpty()) {
            System.out.println("Палиндромов нет.");
        } else {
            System.out.println("Число палиндром: " + (palindromes.size() < 2 ? palindromes.get(0) : palindromes.get(1)));
        }
    }

    /**
     * First checks if the input is correct using regexp.
     * Then checks if number is a palindrome excluding it's sign.
     * @param arg integer number of any length.
     * @return true - if number is a palindrome, false - if not or the input is incorrect.
     */
    private static boolean isPalindrome(String arg) {
        Pattern p = Pattern.compile("^-?(\\d+)$");
        Matcher m = p.matcher(arg);
        if (m.matches()) {
            String substr = arg.substring(m.start(1));
            int n = substr.length();
            for (int i = 0; i < n / 2; i++) {
                if (substr.charAt(i) != substr.charAt(n - i - 1)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
