package com.epam.jf.khvan.homework;

import java.math.BigDecimal;
import java.util.List;

public class Task21Implement extends Task21 {
    @Override
    public double calcResistance(List<IMeasurement> measurements) {

        double result1 = 0;
        double result2 = 0;
        for (int i = 0; i < measurements.size(); i++) {
            result1 = result1 + ( measurements.get(i).getVoltage() * measurements.get(i).getCurrent());
            result2 = result2 +  measurements.get(i).getCurrent() * measurements.get(i).getCurrent();
        }
        BigDecimal resistance = new  BigDecimal(result1 / result2).setScale(6, BigDecimal.ROUND_HALF_DOWN);

        return  resistance.doubleValue();
    }


    public static class Measurement implements IMeasurement{
        private int current;
        private int voltage;

        public Measurement(int current, int voltage) {
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

