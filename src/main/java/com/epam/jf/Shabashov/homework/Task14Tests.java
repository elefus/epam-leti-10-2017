package com.epam.jf.Shabashov.homework;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Task14Tests {
    private Task14 tt = new Task14();

    @Test
    public void test1() {
        int[][] matr = new int[][]{{1,5,9},{5,1,4},{3,7,15}};
        System.out.println(Arrays.deepToString(tt.sortMatrixByValuesInColumn(matr,0)));
        assertArrayEquals(new int[][]{{1,5,9},{3,7,15},{5,1,4}}, tt.sortMatrixByValuesInColumn(matr,0));
    }

    @Test
    public void test2() {
        int[][] matr = new int[][]{{1,5,9},{5,1,4},{3,7,15}};
        System.out.println(Arrays.deepToString(tt.sortMatrixByValuesInColumn(matr,1)));
        assertArrayEquals(new int[][]{{5,1,4},{1,5,9},{3,7,15}}, tt.sortMatrixByValuesInColumn(matr,1));
    }

    @Test
    public void test3() {
        int[][] matr = new int[][]{{1,5,9},{5,1,4},{3,7,15}};
        System.out.println(Arrays.deepToString(tt.sortMatrixByValuesInColumn(matr,2)));
        assertArrayEquals(new int[][]{{5,1,4},{1,5,9},{3,7,15}}, tt.sortMatrixByValuesInColumn(matr,2));
    }


}
