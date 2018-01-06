package com.epam.jf.vasiliev.homework;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Task19Test {
    Task19 ref = new Task19();


    @Test
    void testOnSquareMatrixThreeOnThree() {
        int[][] src = {{1, 2, 3},
                       {4, 5, 6},
                       {7, 8, 9}};
        System.out.println(Arrays.deepToString(src));
    }

}