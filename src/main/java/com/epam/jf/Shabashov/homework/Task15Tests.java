package com.epam.jf.Shabashov.homework;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Task15Tests {
    private Task15 tt = new Task15();

    @Test
    public void test1() {
        int[][] matr = new int[][]{{1,5,9},{5,1,4},{3,7,15}};
        System.out.println(Arrays.deepToString(tt.verticalCyclicShift(matr,2)));
        assertArrayEquals(new int[][]{{5,1,4},{3,7,15},{1,5,9}}, tt.verticalCyclicShift(matr,2));

    }

    @Test
    public void test2() {
        int[][] matr = new int[][]{{1,5,9},{5,1,4},{3,7,15}};
        System.out.println(Arrays.deepToString(tt.verticalCyclicShift(matr,-5)));
        assertArrayEquals(new int[][]{{3,7,15},{1,5,9},{5,1,4}}, tt.verticalCyclicShift(matr,-2));
    }

    @Test
    public void test3() {
        int[][] matr = new int[][]{{1,5,9},{5,1,4},{3,7,15}};
        System.out.println(Arrays.deepToString(tt.horizontalCyclicShift(matr,4)));
        assertArrayEquals(new int[][]{{9,1,5},{4,5,1},{15,3,7}}, tt.horizontalCyclicShift(matr,4));
    }
    @Test
    public void test4() {
        int[][] matr = new int[][]{{1,5,9},{5,1,4},{3,7,15}};
        System.out.println(Arrays.deepToString(tt.horizontalCyclicShift(matr,-5)));
        assertArrayEquals(new int[][]{{9,1,5},{4,5,1},{15,3,7}}, tt.horizontalCyclicShift(matr,-5));
    }



}
