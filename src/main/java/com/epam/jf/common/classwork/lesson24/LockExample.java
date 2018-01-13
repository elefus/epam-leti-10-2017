package com.epam.jf.common.classwork.lesson24;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.*;

public class LockExample {

    private final Lock monitor = new ReentrantLock();

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        Condition condition = lock.newCondition();

        AtomicInteger atomicInteger = new AtomicInteger();

        try {
            boolean b = lock.tryLock(10, TimeUnit.MICROSECONDS);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void oldStyle() {
        // TODO ...
    }

    private void lockStyle() {
        try {
            boolean isLocked = monitor.tryLock();
            if (isLocked) {
                // TODO ...
            } else {

            }
        } finally {
            monitor.unlock();
        }
    }
}
