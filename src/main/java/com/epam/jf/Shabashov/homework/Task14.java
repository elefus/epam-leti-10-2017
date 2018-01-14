package com.epam.jf.Shabashov.homework;

import java.util.Arrays;
import java.util.Comparator;

public class Task14 {
    /**
     * Упорядочивает строки матрицы в порядке возрастания значений элементов определенного столбца.
     * При совпадении значений элементов строки должны сохранить такой же относительный порядок как в исходной матрице.
     * @param matrix Исходная матрица.
     * @param indexColumn Индекс столбца, по значениям которого выполняется сортировка.
     * @return Новая матрица, содержащая результат применения операции.
     */
    public int[][] sortMatrixByValuesInColumn(int[][] matrix, int indexColumn){
        int[][] matr = Arrays.copyOf(matrix, matrix.length);
        Arrays.sort(matr, Comparator.comparingInt(arr -> arr[indexColumn]));
        return matr;
    }
}
