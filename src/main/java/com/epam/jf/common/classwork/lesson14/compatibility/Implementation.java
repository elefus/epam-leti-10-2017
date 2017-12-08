package com.epam.jf.common.classwork.lesson14.compatibility;

public class Implementation implements Left, Right {

    public static void main(String...args) {
        System.out.println(new Implementation().getValue());
        Left.method();
        Right.method();

    }

    @Override
    public int getValue() {
        return 0;
    }
}

class Child extends Implementation {


    private void test() {
        main();
    }
}