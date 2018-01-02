package com.epam.jf.common.lesson26.pool1;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5, true);
        try {

            semaphore.acquire();
            System.out.println("123");
            // ...
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
