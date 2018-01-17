package com.epam.jf.kazakov.homework;

public class Task11 extends com.epam.jf.common.homework.Task11 {

    @Override
    public int reverse(int value) {
        return reverseWithResult(value, 0);
    }

    private int reverseWithResult(int value, int result) {
        return (value != 0) ? reverseWithResult(value / 10, result * 10 + value % 10) : result;
    }

}
