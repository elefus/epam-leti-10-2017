package com.epam.jf.kruglik.homework;

public class Task14 {

    /**
     * Упорядочивает строки матрицы в порядке возрастания значений элементов определенного столбца.
     * При совпадении значений элементов строки должны сохранить такой же относительный порядок как в исходной матрице.
     *
     * @param matrix      Исходная матрица.
     * @param indexColumn Индекс столбца, по значениям которого выполняется сортировка.
     * @return Новая матрица, содержащая результат применения операции.
     */
    public static int[][] sortMatrixByValuesInColumn(int[][] matrix, int indexColumn) {
        for (int i = matrix.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (matrix[j][indexColumn] > matrix[j + 1][indexColumn]) {
                    int[] sch = matrix[j];
                    matrix[j] = matrix[j + 1];
                    matrix[j + 1] = sch;
                }
            }
        }
        return matrix;
    }

}