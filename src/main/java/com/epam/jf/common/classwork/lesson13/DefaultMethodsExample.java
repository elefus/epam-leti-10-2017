package com.epam.jf.common.classwork.lesson13;

interface Left {

    default int getValue() {
        return 10;
    }
}

interface Right {

    default int getValue() {
        return -10;
    }
}

class C {

}

public class DefaultMethodsExample extends C implements Left, Right {

    @Override
    public int getValue() {
        return Left.super.getValue() + Right.super.getValue();
    }

    public static void main(String[] args) {
        System.out.println(new DefaultMethodsExample().getValue());
    }
}
