package com.epam.jf.zakomornyy.homework;

import java.util.HashMap;
import java.util.Map;

public class Task22 extends com.epam.jf.common.homework.Task22{
    @Override
    public HashMap<Integer, Integer> addPolynomials(HashMap<Integer, Integer> first, HashMap<Integer, Integer> second) {
        HashMap<Integer, Integer> result = new HashMap<>(first);
        for (Map.Entry<Integer, Integer> entry : second.entrySet()) {
            if(result.containsKey(entry.getKey())) {
                result.put(entry.getKey(), entry.getValue() + result.get(entry.getKey()));
            } else {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }
}
