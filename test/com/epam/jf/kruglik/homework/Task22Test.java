package com.epam.jf.kruglik.homework;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class Task22Test {

    @Test
    void addPolynomialsTwoMapsNotEmpty() {
        HashMap<Integer, Integer> resultPoly = new HashMap<>();
        resultPoly.put(1,4);
        resultPoly.put(2,6);
        resultPoly.put(4,1);
        resultPoly.put(5,1);
        HashMap<Integer, Integer> firstPoly = new HashMap<>();
        firstPoly.put(1,1);
        firstPoly.put(2,3);
        firstPoly.put(5,1);
        HashMap<Integer, Integer> secondPoly = new HashMap<>();
        secondPoly.put(1,3);
        secondPoly.put(2,3);
        secondPoly.put(4,1);
        assertTrue(new Task22().addPolynomials(firstPoly,secondPoly).equals(resultPoly));
    }

    @Test
    void addPolynomialsOneOfMapsIsEmpty() {
        HashMap<Integer, Integer> resultPoly = new HashMap<>();
        resultPoly.put(1,1);
        resultPoly.put(2,3);
        resultPoly.put(5,1);
        HashMap<Integer, Integer> firstPoly = new HashMap<>();
        firstPoly.put(1,1);
        firstPoly.put(2,3);
        firstPoly.put(5,1);
        HashMap<Integer, Integer> secondPoly = new HashMap<>();
        assertTrue(new Task22().addPolynomials(firstPoly,secondPoly).equals(resultPoly));
    }
}