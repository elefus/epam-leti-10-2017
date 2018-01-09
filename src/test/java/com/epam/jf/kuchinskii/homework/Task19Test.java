package com.epam.jf.kuchinskii.homework;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class Task19Test {

    @Test
    public void testEmptyMatrix() {
        Task19 task = new Task19();
        int[][] matrix = {};

        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                int[][] result = task.rotateMatrixCounterclockwise(matrix);
            }
        });
    }

    @Test
    public void testZero() {
        Task19 task = new Task19();
        int[][] matrix = {{0}};
        int[][] result = task.rotateMatrixCounterclockwise(matrix);
        int[][] check = {{0}};
        assertArrayEquals(result, check);
    }

    @Test
    public void testSquare() {
        Task19 task = new Task19();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result = task.rotateMatrixCounterclockwise(matrix);
        int[][] check = {{3, 6, 9}, {2, 5, 8}, {1, 4, 7}};
        assertArrayEquals(result, check);
    }

    @Test
    public void testRow() {
        Task19 task = new Task19();
        int[][] matrix = {{1, 2, 3, 4, 5}};
        int[][] result = task.rotateMatrixCounterclockwise(matrix);
        int[][] check = {{5}, {4}, {3}, {2}, {1}};
        assertArrayEquals(result, check);
    }

    @Test
    public void testColumn() {
        Task19 task = new Task19();
        int[][] matrix = {{1}, {2}, {3}, {4}, {5}};
        int[][] result = task.rotateMatrixCounterclockwise(matrix);
        int[][] check = {{1, 2, 3, 4, 5}};
        assertArrayEquals(result, check);
    }

}
