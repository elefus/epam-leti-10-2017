package com.epam.jf.Guyo.homework;

import java.util.Arrays;

public class Task14{

    /**
     * Упорядочивает строки матрицы в порядке возрастания значений элементов определенного столбца.
     * При совпадении значений элементов строки должны сохранить такой же относительный порядок как в исходной матрице.
     * @param matrix Исходная матрица.
     * @param indexColumn Индекс столбца, по значениям которого выполняется сортировка.
     * @return Новая матрица, содержащая результат применения операции.
     */
    public int[][] sortMatrixByValuesInColumn(int[][] matrix, int indexColumn){
        int[][] outputMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, outputMatrix[i], 0, matrix[i].length);
        }

        Arrays.sort(outputMatrix, (arr1, arr2) -> {
            if (arr1[indexColumn] > arr2[indexColumn]){
                return 1;
            } else if(arr1[indexColumn] < arr2[indexColumn]){
                return -1;
            }
            return 0;
        });
        return outputMatrix;
    }
}
