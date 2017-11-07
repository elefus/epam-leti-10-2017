package com.epam.jf.dementyev.homework;

import java.security.InvalidParameterException;

public class Task10 extends com.epam.jf.common.homework.Task10 {

    @Override
    public long getSumDigits(long value) {
        if (value < 0) {
            throw new InvalidParameterException("value < 0");
        }
        if (value == 0) {
            return 0;
        } else {
            return (value % 10) + getSumDigits(value / 10);
        }
    }
}
