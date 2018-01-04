package com.epam.jf.bavtovich.homework;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

class Task22Test {
    @Test
    void addPolynomials() {
        HashMap<Integer, Integer> firstPolynom = new HashMap<>();
        firstPolynom.put(0, 1);
        firstPolynom.put(1, 10);
        firstPolynom.put(2, 30);
        firstPolynom.put(3, 45);

        HashMap<Integer, Integer> secondPolynom = new HashMap<>();
        secondPolynom.put(1, -7);
        secondPolynom.put(2, -20);
        secondPolynom.put(4, 4);

        HashMap<Integer, Integer> resultPolynom = new HashMap<>();
        resultPolynom.put(0, 1);
        resultPolynom.put(1, 3);
        resultPolynom.put(2, 10);
        resultPolynom.put(3, 45);
        resultPolynom.put(4, 4);

        HashMap<Integer, Integer> result = Task22.addPolynomials(firstPolynom, secondPolynom);
        assertEquals(resultPolynom, result);

    }

}