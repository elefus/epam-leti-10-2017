package com.epam.jf.common.classwork.lesson7;

public class Lesson7 {

    public static int ёба = 42;
    public static int val = 0;

    public Lesson7() {
    }

    public static void main(String[] args) {
        Lesson7 lesson7 = new Lesson7();

        SignatureExample signatureExample = new SignatureExample();
        int val = signatureExample.getValue();
        double val2 = signatureExample.getValue();
        signatureExample.getValue();

        String str;

        String s = fromZeroTo(5);
        System.out.println(s);


        String from = from(-2, 5);
        System.out.println(from);
        if (!from.equals("-2 -1 0 1 2 3 4 5")) {
            System.out.println("False");
        }

        String from1 = from(10, 8);
        System.out.println(from1);
        if (!from1.equals("10 9 8")) {
            System.out.println("False");
        }

        SignatureExample signatureExample1 = new SignatureExample();
        signatureExample.getValue();
    }

    public static void method(String[] args) {
        main(args);
    }

    public static String fromZeroTo(int value) {
        return value == 0 ? "0"
                          : fromZeroTo(value - 1) + " " + value;
    }

    public static String from(int from, int to) {
        return from == to ? String.valueOf(from)
                          : from + " " + from(from + ((from > to) ? -1 : 1), to);
    }

}

class SignatureExample {



    // () -> int
    public static int getValueStatic() {
        return 0;
    }

    // SignatureExample -> int
    public static int getValueStatic(SignatureExample ref) {
        return 0;
    }

    // SignatureExample -> int
    public int getValue() {
        System.out.println(this);
        return 0;
    }

//    public double getValue() {
//        return 0;
//    }
}
