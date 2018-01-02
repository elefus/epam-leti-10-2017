package com.epam.jf.common.classwork.lesson23.wait;

import java.util.Queue;

public class Consumer implements Runnable {

    private final Queue<Integer> queue;

    public Consumer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                    synchronized (queue) {
                        while (queue.isEmpty()) {
                            queue.wait();
                        }
                        System.out.println(queue.poll());
                    }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
