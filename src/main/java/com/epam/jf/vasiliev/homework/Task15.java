package com.epam.jf.vasiliev.homework;

public class Task15 extends com.epam.jf.common.homework.Task15 {

    @Override
    public int[][] verticalCyclicShift(int[][] matrix, int numberShifts) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] resMatrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            int newPos = countPosAfterShift(rows,numberShifts,i);
            for (int j = 0; j < columns; j++) {
                resMatrix[newPos][j] = matrix[i][j];
            }
        }

        return resMatrix;
    }

    private int countPosAfterShift(int size,int numberShifts, int crtPosition) {
        int newPosition = (crtPosition + numberShifts) % size;
        return newPosition >= 0 ? newPosition : size + newPosition;
    }

    @Override
    public int[][] horizontalCyclicShift(int[][] matrix, int numberShifts) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] resMatrix = new int[rows][columns];

        for (int i = 0; i < columns; i++) {
            int newPos = countPosAfterShift(columns,numberShifts,i);
            for (int j = 0; j < rows; j++) {
                resMatrix[j][newPos] = matrix[j][i];
            }
        }

        return resMatrix;
    }
}
