package com.epam.jf.common.classwork.lesson5;

public class InternStringExample {

    public static void main(String[] args) {
//        System.out.println(Lib.version);
//        String string = "123A";
//        String string2 = "123a";
//        String string3 = new String(string2).intern();
//        System.out.println(string == string2);
//        System.out.println(string2.equals(string3));
//        System.out.println(string.equalsIgnoreCase(string2));
//        System.out.println(concat());

        test();


    }


    public static void test() {
        String string1 = "abc";
        String string2 = "abc";
        System.out.println(string1 == string2);

        String string3 = "a" + "bc";
        System.out.println(string1 == string3);

        String string4 = "a" + 'b' + 'c';
        System.out.println(string1 == string4);

        final String a = "a";
        String string5 = a + "bc";
        System.out.println(string1 == string5);

        System.out.println(string1 == ManyFields.abc);
    }

    public static String getAbc() {
        return "abc";
    }

    public static String concat() {
        return getValue() + 10.5 + "a" + ")";
    }


    public static int getValue() {
        return 123;
    }
}


class ManyFields {


    public final static String abc = "abc";

    int a;
    int b;
    int c;
    int d;
    int e;
    int g;
    int f;

    @Override
    public String toString() {
        return "ManyFields{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                ", e=" + e +
                ", g=" + g +
                ", f=" + f +
                '}';
    }
}

