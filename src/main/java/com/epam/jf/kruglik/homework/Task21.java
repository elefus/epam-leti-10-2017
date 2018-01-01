package com.epam.jf.kruglik.homework;

import java.math.BigDecimal;
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
    public double calcResistance(List<IMeasurement> measurements){
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

        return dividend.divide(divider, 6).doubleValue();
    }

    public static class Measurement implements IMeasurement{
        double current;
        double voltage;

        Measurement(Double current,Double voltage){
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