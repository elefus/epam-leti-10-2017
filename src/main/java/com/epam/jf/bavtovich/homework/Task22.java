package com.epam.jf.bavtovich.homework;

import java.util.HashMap;

/**
 * Сложить два многочлена, если коэффициенты многочленов хранятся в объекте HashMap.
 * Степень элемента многочлена – ключ, коэффициент элемента многочлена – значение.
 * Коэффициенты многочлена, ключи для которых отсутствуют в карте, равны нулю.
 */
public class Task22 {

    /**
     * Осуществляет сложение двух многочленов.
     * @param first Первый многочлен.
     * @param second Второй многочлен.
     * @return Многочлен, полученный в результате сложения.
     */
    public static HashMap<Integer, Integer> addPolynomials(HashMap<Integer, Integer> first, HashMap<Integer, Integer> second) {
        HashMap<Integer, Integer> result = new HashMap<>(first);
        second.forEach((k, v) -> result.merge(k, v, (firstNum, secondNum) -> firstNum + secondNum));
        return result;
    }
}
