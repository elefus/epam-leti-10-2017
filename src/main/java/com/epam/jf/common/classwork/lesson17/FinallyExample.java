package com.epam.jf.common.classwork.lesson17;

import java.io.EOFException;
import java.io.IOException;

public class FinallyExample {

    static int counter = 0;
    static int tmp = 0;

    public static void main(String[] args) {
//        System.out.println(getValue());
        get();
    }

    private static int get() {
        int a = 10;
        int b = 20;
        int c = 40;
        int d = a + b + c;
        tmp = d;
        try {
            System.out.println(++counter);
            get();
            return 42;
        } catch (StackOverflowError er) {
            er.printStackTrace();
        } finally {
            get();
            System.out.println(--counter);
            return 0;
        }
    }

    private static int getValue() {
        try {
            System.out.println("123");
            if (true) {
                throw new RuntimeException();
            }
            return 42;
        } catch (RuntimeException ex) {
            return -42;
        } finally {
            System.out.println("abc");
            return 0;
        }
    }


}

class A {

    public A() throws IOException {
    }
}

class B extends A {

    public B() throws IOException {
        super();
        System.out.println("132");
    }
}


class BaseCl {
    public BaseCl() throws IOException, ArithmeticException {
    }

    public static void methodA() throws IOException {
    }
}

class DerivativeCl extends BaseCl {
    public DerivativeCl() throws EOFException, IOException, ArithmeticException {
        super();
    }

    public static void methodA() throws EOFException {
    }
}

class DerivativeCl2 extends BaseCl {
    public DerivativeCl2() throws Throwable {
        super();
    }

//    public static void methodA() throws Exception {
//    }
}


