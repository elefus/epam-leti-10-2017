package com.epam.jf.volkov.homework;

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
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        System.arraycopy(matrix, 0, newMatrix, 0, matrix.length);
        Arrays.sort(newMatrix, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[indexColumn] - o2[indexColumn];
            }
        });
        return newMatrix;
    }
}
