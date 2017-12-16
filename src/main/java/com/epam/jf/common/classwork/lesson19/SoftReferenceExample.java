package com.epam.jf.common.classwork.lesson19;

import lombok.SneakyThrows;

import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

public class SoftReferenceExample {

    @SneakyThrows
    public static void main(String[] args) {
        B ref = new B();
        SoftReference<B> softReference = new SoftReference<>(ref);

        ref = null;

        System.out.println(Runtime.getRuntime().freeMemory());

        int[] arr = new int[700_000_000];
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(arr);
//        arr = null;

        TimeUnit.SECONDS.sleep(5);
        System.gc();
        TimeUnit.SECONDS.sleep(5);
        System.out.println(arr);
        System.out.println(Runtime.getRuntime().freeMemory());

        B strongReference = softReference.get();
        if (strongReference != null) {
            System.out.println(strongReference.getField());
        } else {
            System.out.println("Removed by GC!");
        }
    }
}

class B {
    private int[] arr = new int[1_000_000];
    private int field = 42;

    public int getField() {
        return field;
    }
}
