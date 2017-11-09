package com.epam.jf.bavtovich.homework;

public class Task10 extends com.epam.jf.common.homework.Task10 {

    /**
     * Вычисляет сумму цифр, составляющих указанное число с использованием рекурсии.
     * @param value натуральное число.
     * @return Сумма цифр, составляющих число.
     */
    @Override
    public long getSumDigits(long value) {
        if (value < 10) {
            return value;
        } else {
            return getSumDigits(value / 10) + (value % 10);
        }
    }
}
