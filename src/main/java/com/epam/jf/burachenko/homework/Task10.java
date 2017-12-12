package com.epam.jf.burachenko.homework;

public class Task10 extends com.epam.jf.common.homework.Task10 {
    @Override
    public long getSumDigits(long value) {
        return (value > 0) ? value%10+getSumDigits(value/10):0;
    }
}
