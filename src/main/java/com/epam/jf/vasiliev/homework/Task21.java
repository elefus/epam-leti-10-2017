package com.epam.jf.vasiliev.homework;

import java.math.RoundingMode;
import java.util.List;
import java.math.BigDecimal;

/**
 * Список содержит результаты измерений тока и напряжения на неизвестном сопротивлении R.
 * Найти приближенное число R методом наименьших квадратов.
 * Для повышения точности вычислений использовать класс {@link java.math.BigDecimal}
 * Гарантировать точность не менее 1e-6.
 */
public class Task21 extends com.epam.jf.common.homework.Task21 {

    /**
     * Вычисляет сопротивление методом наименьших квадратов.
     * @param measurements Измерения в ходе эксперимента.
     * @return Вычисленное по исходным данным сопротивление.
     */
    @Override
    public double calcResistance(List<IMeasurement> measurements) {
        BigDecimal numeratorSum = BigDecimal.valueOf(0, 6);
        BigDecimal denominatorSum = BigDecimal.valueOf(0, 6);

        for (IMeasurement crt : measurements) {
            numeratorSum = numeratorSum.add(BigDecimal.valueOf(crt.getCurrent()).multiply(BigDecimal.valueOf(crt.getVoltage())));
            denominatorSum = denominatorSum.add(BigDecimal.valueOf(crt.getCurrent()).pow(2));
        }
        return numeratorSum.divide(denominatorSum, 6, RoundingMode.HALF_UP).doubleValue();
    }

    /** Измерение. */
    public static class Measurement implements IMeasurement {
        double current;
        double voltage;

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
