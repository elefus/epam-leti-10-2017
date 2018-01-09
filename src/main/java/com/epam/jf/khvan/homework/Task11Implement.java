package com.epam.jf.khvan.homework;

import com.epam.jf.common.homework.Task11;

public class Task11Implement extends Task11 {
    public static void main(String[] args) {
        System.out.println( new Task11Implement().reverse(6805));
    }
    @Override
    public int reverse(int value) {
        if ( value < 10) return value;
        int degree = (int) Math.abs( Math.log10( value) );
        int number = (int) (value % 10 * Math.pow( 10, degree ) + reverse( value / 10 ));
        return  number;
    }
}

