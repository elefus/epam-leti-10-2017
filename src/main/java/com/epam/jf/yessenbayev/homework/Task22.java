package com.epam.jf.yessenbayev.homework;

import java.util.HashMap;

public class Task22 extends com.epam.jf.common.homework.Task22 {
    @Override
    public HashMap<Integer, Integer> addPolynomials(HashMap<Integer, Integer> first, HashMap<Integer, Integer> second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }

        HashMap<Integer, Integer> result = new HashMap<>(first);
        second.forEach((Integer key, Integer value) ->{
            if(!result.containsKey(key)){
                result.put(key,value);
            }
            else {
                result.replace(key,result.get(key)+value);
            }
        });

        return result;
    }
}
