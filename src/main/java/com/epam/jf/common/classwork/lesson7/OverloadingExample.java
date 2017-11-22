package com.epam.jf.common.classwork.lesson7;

import org.jetbrains.annotations.NotNull;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class OverloadingExample {

    public static void main(String[] args) throws FileNotFoundException {
        A aRef = getB();
        aRef.method();

        A aRef2 = getB();
        aRef2.method("13");

        B bRef = new B();

        PrintStream consoleOutput = System.out;
        System.out.println("123");

        FileOutputStream outputStream = new FileOutputStream("tmp.txt");
        System.setOut(new PrintStream(outputStream));
        System.out.println("123");

        System.setOut(consoleOutput);
        System.out.println("ABC");
    }

    private static B getB() {
        return new B();
    }
}


class A {

    int method() {
        return 0;
    }


    double method(String str) {
        return 0;
    }
}

class B extends A {

    String method(int val) {
        return "123";
    }
}

