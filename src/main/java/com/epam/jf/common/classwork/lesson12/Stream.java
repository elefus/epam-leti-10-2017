package com.epam.jf.common.classwork.lesson12;

public interface Stream<T> extends BaseStream<T, Stream<T>> {

    Stream<T> sorted();
    Stream<T> ordered();
}


class StreamLauncher {

    public static void main(String[] args) {
        Stream<Integer> stream = null;
        stream.sorted().ordered().parallel().sorted().ordered().unordered();
    }
}