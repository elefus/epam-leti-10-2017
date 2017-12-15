package com.epam.jf.common.classwork.lesson12;

public interface BaseStream<T, S extends BaseStream<T, S>> {

    S parallel();
    S sequential();
    S unordered();
}
