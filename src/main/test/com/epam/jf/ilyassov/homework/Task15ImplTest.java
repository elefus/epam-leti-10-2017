package com.epam.jf.ilyassov.homework;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
class Task15ImplTest {
    @Test
    void TestVerticalCyclicShift() {
        Task15Impl task15=new Task15Impl();
        int arr[][]=new int[3][3];
        int a=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j]=++a;
            }
        }
        int[][] ints = task15.verticalCyclicShift(arr, 3);
        int[][] ints2 = task15.verticalCyclicShift(arr, 9);
        assertEquals(ints,arr);
        assertEquals(ints2,ints);

    }

    @Test
    void TestHorizontalCyclicShift() {
        Task15Impl task15=new Task15Impl();
        int arr[][]=new int[3][3];
        int a=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j]=++a;
            }
        }
        int[][] ints = task15.verticalCyclicShift(arr, 6);
        int[][] ints2 = task15.verticalCyclicShift(arr, 0);
        int[][] ints3 = task15.verticalCyclicShift(arr, 2);
        int[][] ints4 = task15.verticalCyclicShift(arr, 1);
        assertEquals(ints,arr);
        assertEquals(ints2,ints);
        assertFalse(ints3.equals(ints4));

    }
}