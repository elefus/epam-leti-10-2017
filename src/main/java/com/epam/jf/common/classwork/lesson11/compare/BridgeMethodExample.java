package com.epam.jf.common.classwork.lesson11.compare;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class BridgeMethodExample {

    public static void main(String[] args) {
        for (Method method : Person.class.getDeclaredMethods()) {
            System.out.println(method);
            System.out.println(method.isSynthetic());
            System.out.println(method.isBridge());
            System.out.println("----");
        }
    }
}
