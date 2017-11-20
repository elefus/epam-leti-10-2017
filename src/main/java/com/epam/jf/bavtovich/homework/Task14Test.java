package com.epam.jf.bavtovich.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task14Test {
    @Test
    void sortMatrixByValuesInColumn() {
        int[][] matr = {{1,2,5,4,9}, {8,6,1,5,9}, {5,6,4,3,8}, {8,5,6,4,1}};
        int[][] matr2 = {{1,2,5,4,9}, {5,6,4,3,8}, {8,6,1,5,9}, {8,5,6,4,1}};
        int[][] matr3 = {{1,2,5,4,9}, {8,5,6,4,1}, {8,6,1,5,9}, {5,6,4,3,8}};
        int[][] matr4 = {{8,6,1,5,9}, {5,6,4,3,8}, {1,2,5,4,9}, {8,5,6,4,1}};
        int[][] matr5 = {{5,6,4,3,8}, {1,2,5,4,9}, {8,5,6,4,1}, {8,6,1,5,9}};
        int[][] matr6 = {{8,5,6,4,1}, {5,6,4,3,8}, {1,2,5,4,9}, {8,6,1,5,9}};


        Task14 obj = new Task14();
        assertArrayEquals(obj.sortMatrixByValuesInColumn(matr, 0), matr2);
        assertArrayEquals(obj.sortMatrixByValuesInColumn(matr, 1), matr3);
        assertArrayEquals(obj.sortMatrixByValuesInColumn(matr, 2), matr4);
        assertArrayEquals(obj.sortMatrixByValuesInColumn(matr, 3), matr5);
        assertArrayEquals(obj.sortMatrixByValuesInColumn(matr, 4), matr6);
        assertThrows(IndexOutOfBoundsException.class, () -> obj.sortMatrixByValuesInColumn(matr, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> obj.sortMatrixByValuesInColumn(matr, 5));

    }

}