package com.epam.jf.vasiliev.homework;

import java.util.HashMap;

/**
 * Сложить два многочлена, если коэффициенты многочленов хранятся в объекте HashMap.
 * Степень элемента многочлена – ключ, коэффициент элемента многочлена – значение.
 * Коэффициенты многочлена, ключи для которых отсутствуют в карте, равны нулю.
 */
public class Task22 extends com.epam.jf.common.homework.Task22{

    /**
     * Осуществляет сложение двух многочленов.
     * @param first Первый многочлен.
     * @param second Второй многочлен.
     * @return Многочлен, полученный в результате сложения.
     */
    @Override
    public HashMap<Integer, Integer> addPolynomials(HashMap<Integer, Integer> first, HashMap<Integer, Integer> second) {
        HashMap<Integer,Integer> result = new HashMap<>(first);
        second.forEach((k,v) -> result.merge(k, v, (v1, v2) -> v1 + v2 == 0 ? null : v1 + v2));
        return result;
    }
}
