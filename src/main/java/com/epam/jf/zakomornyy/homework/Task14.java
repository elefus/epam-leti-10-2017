package com.epam.jf.zakomornyy.homework;


public class Task14 extends com.epam.jf.common.homework.Task14 {
    @Override
    public int[][] sortMatrixByValuesInColumn(int[][] matrix, int indexColumn) {
        for (int min = 0; min < matrix.length - 1; min++) {
            int least = min;
            for (int j = min + 1; j < matrix.length; j++) {
                if (matrix[j][indexColumn] < matrix[least][indexColumn]) {
                    least = j;
                }
            }
            int[] tmp = matrix[min];
            matrix[min] = matrix[least];
            matrix[least] = tmp;
        }
        return matrix;
    }


}
