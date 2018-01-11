package com.epam.jf.common.classwork.lesson24.practice;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class Storage {

    private volatile String current = "DEFAULT";
    private volatile int activeReaders;
    private volatile boolean wannaWrite;
    private final Object monitor = new Object();
    private final Object activeReadersMonitor = new Object();

    @SneakyThrows
    public void write(String value) {
        wannaWrite = true;

        while (activeReaders != 0) {
            synchronized (monitor) {
                monitor.wait();
            }
        }

        if (activeReaders == 0) {
            synchronized (monitor) {
                TimeUnit.SECONDS.sleep(1);
                current = value;
                wannaWrite = false;
                monitor.notifyAll();
            }
        }
    }

    @SneakyThrows
    public String read() {
        while (wannaWrite) {
            synchronized (monitor) {
                monitor.wait();
            }
        }
        try {

            // 5

            synchronized (activeReadersMonitor) {
                ++activeReaders;
            }
            TimeUnit.SECONDS.sleep(1);
            return current;
        } finally {
            synchronized (activeReadersMonitor) {
                if (--activeReaders == 0) {
                    synchronized (monitor) {
                        monitor.notify();
                    }
                }

            }
        }
    }
}
