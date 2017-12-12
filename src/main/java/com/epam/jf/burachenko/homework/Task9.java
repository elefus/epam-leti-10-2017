package com.epam.jf.burachenko.homework;

public class Task9 extends com.epam.jf.common.homework.Task9 {
    @Override
    public boolean isPowerOfTwo(long value) {
        int count = 0;
        for(int i = 0; i < 64 && count < 2; i++) {
            count += value%2;
            value >>= 1;
        }
        return count == 1;
    }

    /*public static void main(String[] args) {
        Task9 example = new Task9();
        System.out.println(example.isPowerOfTwo(16_384));
    }*/
}
