package com.epam.jf.common.classwork.lesson8;

import java.util.Objects;

public class InitExtendsExample {

    public static void main(String[] args) {
        new Child();
    }
}

class Parent {

    static {
        System.out.println("Static block in parent");
    }

    {
        System.out.println("Non-static block in parent 1");
        nonStaticField = 10.5;
    }

    static final String STATIC_FIELD = "123";
    final Double nonStaticField;

    {
        System.out.println("Non-static block in parent 2: " + nonStaticField);
    }

    public Parent() {
        super();
        System.out.println("Inside Parent constructor");
//        nonStaticField = 10.5;
    }
}

class Child extends Parent {

    static {
        System.out.println("Static block in Child");
    }

    {
        System.out.println("Non-static block in Child 1");
        nonStaticField = -42.0;
    }

    static final String STATIC_FIELD = "Child static field";
    final Double nonStaticField;

    {
        System.out.println("Non-static block in Child 2: " + nonStaticField);
    }

    public Child() {
        super();
        System.out.println("Inside Child constructor");
//        nonStaticField = 10.5;
    }
}
