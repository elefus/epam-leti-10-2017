package com.epam.jf.vasiliev.homework;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import com.epam.jf.vasiliev.homework.Task21.Measurement;
import com.epam.jf.common.homework.Task21.IMeasurement;

import static org.junit.jupiter.api.Assertions.*;

class Task21Test {
    Task21 ref = new Task21();

    @Test
    void firstTest() {
        List<IMeasurement> measurements = new ArrayList<>();
        measurements.add(new Measurement(1.150004, 2.000001));
        measurements.add(new Measurement(2.100001, 4.300002));
        measurements.add(new Measurement(4.400001, 8.350002));
        measurements.add(new Measurement(8.700301, 17.00403));
        measurements.add(new Measurement(0.500041, 1.050057));

        assertEquals( 1.945166, ref.calcResistance(measurements));
    }

    @Test
    void secondTest() {
        List<IMeasurement> measurements = new ArrayList<>();
        measurements.add(new Measurement(0.00976,1.0));
        measurements.add(new Measurement(0.00975,1.0));
        measurements.add(new Measurement(0.00977,1.0));
        measurements.add(new Measurement(0.00974,1.0));
        measurements.add(new Measurement(0.00972,1.0));

        assertEquals( 102.584826, ref.calcResistance(measurements));
    }

    @Test
    void thirdTest() {
        List<IMeasurement> measurements = new ArrayList<>();
        measurements.add(new Measurement(0.5, 5.0));
        measurements.add(new Measurement(0.2, 2.0));
        measurements.add(new Measurement(0.3, 3.0));
        measurements.add(new Measurement(0.1, 1.0));
        measurements.add(new Measurement(0.4, 4.0));

        assertEquals(  10.0, ref.calcResistance(measurements));

    }
}