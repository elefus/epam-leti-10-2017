package com.epam.jf.ilyinykh.homework;

import com.epam.jf.common.homework.Task9;

public class Task9Impl extends Task9 {
    /**
     * С помощью битовых и логических операций определяет, является ли указанное значение степенью двойки.
     *
     * @param value анализируемое не отрицательное число.
     * @return true - число является степенью двойки, false в противном случае.
     */
    @Override
    public boolean isPowerOfTwo(long value) {
        return value != 0 && (value & (value - 1)) == 0;
    }

    public static void main(String...args) {
        System.out.println(new Task9Impl().isPowerOfTwo(0));
    }
}
