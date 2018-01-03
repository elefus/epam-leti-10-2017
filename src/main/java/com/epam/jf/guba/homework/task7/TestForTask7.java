package com.epam.jf.guba.homework.task7;

import java.util.NoSuchElementException;

public class TestForTask7 {

    public static void main(String[] args) {
        Task7 task7 = new Task7();
        task7.add(1);
        task7.add(5);
        task7.add(7);
        task7.add(15);
        task7.add(55);
        task7.add(25);
        System.out.println("Task7 list size: " + task7.size);
        System.out.print("Task7 list: ");
        printList(task7);
        System.out.println("Set value " + task7.set(555, 2));
        System.out.println("Task7 list size: " + task7.size);
        System.out.print("Task7 list: ");
        printList(task7);
        task7.add(125, 4);
        System.out.println("Task7 list size: " + task7.size);
        System.out.print("Task7 list: ");
        printList(task7);
        System.out.println("To delete: " + task7.remove(0));
        System.out.println("Task7 list size: " + task7.size);
        System.out.print("Task7 list: ");
        printList(task7);
        System.out.println("To delete: " + task7.remove(3));
        System.out.println("Task7 list size: " + task7.size);
        System.out.print("Task7 list: ");
        printList(task7);
        System.out.println("To delete: " + task7.remove(4));
        System.out.println("Task7 list size: " + task7.size);
        System.out.print("Task7 list: ");
        printList(task7);
        task7.add(1);
        task7.add(5);
        task7.add(7);
        task7.add(15);
        task7.add(55);
        task7.add(25);
        task7.add(1);
        task7.add(5);
        task7.add(7);
        task7.add(15);
        task7.add(55);
        task7.add(25);
        task7.add(1);
        task7.add(5);
        task7.add(7);
        task7.add(15);
        task7.add(55);
        task7.add(25);
        task7.add(1);
        task7.add(5);
        task7.add(7);
        task7.add(15);
        task7.add(55);
        task7.add(25);
        task7.add(1);
        task7.add(5);
        task7.add(7);
        task7.add(15);
        task7.add(55);
        task7.add(25);
        task7.add(1);
        task7.add(5);
        task7.add(7);
        task7.add(15);
        task7.add(55);
        task7.add(25);
        task7.add(1);
        task7.add(5);
        task7.add(7);
        task7.add(15);
        task7.add(55);
        task7.add(25);
        task7.add(1);
        task7.add(5);
        task7.add(7);
        task7.add(15);
        task7.add(55);
        task7.add(25);
        System.out.println("Task7 list size: " + task7.size);
        System.out.print("Task7 list: ");
        printList(task7);
        task7.clear();
        System.out.println("Task7 list size: " + task7.size);
        System.out.print("Task7 list: ");
        printList(task7);
        Task7 anotherList = new Task7(25);
        anotherList.add(1);
        anotherList.add(2);
        anotherList.add(3);
        anotherList.add(4);
        anotherList.add(5);
        anotherList.add(6);
        anotherList.add(7);
        anotherList.add(8);
        anotherList.add(9);
        anotherList.add(10);
        anotherList.add(11);
        System.out.println("Another list size: " + anotherList.size);
        System.out.print("Another list: ");
        printList(anotherList);
        task7.addAll(anotherList);
        System.out.println("Task7 list size: " + task7.size);
        System.out.print("Task7 list: ");
        printList(task7);
        task7.add(5, 5);
        task7.add(7, 7);
        task7.add(15);
        System.out.println("Task7 list size: " + task7.size);
        System.out.print("Task7 list: ");
        printList(task7);
        if (task7.containsAll(anotherList)) {
            System.out.println();
            System.out.println("Task7 contains all Another list");
            System.out.println();
            System.out.println();
        }

        anotherList.add(245242);

        System.out.println("Another list size: " + anotherList.size);
        System.out.print("Another list: ");
        printList(anotherList);
        System.out.println("Task7 list size: " + task7.size);
        System.out.print("Task7 list: ");
        printList(task7);

        if (!task7.containsAll(anotherList)) {
            System.out.println();
            System.out.println("Task7 doesn't contains all Another list");
            System.out.println();
            System.out.println();

        }

        if (task7.contains(8)) {
            System.out.println();
            System.out.println("But Task7 contains 8");
            System.out.println();
            System.out.println();

        }

        anotherList.clear();
        System.out.println("Another list size: " + anotherList.size);
        System.out.print("Another list: ");
        printList(anotherList);
        if (anotherList.isEmpty()) {
            System.out.println();
            System.out.println("Another list is empty");
            System.out.println();
            System.out.println();
        }

        System.out.println("Index of 5 in task7 is " + task7.indexOf(5));
        System.out.println();
        System.out.println("Index of 1 in task7 is " + task7.indexOf(1));
        System.out.println();
        System.out.println();
        System.out.println("Last index of 7 in task7 is " + task7.lastIndexOf(7));
        System.out.println();
        System.out.println("Last index of 15 in task7 is " + task7.lastIndexOf(15));
        System.out.println();
        System.out.println();

        Task7 sublist = (Task7) task7.subList(4, 8);
        System.out.println("Sublist size: " + sublist.size);
        System.out.print("Sublist: ");
        printList(sublist);

        System.out.println("PREPARE TO CATCH SOME EXCEPTIONS");
        try {
            task7.get(task7.size);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println(ex.getMessage());
        }

        try {
            task7.get(-1);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println(ex.getMessage());
        }

        try {
            task7.add(task7.size + 1);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println(ex.getMessage());
        }

        try {
            task7.add(-100);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println(ex.getMessage());
        }

        try {
            task7.set(100, task7.size);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println(ex.getMessage());
        }

        try {
            task7.set(100, -1);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println(ex.getMessage());
        }

        try {
            task7.remove(task7.size);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println(ex.getMessage());
        }

        try {
            task7.remove(-1);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println(ex.getMessage());
        }

        try {
            task7.indexOf(10000000);
        } catch (NoSuchElementException ex) {
            System.err.println(ex.getMessage());
        }

        try {
            task7.lastIndexOf(10000000);
        } catch (NoSuchElementException ex) {
            System.err.println(ex.getMessage());
        }

        System.out.println();
        System.out.println();
        Task7 task71 = new Task7(0);
        task7.add(1);

    }

    private static void printList(Task7 task7) {
        for (int i = 0; i < task7.size; i++) {
            System.out.print(task7.get(i) + " ");
        }
        System.out.println();

    }

}
