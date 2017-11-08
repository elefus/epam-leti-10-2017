package com.epam.jf.guba.homework;

public class Task10 extends com.epam.jf.common.homework.Task10 {

    @Override
    public long getSumDigits(long value) {
        if ((value / 10) == 0) {
            return value;
        }
        return value % 10 + getSumDigits(value / 10);
    }
}
