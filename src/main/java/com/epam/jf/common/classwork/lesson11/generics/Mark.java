package com.epam.jf.common.classwork.lesson11.generics;

import java.util.Objects;

public class Mark<T extends Number> {
    public T mark;

    public Mark(T value) {
        mark = value;
    }

    public T getMark() {
        return mark;
    }

    public int roundMark() {
        return Math.round(mark.floatValue());
    }

    /* вместо */ // public boolean sameAny (Mark<T> ob) {
    public boolean sameAny(Mark<?> other) {
        return this.roundMark() == other.roundMark();
    }

    public boolean same(Mark<T> other) {
        return Objects.equals(getMark(), other.getMark());
    }
}

