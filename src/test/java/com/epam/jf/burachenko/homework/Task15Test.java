package com.epam.jf.burachenko.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task15Test {
    @Test
    void testVerticalCyclicShiftZero() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}};
        Task15 test = new Task15();
        int[][] newMatrix = test.verticalCyclicShift(matrix, 0);
        assertArrayEquals(matrix, newMatrix);
    }

    @Test
    void testVerticalCyclicShiftPositive() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };
        Task15 test = new Task15();
        int[][] newMatrix = test.verticalCyclicShift(matrix, 2);
        assertArrayEquals(new int[][]{
                        {7, 8, 9},
                        {10, 11, 12},
                        {1, 2, 3},
                        {4, 5, 6}},
                          newMatrix);
    }

    @Test
    void testVerticalCyclicShiftNegative() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}};
        Task15 test = new Task15();
        int[][] newMatrix = test.verticalCyclicShift(matrix, -2);
        assertArrayEquals(new int[][]{
                        {7, 8, 9},
                        {10, 11, 12},
                        {1, 2, 3},
                        {4, 5, 6}},
                newMatrix);
    }

    @Test
    void testVerticalCyclicShiftMoreThanMatrixLength() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}};
        Task15 test = new Task15();
        int[][] newMatrix = test.verticalCyclicShift(matrix, 7);
        assertArrayEquals(new int[][]{
                        {4, 5, 6},
                        {7, 8, 9},
                        {10, 11, 12},
                        {1, 2, 3}},
                          newMatrix);
    }

    @Test
    void testVerticalCyclicShiftLessThanNegativeMatrixLength() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}};
        Task15 test = new Task15();
        int[][] newMatrix = test.verticalCyclicShift(matrix, -7);
        assertArrayEquals(new int[][]{
                        {10, 11, 12},
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}},
                          newMatrix);
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test
    void testHorizontalCyclicShiftZero() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}};
        Task15 test = new Task15();
        int[][] newMatrix = test.horizontalCyclicShift(matrix, 0);
        assertArrayEquals(matrix, newMatrix);
    }

    @Test
    void testHorizontalCyclicShiftPositive() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };
        Task15 test = new Task15();
        int[][] newMatrix = test.horizontalCyclicShift(matrix, 2);
        assertArrayEquals(new int[][]{
                        {2, 3, 1},
                        {5, 6, 4},
                        {8, 9, 7},
                        {11, 12, 10}},
                newMatrix);
    }

    @Test
    void testHorizontalCyclicShiftNegative() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}};
        Task15 test = new Task15();
        int[][] newMatrix = test.horizontalCyclicShift(matrix, -2);
        assertArrayEquals(new int[][]{
                        {3, 1, 2},
                        {6, 4, 5},
                        {9, 7, 8},
                        {12, 10, 11}},
                newMatrix);
    }

    @Test
    void testHorizontalCyclicShiftMoreThanMatrixLength() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}};
        Task15 test = new Task15();
        int[][] newMatrix = test.horizontalCyclicShift(matrix, 7);
        assertArrayEquals(new int[][]{
                        {3, 1, 2},
                        {6, 4, 5},
                        {9, 7, 8},
                        {12, 10, 11}},
                newMatrix);
    }

    @Test
    void testHorizontalCyclicShiftLessThanNegativeMatrixLength() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}};
        Task15 test = new Task15();
        int[][] newMatrix = test.horizontalCyclicShift(matrix, -7);
        assertArrayEquals(new int[][]{
                        {2, 3, 1},
                        {5, 6, 4},
                        {8, 9, 7},
                        {11, 12, 10}},
                newMatrix);
    }
}