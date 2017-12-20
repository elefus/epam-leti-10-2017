package com.epam.jf.kozlov.homework;

public class Task9 extends com.epam.jf.common.homework.Task9 {

    /**
     * С помощью битовых и логических операций определяет, является ли указанное значение степенью двойки.
     * @param value анализируемое не отрицательное число.
     * @return true - число является степенью двойки, false в противном случае.
     */
    public boolean isPowerOfTwo(long value) {
        return (value > 0) && ((value & (value - 1)) == 0);
    }
}
