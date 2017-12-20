package com.epam.jf.kozlov.homework;

public class Task10 extends com.epam.jf.common.homework.Task10 {

    /**
     * Вычисляет сумму цифр, составляющих указанное число с использованием рекурсии.
     * @param value натуральное число.
     * @return Сумма цифр, составляющих число.
     */
    public long getSumDigits(long value) {
        if (value < 0) {
            value = Math.abs(value);
        }
        if (value == 0) {
            return 0;
        }
        return value % 10 + getSumDigits(value / 10);
    }
}
