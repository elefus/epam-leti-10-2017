package com.epam.jf.guba.homework;

public class Task9 extends com.epam.jf.common.homework.Task9 {

    @Override
    public boolean isPowerOfTwo(long value) {
        if(value < 0){
            throw new IllegalArgumentException("value < 0");
        }
        return value != 0 && ((value) & (value - 1)) == 0;
    }
}
