package com.epam.jf.ilyinykh.homework;

import com.epam.jf.common.homework.Task14;

import java.lang.reflect.Array;
import java.util.*;

public class Task14Solution extends Task14 {
    /**
     * Упорядочивает строки матрицы в порядке возрастания значений элементов определенного столбца.
     * При совпадении значений элементов строки должны сохранить такой же относительный порядок как в исходной матрице.
     *
     * @param matrix      Исходная матрица.
     * @param indexColumn Индекс столбца, по значениям которого выполняется сортировка.
     * @return Новая матрица, содержащая результат применения операции.
     */
    @Override
    public int[][] sortMatrixByValuesInColumn(int[][] matrix, int indexColumn) {
        int[][] cp = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            cp[i] = matrix[i].clone();
        }
        Arrays.sort(cp, Comparator.comparingInt(o -> o[indexColumn]));
        return cp;
    }
}
