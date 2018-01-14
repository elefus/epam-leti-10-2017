package com.epam.jf.Shabashov.homework;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task21Test {
    private Task21 tt = new Task21();

    @Test
    void test1() {
        List<RealizationIMeasurement> list = new ArrayList<>();
        list.add(new RealizationIMeasurement(1.0, 2.0));
        list.add(new RealizationIMeasurement(2.0, 4.0));
        list.add(new RealizationIMeasurement(4.0, 8.0));
        list.add(new RealizationIMeasurement(8.0, 16.0));
        list.add(new RealizationIMeasurement(0.5, 1.0));
        assertEquals(tt.calcResistance(list), 2.0);
    }

    @Test
    void test2() {
        List<RealizationIMeasurement> list = new ArrayList<>();
        list.add(new RealizationIMeasurement(0.5, 5.0));
        list.add(new RealizationIMeasurement(0.2, 2.0));
        list.add(new RealizationIMeasurement(0.3, 3.0));
        list.add(new RealizationIMeasurement(0.1, 1.0));
        list.add(new RealizationIMeasurement(0.4, 4.0));
        assertEquals(tt.calcResistance(list), 10.0);
    }


}