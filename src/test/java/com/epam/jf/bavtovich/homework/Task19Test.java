package com.epam.jf.bavtovich.homework;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

class Task19Test {
    @Test
    void rotateMatrixCounterclockwise() {
        int[][] matr1 = {{1,2,3},
                         {4,5,6},
                         {7,8,9},
                         {10,11,12},
                         {13,14,15}};
        Task19 obj = new Task19();
        int[][] ans1 = {{3, 6, 9, 12, 15},
                        {2, 5, 8, 11, 14},
                        {1, 4, 7, 10, 13}};
        assertArrayEquals(obj.rotateMatrixCounterclockwise(matr1), ans1);
    }    
}