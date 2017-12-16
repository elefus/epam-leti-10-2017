package com.epam.jf.guba.homework;

public class Task14 extends com.epam.jf.common.homework.Task14 {

    @Override
    public int[][] sortMatrixByValuesInColumn(int[][] matrix, int indexColumn) {
        if (indexColumn < 0 || indexColumn >= matrix.length) {
            throw new IllegalArgumentException("indexColumn is out of bound");
        }
        int[][] newMatrix = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                newMatrix[i][j] = matrix[i][j];
            }
        }
        int[] temp;
        int j;
        for (int i = 0; i < newMatrix.length - 1; i++) {
            if (newMatrix[i][indexColumn] > newMatrix[i + 1][indexColumn]) {
                temp = newMatrix[i + 1];
                newMatrix[i + 1] = newMatrix[i];
                j = i;
                while (j > 0 && temp[indexColumn] < newMatrix[j - 1][indexColumn]) {
                    newMatrix[j] = newMatrix[j - 1];
                    j--;
                }
                newMatrix[j] = temp;
            }
        }
        return newMatrix;
    }
}
