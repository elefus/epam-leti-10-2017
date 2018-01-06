package com.epam.jf.common.classwork.lesson9;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilePermission;
import java.util.concurrent.TimeUnit;

public class FinalizerAttackExample {

    protected String anotherFiled = "123";
    protected FileOutputStream stream;
    protected int value;

    public FinalizerAttackExample(String fileName, int value) throws FileNotFoundException {
        this(fileName, checkValue(value), 0);
        SecurityManager manager = System.getSecurityManager();


        if (manager != null) {
            manager.checkPermission(new FilePermission(fileName, "write"));
            manager.checkPermission(new FilePermission("default.txt", "write"));
        }

        try {
            stream = new FileOutputStream(fileName);
        } catch (FileNotFoundException e) {
            stream = new FileOutputStream("default.txt");
        }

        this.value = value;
    }

    private static int checkValue(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException();
        }
        return value;
    }

    private FinalizerAttackExample(String fileName, int value, int tmp) {
        super();
    }

    public void process() {
        // stream.write(...);
    }
}

class Hacker extends FinalizerAttackExample {

    public static Hacker zombie;

    public Hacker(String fileName, int value) throws FileNotFoundException {
        super(fileName, value);
    }

    @Override
    protected void finalize() throws Throwable {
        zombie = this;
    }
}

class Launcher {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        FinalizerAttackExample finalizerAttackExample = null;
        try {
            finalizerAttackExample = new FinalizerAttackExample("123.txt", -1);
        } catch (RuntimeException ex) {
            ex.printStackTrace();
        }
        System.out.println(finalizerAttackExample);

        Hacker hacker = null;
        try {
            hacker = new Hacker("123.txt", -1);
        } catch (RuntimeException ex) {
            ex.printStackTrace();
        }
        System.out.println(hacker);


        int[] arr1 = new int[1_000_000_00];
        print(arr1);
        arr1 = null;

        System.gc();
        System.runFinalization();

        int[] arr2 = new int[1_000_000_00];
        print(arr2);

        TimeUnit.SECONDS.sleep(1);

        System.out.println(Hacker.zombie);


    }

    public static void print(int[] arr) {
        System.out.println(arr);
    }
}

