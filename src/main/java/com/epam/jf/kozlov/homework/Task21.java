package com.epam.jf.kozlov.homework;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * Список содержит результаты измерений тока и напряжения на неизвестном сопротивлении R.
 * Найти приближенное число R методом наименьших квадратов.
 * Для повышения точности вычислений использовать класс {@link java.math.BigDecimal}
 * Гарантировать точность не менее 1e-6.
 */
public class Task21 {

    /**
     * Вычисляет сопротивление методом наименьших квадратов.
     * @param measurements Измерения в ходе эксперимента.
     * @return Вычисленное по исходным данным сопротивление.
     */
    public double calcResistance(List<com.epam.jf.common.homework.Task21.IMeasurement> measurements) {
        BigDecimal resistance = new BigDecimal(0);
        for (com.epam.jf.common.homework.Task21.IMeasurement measurement: measurements) {
            resistance = resistance.add(new BigDecimal(measurement.getVoltage() / measurement.getCurrent()));
        }
        return resistance.divide(new BigDecimal(measurements.size()), 6, RoundingMode.HALF_UP).doubleValue();
    }

    /** Измерение. */
    static class Measurement implements com.epam.jf.common.homework.Task21.IMeasurement {

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
