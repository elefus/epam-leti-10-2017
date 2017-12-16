package com.epam.jf.guba.homework;

import java.util.HashMap;

public class Task22 extends com.epam.jf.common.homework.Task22 {

    @Override
    public HashMap<Integer, Integer> addPolynomials(HashMap<Integer, Integer> first, HashMap<Integer, Integer> second) {
        if(first == null || second == null){
            throw new NullPointerException("Some arguments is null");
        }
        HashMap<Integer, Integer> result = new HashMap<>(first);
        second.forEach((key, value) -> result.merge(key, value, (oldVal, newVal) -> oldVal + newVal));
        return result;
    }
}
