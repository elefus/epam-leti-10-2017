package com.epam.jf.khvan.homework;
import com.epam.jf.common.homework.Task9;

public  class Task9Implement extends Task9 {
    public static void main(String[] args) {
        System.out.println(new Task9Implement().isPowerOfTwo(2048));
    }
    @Override
    public boolean isPowerOfTwo(long value) {
        boolean flag = false;
        while ( value >= 1){
            if ( value % 2 != 0 & value != 1) return flag;
            if ( ( value >>= 1) % 2 == 0) {
                flag = true;
            } else {
                return flag;
            }
        }
        return flag;
    }
}

