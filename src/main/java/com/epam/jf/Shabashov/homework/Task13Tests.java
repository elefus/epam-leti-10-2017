package com.epam.jf.Shabashov.homework;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Task13Tests {
    private Task13 tt = new Task13();

    @Test
    void test1() {
        System.out.println(Arrays.deepToString(tt.createSquareMatrix(1)));
        assertArrayEquals(new int[][]{{1}}, tt.createSquareMatrix(1));
    }

    @Test
    void test2() {
        System.out.println(Arrays.deepToString(tt.createSquareMatrix(2)));
        assertArrayEquals(new int[][]{{1, 2}, {3, 4}}, tt.createSquareMatrix(2));
    }

    @Test
    void test3() {
        System.out.println(Arrays.deepToString(tt.createSquareMatrix(3)));
        assertArrayEquals(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, tt.createSquareMatrix(3));
    }

    @Test
    void test4() {
        System.out.println(Arrays.deepToString(tt.createSquareMatrix(4)));
        assertArrayEquals(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}, tt.createSquareMatrix(4));
    }

}
