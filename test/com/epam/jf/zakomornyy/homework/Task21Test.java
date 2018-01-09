package com.epam.jf.zakomornyy.homework;

import com.epam.jf.common.homework.Task21.IMeasurement;
import com.epam.jf.zakomornyy.homework.Task21.Measurement;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class Task21Test {
    @Test
    void calcResistance() {
        List<IMeasurement> measurements = new ArrayList<>();
        measurements.add(new Measurement(0.52, 3.00));
        measurements.add(new Measurement(0.12, 2.02));
        measurements.add(new Measurement(0.35, 1.05));
        measurements.add(new Measurement(0.32, 1.2));
        measurements.add(new Measurement(0.13, 2.43));
        assertEquals(5.449677, new Task21().calcResistance(measurements));
    }

    @Test
    void calcResistance1() {
        List<IMeasurement> measurements = new ArrayList<>();
        measurements.add(new Measurement(0, 3.00));
        measurements.add(new Measurement(0, 2.02));
        measurements.add(new Measurement(0, 1.05));
        measurements.add(new Measurement(0, 1.2));
        measurements.add(new Measurement(0, 2.43));
        assertEquals(Double.NaN, new Task21().calcResistance(measurements));
    }
}
