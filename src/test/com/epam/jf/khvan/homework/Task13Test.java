package com.epam.jf.khvan.homework;

import com.epam.jf.common.homework.Task13;
import org.junit.Test;

import java.lang.reflect.Executable;
import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;

public class Task13Test {

    @Test
    void testZero() {
        Task13 solver = new Task13Implement();

        int[][] result = solver.createSquareMatrix(0);
        int[][] check = {};

        assertTrue(Arrays.deepEquals(result, check));
    }

    @Test
    void testOne() {
        Task13 solver = new Task13Implement();

        int[][] result = solver.createSquareMatrix(1);
        int[][] check = {{1}};

        assertTrue(Arrays.deepEquals(result, check));
    }

    @Test
    void testThree() {
        Task13 solver = new Task13Implement();

        int[][] result = solver.createSquareMatrix(3);
        int[][] check = { {1,2,3}, {4,5,6}, {7,8,9} };

        assertTrue(Arrays.deepEquals(result, check));
    }
}

