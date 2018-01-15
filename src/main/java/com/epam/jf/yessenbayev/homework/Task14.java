package com.epam.jf.yessenbayev.homework;

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
    @Override
    public int[][] sortMatrixByValuesInColumn(int[][] matrix, int indexColumn) {
        if (indexColumn < 0) {
            throw new IllegalArgumentException();
        }
        int[][] tempo = matrix.clone();
        Arrays.sort(tempo, Comparator.comparingInt(o -> o[indexColumn]));;
        return tempo;
    }
}
