package com.epam.jf.vasiliev.homework;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Task19Test {
    Task19 ref = new Task19();

    @Test
    void testOnSquareMatrixThreeOnThree() {
        int[][] src = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        int[][] expected = {{3, 6, 9},
                {2, 5, 8},
                {1, 4, 7}};
        int[][] res = ref.rotateMatrixCounterclockwise(src);

        System.out.println(Arrays.deepToString(res));
        assertArrayEquals(expected, res);
    }

    @Test
    void testOnEmptyMatrix() {
        int[][] src = new int[0][0];
        int[][] expected = new int[0][0];
        int[][] res = ref.rotateMatrixCounterclockwise(src);

        System.out.println(Arrays.deepToString(res));
        assertArrayEquals(expected, res);
    }

    @Test
    void testOnNonSquareMatrixThreeOnFour() {
        int[][] src = {{1, 2, 3, 10},
                {4, 5, 6, 11},
                {7, 8, 9, 12}};

        int[][] expected = { {10, 11, 12},
                {3, 6, 9},
                {2, 5, 8},
                {1, 4, 7}};
        int[][] res = ref.rotateMatrixCounterclockwise(src);

        System.out.println(Arrays.deepToString(res));
        assertArrayEquals(expected, res);
    }

    @Test
    void testOnNonSquareMatrixFourOnThree() {
        int[][] src = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}};

        int[][] expected = {{3, 6, 9, 12},
                {2, 5, 8, 11},
                {1, 4, 7, 10}};
        int[][] res = ref.rotateMatrixCounterclockwise(src);

        System.out.println(Arrays.deepToString(res));
        assertArrayEquals(expected, res);
    }
}