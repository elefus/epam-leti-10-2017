package com.epam.jf.kruglik.homework;

public class Task10 {

    /**
     * Вычисляет сумму цифр, составляющих указанное число с использованием рекурсии.
     *
     * @param value натуральное число.
     * @return Сумма цифр, составляющих число.
     */
    public static long getSumDigits(long value) {
        if (value >= 9){
            return (value % 10) + getSumDigits(value / 10);
        } else {
            return value;
        }
    }

}