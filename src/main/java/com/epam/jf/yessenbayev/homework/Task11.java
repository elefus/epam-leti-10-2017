package com.epam.jf.yessenbayev.homework;

//extends  com.epam.jf.common.homework.Task11

public class Task11 extends com.epam.jf.common.homework.Task11 {
    /**
     * Создает число, в котором порядок цифр обратный по отношению к исходному с использованием рекурсии.
     * Ведущие нули отбрасываются.
     * @param value исходное значение.
     * @return Число, содержащее цифры в порядке обратном исходному.
     */
    @Override
    public int reverse(int value) {
        if (value < 10 && value > -10) {
            return value;
        } else {
            int tempo = value;
            int result = tempo % 10;
            value /= 10;
            int digitsCount = (int) Math.ceil(Math.log10(Math.abs(value) + 0.5));
            for (int i = 0; i < digitsCount; i++) {
                result *= 10;
            }
            return result + reverse(value);
        }

    }
}
