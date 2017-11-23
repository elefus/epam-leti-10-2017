package com.epam.jf.khvan.homework;

import com.epam.jf.common.homework.Task11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


class Task10 {

    public static void main(String[] args) {
        System.out.println( getSumDigits(0));

        ArrayList array = new ArrayList();
        array.add("a");
        array.add("b");//1
        array.add("c");//2
        array.add("d");//3
        array.add("e");

        array;
        array.subList(1,3).subList().subList()
        array.subList(1,3).add("h");
        LinkedList

        for (Object a:
                array.subList(1,8)) {
            System.out.println(a);
        }
        System.out.println(array.subList(1,8));





    }

    public static long getSumDigits(long value) {

        if (value >= 9){
            return (value % 10) + getSumDigits(value / 10);
        } else {
            return value;
        }
    }

}