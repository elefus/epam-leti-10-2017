package com.epam.jf.zakomornyy.homework;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

public class Task21 extends com.epam.jf.common.homework.Task21{
    @Override
    public double calcResistance(List<IMeasurement> measurements) {
        BigDecimal sui = new BigDecimal(BigInteger.ZERO).setScale(6, RoundingMode.HALF_DOWN);
        BigDecimal sii = new BigDecimal(BigInteger.ZERO).setScale(6, RoundingMode.HALF_DOWN);

        for (IMeasurement measurement: measurements) {
            sui = sui.add(BigDecimal.valueOf(measurement.getVoltage()).multiply(BigDecimal.valueOf(measurement.getCurrent())));
            sii = sii.add(BigDecimal.valueOf(measurement.getCurrent()).multiply(BigDecimal.valueOf(measurement.getCurrent())));
        }
        try {
            return sui.divide(sii, RoundingMode.HALF_DOWN).doubleValue();
        }catch (ArithmeticException e) {
            switch (sui.compareTo(BigDecimal.valueOf(0))) {
                case -1:
                    return Double.NEGATIVE_INFINITY;
                case 1:
                    return Double.POSITIVE_INFINITY;
                default:
                    return Double.NaN;
            }

        }
    }

    public static class Measurement implements IMeasurement {

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
