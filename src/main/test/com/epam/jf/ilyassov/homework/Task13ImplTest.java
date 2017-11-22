package com.epam.jf.ilyassov.homework;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task13ImplTest {

    @Test
    void createSquareMatrixTest() {
        Task13Impl task13 = new Task13Impl();
        int[][] ints1=task13.createSquareMatrix(1);
        int[][] ints3=task13.createSquareMatrix(3);
        int[][] temp1={{1}};
        int[][] temp3={{1,2,3},{4,5,6},{7,8,9}};

        assertArrayEquals(ints1,temp1);
        assertArrayEquals(ints3,temp3);


    }
}