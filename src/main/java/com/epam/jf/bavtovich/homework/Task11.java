package com.epam.jf.bavtovich.homework;

public class Task11 extends com.epam.jf.common.homework.Task11 {

    /**
     * Создает число, в котором порядок цифр обратный по отношению к исходному с использованием рекурсии.
     * Ведущие нули отбрасываются.
     * @param value исходное значение.
     * @return Число, содержащее цифры в порядке обратном исходному.
     */
    @Override
    public int reverse(int value) {
        if (value < 10) {
            return value;
        } else {
            int n = (int) Math.pow(10, Math.floor(Math.log10(value)));
            return (value % 10) * n + reverse(value / 10);
        }
    }

}
