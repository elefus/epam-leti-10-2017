package com.epam.jf.kuchinskii.homework;

import java.util.HashMap;
import java.util.Map;

public class Task22 extends com.epam.jf.common.homework.Task22 {

    @Override
    public HashMap<Integer, Integer> addPolynomials(HashMap<Integer, Integer> first, HashMap<Integer, Integer> second) {
        HashMap<Integer, Integer> result =  (HashMap<Integer, Integer>) first.clone();

        for (Map.Entry<Integer, Integer> entry: second.entrySet()) {
            if (result.containsKey(entry.getKey())) {
                Integer i = result.remove(entry.getKey());
                result.put(entry.getKey(), entry.getValue() + i);
            } else {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }
}
