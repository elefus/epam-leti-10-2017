package com.epam.jf.ilyinykh.homework;

import com.epam.jf.common.homework.Task21;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Task21DoneTest {

    @Test
    void calcResistance() {
        List<Task21.IMeasurement> measurements = Arrays.asList(new Measurement(1, 2),
                new Measurement(2, 4),
                new Measurement(3, 6));

        double v = new Task21Done().calcResistance(measurements);
        System.out.println(v);
        assertTrue(v - 0.5 < 0.0001);
    }
}