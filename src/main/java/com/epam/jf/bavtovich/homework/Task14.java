package com.epam.jf.bavtovich.homework;

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
    public int[][] sortMatrixByValuesInColumn(int[][] matrix, int indexColumn) {
        isIndexValid(matrix, indexColumn);
        int[][] temp = matrix.clone();
        Arrays.sort(temp, Comparator.comparingInt(o -> o[indexColumn]));
        return temp;
    }

    public void isIndexValid(int[][] matrix, int indexColumn) {
        for (int[] row: matrix) {
            if (indexColumn < 0 || indexColumn >= row.length) {
                throw new IndexOutOfBoundsException("Invalid index");
            }
        }
    }

}