package com.epam.jf.polovinkin.homework;

public class Task11 {

    /**
     * Создает число, в котором порядок цифр обратный по отношению к исходному с использованием рекурсии.
     * Ведущие нули отбрасываются.
     * @param value исходное значение.
     * @return Число, содержащее цифры в порядке обратном исходному.
     */
    public int reverse(int value) {
        if (value < 10) {
            return value;
        } else {
            return (value % 10) * (int) Math.pow(10, (int) Math.log10(value)) + reverse(value / 10);
        }
    }
}
