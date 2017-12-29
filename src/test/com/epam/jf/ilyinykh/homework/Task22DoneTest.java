package com.epam.jf.ilyinykh.homework;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Task22DoneTest {

    @Test
    void addPolynomials() {
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> second = new HashMap<>();
        first.put(0, 10);
        first.put(1, 5);
        second.put(1, 5);
        second.put(2, 10);
        HashMap<Integer, Integer> answer = new Task22Done().addPolynomials(first, second);
        System.out.println(answer);
        for (Integer key : answer.keySet()) {
            assertEquals(answer.get(key), new Integer(first.getOrDefault(key, 0) + second.getOrDefault(key, 0)));
        }
    }
}