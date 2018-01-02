package com.epam.jf.kruglik.homework;

public class Task9 {


    public static boolean isPowerOfTwo(long n){
        return n!=0 && (n & (n-1)) == 0;
    }

}