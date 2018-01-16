package com.epam.jf.yessenbayev.homework;

import java.math.BigDecimal;
import java.util.List;

public class Task21 extends com.epam.jf.common.homework.Task21 {

    @Override
    public double calcResistance(List<com.epam.jf.common.homework.Task21.IMeasurement> measurements) {
        if(measurements == null) {
            throw new IllegalArgumentException();
        }
        double r = 0;

        BigDecimal sU = new BigDecimal(0.);
        BigDecimal sI = new BigDecimal(0.);
        for(com.epam.jf.common.homework.Task21.IMeasurement measurement : measurements) {
            sU = sU.add(BigDecimal.valueOf(measurement.getVoltage()));
            sI = sI.add(BigDecimal.valueOf(measurement.getCurrent()));
        }
        return sU.divide(sI, 0).doubleValue();
    }

    public static class IMeasurement implements com.epam.jf.common.homework.Task21.IMeasurement {

        final double current;
        final double voltage;

        IMeasurement(double current, double voltage) {
            this.current = current;
            this.voltage = voltage;
        }

        @Override
        public double getCurrent() {
            return this.current;
        }

        @Override
        public double getVoltage() {
            return this.voltage;
        }
    }

}
