package com.epam.jf.common.classwork.lesson23;

public class ThreadGroupDemo {
    public static void main(String[] args) {
        ThreadGroup groupA = new ThreadGroup("Group A");
        ThreadGroup groupB = new ThreadGroup("Group B");
        MyThread ob1 = new MyThread("One", groupA);
        ob1.start();

        MyThread ob2 = new MyThread("Two", groupA);
        ob2.start();

        MyThread ob3 = new MyThread("Three", groupB);
        ob3.start();

        MyThread ob4 = new MyThread("Four", groupB);
        ob4.start();

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        groupA.interrupt();

    }
}

class MyThread extends Thread {

    public MyThread(String name, ThreadGroup group) {
        super(group, name);
        System.out.println("New thread: " + this);
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(getName() + ": " + i);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println("Exception in " + getName());
        }
        System.out.println(getName() + " exiting.");
    }
}
