package com.epam.jf.burachenko.homework;

import java.util.HashMap;

public class Task22 extends com.epam.jf.common.homework.Task22 {
    @Override
    public HashMap<Integer, Integer> addPolynomials(HashMap<Integer, Integer> first, HashMap<Integer, Integer> second) {
        HashMap<Integer, Integer> result = new HashMap<>(first);
        for (Integer key : second.keySet()) {
            result.merge(key, second.get(key), (int1, int2) -> int1+int2);
        }
        return result;
    }
}
