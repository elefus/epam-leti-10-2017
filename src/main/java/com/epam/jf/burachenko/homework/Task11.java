package com.epam.jf.burachenko.homework;

class Task11 extends com.epam.jf.common.homework.Task11 {
    @Override
    public int reverse(int value) {
        return (value > 9) ? value%10*(int)Math.pow(10, Math.floor(Math.log10(value))) + reverse(value/10) : value%10;
    }
}
