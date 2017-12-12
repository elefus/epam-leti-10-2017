package com.epam.jf.kuchinskii.homework;

public class Task10 extends com.epam.jf.common.homework.Task10 {

    @Override
    public long getSumDigits(long value) {
        return (value < 10 && value > -10) ? Math.abs(value) : (Math.abs(value % 10) + getSumDigits(value / 10));
    }
}
