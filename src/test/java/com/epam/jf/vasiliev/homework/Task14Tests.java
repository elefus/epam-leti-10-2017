package com.epam.jf.vasiliev.homework;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Task14Tests {
    Task14 ref = new Task14();

    @Test
    void testOnMatrixWithDifferentRowsLength() {
        int[][] src = {{9,7,7,8}, {1,6,3}, {44,5}};
        int[][] res = ref.sortMatrixByValuesInColumn(src, 1);
        assertArrayEquals(new int[][]{{44,5},{1,6,3},{9,7,7,8}},res);
    }

    @Test
    void testOnMatrixWithSameNumbersInSortingColumn() {
        int[][] src = {{1,7,7,8}, {1,6,3}, {1,5,4,5}};
        int[][] res = ref.sortMatrixByValuesInColumn(src, 0);
        assertArrayEquals(new int[][]{{1,7,7,8}, {1,6,3}, {1,5,4,5}},res);
    }

    @Test
    void testOnEmptyMatrix() {
        int[][] src = {};
        assertArrayEquals(new int[][]{}, ref.sortMatrixByValuesInColumn(src,0));
    }
}