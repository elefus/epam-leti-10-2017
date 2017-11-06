package com.epam.jf.burachenko.homework;

public abstract class Task10 {

    /**
     * Вычисляет сумму цифр, составляющих указанное число с использованием рекурсии.
     * @param value натуральное число.
     * @return Сумма цифр, составляющих число.
     */
    public abstract long getSumDigits(long value);
}

class Decision extends Task10 {
    @Override
    public long getSumDigits(long value) {
        return (value > 0) ? value%10+getSumDigits(value/10):0;
    }

    public static void main(String[] args) {
        Task10 example = new Decision();
        System.out.println(example.getSumDigits(5_158_964_489_577L));
    }
}
