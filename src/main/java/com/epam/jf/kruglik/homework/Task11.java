package com.epam.jf.kruglik.homework;

public class Task11 {

    private static int reverseWithTwoVar(int start,int end){
        if(start == 0) return end;
        else return reverseWithTwoVar(start/10 ,end*10 + start%10);
    }

    /**
     * Создает число, в котором порядок цифр обратный по отношению к исходному с использованием рекурсии.
     * Ведущие нули отбрасываются.
     *
     * @param value исходное значение.
     * @return Число, содержащее цифры в порядке обратном исходному.
     */
    public static int reverse(int value) {
        return reverseWithTwoVar(value,0);
    }

}