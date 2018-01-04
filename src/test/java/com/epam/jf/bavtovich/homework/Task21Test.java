package com.epam.jf.bavtovich.homework;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

class Task21Test {
    @Test
    void calcResistance() {
        ArrayList<Task21.IMeasurement> list = new ArrayList<>();
        Task21.Measurment m1 = new Task21.Measurment(0.00976,1.0);
        list.add(m1);
        Task21.Measurment m2 = new Task21.Measurment(0.00975,1.0);
        list.add(m2);
        Task21.Measurment m3 = new Task21.Measurment(0.00977,1.0);
        list.add(m3);
        Task21.Measurment m4 = new Task21.Measurment(0.00974,1.0);
        list.add(m4);
        Task21.Measurment m5 = new Task21.Measurment(0.00972,1.0);
        list.add(m5);

        Task21 obj = new Task21();
        double result = obj.calcResistance(list);
        assertEquals(0, Double.compare(result, 102.5854650));
    }

}