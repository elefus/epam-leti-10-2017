package com.epam.jf.common.homework;

public abstract class Task14 {

    /**
     * Упорядочивает строки матрицы в порядке возрастания значений элементов определенного столбца.
     * При совпадении значений элементов строки должны сохранить такой же относительный порядок как в исходной матрице.
     * @param matrix Исходная матрица.
     * @param indexColumn Индекс столбца, по значениям которого выполняется сортировка.
     * @return Новая матрица, содержащая результат применения операции.
     */
    public abstract int[][] sortMatrixByValuesInColumn(int[][] matrix, int indexColumn);
}
