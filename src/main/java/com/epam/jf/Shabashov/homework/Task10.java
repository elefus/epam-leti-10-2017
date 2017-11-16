package com.epam.jf.Shabashov.homework;

public abstract class Task10 extends com.epam.jf.common.homework.Task10{

    /**
     * Вычисляет сумму цифр, составляющих указанное число с использованием рекурсии.
     *
     * @param value натуральное число.
     * @return Сумма цифр, составляющих число.
     */
    @Override
    public long getSumDigits(long value) {
        if (value>9){
            return (value%10) + getSumDigits(value/10);
        }
        return value;
    }
}
