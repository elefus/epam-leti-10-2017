package com.epam.jf.polovinkin.homework;


public abstract class Task10 {

    /**
     * Вычисляет сумму цифр, составляющих указанное число с использованием рекурсии.
     * @param value натуральное число.
     * @return Сумма цифр, составляющих число.
     */
    public long getSumDigits(long value) {
        if (value == 0) return 0;
        return value % 10 + getSumDigits(value / 10);
    }

}
