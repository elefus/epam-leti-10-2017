package com.epam.jf.ilyassov.homework;


import com.epam.jf.common.homework.Task21;

public class IMeasurementImpl implements Task21.IMeasurement {
    private double Current;

    public IMeasurementImpl(double current, double voltage) {
        Current = current;
        Voltage = voltage;
    }

    private double Voltage;

    @Override
    public double getCurrent() {
        return Current;
    }

    @Override
    public double getVoltage() {
        return Voltage;
    }

    public void setCurrent(double current) {
        Current = current;
    }

    public void setVoltage(double voltage) {
        Voltage = voltage;
    }
}
