package com.epam.jf.ilyinykh.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task14SolutionTest {
    @Test
    void sortMatrixByValuesInColumn() {
        int[][] matrix = {{1, 2 ,3}, {3, 2, 1}, {1, 1, 2}};
        new Task14Solution().sortMatrixByValuesInColumn(matrix, 2);
        assertTrue(matrix[0][0] == 3);
    }

}