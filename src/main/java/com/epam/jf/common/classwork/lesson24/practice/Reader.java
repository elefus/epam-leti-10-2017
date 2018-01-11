package com.epam.jf.common.classwork.lesson24.practice;

import java.util.concurrent.TimeUnit;

public class Reader extends Thread {

    private final Storage storage;

    public Reader(String name, Storage storage) {
        super(name);
        this.storage = storage;
    }

    @Override
    public void run() {
        try {
            Thread current = Thread.currentThread();
            while (!Thread.interrupted()) {
                System.out.println(current.getName() + ": " + storage.read());
                TimeUnit.MILLISECONDS.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
