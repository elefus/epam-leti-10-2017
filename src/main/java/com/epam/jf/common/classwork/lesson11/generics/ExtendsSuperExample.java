package com.epam.jf.common.classwork.lesson11.generics;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ExtendsSuperExample {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(10);
        Integer integer = integerList.get(0);

        List<Number> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2.5);
        Number number = numbers.get(0);
        if (number instanceof Integer) {
            System.out.println("Really integer");
        }

        List<? extends Number> list2 = integerList;
        List<? extends Number> list3 = new ArrayList<Float>();
        List<? extends Number> list4 = new ArrayList<Number>();
        list2.add(null);
        Number number1 = list2.get(0);

        List<? super Integer> list5 = new ArrayList<Integer>();
        List<? super Integer> list6 = new ArrayList<Number>();
        List<? super Integer> list7 = new ArrayList<Object>();
        Number val = 10.5;
        list5.add(10);
        Object object = list5.get(0);

        // Producer
        // Extends
        // Consumer
        // Super
    }



}
