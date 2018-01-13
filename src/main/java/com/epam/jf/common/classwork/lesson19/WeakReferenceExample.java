package com.epam.jf.common.classwork.lesson19;

import lombok.SneakyThrows;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class WeakReferenceExample {

    @SneakyThrows
    public static void main(String[] args) {
        B ref = new B();
        ReferenceQueue<B> queue = new ReferenceQueue<>();
        WeakReference<B> weakReference = new WeakReference<>(ref, queue);

        ref = null;

        System.out.println(Runtime.getRuntime().freeMemory());

        int[] arr = new int[700_000_000];
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(arr);
//        arr = null;

        System.gc();
        System.out.println(arr);
        System.out.println(Runtime.getRuntime().freeMemory());

        System.out.println(weakReference.isEnqueued());

        Reference<? extends B> referenceToRemovedObject = queue.remove();
        System.out.println(weakReference == referenceToRemovedObject);


        B strongReference = weakReference.get();
        if (strongReference != null) {
            System.out.println(strongReference.getField());
        } else {
            System.out.println("Removed by GC!");
        }
    }

}
