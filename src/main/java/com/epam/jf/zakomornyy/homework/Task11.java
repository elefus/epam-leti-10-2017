package com.epam.jf.zakomornyy.homework;


public class Task11 extends com.epam.jf.common.homework.Task11 {
    @Override
    public int reverse(int value) {
        overflowCheck(value);
        return value > 0 ? reverseHelper(Math.abs(value), 1) : (-1) * reverseHelper(Math.abs(value), 1);
    }

    private int reverseHelper(int value, int i) {
        int numOfDigits = (int) Math.log10(value);
        return value < 10 ? value : (value % 10) * (int) Math.pow(10, numOfDigits) + reverseHelper(value / 10, i);
    }

    private void overflowCheck(int value){
        if(value > 1_000_000_000) {
            if(reverse(value % 100_000) > 21474){
                    throw new IllegalArgumentException();
            }
        }
        if(value < -1_000_000_000){
            if(Math.abs(reverse(value % 100_000)) > 21474){
                    throw new IllegalArgumentException();
            }
        }
    }
}
