package com.epam.jf.vasiliev.homework;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Task15Test {
    Task15 ref = new Task15();

    @Test
    void testVerticalOnZero() {
        int[][] src = new int[][]{{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};

        int[][] expected = new int[][] {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};


        int[][] result = ref.verticalCyclicShift(src,0);
        assertArrayEquals(expected, result);
    }

    @Test
    void testVerticalOnTwoUp() {
        int[][] src = new int[][]{{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};

        int[][] expected = new int[][] {{9, 10, 11, 12},
                {1, 2, 3, 4},
                {5, 6, 7, 8}};


        int[][] result = ref.verticalCyclicShift(src,-2);
        assertArrayEquals(expected, result);
    }

    @Test
    void testVerticalOnTwoDown() {
        int[][] src = new int[][]{{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};

        int[][] expected = new int[][] {{5, 6, 7, 8},
                {9, 10, 11, 12},
                {1, 2, 3, 4}};


        int[][] result = ref.verticalCyclicShift(src,2);
        assertArrayEquals(expected, result);
    }

    @Test
    void testHorizontalOnZero() {
        int[][] src = new int[][]{{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};

        int[][] expected = new int[][] {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};


        int[][] result = ref.horizontalCyclicShift(src,0);
        assertArrayEquals(expected, result);
    }

    @Test
    void testHorizontalOnOneLeft() {
        int[][] src = new int[][]{{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};

        int[][] expected = new int[][] {{2, 3, 4, 1},
                {6, 7, 8, 5},
                {10, 11, 12, 9}};


        int[][] result = ref.horizontalCyclicShift(src,-1);
        assertArrayEquals(expected, result);
    }

    @Test
    void testHorizontalOnThreeRight() {
        int[][] src = new int[][]{{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};

        int[][] expected = new int[][] {{2, 3, 4, 1},
                {6, 7, 8, 5},
                {10, 11, 12, 9}};


        int[][] result = ref.horizontalCyclicShift(src,3);
        assertArrayEquals(expected, result);
    }
}