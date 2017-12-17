package com.epam.jf.common.classwork.lesson14;

public class Child extends Parent {

    private final String field;

    public Child() {
        super();
        field = "123";
    }

    @Override
    public void method() {
        System.out.println(field.substring(1));
    }

    public static void main(String[] args) {
        new Child();
    }
}


