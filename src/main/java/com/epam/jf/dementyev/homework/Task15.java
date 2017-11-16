package com.epam.jf.dementyev.homework;

public class Task15 extends com.epam.jf.common.homework.Task15 {

    @Override
    public int[][] verticalCyclicShift(int[][] matrix, int numberShifts) {
        if (matrix == null) {
            throw new IllegalArgumentException("matrix is null");
        }

        int[][] newMatrix = new int[matrix.length][];

        if (matrix.length != 0 && numberShifts % matrix.length != 0) {
            numberShifts %= matrix.length;
            for (int i = 0; i < newMatrix.length; i++) {
                int index = (i + numberShifts) % newMatrix.length;
                if (index < 0) {
                    index += newMatrix.length;
                }
                newMatrix[index] = matrix[i];
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            newMatrix[i] = (newMatrix[i] != null) ? newMatrix[i].clone() : matrix[i].clone();
        }
        return newMatrix;
    }

    @Override
    public int[][] horizontalCyclicShift(int[][] matrix, int numberShifts) {
        if (matrix == null) {
            throw new IllegalArgumentException("matrix is null");
        }

        int[][] newMatrix = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            newMatrix[i] = matrix[i].clone();
        }

        for (int i = 0; i < newMatrix.length; i++) {
            if (newMatrix[i].length != 0 && numberShifts % newMatrix[i].length != 0) {
                for (int j = 0; j < newMatrix[i].length; j++) {
                    int index = (j + (numberShifts % newMatrix[i].length)) % newMatrix[i].length;
                    if (index < 0) {
                        index += newMatrix[i].length;
                    }
                    newMatrix[i][index] = matrix[i][j];
                }
            }
        }
        return newMatrix;
    }
}
