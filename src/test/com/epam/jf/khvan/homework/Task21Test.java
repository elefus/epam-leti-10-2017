package com.epam.jf.khvan.homework;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class Task21Test {
    private static  List<Task21.IMeasurement> measurements= new ArrayList();

    static {
        measurements.add(new Task21Implement.Measurement(21, 55));
        measurements.add(new Task21Implement.Measurement(11, 58));
        measurements.add(new Task21Implement.Measurement(41, 75));
    }

    @Test
    void testOne() {
        assertThat(new Task21Implement().calcResistance(measurements), is(2.170308));
    }


}
