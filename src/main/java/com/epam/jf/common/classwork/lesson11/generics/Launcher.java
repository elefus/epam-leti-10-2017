package com.epam.jf.common.classwork.lesson11.generics;

public class Launcher {

    public static void main(String[] args) {
        Optional<Integer> integerOptional = new Optional<>();
        integerOptional.setValue(1);
//        integerOptional.setValue("2");// ERROR
        int v1 = integerOptional.getValue();

        // параметризация типом String
        Optional<String> stringOptional = new Optional<>("Java");
        String v2 = stringOptional.getValue();

        // ob1 = ob2; //ERROR
        Optional rawOptional = new Optional();
        rawOptional.setValue("Java SE 6");
        rawOptional.setValue(71);
        rawOptional.setValue(null);

        rawOptional = integerOptional;
        rawOptional.setValue("qq");
        System.out.println(rawOptional.getValue());
        System.out.println(integerOptional.getValue());
    }
}
