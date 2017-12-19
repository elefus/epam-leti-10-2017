package com.epam.jf.common.classwork.lesson11.generics;

public class NumberOptionalExample {

    public static void main(String[] args) {
        NumberOptional<Number> optional = new NumberOptional<>();
        optional.setValue(1);
        optional.setValue(1.0);
        optional.setValue(1.0f);

        NumberOptional<Long> optionalLong = new NumberOptional<>();
        optionalLong.setValue((long)1);

        NumberOptional<Integer> integerNumberOptional = new NumberOptional<>();
        integerNumberOptional.setValue((int)10L);
    }
}
