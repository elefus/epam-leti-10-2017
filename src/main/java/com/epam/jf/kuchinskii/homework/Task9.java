package com.epam.jf.kuchinskii.homework;

public class Task9 extends com.epam.jf.common.homework.Task9 {

    @Override
    public boolean isPowerOfTwo(long value) {
        if (value < 0) {
            throw new IllegalArgumentException("Неверное значение " + value);
        } else {
            return (value != 0) && (value & value - 1) == 0;
        }
    }
}
