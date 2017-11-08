package com.epam.jf.common.classwork.lesson4;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Lesson4 implements Iterable<Integer> {

    static {
//        System.out.println("Static logical block");
//        if (true) {
//            throw new RuntimeException();
//        }
//        System.out.println("Static logical block");
    }

    {
        System.out.println("Logical block");
    }

    public static void main(String[] args) {
        {

        }
//        wrappersExample();
//        arraysExample();
//        bitOperations();
//        boolean left = logicalOperations();
//        doublesExample(left);

        Number[] numbers = {1, 2, 3, 4, 5};
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        for (Number number : numbers) {
            System.out.println(number);
        }

        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (Integer integer : new Lesson4()) {
            System.out.println(integer);
        }


        int value = 0;
        boolean flag = true;
        label2: {
            for (int i = 0; flag && i < 10; i++) {
                for (int j = 0; flag && j < 10; j++) {
                    for (int k = 0; flag && k < 10; k++) {
                        if (++value == 50) {
                            flag = false;
                        }
                    }
                }
            }

            label:
            {
                int value2 = 0;
                outer: for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        for (int k = 0; k < 10; k++) {
                            if (++value2 == 50) {
                                break label2;
                            }
                        }
                    }
                }
                System.out.println(value2);
            }
            System.out.println("After label");
        }
        System.out.println("After label2");

        int val = 10;
        switch (val) {
            case 0:
            case 1:
            case 2:
                System.out.println("Lol");
                break;

            case 3:
            case 4:
            case 5:
                System.out.println("WTF");
                break;

            default:
                System.out.println("DEF");
        }



        String.valueOf(10);
        Integer.valueOf("10qwe");
        String str = "" + 10;

        String s = "abc" + "def";

        method("123");
        String[] strings = {"123", "123"};
        System.out.println(strings[0]);
    }


    public static void method(String string) {

    }

    @Override
    public Iterator<Integer> iterator() {
        return Arrays.asList(1, 2, 3, 4).iterator();
    }

    private static boolean logicalOperations() {
        boolean left = true;
        boolean right = false;
        if (calcLeft() && calcRight()) {
            System.out.println();
        }
        return left;
    }

    private static void doublesExample(boolean left) {
        Number object = left ? 10.0 : 1;

        double nan1 = 0d / 0;
        double nan2 = 0d / 0;
        System.out.println(nan1);
        System.out.println(nan2);
        System.out.println(Double.NaN == Double.NaN);
        System.out.println(Double.NaN == nan1);
        System.out.println(Double.NaN == nan2);
        System.out.println(nan1 == nan2);
//        System.out.println(nan1.equals(nan2));
        System.out.println(Double.isNaN(nan1));
    }

    public static boolean calcLeft() {
        System.out.println("Left");
        return false;
    }


    public static boolean calcRight() {
        System.out.println("Right");
        return false;
    }

    private static void bitOperations() {
        int value = 0b0111001;
        int result = value >> 3; // 0b0.....0111
        int negativeValue = 0b1111_1111_1111_1111_1111_1111_1111_0110;
        int negativeShiftResult = negativeValue >>> 4; // 0b0000_1111_1111_1111_1111_1111_1111_1111;
        int negativeShiftWithoutZeroesResult = negativeValue >> 4; // 0b1111_1111_1111_1111_1111_1111_1111_1111;
    }

    private static void wrappersExample() {
        Integer value = 10;
        int result = value.compareTo(50);
        System.out.println(Character.isJavaIdentifierPart('3'));
        System.out.println(Character.isJavaIdentifierStart('3'));

        Short shortValue = (short)100000;
        Integer intValue = shortValue.intValue();
    }

    private static void arraysExample() {
        // 8   <- header
        // 4   <- size
        // 72  <- data
        // 4   <- padding

        Integer[] integers = new Integer[]{1, 2, 3, 4, 5, 6};
        Number[] numbers = integers;
        numbers[0] = new Double(30.5);

        Number[] nums = {1, 2, 3, 4, 5};
        Integer[] refToIntArray = (Integer[]) nums;
    }


    class B {

    }
}


class A {

}
