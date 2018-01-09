package com.epam.jf.kuchinskii.homework;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task14Test {

    @Test
    void testIntegerMaxValue() {
        Task14 solver = new Task14();
        int[][] matrix = {{1}, {1}};

        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                solver.sortMatrixByValuesInColumn(matrix, Integer.MAX_VALUE);
            }
        });
    }

    @Test
    void testZero() {
        Task14 solver = new Task14();
        int[][] matrix = {{9, 7, 6, 5, 4}, {3, 2, 1, 0, 1}, {4, 5, 6, 7, 8}, {4, 4, 4, 4, 4}, {9, 2, 8, 1, 5}};
        int[][] check  = {{3, 2, 1, 0, 1}, {4, 5, 6, 7, 8}, {4, 4, 4, 4, 4}, {9, 7, 6, 5, 4}, {9, 2, 8, 1, 5}};

        int[][] result = solver.sortMatrixByValuesInColumn(matrix, 0);

        assertTrue(Arrays.deepEquals(result, check));
    }

    @Test
    void testThree() {
        Task14 solver = new Task14();
        int[][] matrix = {{9, 7, 6, 5, 4}, {3, 2, 1, 0, 1}, {4, 5, 6, 7, 8}, {4, 4, 4, 4, 4}, {9, 2, 8, 1, 5}};
        int[][] check  = {{3, 2, 1, 0, 1}, {9, 2, 8, 1, 5}, {4, 4, 4, 4, 4}, {9, 7, 6, 5, 4}, {4, 5, 6, 7, 8}};

        int[][] result = solver.sortMatrixByValuesInColumn(matrix, 3);

        assertTrue(Arrays.deepEquals(result, check));
    }
}
