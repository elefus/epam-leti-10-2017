package com.epam.jf.kozlov.homework;

import java.util.Arrays;
import java.util.Comparator;

public class Task14 extends com.epam.jf.common.homework.Task14 {

    /**
     * Упорядочивает строки матрицы в порядке возрастания значений элементов определенного столбца.
     * При совпадении значений элементов строки должны сохранить такой же относительный порядок как в исходной матрице.
     * @param matrix Исходная матрица.
     * @param indexColumn Индекс столбца, по значениям которого выполняется сортировка.
     * @return Новая матрица, содержащая результат применения операции.
     */
    public int[][] sortMatrixByValuesInColumn(int[][] matrix, int indexColumn) {
        int [][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, newMatrix[i], 0, matrix[i].length);
        }
        Arrays.sort(newMatrix, Comparator.comparingInt(o -> o[indexColumn]));
        return newMatrix;
    }
}
