package com.epam.jf.Guyo.homework;

import java.util.HashMap;

public class Task22 extends com.epam.jf.common.homework.Task22 {

    public HashMap<Integer, Integer> addPolynomials(HashMap<Integer, Integer> first, HashMap<Integer, Integer> second) {
        HashMap<Integer, Integer> polSum = new HashMap<>(first);
        second.forEach((k, v) -> polSum.merge(k, v, (v1, v2) -> v1 + v2));
        return polSum;
    }
}
