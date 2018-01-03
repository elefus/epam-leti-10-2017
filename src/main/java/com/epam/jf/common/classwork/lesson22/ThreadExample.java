package com.epam.jf.common.classwork.lesson22;

import java.util.concurrent.TimeUnit;

public class ThreadExample {

    public static void main(String[] args) throws InterruptedException {
//        interruptedExceptionExample();
        Thread thread = new Thread(() -> {
            long value = 0;
            while (!Thread.interrupted()) {
                value++;
                Thread.yield();
            }
            System.out.println(value);
        });
        thread.start();

        TimeUnit.SECONDS.sleep(5);
        thread.interrupt();

    }

    private static void interruptedExceptionExample() throws InterruptedException {
        Talk talk  = new Talk();
        talk.start();

        Thread walk = new Thread(new Walk());
        walk.start();

        TimeUnit.MILLISECONDS.sleep(20);
        walk.interrupt();
    }
}


class Walk implements Runnable {

    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted");
                break;
            }
        }

        System.out.println(Thread.currentThread().isInterrupted());
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().isInterrupted());
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().isInterrupted());
    }
}

class Talk extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 8; i++) {
            System.out.println("Talking");
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.err.print(e);
            }
        }
    }
}

