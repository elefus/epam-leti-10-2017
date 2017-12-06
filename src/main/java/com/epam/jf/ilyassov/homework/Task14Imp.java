package com.epam.jf.ilyassov.homework;

import com.epam.jf.common.homework.Task14;

import java.util.Arrays;
import java.util.Comparator;

public class Task14Imp extends Task14{

    @Override
    public int[][] sortMatrixByValuesInColumn(int[][] matrix, int indexColumn) {
        Arrays.sort(matrix, Comparator.comparingInt(o->o[indexColumn]));
        return matrix;
    }


}
