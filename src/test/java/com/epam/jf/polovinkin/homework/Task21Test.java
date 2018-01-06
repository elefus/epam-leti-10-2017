package com.epam.jf.polovinkin.homework;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Task21Test {
    @Test
    void test1() {
        List<com.epam.jf.common.homework.Task21.IMeasurement> list = new ArrayList<>();
        list.add(new Task21.Measurement(1.0, 2.0));
        list.add(new Task21.Measurement(2.0, 4.0));
        list.add(new Task21.Measurement(4.0, 8.0));
        list.add(new Task21.Measurement(8.0, 16.0));
        list.add(new Task21.Measurement(0.5, 1.0));
        assertEquals(2.0, new Task21().calcResistance(list));
    }

    @Test
    void test2() {
        List<com.epam.jf.common.homework.Task21.IMeasurement> list = new ArrayList<>();
        list.add(new Task21.Measurement(0.5, 5.0));
        list.add(new Task21.Measurement(0.2, 2.0));
        list.add(new Task21.Measurement(0.3, 3.0));
        list.add(new Task21.Measurement(0.1, 1.0));
        list.add(new Task21.Measurement(0.4, 4.0));
        assertEquals(10.0, new Task21().calcResistance(list));
    }
}