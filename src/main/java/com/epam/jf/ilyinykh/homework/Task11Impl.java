package com.epam.jf.ilyinykh.homework;

import com.epam.jf.common.homework.Task11;

public class Task11Impl extends Task11 {
    private static StringBuilder stringBuilder = new StringBuilder("");

    /**
     * Создает число, в котором порядок цифр обратный по отношению к исходному с использованием рекурсии.
     * Ведущие нули отбрасываются.
     *
     * @param value исходное значение.
     * @return Число, содержащее цифры в порядке обратном исходному.
     */
    @Override
    public int reverse(int value) {
        if (value < 10) {
            stringBuilder.append(value);
            String answer = stringBuilder.toString();
            stringBuilder = new StringBuilder("");
            return Integer.parseInt(answer);
        } else {
            stringBuilder.append(value % 10);
            return reverse(value / 10);
        }
    }
}
