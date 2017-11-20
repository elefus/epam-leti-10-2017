package com.epam.jf.bavtovich.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task13Test {
    @Test
    void createSquareMatrix() {
        Task13 obj = new Task13();
        int[][] matr1 = {{1,2},
                         {3,4}};
        int[][] matr2 = {{1,2,3},
                         {4,5,6},
                         {7,8,9}};
        int[][] matr3 = {{1,2,3,4,5},
                         {6,7,8,9,10},
                         {11,12,13,14,15},
                         {16,17,18,19,20},
                         {21,22,23,24,25}};
        assertArrayEquals(obj.createSquareMatrix(2), matr1);
        assertArrayEquals(obj.createSquareMatrix(3), matr2);
        assertArrayEquals(obj.createSquareMatrix(5), matr3);
        assertArrayEquals(obj.createSquareMatrix(0), null);
        assertArrayEquals(obj.createSquareMatrix(-1), null);
    }

}