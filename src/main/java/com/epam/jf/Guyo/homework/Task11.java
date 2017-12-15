package com.epam.jf.Guyo.homework;

public class Task11 {

    /**
     * Создает число, в котором порядок цифр обратный по отношению к исходному с использованием рекурсии.
     * Ведущие нули отбрасываются.
     * @param value исходное значение.
     * @return Число, содержащее цифры в порядке обратном исходному.
     */

    public  int reverse(int value){
        return (value > 0) ? (value%10)*tenMultiply(getCountOfDigits(value)-1) + reverse(value/10) : 0;
    }

    public   int getCountOfDigits(int val){
        return (val > 0) ? getCountOfDigits(val/10) + 1 : 0;
    }

    public  int tenMultiply(int val){
        return val > 0 ? (tenMultiply(val - 1) * 10) : 1;
    }

}
