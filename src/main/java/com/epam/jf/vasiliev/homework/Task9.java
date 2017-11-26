package com.epam.jf.vasiliev.homework;

public class Task9 extends com.epam.jf.common.homework.Task9 {
    @Override
    public boolean isPowerOfTwo(long value) {
        if(value < 0) {
            throw new IllegalArgumentException("Value is less than zero");
        }
        return value != 0 && (value & (value-1)) == 0;
    }
}
