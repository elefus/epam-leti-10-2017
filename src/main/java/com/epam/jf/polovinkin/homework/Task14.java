package com.epam.jf.polovinkin.homework;

import java.util.Arrays;
import java.util.Comparator;

public class Task14 extends com.epam.jf.common.homework.Task14 {
    @Override
    public int[][] sortMatrixByValuesInColumn(int[][] matrix, int indexColumn) {
        return (int[][])Arrays.stream(matrix).sorted(Comparator.comparingInt(a -> a[indexColumn])).toArray();
    }
}
