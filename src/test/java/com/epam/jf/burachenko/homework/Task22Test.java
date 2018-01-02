package com.epam.jf.burachenko.homework;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class Task22Test {
    @Test
    void testAddPolynomials() {
        Task22 T = new Task22();
        HashMap<Integer, Integer> first = new HashMap<>();
        first.put(0, 1);
        first.put(1, 2);
        first.put(2, 1);

        HashMap<Integer, Integer> second = new HashMap<>();
        second.put(0, 5);
        second.put(3, 4);
        second.put(2, 4);

        HashMap<Integer, Integer> expected = new HashMap<>();
        expected.put(0, 6);
        expected.put(1, 2);
        expected.put(2, 5);
        expected.put(3, 4);

        assertTrue(T.addPolynomials(first, second).equals(expected));
        assertTrue(T.addPolynomials(second, first).equals(expected));


        HashMap<Integer, Integer> first1 = new HashMap<>();
        first1.put(0, 3);
        first1.put(1, 5);

        HashMap<Integer, Integer> second1 = new HashMap<>();
        second1.put(0, 2);
        second1.put(2, 4);

        HashMap<Integer, Integer> expected1 = new HashMap<>();
        expected1.put(0, 5);
        expected1.put(1, 5);
        expected1.put(2, 4);

        assertTrue(T.addPolynomials(first1, second1).equals(expected1));
        assertTrue(T.addPolynomials(second1, first1).equals(expected1));
    }
}
