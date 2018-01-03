package com.epam.jf.guba.homework;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

public class Task22Test {

    private Task22 task22 = new Task22();

    @Test
    void testWithNull() {
        assertThrows(NullPointerException.class, () -> task22.addPolynomials(null, new HashMap<>()));
    }

    @Test
    void testEmtyBoth() {
        HashMap<Integer, Integer> first = new HashMap<>();

        HashMap<Integer, Integer> second = new HashMap<>();

        HashMap<Integer, Integer> expected = new HashMap<>();

        assertThat(task22.addPolynomials(first, second), is(expected));
    }

    @Test
    void testSame() {
        HashMap<Integer, Integer> firstAndSecond = new HashMap<>();
        firstAndSecond.put(1, 1);
        firstAndSecond.put(2, 2);
        firstAndSecond.put(3, 3);
        firstAndSecond.put(4, 4);

        HashMap<Integer, Integer> expected = new HashMap<>();
        expected.put(1, 2);
        expected.put(2, 4);
        expected.put(3, 6);
        expected.put(4, 8);

        assertThat(task22.addPolynomials(firstAndSecond, firstAndSecond), is(expected));
    }

    @Test
    void testWithMissingLeft() {
        HashMap<Integer, Integer> first = new HashMap<>();
        first.put(1, 1);
        first.put(3, 2);
        first.put(4, 3);
        HashMap<Integer, Integer> second = new HashMap<>();
        second.put(1, 1);
        second.put(2, 2);
        second.put(3, 3);
        second.put(4, 4);

        HashMap<Integer, Integer> expected = new HashMap<>();
        expected.put(1, 2);
        expected.put(2, 2);
        expected.put(3, 5);
        expected.put(4, 7);

        assertThat(task22.addPolynomials(first, second), is(expected));
    }

    @Test
    void testWithMissingRight() {
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
    void testEmtyLeft() {
        HashMap<Integer, Integer> first = new HashMap<>();
        first.put(1, 1);
        first.put(2, 2);
        first.put(3, 3);
        first.put(4, 4);

        HashMap<Integer, Integer> second = new HashMap<>();

        HashMap<Integer, Integer> expected = new HashMap<>();
        expected.put(1, 1);
        expected.put(2, 2);
        expected.put(3, 3);
        expected.put(4, 4);

        assertThat(task22.addPolynomials(first, second), is(expected));
    }

    @Test
    void testEmtyRight() {
        HashMap<Integer, Integer> first = new HashMap<>();

        HashMap<Integer, Integer> second = new HashMap<>();
        second.put(1, 1);
        second.put(3, 2);
        second.put(4, 3);

        HashMap<Integer, Integer> expected = new HashMap<>();
        expected.put(1, 1);
        expected.put(3, 2);
        expected.put(4, 3);

        assertThat(task22.addPolynomials(first, second), is(expected));
    }


}
