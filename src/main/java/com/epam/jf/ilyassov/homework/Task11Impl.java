package com.epam.jf.ilyassov.homework;


import com.epam.jf.common.homework.Task11;

public class Task11Impl extends Task11 {

    @Override
    public int reverse(int value) {
        if(value<10)
            return value;
        else
            return reverse(value/10)+(value%10)*count(value);
    }
    public static int count(int value){
        String str=Integer.toString(value);
        int result=1;
        for (int i = 0; i < str.length()-1; i++) {
            result*=10;
        }
        return result;
    }

}

