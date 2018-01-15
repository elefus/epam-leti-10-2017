package com.epam.jf.yessenbayev.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task14Test {
    Task14 tester = new Task14();
    @Test
    void test1() {
        int[][] matrix = {
                {4, 5},
                {1, 2},

        };

        int[][] expected = {
                {1, 2},
                {4, 5},

        };
        assertArrayEquals(expected, tester.sortMatrixByValuesInColumn(matrix, 0));
    }

    @Test
    void test2() {
        int[][] matrix = {
                {1, 1, 1, 1, 1, 1},
                {3, 3, 3, 3, 3, 3},
                {2, 2, 2, 2, 2, 2}

        };

        int[][] expected = {
                {1, 1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2, 2},
                {3, 3, 3, 3, 3, 3}

        };
        assertArrayEquals(expected, tester.sortMatrixByValuesInColumn(matrix, 0));
    }

    @Test
    void test3() {
        assertThrows(IllegalArgumentException.class, () -> tester.sortMatrixByValuesInColumn(new int[1][2], -1));
    }


}