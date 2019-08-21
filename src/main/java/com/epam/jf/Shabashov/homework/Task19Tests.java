package com.epam.jf.Shabashov.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task19Test {
    private Task19 tt = new Task19();

    @Test
    void test1() {
        int[][] arr = new int[][]{{2}};
        int[][] check = tt.rotateMatrixCounterclockwise(arr);
        assertArrayEquals(check, new int[][]{{2}});
    }

    /**
     * 1 2
     * 3 4
     * <p>
     * 2 4
     * 1 3
     */
    @Test
    void test2() {
        int[][] arr = new int[][]{{1, 2}, {3, 4}};
        int[][] check = tt.rotateMatrixCounterclockwise(arr);
        assertArrayEquals(check, new int[][]{{2, 4}, {1, 3}});
    }

    /**
     * 1 2 3
     * 4 5 6
     * 7 8 9
     * <p>
     * 3 6 9
     * 2 5 9
     * 1 4 7
     */
    @Test
    void test3() {
        int[][] arr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] check = tt.rotateMatrixCounterclockwise(arr);
        assertArrayEquals(check, new int[][]{{3, 6, 9}, {2, 5, 8}, {1, 4, 7}});
    }


}