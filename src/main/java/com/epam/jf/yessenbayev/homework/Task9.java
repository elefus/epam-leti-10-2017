package com.epam.jf.yessenbayev.homework;

public class Task9 extends com.epam.jf.common.homework.Task9  {

    @Override
    public boolean isPowerOfTwo(long value) {
        return (value > 0) && ((value & (value - 1)) == 0);
    }

}
