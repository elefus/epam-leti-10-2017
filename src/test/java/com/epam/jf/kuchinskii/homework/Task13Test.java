package com.epam.jf.kuchinskii.homework;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class Task13Test {
    @Test
    void testIntegerMaxValue() {
        Task13 solver = new Task13();

        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                solver.createSquareMatrix(Integer.MAX_VALUE);
            }
        });
    }

    @Test
    void testIntegerMinValue() {
        Task13 solver = new Task13();

        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                solver.createSquareMatrix(Integer.MIN_VALUE);
            }
        });
    }

    @Test
    void testZero() {
        Task13 solver = new Task13();

        int[][] result = solver.createSquareMatrix(0);
        int[][] check = {};

        assertTrue(Arrays.deepEquals(result, check));
    }

    @Test
    void testOne() {
        Task13 solver = new Task13();

        int[][] result = solver.createSquareMatrix(1);
        int[][] check = {{1}};

        assertTrue(Arrays.deepEquals(result, check));
    }

    @Test
    void testThree() {
        Task13 solver = new Task13();

        int[][] result = solver.createSquareMatrix(3);
        int[][] check = { {1,2,3}, {4,5,6}, {7,8,9} };

        assertTrue(Arrays.deepEquals(result, check));
    }

}
