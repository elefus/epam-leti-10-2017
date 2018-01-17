package com.epam.jf.kazakov.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task14Test {

    @Test
    void sortMatrixByValuesInColumn() {
        Task14 test = new Task14();
        int matrix[][] = {
                {3, 6, 5},
                {2, 1, 4},
                {-2, 9, -1}
        };

        assertEquals(test.sortMatrixByValuesInColumn(matrix, 2)[0][2], -1);
        assertEquals(test.sortMatrixByValuesInColumn(matrix, 1)[0][1], 1);
        assertEquals(test.sortMatrixByValuesInColumn(matrix, 0)[2][0], 3);

    }

}