package com.epam.jf.Shabashov.homework;

import java.util.HashMap;

/**
 * Сложить два многочлена, если коэффициенты многочленов хранятся в объекте HashMap.
 * Степень элемента многочлена – ключ, коэффициент элемента многочлена – значение.
 * Коэффициенты многочлена, ключи для которых отсутствуют в карте, равны нулю.
 */
public class Task22 {

    /**
     * Осуществляет сложение двух многочленов.
     *
     * @param first  Первый многочлен.
     * @param second Второй многочлен.
     * @return Многочлен, полученный в результате сложения.
     */
    public HashMap<Integer, Integer> addPolynomials(HashMap<Integer, Integer> first, HashMap<Integer, Integer> second) {
        HashMap<Integer, Integer> map = new HashMap<>(first);
        second.forEach((key, val) -> {
            if (map.containsKey(key)) {
                if (val + map.get(key) != 0) {
                    map.put(key, val + map.get(key));
                }else{
                    map.remove(key);
                }
            } else {
                map.put(key, val);
            }
        });
        return map;
    }
}