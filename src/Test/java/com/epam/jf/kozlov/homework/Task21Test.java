package com.epam.jf.kozlov.homework;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Task21Test {

    @Test
    void calcResistanceTest() {
        ArrayList<com.epam.jf.common.homework.Task21.IMeasurement> list = new ArrayList<>();
        Task21.Measurement m1 = new Task21.Measurement(0.00976,1.0);
        list.add(m1);
        Task21.Measurement m2 = new Task21.Measurement(0.00975,1.0);
        list.add(m2);
        Task21.Measurement m3 = new Task21.Measurement(0.00977,1.0);
        list.add(m3);
        Task21.Measurement m4 = new Task21.Measurement(0.00974,1.0);
        list.add(m4);
        Task21.Measurement m5 = new Task21.Measurement(0.00972,1.0);
        list.add(m5);

        Task21 obj = new Task21();
        double result = obj.calcResistance(list);
        assertEquals(102.5854650, result);
    }

}