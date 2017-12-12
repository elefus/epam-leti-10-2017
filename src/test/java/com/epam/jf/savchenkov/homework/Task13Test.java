package com.epam.jf.savchenkov.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task13Test {

    @Test
    void testArraysEquals() {
        Task13 task13 = new Task13();

        int [][] expected = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        assertArrayEquals(expected, task13.createSquareMatrix(4));
    }
}