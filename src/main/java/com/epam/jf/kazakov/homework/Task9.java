package com.epam.jf.kazakov.homework;

public abstract class Task9 {

    /**
     * С помощью битовых и логических операций определяет, является ли указанное значение степенью двойки.
     * @param value анализируемое не отрицательное число.
     * @return true - число является степенью двойки, false в противном случае.
     */
    public abstract boolean isPowerOfTwo(long value);

    public static void main(String[] args) {
        System.out.println(new powerOfTwo().isPowerOfTwo(Long.valueOf(args[0])));
    }
}

class powerOfTwo extends Task9 {

    @Override
    public boolean isPowerOfTwo(long value) {
        return (Long.bitCount(value) == 1);
    }
}
