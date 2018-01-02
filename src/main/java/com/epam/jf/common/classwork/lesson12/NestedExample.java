package com.epam.jf.common.classwork.lesson12;

public class NestedExample {

    private int field = 100;

    static class J extends K {

        public J(NestedExample ref) {
            ref.super();
        }
    }

    class K {

    }
}
