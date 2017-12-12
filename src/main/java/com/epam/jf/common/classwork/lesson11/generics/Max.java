package com.epam.jf.common.classwork.lesson11.generics;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Max {

    public static <T> T max(List<? extends T> list, Comparator<? super T> comparator) {
        return null;
    }

    public static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll) {
        return null;
    }
}
