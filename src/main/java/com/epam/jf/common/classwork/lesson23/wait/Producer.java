package com.epam.jf.common.classwork.lesson23.wait;

import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable {

    private final Queue<Integer> queue;

    public Producer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                TimeUnit.SECONDS.sleep(1);
                synchronized (queue) {
                    queue.offer(ThreadLocalRandom.current().nextInt());
                    queue.notify();

                    //....
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
