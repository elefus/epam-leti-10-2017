package com.epam.jf.khvan.homework;

import java.util.HashMap;

public class Task22Implement extends Task22  {

    @Override
    public HashMap<Integer, Integer> addPolynomials(HashMap<Integer, Integer> first, HashMap<Integer, Integer> second) {
        if (first == null || second == null){
            throw new NullPointerException();
        }

        HashMap<Integer, Integer> result = new HashMap<>(first);
        second.forEach((key, value) -> result.merge(key, value, Integer::sum));

        return result;
    }
}

