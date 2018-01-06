package com.epam.jf.polovinkin.homework;

import java.util.List;

public class Task21 extends com.epam.jf.common.homework.Task21 {
    @Override
    public double calcResistance(List<IMeasurement> measurements) {
        if (measurements.size() == 0) return Double.NaN;
        double voltageCurrentProductSum = 0;
        double squaredCurrentSum = 0;

        for (IMeasurement measurement : measurements) {
            voltageCurrentProductSum += measurement.getVoltage() * measurement.getCurrent();
            squaredCurrentSum += measurement.getCurrent() * measurement.getCurrent();
        }


        return voltageCurrentProductSum / squaredCurrentSum;
    }

    static class Measurement implements IMeasurement {
        private double current;
        private double voltage;

        public Measurement(double current, double voltage) {
            this.current = current;
            this.voltage = voltage;
        }

        @Override
        public double getCurrent() {
            return current;
        }

        @Override
        public double getVoltage() {
            return voltage;
        }
    }
}
