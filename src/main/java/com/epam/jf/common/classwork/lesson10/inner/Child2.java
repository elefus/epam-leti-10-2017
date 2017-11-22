package com.epam.jf.common.classwork.lesson10.inner;


import com.epam.jf.common.classwork.lesson10.Child4;
import com.epam.jf.common.classwork.lesson10.Parent;

public class Child2 extends Parent {

    public void printFields() {
//        System.out.println(this.packageField);
        System.out.println(this.protectedField);
    }

    public void printFields(Parent out) {
//        System.out.println(out.packageField);
//        System.out.println(out.protectedField);
    }

    public void printFields(Child2 out) {
//        System.out.println(out.packageField);
        System.out.println(out.protectedField);
    }

    public void printFields(Child3 out) {
//        System.out.println(out.packageField);
        System.out.println(out.protectedField);
    }

    public void printFields(Child4 out) {
//        System.out.println(out.packageField);
        System.out.println(out.protectedField);
    }
}