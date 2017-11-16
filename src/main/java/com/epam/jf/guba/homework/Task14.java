package com.epam.jf.guba.homework;

public class Task14 extends com.epam.jf.common.homework.Task14 {

    @Override
    public int[][] sortMatrixByValuesInColumn(int[][] matrix, int indexColumn) {
        if(indexColumn < 0 || indexColumn >= matrix.length){
            throw new IllegalArgumentException("indexColumn is out of bound");
        }
        int[] temp;
        int j;
        for(int i = 0; i < matrix.length - 1; i++){
            if (matrix[i][indexColumn] > matrix[i + 1][indexColumn]) {
                temp = matrix[i + 1];
                matrix[i + 1] = matrix[i];
                j = i;
                while (j > 0 && temp[indexColumn] < matrix[j - 1][indexColumn]) {
                    matrix[j] = matrix[j - 1];
                    j--;
                }
                matrix[j] = temp;
            }
        }

        System.out.println(matrix);

        return matrix;
    }
}
