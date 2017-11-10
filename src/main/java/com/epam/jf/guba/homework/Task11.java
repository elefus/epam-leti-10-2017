package com.epam.jf.guba.homework;

public class Task11 extends com.epam.jf.common.homework.Task11 {

    @Override
    public int reverse(int value) {

        int sign = 1;

        if (value < 0) {
            value = value * -1;
            sign = -1;
        }
        if (value < 10) {
            return value * sign;
        }

        return (int) ((value % 10) * Math.pow(10, ((int) (Math.log10(value / 10) + 1)))
            + reverse(value / 10)) * sign;
    }
}
