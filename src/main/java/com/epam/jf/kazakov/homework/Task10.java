package com.epam.jf.kazakov.homework;

public class Task10 extends com.epam.jf.common.homework.Task10 {
    @Override
    public long getSumDigits(long value) {
        return (value > 9) ? (value % 10 + getSumDigits(value / 10)) : value;
    }
}
