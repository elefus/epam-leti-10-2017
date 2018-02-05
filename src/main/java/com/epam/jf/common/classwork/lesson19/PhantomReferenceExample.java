package com.epam.jf.common.classwork.lesson19;

import lombok.SneakyThrows;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class PhantomReferenceExample {

    @SneakyThrows
    public static void main(String[] args) {
        Integer[] values = new Integer[5];
        Integer[] integers = Arrays.asList(1, 2, 3, 4, 5).toArray(values);
        System.out.println(values == integers);

        Number[] numbers = Arrays.asList(1, 2, 3, 4, 5).toArray(new Number[0]);
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(values));


        Finalized ref = new Finalized(1);

        ReferenceQueue<Finalized> queue = new ReferenceQueue<>();
        Reference<Finalized> phantomReference = new PhantomReferenceWithID<>(ref, queue, ref.getId());

        ref = null;

        int[] arr = new int[700_000_000];
        System.out.println(arr);

        System.gc();
        System.out.println(arr);

        TimeUnit.SECONDS.sleep(2);

        System.out.println(phantomReference.isEnqueued());

        System.gc();

        System.out.println(arr);

        TimeUnit.SECONDS.sleep(2);

        PhantomReferenceWithID<Finalized> preparedToRemove = (PhantomReferenceWithID<Finalized>) queue.remove();
        System.out.println(preparedToRemove.getId());
        preparedToRemove.clear();

        System.gc();

        System.out.println(arr);
    }

}

class Finalized {

    private final int id;

    Finalized(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            System.out.println("Object finalized");
        } finally {
            super.finalize();
        }
    }
}

class PhantomReferenceWithID<T> extends PhantomReference<T> {

    private final int id;

    public PhantomReferenceWithID(T referent, ReferenceQueue<? super T> q, int id) {
        super(referent, q);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}