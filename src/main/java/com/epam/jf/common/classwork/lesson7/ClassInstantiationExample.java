package com.epam.jf.common.classwork.lesson7;

public class ClassInstantiationExample {

    static {
        System.out.println("Base class static block");
    }

    public static void method() {
        System.out.println("Hello from base class");
    }
}


class Child extends ClassInstantiationExample {

    static {
        System.out.println("Child class static block");
    }
}


class Launcher {

    public static void main(String[] args) {
        Child.method();
        Child.method();
        Child.method();
        Child.method();
        Child.method();

        System.out.println("-----");

        new Child();

    }
}