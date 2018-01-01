package com.epam.jf.guba.homework;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.epam.jf.common.homework.Task21.IMeasurement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class Task21Test {

    private Task21 task21 = new Task21();


    @Test
    void testEmptyList() {
        List<IMeasurement> measurements = new ArrayList<>();
        double expected = 0;
        double actual = task21.calcResistance(measurements);
        assertEquals(actual, expected);
    }

    @Test
    void testRegularList() {
        List<Task21.IMeasurement> measurements = Arrays.asList(
            new IMeasurement() {
                @Override
                public double getCurrent() {
                    return 1;
                }

                @Override
                public double getVoltage() {
                    return 2;
                }
            },
            new IMeasurement() {
                @Override
                public double getCurrent() {
                    return 2;
                }

                @Override
                public double getVoltage() {
                    return 4;
                }
            },
            new IMeasurement() {
                @Override
                public double getCurrent() {
                    return 3;
                }

                @Override
                public double getVoltage() {
                    return 6;
                }
            });

        double actual = task21.calcResistance(measurements);
        double expected = 2.0;
        assertEquals(expected, actual);
    }

}
