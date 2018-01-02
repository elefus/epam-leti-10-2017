package com.epam.jf.kruglik.homework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

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
    public HashMap<Integer, Integer> addPolynomials(HashMap<Integer, Integer> first, HashMap<Integer, Integer> second){
        HashMap<Integer, Integer> resultPoly = new HashMap<>(first);
        second.forEach((key,value) -> {
            if (resultPoly.containsKey(key)){
                resultPoly.put(key, resultPoly.get(key) + value);
            } else {
                resultPoly.put(key,value);
            }
        });
        return resultPoly;
    }
}