package com.epam.jf.common.classwork.lesson21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsExample {

    public static void main(String[] args) {
        int result = Collections.binarySearch(Arrays.asList(1, 10, 5, 8, 1, 9, 3), 10);
        System.out.println(result);

        List<String> list = new ArrayList<>();
        List<String> checkedList = Collections.checkedList(list, String.class);
        List rawList = checkedList;
        List<Integer> intList = rawList;
        intList.add(10);
        System.out.println(list);

        String s = list.get(0);
    }

    @SuppressWarnings("unchecked")
    public void swap(List<?> list, int left, int right) {
        final List l = list;
        l.set(right, l.set(left, l.get(right)));
    }
}
