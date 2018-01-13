package com.epam.jf.common.lesson26.pool1.practice;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Launcher {

    public static void main(String[] args) {
        Storage storage = new Storage();
        Writer writer = new Writer(storage);

        IntStream.range(0, 5)
                 .mapToObj(index -> new Reader(String.valueOf(index), storage))
                 .forEach(reader -> {
                     try {
                         TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(1000));
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                     reader.start();
                 });

        new Thread(writer).start();
    }
}
