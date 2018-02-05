package com.epam.jf.volkov.homework;

import java.util.HashMap;

/**
 * Сложить два многочлена, если коэффициенты многочленов хранятся в объекте HashMap.
 * Степень элемента многочлена – ключ, коэффициент элемента многочлена – значение.
 * Коэффициенты многочлена, ключи для которых отсутствуют в карте, равны нулю.
 */
public class Task22 extends com.epam.jf.common.homework.Task22 {

    /**
     * Осуществляет сложение двух многочленов.
     * @param first Первый многочлен.
     * @param second Второй многочлен.
     * @return Многочлен, полученный в результате сложения.
     */
    public HashMap<Integer, Integer> addPolynomials(HashMap<Integer, Integer> first, HashMap<Integer, Integer> second) {
        HashMap<Integer, Integer> newMap = new HashMap<>();
        for (int i = 0, counter = 0; counter < Math.max(first.size(), second.size()); i++) {
            int value = 0;
            if (first.containsKey(i)) {
                value += first.get(i);
            }
            if (second.containsKey(i)) {
                value += second.get(i);
            }
            if (value != 0) {
                counter++;
            }
            newMap.put(i, value);
        }
        return newMap;

        //Уверен, задачу можно решить функциональщиной
    }
}
