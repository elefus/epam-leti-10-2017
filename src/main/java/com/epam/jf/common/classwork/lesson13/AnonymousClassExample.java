package com.epam.jf.common.classwork.lesson13;


import java.util.Arrays;
import java.util.Comparator;

@SuppressWarnings("Convert2Lambda")
public class AnonymousClassExample {

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 1, 2, 3};

        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });

        System.out.println(Arrays.toString(arr));

        A a = new A() {
            @Override
            int method() {
                return 1;
            }
        };
        System.out.println(a.method());

    }
}

class A {
    int method() {
        return 0;
    }
}



