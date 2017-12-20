package com.epam.jf.guba.homework;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.function.Executable;

public class Task14Test {

    private static int[][] matrix = {{-1,8,3},{4,5,6},{-7, 2, 4}};

    @Before
    public void createArray(){
        matrix = new int[][]{{-1, 8, 3}, {4, 5, 6}, {-7, 2, 4}};
    }

    @Test
    public void  testException(){
        Task14 task14 = new Task14();
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                task14.sortMatrixByValuesInColumn(new int[5][5], -1);
            }
        });
    }

    @Test
    public void testWithoutNegative(){
        Task14 task14 = new Task14();
        assertEquals(8, task14.sortMatrixByValuesInColumn(matrix, 1)[2][1]);
    }


    @Test
    public void testWithNegative(){
        Task14 task14 = new Task14();
        assertEquals(-1, task14.sortMatrixByValuesInColumn(matrix, 0)[1][0]);
    }

}