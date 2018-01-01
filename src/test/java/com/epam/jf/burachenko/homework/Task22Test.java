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
        System.out.println(first);

        HashMap<Integer, Integer> second = new HashMap<>();
        second.put(0, 5);
        second.put(3, 4);
        second.put(2, 4);
        System.out.println(second);

        HashMap<Integer, Integer> result = T.addPolynomials(first, second);
        System.out.println(result);
    }
}