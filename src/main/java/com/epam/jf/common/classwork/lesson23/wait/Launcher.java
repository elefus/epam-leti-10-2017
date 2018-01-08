package com.epam.jf.common.classwork.lesson23.wait;

import java.util.LinkedList;
import java.util.Queue;

public class Launcher {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }
}
