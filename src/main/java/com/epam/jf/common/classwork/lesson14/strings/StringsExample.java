package com.epam.jf.common.classwork.lesson14.strings;

public class StringsExample {

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        String java = builder.append("ja1").append("va").toString();

        String ja = "ja1";
        String va = "va";
        String java2 = ja + va;
        System.out.println(System.identityHashCode(java2));

        java2 = java2.intern();
        System.out.println(System.identityHashCode(java2));

        String internedJava = java.intern();
        System.out.println(System.identityHashCode(internedJava));
        System.out.println(java2 == internedJava);

    }
}
