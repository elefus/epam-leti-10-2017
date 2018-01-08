package com.epam.jf.common.classwork.lesson9;

import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

public class FinalizeExample {

    public static void main(String[] args) throws InterruptedException {
        TimeUnit.SECONDS.sleep(10);

        Child child = new Child(null);
        System.out.println(child);
        child = null;

        int[] arr1 = new int[1_000_000_00];
        print(arr1);
        arr1 = null;

        System.gc();
        System.runFinalization();

        int[] arr2 = new int[1_000_000_00];
        print(arr2);

        TimeUnit.SECONDS.sleep(5);
    }

    public static void print(int[] arr) {
        System.out.println(arr);
    }

}

class Parent {

    private final OutputStream stream;

    public Parent(OutputStream stream) {
        this.stream = stream;
    }

    public void write() {
        // ...
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            stream.close();
        } finally {
            super.finalize();
        }
    }
}

class Child extends Parent {

    private final OutputStream stream;

    public Child(OutputStream stream) {
        super(stream);
        this.stream = stream;
    }

    public void write() {
        // ...
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            while (true) {
                System.out.println("123");
            }
//            stream.close();
        } finally {
            super.finalize();
        }
    }
}
