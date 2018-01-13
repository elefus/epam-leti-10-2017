package com.epam.jf.common.classwork.lesson23;

import java.util.concurrent.TimeUnit;

public class RecursiveMonitorExample {


    public static void main(String[] args) {
        SynchroClazz synchroClazz = new SynchroClazz();
        synchronized (SynchroClazz.class) {


            new Thread(() -> {
                System.out.println("Before synchro static method");
                SynchroClazz.staticMethod();
                System.out.println("After synchro static method");
            }).start();


            synchroClazz.method(10);

            SynchroClazz another = new SynchroClazz();
            new Thread(() -> {
                System.out.println("Before call 1");
                another.anotherMethod();
                System.out.println("After call 1");
            }).start();

            new Thread(() -> {
                System.out.println("Before call 2");
                synchroClazz.anotherMethod();
                System.out.println("After call 2");
            }).start();
        }

    }
}


class SynchroClazz {

    public static synchronized void staticMethod() {
        System.out.println("Static synchro");
    }

    public synchronized void anotherMethod() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void method(int value) {
        if (value == 0) {
            return;
        }
        anotherMethod();
        System.out.println(value);
        method(value - 1);
    }

    public void nonSynchroMethod() {
        System.out.println("Non-synchro method");
    }
}