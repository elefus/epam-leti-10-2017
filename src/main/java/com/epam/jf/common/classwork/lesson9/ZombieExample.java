package com.epam.jf.common.classwork.lesson9;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class ZombieExample {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Zombie> list = new ArrayList<>();
        Zombie zombie = new Zombie(42, list);
        System.out.println(zombie);
        zombie = null;

        int[] arr1 = new int[1_000_000_00];
        print(arr1);
        arr1 = null;

        System.gc();
        System.runFinalization();

        int[] arr2 = new int[1_000_000_00];
        print(arr2);

        TimeUnit.SECONDS.sleep(1);

        System.out.println(Zombie.ref);

        Zombie.ref = null;

        System.gc();

        Zombie.ref = null;

        System.gc();

        Zombie.ref = null;

        System.gc();

        Zombie.ref = null;

        System.gc();

        System.out.println(Zombie.ref);

        System.out.println(list.get(0));
    }

    public static void print(int[] arr) {
        System.out.println(arr);
    }

}

class Zombie {

    public static Zombie ref;

    private final Integer value;

    private final List<Zombie> list;

    Zombie(Integer value, List<Zombie> list) {
        this.value = value;
        this.list = list;
    }

    @Override
    protected void finalize() throws Throwable {
        list.add(this);
    }
}