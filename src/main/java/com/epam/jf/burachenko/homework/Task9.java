package com.epam.jf.burachenko.homework;

public abstract class Task9 {

    /**
     * С помощью битовых и логических операций определяет, является ли указанное значение степенью двойки.
     * @param value анализируемое не отрицательное число.
     * @return true - число является степенью двойки, false в противном случае.
     */
    public abstract boolean isPowerOfTwo(long value);
}

class Decision extends Task9 {
    @Override
    public boolean isPowerOfTwo(long value) {
        int count = 0;
        for(int i = 0; i < 64 && count < 2; i++) {
            count += value%2;
            value >>= 1;
        }
        return count == 1;
    }

    public static void main(String[] args) {
        Task9 example = new Decision();
        System.out.println(example.isPowerOfTwo(16_384));
    }
}
