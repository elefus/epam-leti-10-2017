package com.epam.jf.common.classwork.lesson12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapPollutionVarargs {

    public static void main(String[] args) {
//        List<Integer>[] arrLists = new List<Integer>[100];
//        Object[] objects = arrLists;
//        List<String>[] arrStrings = (List<String>[])objects;
//        arrStrings[0].add("123");
        List<Integer> list = new ArrayList<>();
        list.add(0);
        List<Integer> list2 = new ArrayList<>();

        List<String> strings = convert(list, list2);

        String val = strings.get(0);
        System.out.println(val);
    }

    private static List<String> convert(List<Integer>...args) {
        Object[ ] objects = args;
        return (List<String>) objects[0];
    }


}
