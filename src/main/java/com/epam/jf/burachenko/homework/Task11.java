package com.epam.jf.burachenko.homework;

class Task11 extends com.epam.jf.common.homework.Task11 {
    private int degree = 1;

    @Override
    public int reverse(int value) {
        if(value > 9) {
            int temp = reverse(value / 10);
            degree *= 10;
            return value%10*degree + temp;
        }
        else {
            return value%10;
        }
    }
}
