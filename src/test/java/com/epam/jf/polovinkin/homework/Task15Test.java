package com.epam.jf.polovinkin.homework;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Task15Test {

    @Test
    void verticalCyclicShiftUpTest1() {
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[][] arr = new Task15().verticalCyclicShift(matrix, -2);
        System.out.println(Arrays.deepToString(arr));
        assertArrayEquals(new int[]{7, 8, 9}, arr[0]);
        assertArrayEquals(new int[]{1, 2, 3}, arr[1]);
        assertArrayEquals(new int[]{4, 5, 6}, arr[2]);
    }

    @Test
    void verticalCyclicShiftUpTest2() {
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[][] arr = new Task15().verticalCyclicShift(matrix, -1);
        System.out.println(Arrays.deepToString(arr));
        assertArrayEquals(new int[]{4, 5, 6}, arr[0]);
        assertArrayEquals(new int[]{7, 8, 9}, arr[1]);
        assertArrayEquals(new int[]{1, 2, 3}, arr[2]);
    }

    @Test
    void verticalCyclicShiftIdle() {
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[][] arr = new Task15().verticalCyclicShift(matrix, 0);
        System.out.println(Arrays.deepToString(arr));
        assertArrayEquals(new int[]{1, 2, 3}, arr[0]);
        assertArrayEquals(new int[]{4, 5, 6}, arr[1]);
        assertArrayEquals(new int[]{7, 8, 9}, arr[2]);
    }

    @Test
    void verticalCyclicShiftDownTest1() {
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[][] arr = new Task15().verticalCyclicShift(matrix, 1);
        System.out.println(Arrays.deepToString(arr));
        assertArrayEquals(new int[]{7, 8, 9}, arr[0]);
        assertArrayEquals(new int[]{1, 2, 3}, arr[1]);
        assertArrayEquals(new int[]{4, 5, 6}, arr[2]);
    }

    @Test
    void verticalCyclicShiftDownTest2() {
        int[][] matrix = {{1, 2, 3},
                          {4, 5, 6},
                          {7, 8, 9}};
        int[][] arr = new Task15().verticalCyclicShift(matrix, 2);
        System.out.println(Arrays.deepToString(arr));
        assertArrayEquals(new int[]{4, 5, 6}, arr[0]);
        assertArrayEquals(new int[]{7, 8, 9}, arr[1]);
        assertArrayEquals(new int[]{1, 2, 3}, arr[2]);
    }

    @Test
    void verticalCyclicShiftDown7rows() {
        int[][] matrix = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 0}, {1, 1}, {2, 2}};
        int[][] arr = new Task15().verticalCyclicShift(matrix, 3);
        System.out.println(Arrays.deepToString(arr));

        assertArrayEquals(new int[]{9, 0}, arr[0]);
        assertArrayEquals(new int[]{1, 1}, arr[1]);
        assertArrayEquals(new int[]{2, 2}, arr[2]);
        assertArrayEquals(new int[]{1, 2}, arr[3]);
        assertArrayEquals(new int[]{3, 4}, arr[4]);
        assertArrayEquals(new int[]{5, 6}, arr[5]);
        assertArrayEquals(new int[]{7, 8}, arr[6]);

    }

    @Test
    void horizontalCiclicShift() {
        int[][] matrix = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 0}, {1, 1}, {2, 2}};
        int[][] arr = new Task15().horizontalCyclicShift(matrix, 1);
        System.out.println(Arrays.deepToString(arr));

        assertArrayEquals(new int[]{2, 1}, arr[0]);
        assertArrayEquals(new int[]{4, 3}, arr[1]);
        assertArrayEquals(new int[]{6, 5}, arr[2]);
        assertArrayEquals(new int[]{8, 7}, arr[3]);
        assertArrayEquals(new int[]{0, 9}, arr[4]);
        assertArrayEquals(new int[]{1, 1}, arr[5]);
        assertArrayEquals(new int[]{2, 2}, arr[6]);

    }

    @Test
    void horizontalCyclicShiftLeftTest1() {
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[][] arr = new Task15().horizontalCyclicShift(matrix, -2);
        System.out.println(Arrays.deepToString(arr));
        assertArrayEquals(new int[]{3, 1, 2}, arr[0]);
        assertArrayEquals(new int[]{6, 4, 5}, arr[1]);
        assertArrayEquals(new int[]{9, 7, 8}, arr[2]);
    }

    @Test
    void horizontalCyclicShiftRightTest1() {
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[][] arr = new Task15().horizontalCyclicShift(matrix, 2);
        System.out.println(Arrays.deepToString(arr));
        assertArrayEquals(new int[]{2, 3, 1}, arr[0]);
        assertArrayEquals(new int[]{5, 6, 4}, arr[1]);
        assertArrayEquals(new int[]{8, 9, 7}, arr[2]);
    }
}