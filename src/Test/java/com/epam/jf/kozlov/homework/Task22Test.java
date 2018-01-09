package com.epam.jf.kozlov.homework;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class Task22Test {

    @Test
    void addPolynomialsTest() {
        HashMap<Integer, Integer> firstPoly = new HashMap<>();
        firstPoly.put(0, 1337);
        firstPoly.put(3, 42);
        firstPoly.put(4, 24);
        firstPoly.put(45, 13);

        HashMap<Integer, Integer> secondPoly = new HashMap<>();
        secondPoly.put(0, -1337);
        secondPoly.put(2, 42);
        secondPoly.put(3, -11);
        secondPoly.put(11, 13);
        secondPoly.put(4, 13);

        HashMap<Integer, Integer> resultPoly = new HashMap<>();
        resultPoly.put(0, 0);
        resultPoly.put(2, 42);
        resultPoly.put(3, 31);
        resultPoly.put(4, 37);
        resultPoly.put(11, 13);
        resultPoly.put(45, 13);

        assertEquals(resultPoly, new Task22().addPolynomials(firstPoly, secondPoly));
    }

    @Test
    void addPolynomialsInverseTest() {
        HashMap<Integer, Integer> firstPoly = new HashMap<>();
        firstPoly.put(0, 1337);
        firstPoly.put(3, 42);
        firstPoly.put(4, 24);
        firstPoly.put(45, 13);

        HashMap<Integer, Integer> secondPoly = new HashMap<>();
        secondPoly.put(0, -1337);
        secondPoly.put(2, 42);
        secondPoly.put(3, -11);
        secondPoly.put(11, 13);
        secondPoly.put(4, 13);

        HashMap<Integer, Integer> resultPoly = new HashMap<>();
        resultPoly.put(0, 0);
        resultPoly.put(2, 42);
        resultPoly.put(3, 31);
        resultPoly.put(4, 37);
        resultPoly.put(11, 13);
        resultPoly.put(45, 13);

        assertEquals(resultPoly, new Task22().addPolynomials(secondPoly, firstPoly));
    }
}
