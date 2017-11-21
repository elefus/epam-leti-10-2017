package com.epam.jf.ilyassov.homework;

public class Task9Impl extends Task9 {

    @Override
    public boolean isPowerOfTwo(long value) {
        return value != 0 && (value & (value-1)) == 0;
    }

    public static void main(String[] args) {

        System.out.println(new Task9Impl().isPowerOfTwo(9));

    }
}
