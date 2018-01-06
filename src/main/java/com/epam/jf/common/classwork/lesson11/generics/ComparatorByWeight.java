package com.epam.jf.common.classwork.lesson11.generics;

import java.util.Comparator;

/**
 * Created by student on 13.11.2017.
 */
public class ComparatorByWeight implements Comparator<PhysicalObject> {
    @Override
    public int compare(PhysicalObject o1, PhysicalObject o2) {
        return Double.compare(o1.getWeight(), o2.getWeight());
    }
}
