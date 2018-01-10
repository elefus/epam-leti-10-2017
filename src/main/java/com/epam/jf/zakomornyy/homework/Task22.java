package com.epam.jf.zakomornyy.homework;

import java.util.HashMap;
import java.util.Map;

public class Task22 extends com.epam.jf.common.homework.Task22{
    @Override
    public HashMap<Integer, Integer> addPolynomials(HashMap<Integer, Integer> first, HashMap<Integer, Integer> second) {
        for (Map.Entry<Integer, Integer> entry : second.entrySet()) {
            if(first.containsKey(entry.getKey())) {
                first.put(entry.getKey(), entry.getValue() + first.get(entry.getKey()));
            } else {
                first.put(entry.getKey(), entry.getValue());
            }
        }
        return first;
    }
}
