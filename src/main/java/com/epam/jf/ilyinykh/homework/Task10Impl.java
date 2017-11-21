package com.epam.jf.ilyinykh.homework;

import com.epam.jf.common.homework.Task10;

public class Task10Impl extends Task10 {
    /**
     * Вычисляет сумму цифр, составляющих указанное число с использованием рекурсии.
     *
     * @param value натуральное число.
     * @return Сумма цифр, составляющих число.
     */
    @Override
    public long getSumDigits(long value) {
        return (value < 10) ? value : getSumDigits(value / 10) + value % 10;
    }
}
