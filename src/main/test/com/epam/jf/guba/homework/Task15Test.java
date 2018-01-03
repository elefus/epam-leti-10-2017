package com.epam.jf.guba.homework;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.function.Executable;

public class Task15Test {

    private static int[][] matrix;

    @Before
    public void initMatrix() {
        matrix = new int[][]{
            {1, 2, 3},      //1 4 7
            {4, 5, 6},      //2 5 8
            {7, 8, 9}       //3 6 9
        };
    }


    @Test
    public void testFirstMethodException() {
        Task15 task15 = new Task15();
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                task15.verticalCyclicShift(new int[0][0], 1);
            }
        });
    }

    @Test
    public void testSecondMethodException() {
        Task15 task15 = new Task15();
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                task15.horizontalCyclicShift(null, 1);
            }
        });
    }

    @Test
    public void testPositiveVertical() {
        Task15 task15 = new Task15();
        assertArrayEquals(new int[]{7, 8, 9}, task15.verticalCyclicShift(matrix, 5)[1]);
    }

    @Test
    public void testNegativeVertical() {
        Task15 task15 = new Task15();
        assertArrayEquals(new int[]{1, 2, 3}, task15.verticalCyclicShift(matrix, -2)[1]);
    }

    @Test
    public void testPositiveHorisontal() {
        Task15 task15 = new Task15();
        matrix = task15.horizontalCyclicShift(matrix, 2);
        int[] collunm = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            collunm[i] = matrix[i][1];
        }
        assertArrayEquals(new int[]{3, 6, 9}, collunm);
    }
    @Test
    public void testNegativeHorisontal() {
        Task15 task15 = new Task15();
        matrix = task15.horizontalCyclicShift(matrix, -2);
        int[] collunm = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            collunm[i] = matrix[i][1];
        }
        assertArrayEquals(new int[]{1, 4, 7}, collunm);
    }


}