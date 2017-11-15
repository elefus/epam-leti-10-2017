package com.epam.jf.common.classwork.lesson10;

public class Child1 extends Parent {

    public void printFields() {
        System.out.println(this.packageField);
        System.out.println(this.protectedField);
    }

    public void printFields(Child1 out) {
        System.out.println(out.packageField);
        System.out.println(out.protectedField);
    }
}
