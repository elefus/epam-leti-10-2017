package com.epam.jf.common.classwork.lesson23;

public class ThreadUncaughtExceptionDemo {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            throw new RuntimeException("It is a greate exception.");
        });
        t.setUncaughtExceptionHandler((thread, ex) -> System.out.println(thread + " throws exception: " + ex));
        t.start();
    }
}

