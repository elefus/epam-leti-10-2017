package com.epam.jf.dementyev.homework;

public class Task11 extends com.epam.jf.common.homework.Task11 {

    @Override
    public int reverse(int value) {
        if (value < 10 && value > -10) {
            return value;
        } else {
            int result = value % 10;
            int temp = value / 10;
            while (temp != 0) {
                result *= 10;
                temp /= 10;
            }
            return result + reverse(value / 10);
        }
    }
}
