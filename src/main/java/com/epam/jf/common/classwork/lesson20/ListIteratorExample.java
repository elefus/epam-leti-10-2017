package com.epam.jf.common.classwork.lesson20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class ListIteratorExample {

    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ListIterator<Integer> iterator = ints.listIterator();
        iterator.next();
        iterator.next();
        iterator.set(0);

        System.out.println(ints);

        iterator.add(10);
        System.out.println(iterator.previous());
        System.out.println(iterator.next());
        iterator.set(20);
        System.out.println(iterator.previous());
    }
}
