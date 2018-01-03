package com.epam.jf.Shabashov.homework;

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
     *
     * @param measurements Измерения в ходе эксперимента.
     * @return Вычисленное по исходным данным сопротивление.
     */
    public double calcResistance(List<RealizationIMeasurement> measurements) {
        BigDecimal sumUI = BigDecimal.valueOf(0);
        BigDecimal sumI = BigDecimal.valueOf(0);
        for (IMeasurement list : measurements) {
            sumUI = sumUI.add(BigDecimal.valueOf(list.getCurrent()).multiply(BigDecimal.valueOf(list.getVoltage())));
            sumI = sumI.add(BigDecimal.valueOf(list.getCurrent()).pow(2));
        }
        return sumUI.divide(sumI).doubleValue();
    }

    /**
     * Измерение.
     */
    public interface IMeasurement {

        /**
         * @return Измеренное значение тока.
         */
        double getCurrent();

        /**
         * @return Измеренное значение напряжения.
         */
        double getVoltage();
    }
}

class RealizationIMeasurement implements Task21.IMeasurement {

    private final double current;
    private final double voltage;

    RealizationIMeasurement(double current, double voltage) {
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