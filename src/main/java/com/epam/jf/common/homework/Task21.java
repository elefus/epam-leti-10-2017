package com.epam.jf.common.homework;

import java.util.List;

/**
 * Список содержит результаты измерений тока и напряжения на неизвестном сопротивлении R.
 * Найти приближенное число R методом наименьших квадратов.
 * Для повышения точности вычислений использовать класс {@link java.math.BigDecimal}
 * Гарантировать точность не менее 1e-6.
 */
public abstract class Task21 {

    /**
     * Вычисляет сопротивление методом наименьших квадратов.
     * @param measurements Измерения в ходе эксперимента.
     * @return Вычисленное по исходным данным сопротивление.
     */
    public abstract double calcResistance(List<IMeasurement> measurements);

    /** Измерение. */
    public interface IMeasurement {

        /** @return Измеренное значение тока. */
        double getCurrent();

        /** @return Измеренное значение напряжения. */
        double getVoltage();
    }
}
