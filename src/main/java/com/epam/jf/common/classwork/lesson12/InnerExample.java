package com.epam.jf.common.classwork.lesson12;

public class InnerExample {

    private int field = 200;

    class A {

//        private int field = 400;

        public int getField() {
            return InnerExample.this.field;
        }
    }

    class B extends A {

        private String val = "123";

        class C extends B implements MyInterface {

        }
    }

    public void setField(int field) {
        this.field = field;
    }
}

interface MyInterface {

}

class D extends InnerExample.A {

    private int fieldD = 42;

    public D(InnerExample obj) {
        obj.super();
    }

    public static void main(String[] args) {
        InnerExample ref = new InnerExample();
        ref.setField(300);
        D d = new D(ref);
        System.out.println(d.getField());

        ref.setField(400);
        System.out.println(d.getField());

        InnerExample innerExample = new InnerExample();
        InnerExample.B b = innerExample.new B();
    }

    private void test() {
        System.out.println(this.fieldD);

        class E {
            private int fieldE = 100;
            public int getFieldD() {
                return fieldD;
            }
        }

        E e = null;
        e.fieldE = 500;
        System.out.println(e.getFieldD());
    }
}

