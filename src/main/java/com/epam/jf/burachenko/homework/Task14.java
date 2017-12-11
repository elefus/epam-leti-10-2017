package com.epam.jf.burachenko.homework;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Comparator;

public class Task14 extends com.epam.jf.common.homework.Task14{
    /**
     * Упорядочивает строки матрицы в порядке возрастания значений элементов определенного столбца.
     * При совпадении значений элементов строки должны сохранить такой же относительный порядок как в исходной матрице.
     * @param matrix Исходная матрица.
     * @param indexColumn Индекс столбца, по значениям которого выполняется сортировка.
     * @return Новая матрица, содержащая результат применения операции.
     */
    @Override
    public int[][] sortMatrixByValuesInColumn(int[][] matrix, int indexColumn) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, newMatrix[i], 0, matrix[i].length);
        }
        Arrays.sort(newMatrix, new ValueInColumnComparator(indexColumn));
        return newMatrix;
    }

    private void showMatrix(int[][] Matrix) {
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[i].length; j++) {
                System.out.print(Matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] Matrix = {{2, 4, 7, 5, 7}, {2, 3, 8, 4, 1}, {3, 3, 7, 4, 8}, {1, 4, 5, 8, 10}, {3, 4, 8, 5, 10}};
        Task14 T = new Task14();
        T.showMatrix(Matrix);
        T.showMatrix(T.sortMatrixByValuesInColumn(Matrix, 3));
    }
}

class ValueInColumnComparator implements Comparator<int[]> {
    private int indexColumn;
    ValueInColumnComparator(int indexColumn) {
        this.indexColumn = indexColumn;
    }
    @Override
    public int compare(int[] o1, int[] o2) {
        return Integer.compare(o1[indexColumn], o2[indexColumn]);
    }
}
