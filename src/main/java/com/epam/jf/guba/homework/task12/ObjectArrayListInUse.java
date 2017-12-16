package com.epam.jf.guba.homework.task12;

public class ObjectArrayListInUse {

    public static void main(String[] args) {
        ObjectArrayList objectArrayList = new ObjectArrayList(15);
        System.out.println(objectArrayList.size());
        objectArrayList.add(new Object());
        objectArrayList.add(new Object());
        objectArrayList.add(new Object());
        objectArrayList.add(new Object());
        objectArrayList.add(new Object());
        objectArrayList.add(new Object(), 2);
        System.out.println(objectArrayList.size());
        objectArrayList.remove(1);
        System.out.println(objectArrayList.size());
        ObjectArrayList sublist = (ObjectArrayList) objectArrayList.subList(1, 3);
        System.out.println(sublist.size());
        objectArrayList.clear();
        System.out.println(objectArrayList.size());
    }
}
