package com.epam.jf.common.classwork.lesson20;

import java.util.*;

public class ConcurrentModificationExample {

    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 1));

        Set<Integer> singleton = Collections.singleton(1);
        ints.removeAll(singleton);
//        for (Integer value : ints) {
//            if (value > 2) {
//                ints.remove(value);
//            }
//        }

//        Iterator<Integer> iterator = ints.iterator();
//        while (iterator.hasNext()) {
//            Integer value = iterator.next();
//            if (value > 2) {
//                ints.remove(value);
//            }
//        }

        Iterator<Integer> iterator = ints.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            if (value > 2) {
                iterator.remove();
            }
        }

        ints.removeIf(value -> value > 2);
        System.out.println(ints);
    }
}
