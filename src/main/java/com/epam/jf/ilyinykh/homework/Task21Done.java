package com.epam.jf.ilyinykh.homework;

import com.epam.jf.common.homework.Task21;

import java.math.BigDecimal;
import java.util.List;

public class Task21Done extends Task21 {
    /**
     * Вычисляет сопротивление методом наименьших квадратов.
     *
     * @param measurements Измерения в ходе эксперимента.
     * @return Вычисленное по исходным данным сопротивление.
     */
    @Override
    public double calcResistance(List<IMeasurement> measurements) {
        BigDecimal voltageSum = new BigDecimal(0);
        BigDecimal currentSum = new BigDecimal(0);
        BigDecimal productsSum = new BigDecimal(0);
        BigDecimal currentSquareSum = new BigDecimal(0);
        int n = measurements.size();

        for (IMeasurement measurement : measurements) {
            voltageSum = voltageSum.add(BigDecimal.valueOf(measurement.getVoltage()));
            currentSum = currentSum.add(BigDecimal.valueOf(measurement.getCurrent()));
            currentSquareSum = currentSquareSum.add(BigDecimal.valueOf(measurement.getCurrent() * measurement.getCurrent()));
            productsSum = productsSum.add(BigDecimal.valueOf(measurement.getCurrent() * measurement.getVoltage()));
        }

        double voltageS = voltageSum.doubleValue();
        double currentS = currentSum.doubleValue();
        double currentSqrS = currentSquareSum.doubleValue();
        double productS = productsSum.doubleValue();
        return (n * productS - voltageS * currentS) / (n * currentSqrS - currentS * currentS);
    }
}

class Measurement implements Task21.IMeasurement {
    private double current;
    private double voltage;

    public Measurement(double current, double voltage) {
        this.current = current;
        this.voltage = voltage;
    }

    /**
     * @return Измеренное значение тока.
     */
    @Override
    public double getCurrent() {
        return voltage;
    }

    /**
     * @return Измеренное значение напряжения.
     */
    @Override
    public double getVoltage() {
        return current;
    }
}
