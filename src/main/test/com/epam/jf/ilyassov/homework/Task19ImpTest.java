package com.epam.jf.ilyassov.homework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task19ImpTest {

    @Test
    void Method() {
        int arr[][]=new int[3][3];
        int a=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j]=++a;
            }
        }
        int array[][]={{3,6,9},{2,5,8},{1,4,7}};
        int[][] ints = new Task19Imp().rotateMatrixCounterclockwise(arr);
        assertEquals(arr[0][0],ints[2][0]);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(ints[i][j],array[i][j]);
            }
        }


    }
}