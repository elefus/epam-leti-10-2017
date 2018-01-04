package com.epam.jf.kozlov.homework;

public class Task11 extends com.epam.jf.common.homework.Task11 {

    /**
     * Создает число, в котором порядок цифр обратный по отношению к исходному с использованием рекурсии.
     * Ведущие нули отбрасываются.
     * @param value исходное значение.
     * @return Число, содержащее цифры в порядке обратном исходному.
     */
    @Override
    public int reverse(int value) {
        if (value < 0) {
            value = Math.abs(value);
        }
        if (value < 10) {
            return value;
        }
        int length = String.valueOf(value).length() - 1;
        int result = value % 10;
        for (int i = 0; i < length; i++) {
            result *= 10;
        }
        return result + reverse(value / 10);
    }
}
