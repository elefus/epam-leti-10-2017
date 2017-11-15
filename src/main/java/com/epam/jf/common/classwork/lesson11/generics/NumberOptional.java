package com.epam.jf.common.classwork.lesson11.generics;

import java.io.Serializable;

public class NumberOptional <T extends Number & Serializable> {

    private T value;

    public NumberOptional() {}

    public NumberOptional(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T val) {
        value = val;
    }

    public long getAsLong() {
        return value.longValue();
    }

    @Override
    public String toString() {
        if (value == null) return null;
        return value.getClass().getName() + " " + value;
    }
}
