package com.epam.jf.common.classwork.lesson9;

import java.util.concurrent.TimeUnit;

public class AliveReferences {

    private static final String str = "123";

    private static InnerClass ref;

    public static void main(String[] args) throws InterruptedException {
        Object localObject = new Object();
        System.out.println(localObject);
        innerMethod();

        TimeUnit.SECONDS.sleep(15);

        int[] arr1 = new int[1_000_000_00];
        print(arr1);
        arr1 = null;


        TimeUnit.SECONDS.sleep(15);


        localObject = null;
        System.out.println(localObject);



//        System.gc();
//        Runtime.getRuntime().gc();

        TimeUnit.SECONDS.sleep(15);

        int[] arr2 = new int[1_000_000_00];
        Object anotherObject = new Object();
    }

    private static void print(int[] arr) {
        System.out.println(arr);
    }

    private static void innerMethod() {
        String innerString = "...";
        ref = new InnerClass(innerString);
    }

    static class InnerClass {
        private final String field;

        InnerClass(String field) {
            this.field = field;
        }
    }

}
