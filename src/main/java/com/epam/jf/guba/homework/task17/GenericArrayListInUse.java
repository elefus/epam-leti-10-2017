package com.epam.jf.guba.homework.task17;

import java.util.Comparator;

public class GenericArrayListInUse {

    public static void main(String[] args) {
        GenericArrayList<String> first = new GenericArrayList<>();
        GenericArrayList<String> second = new GenericArrayList<>();

        first.add("A");
        first.add("B");
        first.add("C");
        first.add("D");

        second.add("C");
        second.add("D");
        second.add("E");
        second.add("F");

        System.out.println("First size");
        System.out.println(first.size());
        System.out.println("Second size");
        System.out.println(second.size());
        System.out.println();
        System.out.println("Contains A");
        System.out.println(first.contains("A"));
        System.out.println("Get E");
        System.out.println(second.get(2));
        System.out.println("remove A and B from first");
        first.remove("A");
        first.remove(0);
        System.out.println("Contains first in second");
        System.out.println(second.containsAll(first));
        System.out.println("Clear first");
        first.clear();
        System.out.println(first.size());
        System.out.println("Add second in first");
        first.addAll(second);
        System.out.println(first.size());
        System.out.println("sort");
        System.out.println(first.get(0));
        System.out.println(first.get(first.size()-1));
        first.sort(Comparator.reverseOrder());
        System.out.println(first.get(0));
        System.out.println(first.get(first.size()-1));



    }

}
