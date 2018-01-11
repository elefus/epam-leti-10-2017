package com.epam.jf.zakomornyy.homework;


public class Task14 extends com.epam.jf.common.homework.Task14 {
    @Override
    public int[][] sortMatrixByValuesInColumn(int[][] matrix, int indexColumn) {
        int[][] resultMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i){
            System.arraycopy(matrix[i], 0, resultMatrix[i], 0, matrix[0].length);
        }
        for (int min = 0; min < resultMatrix.length - 1; min++) {
            int least = min;
            for (int j = min + 1; j < resultMatrix.length; j++) {
                if (resultMatrix[j][indexColumn] < resultMatrix[least][indexColumn]) {
                    least = j;
                }
            }
            int[] tmp = resultMatrix[min];
            resultMatrix[min] = resultMatrix[least];
            resultMatrix[least] = tmp;
        }
        return resultMatrix;
    }


}
