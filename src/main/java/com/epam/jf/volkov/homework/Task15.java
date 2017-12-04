package com.epam.jf.volkov.homework;

public class Task15 {

    /**
     * Выполняет циклический сдвиг матрицы на указанное количество позиций по вертикали.
     * @param matrix Исходная матрица.
     * @param numberShifts Положительное значение соответствует циклическому сдвигу вниз, отрицательное - вверх.
     * @return Новая матрица, содержащая результат применения операции.
     */
    public int[][] verticalCyclicShift(int[][] matrix, int numberShifts) {
        //System.out.println("Сдвиг: " + numberShifts);
        numberShifts = numberShifts % matrix.length;
        if (numberShifts >= 0) {
            int[][] newMatrix = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < newMatrix.length; i++) {
                System.arraycopy(matrix[i], 0, newMatrix[(i + numberShifts) % newMatrix.length], 0, matrix[i].length);
                //System.out.println("Скопировано " + matrix[i] + " из позиции " + i + " в позицию " + ((i + numberShifts) % newMatrix.length));
            }
            return newMatrix;
        } else {
            return verticalCyclicShift(matrix, numberShifts + matrix.length);
        }
    }

    /**
     * Выполняет циклический сдвиг матрицы на указанное количество позиций по горизонтали.
     * @param matrix Исходная матрица.
     * @param numberShifts Положительное значение соответствует циклическому сдвигу вправо, отрицательное - влево.
     * @return Новая матрица, содержащая результат применения операции.
     */
    public int[][] horizontalCyclicShift(int[][] matrix, int numberShifts) {
        numberShifts = numberShifts % matrix[0].length;
        //System.out.println("Сдвиг: " + numberShifts);
        if (numberShifts >= 0) {
            int[][] newMatrix = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                System.arraycopy(matrix[i], 0, newMatrix[i], numberShifts, matrix[i].length - numberShifts);
                System.arraycopy(matrix[i], matrix[i].length - numberShifts, newMatrix[i], 0, numberShifts);
            }
            return newMatrix;
        } else {
            return horizontalCyclicShift(matrix, numberShifts + matrix[0].length);
        }
    }
}
