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
        int[][] resultMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i){
            System.arraycopy(matrix[i], 0, resultMatrix[i], 0, matrix[0].length);
        }

        for (int i = resultMatrix.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (resultMatrix[j][indexColumn] > resultMatrix[j + 1][indexColumn]) {
                    int[] sch = resultMatrix[j];
                    resultMatrix[j] = resultMatrix[j + 1];
                    resultMatrix[j + 1] = sch;
                }
            }
        }
        return resultMatrix;
    }

}