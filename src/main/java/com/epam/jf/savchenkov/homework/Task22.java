package com.epam.jf.savchenkov.homework;

import java.util.HashMap;

/**
 * Сложить два многочлена, если коэффициенты многочленов хранятся в объекте HashMap.
 * Степень элемента многочлена – ключ, коэффициент элемента многочлена – значение.
 * Коэффициенты многочлена, ключи для которых отсутствуют в карте, равны нулю.
 */
public class Task22 extends com.epam.jf.common.homework.Task22 {

    @Override
    public HashMap<Integer, Integer> addPolynomials(HashMap<Integer, Integer> first, HashMap<Integer, Integer> second) {
        HashMap<Integer, Integer> result = new HashMap<>(first);
        for (Integer key : second.keySet()) {
            result.merge(key,second.get(key), ((integer, integer2) -> integer + integer2));
        }
        return result;
    }
}
