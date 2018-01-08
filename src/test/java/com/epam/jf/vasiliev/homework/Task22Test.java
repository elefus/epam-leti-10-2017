package com.epam.jf.vasiliev.homework;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class Task22Test {
    Task22 ref = new Task22();

    @Test
    void testOnTwoEmpyPolynoms() {
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> second = new HashMap<>();

        HashMap<Integer, Integer> result = ref.addPolynomials(first, second);
        assertTrue(result.isEmpty());
    }

    @Test
    void testOnOneEmptyPolynom() {
        HashMap<Integer, Integer> first = new HashMap<>();
        first.put(3,2);
        first.put(1,4);
        first.put(0,2);
        HashMap<Integer, Integer> second = new HashMap<>();

        HashMap<Integer, Integer> result = ref.addPolynomials(first,second);
        assertArrayEquals(first.entrySet().toArray(), result.entrySet().toArray());
    }

    @Test
    void testAddingTwoPolynomsWithTheSameDegreeWithoutZeroCoefs() {
        HashMap<Integer, Integer> first = new HashMap<>();
        first.put(4,42);
        first.put(3,2);
        first.put(2,18);
        first.put(1,4);
        first.put(0,2);

        HashMap<Integer, Integer> second = new HashMap<>();
        second.put(4,8);
        second.put(3,44);
        second.put(2,10);
        second.put(1,1);
        second.put(0,11);


        HashMap<Integer,Integer> expected = new HashMap<>();
        expected.put(4,50);
        expected.put(3,46);
        expected.put(2,28);
        expected.put(1,5);
        expected.put(0,13);

        HashMap<Integer, Integer> result = ref.addPolynomials(first,second);
        assertArrayEquals(expected.entrySet().toArray(), result.entrySet().toArray());
    }

    @Test
    void testTwoPlynomsWithDifferentDegreesAndWithZeroCoefs() {
        HashMap<Integer, Integer> first = new HashMap<>();
        first.put(6,-4);
        first.put(2,2);
        first.put(0,-6);

        HashMap<Integer, Integer> second = new HashMap<>();
        second.put(4,13);
        second.put(2,-2);
        second.put(1,3);
        second.put(0,2);

        HashMap<Integer,Integer> expected = new HashMap<>();
        expected.put(6,-4);
        expected.put(4,13);
        expected.put(1,3);
        expected.put(0,-4);

        HashMap<Integer, Integer> result = ref.addPolynomials(first,second);
        assertArrayEquals(expected.entrySet().toArray(), result.entrySet().toArray());
    }
}











