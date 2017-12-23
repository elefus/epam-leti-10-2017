package com.epam.jf.ilyinykh.homework;

import com.epam.jf.common.homework.Task22;

import java.util.HashMap;

public class Task22Done extends Task22 {
    /**
     * Осуществляет сложение двух многочленов.
     *
     * @param first  Первый многочлен.
     * @param second Второй многочлен.
     * @return Многочлен, полученный в результате сложения.
     */
    @Override
    public HashMap<Integer, Integer> addPolynomials(HashMap<Integer, Integer> first, HashMap<Integer, Integer> second) {
        HashMap<Integer, Integer> map = new HashMap<>(first);
        for (Integer key : second.keySet()) {
            map.merge(key, second.get(key), (x, y) -> x + y);
        }
        return map;
    }
}
