package com.epam.jf.polovinkin.homework;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        List<String> strings = Arrays.stream(args)
                .filter(a -> a.matches("\\d+"))
                .filter(a -> a.equals(new StringBuilder(a).reverse().toString()))
                .collect(Collectors.toList());


        System.out.println(strings.size() > 0 ? (strings.size() != 1 ? strings.get(1) : strings.get(0)) : "NOT FOUND");
    }
}
