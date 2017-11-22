package com.epam.jf.volkov.homework;

    /**
    * @author Anton Volkov aka thewalkingwind
    * @version 1.0.1
    */
public class Task9 extends com.epam.jf.common.homework.Task9 {

    /**
     * С помощью битовых и логических операций определяет, является ли указанное значение степенью двойки.
     * @param value анализируемое не отрицательное число.
     * @return true - число является степенью двойки, false в противном случае.
     */
    public boolean isPowerOfTwo(long value) {
        return Long.bitCount(value) == 1;
    }
}
