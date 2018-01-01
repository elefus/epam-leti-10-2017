package com.epam.jf.burachenko.homework;

import java.util.Arrays;

public class Task15 extends com.epam.jf.common.homework.Task15 {
    @Override
    public int[][] verticalCyclicShift(int[][] matrix, int numberShifts) {
        if(numberShifts == 0 || numberShifts%matrix.length == 0) {
            return Arrays.copyOf(matrix, matrix.length);
        }

        if(numberShifts > matrix.length || numberShifts*(-1) > matrix.length) {
            numberShifts = numberShifts%matrix.length;
        }

        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            newMatrix[i] = Arrays.copyOf(matrix[(i+matrix.length-numberShifts)%matrix.length], matrix[i].length);
        }

        return newMatrix;
    }

    @Override
    public int[][] horizontalCyclicShift(int[][] matrix, int numberShifts) {
        if(numberShifts == 0 || numberShifts%matrix[0].length == 0) {
            return Arrays.copyOf(matrix, matrix.length);
        }

        return trans(verticalCyclicShift(trans(matrix), numberShifts));
    }
    
    private int[][] trans(int[][] matrix) {
        int[][] newMatrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                newMatrix[i][j] = matrix[j][i];
            }
        }
        return newMatrix;
    }
}
