package com.epam.jf.vasiliev.homework;

import static java.lang.Math.abs;

public class Task10 extends com.epam.jf.common.homework.Task10 {

    /**
     * Вычисляет сумму цифр, составляющих указанное число с использованием рекурсии.
     * @param value натуральное число.
     * @return Сумма цифр, составляющих число.
     */
    @Override
    public long getSumDigits(long value) {
        if(value > 9 || value < -9) {
            return abs(value % 10) + getSumDigits(abs(value/10));
        }
        return abs(value);
    }
}
