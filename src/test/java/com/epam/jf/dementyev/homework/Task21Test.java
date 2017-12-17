package com.epam.jf.dementyev.homework;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.epam.jf.common.homework.Task21.IMeasurement;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class Task21Test {

    @Test
    void testCalcResistance1() {
        List<IMeasurement> l = new ArrayList<>(1);
        l.add(new IMeasurement() {
            @Override
            public double getCurrent() {
                return 2000;
            }

            @Override
            public double getVoltage() {
                return 0.002;
            }
        });

        double r = new Task21().calcResistance(l);
        assertEquals(1e-6, r, 1e-6);
    }

    @Test
    void testCalcResistance2() {
        List<IMeasurement> l = new ArrayList<>(1);
        l.add(new IMeasurement() {
            @Override
            public double getCurrent() {
                return 20000;
            }

            @Override
            public double getVoltage() {
                return 0.002;
            }
        });

        double r = new Task21().calcResistance(l);
        assertEquals(1e-7, r, 1e-6);
    }

    @Test
    void testCalcResistance3() {
        List<IMeasurement> l = new ArrayList<>(1);
        l.add(new IMeasurement() {
            @Override
            public double getCurrent() {
                return 50;
            }

            @Override
            public double getVoltage() {
                return 0.0003;
            }
        });

        double r = new Task21().calcResistance(l);
        assertEquals(6e-6, r, 1e-6);
    }

    @Test
    void testCalcResistance4() {
        List<IMeasurement> l = new ArrayList<>(1);
        l.add(new IMeasurement() {
            @Override
            public double getCurrent() {
                return 500;
            }

            @Override
            public double getVoltage() {
                return 0.0003;
            }
        });

        double r = new Task21().calcResistance(l);
        assertEquals(6e-7, r, 1e-6);
        assertTrue(Math.abs(6e-7 - r) > 1e-7);
    }
}