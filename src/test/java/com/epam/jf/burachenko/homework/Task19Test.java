package com.epam.jf.burachenko.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task19Test {
    @Test
    void testRotateMatrixCounterclockwiseOneElement() {
        int[][] source = {{5}};
        assertArrayEquals(source, (new Task19()).rotateMatrixCounterclockwise(source));
    }

    @Test
    void testRotateMatrixCounterclockwiseSquare() {
        int[][] source = {{5, 2, 4},
                          {3, 7, 8},
                          {2, 4, 55}};
        assertArrayEquals(new int[][]{{4, 8, 55},
                                      {2, 7, 4},
                                      {5, 3, 2}},
                                      (new Task19()).rotateMatrixCounterclockwise(source));
    }

    @Test
    void testRotateMatrixCounterclockwiseNonSquare() {
        int[][] source = {{5, 2, 4},
                          {3, 7, 8},
                          {2, 4, 55},
                          {3, 7, 19}};
        assertArrayEquals(new int[][]{{4, 8, 55, 19},
                                      {2, 7, 4, 7},
                                      {5, 3, 2, 3}},
                (new Task19()).rotateMatrixCounterclockwise(source));
    }
}
