package com.epam.jf.vasiliev.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task13Tests {
    Task13 ref = new Task13();

    @Test
    void testOnEmptyMatrix() {
        int[][] result = ref.createSquareMatrix(0);
        assertEquals(0,result.length);
    }

    @Test
    void testOnOneElMatrix() {
        int[][] result = ref.createSquareMatrix(1);
        assertEquals(1,result[0][0]);
    }

    @Test
    void testThreeDimensionMatrix() {
        final int dimension = 100;
        int[][] result = ref.createSquareMatrix(dimension);

        for (int j = 0; j < dimension; j++) {
            int crtElem = j+1;
            for (int i = 0; i < dimension; i++, crtElem += dimension) {
                assertEquals(crtElem, result[i][j]);
            }
        }
    }

    @Test
    void testOneHundredDimensionMatrix() {
        final int dimension = 3;
        int[][] result = ref.createSquareMatrix(dimension);

        for (int j = 0; j < dimension; j++) {
            int crtElem = j+1;
            for (int i = 0; i < dimension; i++, crtElem += dimension) {
                assertEquals(crtElem, result[i][j]);
            }
        }
    }
}