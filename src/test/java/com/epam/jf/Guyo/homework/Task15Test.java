package com.epam.jf.Guyo.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task15Test {

    Task15 task15 = new Task15();

    @Test
    void verticalCyclicShiftMatrix1X1() {
        int[][] source = {{11}};
        int[][] output = {{11}};
        int numberShifts = 3;
        assertArrayEquals(output, task15.verticalCyclicShift(source, numberShifts));
    }

    @Test
    void verticalCyclicShiftMatrix2X4() {
        int[][] source = {{11, 12, 13, 14}, {21, 22, 23, 24}};
        int[][] output = {{11, 12, 13, 14}, {21, 22, 23, 24}};
        int numberShifts = 4;
        assertArrayEquals(output, task15.verticalCyclicShift(source, numberShifts));
    }

    @Test
    void verticalCyclicShiftMatrix3X3() {
        int[][] source = {{11, 12, 13}, {21, 22, 23}, {31, 32, 33}};
        int[][] output = {{21, 22, 23}, {31, 32, 33}, {11, 12, 13}};
        int numberShifts = 5;
        assertArrayEquals(output, task15.verticalCyclicShift(source, numberShifts));
    }

    @Test
    void horizontalCyclicShift1X1() {
        int[][] source = {{11}};
        int[][] output = {{11}};
        int numberShifts = -0;
        assertArrayEquals(output, task15.horizontalCyclicShift(source, numberShifts));
    }

    @Test
    void horizontalCyclicShift2X4() {
        int[][] source = {{11, 12, 13, 14}, {21, 22, 23, 24}};
        int[][] output = {{12, 13, 14, 11}, {22, 23, 24, 21}};
        int numberShifts = -1;
        assertArrayEquals(output, task15.horizontalCyclicShift(source, numberShifts));
    }

    @Test
    void horizontalCyclicShift3X3() {
        int[][] source = {{11, 12, 13}, {21, 22, 23}, {31, 32, 33}};
        int[][] output = {{11, 12, 13}, {21, 22, 23}, {31, 32, 33}};
        int numberShifts = -9;
        assertArrayEquals(output, task15.horizontalCyclicShift(source, numberShifts));
    }
}