package com.epam.jf.guba.homework.task17;

import java.util.Comparator;

public class GenerikLinkedListInUse {


    public static void main(String[] args) {

        GenericLinkedList<String> first = new GenericLinkedList<>();
        GenericLinkedList<String> second = new GenericLinkedList<>();

        first.add("A");
        first.add("B");
        first.add("C");
        first.add("D");
        System.out.println("FIRST");
        printList(first);

        second.add("C");
        second.add("D");
        second.add("E");
        second.add("F");
        System.out.println("SECOND");
        printList(second);

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
        printList(first);
        System.out.println("Contains first in second");
        System.out.println(second.containsAll(first));
        System.out.println("Clear first");
        first.clear();
        System.out.println(first.size());
        System.out.println("Add second in first");
        first.addAll(second);
        System.out.println(first.size());
        printList(first);
        System.out.println("sort");
        try {
            first.sort(Comparator.reverseOrder());
        } catch (UnsupportedOperationException ex){
            System.out.println("correct");
        }
    }


    private static void printList(GenericLinkedList linkedList){
        for(int i = 0; i < linkedList.size(); i++){
            System.out.print(linkedList.get(i)+ ", ");
        }
        System.out.println();
    }
}
