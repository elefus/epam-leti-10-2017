package com.epam.jf.polovinkin.homework;

import java.util.HashMap;
import java.util.Map;

public class Task22 extends com.epam.jf.common.homework.Task22 {
    @Override
    public HashMap<Integer, Integer> addPolynomials(HashMap<Integer, Integer> first, HashMap<Integer, Integer> second) {
        HashMap<Integer, Integer> sumResult = new HashMap<>(first);
        for (Map.Entry<Integer, Integer> entry : second.entrySet()) {
            Integer power = entry.getKey();
            Integer result = sumResult.getOrDefault(power, 0) + entry.getValue();
            if (result != 0) {
                sumResult.put(power, result);
            } else {
                sumResult.remove(power);
            }
        }
        return sumResult;
    }
}
