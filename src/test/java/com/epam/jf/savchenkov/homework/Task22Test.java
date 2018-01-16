package com.epam.jf.savchenkov.homework;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class Task22Test {

    @Test
    void test() {
        HashMap<Integer, Integer> first = new HashMap<>();
        first.put(0, 1);
        first.put(1, 3);
        first.put(2, 4);
        first.put(3, 12);

        HashMap<Integer, Integer> second = new HashMap<>();
        second.put(0, 3);
        second.put(1, 7);
        second.put(2, 1);

        HashMap<Integer, Integer> expected = new HashMap<>();
        expected.put(0, 4);
        expected.put(1, 10);
        expected.put(2, 5);
        expected.put(3, 12);

        assertTrue(new Task22().addPolynomials(first, second).equals(expected));
        assertTrue(new Task22().addPolynomials(second, first).equals(expected));
    }
}