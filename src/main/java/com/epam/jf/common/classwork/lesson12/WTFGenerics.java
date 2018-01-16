package com.epam.jf.common.classwork.lesson12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WTFGenerics {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3);
//        getFirstNumber(integers);
        Number first = getFirst(integers);
        Integer firstGeneric = getFirstGeneric(integers);

        String str = createList();
    }

    private static <T extends List> T createList() {
        return (T)new ArrayList<>();
    }

    private static Number getFirstNumber(List<Number> list) {
        return list.get(0);
    }

    private static Number getFirst(List<? extends Number> list) {
        return list.get(0);
    }

    private static <T extends Number> T getFirstGeneric(List<T> list) {
        return list.get(0);
    }
}
