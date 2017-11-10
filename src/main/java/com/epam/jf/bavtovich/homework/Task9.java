package com.epam.jf.bavtovich.homework;

public class Task9 extends com.epam.jf.common.homework.Task9 {

    @Override
    public boolean isPowerOfTwo(long value) {
        if (value > 0) {
            return (value % 2 == 0) && (Long.bitCount(value) == 1);
        } else {
            return false;
        }
    }
}