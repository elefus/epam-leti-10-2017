package com.epam.jf.ilyassov.homework;


import com.epam.jf.common.homework.Task10;

public class Task10Impl extends Task10{
    @Override
    public long getSumDigits(long value) {
        if(value<10)
            return value;
        else
            return getSumDigits(value/10)+value%10;
    }

    public static void main(String[] args) {
        Task10Impl task10 = new Task10Impl();
        System.out.println(task10.getSumDigits(104560));

    }
}