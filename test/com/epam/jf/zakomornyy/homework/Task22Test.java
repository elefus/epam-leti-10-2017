package com.epam.jf.zakomornyy.homework;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task22Test {
    @Test
    void addPolynomials() {
        HashMap<Integer, Integer> first = new HashMap<>();
        first.put(3, 12);
        first.put(2, 4);
        first.put(1, 2);
        first.put(0, 54);
        HashMap<Integer, Integer> second = new HashMap<>();
        second.put(4, 12);
        second.put(2, 13);
        second.put(1, 10);
        second.put(0, 32);
        HashMap<Integer, Integer> required = new HashMap<>();
        required.put(4, 12);
        required.put(3, 12);
        required.put(2, 17);
        required.put(1, 12);
        required.put(0, 86);
        HashMap<Integer, Integer> result = new Task22().addPolynomials(first, second);
        assertArrayEquals(required.entrySet().toArray(), result.entrySet().toArray());
    }

    @Test
    void addEmptyPolynoms() {
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> second = new HashMap<>();
        assertTrue(new Task22().addPolynomials(first, second).isEmpty());
    }
}