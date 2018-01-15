package com.epam.jf.common.classwork.lesson10.shadowing;

@SuppressWarnings("AccessStaticViaInstance")
public class Launcher {

    public static void main(String[] args) {
        Parent parent = new Child3();
        parent.printMe();

        Child1 child1 = new Child2();
        child1.printMe();

        Child3 child3 = new Child3();
        child3.printMe();

        Child3.printMe();
    }
}
