package com.epam.jf.common.classwork.lesson23;

class Clicker extends Thread {

    int click = 0;

    @Override
    public void run() {
        while (!isInterrupted()) {
            click++;
        }
    }
}

public class PriorityDemo {

    public static void main(String args[]) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

        Clicker[] clickers = new Clicker[10];
        for (int i = Thread.MIN_PRIORITY; i <= Thread.MAX_PRIORITY; i++) {
            clickers[i - 1] = new Clicker();
            clickers[i - 1].setPriority(i);
        }

        for (Clicker clicker : clickers) {
            clicker.start();
        }

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        try {
            for (Clicker clicker : clickers) {
                clicker.interrupt();
            }

            for (Clicker clicker : clickers) {
                clicker.join();
            }
        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " = " + clickers[i].click);
        }
    }
}


