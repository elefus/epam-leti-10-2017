package com.epam.jf.guba.homework;

import java.math.BigDecimal;
import java.util.List;

public class Task21 extends com.epam.jf.common.homework.Task21 {

    @Override
    public double calcResistance(List<IMeasurement> measurements) {
        if(measurements.isEmpty()){
            return 0;
        }
        BigDecimal vSum = new BigDecimal(0);
        BigDecimal cSum = new BigDecimal(0);
        BigDecimal resSum = new BigDecimal(0);
        BigDecimal cSqSum = new BigDecimal(0);

        for (IMeasurement measurement : measurements) {
            vSum = vSum.add(BigDecimal.valueOf(measurement.getVoltage()));
            cSum = cSum.add(BigDecimal.valueOf(measurement.getCurrent()));
            cSqSum = cSqSum.add(BigDecimal.valueOf(measurement.getCurrent() * measurement.getCurrent()));
            resSum = resSum.add(BigDecimal.valueOf(measurement.getCurrent() * measurement.getVoltage()));
        }

        double totalVoltage = vSum.doubleValue();
        double totalCurrent = cSum.doubleValue();
        double totalCurrentSq = cSqSum.doubleValue();
        double totalRes = resSum.doubleValue();
        return (measurements.size() * totalRes - totalVoltage * totalCurrent) / (measurements.size() * totalCurrentSq - totalCurrent * totalCurrent);
    }

}

