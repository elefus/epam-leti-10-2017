package com.epam.jf.burachenko.homework;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Task21Test {
    @Test
    void testCalcResistance() {
        List<com.epam.jf.common.homework.Task21.IMeasurement> list = new ArrayList<>();
        list.add(new Task21.IMeasurement(1.150004, 2.000001));
        list.add(new Task21.IMeasurement(2.100001, 4.300002));
        list.add(new Task21.IMeasurement(4.400001, 8.350002));
        list.add(new Task21.IMeasurement(8.700301, 17.00403));
        list.add(new Task21.IMeasurement(0.500041, 1.050057));
        double result = new Task21().calcResistance(list);
        System.out.println(result);
        assertEquals(result, 1.940856);
    }
}
