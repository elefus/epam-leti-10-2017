package com.epam.jf.dementyev.homework;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

class Task22Test {

    @Test
    void addPolynomials() {
        HashMap<Integer, Integer> first = new HashMap<>();
        first.put(0, 3);
        first.put(1, 5);
        HashMap<Integer, Integer> second = new HashMap<>();
        second.put(0, 2);
        second.put(2, 4);

        HashMap<Integer, Integer> expected = new HashMap<>();
        expected.put(0, 5);
        expected.put(1, 5);
        expected.put(2, 4);

        // (5*x+3) + (4*x^2+2)
        assertTrue(new Task22().addPolynomials(first, second).equals(expected));
        assertTrue(new Task22().addPolynomials(second, first).equals(expected));
    }
}