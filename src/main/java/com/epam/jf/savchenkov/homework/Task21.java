package com.epam.jf.savchenkov.homework;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Task21 {
    public double calcResistance(List<IMeasurement> measurements) {
        BigDecimal dividend = new BigDecimal(0.0);
        BigDecimal divider = new BigDecimal(0.0);

        BigDecimal current = null;
        BigDecimal voltage = null;

        for (IMeasurement meas : measurements) {
            current = new BigDecimal(meas.getCurrent());
            voltage = new BigDecimal(meas.getVoltage());
            dividend = dividend.add(current.multiply(voltage));
            divider = divider.add(current.pow(2));
        }

        return dividend.divide(divider, BigDecimal.ROUND_HALF_EVEN).doubleValue();
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

    /** Измерение. */
    public interface IMeasurement {

        /** @return Измеренное значение тока. */
        double getCurrent();

        /** @return Измеренное значение напряжения. */
        double getVoltage();
    }
}