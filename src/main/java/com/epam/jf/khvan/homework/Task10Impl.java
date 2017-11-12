package com.epam.jf.khvan.homework;

import com.epam.jf.common.homework.Task10;

public class Task10Impl extends Task10 {

    public static void main(String[] args) {
        System.out.println( new Task10Impl().getSumDigits(123500));
    }
    @Override
    public long getSumDigits(long value) {
        if ( value < 10) return value;
        int result = (int) ( getSumDigits( value % 10) + getSumDigits(  value / 10 ));
        return result;
    }
}
