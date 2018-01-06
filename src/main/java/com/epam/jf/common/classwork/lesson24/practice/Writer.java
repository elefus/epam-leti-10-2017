package com.epam.jf.common.classwork.lesson24.practice;

import java.util.concurrent.TimeUnit;

public class Writer  implements Runnable {

    private final Storage storage;

    public Writer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                storage.write(String.valueOf(System.currentTimeMillis()));
                TimeUnit.SECONDS.sleep(3);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
