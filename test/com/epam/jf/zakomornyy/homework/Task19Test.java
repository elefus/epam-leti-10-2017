package com.epam.jf.zakomornyy.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task19Test {
    @Test
    void rotateMatrixCounterclockwise() {
        int[][] array = new Task19().rotateMatrixCounterclockwise(new int[][]{{3, 5}, {6, 7}});
        int[][] anotherArray = {{5, 7}, {3, 6}};
        for(int i = 0; i < anotherArray.length; i++) {
            for(int j = 0; j < anotherArray[i].length; j++) {
                assertEquals(array[i][j], anotherArray[i][j]);
            }
        }
    }

    @Test
    void rotateMatrixCounterclockwise2() {
        int[][] array = new Task19().rotateMatrixCounterclockwise(new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}});
        int[][] anotherArray = {{5, 10}, {4, 9}, {3, 8}, {2, 7}, {1, 6}};
        for(int i = 0; i < anotherArray.length; i++) {
            for(int j = 0; j < anotherArray[i].length; j++) {
                assertEquals(array[i][j], anotherArray[i][j]);
            }
        }
    }
}