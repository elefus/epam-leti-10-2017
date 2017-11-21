package com.epam.jf.yessenbayev.homework;

public class Task10 extends  com.epam.jf.common.homework.Task10 {

    /**
     * Вычисляет сумму цифр, составляющих указанное число с использованием рекурсии.
     * @param value натуральное число.
     * @return Сумма цифр, составляющих число.
     */

    @Override
    public long getSumDigits(long value) {
        if (value > 0) {
            return getSumDigits(value / 10) + value % 10;
        } else {
            return 0;
        }
    }
}
