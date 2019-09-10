package com.epam.jf.common.lesson26.pool1.practice;

import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Storage {

    private volatile String current = "DEFAULT";
    private final Semaphore semaphore = new Semaphore(Integer.MAX_VALUE, true);

    @SneakyThrows
    public void write(String value) {
        try {
            semaphore.acquire(Integer.MAX_VALUE);
            current = value;
            // sleep
        } finally {
            semaphore.release(Integer.MAX_VALUE);
        }
    }

    @SneakyThrows
    public String read() {
        try {
            semaphore.acquire();
            // sleep
            return current;
        } finally {
            semaphore.release();
        }
    }
}
