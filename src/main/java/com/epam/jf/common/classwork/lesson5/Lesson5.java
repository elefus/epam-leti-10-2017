package com.epam.jf.common.classwork.lesson5;

import java.util.Arrays;

public class Lesson5 {

    public static void main(String[] args) {

        A a = new A(100);
        B b = new B(100);
        a.method(b);
        System.out.println(b);

        String[] arr = {"123"};
        B.changeString(arr);
        System.out.println(Arrays.toString(arr));


        char[] chars = {'a', 'b', 'c', 'd'};
        for (int i = 0; i < 1_000_000; i++) {
            String abcd = new String(chars).intern();
            System.out.println(abcd);
        }

    }
}

class A {

    private static volatile String string = "123";
    private final Integer value;
    private transient Integer transientValue = 100;

    {
        value = 10;
    }

    public A(Integer transientValue) {
        this.transientValue = transientValue;
    }

    public void method(B value) {
        System.out.println(value);
        value.setName("John");
        System.out.println(value);
    }
}

class B extends A {

    private String name = "Alex";


    public B(Integer transientValue) {
        super(200);
    }

    public void setName(String name) {
        if (name == null) {
            throw new NullPointerException();
        }
        this.name = name;
    }

    public static String changeString(String string) {
        return string + "123";
    }

    public static void changeString(String...arr) {
        arr[0] += "abc";
    }
}

