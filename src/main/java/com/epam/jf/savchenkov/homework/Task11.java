package com.epam.jf.savchenkov.homework;

public class Task11 extends com.epam.jf.common.homework.Task11 {

    @Override
    public int reverse(int value) {
        return trueReverse(value, 0);
    }

    private int trueReverse(int value, int result) {
        return (value > 0) ? trueReverse(value / 10, result * 10 + value % 10) : result;
    }
}
