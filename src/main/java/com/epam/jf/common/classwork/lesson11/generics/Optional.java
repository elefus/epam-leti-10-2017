package com.epam.jf.common.classwork.lesson11.generics;

public class Optional <T> {

    private T value;

    public Optional() {}

    public Optional(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T val) {
        value = val;
    }

    @Override
    public String toString() {
        if (value == null) return null;
        return value.getClass().getName() + " " + value;
    }
}

