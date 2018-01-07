package com.epam.jf.khvan.homework;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

public class Task22Test {

    private Task22Implement task22 = new Task22Implement();

    @Test
    void testEmtyAll() {
        HashMap<Integer, Integer> first = new HashMap<>();

        HashMap<Integer, Integer> second = new HashMap<>();

        HashMap<Integer, Integer> expected = new HashMap<>();

        assertThat(task22.addPolynomials(first, second), is(expected));
    }

    @Test
    void testEqualPolynoms() {
        HashMap<Integer, Integer> polynom = new HashMap<>();
        polynom.put(1, 2);
        polynom.put(2, 2);
        polynom.put(3, 3);
        polynom.put(4, 9);

        HashMap<Integer, Integer> expected = new HashMap<>();
        expected.put(1, 4);
        expected.put(2, 4);
        expected.put(3, 6);
        expected.put(4, 18);

        assertThat(task22.addPolynomials(polynom, polynom), is(expected));
    }


    @Test
    void testWithoutLastSecond() {
        HashMap<Integer, Integer> first = new HashMap<>();
        first.put(1, 1);
        first.put(2, 2);
        first.put(3, 3);
        first.put(4, 4);

        HashMap<Integer, Integer> second = new HashMap<>();
        second.put(1, 1);
        second.put(3, 2);
        second.put(4, 3);

        HashMap<Integer, Integer> expected = new HashMap<>();
        expected.put(1, 2);
        expected.put(2, 2);
        expected.put(3, 5);
        expected.put(4, 7);

        assertThat(task22.addPolynomials(first, second), is(expected));

    }

    @Test
    void testEmtySecond() {
        HashMap<Integer, Integer> first = new HashMap<>();
        first.put(1, 1);
        first.put(2, 2);
        first.put(3, 3);

        HashMap<Integer, Integer> second = new HashMap<>();

        HashMap<Integer, Integer> expected = new HashMap<>();
        expected.put(1, 1);
        expected.put(2, 2);
        expected.put(3, 3);

        assertThat(task22.addPolynomials(first, second), is(expected));
    }
}

