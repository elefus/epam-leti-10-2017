package com.epam.jf.kruglik.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task19Test {

    @Test
    void rotateSquareMatrix() {
        int[][] matr = {{1,2,3},
                        {1,2,3},
                        {1,2,3}};
        int[][] resMatr = {{3,3,3},
                           {2,2,2},
                           {1,1,1}};
        int[][] transpMatr = new Task19().rotateMatrixCounterclockwise(matr);
        assertArrayEquals(transpMatr,resMatr);
    }

    @Test
    void rotateNotSquareMatrixWightHighter() {
        int[][] matr = {{1,2},
                        {1,2},
                        {1,2}};
        int[][] resMatr = {{2,2,2},
                           {1,1,1}};
        int[][] transpMatr = new Task19().rotateMatrixCounterclockwise(matr);
        assertArrayEquals(transpMatr,resMatr);
    }

    @Test
    void rotateNonSquareMatrixHeightHighter() {
        int[][] matr = {{1,2,3},
                        {1,2,3}};
        int[][] resMatr = {{3,3},
                           {2,2},
                           {1,1}};
        int[][] transpMatr = new Task19().rotateMatrixCounterclockwise(matr);
        assertArrayEquals(transpMatr,resMatr);
    }
}