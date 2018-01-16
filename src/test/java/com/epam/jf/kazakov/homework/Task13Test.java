package com.epam.jf.kazakov.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task13Test {
    @Test
    void createSquareMatrix() {
        Task13 test = new Task13();

        int[][] expectedSquareMatrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        assertArrayEquals(expectedSquareMatrix, test.createSquareMatrix(3));
    }

}