package com.epam.jf.dementyev.homework;

import java.security.InvalidParameterException;

public class Task9 extends com.epam.jf.common.homework.Task9 {

    @Override
    public boolean isPowerOfTwo(long value) {
        if (value < 0) {
            throw new InvalidParameterException("value < 0");
        }
        return value != 0 && ((value) & (value - 1)) == 0;
    }
}