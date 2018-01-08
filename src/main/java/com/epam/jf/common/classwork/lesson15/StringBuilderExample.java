package com.epam.jf.common.classwork.lesson15;

public class StringBuilderExample {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Java StringBuilder");
        System.out.println("StringBuilder1 : " + sb);
        System.out.println(sb.capacity());

        sb.append(" Example");
        System.out.println("StringBuilder2 : " + sb);
        System.out.println(sb.capacity());

    }
}
