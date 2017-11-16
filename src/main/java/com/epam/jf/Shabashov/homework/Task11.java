package com.epam.jf.Shabashov.homework;

public class Task11 extends com.epam.jf.common.homework.Task11 {

    /**
     * Создает число, в котором порядок цифр обратный по отношению к исходному с использованием рекурсии.
     * Ведущие нули отбрасываются.
     *
     * @param value исходное значение.
     * @return Число, содержащее цифры в порядке обратном исходному.
     */
    @Override
    public int reverse(int value) {
        return helpReverse(value,0);
    }

    private int helpReverse(int value,int step){
        return value != 0 ? helpReverse(value / 10,step*10 + value % 10) : step;
    }

}
