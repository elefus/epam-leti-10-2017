package com.epam.jf.burachenko.homework;

class Task11 extends com.epam.jf.common.homework.Task11 {
    @Override
    public int reverse(int value) {
        return (value > 9) ? 10*value%10 + reverse(value/10) : value%10;
    }

    public static void main(String[] args) {
        Task11 example = new Task11();
        System.out.println(example.reverse(5_748_457));
    }
}
