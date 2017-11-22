package com.epam.jf.common.classwork.lesson11.generics;

import java.util.ArrayList;
import java.util.List;

public class RawCollectionsExample {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        List rawList = integers;
        rawList.add("qwerty");

        List<Double> doubleList = rawList;

        System.out.println(integers);
        System.out.println(integers.get(0));
        System.out.println(integers.get(3));

        System.out.println(doubleList.get(0));

        Double aDouble = doubleList.get(0);
        System.out.println(aDouble);
    }
}
