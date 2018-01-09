package com.epam.jf.kuchinskii.homework;

public class Task11 extends com.epam.jf.common.homework.Task11 {

    @Override
    public int reverse(int value) {
        if (value > 999_999_999 || value < -999_999_999) {
            throw new IllegalArgumentException("Value too big");
        }
        if (value < 0) {
            value = Math.abs(value);
        }
        int digitsCount = (int) Math.log10(value);
        return (value < 10) ? value : (value % 10) * (int)Math.pow(10, digitsCount) + reverse(value / 10);
    }
}
