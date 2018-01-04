package com.epam.jf.bavtovich.homework;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * Список содержит результаты измерений тока и напряжения на неизвестном сопротивлении R.
 * Найти приближенное число R методом наименьших квадратов.
 * Для повышения точности вычислений использовать класс {@link java.math.BigDecimal}
 * Гарантировать точность не менее 1e-6.
 */
public class Task21 extends com.epam.jf.common.homework.Task21 {

    @Override
    public double calcResistance(List<IMeasurement> measurements) {
        BigDecimal summ = new BigDecimal("0");
        BigDecimal averResist;
        BigDecimal numOfMeasur = new BigDecimal(measurements.size());
        for (IMeasurement elem: measurements) {
            BigDecimal resistance = new BigDecimal(elem.getVoltage() / elem.getCurrent());
            summ = summ.add(resistance);
        }
        averResist = summ.divide(numOfMeasur, 6, RoundingMode.HALF_UP);
        return averResist.doubleValue();
    }

    static class Measurment implements IMeasurement {

        private double current;
        private double voltage;

        public Measurment(double current, double voltage) {
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
