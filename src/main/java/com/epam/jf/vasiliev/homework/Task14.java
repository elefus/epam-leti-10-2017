package com.epam.jf.vasiliev.homework;

import java.util.Arrays;
import java.util.Comparator;

public class Task14 extends com.epam.jf.common.homework.Task14 {
    @Override
    public int[][] sortMatrixByValuesInColumn(int[][] matrix, int indexColumn) {
        int[][] tmp = Arrays.copyOf(matrix, matrix.length);
        Arrays.sort(tmp, Comparator.comparing(e -> e[indexColumn]));
        return tmp;
    }
}
