package com.epam.jf.common.classwork.lesson5;

import java.util.ArrayList;

public class ArraysExample {

    public static void main(String[] args) {
        Integer[][] arr = new Integer[10][];


        arr[0] = new Integer[10];
        System.out.println(arr[0]);
        System.out.println(arr[0][0]);

        Integer [] arr1 [];
        Integer arr2[][];
        Integer[][] res = getArr();

        Number[] values = {1, 2, 3, 4};

        values = new Integer[]{10, 20};

        int[] ints = {100, 200, 300};
        int[] clone = ints.clone();

        Number[] clone1 = values.clone();


        Object[] objects = null;
        String[] strings = null;
        objects = strings;

        ArrayList<Object> list = null;
        ArrayList<String> stringList = null;
//        list = stringList;

//        int[] ints = {1, 2, 3, 4};
//        System.out.println(Arrays.toString(ints));
//
//        Integer[] wrappers = {1, 2, 3, 4};
//        System.out.println(Arrays.toString(wrappers));
    }

    public static Integer[] getArr() [] {
        return new Integer[10][10];
    }

}
